package com.github.kklisura.cdt.protocol.types.emulation;

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

/** Parameters for the setTouchEmulationEnabled command. */
public class SetTouchEmulationEnabledParameters {

  @ParamName("enabled")
  private Boolean enabled;

  @Optional
  @ParamName("maxTouchPoints")
  private Integer maxTouchPoints;

  /** Whether the touch event emulation should be enabled. */
  public Boolean getEnabled() {
    return enabled;
  }

  /** Whether the touch event emulation should be enabled. */
  public SetTouchEmulationEnabledParameters setEnabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  /** Maximum touch points supported. Defaults to one. */
  public Integer getMaxTouchPoints() {
    return maxTouchPoints;
  }

  /** Maximum touch points supported. Defaults to one. */
  public SetTouchEmulationEnabledParameters setMaxTouchPoints(Integer maxTouchPoints) {
    this.maxTouchPoints = maxTouchPoints;
    return this;
  }
}
