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

/** Parameters for the setScriptSource command. */
public class SetScriptSourceParameters {

  @ParamName("scriptId")
  private String scriptId;

  @ParamName("scriptSource")
  private String scriptSource;

  @Optional
  @ParamName("dryRun")
  private Boolean dryRun;

  @Experimental
  @Optional
  @ParamName("allowTopFrameEditing")
  private Boolean allowTopFrameEditing;

  /** Id of the script to edit. */
  public String getScriptId() {
    return scriptId;
  }

  /** Id of the script to edit. */
  public SetScriptSourceParameters setScriptId(String scriptId) {
    this.scriptId = scriptId;
    return this;
  }

  /** New content of the script. */
  public String getScriptSource() {
    return scriptSource;
  }

  /** New content of the script. */
  public SetScriptSourceParameters setScriptSource(String scriptSource) {
    this.scriptSource = scriptSource;
    return this;
  }

  /**
   * If true the change will not actually be applied. Dry run may be used to get result description
   * without actually modifying the code.
   */
  public Boolean getDryRun() {
    return dryRun;
  }

  /**
   * If true the change will not actually be applied. Dry run may be used to get result description
   * without actually modifying the code.
   */
  public SetScriptSourceParameters setDryRun(Boolean dryRun) {
    this.dryRun = dryRun;
    return this;
  }

  /**
   * If true, then `scriptSource` is allowed to change the function on top of the stack as long as
   * the top-most stack frame is the only activation of that function.
   */
  public Boolean getAllowTopFrameEditing() {
    return allowTopFrameEditing;
  }

  /**
   * If true, then `scriptSource` is allowed to change the function on top of the stack as long as
   * the top-most stack frame is the only activation of that function.
   */
  public SetScriptSourceParameters setAllowTopFrameEditing(Boolean allowTopFrameEditing) {
    this.allowTopFrameEditing = allowTopFrameEditing;
    return this;
  }
}
