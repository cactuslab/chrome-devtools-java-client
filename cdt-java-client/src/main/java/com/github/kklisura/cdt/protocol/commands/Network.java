package com.github.kklisura.cdt.protocol.commands;

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

import com.github.kklisura.cdt.protocol.events.network.DataReceived;
import com.github.kklisura.cdt.protocol.events.network.DeviceBoundSessionEventOccurred;
import com.github.kklisura.cdt.protocol.events.network.DeviceBoundSessionsAdded;
import com.github.kklisura.cdt.protocol.events.network.DirectTCPSocketAborted;
import com.github.kklisura.cdt.protocol.events.network.DirectTCPSocketChunkReceived;
import com.github.kklisura.cdt.protocol.events.network.DirectTCPSocketChunkSent;
import com.github.kklisura.cdt.protocol.events.network.DirectTCPSocketClosed;
import com.github.kklisura.cdt.protocol.events.network.DirectTCPSocketCreated;
import com.github.kklisura.cdt.protocol.events.network.DirectTCPSocketOpened;
import com.github.kklisura.cdt.protocol.events.network.DirectUDPSocketAborted;
import com.github.kklisura.cdt.protocol.events.network.DirectUDPSocketChunkReceived;
import com.github.kklisura.cdt.protocol.events.network.DirectUDPSocketChunkSent;
import com.github.kklisura.cdt.protocol.events.network.DirectUDPSocketClosed;
import com.github.kklisura.cdt.protocol.events.network.DirectUDPSocketCreated;
import com.github.kklisura.cdt.protocol.events.network.DirectUDPSocketJoinedMulticastGroup;
import com.github.kklisura.cdt.protocol.events.network.DirectUDPSocketLeftMulticastGroup;
import com.github.kklisura.cdt.protocol.events.network.DirectUDPSocketOpened;
import com.github.kklisura.cdt.protocol.events.network.EventSourceMessageReceived;
import com.github.kklisura.cdt.protocol.events.network.LoadingFailed;
import com.github.kklisura.cdt.protocol.events.network.LoadingFinished;
import com.github.kklisura.cdt.protocol.events.network.PolicyUpdated;
import com.github.kklisura.cdt.protocol.events.network.ReportingApiEndpointsChangedForOrigin;
import com.github.kklisura.cdt.protocol.events.network.ReportingApiReportAdded;
import com.github.kklisura.cdt.protocol.events.network.ReportingApiReportUpdated;
import com.github.kklisura.cdt.protocol.events.network.RequestIntercepted;
import com.github.kklisura.cdt.protocol.events.network.RequestServedFromCache;
import com.github.kklisura.cdt.protocol.events.network.RequestWillBeSent;
import com.github.kklisura.cdt.protocol.events.network.RequestWillBeSentExtraInfo;
import com.github.kklisura.cdt.protocol.events.network.ResourceChangedPriority;
import com.github.kklisura.cdt.protocol.events.network.ResponseReceived;
import com.github.kklisura.cdt.protocol.events.network.ResponseReceivedEarlyHints;
import com.github.kklisura.cdt.protocol.events.network.ResponseReceivedExtraInfo;
import com.github.kklisura.cdt.protocol.events.network.SignedExchangeReceived;
import com.github.kklisura.cdt.protocol.events.network.TrustTokenOperationDone;
import com.github.kklisura.cdt.protocol.events.network.WebSocketClosed;
import com.github.kklisura.cdt.protocol.events.network.WebSocketCreated;
import com.github.kklisura.cdt.protocol.events.network.WebSocketFrameError;
import com.github.kklisura.cdt.protocol.events.network.WebSocketFrameReceived;
import com.github.kklisura.cdt.protocol.events.network.WebSocketFrameSent;
import com.github.kklisura.cdt.protocol.events.network.WebSocketHandshakeResponseReceived;
import com.github.kklisura.cdt.protocol.events.network.WebSocketWillSendHandshakeRequest;
import com.github.kklisura.cdt.protocol.events.network.WebTransportClosed;
import com.github.kklisura.cdt.protocol.events.network.WebTransportConnectionEstablished;
import com.github.kklisura.cdt.protocol.events.network.WebTransportCreated;
import com.github.kklisura.cdt.protocol.support.annotations.EventName;
import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;
import com.github.kklisura.cdt.protocol.support.annotations.ReturnTypeParameter;
import com.github.kklisura.cdt.protocol.support.annotations.Returns;
import com.github.kklisura.cdt.protocol.support.types.EventHandler;
import com.github.kklisura.cdt.protocol.support.types.EventListener;
import com.github.kklisura.cdt.protocol.types.debugger.SearchMatch;
import com.github.kklisura.cdt.protocol.types.network.AuthChallengeResponse;
import com.github.kklisura.cdt.protocol.types.network.BlockPattern;
import com.github.kklisura.cdt.protocol.types.network.ConnectionType;
import com.github.kklisura.cdt.protocol.types.network.ContentEncoding;
import com.github.kklisura.cdt.protocol.types.network.Cookie;
import com.github.kklisura.cdt.protocol.types.network.CookieParam;
import com.github.kklisura.cdt.protocol.types.network.CookiePartitionKey;
import com.github.kklisura.cdt.protocol.types.network.CookiePriority;
import com.github.kklisura.cdt.protocol.types.network.CookieSameSite;
import com.github.kklisura.cdt.protocol.types.network.CookieSourceScheme;
import com.github.kklisura.cdt.protocol.types.network.DeviceBoundSessionKey;
import com.github.kklisura.cdt.protocol.types.network.ErrorReason;
import com.github.kklisura.cdt.protocol.types.network.LoadNetworkResourceOptions;
import com.github.kklisura.cdt.protocol.types.network.LoadNetworkResourcePageResult;
import com.github.kklisura.cdt.protocol.types.network.NetworkConditions;
import com.github.kklisura.cdt.protocol.types.network.RequestPattern;
import com.github.kklisura.cdt.protocol.types.network.RequestPostData;
import com.github.kklisura.cdt.protocol.types.network.ResponseBody;
import com.github.kklisura.cdt.protocol.types.network.ResponseBodyForInterception;
import com.github.kklisura.cdt.protocol.types.network.SecurityIsolationStatus;
import java.util.List;
import java.util.Map;

