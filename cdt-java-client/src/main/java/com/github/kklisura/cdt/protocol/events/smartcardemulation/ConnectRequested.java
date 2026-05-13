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

import com.github.kklisura.cdt.protocol.types.smartcardemulation.ProtocolSet;
import com.github.kklisura.cdt.protocol.types.smartcardemulation.ShareMode;

/**
 * Fired when |SCardConnect| is called.
 *
 * <p>This maps to: PC/SC Lite:
 * https://pcsclite.apdu.fr/api/group__API.html#ga4e515829752e0a8dbc4d630696a8d6a5 Microsoft:
 * https://learn.microsoft.com/en-us/windows/win32/api/winscard/nf-winscard-scardconnecta
 */
public class ConnectRequested {

  private String requestId;

  private Integer contextId;

  private String reader;

  private ShareMode shareMode;

  private ProtocolSet preferredProtocols;

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

  public String getReader() {
    return reader;
  }

  public void setReader(String reader) {
    this.reader = reader;
  }

  public ShareMode getShareMode() {
    return shareMode;
  }

  public void setShareMode(ShareMode shareMode) {
    this.shareMode = shareMode;
  }

  public ProtocolSet getPreferredProtocols() {
    return preferredProtocols;
  }

  public void setPreferredProtocols(ProtocolSet preferredProtocols) {
    this.preferredProtocols = preferredProtocols;
  }
}
