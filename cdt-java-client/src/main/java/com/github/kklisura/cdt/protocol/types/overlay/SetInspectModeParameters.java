package com.github.kklisura.cdt.protocol.types.overlay;

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

/** Parameters for the setInspectMode command. */
public class SetInspectModeParameters {

  @ParamName("mode")
  private InspectMode mode;

  @Optional
  @ParamName("highlightConfig")
  private HighlightConfig highlightConfig;

  /** Set an inspection mode. */
  public InspectMode getMode() {
    return mode;
  }

  /** Set an inspection mode. */
  public SetInspectModeParameters setMode(InspectMode mode) {
    this.mode = mode;
    return this;
  }

  /**
   * A descriptor for the highlight appearance of hovered-over nodes. May be omitted if `enabled ==
   * false`.
   */
  public HighlightConfig getHighlightConfig() {
    return highlightConfig;
  }

  /**
   * A descriptor for the highlight appearance of hovered-over nodes. May be omitted if `enabled ==
   * false`.
   */
  public SetInspectModeParameters setHighlightConfig(HighlightConfig highlightConfig) {
    this.highlightConfig = highlightConfig;
    return this;
  }
}
