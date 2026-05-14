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

/** Parameters for the getHighlightObjectForTest command. */
public class GetHighlightObjectForTestParameters {

  @ParamName("nodeId")
  private Integer nodeId;

  @Optional
  @ParamName("includeDistance")
  private Boolean includeDistance;

  @Optional
  @ParamName("includeStyle")
  private Boolean includeStyle;

  @Optional
  @ParamName("colorFormat")
  private ColorFormat colorFormat;

  @Optional
  @ParamName("showAccessibilityInfo")
  private Boolean showAccessibilityInfo;

  /** Id of the node to get highlight object for. */
  public Integer getNodeId() {
    return nodeId;
  }

  /** Id of the node to get highlight object for. */
  public GetHighlightObjectForTestParameters setNodeId(Integer nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /** Whether to include distance info. */
  public Boolean getIncludeDistance() {
    return includeDistance;
  }

  /** Whether to include distance info. */
  public GetHighlightObjectForTestParameters setIncludeDistance(Boolean includeDistance) {
    this.includeDistance = includeDistance;
    return this;
  }

  /** Whether to include style info. */
  public Boolean getIncludeStyle() {
    return includeStyle;
  }

  /** Whether to include style info. */
  public GetHighlightObjectForTestParameters setIncludeStyle(Boolean includeStyle) {
    this.includeStyle = includeStyle;
    return this;
  }

  /** The color format to get config with (default: hex). */
  public ColorFormat getColorFormat() {
    return colorFormat;
  }

  /** The color format to get config with (default: hex). */
  public GetHighlightObjectForTestParameters setColorFormat(ColorFormat colorFormat) {
    this.colorFormat = colorFormat;
    return this;
  }

  /** Whether to show accessibility info (default: true). */
  public Boolean getShowAccessibilityInfo() {
    return showAccessibilityInfo;
  }

  /** Whether to show accessibility info (default: true). */
  public GetHighlightObjectForTestParameters setShowAccessibilityInfo(
      Boolean showAccessibilityInfo) {
    this.showAccessibilityInfo = showAccessibilityInfo;
    return this;
  }
}
