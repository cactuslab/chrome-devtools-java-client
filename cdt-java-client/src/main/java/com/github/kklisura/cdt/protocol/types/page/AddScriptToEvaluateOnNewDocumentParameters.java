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

/** Parameters for the addScriptToEvaluateOnNewDocument command. */
public class AddScriptToEvaluateOnNewDocumentParameters {

  @ParamName("source")
  private String source;

  @Experimental
  @Optional
  @ParamName("worldName")
  private String worldName;

  @Experimental
  @Optional
  @ParamName("includeCommandLineAPI")
  private Boolean includeCommandLineAPI;

  @Experimental
  @Optional
  @ParamName("runImmediately")
  private Boolean runImmediately;

  public String getSource() {
    return source;
  }

  public AddScriptToEvaluateOnNewDocumentParameters setSource(String source) {
    this.source = source;
    return this;
  }

  /**
   * If specified, creates an isolated world with the given name and evaluates given script in it.
   * This world name will be used as the ExecutionContextDescription::name when the corresponding
   * event is emitted.
   */
  public String getWorldName() {
    return worldName;
  }

  /**
   * If specified, creates an isolated world with the given name and evaluates given script in it.
   * This world name will be used as the ExecutionContextDescription::name when the corresponding
   * event is emitted.
   */
  public AddScriptToEvaluateOnNewDocumentParameters setWorldName(String worldName) {
    this.worldName = worldName;
    return this;
  }

  /** Specifies whether command line API should be available to the script, defaults to false. */
  public Boolean getIncludeCommandLineAPI() {
    return includeCommandLineAPI;
  }

  /** Specifies whether command line API should be available to the script, defaults to false. */
  public AddScriptToEvaluateOnNewDocumentParameters setIncludeCommandLineAPI(
      Boolean includeCommandLineAPI) {
    this.includeCommandLineAPI = includeCommandLineAPI;
    return this;
  }

  /**
   * If true, runs the script immediately on existing execution contexts or worlds. Default: false.
   */
  public Boolean getRunImmediately() {
    return runImmediately;
  }

  /**
   * If true, runs the script immediately on existing execution contexts or worlds. Default: false.
   */
  public AddScriptToEvaluateOnNewDocumentParameters setRunImmediately(Boolean runImmediately) {
    this.runImmediately = runImmediately;
    return this;
  }
}
