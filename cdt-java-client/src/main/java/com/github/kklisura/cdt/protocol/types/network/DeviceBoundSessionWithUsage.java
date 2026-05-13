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

/** How a device bound session was used during a request. */
@Experimental
public class DeviceBoundSessionWithUsage {

  private DeviceBoundSessionKey sessionKey;

  private DeviceBoundSessionWithUsageUsage usage;

  /** The key for the session. */
  public DeviceBoundSessionKey getSessionKey() {
    return sessionKey;
  }

  /** The key for the session. */
  public void setSessionKey(DeviceBoundSessionKey sessionKey) {
    this.sessionKey = sessionKey;
  }

  /** How the session was used (or not used). */
  public DeviceBoundSessionWithUsageUsage getUsage() {
    return usage;
  }

  /** How the session was used (or not used). */
  public void setUsage(DeviceBoundSessionWithUsageUsage usage) {
    this.usage = usage;
  }
}
