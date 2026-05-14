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

import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;

/** Parameters for the getOuterHTML command. */
public class GetOuterHTMLParameters {

  @Optional
  @ParamName("nodeId")
  private Integer nodeId;

  @Optional
  @ParamName("backendNodeId")
  private Integer backendNodeId;

  @Optional
  @ParamName("objectId")
  private String objectId;

  @Experimental
  @Optional
  @ParamName("includeShadowDOM")
  private Boolean includeShadowDOM;

  /** Identifier of the node. */
  public Integer getNodeId() {
    return nodeId;
  }

  /** Identifier of the node. */
  public GetOuterHTMLParameters setNodeId(Integer nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /** Identifier of the backend node. */
  public Integer getBackendNodeId() {
    return backendNodeId;
  }

  /** Identifier of the backend node. */
  public GetOuterHTMLParameters setBackendNodeId(Integer backendNodeId) {
    this.backendNodeId = backendNodeId;
    return this;
  }

  /** JavaScript object id of the node wrapper. */
  public String getObjectId() {
    return objectId;
  }

  /** JavaScript object id of the node wrapper. */
  public GetOuterHTMLParameters setObjectId(String objectId) {
    this.objectId = objectId;
    return this;
  }

  /** Include all shadow roots. Equals to false if not specified. */
  public Boolean getIncludeShadowDOM() {
    return includeShadowDOM;
  }

  /** Include all shadow roots. Equals to false if not specified. */
  public GetOuterHTMLParameters setIncludeShadowDOM(Boolean includeShadowDOM) {
    this.includeShadowDOM = includeShadowDOM;
    return this;
  }
}
