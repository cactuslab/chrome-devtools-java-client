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

import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;

/** Parameters for the reload command. */
public class ReloadParameters {

  @Optional
  @ParamName("ignoreCache")
  private Boolean ignoreCache;

  @Optional
  @ParamName("scriptToEvaluateOnLoad")
  private String scriptToEvaluateOnLoad;

  @Experimental
  @Optional
  @ParamName("loaderId")
  private String loaderId;

  /** If true, browser cache is ignored (as if the user pressed Shift+refresh). */
  public Boolean getIgnoreCache() {
    return ignoreCache;
  }

  /** If true, browser cache is ignored (as if the user pressed Shift+refresh). */
  public ReloadParameters setIgnoreCache(Boolean ignoreCache) {
    this.ignoreCache = ignoreCache;
    return this;
  }

  /**
   * If set, the script will be injected into all frames of the inspected page after reload.
   * Argument will be ignored if reloading dataURL origin.
   */
  public String getScriptToEvaluateOnLoad() {
    return scriptToEvaluateOnLoad;
  }

  /**
   * If set, the script will be injected into all frames of the inspected page after reload.
   * Argument will be ignored if reloading dataURL origin.
   */
  public ReloadParameters setScriptToEvaluateOnLoad(String scriptToEvaluateOnLoad) {
    this.scriptToEvaluateOnLoad = scriptToEvaluateOnLoad;
    return this;
  }

  /**
   * If set, an error will be thrown if the target page's main frame's loader id does not match the
   * provided id. This prevents accidentally reloading an unintended target in case there's a racing
   * navigation.
   */
  public String getLoaderId() {
    return loaderId;
  }

  /**
   * If set, an error will be thrown if the target page's main frame's loader id does not match the
   * provided id. This prevents accidentally reloading an unintended target in case there's a racing
   * navigation.
   */
  public ReloadParameters setLoaderId(String loaderId) {
    this.loaderId = loaderId;
    return this;
  }
}
