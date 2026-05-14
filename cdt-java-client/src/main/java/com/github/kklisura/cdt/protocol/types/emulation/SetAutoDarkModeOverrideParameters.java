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

/** Parameters for the setAutoDarkModeOverride command. */
public class SetAutoDarkModeOverrideParameters {

  @Optional
  @ParamName("enabled")
  private Boolean enabled;

  /**
   * Whether to enable or disable automatic dark mode. If not specified, any existing override will
   * be cleared.
   */
  public Boolean getEnabled() {
    return enabled;
  }

  /**
   * Whether to enable or disable automatic dark mode. If not specified, any existing override will
   * be cleared.
   */
  public SetAutoDarkModeOverrideParameters setEnabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }
}
