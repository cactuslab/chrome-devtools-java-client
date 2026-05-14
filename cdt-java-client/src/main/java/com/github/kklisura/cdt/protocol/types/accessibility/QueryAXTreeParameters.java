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

/** Parameters for the queryAXTree command. */
public class QueryAXTreeParameters {

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
  @ParamName("accessibleName")
  private String accessibleName;

  @Optional
  @ParamName("role")
  private String role;

  /** Identifier of the node for the root to query. */
  public Integer getNodeId() {
    return nodeId;
  }

  /** Identifier of the node for the root to query. */
  public QueryAXTreeParameters setNodeId(Integer nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /** Identifier of the backend node for the root to query. */
  public Integer getBackendNodeId() {
    return backendNodeId;
  }

  /** Identifier of the backend node for the root to query. */
  public QueryAXTreeParameters setBackendNodeId(Integer backendNodeId) {
    this.backendNodeId = backendNodeId;
    return this;
  }

  /** JavaScript object id of the node wrapper for the root to query. */
  public String getObjectId() {
    return objectId;
  }

  /** JavaScript object id of the node wrapper for the root to query. */
  public QueryAXTreeParameters setObjectId(String objectId) {
    this.objectId = objectId;
    return this;
  }

  /** Find nodes with this computed name. */
  public String getAccessibleName() {
    return accessibleName;
  }

  /** Find nodes with this computed name. */
  public QueryAXTreeParameters setAccessibleName(String accessibleName) {
    this.accessibleName = accessibleName;
    return this;
  }

  /** Find nodes with this computed role. */
  public String getRole() {
    return role;
  }

  /** Find nodes with this computed role. */
  public QueryAXTreeParameters setRole(String role) {
    this.role = role;
    return this;
  }
}