/**
 * Network domain allows tracking network activities of the page. It exposes information about http,
 * file, data and other requests and responses, their headers, bodies, timing, etc.
 */
public interface Network {

  /**
   * Sets a list of content encodings that will be accepted. Empty list means no encoding is
   * accepted.
   *
   * @param encodings List of accepted content encodings.
   */
  @Experimental
  void setAcceptedEncodings(@ParamName("encodings") List<ContentEncoding> encodings);

  /** Clears accepted encodings set by setAcceptedEncodings */
  @Experimental
  void clearAcceptedEncodingsOverride();

  /** Tells whether clearing browser cache is supported. */
  @Deprecated
  @Returns("result")
  Boolean canClearBrowserCache();

  /** Tells whether clearing browser cookies is supported. */
  @Deprecated
  @Returns("result")
  Boolean canClearBrowserCookies();

  /** Tells whether emulation of network conditions is supported. */
  @Deprecated
  @Returns("result")
  Boolean canEmulateNetworkConditions();

  /** Clears browser cache. */
  void clearBrowserCache();

  /** Clears browser cookies. */
  void clearBrowserCookies();

  /**
   * Response to Network.requestIntercepted which either modifies the request to continue with any
   * modifications, or blocks it, or completes it with the provided response bytes. If a network
   * fetch occurs as a result which encounters a redirect an additional Network.requestIntercepted
   * event will be sent with the same InterceptionId. Deprecated, use Fetch.continueRequest,
   * Fetch.fulfillRequest and Fetch.failRequest instead.
   *
   * @param interceptionId
   */
  @Deprecated
  @Experimental
  void continueInterceptedRequest(@ParamName("interceptionId") String interceptionId);

  /**
   * Response to Network.requestIntercepted which either modifies the request to continue with any
   * modifications, or blocks it, or completes it with the provided response bytes. If a network
   * fetch occurs as a result which encounters a redirect an additional Network.requestIntercepted
   * event will be sent with the same InterceptionId. Deprecated, use Fetch.continueRequest,
   * Fetch.fulfillRequest and Fetch.failRequest instead.
   *
   * @param interceptionId
   * @param errorReason If set this causes the request to fail with the given reason. Passing
   *     `Aborted` for requests marked with `isNavigationRequest` also cancels the navigation. Must
   *     not be set in response to an authChallenge.
   * @param rawResponse If set the requests completes using with the provided base64 encoded raw
   *     response, including HTTP status line and headers etc... Must not be set in response to an
   *     authChallenge. (Encoded as a base64 string when passed over JSON)
   * @param url If set the request url will be modified in a way that's not observable by page. Must
   *     not be set in response to an authChallenge.
   * @param method If set this allows the request method to be overridden. Must not be set in
   *     response to an authChallenge.
   * @param postData If set this allows postData to be set. Must not be set in response to an
   *     authChallenge.
   * @param headers If set this allows the request headers to be changed. Must not be set in
   *     response to an authChallenge.
   * @param authChallengeResponse Response to a requestIntercepted with an authChallenge. Must not
   *     be set otherwise.
   */
  @Deprecated
  @Experimental
  void continueInterceptedRequest(
      @ParamName("interceptionId") String interceptionId,
      @Optional @ParamName("errorReason") ErrorReason errorReason,
      @Optional @ParamName("rawResponse") String rawResponse,
      @Optional @ParamName("url") String url,
      @Optional @ParamName("method") String method,
      @Optional @ParamName("postData") String postData,
      @Optional @ParamName("headers") Map<String, Object> headers,
      @Optional @ParamName("authChallengeResponse") AuthChallengeResponse authChallengeResponse);

  /**
   * Deletes browser cookies with matching name and url or domain/path/partitionKey pair.
   *
   * @param name Name of the cookies to remove.
   */
  void deleteCookies(@ParamName("name") String name);

