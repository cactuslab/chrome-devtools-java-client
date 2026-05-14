package com.github.kklisura.cdt.protocol.types.emulation;

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

/** Parameters for the updateScreen command. */
public class UpdateScreenParameters {

  @ParamName("screenId")
  private String screenId;

  @Optional
  @ParamName("left")
  private Integer left;

  @Optional
  @ParamName("top")
  private Integer top;

  @Optional
  @ParamName("width")
  private Integer width;

  @Optional
  @ParamName("height")
  private Integer height;

  @Optional
  @ParamName("workAreaInsets")
  private WorkAreaInsets workAreaInsets;

  @Optional
  @ParamName("devicePixelRatio")
  private Double devicePixelRatio;

  @Optional
  @ParamName("rotation")
  private Integer rotation;

  @Optional
  @ParamName("colorDepth")
  private Integer colorDepth;

  @Optional
  @ParamName("label")
  private String label;

  @Optional
  @ParamName("isInternal")
  private Boolean isInternal;

  /** Target screen identifier. */
  public String getScreenId() {
    return screenId;
  }

  /** Target screen identifier. */
  public UpdateScreenParameters setScreenId(String screenId) {
    this.screenId = screenId;
    return this;
  }

  /** Offset of the left edge of the screen in pixels. */
  public Integer getLeft() {
    return left;
  }

  /** Offset of the left edge of the screen in pixels. */
  public UpdateScreenParameters setLeft(Integer left) {
    this.left = left;
    return this;
  }

  /** Offset of the top edge of the screen in pixels. */
  public Integer getTop() {
    return top;
  }

  /** Offset of the top edge of the screen in pixels. */
  public UpdateScreenParameters setTop(Integer top) {
    this.top = top;
    return this;
  }

  /** The width of the screen in pixels. */
  public Integer getWidth() {
    return width;
  }

  /** The width of the screen in pixels. */
  public UpdateScreenParameters setWidth(Integer width) {
    this.width = width;
    return this;
  }

  /** The height of the screen in pixels. */
  public Integer getHeight() {
    return height;
  }

  /** The height of the screen in pixels. */
  public UpdateScreenParameters setHeight(Integer height) {
    this.height = height;
    return this;
  }

  /** Specifies the screen's work area. */
  public WorkAreaInsets getWorkAreaInsets() {
    return workAreaInsets;
  }

  /** Specifies the screen's work area. */
  public UpdateScreenParameters setWorkAreaInsets(WorkAreaInsets workAreaInsets) {
    this.workAreaInsets = workAreaInsets;
    return this;
  }

  /** Specifies the screen's device pixel ratio. */
  public Double getDevicePixelRatio() {
    return devicePixelRatio;
  }

  /** Specifies the screen's device pixel ratio. */
  public UpdateScreenParameters setDevicePixelRatio(Double devicePixelRatio) {
    this.devicePixelRatio = devicePixelRatio;
    return this;
  }

  /** Specifies the screen's rotation angle. Available values are 0, 90, 180 and 270. */
  public Integer getRotation() {
    return rotation;
  }

  /** Specifies the screen's rotation angle. Available values are 0, 90, 180 and 270. */
  public UpdateScreenParameters setRotation(Integer rotation) {
    this.rotation = rotation;
    return this;
  }

  /** Specifies the screen's color depth in bits. */
  public Integer getColorDepth() {
    return colorDepth;
  }

  /** Specifies the screen's color depth in bits. */
  public UpdateScreenParameters setColorDepth(Integer colorDepth) {
    this.colorDepth = colorDepth;
    return this;
  }

  /** Specifies the descriptive label for the screen. */
  public String getLabel() {
    return label;
  }

  /** Specifies the descriptive label for the screen. */
  public UpdateScreenParameters setLabel(String label) {
    this.label = label;
    return this;
  }

  /**
   * Indicates whether the screen is internal to the device or external, attached to the device.
   * Default is false.
   */
  public Boolean getIsInternal() {
    return isInternal;
  }

  /**
   * Indicates whether the screen is internal to the device or external, attached to the device.
   * Default is false.
   */
  public UpdateScreenParameters setIsInternal(Boolean isInternal) {
    this.isInternal = isInternal;
    return this;
  }
}
