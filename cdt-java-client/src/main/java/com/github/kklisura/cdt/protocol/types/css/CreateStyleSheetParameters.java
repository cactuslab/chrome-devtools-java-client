package com.github.kklisura.cdt.protocol.types.css;

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

/** Parameters for the createStyleSheet command. */
public class CreateStyleSheetParameters {

  @ParamName("frameId")
  private String frameId;

  @Optional
  @ParamName("force")
  private Boolean force;

  /** Identifier of the frame where "via-inspector" stylesheet should be created. */
  public String getFrameId() {
    return frameId;
  }

  /** Identifier of the frame where "via-inspector" stylesheet should be created. */
  public CreateStyleSheetParameters setFrameId(String frameId) {
    this.frameId = frameId;
    return this;
  }

  /**
   * If true, creates a new stylesheet for every call. If false, returns a stylesheet previously
   * created by a call with force=false for the frame's document if it exists or creates a new
   * stylesheet (default: false).
   */
  public Boolean getForce() {
    return force;
  }

  /**
   * If true, creates a new stylesheet for every call. If false, returns a stylesheet previously
   * created by a call with force=false for the frame's document if it exists or creates a new
   * stylesheet (default: false).
   */
  public CreateStyleSheetParameters setForce(Boolean force) {
    this.force = force;
    return this;
  }
}