  /**
   * Deletes browser cookies with matching name and url or domain/path/partitionKey pair.
   *
   * @param name Name of the cookies to remove.
   * @param url If specified, deletes all the cookies with the given name where domain and path
   *     match provided URL.
   * @param domain If specified, deletes only cookies with the exact domain.
   * @param path If specified, deletes only cookies with the exact path.
   * @param partitionKey If specified, deletes only cookies with the the given name and partitionKey
   *     where all partition key attributes match the cookie partition key attribute.
   */
  void deleteCookies(
      @ParamName("name") String name,
      @Optional @ParamName("url") String url,
      @Optional @ParamName("domain") String domain,
      @Optional @ParamName("path") String path,
      @Experimental @Optional @ParamName("partitionKey") CookiePartitionKey partitionKey);

  /** Disables network tracking, prevents network events from being sent to the client. */
  void disable();

  /**
   * Activates emulation of network conditions. This command is deprecated in favor of the
   * emulateNetworkConditionsByRule and overrideNetworkState commands, which can be used together to
   * the same effect.
   *
   * @param offline True to emulate internet disconnection.
   * @param latency Minimum latency from request sent to response headers received (ms).
   * @param downloadThroughput Maximal aggregated download throughput (bytes/sec). -1 disables
   *     download throttling.
   * @param uploadThroughput Maximal aggregated upload throughput (bytes/sec). -1 disables upload
   *     throttling.
   */
  @Deprecated
  void emulateNetworkConditions(
      @ParamName("offline") Boolean offline,
      @ParamName("latency") Double latency,
      @ParamName("downloadThroughput") Double downloadThroughput,
      @ParamName("uploadThroughput") Double uploadThroughput);

  /**
   * Activates emulation of network conditions. This command is deprecated in favor of the
   * emulateNetworkConditionsByRule and overrideNetworkState commands, which can be used together to
   * the same effect.
   *
   * @param offline True to emulate internet disconnection.
   * @param latency Minimum latency from request sent to response headers received (ms).
   * @param downloadThroughput Maximal aggregated download throughput (bytes/sec). -1 disables
   *     download throttling.
   * @param uploadThroughput Maximal aggregated upload throughput (bytes/sec). -1 disables upload
   *     throttling.
   * @param connectionType Connection type if known.
   * @param packetLoss WebRTC packet loss (percent, 0-100). 0 disables packet loss emulation, 100
   *     drops all the packets.
   * @param packetQueueLength WebRTC packet queue length (packet). 0 removes any queue length
   *     limitations.
   * @param packetReordering WebRTC packetReordering feature.
   */
  @Deprecated
  void emulateNetworkConditions(
      @ParamName("offline") Boolean offline,
      @ParamName("latency") Double latency,
      @ParamName("downloadThroughput") Double downloadThroughput,
      @ParamName("uploadThroughput") Double uploadThroughput,
      @Optional @ParamName("connectionType") ConnectionType connectionType,
      @Experimental @Optional @ParamName("packetLoss") Double packetLoss,
      @Experimental @Optional @ParamName("packetQueueLength") Integer packetQueueLength,
      @Experimental @Optional @ParamName("packetReordering") Boolean packetReordering);

  /**
   * Activates emulation of network conditions for individual requests using URL match patterns.
   * Unlike the deprecated Network.emulateNetworkConditions this method does not affect `navigator`
   * state. Use Network.overrideNetworkState to explicitly modify `navigator` behavior.
   *
   * @param matchedNetworkConditions Configure conditions for matching requests. If multiple entries
   *     match a request, the first entry wins. Global conditions can be configured by leaving the
   *     urlPattern for the conditions empty. These global conditions are also applied for
   *     throttling of p2p connections.
   */
  @Experimental
  @Returns("ruleIds")
  @ReturnTypeParameter(String.class)
  List<String> emulateNetworkConditionsByRule(
      @ParamName("matchedNetworkConditions") List<NetworkConditions> matchedNetworkConditions);

  /**
   * Activates emulation of network conditions for individual requests using URL match patterns.
   * Unlike the deprecated Network.emulateNetworkConditions this method does not affect `navigator`
   * state. Use Network.overrideNetworkState to explicitly modify `navigator` behavior.
   *
   * @param offline True to emulate internet disconnection. Deprecated, use the offline property in
   *     matchedNetworkConditions or emulateOfflineServiceWorker instead.
   * @param emulateOfflineServiceWorker True to emulate offline service worker.
   * @param matchedNetworkConditions Configure conditions for matching requests. If multiple entries
   *     match a request, the first entry wins. Global conditions can be configured by leaving the
   *     urlPattern for the conditions empty. These global conditions are also applied for
   *     throttling of p2p connections.
   */
  @Experimental
  @Returns("ruleIds")
  @ReturnTypeParameter(String.class)
  List<String> emulateNetworkConditionsByRule(
      @Deprecated @Optional @ParamName("offline") Boolean offline,
      @Optional @ParamName("emulateOfflineServiceWorker") Boolean emulateOfflineServiceWorker,
      @ParamName("matchedNetworkConditions") List<NetworkConditions> matchedNetworkConditions);

