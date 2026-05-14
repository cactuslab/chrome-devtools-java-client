package com.github.kklisura.cdt.protocol.types.target;

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

/** Parameters for the detachFromTarget command. */
public class DetachFromTargetParameters {

  @Optional
  @ParamName("sessionId")
  private String sessionId;

  @Deprecated
  @Optional
  @ParamName("targetId")
  private String targetId;

  /** Session to detach. */
  public String getSessionId() {
    return sessionId;
  }

  /** Session to detach. */
  public DetachFromTargetParameters setSessionId(String sessionId) {
    this.sessionId = sessionId;
    return this;
  }

  /** Deprecated. */
  public String getTargetId() {
    return targetId;
  }

  /** Deprecated. */
  public DetachFromTargetParameters setTargetId(String targetId) {
    this.targetId = targetId;
    return this;
  }
}
