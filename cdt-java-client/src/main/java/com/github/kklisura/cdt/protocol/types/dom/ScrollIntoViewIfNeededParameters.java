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

/** Parameters for the scrollIntoViewIfNeeded command. */
public class ScrollIntoViewIfNeededParameters {

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
  @ParamName("rect")
  private Rect rect;

  /** Identifier of the node. */
  public Integer getNodeId() {
    return nodeId;
  }

  /** Identifier of the node. */
  public ScrollIntoViewIfNeededParameters setNodeId(Integer nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /** Identifier of the backend node. */
  public Integer getBackendNodeId() {
    return backendNodeId;
  }

  /** Identifier of the backend node. */
  public ScrollIntoViewIfNeededParameters setBackendNodeId(Integer backendNodeId) {
    this.backendNodeId = backendNodeId;
    return this;
  }

  /** JavaScript object id of the node wrapper. */
  public String getObjectId() {
    return objectId;
  }

  /** JavaScript object id of the node wrapper. */
  public ScrollIntoViewIfNeededParameters setObjectId(String objectId) {
    this.objectId = objectId;
    return this;
  }

  /**
   * The rect to be scrolled into view, relative to the node's border box, in CSS pixels. When
   * omitted, center of the node will be used, similar to Element.scrollIntoView.
   */
  public Rect getRect() {
    return rect;
  }

  /**
   * The rect to be scrolled into view, relative to the node's border box, in CSS pixels. When
   * omitted, center of the node will be used, similar to Element.scrollIntoView.
   */
  public ScrollIntoViewIfNeededParameters setRect(Rect rect) {
    this.rect = rect;
    return this;
  }
}