  /**
   * Override the state of navigator.onLine and navigator.connection.
   *
   * @param offline True to emulate internet disconnection.
   * @param latency Minimum latency from request sent to response headers received (ms).
   * @param downloadThroughput Maximal aggregated download throughput (bytes/sec). -1 disables
   *     download throttling.
   * @param uploadThroughput Maximal aggregated upload throughput (bytes/sec). -1 disables upload
   *     throttling.
   */
  @Experimental
  void overrideNetworkState(
      @ParamName("offline") Boolean offline,
      @ParamName("latency") Double latency,
      @ParamName("downloadThroughput") Double downloadThroughput,
      @ParamName("uploadThroughput") Double uploadThroughput);

  /**
   * Override the state of navigator.onLine and navigator.connection.
   *
   * @param offline True to emulate internet disconnection.
   * @param latency Minimum latency from request sent to response headers received (ms).
   * @param downloadThroughput Maximal aggregated download throughput (bytes/sec). -1 disables
   *     download throttling.
   * @param uploadThroughput Maximal aggregated upload throughput (bytes/sec). -1 disables upload
   *     throttling.
   * @param connectionType Connection type if known.
   */
  @Experimental
  void overrideNetworkState(
      @ParamName("offline") Boolean offline,
      @ParamName("latency") Double latency,
      @ParamName("downloadThroughput") Double downloadThroughput,
      @ParamName("uploadThroughput") Double uploadThroughput,
      @Optional @ParamName("connectionType") ConnectionType connectionType);

  /** Enables network tracking, network events will now be delivered to the client. */
  void enable();

  /**
   * Enables network tracking, network events will now be delivered to the client.
   *
   * @param maxTotalBufferSize Buffer size in bytes to use when preserving network payloads (XHRs,
   *     etc). This is the maximum number of bytes that will be collected by this DevTools session.
   * @param maxResourceBufferSize Per-resource buffer size in bytes to use when preserving network
   *     payloads (XHRs, etc).
   * @param maxPostDataSize Longest post body size (in bytes) that would be included in
   *     requestWillBeSent notification
   * @param reportDirectSocketTraffic Whether DirectSocket chunk send/receive events should be
   *     reported.
   * @param enableDurableMessages Enable storing response bodies outside of renderer, so that these
   *     survive a cross-process navigation. Requires maxTotalBufferSize to be set. Currently
   *     defaults to false. This field is being deprecated in favor of the dedicated
   *     configureDurableMessages command, due to the possibility of deadlocks when awaiting
   *     Network.enable before issuing Runtime.runIfWaitingForDebugger.
   */
  void enable(
      @Experimental @Optional @ParamName("maxTotalBufferSize") Integer maxTotalBufferSize,
      @Experimental @Optional @ParamName("maxResourceBufferSize") Integer maxResourceBufferSize,
      @Optional @ParamName("maxPostDataSize") Integer maxPostDataSize,
      @Experimental @Optional @ParamName("reportDirectSocketTraffic")
          Boolean reportDirectSocketTraffic,
      @Experimental @Optional @ParamName("enableDurableMessages") Boolean enableDurableMessages);

  /**
   * Configures storing response bodies outside of renderer, so that these survive a cross-process
   * navigation. If maxTotalBufferSize is not set, durable messages are disabled.
   */
  @Experimental
  void configureDurableMessages();

  /**
   * Configures storing response bodies outside of renderer, so that these survive a cross-process
   * navigation. If maxTotalBufferSize is not set, durable messages are disabled.
   *
   * @param maxTotalBufferSize Buffer size in bytes to use when preserving network payloads (XHRs,
   *     etc).
   * @param maxResourceBufferSize Per-resource buffer size in bytes to use when preserving network
   *     payloads (XHRs, etc).
   */
  @Experimental
  void configureDurableMessages(
      @Optional @ParamName("maxTotalBufferSize") Integer maxTotalBufferSize,
      @Optional @ParamName("maxResourceBufferSize") Integer maxResourceBufferSize);

  /**
   * Returns all browser cookies. Depending on the backend support, will return detailed cookie
   * information in the `cookies` field. Deprecated. Use Storage.getCookies instead.
   */
  @Deprecated
  @Returns("cookies")
  @ReturnTypeParameter(Cookie.class)
  List<Cookie> getAllCookies();

  /**
   * Returns the DER-encoded certificate.
   *
   * @param origin Origin to get certificate for.
   */
  @Experimental
  @Returns("tableNames")
  @ReturnTypeParameter(String.class)
  List<String> getCertificate(@ParamName("origin") String origin);

  /**
   * Returns all browser cookies for the current URL. Depending on the backend support, will return
   * detailed cookie information in the `cookies` field.
   */
  @Returns("cookies")
  @ReturnTypeParameter(Cookie.class)
  List<Cookie> getCookies();

  /**
   * Returns all browser cookies for the current URL. Depending on the backend support, will return
   * detailed cookie information in the `cookies` field.
   *
   * @param urls The list of URLs for which applicable cookies will be fetched. If not specified,
   *     it's assumed to be set to the list containing the URLs of the page and all of its
   *     subframes.
   */
  @Returns("cookies")
  @ReturnTypeParameter(Cookie.class)
  List<Cookie> getCookies(@Optional @ParamName("urls") List<String> urls);

