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

import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;

/** Parameters for the evaluate command. */
public class EvaluateParameters {

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
  @ParamName("contextId")
  private Integer contextId;

  @Optional
  @ParamName("returnByValue")
  private Boolean returnByValue;

  @Experimental
  @Optional
  @ParamName("generatePreview")
  private Boolean generatePreview;

  @Optional
  @ParamName("userGesture")
  private Boolean userGesture;

  @Optional
  @ParamName("awaitPromise")
  private Boolean awaitPromise;

  @Experimental
  @Optional
  @ParamName("throwOnSideEffect")
  private Boolean throwOnSideEffect;

  @Experimental
  @Optional
  @ParamName("timeout")
  private Double timeout;

  @Experimental
  @Optional
  @ParamName("disableBreaks")
  private Boolean disableBreaks;

  @Experimental
  @Optional
  @ParamName("replMode")
  private Boolean replMode;

  @Experimental
  @Optional
  @ParamName("allowUnsafeEvalBlockedByCSP")
  private Boolean allowUnsafeEvalBlockedByCSP;

  @Experimental
  @Optional
  @ParamName("uniqueContextId")
  private String uniqueContextId;

  @Experimental
  @Optional
  @ParamName("serializationOptions")
  private SerializationOptions serializationOptions;

  /** Expression to evaluate. */
  public String getExpression() {
    return expression;
  }

  /** Expression to evaluate. */
  public EvaluateParameters setExpression(String expression) {
    this.expression = expression;
    return this;
  }

  /** Symbolic group name that can be used to release multiple objects. */
  public String getObjectGroup() {
    return objectGroup;
  }

  /** Symbolic group name that can be used to release multiple objects. */
  public EvaluateParameters setObjectGroup(String objectGroup) {
    this.objectGroup = objectGroup;
    return this;
  }

  /** Determines whether Command Line API should be available during the evaluation. */
  public Boolean getIncludeCommandLineAPI() {
    return includeCommandLineAPI;
  }

