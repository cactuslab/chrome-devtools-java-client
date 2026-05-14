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
import java.util.List;

/** Parameters for the callFunctionOn command. */
public class CallFunctionOnParameters {

  @ParamName("functionDeclaration")
  private String functionDeclaration;

  @Optional
  @ParamName("objectId")
  private String objectId;

  @Optional
  @ParamName("arguments")
  private List<CallArgument> arguments;

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
  @ParamName("userGesture")
  private Boolean userGesture;

  @Optional
  @ParamName("awaitPromise")
  private Boolean awaitPromise;

  @Optional
  @ParamName("executionContextId")
  private Integer executionContextId;

  @Optional
  @ParamName("objectGroup")
  private String objectGroup;

  @Experimental
  @Optional
  @ParamName("throwOnSideEffect")
  private Boolean throwOnSideEffect;

  @Experimental
  @Optional
  @ParamName("uniqueContextId")
  private String uniqueContextId;

  @Experimental
  @Optional
  @ParamName("serializationOptions")
  private SerializationOptions serializationOptions;

  /** Declaration of the function to call. */
  public String getFunctionDeclaration() {
    return functionDeclaration;
  }

  /** Declaration of the function to call. */
  public CallFunctionOnParameters setFunctionDeclaration(String functionDeclaration) {
    this.functionDeclaration = functionDeclaration;
    return this;
  }

  /**
   * Identifier of the object to call function on. Either objectId or executionContextId should be
   * specified.
   */
  public String getObjectId() {
    return objectId;
  }

  /**
   * Identifier of the object to call function on. Either objectId or executionContextId should be
   * specified.
   */
  public CallFunctionOnParameters setObjectId(String objectId) {
    this.objectId = objectId;
    return this;
  }

  /**
   * Call arguments. All call arguments must belong to the same JavaScript world as the target
   * object.
   */
  public List<CallArgument> getArguments() {
    return arguments;
  }

  /**
   * Call arguments. All call arguments must belong to the same JavaScript world as the target
   * object.
   */
  public CallFunctionOnParameters setArguments(List<CallArgument> arguments) {
    this.arguments = arguments;
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
  public CallFunctionOnParameters setSilent(Boolean silent) {
    this.silent = silent;
    return this;
  }

  /**
   * Whether the result is expected to be a JSON object which should be sent by value. Can be
   * overriden by `serializationOptions`.
   */
  public Boolean getReturnByValue() {
    return returnByValue;
  }

  /**
   * Whether the result is expected to be a JSON object which should be sent by value. Can be
   * overriden by `serializationOptions`.
   */
  public CallFunctionOnParameters setReturnByValue(Boolean returnByValue) {
    this.returnByValue = returnByValue;
    return this;
  }

  /** Whether preview should be generated for the result. */
  public Boolean getGeneratePreview() {
    return generatePreview;
  }

  /** Whether preview should be generated for the result. */
  public CallFunctionOnParameters setGeneratePreview(Boolean generatePreview) {
    this.generatePreview = generatePreview;
    return this;
  }

  /** Whether execution should be treated as initiated by user in the UI. */
  public Boolean getUserGesture() {
    return userGesture;
  }

  /** Whether execution should be treated as initiated by user in the UI. */
  public CallFunctionOnParameters setUserGesture(Boolean userGesture) {
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
  public CallFunctionOnParameters setAwaitPromise(Boolean awaitPromise) {
    this.awaitPromise = awaitPromise;
    return this;
  }

  /**
   * Specifies execution context which global object will be used to call function on. Either
   * executionContextId or objectId should be specified.
   */
  public Integer getExecutionContextId() {
    return executionContextId;
  }

  /**
   * Specifies execution context which global object will be used to call function on. Either
   * executionContextId or objectId should be specified.
   */
  public CallFunctionOnParameters setExecutionContextId(Integer executionContextId) {
    this.executionContextId = executionContextId;
    return this;
  }

  /**
   * Symbolic group name that can be used to release multiple objects. If objectGroup is not
   * specified and objectId is, objectGroup will be inherited from object.
   */
  public String getObjectGroup() {
    return objectGroup;
  }

  /**
   * Symbolic group name that can be used to release multiple objects. If objectGroup is not
   * specified and objectId is, objectGroup will be inherited from object.
   */
  public CallFunctionOnParameters setObjectGroup(String objectGroup) {
    this.objectGroup = objectGroup;
    return this;
  }

  /** Whether to throw an exception if side effect cannot be ruled out during evaluation. */
  public Boolean getThrowOnSideEffect() {
    return throwOnSideEffect;
  }

  /** Whether to throw an exception if side effect cannot be ruled out during evaluation. */
  public CallFunctionOnParameters setThrowOnSideEffect(Boolean throwOnSideEffect) {
    this.throwOnSideEffect = throwOnSideEffect;
    return this;
  }

  /**
   * An alternative way to specify the execution context to call function on. Compared to contextId
   * that may be reused across processes, this is guaranteed to be system-unique, so it can be used
   * to prevent accidental function call in context different than intended (e.g. as a result of
   * navigation across process boundaries). This is mutually exclusive with `executionContextId`.
   */
  public String getUniqueContextId() {
    return uniqueContextId;
  }

  /**
   * An alternative way to specify the execution context to call function on. Compared to contextId
   * that may be reused across processes, this is guaranteed to be system-unique, so it can be used
   * to prevent accidental function call in context different than intended (e.g. as a result of
   * navigation across process boundaries). This is mutually exclusive with `executionContextId`.
   */
  public CallFunctionOnParameters setUniqueContextId(String uniqueContextId) {
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
  public CallFunctionOnParameters setSerializationOptions(
      SerializationOptions serializationOptions) {
    this.serializationOptions = serializationOptions;
    return this;
  }
}
