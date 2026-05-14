package com.github.kklisura.cdt.protocol.types.fetch;

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

import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;
import java.util.List;

/** Parameters for the continueRequest command. */
public class ContinueRequestParameters {

  @ParamName("requestId")
  private String requestId;

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
  private List<HeaderEntry> headers;

  @Experimental
  @Optional
  @ParamName("interceptResponse")
  private Boolean interceptResponse;

  /** An id the client received in requestPaused event. */
  public String getRequestId() {
    return requestId;
  }

  /** An id the client received in requestPaused event. */
  public ContinueRequestParameters setRequestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

  /** If set, the request url will be modified in a way that's not observable by page. */
  public String getUrl() {
    return url;
  }

  /** If set, the request url will be modified in a way that's not observable by page. */
  public ContinueRequestParameters setUrl(String url) {
    this.url = url;
    return this;
  }

  /** If set, the request method is overridden. */
  public String getMethod() {
    return method;
  }

  /** If set, the request method is overridden. */
  public ContinueRequestParameters setMethod(String method) {
    this.method = method;
    return this;
  }

  /**
   * If set, overrides the post data in the request. (Encoded as a base64 string when passed over
   * JSON)
   */
  public String getPostData() {
    return postData;
  }

  /**
   * If set, overrides the post data in the request. (Encoded as a base64 string when passed over
   * JSON)
   */
  public ContinueRequestParameters setPostData(String postData) {
    this.postData = postData;
    return this;
  }

  /**
   * If set, overrides the request headers. Note that the overrides do not extend to subsequent
   * redirect hops, if a redirect happens. Another override may be applied to a different request
   * produced by a redirect.
   */
  public List<HeaderEntry> getHeaders() {
    return headers;
  }

  /**
   * If set, overrides the request headers. Note that the overrides do not extend to subsequent
   * redirect hops, if a redirect happens. Another override may be applied to a different request
   * produced by a redirect.
   */
  public ContinueRequestParameters setHeaders(List<HeaderEntry> headers) {
    this.headers = headers;
    return this;
  }

  /** If set, overrides response interception behavior for this request. */
  public Boolean getInterceptResponse() {
    return interceptResponse;
  }

  /** If set, overrides response interception behavior for this request. */
  public ContinueRequestParameters setInterceptResponse(Boolean interceptResponse) {
    this.interceptResponse = interceptResponse;
    return this;
  }
}
