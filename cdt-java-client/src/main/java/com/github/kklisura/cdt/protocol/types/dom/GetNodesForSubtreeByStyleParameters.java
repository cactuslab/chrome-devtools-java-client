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
import java.util.List;

/** Parameters for the getNodesForSubtreeByStyle command. */
public class GetNodesForSubtreeByStyleParameters {

  @ParamName("nodeId")
  private Integer nodeId;

  @ParamName("computedStyles")
  private List<CSSComputedStyleProperty> computedStyles;

  @Optional
  @ParamName("pierce")
  private Boolean pierce;

  /** Node ID pointing to the root of a subtree. */
  public Integer getNodeId() {
    return nodeId;
  }

  /** Node ID pointing to the root of a subtree. */
  public GetNodesForSubtreeByStyleParameters setNodeId(Integer nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /** The style to filter nodes by (includes nodes if any of properties matches). */
  public List<CSSComputedStyleProperty> getComputedStyles() {
    return computedStyles;
  }

  /** The style to filter nodes by (includes nodes if any of properties matches). */
  public GetNodesForSubtreeByStyleParameters setComputedStyles(
      List<CSSComputedStyleProperty> computedStyles) {
    this.computedStyles = computedStyles;
    return this;
  }

  /**
   * Whether or not iframes and shadow roots in the same target should be traversed when returning
   * the results (default is false).
   */
  public Boolean getPierce() {
    return pierce;
  }

  /**
   * Whether or not iframes and shadow roots in the same target should be traversed when returning
   * the results (default is false).
   */
  public GetNodesForSubtreeByStyleParameters setPierce(Boolean pierce) {
    this.pierce = pierce;
    return this;
  }
}
