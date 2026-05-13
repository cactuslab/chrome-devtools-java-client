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

import com.github.kklisura.cdt.protocol.support.annotations.Experimental;

/**
 * Screen information similar to the one returned by window.getScreenDetails() method, see
 * https://w3c.github.io/window-management/#screendetailed.
 */
@Experimental
public class ScreenInfo {

  private Integer left;

  private Integer top;

  private Integer width;

  private Integer height;

  private Integer availLeft;

  private Integer availTop;

  private Integer availWidth;

  private Integer availHeight;

  private Double devicePixelRatio;

  private ScreenOrientation orientation;

  private Integer colorDepth;

  private Boolean isExtended;

  private Boolean isInternal;

  private Boolean isPrimary;

  private String label;

  private String id;

  /** Offset of the left edge of the screen. */
  public Integer getLeft() {
    return left;
  }

  /** Offset of the left edge of the screen. */
  public void setLeft(Integer left) {
    this.left = left;
  }

  /** Offset of the top edge of the screen. */
  public Integer getTop() {
    return top;
  }

  /** Offset of the top edge of the screen. */
  public void setTop(Integer top) {
    this.top = top;
  }

  /** Width of the screen. */
  public Integer getWidth() {
    return width;
  }

  /** Width of the screen. */
  public void setWidth(Integer width) {
    this.width = width;
  }

  /** Height of the screen. */
  public Integer getHeight() {
    return height;
  }

  /** Height of the screen. */
  public void setHeight(Integer height) {
    this.height = height;
  }

  /** Offset of the left edge of the available screen area. */
  public Integer getAvailLeft() {
    return availLeft;
  }

  /** Offset of the left edge of the available screen area. */
  public void setAvailLeft(Integer availLeft) {
    this.availLeft = availLeft;
  }

  /** Offset of the top edge of the available screen area. */
  public Integer getAvailTop() {
    return availTop;
  }

  /** Offset of the top edge of the available screen area. */
  public void setAvailTop(Integer availTop) {
    this.availTop = availTop;
  }

  /** Width of the available screen area. */
  public Integer getAvailWidth() {
    return availWidth;
  }

  /** Width of the available screen area. */
  public void setAvailWidth(Integer availWidth) {
    this.availWidth = availWidth;
  }

  /** Height of the available screen area. */
  public Integer getAvailHeight() {
    return availHeight;
  }

  /** Height of the available screen area. */
  public void setAvailHeight(Integer availHeight) {
    this.availHeight = availHeight;
  }

  /** Specifies the screen's device pixel ratio. */
  public Double getDevicePixelRatio() {
    return devicePixelRatio;
  }

  /** Specifies the screen's device pixel ratio. */
  public void setDevicePixelRatio(Double devicePixelRatio) {
    this.devicePixelRatio = devicePixelRatio;
  }

  /** Specifies the screen's orientation. */
  public ScreenOrientation getOrientation() {
    return orientation;
  }

  /** Specifies the screen's orientation. */
  public void setOrientation(ScreenOrientation orientation) {
    this.orientation = orientation;
  }

  /** Specifies the screen's color depth in bits. */
  public Integer getColorDepth() {
    return colorDepth;
  }

  /** Specifies the screen's color depth in bits. */
  public void setColorDepth(Integer colorDepth) {
    this.colorDepth = colorDepth;
  }

  /** Indicates whether the device has multiple screens. */
  public Boolean getIsExtended() {
    return isExtended;
  }

  /** Indicates whether the device has multiple screens. */
  public void setIsExtended(Boolean isExtended) {
    this.isExtended = isExtended;
  }

  /** Indicates whether the screen is internal to the device or external, attached to the device. */
  public Boolean getIsInternal() {
    return isInternal;
  }

  /** Indicates whether the screen is internal to the device or external, attached to the device. */
  public void setIsInternal(Boolean isInternal) {
    this.isInternal = isInternal;
  }

  /** Indicates whether the screen is set as the the operating system primary screen. */
  public Boolean getIsPrimary() {
    return isPrimary;
  }

  /** Indicates whether the screen is set as the the operating system primary screen. */
  public void setIsPrimary(Boolean isPrimary) {
    this.isPrimary = isPrimary;
  }

  /** Specifies the descriptive label for the screen. */
  public String getLabel() {
    return label;
  }

  /** Specifies the descriptive label for the screen. */
  public void setLabel(String label) {
    this.label = label;
  }

  /** Specifies the unique identifier of the screen. */
  public String getId() {
    return id;
  }

  /** Specifies the unique identifier of the screen. */
  public void setId(String id) {
    this.id = id;
  }
}
