package com.github.kklisura.cdt.protocol.types.smartcardemulation;

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

/** Parameters for the reportStatusResult command. */
public class ReportStatusResultParameters {

  @ParamName("requestId")
  private String requestId;

  @ParamName("readerName")
  private String readerName;

  @ParamName("state")
  private ConnectionState state;

  @ParamName("atr")
  private String atr;

  @Optional
  @ParamName("protocol")
  private Protocol protocol;

  public String getRequestId() {
    return requestId;
  }

  public ReportStatusResultParameters setRequestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

  public String getReaderName() {
    return readerName;
  }

  public ReportStatusResultParameters setReaderName(String readerName) {
    this.readerName = readerName;
    return this;
  }

  public ConnectionState getState() {
    return state;
  }

  public ReportStatusResultParameters setState(ConnectionState state) {
    this.state = state;
    return this;
  }

  public String getAtr() {
    return atr;
  }

  public ReportStatusResultParameters setAtr(String atr) {
    this.atr = atr;
    return this;
  }

  public Protocol getProtocol() {
    return protocol;
  }

  public ReportStatusResultParameters setProtocol(Protocol protocol) {
    this.protocol = protocol;
    return this;
  }
}
