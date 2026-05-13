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

@Experimental
public class DirectUDPMessage {

  private String data;

  @Optional private String remoteAddr;

  @Optional private Integer remotePort;

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  /** Null for connected mode. */
  public String getRemoteAddr() {
    return remoteAddr;
  }

  /** Null for connected mode. */
  public void setRemoteAddr(String remoteAddr) {
    this.remoteAddr = remoteAddr;
  }

  /** Null for connected mode. Expected to be unsigned integer. */
  public Integer getRemotePort() {
    return remotePort;
  }

  /** Null for connected mode. Expected to be unsigned integer. */
  public void setRemotePort(Integer remotePort) {
    this.remotePort = remotePort;
  }
}
