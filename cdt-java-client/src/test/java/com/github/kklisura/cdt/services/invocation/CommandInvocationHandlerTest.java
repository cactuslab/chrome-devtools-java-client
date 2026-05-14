package com.github.kklisura.cdt.services.invocation;

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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.AdditionalMatchers.aryEq;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.github.kklisura.cdt.protocol.support.annotations.EventName;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;
import com.github.kklisura.cdt.protocol.support.annotations.ParamObject;
import com.github.kklisura.cdt.protocol.support.annotations.ReturnTypeParameter;
import com.github.kklisura.cdt.protocol.support.annotations.Returns;
import com.github.kklisura.cdt.protocol.support.types.EventHandler;
import com.github.kklisura.cdt.protocol.support.types.EventListener;
import com.github.kklisura.cdt.services.ChromeDevToolsService;
import com.github.kklisura.cdt.services.types.MethodInvocation;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Command invocation handler test.
 *
 * @author Kenan Klisura
 */
@ExtendWith(MockitoExtension.class)
public class CommandInvocationHandlerTest {

  @Mock private ChromeDevToolsService chromeDevToolsService;

  private CommandInvocationHandler invocationHandler;

  @BeforeEach
  public void setUp() {
    invocationHandler = new CommandInvocationHandler();
    invocationHandler.setChromeDevToolsService(chromeDevToolsService);
  }

  @Test
  public void testInvokeVoidMethod() throws Throwable {
    assertNull(invocationHandler.invoke(this, getMethodByName("voidMethod"), null));

    ArgumentCaptor<MethodInvocation> methodInvocationCapture =
        ArgumentCaptor.forClass(MethodInvocation.class);
    verify(chromeDevToolsService)
        .invoke(isNull(), eq(Void.TYPE), isNull(), methodInvocationCapture.capture());

    MethodInvocation methodInvocation = methodInvocationCapture.getValue();
    assertNotNull(methodInvocation.getId());
    assertEquals("CommandInvocationHandlerTest.voidMethod", methodInvocation.getMethod());
    assertTrue(methodInvocation.getParams().isEmpty());

    reset(chromeDevToolsService);

    assertNull(invocationHandler.invoke(this, getMethodByName("voidMethod"), new Object[] {}));

    methodInvocationCapture = ArgumentCaptor.forClass(MethodInvocation.class);
    verify(chromeDevToolsService)
        .invoke(isNull(), eq(Void.TYPE), isNull(), methodInvocationCapture.capture());

    methodInvocation = methodInvocationCapture.getValue();
    assertNotNull(methodInvocation.getId());
    assertEquals("CommandInvocationHandlerTest.voidMethod", methodInvocation.getMethod());
    assertTrue(methodInvocation.getParams().isEmpty());
  }

  @Test
  public void testInvokeStringMethodWithParams() throws Throwable {
    assertNull(
        invocationHandler.invoke(
            this, getMethodByName("stringMethodWithParams"), new Object[] {"Test", 1}));

    ArgumentCaptor<MethodInvocation> methodInvocationCapture =
        ArgumentCaptor.forClass(MethodInvocation.class);
    verify(chromeDevToolsService)
        .invoke(isNull(), eq(String.class), isNull(), methodInvocationCapture.capture());

    MethodInvocation methodInvocation = methodInvocationCapture.getValue();
    assertNotNull(methodInvocation.getId());
    assertEquals(
        "CommandInvocationHandlerTest.stringMethodWithParams", methodInvocation.getMethod());
    assertFalse(methodInvocation.getParams().isEmpty());

    assertEquals("Test", methodInvocation.getParams().get("paramTest"));
    assertEquals(1, (int) methodInvocation.getParams().get("paramTest1"));
  }

  @Test
  public void testInvokeStringMethodWithParamsAndReturnsAnnotation() throws Throwable {
    assertNull(
        invocationHandler.invoke(
            this,
            getMethodByName("stringMethodWithParamsAndAnnotation"),
            new Object[] {"Test", 1}));

    ArgumentCaptor<MethodInvocation> methodInvocationCapture =
        ArgumentCaptor.forClass(MethodInvocation.class);
    verify(chromeDevToolsService)
        .invoke(eq("ReturnsValue"), eq(String.class), isNull(), methodInvocationCapture.capture());

    MethodInvocation methodInvocation = methodInvocationCapture.getValue();
    assertNotNull(methodInvocation.getId());
    assertEquals(
        "CommandInvocationHandlerTest.stringMethodWithParamsAndAnnotation",
        methodInvocation.getMethod());
    assertFalse(methodInvocation.getParams().isEmpty());

    assertEquals("Test", methodInvocation.getParams().get("paramTest"));
    assertEquals(1, (int) methodInvocation.getParams().get("paramTest1"));
  }

  @Test
  public void testInvokeStringMethodWithParamsAndReturnTypeAnnotation() throws Throwable {
    assertNull(
        invocationHandler.invoke(
            this,
            getMethodByName("stringMethodWithParamsAndReturnTypeAnnotation"),
            new Object[] {"Test", 1}));

    ArgumentCaptor<MethodInvocation> methodInvocationCapture =
        ArgumentCaptor.forClass(MethodInvocation.class);
    verify(chromeDevToolsService)
        .invoke(
            eq("ReturnsValue"),
            eq(List.class),
            aryEq(new Class[] {String.class}),
            methodInvocationCapture.capture());

    MethodInvocation methodInvocation = methodInvocationCapture.getValue();
    assertNotNull(methodInvocation.getId());
    assertEquals(
        "CommandInvocationHandlerTest.stringMethodWithParamsAndReturnTypeAnnotation",
        methodInvocation.getMethod());
    assertFalse(methodInvocation.getParams().isEmpty());

    assertEquals("Test", methodInvocation.getParams().get("paramTest"));
    assertEquals(1, (int) methodInvocation.getParams().get("paramTest1"));
  }

