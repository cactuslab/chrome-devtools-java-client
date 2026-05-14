package com.github.kklisura.cdt.protocol.types.debugger;

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
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;

/** Parameters for the restartFrame command. */
public class RestartFrameParameters {

  @ParamName("callFrameId")
  private String callFrameId;

  @Experimental
  @Optional
  @ParamName("mode")
  private RestartFrameMode mode;

  /** Call frame identifier to evaluate on. */
  public String getCallFrameId() {
    return callFrameId;
  }

  /** Call frame identifier to evaluate on. */
  public RestartFrameParameters setCallFrameId(String callFrameId) {
    this.callFrameId = callFrameId;
    return this;
  }

  /**
   * The `mode` parameter must be present and set to 'StepInto', otherwise `restartFrame` will error
   * out.
   */
  public RestartFrameMode getMode() {
    return mode;
  }

  /**
   * The `mode` parameter must be present and set to 'StepInto', otherwise `restartFrame` will error
   * out.
   */
  public RestartFrameParameters setMode(RestartFrameMode mode) {
    this.mode = mode;
    return this;
  }
}