  /**
   * Returns content served for the given request.
   *
   * @param requestId Identifier of the network request to get content for.
   */
  ResponseBody getResponseBody(@ParamName("requestId") String requestId);

  /**
   * Returns post data sent with the request. Returns an error when no data was sent with the
   * request.
   *
   * @param requestId Identifier of the network request to get content for.
   */
  RequestPostData getRequestPostData(@ParamName("requestId") String requestId);

  /**
   * Returns content served for the given currently intercepted request.
   *
   * @param interceptionId Identifier for the intercepted request to get body for.
   */
  @Experimental
  ResponseBodyForInterception getResponseBodyForInterception(
      @ParamName("interceptionId") String interceptionId);

  /**
   * Returns a handle to the stream representing the response body. Note that after this command,
   * the intercepted request can't be continued as is -- you either need to cancel it or to provide
   * the response body. The stream only supports sequential read, IO.read will fail if the position
   * is specified.
   *
   * @param interceptionId
   */
  @Experimental
  @Returns("stream")
  String takeResponseBodyForInterceptionAsStream(
      @ParamName("interceptionId") String interceptionId);

  /**
   * This method sends a new XMLHttpRequest which is identical to the original one. The following
   * parameters should be identical: method, url, async, request body, extra headers,
   * withCredentials attribute, user, password.
   *
   * @param requestId Identifier of XHR to replay.
   */
  @Experimental
  void replayXHR(@ParamName("requestId") String requestId);

  /**
   * Searches for given string in response content.
   *
   * @param requestId Identifier of the network response to search.
   * @param query String to search for.
   */
  @Experimental
  @Returns("result")
  @ReturnTypeParameter(SearchMatch.class)
  List<SearchMatch> searchInResponseBody(
      @ParamName("requestId") String requestId, @ParamName("query") String query);

  /**
   * Searches for given string in response content.
   *
   * @param requestId Identifier of the network response to search.
   * @param query String to search for.
   * @param caseSensitive If true, search is case sensitive.
   * @param isRegex If true, treats string parameter as regex.
   */
  @Experimental
  @Returns("result")
  @ReturnTypeParameter(SearchMatch.class)
  List<SearchMatch> searchInResponseBody(
      @ParamName("requestId") String requestId,
      @ParamName("query") String query,
      @Optional @ParamName("caseSensitive") Boolean caseSensitive,
      @Optional @ParamName("isRegex") Boolean isRegex);

  /** Blocks URLs from loading. */
  @Experimental
  void setBlockedURLs();

  /**
   * Blocks URLs from loading.
   *
   * @param urlPatterns Patterns to match in the order in which they are given. These patterns also
   *     take precedence over any wildcard patterns defined in `urls`.
   * @param urls URL patterns to block. Wildcards ('*') are allowed.
   */
  @Experimental
  void setBlockedURLs(
      @Optional @ParamName("urlPatterns") List<BlockPattern> urlPatterns,
      @Deprecated @Optional @ParamName("urls") List<String> urls);

  /**
   * Toggles ignoring of service worker for each request.
   *
   * @param bypass Bypass service worker and load from network.
   */
  void setBypassServiceWorker(@ParamName("bypass") Boolean bypass);

  /**
   * Toggles ignoring cache for each request. If `true`, cache will not be used.
   *
   * @param cacheDisabled Cache disabled state.
   */
  void setCacheDisabled(@ParamName("cacheDisabled") Boolean cacheDisabled);

  /**
   * Sets a cookie with the given cookie data; may overwrite equivalent cookies if they exist.
   *
   * @param name Cookie name.
   * @param value Cookie value.
   */
  @Returns("success")
  Boolean setCookie(@ParamName("name") String name, @ParamName("value") String value);

  /**
   * Sets a cookie with the given cookie data; may overwrite equivalent cookies if they exist.
   *
   * @param name Cookie name.
   * @param value Cookie value.
   * @param url The request-URI to associate with the setting of the cookie. This value can affect
   *     the default domain, path, source port, and source scheme values of the created cookie.
   * @param domain Cookie domain.
   * @param path Cookie path.
   * @param secure True if cookie is secure.
   * @param httpOnly True if cookie is http-only.
   * @param sameSite Cookie SameSite type.
   * @param expires Cookie expiration date, session cookie if not set
   * @param priority Cookie Priority type.
   * @param sourceScheme Cookie source scheme type.
   * @param sourcePort Cookie source port. Valid values are {-1, [1, 65535]}, -1 indicates an
   *     unspecified port. An unspecified port value allows protocol clients to emulate legacy
   *     cookie scope for the port. This is a temporary ability and it will be removed in the
   *     future.
   * @param partitionKey Cookie partition key. If not set, the cookie will be set as not
   *     partitioned.
   */
  @Returns("success")
  Boolean setCookie(
      @ParamName("name") String name,
      @ParamName("value") String value,
      @Optional @ParamName("url") String url,
      @Optional @ParamName("domain") String domain,
      @Optional @ParamName("path") String path,
      @Optional @ParamName("secure") Boolean secure,
      @Optional @ParamName("httpOnly") Boolean httpOnly,
      @Optional @ParamName("sameSite") CookieSameSite sameSite,
      @Optional @ParamName("expires") Double expires,
      @Experimental @Optional @ParamName("priority") CookiePriority priority,
      @Experimental @Optional @ParamName("sourceScheme") CookieSourceScheme sourceScheme,
      @Experimental @Optional @ParamName("sourcePort") Integer sourcePort,
      @Experimental @Optional @ParamName("partitionKey") CookiePartitionKey partitionKey);

