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

import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;
import java.util.List;

/** Parameters for the captureSnapshot command. */
public class CaptureSnapshotParameters {

  @ParamName("computedStyles")
  private List<String> computedStyles;

  @Optional
  @ParamName("includePaintOrder")
  private Boolean includePaintOrder;

  @Optional
  @ParamName("includeDOMRects")
  private Boolean includeDOMRects;

  @Experimental
  @Optional
  @ParamName("includeBlendedBackgroundColors")
  private Boolean includeBlendedBackgroundColors;

  @Experimental
  @Optional
  @ParamName("includeTextColorOpacities")
  private Boolean includeTextColorOpacities;

  /** Whitelist of computed styles to return. */
  public List<String> getComputedStyles() {
    return computedStyles;
  }

  /** Whitelist of computed styles to return. */
  public CaptureSnapshotParameters setComputedStyles(List<String> computedStyles) {
    this.computedStyles = computedStyles;
    return this;
  }

  /** Whether to include layout object paint orders into the snapshot. */
  public Boolean getIncludePaintOrder() {
    return includePaintOrder;
  }

  /** Whether to include layout object paint orders into the snapshot. */
  public CaptureSnapshotParameters setIncludePaintOrder(Boolean includePaintOrder) {
    this.includePaintOrder = includePaintOrder;
    return this;
  }

  /** Whether to include DOM rectangles (offsetRects, clientRects, scrollRects) into the snapshot */
  public Boolean getIncludeDOMRects() {
    return includeDOMRects;
  }

  /** Whether to include DOM rectangles (offsetRects, clientRects, scrollRects) into the snapshot */
  public CaptureSnapshotParameters setIncludeDOMRects(Boolean includeDOMRects) {
    this.includeDOMRects = includeDOMRects;
    return this;
  }

  /**
   * Whether to include blended background colors in the snapshot (default: false). Blended
   * background color is achieved by blending background colors of all elements that overlap with
   * the current element.
   */
  public Boolean getIncludeBlendedBackgroundColors() {
    return includeBlendedBackgroundColors;
  }

  /**
   * Whether to include blended background colors in the snapshot (default: false). Blended
   * background color is achieved by blending background colors of all elements that overlap with
   * the current element.
   */
  public CaptureSnapshotParameters setIncludeBlendedBackgroundColors(
      Boolean includeBlendedBackgroundColors) {
    this.includeBlendedBackgroundColors = includeBlendedBackgroundColors;
    return this;
  }

  /**
   * Whether to include text color opacity in the snapshot (default: false). An element might have
   * the opacity property set that affects the text color of the element. The final text color
   * opacity is computed based on the opacity of all overlapping elements.
   */
  public Boolean getIncludeTextColorOpacities() {
    return includeTextColorOpacities;
  }

  /**
   * Whether to include text color opacity in the snapshot (default: false). An element might have
   * the opacity property set that affects the text color of the element. The final text color
   * opacity is computed based on the opacity of all overlapping elements.
   */
  public CaptureSnapshotParameters setIncludeTextColorOpacities(Boolean includeTextColorOpacities) {
    this.includeTextColorOpacities = includeTextColorOpacities;
    return this;
  }
}
