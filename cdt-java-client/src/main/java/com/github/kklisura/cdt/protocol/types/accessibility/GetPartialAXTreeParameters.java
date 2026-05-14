package com.github.kklisura.cdt.protocol.types.accessibility;

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

/** Parameters for the getPartialAXTree command. */
public class GetPartialAXTreeParameters {

  @Optional
  @ParamName("nodeId")
  private Integer nodeId;

  @Optional
  @ParamName("backendNodeId")
  private Integer backendNodeId;

  @Optional
  @ParamName("objectId")
  private String objectId;

  @Optional
  @ParamName("fetchRelatives")
  private Boolean fetchRelatives;

  /** Identifier of the node to get the partial accessibility tree for. */
  public Integer getNodeId() {
    return nodeId;
  }

  /** Identifier of the node to get the partial accessibility tree for. */
  public GetPartialAXTreeParameters setNodeId(Integer nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /** Identifier of the backend node to get the partial accessibility tree for. */
  public Integer getBackendNodeId() {
    return backendNodeId;
  }

  /** Identifier of the backend node to get the partial accessibility tree for. */
  public GetPartialAXTreeParameters setBackendNodeId(Integer backendNodeId) {
    this.backendNodeId = backendNodeId;
    return this;
  }

  /** JavaScript object id of the node wrapper to get the partial accessibility tree for. */
  public String getObjectId() {
    return objectId;
  }

  /** JavaScript object id of the node wrapper to get the partial accessibility tree for. */
  public GetPartialAXTreeParameters setObjectId(String objectId) {
    this.objectId = objectId;
    return this;
  }

  /** Whether to fetch this node's ancestors, siblings and children. Defaults to true. */
  public Boolean getFetchRelatives() {
    return fetchRelatives;
  }

  /** Whether to fetch this node's ancestors, siblings and children. Defaults to true. */
  public GetPartialAXTreeParameters setFetchRelatives(Boolean fetchRelatives) {
    this.fetchRelatives = fetchRelatives;
    return this;
  }
}
