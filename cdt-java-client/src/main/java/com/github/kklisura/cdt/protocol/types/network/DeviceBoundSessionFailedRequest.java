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

import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;

/** Details about a failed device bound session network request. */
@Experimental
public class DeviceBoundSessionFailedRequest {

  private String requestUrl;

  @Optional private String netError;

  @Optional private Integer responseError;

  @Optional private String responseErrorBody;

  /** The failed request URL. */
  public String getRequestUrl() {
    return requestUrl;
  }

  /** The failed request URL. */
  public void setRequestUrl(String requestUrl) {
    this.requestUrl = requestUrl;
  }

  /** The net error of the response if it was not OK. */
  public String getNetError() {
    return netError;
  }

  /** The net error of the response if it was not OK. */
  public void setNetError(String netError) {
    this.netError = netError;
  }

  /** The response code if the net error was OK and the response code was not 200. */
  public Integer getResponseError() {
    return responseError;
  }

  /** The response code if the net error was OK and the response code was not 200. */
  public void setResponseError(Integer responseError) {
    this.responseError = responseError;
  }

  /**
   * The body of the response if the net error was OK, the response code was not 200, and the
   * response body was not empty.
   */
  public String getResponseErrorBody() {
    return responseErrorBody;
  }

  /**
   * The body of the response if the net error was OK, the response code was not 200, and the
   * response body was not empty.
   */
  public void setResponseErrorBody(String responseErrorBody) {
    this.responseErrorBody = responseErrorBody;
  }
}
