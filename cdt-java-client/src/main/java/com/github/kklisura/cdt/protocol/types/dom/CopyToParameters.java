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

/** Parameters for the copyTo command. */
public class CopyToParameters {

  @ParamName("nodeId")
  private Integer nodeId;

  @ParamName("targetNodeId")
  private Integer targetNodeId;

  @Optional
  @ParamName("insertBeforeNodeId")
  private Integer insertBeforeNodeId;

  /** Id of the node to copy. */
  public Integer getNodeId() {
    return nodeId;
  }

  /** Id of the node to copy. */
  public CopyToParameters setNodeId(Integer nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /** Id of the element to drop the copy into. */
  public Integer getTargetNodeId() {
    return targetNodeId;
  }

  /** Id of the element to drop the copy into. */
  public CopyToParameters setTargetNodeId(Integer targetNodeId) {
    this.targetNodeId = targetNodeId;
    return this;
  }

  /**
   * Drop the copy before this node (if absent, the copy becomes the last child of `targetNodeId`).
   */
  public Integer getInsertBeforeNodeId() {
    return insertBeforeNodeId;
  }

  /**
   * Drop the copy before this node (if absent, the copy becomes the last child of `targetNodeId`).
   */
  public CopyToParameters setInsertBeforeNodeId(Integer insertBeforeNodeId) {
    this.insertBeforeNodeId = insertBeforeNodeId;
    return this;
  }
}
