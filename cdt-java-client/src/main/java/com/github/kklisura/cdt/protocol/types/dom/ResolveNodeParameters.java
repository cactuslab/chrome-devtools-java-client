package com.github.kklisura.cdt.protocol.types.dom;

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

/** Parameters for the resolveNode command. */
public class ResolveNodeParameters {

  @Optional
  @ParamName("nodeId")
  private Integer nodeId;

  @Optional
  @ParamName("backendNodeId")
  private Integer backendNodeId;

  @Optional
  @ParamName("objectGroup")
  private String objectGroup;

  @Optional
  @ParamName("executionContextId")
  private Integer executionContextId;

  /** Id of the node to resolve. */
  public Integer getNodeId() {
    return nodeId;
  }

  /** Id of the node to resolve. */
  public ResolveNodeParameters setNodeId(Integer nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /** Backend identifier of the node to resolve. */
  public Integer getBackendNodeId() {
    return backendNodeId;
  }

  /** Backend identifier of the node to resolve. */
  public ResolveNodeParameters setBackendNodeId(Integer backendNodeId) {
    this.backendNodeId = backendNodeId;
    return this;
  }

  /** Symbolic group name that can be used to release multiple objects. */
  public String getObjectGroup() {
    return objectGroup;
  }

  /** Symbolic group name that can be used to release multiple objects. */
  public ResolveNodeParameters setObjectGroup(String objectGroup) {
    this.objectGroup = objectGroup;
    return this;
  }

  /** Execution context in which to resolve the node. */
  public Integer getExecutionContextId() {
    return executionContextId;
  }

  /** Execution context in which to resolve the node. */
  public ResolveNodeParameters setExecutionContextId(Integer executionContextId) {
    this.executionContextId = executionContextId;
    return this;
  }
}
