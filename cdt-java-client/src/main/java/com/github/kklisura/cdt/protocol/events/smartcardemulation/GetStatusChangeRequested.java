package com.github.kklisura.cdt.protocol.events.smartcardemulation;

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
import com.github.kklisura.cdt.protocol.types.smartcardemulation.ReaderStateIn;
import java.util.List;

/**
 * Fired when |SCardGetStatusChange| is called. Timeout is specified in milliseconds.
 *
 * <p>This maps to: PC/SC Lite:
 * https://pcsclite.apdu.fr/api/group__API.html#ga33247d5d1257d59e55647c3bb717db24 Microsoft:
 * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardgetstatuschangea
 */
public class GetStatusChangeRequested {

  private String requestId;

  private Integer contextId;

  private List<ReaderStateIn> readerStates;

  @Optional private Integer timeout;

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public Integer getContextId() {
    return contextId;
  }

  public void setContextId(Integer contextId) {
    this.contextId = contextId;
  }

  public List<ReaderStateIn> getReaderStates() {
    return readerStates;
  }

  public void setReaderStates(List<ReaderStateIn> readerStates) {
    this.readerStates = readerStates;
  }

  /** in milliseconds, if absent, it means "infinite" */
  public Integer getTimeout() {
    return timeout;
  }

  /** in milliseconds, if absent, it means "infinite" */
  public void setTimeout(Integer timeout) {
    this.timeout = timeout;
  }
}
