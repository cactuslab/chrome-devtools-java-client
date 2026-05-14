package com.github.kklisura.cdt.protocol.types.overlay;

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

/** Parameters for the highlightNode command. */
public class HighlightNodeParameters {

  @ParamName("highlightConfig")
  private HighlightConfig highlightConfig;

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
  @ParamName("selector")
  private String selector;

  /** A descriptor for the highlight appearance. */
  public HighlightConfig getHighlightConfig() {
    return highlightConfig;
  }

  /** A descriptor for the highlight appearance. */
  public HighlightNodeParameters setHighlightConfig(HighlightConfig highlightConfig) {
    this.highlightConfig = highlightConfig;
    return this;
  }

  /** Identifier of the node to highlight. */
  public Integer getNodeId() {
    return nodeId;
  }

  /** Identifier of the node to highlight. */
  public HighlightNodeParameters setNodeId(Integer nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /** Identifier of the backend node to highlight. */
  public Integer getBackendNodeId() {
    return backendNodeId;
  }

  /** Identifier of the backend node to highlight. */
  public HighlightNodeParameters setBackendNodeId(Integer backendNodeId) {
    this.backendNodeId = backendNodeId;
    return this;
  }

  /** JavaScript object id of the node to be highlighted. */
  public String getObjectId() {
    return objectId;
  }

  /** JavaScript object id of the node to be highlighted. */
  public HighlightNodeParameters setObjectId(String objectId) {
    this.objectId = objectId;
    return this;
  }

  /** Selectors to highlight relevant nodes. */
  public String getSelector() {
    return selector;
  }

  /** Selectors to highlight relevant nodes. */
  public HighlightNodeParameters setSelector(String selector) {
    this.selector = selector;
    return this;
  }
}
