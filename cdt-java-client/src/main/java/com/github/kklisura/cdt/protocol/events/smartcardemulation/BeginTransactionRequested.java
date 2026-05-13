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

/**
 * Fired when |SCardBeginTransaction| is called.
 *
 * <p>This maps to: PC/SC Lite:
 * https://pcsclite.apdu.fr/api/group__API.html#gaddb835dce01a0da1d6ca02d33ee7d861 Microsoft:
 * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardbegintransaction
 */
public class BeginTransactionRequested {

  private String requestId;

  private Integer handle;

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
}
