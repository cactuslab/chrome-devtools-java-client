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

import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;

/** Parameters for the continueToLocation command. */
public class ContinueToLocationParameters {

  @ParamName("location")
  private Location location;

  @Optional
  @ParamName("targetCallFrames")
  private ContinueToLocationTargetCallFrames targetCallFrames;

  /** Location to continue to. */
  public Location getLocation() {
    return location;
  }

  /** Location to continue to. */
  public ContinueToLocationParameters setLocation(Location location) {
    this.location = location;
    return this;
  }

  public ContinueToLocationTargetCallFrames getTargetCallFrames() {
    return targetCallFrames;
  }

  public ContinueToLocationParameters setTargetCallFrames(
      ContinueToLocationTargetCallFrames targetCallFrames) {
    this.targetCallFrames = targetCallFrames;
    return this;
  }
}
