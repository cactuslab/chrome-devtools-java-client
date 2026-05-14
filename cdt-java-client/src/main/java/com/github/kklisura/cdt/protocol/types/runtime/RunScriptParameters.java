package com.github.kklisura.cdt.protocol.types.runtime;

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

/** Parameters for the runScript command. */
public class RunScriptParameters {

  @ParamName("scriptId")
  private String scriptId;

  @Optional
  @ParamName("executionContextId")
  private Integer executionContextId;

  @Optional
  @ParamName("objectGroup")
  private String objectGroup;

  @Optional
  @ParamName("silent")
  private Boolean silent;

  @Optional
  @ParamName("includeCommandLineAPI")
  private Boolean includeCommandLineAPI;

  @Optional
  @ParamName("returnByValue")
  private Boolean returnByValue;

  @Optional
  @ParamName("generatePreview")
  private Boolean generatePreview;

  @Optional
  @ParamName("awaitPromise")
  private Boolean awaitPromise;

  /** Id of the script to run. */
  public String getScriptId() {
    return scriptId;
  }

  /** Id of the script to run. */
  public RunScriptParameters setScriptId(String scriptId) {
    this.scriptId = scriptId;
    return this;
  }

  /**
   * Specifies in which execution context to perform script run. If the parameter is omitted the
   * evaluation will be performed in the context of the inspected page.
   */
  public Integer getExecutionContextId() {
    return executionContextId;
  }

  /**
   * Specifies in which execution context to perform script run. If the parameter is omitted the
   * evaluation will be performed in the context of the inspected page.
   */
  public RunScriptParameters setExecutionContextId(Integer executionContextId) {
    this.executionContextId = executionContextId;
    return this;
  }

  /** Symbolic group name that can be used to release multiple objects. */
  public String getObjectGroup() {
    return objectGroup;
  }

  /** Symbolic group name that can be used to release multiple objects. */
  public RunScriptParameters setObjectGroup(String objectGroup) {
    this.objectGroup = objectGroup;
    return this;
  }

  /**
   * In silent mode exceptions thrown during evaluation are not reported and do not pause execution.
   * Overrides `setPauseOnException` state.
   */
  public Boolean getSilent() {
    return silent;
  }

  /**
   * In silent mode exceptions thrown during evaluation are not reported and do not pause execution.
   * Overrides `setPauseOnException` state.
   */
  public RunScriptParameters setSilent(Boolean silent) {
    this.silent = silent;
    return this;
  }

  /** Determines whether Command Line API should be available during the evaluation. */
  public Boolean getIncludeCommandLineAPI() {
    return includeCommandLineAPI;
  }

  /** Determines whether Command Line API should be available during the evaluation. */
  public RunScriptParameters setIncludeCommandLineAPI(Boolean includeCommandLineAPI) {
    this.includeCommandLineAPI = includeCommandLineAPI;
    return this;
  }

  /** Whether the result is expected to be a JSON object which should be sent by value. */
  public Boolean getReturnByValue() {
    return returnByValue;
  }

  /** Whether the result is expected to be a JSON object which should be sent by value. */
  public RunScriptParameters setReturnByValue(Boolean returnByValue) {
    this.returnByValue = returnByValue;
    return this;
  }

  /** Whether preview should be generated for the result. */
  public Boolean getGeneratePreview() {
    return generatePreview;
  }

  /** Whether preview should be generated for the result. */
  public RunScriptParameters setGeneratePreview(Boolean generatePreview) {
    this.generatePreview = generatePreview;
    return this;
  }

  /**
   * Whether execution should `await` for resulting value and return once awaited promise is
   * resolved.
   */
  public Boolean getAwaitPromise() {
    return awaitPromise;
  }

  /**
   * Whether execution should `await` for resulting value and return once awaited promise is
   * resolved.
   */
  public RunScriptParameters setAwaitPromise(Boolean awaitPromise) {
    this.awaitPromise = awaitPromise;
    return this;
  }
}