  /** Determines whether Command Line API should be available during the evaluation. */
  public EvaluateParameters setIncludeCommandLineAPI(Boolean includeCommandLineAPI) {
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
  public EvaluateParameters setSilent(Boolean silent) {
    this.silent = silent;
    return this;
  }

  /**
   * Specifies in which execution context to perform evaluation. If the parameter is omitted the
   * evaluation will be performed in the context of the inspected page. This is mutually exclusive
   * with `uniqueContextId`, which offers an alternative way to identify the execution context that
   * is more reliable in a multi-process environment.
   */
  public Integer getContextId() {
    return contextId;
  }

  /**
   * Specifies in which execution context to perform evaluation. If the parameter is omitted the
   * evaluation will be performed in the context of the inspected page. This is mutually exclusive
   * with `uniqueContextId`, which offers an alternative way to identify the execution context that
   * is more reliable in a multi-process environment.
   */
  public EvaluateParameters setContextId(Integer contextId) {
    this.contextId = contextId;
    return this;
  }

  /** Whether the result is expected to be a JSON object that should be sent by value. */
  public Boolean getReturnByValue() {
    return returnByValue;
  }

  /** Whether the result is expected to be a JSON object that should be sent by value. */
  public EvaluateParameters setReturnByValue(Boolean returnByValue) {
    this.returnByValue = returnByValue;
    return this;
  }

  /** Whether preview should be generated for the result. */
  public Boolean getGeneratePreview() {
    return generatePreview;
  }

  /** Whether preview should be generated for the result. */
  public EvaluateParameters setGeneratePreview(Boolean generatePreview) {
    this.generatePreview = generatePreview;
    return this;
  }

  /** Whether execution should be treated as initiated by user in the UI. */
  public Boolean getUserGesture() {
    return userGesture;
  }

  /** Whether execution should be treated as initiated by user in the UI. */
  public EvaluateParameters setUserGesture(Boolean userGesture) {
    this.userGesture = userGesture;
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
  public EvaluateParameters setAwaitPromise(Boolean awaitPromise) {
    this.awaitPromise = awaitPromise;
    return this;
  }

  /**
   * Whether to throw an exception if side effect cannot be ruled out during evaluation. This
   * implies `disableBreaks` below.
   */
  public Boolean getThrowOnSideEffect() {
    return throwOnSideEffect;
  }

  /**
   * Whether to throw an exception if side effect cannot be ruled out during evaluation. This
   * implies `disableBreaks` below.
   */
  public EvaluateParameters setThrowOnSideEffect(Boolean throwOnSideEffect) {
    this.throwOnSideEffect = throwOnSideEffect;
    return this;
  }

  /** Terminate execution after timing out (number of milliseconds). */
  public Double getTimeout() {
    return timeout;
  }

  /** Terminate execution after timing out (number of milliseconds). */
  public EvaluateParameters setTimeout(Double timeout) {
    this.timeout = timeout;
    return this;
  }

  /** Disable breakpoints during execution. */
  public Boolean getDisableBreaks() {
    return disableBreaks;
  }

  /** Disable breakpoints during execution. */
  public EvaluateParameters setDisableBreaks(Boolean disableBreaks) {
    this.disableBreaks = disableBreaks;
    return this;
  }

  /**
   * Setting this flag to true enables `let` re-declaration and top-level `await`. Note that `let`
   * variables can only be re-declared if they originate from `replMode` themselves.
   */
  public Boolean getReplMode() {
    return replMode;
  }

  /**
   * Setting this flag to true enables `let` re-declaration and top-level `await`. Note that `let`
   * variables can only be re-declared if they originate from `replMode` themselves.
   */
  public EvaluateParameters setReplMode(Boolean replMode) {
    this.replMode = replMode;
    return this;
  }

  /**
   * The Content Security Policy (CSP) for the target might block 'unsafe-eval' which includes
   * eval(), Function(), setTimeout() and setInterval() when called with non-callable arguments.
   * This flag bypasses CSP for this evaluation and allows unsafe-eval. Defaults to true.
   */
  public Boolean getAllowUnsafeEvalBlockedByCSP() {
    return allowUnsafeEvalBlockedByCSP;
  }

  /**
   * The Content Security Policy (CSP) for the target might block 'unsafe-eval' which includes
   * eval(), Function(), setTimeout() and setInterval() when called with non-callable arguments.
   * This flag bypasses CSP for this evaluation and allows unsafe-eval. Defaults to true.
   */
  public EvaluateParameters setAllowUnsafeEvalBlockedByCSP(Boolean allowUnsafeEvalBlockedByCSP) {
    this.allowUnsafeEvalBlockedByCSP = allowUnsafeEvalBlockedByCSP;
    return this;
  }

  /**
   * An alternative way to specify the execution context to evaluate in. Compared to contextId that
   * may be reused across processes, this is guaranteed to be system-unique, so it can be used to
   * prevent accidental evaluation of the expression in context different than intended (e.g. as a
   * result of navigation across process boundaries). This is mutually exclusive with `contextId`.
   */
  public String getUniqueContextId() {
    return uniqueContextId;
  }

  /**
   * An alternative way to specify the execution context to evaluate in. Compared to contextId that
   * may be reused across processes, this is guaranteed to be system-unique, so it can be used to
   * prevent accidental evaluation of the expression in context different than intended (e.g. as a
   * result of navigation across process boundaries). This is mutually exclusive with `contextId`.
   */
  public EvaluateParameters setUniqueContextId(String uniqueContextId) {
    this.uniqueContextId = uniqueContextId;
    return this;
  }

  /**
   * Specifies the result serialization. If provided, overrides `generatePreview` and
   * `returnByValue`.
   */
  public SerializationOptions getSerializationOptions() {
    return serializationOptions;
  }

  /**
   * Specifies the result serialization. If provided, overrides `generatePreview` and
   * `returnByValue`.
   */
  public EvaluateParameters setSerializationOptions(SerializationOptions serializationOptions) {
    this.serializationOptions = serializationOptions;
    return this;
  }
}
