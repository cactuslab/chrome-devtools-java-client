package com.github.kklisura.cdt.protocol.types.network;

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

import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;
import java.util.Map;

/** Parameters for the continueInterceptedRequest command. */
public class ContinueInterceptedRequestParameters {

  @ParamName("interceptionId")
  private String interceptionId;

  @Optional
  @ParamName("errorReason")
  private ErrorReason errorReason;

  @Optional
  @ParamName("rawResponse")
  private String rawResponse;

  @Optional
  @ParamName("url")
  private String url;

  @Optional
  @ParamName("method")
  private String method;

  @Optional
  @ParamName("postData")
  private String postData;

  @Optional
  @ParamName("headers")
  private Map<String, Object> headers;

  @Optional
  @ParamName("authChallengeResponse")
  private AuthChallengeResponse authChallengeResponse;

  public String getInterceptionId() {
    return interceptionId;
  }

  public ContinueInterceptedRequestParameters setInterceptionId(String interceptionId) {
    this.interceptionId = interceptionId;
    return this;
  }

  /**
   * If set this causes the request to fail with the given reason. Passing `Aborted` for requests
   * marked with `isNavigationRequest` also cancels the navigation. Must not be set in response to
   * an authChallenge.
   */
  public ErrorReason getErrorReason() {
    return errorReason;
  }

  /**
   * If set this causes the request to fail with the given reason. Passing `Aborted` for requests
   * marked with `isNavigationRequest` also cancels the navigation. Must not be set in response to
   * an authChallenge.
   */
  public ContinueInterceptedRequestParameters setErrorReason(ErrorReason errorReason) {
    this.errorReason = errorReason;
    return this;
  }

  /**
   * If set the requests completes using with the provided base64 encoded raw response, including
   * HTTP status line and headers etc... Must not be set in response to an authChallenge. (Encoded
   * as a base64 string when passed over JSON)
   */
  public String getRawResponse() {
    return rawResponse;
  }

  /**
   * If set the requests completes using with the provided base64 encoded raw response, including
   * HTTP status line and headers etc... Must not be set in response to an authChallenge. (Encoded
   * as a base64 string when passed over JSON)
   */
  public ContinueInterceptedRequestParameters setRawResponse(String rawResponse) {
    this.rawResponse = rawResponse;
    return this;
  }

  /**
   * If set the request url will be modified in a way that's not observable by page. Must not be set
   * in response to an authChallenge.
   */
  public String getUrl() {
    return url;
  }

  /**
   * If set the request url will be modified in a way that's not observable by page. Must not be set
   * in response to an authChallenge.
   */
  public ContinueInterceptedRequestParameters setUrl(String url) {
    this.url = url;
    return this;
  }

  /**
   * If set this allows the request method to be overridden. Must not be set in response to an
   * authChallenge.
   */
  public String getMethod() {
    return method;
  }

  /**
   * If set this allows the request method to be overridden. Must not be set in response to an
   * authChallenge.
   */
  public ContinueInterceptedRequestParameters setMethod(String method) {
    this.method = method;
    return this;
  }

  /** If set this allows postData to be set. Must not be set in response to an authChallenge. */
  public String getPostData() {
    return postData;
  }

  /** If set this allows postData to be set. Must not be set in response to an authChallenge. */
  public ContinueInterceptedRequestParameters setPostData(String postData) {
    this.postData = postData;
    return this;
  }

  /**
   * If set this allows the request headers to be changed. Must not be set in response to an
   * authChallenge.
   */
  public Map<String, Object> getHeaders() {
    return headers;
  }

  /**
   * If set this allows the request headers to be changed. Must not be set in response to an
   * authChallenge.
   */
  public ContinueInterceptedRequestParameters setHeaders(Map<String, Object> headers) {
    this.headers = headers;
    return this;
  }

  /** Response to a requestIntercepted with an authChallenge. Must not be set otherwise. */
  public AuthChallengeResponse getAuthChallengeResponse() {
    return authChallengeResponse;
  }

  /** Response to a requestIntercepted with an authChallenge. Must not be set otherwise. */
  public ContinueInterceptedRequestParameters setAuthChallengeResponse(
      AuthChallengeResponse authChallengeResponse) {
    this.authChallengeResponse = authChallengeResponse;
    return this;
  }
}
