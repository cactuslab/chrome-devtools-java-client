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

/** Parameters for the openDevTools command. */
public class OpenDevToolsParameters {

  @ParamName("targetId")
  private String targetId;

  @Optional
  @ParamName("panelId")
  private String panelId;

  /** This can be the page or tab target ID. */
  public String getTargetId() {
    return targetId;
  }

  /** This can be the page or tab target ID. */
  public OpenDevToolsParameters setTargetId(String targetId) {
    this.targetId = targetId;
    return this;
  }

  /**
   * The id of the panel we want DevTools to open initially. Currently supported panels are
   * elements, console, network, sources, resources and performance.
   */
  public String getPanelId() {
    return panelId;
  }

  /**
   * The id of the panel we want DevTools to open initially. Currently supported panels are
   * elements, console, network, sources, resources and performance.
   */
  public OpenDevToolsParameters setPanelId(String panelId) {
    this.panelId = panelId;
    return this;
  }
}