  @Test
  public void testInvokeMethodWithParamObject() throws Throwable {
    TestParameters parameters = new TestParameters().setParamTest("Test").setParamTest1(1);

    assertNull(
        invocationHandler.invoke(
            this, getMethodByName("methodWithParamObject"), new Object[] {parameters}));

    ArgumentCaptor<MethodInvocation> methodInvocationCapture =
        ArgumentCaptor.forClass(MethodInvocation.class);
    verify(chromeDevToolsService)
        .invoke(isNull(), eq(String.class), isNull(), methodInvocationCapture.capture());

    MethodInvocation methodInvocation = methodInvocationCapture.getValue();
    assertNotNull(methodInvocation.getId());
    assertEquals(
        "CommandInvocationHandlerTest.methodWithParamObject", methodInvocation.getMethod());
    assertEquals("Test", methodInvocation.getParams().get("paramTest"));
    assertEquals(1, (int) methodInvocation.getParams().get("paramTest1"));
  }

  @Test
  public void testInvokeMethodWithParamObjectSkipsNullFields() throws Throwable {
    TestParameters parameters = new TestParameters().setParamTest("Test");

    assertNull(
        invocationHandler.invoke(
            this, getMethodByName("methodWithParamObject"), new Object[] {parameters}));

    ArgumentCaptor<MethodInvocation> methodInvocationCapture =
        ArgumentCaptor.forClass(MethodInvocation.class);
    verify(chromeDevToolsService)
        .invoke(isNull(), eq(String.class), isNull(), methodInvocationCapture.capture());

    MethodInvocation methodInvocation = methodInvocationCapture.getValue();
    assertEquals("Test", methodInvocation.getParams().get("paramTest"));
    assertFalse(methodInvocation.getParams().containsKey("paramTest1"));
  }

  @Test
  public void testIsEventSubscription() {
    assertFalse(CommandInvocationHandler.isEventSubscription(getMethodByName("voidMethod")));
    assertFalse(
        CommandInvocationHandler.isEventSubscription(getMethodByName("stringMethodWithParams")));

    assertFalse(
        CommandInvocationHandler.isEventSubscription(getMethodByName("onEventListenerTestMethod")));
    assertFalse(
        CommandInvocationHandler.isEventSubscription(
            getMethodByName("onEventListenerTestMethod1")));
    assertFalse(
        CommandInvocationHandler.isEventSubscription(
            getMethodByName("onEventListenerTestMethod2")));
    assertFalse(
        CommandInvocationHandler.isEventSubscription(
            getMethodByName("onEventListenerTestMethod3")));
    assertTrue(
        CommandInvocationHandler.isEventSubscription(
            getMethodByName("onEventListenerTestMethod4")));
  }

  @Test
  public void testInvokeWithEvent() throws Throwable {
    EventHandler<String> eventHandler = event -> {};
    EventListener eventListener = mock(EventListener.class);

    when(chromeDevToolsService.addEventListener(
            "CommandInvocationHandlerTest", "someEventName", eventHandler, String.class))
        .thenReturn(eventListener);

    assertEquals(
        eventListener,
        invocationHandler.invoke(
            null, getMethodByName("onEventListenerTestMethod4"), new Object[] {eventHandler}));
  }

  private Method getMethodByName(String name) {
    Method[] declaredMethods = this.getClass().getDeclaredMethods();
    for (Method method : declaredMethods) {
      if (name.equals(method.getName())) {
        return method;
      }
    }

    throw new RuntimeException("Could not find method " + name);
  }

  private void onEventListenerTestMethod() {}

  private EventListener onEventListenerTestMethod1() {
    return null;
  }

  private void onEventListenerTestMethod2(String param, String param2) {}

  private EventListener onEventListenerTestMethod3(String param, String param2) {
    return null;
  }

  @EventName("someEventName")
  private EventListener onEventListenerTestMethod4(EventHandler<String> handler) {
    return null;
  }

  private void voidMethod() {}

  private String stringMethodWithParams(
      @ParamName("paramTest") String param1, @ParamName("paramTest1") Integer param2) {
    return "EMPTY-STRING";
  }

  @Returns("ReturnsValue")
  private String stringMethodWithParamsAndAnnotation(
      @ParamName("paramTest") String param1, @ParamName("paramTest1") Integer param2) {
    return "EMPTY-STRING";
  }

  @Returns("ReturnsValue")
  @ReturnTypeParameter(String.class)
  private List<String> stringMethodWithParamsAndReturnTypeAnnotation(
      @ParamName("paramTest") String param1, @ParamName("paramTest1") Integer param2) {
    return Collections.emptyList();
  }

  private String methodWithParamObject(@ParamObject TestParameters parameters) {
    return "EMPTY-STRING";
  }

  private static class TestParameters {
    @ParamName("paramTest")
    private String paramTest;

    @ParamName("paramTest1")
    private Integer paramTest1;

    private TestParameters setParamTest(String paramTest) {
      this.paramTest = paramTest;
      return this;
    }

    private TestParameters setParamTest1(Integer paramTest1) {
      this.paramTest1 = paramTest1;
      return this;
    }
  }
}
