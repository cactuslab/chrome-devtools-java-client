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
import com.github.kklisura.cdt.protocol.types.smartcardemulation.Protocol;

/**
 * Fired when |SCardTransmit| is called.
 *
 * <p>This maps to: PC/SC Lite:
 * https://pcsclite.apdu.fr/api/group__API.html#ga9a2d77242a271310269065e64633ab99 Microsoft:
 * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardtransmit
 */
public class TransmitRequested {

  private String requestId;

  private Integer handle;

  private String data;

  @Optional private Protocol protocol;

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public Integer getHandle() {
    return handle;
  }

  public void setHandle(Integer handle) {
    this.handle = handle;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Protocol getProtocol() {
    return protocol;
  }

  public void setProtocol(Protocol protocol) {
    this.protocol = protocol;
  }
}
