package com.github.kklisura.cdt.protocol.types.domsnapshot;

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

/** Parameters for the getSnapshot command. */
public class GetSnapshotParameters {

  @ParamName("computedStyleWhitelist")
  private List<String> computedStyleWhitelist;

  @Optional
  @ParamName("includeEventListeners")
  private Boolean includeEventListeners;

  @Optional
  @ParamName("includePaintOrder")
  private Boolean includePaintOrder;

  @Optional
  @ParamName("includeUserAgentShadowTree")
  private Boolean includeUserAgentShadowTree;

  /** Whitelist of computed styles to return. */
  public List<String> getComputedStyleWhitelist() {
    return computedStyleWhitelist;
  }

  /** Whitelist of computed styles to return. */
  public GetSnapshotParameters setComputedStyleWhitelist(List<String> computedStyleWhitelist) {
    this.computedStyleWhitelist = computedStyleWhitelist;
    return this;
  }

  /** Whether or not to retrieve details of DOM listeners (default false). */
  public Boolean getIncludeEventListeners() {
    return includeEventListeners;
  }

  /** Whether or not to retrieve details of DOM listeners (default false). */
  public GetSnapshotParameters setIncludeEventListeners(Boolean includeEventListeners) {
    this.includeEventListeners = includeEventListeners;
    return this;
  }

  /** Whether to determine and include the paint order index of LayoutTreeNodes (default false). */
  public Boolean getIncludePaintOrder() {
    return includePaintOrder;
  }

  /** Whether to determine and include the paint order index of LayoutTreeNodes (default false). */
  public GetSnapshotParameters setIncludePaintOrder(Boolean includePaintOrder) {
    this.includePaintOrder = includePaintOrder;
    return this;
  }

  /** Whether to include UA shadow tree in the snapshot (default false). */
  public Boolean getIncludeUserAgentShadowTree() {
    return includeUserAgentShadowTree;
  }

  /** Whether to include UA shadow tree in the snapshot (default false). */
  public GetSnapshotParameters setIncludeUserAgentShadowTree(Boolean includeUserAgentShadowTree) {
    this.includeUserAgentShadowTree = includeUserAgentShadowTree;
    return this;
  }
}
