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

/** Parameters for the getContainerForNode command. */
public class GetContainerForNodeParameters {

  @ParamName("nodeId")
  private Integer nodeId;

  @Optional
  @ParamName("containerName")
  private String containerName;

  @Optional
  @ParamName("physicalAxes")
  private PhysicalAxes physicalAxes;

  @Optional
  @ParamName("logicalAxes")
  private LogicalAxes logicalAxes;

  @Optional
  @ParamName("queriesScrollState")
  private Boolean queriesScrollState;

  @Optional
  @ParamName("queriesAnchored")
  private Boolean queriesAnchored;

  public Integer getNodeId() {
    return nodeId;
  }

  public GetContainerForNodeParameters setNodeId(Integer nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  public String getContainerName() {
    return containerName;
  }

  public GetContainerForNodeParameters setContainerName(String containerName) {
    this.containerName = containerName;
    return this;
  }

  public PhysicalAxes getPhysicalAxes() {
    return physicalAxes;
  }

  public GetContainerForNodeParameters setPhysicalAxes(PhysicalAxes physicalAxes) {
    this.physicalAxes = physicalAxes;
    return this;
  }

  public LogicalAxes getLogicalAxes() {
    return logicalAxes;
  }

  public GetContainerForNodeParameters setLogicalAxes(LogicalAxes logicalAxes) {
    this.logicalAxes = logicalAxes;
    return this;
  }

  public Boolean getQueriesScrollState() {
    return queriesScrollState;
  }

  public GetContainerForNodeParameters setQueriesScrollState(Boolean queriesScrollState) {
    this.queriesScrollState = queriesScrollState;
    return this;
  }

  public Boolean getQueriesAnchored() {
    return queriesAnchored;
  }

  public GetContainerForNodeParameters setQueriesAnchored(Boolean queriesAnchored) {
    this.queriesAnchored = queriesAnchored;
    return this;
  }
}