  /**
   * Sets given cookies.
   *
   * @param cookies Cookies to be set.
   */
  void setCookies(@ParamName("cookies") List<CookieParam> cookies);

  /**
   * Specifies whether to always send extra HTTP headers with the requests from this page.
   *
   * @param headers Map with extra HTTP headers.
   */
  void setExtraHTTPHeaders(@ParamName("headers") Map<String, Object> headers);

  /**
   * Specifies whether to attach a page script stack id in requests
   *
   * @param enabled Whether to attach a page script stack for debugging purpose.
   */
  @Experimental
  void setAttachDebugStack(@ParamName("enabled") Boolean enabled);

  /**
   * Sets the requests to intercept that match the provided patterns and optionally resource types.
   * Deprecated, please use Fetch.enable instead.
   *
   * @param patterns Requests matching any of these patterns will be forwarded and wait for the
   *     corresponding continueInterceptedRequest call.
   */
  @Deprecated
  @Experimental
  void setRequestInterception(@ParamName("patterns") List<RequestPattern> patterns);

  /**
   * Enables streaming of the response for the given requestId. If enabled, the dataReceived event
   * contains the data that was received during streaming.
   *
   * @param requestId Identifier of the request to stream.
   */
  @Experimental
  @Returns("bufferedData")
  String streamResourceContent(@ParamName("requestId") String requestId);

  /** Returns information about the COEP/COOP isolation status. */
  @Experimental
  @Returns("status")
  SecurityIsolationStatus getSecurityIsolationStatus();

  /**
   * Returns information about the COEP/COOP isolation status.
   *
   * @param frameId If no frameId is provided, the status of the target is provided.
   */
  @Experimental
  @Returns("status")
  SecurityIsolationStatus getSecurityIsolationStatus(
      @Optional @ParamName("frameId") String frameId);

  /**
   * Enables tracking for the Reporting API, events generated by the Reporting API will now be
   * delivered to the client. Enabling triggers 'reportingApiReportAdded' for all existing reports.
   *
   * @param enable Whether to enable or disable events for the Reporting API
   */
  @Experimental
  void enableReportingApi(@ParamName("enable") Boolean enable);

  /**
   * Sets up tracking device bound sessions and fetching of initial set of sessions.
   *
   * @param enable Whether to enable or disable events.
   */
  @Experimental
  void enableDeviceBoundSessions(@ParamName("enable") Boolean enable);

  /**
   * Deletes a device bound session.
   *
   * @param key
   */
  @Experimental
  void deleteDeviceBoundSession(@ParamName("key") DeviceBoundSessionKey key);

  /**
   * Fetches the schemeful site for a specific origin.
   *
   * @param origin The URL origin.
   */
  @Experimental
  @Returns("schemefulSite")
  String fetchSchemefulSite(@ParamName("origin") String origin);

  /**
   * Fetches the resource and returns the content.
   *
   * @param url URL of the resource to get content for.
   * @param options Options for the request.
   */
  @Experimental
  @Returns("resource")
  LoadNetworkResourcePageResult loadNetworkResource(
      @ParamName("url") String url, @ParamName("options") LoadNetworkResourceOptions options);

  /**
   * Fetches the resource and returns the content.
   *
   * @param frameId Frame id to get the resource for. Mandatory for frame targets, and should be
   *     omitted for worker targets.
   * @param url URL of the resource to get content for.
   * @param options Options for the request.
   */
  @Experimental
  @Returns("resource")
  LoadNetworkResourcePageResult loadNetworkResource(
      @Optional @ParamName("frameId") String frameId,
      @ParamName("url") String url,
      @ParamName("options") LoadNetworkResourceOptions options);

  /**
   * Sets Controls for third-party cookie access Page reload is required before the new cookie
   * behavior will be observed
   *
   * @param enableThirdPartyCookieRestriction Whether 3pc restriction is enabled.
   */
  @Experimental
  void setCookieControls(
      @ParamName("enableThirdPartyCookieRestriction") Boolean enableThirdPartyCookieRestriction);

  /** Fired when data chunk was received over the network. */
  @EventName("dataReceived")
  EventListener onDataReceived(EventHandler<DataReceived> eventListener);

  /** Fired when EventSource message is received. */
  @EventName("eventSourceMessageReceived")
  EventListener onEventSourceMessageReceived(
      EventHandler<EventSourceMessageReceived> eventListener);

