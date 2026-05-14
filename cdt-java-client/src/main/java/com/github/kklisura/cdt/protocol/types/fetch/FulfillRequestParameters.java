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

import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;
import java.util.List;

/** Parameters for the fulfillRequest command. */
public class FulfillRequestParameters {

  @ParamName("requestId")
  private String requestId;

  @ParamName("responseCode")
  private Integer responseCode;

  @Optional
  @ParamName("responseHeaders")
  private List<HeaderEntry> responseHeaders;

  @Optional
  @ParamName("binaryResponseHeaders")
  private String binaryResponseHeaders;

  @Optional
  @ParamName("body")
  private String body;

  @Optional
  @ParamName("responsePhrase")
  private String responsePhrase;

  /** An id the client received in requestPaused event. */
  public String getRequestId() {
    return requestId;
  }

  /** An id the client received in requestPaused event. */
  public FulfillRequestParameters setRequestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

  /** An HTTP response code. */
  public Integer getResponseCode() {
    return responseCode;
  }

  /** An HTTP response code. */
  public FulfillRequestParameters setResponseCode(Integer responseCode) {
    this.responseCode = responseCode;
    return this;
  }

  /** Response headers. */
  public List<HeaderEntry> getResponseHeaders() {
    return responseHeaders;
  }

  /** Response headers. */
  public FulfillRequestParameters setResponseHeaders(List<HeaderEntry> responseHeaders) {
    this.responseHeaders = responseHeaders;
    return this;
  }

  /**
   * Alternative way of specifying response headers as a \0-separated series of name: value pairs.
   * Prefer the above method unless you need to represent some non-UTF8 values that can't be
   * transmitted over the protocol as text. (Encoded as a base64 string when passed over JSON)
   */
  public String getBinaryResponseHeaders() {
    return binaryResponseHeaders;
  }

  /**
   * Alternative way of specifying response headers as a \0-separated series of name: value pairs.
   * Prefer the above method unless you need to represent some non-UTF8 values that can't be
   * transmitted over the protocol as text. (Encoded as a base64 string when passed over JSON)
   */
  public FulfillRequestParameters setBinaryResponseHeaders(String binaryResponseHeaders) {
    this.binaryResponseHeaders = binaryResponseHeaders;
    return this;
  }

  /**
   * A response body. If absent, original response body will be used if the request is intercepted
   * at the response stage and empty body will be used if the request is intercepted at the request
   * stage. (Encoded as a base64 string when passed over JSON)
   */
  public String getBody() {
    return body;
  }

  /**
   * A response body. If absent, original response body will be used if the request is intercepted
   * at the response stage and empty body will be used if the request is intercepted at the request
   * stage. (Encoded as a base64 string when passed over JSON)
   */
  public FulfillRequestParameters setBody(String body) {
    this.body = body;
    return this;
  }

  /**
   * A textual representation of responseCode. If absent, a standard phrase matching responseCode is
   * used.
   */
  public String getResponsePhrase() {
    return responsePhrase;
  }

  /**
   * A textual representation of responseCode. If absent, a standard phrase matching responseCode is
   * used.
   */
  public FulfillRequestParameters setResponsePhrase(String responsePhrase) {
    this.responsePhrase = responsePhrase;
    return this;
  }
}
