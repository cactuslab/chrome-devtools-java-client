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

/** Parameters for the compileScript command. */
public class CompileScriptParameters {

  @ParamName("expression")
  private String expression;

  @ParamName("sourceURL")
  private String sourceURL;

  @ParamName("persistScript")
  private Boolean persistScript;

  @Optional
  @ParamName("executionContextId")
  private Integer executionContextId;

  /** Expression to compile. */
  public String getExpression() {
    return expression;
  }

  /** Expression to compile. */
  public CompileScriptParameters setExpression(String expression) {
    this.expression = expression;
    return this;
  }

  /** Source url to be set for the script. */
  public String getSourceURL() {
    return sourceURL;
  }

  /** Source url to be set for the script. */
  public CompileScriptParameters setSourceURL(String sourceURL) {
    this.sourceURL = sourceURL;
    return this;
  }

  /** Specifies whether the compiled script should be persisted. */
  public Boolean getPersistScript() {
    return persistScript;
  }

  /** Specifies whether the compiled script should be persisted. */
  public CompileScriptParameters setPersistScript(Boolean persistScript) {
    this.persistScript = persistScript;
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
  public CompileScriptParameters setExecutionContextId(Integer executionContextId) {
    this.executionContextId = executionContextId;
    return this;
  }
}
