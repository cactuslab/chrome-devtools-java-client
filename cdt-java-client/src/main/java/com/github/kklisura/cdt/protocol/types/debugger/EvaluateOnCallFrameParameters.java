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

/** Parameters for the evaluateOnCallFrame command. */
public class EvaluateOnCallFrameParameters {

  @ParamName("callFrameId")
  private String callFrameId;

  @ParamName("expression")
  private String expression;

  @Optional
  @ParamName("objectGroup")
  private String objectGroup;

  @Optional
  @ParamName("includeCommandLineAPI")
  private Boolean includeCommandLineAPI;

  @Optional
  @ParamName("silent")
  private Boolean silent;

  @Optional
  @ParamName("returnByValue")
  private Boolean returnByValue;

  @Experimental
  @Optional
  @ParamName("generatePreview")
  private Boolean generatePreview;

  @Optional
  @ParamName("throwOnSideEffect")
  private Boolean throwOnSideEffect;

  @Experimental
  @Optional
  @ParamName("timeout")
  private Double timeout;

  /** Call frame identifier to evaluate on. */
  public String getCallFrameId() {
    return callFrameId;
  }

  /** Call frame identifier to evaluate on. */
  public EvaluateOnCallFrameParameters setCallFrameId(String callFrameId) {
    this.callFrameId = callFrameId;
    return this;
  }

  /** Expression to evaluate. */
  public String getExpression() {
    return expression;
  }

  /** Expression to evaluate. */
  public EvaluateOnCallFrameParameters setExpression(String expression) {
    this.expression = expression;
    return this;
  }

  /**
   * String object group name to put result into (allows rapid releasing resulting object handles
   * using `releaseObjectGroup`).
   */
  public String getObjectGroup() {
    return objectGroup;
  }

  /**
   * String object group name to put result into (allows rapid releasing resulting object handles
   * using `releaseObjectGroup`).
   */
  public EvaluateOnCallFrameParameters setObjectGroup(String objectGroup) {
    this.objectGroup = objectGroup;
    return this;
  }

  /**
   * Specifies whether command line API should be available to the evaluated expression, defaults to
   * false.
   */
  public Boolean getIncludeCommandLineAPI() {
    return includeCommandLineAPI;
  }

  /**
   * Specifies whether command line API should be available to the evaluated expression, defaults to
   * false.
   */
  public EvaluateOnCallFrameParameters setIncludeCommandLineAPI(Boolean includeCommandLineAPI) {
    this.includeCommandLineAPI = includeCommandLineAPI;
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
  public EvaluateOnCallFrameParameters setSilent(Boolean silent) {
    this.silent = silent;
    return this;
  }

  /** Whether the result is expected to be a JSON object that should be sent by value. */
  public Boolean getReturnByValue() {
    return returnByValue;
  }

  /** Whether the result is expected to be a JSON object that should be sent by value. */
  public EvaluateOnCallFrameParameters setReturnByValue(Boolean returnByValue) {
    this.returnByValue = returnByValue;
    return this;
  }

  /** Whether preview should be generated for the result. */
  public Boolean getGeneratePreview() {
    return generatePreview;
  }

  /** Whether preview should be generated for the result. */
  public EvaluateOnCallFrameParameters setGeneratePreview(Boolean generatePreview) {
    this.generatePreview = generatePreview;
    return this;
  }

  /** Whether to throw an exception if side effect cannot be ruled out during evaluation. */
  public Boolean getThrowOnSideEffect() {
    return throwOnSideEffect;
  }

  /** Whether to throw an exception if side effect cannot be ruled out during evaluation. */
  public EvaluateOnCallFrameParameters setThrowOnSideEffect(Boolean throwOnSideEffect) {
    this.throwOnSideEffect = throwOnSideEffect;
    return this;
  }

  /** Terminate execution after timing out (number of milliseconds). */
  public Double getTimeout() {
    return timeout;
  }

  /** Terminate execution after timing out (number of milliseconds). */
  public EvaluateOnCallFrameParameters setTimeout(Double timeout) {
    this.timeout = timeout;
    return this;
  }
}
