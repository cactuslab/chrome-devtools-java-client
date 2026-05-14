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

/** Parameters for the addBinding command. */
public class AddBindingParameters {

  @ParamName("name")
  private String name;

  @Deprecated
  @Experimental
  @Optional
  @ParamName("executionContextId")
  private Integer executionContextId;

  @Optional
  @ParamName("executionContextName")
  private String executionContextName;

  public String getName() {
    return name;
  }

  public AddBindingParameters setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * If specified, the binding would only be exposed to the specified execution context. If omitted
   * and `executionContextName` is not set, the binding is exposed to all execution contexts of the
   * target. This parameter is mutually exclusive with `executionContextName`. Deprecated in favor
   * of `executionContextName` due to an unclear use case and bugs in implementation
   * (crbug.com/1169639). `executionContextId` will be removed in the future.
   */
  public Integer getExecutionContextId() {
    return executionContextId;
  }

  /**
   * If specified, the binding would only be exposed to the specified execution context. If omitted
   * and `executionContextName` is not set, the binding is exposed to all execution contexts of the
   * target. This parameter is mutually exclusive with `executionContextName`. Deprecated in favor
   * of `executionContextName` due to an unclear use case and bugs in implementation
   * (crbug.com/1169639). `executionContextId` will be removed in the future.
   */
  public AddBindingParameters setExecutionContextId(Integer executionContextId) {
    this.executionContextId = executionContextId;
    return this;
  }

  /**
   * If specified, the binding is exposed to the executionContext with matching name, even for
   * contexts created after the binding is added. See also `ExecutionContext.name` and `worldName`
   * parameter to `Page.addScriptToEvaluateOnNewDocument`. This parameter is mutually exclusive with
   * `executionContextId`.
   */
  public String getExecutionContextName() {
    return executionContextName;
  }

  /**
   * If specified, the binding is exposed to the executionContext with matching name, even for
   * contexts created after the binding is added. See also `ExecutionContext.name` and `worldName`
   * parameter to `Page.addScriptToEvaluateOnNewDocument`. This parameter is mutually exclusive with
   * `executionContextId`.
   */
  public AddBindingParameters setExecutionContextName(String executionContextName) {
    this.executionContextName = executionContextName;
    return this;
  }
}
