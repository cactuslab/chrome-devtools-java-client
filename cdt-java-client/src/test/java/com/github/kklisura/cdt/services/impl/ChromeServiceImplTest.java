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

import static com.github.kklisura.cdt.services.impl.utils.TestUtils.getFixture;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.kklisura.cdt.protocol.ChromeDevTools;
import com.github.kklisura.cdt.protocol.commands.Network;
import com.github.kklisura.cdt.protocol.commands.Target;
import com.github.kklisura.cdt.protocol.types.target.CreateTargetParameters;
import com.github.kklisura.cdt.services.ChromeDevToolsService;
import com.github.kklisura.cdt.services.IsolatedTab;
import com.github.kklisura.cdt.services.WebSocketService;
import com.github.kklisura.cdt.services.exceptions.ChromeServiceException;
import com.github.kklisura.cdt.services.exceptions.WebSocketServiceException;
import com.github.kklisura.cdt.services.factory.WebSocketServiceFactory;
import com.github.kklisura.cdt.services.types.ChromeTab;
import com.github.kklisura.cdt.services.types.ChromeVersion;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;
import com.squareup.okhttp.mockwebserver.RecordedRequest;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

/**
 * Chrome service impl test.
 *
 * @author Kenan Klisura
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ChromeServiceImplTest {

  @Mock private WebSocketService webSocketService;

  @Mock private WebSocketServiceFactory webSocketServiceFactory;

  @Test
  public void testGetTabsOnBadHost() {
    ChromeServiceImpl service = new ChromeServiceImpl("unknown-schema://unknown-host", 9922);
    assertThrows(ChromeServiceException.class, service::getTabs);
  }

  @Test
  public void testGetDevToolsFailsConnectToWebSocket()
      throws IOException, WebSocketServiceException {
    InputStream fixture = getFixture("chrome/tab.json");
    ObjectMapper objectMapper = new ObjectMapper();
    ChromeTab tab = objectMapper.readerFor(ChromeTab.class).readValue(fixture);

    when(webSocketServiceFactory.createWebSocketService(tab.getWebSocketDebuggerUrl()))
        .thenThrow(new WebSocketServiceException("Failed connecting to websocket."));

    ChromeServiceImpl service = new ChromeServiceImpl(9992);
    service.setWebSocketServiceFactory(webSocketServiceFactory);
    assertThrows(ChromeServiceException.class, () -> service.createDevToolsService(tab));
  }

  @Test
  public void testGetTabs() throws IOException, ChromeServiceException, InterruptedException {
    MockWebServer server = new MockWebServer();

    InputStream fixture = getFixture("chrome/tabs.json");
    server.enqueue(new MockResponse().setBody(ChromeServiceImpl.inputStreamToString(fixture)));

    server.start();

    ChromeServiceImpl service = new ChromeServiceImpl(server.getHostName(), server.getPort());

    List<ChromeTab> tabs = service.getTabs();

    RecordedRequest request = server.takeRequest();
    assertEquals(1, server.getRequestCount());
    assertEquals("PUT /json/list HTTP/1.1", request.getRequestLine());

    assertFalse(tabs.isEmpty());
    assertEquals(2, tabs.size());

    assertEquals("", tabs.get(0).getDescription());
    assertEquals(
        "/devtools/inspector.html?ws=localhost:9222/devtools/page/(2C5C79DD1137419CC8839D61D91CEB2A)",
        tabs.get(0).getDevtoolsFrontendUrl());
    assertEquals(
        "https://www.google.ba/images/branding/product/ico/googleg_lodp.ico",
        tabs.get(0).getFaviconUrl());
    assertEquals("(2C5C79DD1137419CC8839D61D91CEB2A)", tabs.get(0).getId());
    assertEquals("Google", tabs.get(0).getTitle());
    assertEquals("page", tabs.get(0).getType());
    assertTrue(tabs.get(0).isPageType());
    assertEquals(
        "https://www.google.ba/?gws_rd=cr&dcr=0&ei=93piWq2oKqqJmgWIzbdg", tabs.get(0).getUrl());
    assertEquals(
        "ws://localhost:9222/devtools/page/(2C5C79DD1137419CC8839D61D91CEB2A)",
        tabs.get(0).getWebSocketDebuggerUrl());

    server.shutdown();
  }

  @Test
  public void testCreateTab() throws IOException, ChromeServiceException, InterruptedException {
    MockWebServer server = new MockWebServer();

    InputStream fixture = getFixture("chrome/tab.json");
    server.enqueue(new MockResponse().setBody(ChromeServiceImpl.inputStreamToString(fixture)));

    server.start();

    ChromeServiceImpl service = new ChromeServiceImpl(server.getHostName(), server.getPort());

    ChromeTab tab = service.createTab("some-tab-name");

    RecordedRequest request = server.takeRequest();
    assertEquals(1, server.getRequestCount());
    assertEquals("PUT /json/new?some-tab-name HTTP/1.1", request.getRequestLine());

    assertEquals("", tab.getDescription());
    assertEquals(
        "/devtools/inspector.html?ws=localhost:54011/devtools/page/D4CEC22C995F1A9C8526737014CD436D",
        tab.getDevtoolsFrontendUrl());
    assertEquals(
        "https://www.google.ba/images/branding/product/ico/googleg_lodp.ico", tab.getFaviconUrl());
    assertEquals("D4CEC22C995F1A9C8526737014CD436D", tab.getId());
    assertEquals("", tab.getTitle());
    assertEquals("page", tab.getType());
    assertTrue(tab.isPageType());
    assertEquals("about:blank", tab.getUrl());
    assertEquals(
        "ws://localhost:54011/devtools/page/D4CEC22C995F1A9C8526737014CD436D",
        tab.getWebSocketDebuggerUrl());

    server.shutdown();
  }

  @Test
  public void testCreateTabWithAboutBlankPage()
      throws IOException, ChromeServiceException, InterruptedException {
    MockWebServer server = new MockWebServer();

    InputStream fixture = getFixture("chrome/tab.json");
    server.enqueue(new MockResponse().setBody(ChromeServiceImpl.inputStreamToString(fixture)));

    server.start();

    ChromeServiceImpl service = new ChromeServiceImpl(server.getHostName(), server.getPort());

    ChromeTab tab = service.createTab();

    RecordedRequest request = server.takeRequest();
    assertEquals(1, server.getRequestCount());
    assertEquals("PUT /json/new?about:blank HTTP/1.1", request.getRequestLine());

    assertEquals("", tab.getDescription());
    assertEquals(
        "/devtools/inspector.html?ws=localhost:54011/devtools/page/D4CEC22C995F1A9C8526737014CD436D",
        tab.getDevtoolsFrontendUrl());
    assertEquals(
        "https://www.google.ba/images/branding/product/ico/googleg_lodp.ico", tab.getFaviconUrl());
    assertEquals("D4CEC22C995F1A9C8526737014CD436D", tab.getId());
    assertEquals("", tab.getTitle());
    assertEquals("page", tab.getType());
    assertTrue(tab.isPageType());
    assertEquals("about:blank", tab.getUrl());
    assertEquals(
        "ws://localhost:54011/devtools/page/D4CEC22C995F1A9C8526737014CD436D",
        tab.getWebSocketDebuggerUrl());

    server.shutdown();
  }

  @Test
  public void testActivateTab() throws IOException, ChromeServiceException, InterruptedException {
    MockWebServer server = new MockWebServer();
    ObjectMapper objectMapper = new ObjectMapper();

    ChromeTab tab =
        objectMapper.readerFor(ChromeTab.class).readValue(getFixture("chrome/tab.json"));

    server.enqueue(new MockResponse());
    server.start();

    ChromeServiceImpl service = new ChromeServiceImpl(server.getHostName(), server.getPort());

    service.activateTab(tab);

    RecordedRequest request = server.takeRequest();
    assertEquals(1, server.getRequestCount());
    assertEquals(
        "PUT /json/activate/D4CEC22C995F1A9C8526737014CD436D HTTP/1.1", request.getRequestLine());

    server.shutdown();
  }

  @Test
  public void testActivateTabOnNotFoundResponse() throws IOException {
    MockWebServer server = new MockWebServer();
    ObjectMapper objectMapper = new ObjectMapper();

    ChromeTab tab =
        objectMapper.readerFor(ChromeTab.class).readValue(getFixture("chrome/tab.json"));

    server.enqueue(new MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_FOUND));
    server.start();

    try {
      ChromeServiceImpl service = new ChromeServiceImpl(server.getHostName(), server.getPort());
      assertThrows(ChromeServiceException.class, () -> service.activateTab(tab));
    } finally {
      server.shutdown();
    }
  }

  @Test
  public void testCloseTabClearsDevTools()
      throws IOException, ChromeServiceException, InterruptedException, WebSocketServiceException {
    MockWebServer server = new MockWebServer();

    ObjectMapper objectMapper = new ObjectMapper();
    ChromeTab tab =
        objectMapper.readerFor(ChromeTab.class).readValue(getFixture("chrome/tab.json"));

    server.enqueue(new MockResponse());
    server.start();

    when(webSocketServiceFactory.createWebSocketService(tab.getWebSocketDebuggerUrl()))
        .thenReturn(webSocketService);

    ChromeServiceImpl service =
        new ChromeServiceImpl(server.getHostName(), server.getPort(), webSocketServiceFactory);

    service.createDevToolsService(tab);

    service.closeTab(tab);

    RecordedRequest request = server.takeRequest();
    assertEquals(1, server.getRequestCount());
    assertEquals(
        "PUT /json/close/D4CEC22C995F1A9C8526737014CD436D HTTP/1.1", request.getRequestLine());

    server.shutdown();

    verify(webSocketService).addMessageHandler(org.mockito.ArgumentMatchers.any());
    verify(webSocketService).close();
  }

  @Test
  public void testCloseTab() throws IOException, ChromeServiceException, InterruptedException {
    MockWebServer server = new MockWebServer();

    ObjectMapper objectMapper = new ObjectMapper();
    ChromeTab tab =
        objectMapper.readerFor(ChromeTab.class).readValue(getFixture("chrome/tab.json"));

    server.enqueue(new MockResponse());
    server.start();

    ChromeServiceImpl service = new ChromeServiceImpl(server.getHostName(), server.getPort());

    service.closeTab(tab);

    RecordedRequest request = server.takeRequest();
    assertEquals(1, server.getRequestCount());
    assertEquals(
        "PUT /json/close/D4CEC22C995F1A9C8526737014CD436D HTTP/1.1", request.getRequestLine());

    server.shutdown();
  }

  @Test
  public void testVersion() throws IOException, ChromeServiceException, InterruptedException {
    MockWebServer server = new MockWebServer();

    InputStream fixture = getFixture("chrome/version.json");
    server.enqueue(new MockResponse().setBody(ChromeServiceImpl.inputStreamToString(fixture)));

    server.start();

    ChromeServiceImpl service = new ChromeServiceImpl(server.getHostName(), server.getPort());

    ChromeVersion version = service.getVersion();

    RecordedRequest request = server.takeRequest();
    assertEquals(1, server.getRequestCount());
    assertEquals("PUT /json/version HTTP/1.1", request.getRequestLine());

    assertEquals("Chrome/63.0.3239.132", version.getBrowser());
    assertEquals("1.2", version.getProtocolVersion());
    assertEquals(
        "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36",
        version.getUserAgent());
    assertEquals("6.3.292.49", version.getV8Version());
    assertEquals("537.36 (@2e6edcfee630baa3775f37cb11796b1603a64360)", version.getWebKitVersion());
    assertEquals(
        "ws://localhost:9222/devtools/browser/63318df0-09e4-4143-910e-f89525dda26b",
        version.getWebSocketDebuggerUrl());

    server.shutdown();
  }

  @Test
  public void testGetDevTools()
      throws IOException, ChromeServiceException, WebSocketServiceException {
    ChromeServiceImpl service = new ChromeServiceImpl(9222, webSocketServiceFactory);

    ObjectMapper objectMapper = new ObjectMapper();
    ChromeTab tab =
        objectMapper.readerFor(ChromeTab.class).readValue(getFixture("chrome/tab.json"));

    when(webSocketServiceFactory.createWebSocketService(tab.getWebSocketDebuggerUrl()))
        .thenReturn(webSocketService);

    ChromeDevTools devTools = service.createDevToolsService(tab);

    assertNotNull(devTools);
    verify(webSocketService).addMessageHandler(org.mockito.ArgumentMatchers.any());
  }

  @Test
  public void testGetDevToolsIsCachedPerTab()
      throws IOException, ChromeServiceException, WebSocketServiceException {
    ChromeServiceImpl service = new ChromeServiceImpl(9222, webSocketServiceFactory);

    ObjectMapper objectMapper = new ObjectMapper();
    ChromeTab tab =
        objectMapper.readerFor(ChromeTab.class).readValue(getFixture("chrome/tab.json"));

    when(webSocketServiceFactory.createWebSocketService(tab.getWebSocketDebuggerUrl()))
        .thenReturn(webSocketService);

    ChromeDevTools devTools = service.createDevToolsService(tab);
    assertSame(devTools, service.createDevToolsService(tab));
    assertSame(devTools, service.createDevToolsService(tab));
    assertSame(devTools, service.createDevToolsService(tab));

    devTools = null;
    System.gc();

    reset(webSocketServiceFactory, webSocketService);
    when(webSocketServiceFactory.createWebSocketService(tab.getWebSocketDebuggerUrl()))
        .thenReturn(webSocketService);

    devTools = service.createDevToolsService(tab);

    assertNotNull(devTools);
  }

  @Test
  public void testGetDevToolsSubTypeIsCachedPerTab()
      throws IOException, ChromeServiceException, WebSocketServiceException {
    ChromeServiceImpl service = new ChromeServiceImpl(9222, webSocketServiceFactory);

    ObjectMapper objectMapper = new ObjectMapper();
    ChromeTab tab =
        objectMapper.readerFor(ChromeTab.class).readValue(getFixture("chrome/tab.json"));

    when(webSocketServiceFactory.createWebSocketService(tab.getWebSocketDebuggerUrl()))
        .thenReturn(webSocketService);

    Network network = service.createDevToolsService(tab).getNetwork();
    assertSame(network, service.createDevToolsService(tab).getNetwork());
    assertSame(network, service.createDevToolsService(tab).getNetwork());
    assertSame(network, service.createDevToolsService(tab).getNetwork());

    assertNotNull(network);
  }

  @Test
  public void testClearChromeDevToolsServiceCacheAndCloseDevTools()
      throws IOException, ChromeServiceException, WebSocketServiceException {
    ChromeServiceImpl service = new ChromeServiceImpl(9222, webSocketServiceFactory);

    ObjectMapper objectMapper = new ObjectMapper();
    ChromeTab tab =
        objectMapper.readerFor(ChromeTab.class).readValue(getFixture("chrome/tab.json"));

    when(webSocketServiceFactory.createWebSocketService(tab.getWebSocketDebuggerUrl()))
        .thenReturn(webSocketService);

    service.createDevToolsService(tab);

    service.clearChromeDevToolsServiceCache(tab);

    verify(webSocketService).addMessageHandler(org.mockito.ArgumentMatchers.any());
    verify(webSocketService).close();
  }

  @Test
  @SuppressWarnings("deprecation")
  public void testClearChromeDevToolsServiceCache() throws IOException {
    ChromeServiceImpl service = new ChromeServiceImpl(9222, webSocketServiceFactory);
    service.clearChromeDevToolsServiceCache(createChromeTab("UNUSED"));
  }

  @Test
  public void testCreateBrowserDevToolsService()
      throws IOException, ChromeServiceException, InterruptedException, WebSocketServiceException {
    MockWebServer server = new MockWebServer();

    InputStream fixture = getFixture("chrome/version.json");
    server.enqueue(new MockResponse().setBody(ChromeServiceImpl.inputStreamToString(fixture)));
    server.start();

    when(webSocketServiceFactory.createWebSocketService(
            "ws://localhost:9222/devtools/browser/63318df0-09e4-4143-910e-f89525dda26b"))
        .thenReturn(webSocketService);

    ChromeServiceImpl service =
        new ChromeServiceImpl(server.getHostName(), server.getPort(), webSocketServiceFactory);

    ChromeDevToolsService devTools = service.createBrowserDevToolsService();

    RecordedRequest request = server.takeRequest();
    assertEquals(1, server.getRequestCount());
    assertEquals("PUT /json/version HTTP/1.1", request.getRequestLine());

    assertNotNull(devTools);
    verify(webSocketService).addMessageHandler(org.mockito.ArgumentMatchers.any());

    server.shutdown();
  }

  @Test
  public void testCreateBrowserDevToolsServiceIsCached()
      throws IOException, ChromeServiceException, WebSocketServiceException {
    MockWebServer server = new MockWebServer();

    InputStream fixture = getFixture("chrome/version.json");
    server.enqueue(new MockResponse().setBody(ChromeServiceImpl.inputStreamToString(fixture)));
    server.start();

    when(webSocketServiceFactory.createWebSocketService(
            "ws://localhost:9222/devtools/browser/63318df0-09e4-4143-910e-f89525dda26b"))
        .thenReturn(webSocketService);

    ChromeServiceImpl service =
        new ChromeServiceImpl(server.getHostName(), server.getPort(), webSocketServiceFactory);

    ChromeDevToolsService devTools = service.createBrowserDevToolsService();

    // Subsequent calls return the cached service without another json/version round-trip.
    assertSame(devTools, service.createBrowserDevToolsService());
    assertEquals(1, server.getRequestCount());

    server.shutdown();
  }

  @Test
  public void testCreateDevToolsServiceByTargetId()
      throws IOException, ChromeServiceException, WebSocketServiceException {
    ChromeServiceImpl service = new ChromeServiceImpl(9222, webSocketServiceFactory);

    when(webSocketServiceFactory.createWebSocketService(
            "ws://localhost:9222/devtools/page/TARGET-ID"))
        .thenReturn(webSocketService);

    ChromeDevToolsService devTools = service.createDevToolsService("TARGET-ID");

    assertNotNull(devTools);
    verify(webSocketService).addMessageHandler(org.mockito.ArgumentMatchers.any());
  }

  @Test
  public void testCreateDevToolsServiceByTargetIdIsCached()
      throws IOException, ChromeServiceException, WebSocketServiceException {
    ChromeServiceImpl service = new ChromeServiceImpl(9222, webSocketServiceFactory);

    when(webSocketServiceFactory.createWebSocketService(
            "ws://localhost:9222/devtools/page/TARGET-ID"))
        .thenReturn(webSocketService);

    ChromeDevToolsService devTools = service.createDevToolsService("TARGET-ID");
    assertSame(devTools, service.createDevToolsService("TARGET-ID"));
  }

  @Test
  public void testCloseEvictsDevToolsServiceFromCache()
      throws IOException, ChromeServiceException, WebSocketServiceException {
    ChromeServiceImpl service = new ChromeServiceImpl(9222, webSocketServiceFactory);

    when(webSocketServiceFactory.createWebSocketService(
            "ws://localhost:9222/devtools/page/TARGET-ID"))
        .thenReturn(webSocketService);

    ChromeDevToolsService devTools = service.createDevToolsService("TARGET-ID");

    // Closing the service evicts it from the cache, so a subsequent create builds a fresh one.
    devTools.close();
    verify(webSocketService).close();

    assertNotSame(devTools, service.createDevToolsService("TARGET-ID"));
  }

  @Test
  public void testCreateIsolatedTab() throws ChromeServiceException {
    ChromeServiceImpl service = spy(new ChromeServiceImpl(9222, webSocketServiceFactory));

    ChromeDevToolsService browserDevTools = mock(ChromeDevToolsService.class);
    Target target = mock(Target.class);
    ChromeDevToolsService tabDevTools = mock(ChromeDevToolsService.class);

    doReturn(browserDevTools).when(service).createBrowserDevToolsService();
    when(browserDevTools.getTarget()).thenReturn(target);
    when(target.createBrowserContext()).thenReturn("browser-context-id");
    when(target.createTarget(any(CreateTargetParameters.class))).thenReturn("target-id");
    doReturn(tabDevTools).when(service).createDevToolsService("target-id");

    IsolatedTab isolatedTab = service.createIsolatedTab();

    assertEquals("browser-context-id", isolatedTab.getBrowserContextId());
    assertEquals("target-id", isolatedTab.getTargetId());
    assertSame(tabDevTools, isolatedTab.getDevToolsService());

    ArgumentCaptor<CreateTargetParameters> paramsCaptor =
        ArgumentCaptor.forClass(CreateTargetParameters.class);
    verify(target).createTarget(paramsCaptor.capture());
    assertEquals(ChromeServiceImpl.ABOUT_BLANK_PAGE, paramsCaptor.getValue().getUrl());
    assertEquals("browser-context-id", paramsCaptor.getValue().getBrowserContextId());
  }

  @Test
  public void testCreateIsolatedTabDisposesBrowserContextOnFailure() {
    ChromeServiceImpl service = spy(new ChromeServiceImpl(9222, webSocketServiceFactory));

    ChromeDevToolsService browserDevTools = mock(ChromeDevToolsService.class);
    Target target = mock(Target.class);

    doReturn(browserDevTools).when(service).createBrowserDevToolsService();
    when(browserDevTools.getTarget()).thenReturn(target);
    when(target.createBrowserContext()).thenReturn("browser-context-id");

    RuntimeException failure = new RuntimeException("createTarget failed");
    when(target.createTarget(any(CreateTargetParameters.class))).thenThrow(failure);

    RuntimeException thrown = assertThrows(RuntimeException.class, service::createIsolatedTab);
    assertSame(failure, thrown);

    // The browser context must not be leaked when target creation fails.
    verify(target).disposeBrowserContext("browser-context-id");
  }

  private static ChromeTab createChromeTab(String id) throws IOException {
    return new ObjectMapper()
        .readerFor(ChromeTab.class)
        .readValue(String.format("{\"id\":\"%s\"}", id));
  }
}