  /** Fired when HTTP request has failed to load. */
  @EventName("loadingFailed")
  EventListener onLoadingFailed(EventHandler<LoadingFailed> eventListener);

  /** Fired when HTTP request has finished loading. */
  @EventName("loadingFinished")
  EventListener onLoadingFinished(EventHandler<LoadingFinished> eventListener);

  /**
   * Details of an intercepted HTTP request, which must be either allowed, blocked, modified or
   * mocked. Deprecated, use Fetch.requestPaused instead.
   */
  @EventName("requestIntercepted")
  @Deprecated
  @Experimental
  EventListener onRequestIntercepted(EventHandler<RequestIntercepted> eventListener);

  /** Fired if request ended up loading from cache. */
  @EventName("requestServedFromCache")
  EventListener onRequestServedFromCache(EventHandler<RequestServedFromCache> eventListener);

  /** Fired when page is about to send HTTP request. */
  @EventName("requestWillBeSent")
  EventListener onRequestWillBeSent(EventHandler<RequestWillBeSent> eventListener);

  /** Fired when resource loading priority is changed */
  @EventName("resourceChangedPriority")
  @Experimental
  EventListener onResourceChangedPriority(EventHandler<ResourceChangedPriority> eventListener);

  /** Fired when a signed exchange was received over the network */
  @EventName("signedExchangeReceived")
  @Experimental
  EventListener onSignedExchangeReceived(EventHandler<SignedExchangeReceived> eventListener);

  /** Fired when HTTP response is available. */
  @EventName("responseReceived")
  EventListener onResponseReceived(EventHandler<ResponseReceived> eventListener);

  /** Fired when WebSocket is closed. */
  @EventName("webSocketClosed")
  EventListener onWebSocketClosed(EventHandler<WebSocketClosed> eventListener);

  /** Fired upon WebSocket creation. */
  @EventName("webSocketCreated")
  EventListener onWebSocketCreated(EventHandler<WebSocketCreated> eventListener);

  /** Fired when WebSocket message error occurs. */
  @EventName("webSocketFrameError")
  EventListener onWebSocketFrameError(EventHandler<WebSocketFrameError> eventListener);

  /** Fired when WebSocket message is received. */
  @EventName("webSocketFrameReceived")
  EventListener onWebSocketFrameReceived(EventHandler<WebSocketFrameReceived> eventListener);

  /** Fired when WebSocket message is sent. */
  @EventName("webSocketFrameSent")
  EventListener onWebSocketFrameSent(EventHandler<WebSocketFrameSent> eventListener);

  /** Fired when WebSocket handshake response becomes available. */
  @EventName("webSocketHandshakeResponseReceived")
  EventListener onWebSocketHandshakeResponseReceived(
      EventHandler<WebSocketHandshakeResponseReceived> eventListener);

  /** Fired when WebSocket is about to initiate handshake. */
  @EventName("webSocketWillSendHandshakeRequest")
  EventListener onWebSocketWillSendHandshakeRequest(
      EventHandler<WebSocketWillSendHandshakeRequest> eventListener);

  /** Fired upon WebTransport creation. */
  @EventName("webTransportCreated")
  EventListener onWebTransportCreated(EventHandler<WebTransportCreated> eventListener);

  /** Fired when WebTransport handshake is finished. */
  @EventName("webTransportConnectionEstablished")
  EventListener onWebTransportConnectionEstablished(
      EventHandler<WebTransportConnectionEstablished> eventListener);

  /** Fired when WebTransport is disposed. */
  @EventName("webTransportClosed")
  EventListener onWebTransportClosed(EventHandler<WebTransportClosed> eventListener);

  /** Fired upon direct_socket.TCPSocket creation. */
  @EventName("directTCPSocketCreated")
  @Experimental
  EventListener onDirectTCPSocketCreated(EventHandler<DirectTCPSocketCreated> eventListener);

  /** Fired when direct_socket.TCPSocket connection is opened. */
  @EventName("directTCPSocketOpened")
  @Experimental
  EventListener onDirectTCPSocketOpened(EventHandler<DirectTCPSocketOpened> eventListener);

  /** Fired when direct_socket.TCPSocket is aborted. */
  @EventName("directTCPSocketAborted")
  @Experimental
  EventListener onDirectTCPSocketAborted(EventHandler<DirectTCPSocketAborted> eventListener);

  /** Fired when direct_socket.TCPSocket is closed. */
  @EventName("directTCPSocketClosed")
  @Experimental
  EventListener onDirectTCPSocketClosed(EventHandler<DirectTCPSocketClosed> eventListener);

  /** Fired when data is sent to tcp direct socket stream. */
  @EventName("directTCPSocketChunkSent")
  @Experimental
  EventListener onDirectTCPSocketChunkSent(EventHandler<DirectTCPSocketChunkSent> eventListener);

  /** Fired when data is received from tcp direct socket stream. */
  @EventName("directTCPSocketChunkReceived")
  @Experimental
  EventListener onDirectTCPSocketChunkReceived(
      EventHandler<DirectTCPSocketChunkReceived> eventListener);

