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

import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;

/** Parameters for the createIsolatedWorld command. */
public class CreateIsolatedWorldParameters {

  @ParamName("frameId")
  private String frameId;

  @Optional
  @ParamName("worldName")
  private String worldName;

  @Optional
  @ParamName("grantUniveralAccess")
  private Boolean grantUniveralAccess;

  /** Id of the frame in which the isolated world should be created. */
  public String getFrameId() {
    return frameId;
  }

  /** Id of the frame in which the isolated world should be created. */
  public CreateIsolatedWorldParameters setFrameId(String frameId) {
    this.frameId = frameId;
    return this;
  }

  /** An optional name which is reported in the Execution Context. */
  public String getWorldName() {
    return worldName;
  }

  /** An optional name which is reported in the Execution Context. */
  public CreateIsolatedWorldParameters setWorldName(String worldName) {
    this.worldName = worldName;
    return this;
  }

  /**
   * Whether or not universal access should be granted to the isolated world. This is a powerful
   * option, use with caution.
   */
  public Boolean getGrantUniveralAccess() {
    return grantUniveralAccess;
  }

  /**
   * Whether or not universal access should be granted to the isolated world. This is a powerful
   * option, use with caution.
   */
  public CreateIsolatedWorldParameters setGrantUniveralAccess(Boolean grantUniveralAccess) {
    this.grantUniveralAccess = grantUniveralAccess;
    return this;
  }
}
