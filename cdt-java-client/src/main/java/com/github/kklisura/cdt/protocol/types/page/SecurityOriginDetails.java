package com.github.kklisura.cdt.protocol.types.page;

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

/** Additional information about the frame document's security origin. */
@Experimental
public class SecurityOriginDetails {

  private Boolean isLocalhost;

  /**
   * Indicates whether the frame document's security origin is one of the local hostnames (e.g.
   * "localhost") or IP addresses (IPv4 127.0.0.0/8 or IPv6 ::1).
   */
  public Boolean getIsLocalhost() {
    return isLocalhost;
  }

  /**
   * Indicates whether the frame document's security origin is one of the local hostnames (e.g.
   * "localhost") or IP addresses (IPv4 127.0.0.0/8 or IPv6 ::1).
   */
  public void setIsLocalhost(Boolean isLocalhost) {
    this.isLocalhost = isLocalhost;
  }
}