  @EventName("directUDPSocketJoinedMulticastGroup")
  @Experimental
  EventListener onDirectUDPSocketJoinedMulticastGroup(
      EventHandler<DirectUDPSocketJoinedMulticastGroup> eventListener);

  @EventName("directUDPSocketLeftMulticastGroup")
  @Experimental
  EventListener onDirectUDPSocketLeftMulticastGroup(
      EventHandler<DirectUDPSocketLeftMulticastGroup> eventListener);

  /** Fired upon direct_socket.UDPSocket creation. */
  @EventName("directUDPSocketCreated")
  @Experimental
  EventListener onDirectUDPSocketCreated(EventHandler<DirectUDPSocketCreated> eventListener);

  /** Fired when direct_socket.UDPSocket connection is opened. */
  @EventName("directUDPSocketOpened")
  @Experimental
  EventListener onDirectUDPSocketOpened(EventHandler<DirectUDPSocketOpened> eventListener);

  /** Fired when direct_socket.UDPSocket is aborted. */
  @EventName("directUDPSocketAborted")
  @Experimental
  EventListener onDirectUDPSocketAborted(EventHandler<DirectUDPSocketAborted> eventListener);

  /** Fired when direct_socket.UDPSocket is closed. */
  @EventName("directUDPSocketClosed")
  @Experimental
  EventListener onDirectUDPSocketClosed(EventHandler<DirectUDPSocketClosed> eventListener);

  /** Fired when message is sent to udp direct socket stream. */
  @EventName("directUDPSocketChunkSent")
  @Experimental
  EventListener onDirectUDPSocketChunkSent(EventHandler<DirectUDPSocketChunkSent> eventListener);

  /** Fired when message is received from udp direct socket stream. */
  @EventName("directUDPSocketChunkReceived")
  @Experimental
  EventListener onDirectUDPSocketChunkReceived(
      EventHandler<DirectUDPSocketChunkReceived> eventListener);

  /**
   * Fired when additional information about a requestWillBeSent event is available from the network
   * stack. Not every requestWillBeSent event will have an additional requestWillBeSentExtraInfo
   * fired for it, and there is no guarantee whether requestWillBeSent or requestWillBeSentExtraInfo
   * will be fired first for the same request.
   */
  @EventName("requestWillBeSentExtraInfo")
  @Experimental
  EventListener onRequestWillBeSentExtraInfo(
      EventHandler<RequestWillBeSentExtraInfo> eventListener);

  /**
   * Fired when additional information about a responseReceived event is available from the network
   * stack. Not every responseReceived event will have an additional responseReceivedExtraInfo for
   * it, and responseReceivedExtraInfo may be fired before or after responseReceived.
   */
  @EventName("responseReceivedExtraInfo")
  @Experimental
  EventListener onResponseReceivedExtraInfo(EventHandler<ResponseReceivedExtraInfo> eventListener);

  /**
   * Fired when 103 Early Hints headers is received in addition to the common response. Not every
   * responseReceived event will have an responseReceivedEarlyHints fired. Only one
   * responseReceivedEarlyHints may be fired for eached responseReceived event.
   */
  @EventName("responseReceivedEarlyHints")
  @Experimental
  EventListener onResponseReceivedEarlyHints(
      EventHandler<ResponseReceivedEarlyHints> eventListener);

  /**
   * Fired exactly once for each Trust Token operation. Depending on the type of the operation and
   * whether the operation succeeded or failed, the event is fired before the corresponding request
   * was sent or after the response was received.
   */
  @EventName("trustTokenOperationDone")
  @Experimental
  EventListener onTrustTokenOperationDone(EventHandler<TrustTokenOperationDone> eventListener);

  /** Fired once security policy has been updated. */
  @EventName("policyUpdated")
  @Experimental
  EventListener onPolicyUpdated(EventHandler<PolicyUpdated> eventListener);

  /**
   * Is sent whenever a new report is added. And after 'enableReportingApi' for all existing
   * reports.
   */
  @EventName("reportingApiReportAdded")
  @Experimental
  EventListener onReportingApiReportAdded(EventHandler<ReportingApiReportAdded> eventListener);

  @EventName("reportingApiReportUpdated")
  @Experimental
  EventListener onReportingApiReportUpdated(EventHandler<ReportingApiReportUpdated> eventListener);

  @EventName("reportingApiEndpointsChangedForOrigin")
  @Experimental
  EventListener onReportingApiEndpointsChangedForOrigin(
      EventHandler<ReportingApiEndpointsChangedForOrigin> eventListener);

  /** Triggered when the initial set of device bound sessions is added. */
  @EventName("deviceBoundSessionsAdded")
  @Experimental
  EventListener onDeviceBoundSessionsAdded(EventHandler<DeviceBoundSessionsAdded> eventListener);

  /** Triggered when a device bound session event occurs. */
  @EventName("deviceBoundSessionEventOccurred")
  @Experimental
  EventListener onDeviceBoundSessionEventOccurred(
      EventHandler<DeviceBoundSessionEventOccurred> eventListener);
}
