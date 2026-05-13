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

import com.fasterxml.jackson.annotation.JsonProperty;

/** How the session was used (or not used). */
public enum DeviceBoundSessionWithUsageUsage {
  @JsonProperty("NotInScope")
  NOT_IN_SCOPE,
  @JsonProperty("InScopeRefreshNotYetNeeded")
  IN_SCOPE_REFRESH_NOT_YET_NEEDED,
  @JsonProperty("InScopeRefreshNotAllowed")
  IN_SCOPE_REFRESH_NOT_ALLOWED,
  @JsonProperty("ProactiveRefreshNotPossible")
  PROACTIVE_REFRESH_NOT_POSSIBLE,
  @JsonProperty("ProactiveRefreshAttempted")
  PROACTIVE_REFRESH_ATTEMPTED,
  @JsonProperty("Deferred")
  DEFERRED
}
