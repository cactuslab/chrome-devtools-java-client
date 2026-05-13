package com.github.kklisura.cdt.services.impl;

/*-
 * #%L
 * cdt-java-client
 * %%
 * Copyright (C) 2018 - 2026 Kenan Klisura
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kklisura.cdt.protocol.support.types.EventHandler;
import com.github.kklisura.cdt.protocol.support.types.EventListener;
import com.github.kklisura.cdt.services.WebSocketService;
import com.github.kklisura.cdt.services.config.ChromeDevToolsServiceConfiguration;
import com.github.kklisura.cdt.services.exceptions.ChromeDevToolsInvocationException;
import com.github.kklisura.cdt.services.exceptions.WebSocketServiceException;
import com.github.kklisura.cdt.services.executors.EventExecutorService;
import com.github.kklisura.cdt.services.types.ChromeTab;
import com.github.kklisura.cdt.services.types.EventListenerImpl;
import com.github.kklisura.cdt.services.types.MethodInvocation;
import com.github.kklisura.cdt.services.utils.ProxyUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

/**
 * Created by Kenan Klisura on 21/01/2018.
 *
 * @author Kenan Klisura
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ChromeDevToolsServiceImplTest {
  private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

  @Mock private WebSocketService webSocketService;

  @Mock private EventExecutorService eventExecutorService;

  private final ImmediateEventExecutorService immediateEventExecutorService =
      new ImmediateEventExecutorService();

  private ChromeDevToolsServiceImpl service;

  @BeforeEach
  public void setUp() {
    ChromeDevToolsServiceConfiguration configuration = new ChromeDevToolsServiceConfiguration();
    configuration.setEventExecutorService(eventExecutorService);

    service =
        ProxyUtils.createProxyFromAbstract(
            ChromeDevToolsServiceImpl.class,
            new Class[] {WebSocketService.class, ChromeDevToolsServiceConfiguration.class},
            new Object[] {webSocketService, configuration},
            (proxy, method, args) -> {
              throw new RuntimeException("This should not be called during testing");
            });
  }

  @Test
  public void testAcceptWithUnknownInvocation() {
    resolveMessage("{\"id\":1,\"result\":{}}");
  }

  @Test
  public void testAcceptWithUnknownInvocation2() {
    resolveMessage("{\"id\":1}");
  }

  @Test
  public void testInvokeVoidMethodThrowsWebSocketException()
      throws IOException, WebSocketServiceException {
    MethodInvocation methodInvocation = newMethodInvocation();

    WebSocketServiceException webSocketServiceException =
        new WebSocketServiceException("WS Failed");

    doThrow(webSocketServiceException).when(webSocketService).send(any());

    ChromeDevToolsInvocationException capturedException =
        assertThrows(
            ChromeDevToolsInvocationException.class,
            () -> service.invoke(null, Void.TYPE, null, methodInvocation));

    assertEquals("Failed sending web socket message.", capturedException.getMessage());
    assertEquals(webSocketServiceException, capturedException.getCause());

    ArgumentCaptor<String> messageCapture = ArgumentCaptor.forClass(String.class);
    verify(webSocketService).send(messageCapture.capture());

    MethodInvocation sentInvocation =
        OBJECT_MAPPER.readerFor(MethodInvocation.class).readValue(messageCapture.getValue());
    assertEquals(methodInvocation.getId(), sentInvocation.getId());
    assertEquals(methodInvocation.getMethod(), sentInvocation.getMethod());
  }

  @Test
  public void testInvokeVoidMethodInterruptsWaiting()
      throws IOException, WebSocketServiceException {
    MethodInvocation methodInvocation = newMethodInvocation();

    final Thread currentThread = Thread.currentThread();
    new Thread(
            () -> {
              try {
                Thread.sleep(1000);
                currentThread.interrupt();
              } catch (InterruptedException e) {
                // We can ignore this
              }
            })
        .start();

    ChromeDevToolsInvocationException capturedException =
        assertThrows(
            ChromeDevToolsInvocationException.class,
            () -> service.invoke(null, Void.TYPE, null, methodInvocation));

    assertEquals("Interrupted while waiting response.", capturedException.getMessage());
    assertTrue(capturedException.getCause() instanceof InterruptedException);

    ArgumentCaptor<String> messageCapture = ArgumentCaptor.forClass(String.class);
    verify(webSocketService).send(messageCapture.capture());

    MethodInvocation sentInvocation =
        OBJECT_MAPPER.readerFor(MethodInvocation.class).readValue(messageCapture.getValue());
    assertEquals(methodInvocation.getId(), sentInvocation.getId());
    assertEquals(methodInvocation.getMethod(), sentInvocation.getMethod());
  }

  @Test
  public void testInvokeVoidMethod() throws WebSocketServiceException, IOException {
    MethodInvocation methodInvocation = newMethodInvocation();

    resolveMessage("{\"id\":1,\"result\":{}}");
    assertNull(service.invoke(null, Void.TYPE, null, methodInvocation));

    ArgumentCaptor<String> messageCapture = ArgumentCaptor.forClass(String.class);
    verify(webSocketService).send(messageCapture.capture());

    MethodInvocation sentInvocation =
        OBJECT_MAPPER.readerFor(MethodInvocation.class).readValue(messageCapture.getValue());
    assertEquals(methodInvocation.getId(), sentInvocation.getId());
    assertEquals(methodInvocation.getMethod(), sentInvocation.getMethod());
    assertEquals(methodInvocation.getParams(), sentInvocation.getParams());
  }

  @Test
  public void testInvokeStringMethod() throws WebSocketServiceException, IOException {
    MethodInvocation methodInvocation = newMethodInvocation();

    resolveMessage("{\"id\":1,\"result\":{\"resultProperty\":\"resultValue\"}}");
    assertEquals(
        "resultValue", service.invoke("resultProperty", String.class, null, methodInvocation));

    ArgumentCaptor<String> messageCapture = ArgumentCaptor.forClass(String.class);
    verify(webSocketService).send(messageCapture.capture());

    MethodInvocation sentInvocation =
        OBJECT_MAPPER.readerFor(MethodInvocation.class).readValue(messageCapture.getValue());
    assertEquals(methodInvocation.getId(), sentInvocation.getId());
    assertEquals(methodInvocation.getMethod(), sentInvocation.getMethod());
    assertEquals(methodInvocation.getParams(), sentInvocation.getParams());
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testInvokeMethodReturningListOfComplexObjects()
      throws WebSocketServiceException, IOException {
    MethodInvocation methodInvocation = newMethodInvocation();

    resolveMessage("{\"id\":1,\"result\":[{\"testProperty\":\"1\"},{\"testProperty\":\"2\"}]}");

    List<TestMessage> result =
        (List<TestMessage>)
            service.invoke(null, List.class, new Class[] {TestMessage.class}, methodInvocation);

    assertNotNull(result);
    assertEquals(2, result.size());
    assertNotNull(result.get(0));
    assertNotNull(result.get(1));
    assertEquals("1", result.get(0).getTestProperty());
    assertEquals("2", result.get(1).getTestProperty());

    ArgumentCaptor<String> messageCapture = ArgumentCaptor.forClass(String.class);
    verify(webSocketService).send(messageCapture.capture());

    MethodInvocation sentInvocation =
        OBJECT_MAPPER.readerFor(MethodInvocation.class).readValue(messageCapture.getValue());
    assertEquals(methodInvocation.getId(), sentInvocation.getId());
    assertEquals(methodInvocation.getMethod(), sentInvocation.getMethod());
    assertEquals(methodInvocation.getParams(), sentInvocation.getParams());
  }

  @Test
  @SuppressWarnings("unchecked")
  public void testInvokeMethodReturningListOfComplexObjects2()
      throws WebSocketServiceException, IOException {
    MethodInvocation methodInvocation = newMethodInvocation();

    resolveMessage("{\"id\":1,\"result\":[[{\"testProperty\":\"1\"},{\"testProperty\":\"2\"}]]}");

    List<List<TestMessage>> resultWrapper =
        (List<List<TestMessage>>)
            service.invoke(
                null, List.class, new Class[] {List.class, TestMessage.class}, methodInvocation);

    assertNotNull(resultWrapper);
    assertEquals(1, resultWrapper.size());

    List<TestMessage> result = resultWrapper.get(0);

    assertNotNull(result);
    assertEquals(2, result.size());
    assertNotNull(result.get(0));
    assertNotNull(result.get(1));
    assertEquals("1", result.get(0).getTestProperty());
    assertEquals("2", result.get(1).getTestProperty());

    ArgumentCaptor<String> messageCapture = ArgumentCaptor.forClass(String.class);
    verify(webSocketService).send(messageCapture.capture());

    MethodInvocation sentInvocation =
        OBJECT_MAPPER.readerFor(MethodInvocation.class).readValue(messageCapture.getValue());
    assertEquals(methodInvocation.getId(), sentInvocation.getId());
    assertEquals(methodInvocation.getMethod(), sentInvocation.getMethod());
    assertEquals(methodInvocation.getParams(), sentInvocation.getParams());
  }

  @Test
  public void testInvokeStringMethodWithNullResult() {
    MethodInvocation methodInvocation = newMethodInvocation();

    resolveMessage("{\"id\":1}");
    assertThrows(
        ChromeDevToolsInvocationException.class,
        () -> service.invoke("resultProperty", String.class, null, methodInvocation));
  }

  @Test
  public void testInvokeTestMessageMethod() throws WebSocketServiceException, IOException {
    MethodInvocation methodInvocation = newMethodInvocation();

    resolveMessage(
        "{\"id\":1,\"result\":{\"testProperty\":\"resultValue\",\"testProperty2\":\"resultValue2\"}}");
    TestMessage testMessage = service.invoke(null, TestMessage.class, null, methodInvocation);

    assertEquals("resultValue", testMessage.getTestProperty());
    assertEquals("resultValue2", testMessage.getTestProperty2());

    ArgumentCaptor<String> messageCapture = ArgumentCaptor.forClass(String.class);
    verify(webSocketService).send(messageCapture.capture());

    MethodInvocation sentInvocation =
        OBJECT_MAPPER.readerFor(MethodInvocation.class).readValue(messageCapture.getValue());
    assertEquals(methodInvocation.getId(), sentInvocation.getId());
    assertEquals(methodInvocation.getMethod(), sentInvocation.getMethod());
    assertEquals(methodInvocation.getParams(), sentInvocation.getParams());
  }

  @Test
  public void testInvokeTestMessageMethodWithUnknownProperty()
      throws WebSocketServiceException, IOException {
    MethodInvocation methodInvocation = newMethodInvocation();

    resolveMessage(
        "{\"id\":1,\"result\":{\"testProperty\":\"resultValue\",\"testProperty2\":\"resultValue2\",\"unknownProperty\":false}}");
    TestMessage testMessage = service.invoke(null, TestMessage.class, null, methodInvocation);

    assertEquals("resultValue", testMessage.getTestProperty());
    assertEquals("resultValue2", testMessage.getTestProperty2());

    ArgumentCaptor<String> messageCapture = ArgumentCaptor.forClass(String.class);
    verify(webSocketService).send(messageCapture.capture());

    MethodInvocation sentInvocation =
        OBJECT_MAPPER.readerFor(MethodInvocation.class).readValue(messageCapture.getValue());
    assertEquals(methodInvocation.getId(), sentInvocation.getId());
    assertEquals(methodInvocation.getMethod(), sentInvocation.getMethod());
    assertEquals(methodInvocation.getParams(), sentInvocation.getParams());
  }

  @Test
  public void testInvokeTestMessageMethodWithBadJson()
      throws IOException, WebSocketServiceException {
    ChromeDevToolsServiceConfiguration configuration = new ChromeDevToolsServiceConfiguration();
    configuration.setReadTimeout(1);

    service =
        ProxyUtils.createProxyFromAbstract(
            ChromeDevToolsServiceImpl.class,
            new Class[] {WebSocketService.class, ChromeDevToolsServiceConfiguration.class},
            new Object[] {webSocketService, configuration},
            (proxy, method, args) -> {
              throw new RuntimeException("This should not be called during testing");
            });

    MethodInvocation methodInvocation = newMethodInvocation();

    resolveMessage(
        "{\"id\":1,\"result\":{\"testProperty\":\"resultValue\",\"testProperty2\"-\"resultValue2\"}}");

    ChromeDevToolsInvocationException capturedException =
        assertThrows(
            ChromeDevToolsInvocationException.class,
            () -> service.invoke(null, Void.TYPE, null, methodInvocation));

    assertEquals(
        "Timeout expired while waiting for server response.", capturedException.getMessage());

    ArgumentCaptor<String> messageCapture = ArgumentCaptor.forClass(String.class);
    verify(webSocketService).send(messageCapture.capture());

    MethodInvocation sentInvocation =
        OBJECT_MAPPER.readerFor(MethodInvocation.class).readValue(messageCapture.getValue());
    assertEquals(methodInvocation.getId(), sentInvocation.getId());
    assertEquals(methodInvocation.getMethod(), sentInvocation.getMethod());
  }

  @Test
  public void testInvokeVoidMethodWithError() {
    MethodInvocation methodInvocation = newMethodInvocation();

    resolveMessage(
        "{\"id\":1,\"error\":{\"code\":1,\"message\":\"Error message for id 1\",\"data\": \"Test data\"}}");

    ChromeDevToolsInvocationException capturedException =
        assertThrows(
            ChromeDevToolsInvocationException.class,
            () -> service.invoke(null, Void.TYPE, null, methodInvocation));

    assertEquals(1, (long) capturedException.getCode());
    assertEquals("Error message for id 1: Test data", capturedException.getMessage());
  }

  @Test
  public void testInvokeVoidMethodWithErrorNoTestData() {
    MethodInvocation methodInvocation = newMethodInvocation();

    resolveMessage("{\"id\":1,\"error\":{\"code\":1,\"message\":\"Error message for id 1\"}}");

    ChromeDevToolsInvocationException capturedException =
        assertThrows(
            ChromeDevToolsInvocationException.class,
            () -> service.invoke(null, Void.TYPE, null, methodInvocation));

    assertEquals(1, (long) capturedException.getCode());
    assertEquals("Error message for id 1", capturedException.getMessage());
  }

  @Test
  public void testClose() {
    service.close();
    service.close(); // Already closed - should do nothing on second call.

    verify(webSocketService).close();
    verify(eventExecutorService).shutdown();
  }

  @Test
  public void testCloseRemovesDevToolsServiceCache() {
    ChromeTab chromeTab = new ChromeTab();

    ChromeServiceImpl chromeService = mock(ChromeServiceImpl.class);
    service.setChromeService(chromeService);
    service.setChromeTab(chromeTab);

    service.close();

    verify(chromeService).clearChromeDevToolsServiceCache(chromeTab);
    verify(webSocketService).close();
    verify(eventExecutorService).shutdown();
  }

  @Test
  public void testAddEventListener() {
    EventHandler<String> eventHandler = event -> {};

    EventListener eventListener =
        service.addEventListener("domain", "event", eventHandler, String.class);
    assertNotNull(eventListener);

    assertEquals(eventHandler, ((EventListenerImpl) eventListener).getHandler());
    assertEquals("domain.event", ((EventListenerImpl) eventListener).getKey());
    assertEquals(String.class, ((EventListenerImpl) eventListener).getParamType());

    service.removeEventListener(eventListener);
  }

  @Test
  public void testEventReceivedWithOff() {
    // Non existing event handler
    service.accept("{\"method\":\"Domain.name\",\"params\":{\"testProperty\":\"testValue\"}}");

    final TestMessage[] capturedMessage = new TestMessage[1];
    EventHandler<TestMessage> eventHandler = msg -> capturedMessage[0] = msg;

    EventListener eventListener =
        service.addEventListener("Domain", "name", eventHandler, TestMessage.class);

    expectEventExecutorCall();

    service.accept("{\"method\":\"Domain.name\",\"params\":{\"testProperty\":\"testValue\"}}");

    assertNotNull(capturedMessage[0]);
    assertEquals("testValue", capturedMessage[0].getTestProperty());

    capturedMessage[0] = null;

    eventListener.off();

    service.accept("{\"method\":\"Domain.name\",\"params\":{\"testProperty\":\"testValue\"}}");

    assertNull(capturedMessage[0]);
  }

  @Test
  public void testEventReceivedWithUnsubscribe() {
    // Non existing event handler
    service.accept("{\"method\":\"Domain.name\",\"params\":{\"testProperty\":\"testValue\"}}");

    final TestMessage[] capturedMessage = new TestMessage[1];
    EventHandler<TestMessage> eventHandler = msg -> capturedMessage[0] = msg;

    EventListener eventListener =
        service.addEventListener("Domain", "name", eventHandler, TestMessage.class);

    expectEventExecutorCall();

    service.accept("{\"method\":\"Domain.name\",\"params\":{\"testProperty\":\"testValue\"}}");

    assertNotNull(capturedMessage[0]);
    assertEquals("testValue", capturedMessage[0].getTestProperty());

    capturedMessage[0] = null;

    eventListener.unsubscribe();

    service.accept("{\"method\":\"Domain.name\",\"params\":{\"testProperty\":\"testValue\"}}");

    assertNull(capturedMessage[0]);
  }

  @Test
  public void testEventReceivedWithUnsubscribeOnService() {
    // Non existing event handler
    service.accept("{\"method\":\"Domain.name\",\"params\":{\"testProperty\":\"testValue\"}}");

    final TestMessage[] capturedMessage = new TestMessage[1];
    EventHandler<TestMessage> eventHandler = msg -> capturedMessage[0] = msg;

    EventListener eventListener =
        service.addEventListener("Domain", "name", eventHandler, TestMessage.class);

    expectEventExecutorCall();

    service.accept("{\"method\":\"Domain.name\",\"params\":{\"testProperty\":\"testValue\"}}");

    assertNotNull(capturedMessage[0]);
    assertEquals("testValue", capturedMessage[0].getTestProperty());

    service.removeEventListener(eventListener);

    capturedMessage[0] = null;

    service.accept("{\"method\":\"Domain.name\",\"params\":{\"testProperty\":\"testValue\"}}");

    assertNull(capturedMessage[0]);
  }

  @Test
  public void testEventReceivedHandlerThrowsException() {
    // Non existing event handler
    service.accept("{\"method\":\"Domain.name\",\"params\":{\"testProperty\":\"testValue\"}}");

    final TestMessage[] capturedMessage = new TestMessage[1];

    EventHandler<TestMessage> eventHandlerThrowsException =
        event -> {
          throw new RuntimeException("test");
        };
    EventListener eventListenerWithException =
        service.addEventListener("Domain", "name", eventHandlerThrowsException, TestMessage.class);

    EventHandler<TestMessage> eventHandler = msg -> capturedMessage[0] = msg;
    service.addEventListener("Domain", "name", eventHandler, TestMessage.class);

    expectEventExecutorCall();

    service.accept("{\"method\":\"Domain.name\",\"params\":{\"testProperty\":\"testValue\"}}");

    assertNotNull(capturedMessage[0]);
    assertEquals("testValue", capturedMessage[0].getTestProperty());

    service.removeEventListener(eventListenerWithException);

    capturedMessage[0] = null;

    service.accept("{\"method\":\"Domain.name\",\"params\":{\"testProperty\":\"testValue\"}}");

    assertNotNull(capturedMessage[0]);
    assertEquals("testValue", capturedMessage[0].getTestProperty());
  }

  private MethodInvocation newMethodInvocation() {
    MethodInvocation methodInvocation = new MethodInvocation();
    methodInvocation.setId(1L);
    methodInvocation.setMethod("SomeMethod");
    methodInvocation.setParams(new HashMap<>());
    methodInvocation.getParams().put("param", "value");
    return methodInvocation;
  }

  private void resolveMessage(String message) {
    new Thread(
            () -> {
              try {
                Thread.sleep(500);
                service.accept(message);
              } catch (InterruptedException e) {
                // We can ignore this
              }
            })
        .start();
  }

  private void expectEventExecutorCall() {
    doAnswer(
            invocation -> {
              immediateEventExecutorService.execute(invocation.getArgument(0));
              return null;
            })
        .when(eventExecutorService)
        .execute(any());
  }

  // Suppress unused warnings: assertions verify invocation behavior, keeping reference for clarity.
  @SuppressWarnings("unused")
  private static void verifyExecuteInvoked(EventExecutorService executor, int times) {
    verify(executor, times(times)).execute(any());
  }

  public static class TestMessage {
    private String testProperty;
    private String testProperty2;

    public String getTestProperty() {
      return testProperty;
    }

    public void setTestProperty(String testProperty) {
      this.testProperty = testProperty;
    }

    public String getTestProperty2() {
      return testProperty2;
    }

    public void setTestProperty2(String testProperty2) {
      this.testProperty2 = testProperty2;
    }
  }

  public static class ImmediateEventExecutorService implements EventExecutorService {
    @Override
    public void execute(Runnable runnable) {
      runnable.run();
    }

    @Override
    public void shutdown() {
      throw new RuntimeException("test");
    }
  }
}
