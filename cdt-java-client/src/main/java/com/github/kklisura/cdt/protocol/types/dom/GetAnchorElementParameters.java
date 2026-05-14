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

/** Parameters for the getAnchorElement command. */
public class GetAnchorElementParameters {

  @ParamName("nodeId")
  private Integer nodeId;

  @Optional
  @ParamName("anchorSpecifier")
  private String anchorSpecifier;

  /** Id of the positioned element from which to find the anchor. */
  public Integer getNodeId() {
    return nodeId;
  }

  /** Id of the positioned element from which to find the anchor. */
  public GetAnchorElementParameters setNodeId(Integer nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /**
   * An optional anchor specifier, as defined in
   * https://www.w3.org/TR/css-anchor-position-1/#anchor-specifier. If not provided, it will return
   * the implicit anchor element for the given positioned element.
   */
  public String getAnchorSpecifier() {
    return anchorSpecifier;
  }

  /**
   * An optional anchor specifier, as defined in
   * https://www.w3.org/TR/css-anchor-position-1/#anchor-specifier. If not provided, it will return
   * the implicit anchor element for the given positioned element.
   */
  public GetAnchorElementParameters setAnchorSpecifier(String anchorSpecifier) {
    this.anchorSpecifier = anchorSpecifier;
    return this;
  }
}
