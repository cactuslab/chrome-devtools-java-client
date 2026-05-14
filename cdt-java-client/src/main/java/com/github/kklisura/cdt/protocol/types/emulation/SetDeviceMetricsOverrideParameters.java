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
import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;
import com.github.kklisura.cdt.protocol.types.page.Viewport;

/** Parameters for the setDeviceMetricsOverride command. */
public class SetDeviceMetricsOverrideParameters {

  @ParamName("width")
  private Integer width;

  @ParamName("height")
  private Integer height;

  @ParamName("deviceScaleFactor")
  private Double deviceScaleFactor;

  @ParamName("mobile")
  private Boolean mobile;

  @Experimental
  @Optional
  @ParamName("scale")
  private Double scale;

  @Experimental
  @Optional
  @ParamName("screenWidth")
  private Integer screenWidth;

  @Experimental
  @Optional
  @ParamName("screenHeight")
  private Integer screenHeight;

  @Experimental
  @Optional
  @ParamName("positionX")
  private Integer positionX;

  @Experimental
  @Optional
  @ParamName("positionY")
  private Integer positionY;

  @Experimental
  @Optional
  @ParamName("dontSetVisibleSize")
  private Boolean dontSetVisibleSize;

  @Optional
  @ParamName("screenOrientation")
  private ScreenOrientation screenOrientation;

  @Experimental
  @Optional
  @ParamName("viewport")
  private Viewport viewport;

  @Deprecated
  @Experimental
  @Optional
  @ParamName("displayFeature")
  private DisplayFeature displayFeature;

  @Deprecated
  @Experimental
  @Optional
  @ParamName("devicePosture")
  private DevicePosture devicePosture;

  @Experimental
  @Optional
  @ParamName("scrollbarType")
  private SetDeviceMetricsOverrideScrollbarType scrollbarType;

  @Experimental
  @Optional
  @ParamName("screenOrientationLockEmulation")
  private Boolean screenOrientationLockEmulation;

  /** Overriding width value in pixels (minimum 0, maximum 10000000). 0 disables the override. */
  public Integer getWidth() {
    return width;
  }

  /** Overriding width value in pixels (minimum 0, maximum 10000000). 0 disables the override. */
  public SetDeviceMetricsOverrideParameters setWidth(Integer width) {
    this.width = width;
    return this;
  }

  /** Overriding height value in pixels (minimum 0, maximum 10000000). 0 disables the override. */
  public Integer getHeight() {
    return height;
  }

  /** Overriding height value in pixels (minimum 0, maximum 10000000). 0 disables the override. */
  public SetDeviceMetricsOverrideParameters setHeight(Integer height) {
    this.height = height;
    return this;
  }

  /** Overriding device scale factor value. 0 disables the override. */
  public Double getDeviceScaleFactor() {
    return deviceScaleFactor;
  }

  /** Overriding device scale factor value. 0 disables the override. */
  public SetDeviceMetricsOverrideParameters setDeviceScaleFactor(Double deviceScaleFactor) {
    this.deviceScaleFactor = deviceScaleFactor;
    return this;
  }

  /**
   * Whether to emulate mobile device. This includes viewport meta tag, overlay scrollbars, text
   * autosizing and more.
   */
  public Boolean getMobile() {
    return mobile;
  }

  /**
   * Whether to emulate mobile device. This includes viewport meta tag, overlay scrollbars, text
   * autosizing and more.
   */
  public SetDeviceMetricsOverrideParameters setMobile(Boolean mobile) {
    this.mobile = mobile;
    return this;
  }

  /** Scale to apply to resulting view image. */
  public Double getScale() {
    return scale;
  }

  /** Scale to apply to resulting view image. */
  public SetDeviceMetricsOverrideParameters setScale(Double scale) {
    this.scale = scale;
    return this;
  }

  /** Overriding screen width value in pixels (minimum 0, maximum 10000000). */
  public Integer getScreenWidth() {
    return screenWidth;
  }

  /** Overriding screen width value in pixels (minimum 0, maximum 10000000). */
  public SetDeviceMetricsOverrideParameters setScreenWidth(Integer screenWidth) {
    this.screenWidth = screenWidth;
    return this;
  }

  /** Overriding screen height value in pixels (minimum 0, maximum 10000000). */
  public Integer getScreenHeight() {
    return screenHeight;
  }

  /** Overriding screen height value in pixels (minimum 0, maximum 10000000). */
  public SetDeviceMetricsOverrideParameters setScreenHeight(Integer screenHeight) {
    this.screenHeight = screenHeight;
    return this;
  }

  /** Overriding view X position on screen in pixels (minimum 0, maximum 10000000). */
  public Integer getPositionX() {
    return positionX;
  }

  /** Overriding view X position on screen in pixels (minimum 0, maximum 10000000). */
  public SetDeviceMetricsOverrideParameters setPositionX(Integer positionX) {
    this.positionX = positionX;
    return this;
  }

  /** Overriding view Y position on screen in pixels (minimum 0, maximum 10000000). */
  public Integer getPositionY() {
    return positionY;
  }

  /** Overriding view Y position on screen in pixels (minimum 0, maximum 10000000). */
  public SetDeviceMetricsOverrideParameters setPositionY(Integer positionY) {
    this.positionY = positionY;
    return this;
  }

  /** Do not set visible view size, rely upon explicit setVisibleSize call. */
  public Boolean getDontSetVisibleSize() {
    return dontSetVisibleSize;
  }

  /** Do not set visible view size, rely upon explicit setVisibleSize call. */
  public SetDeviceMetricsOverrideParameters setDontSetVisibleSize(Boolean dontSetVisibleSize) {
    this.dontSetVisibleSize = dontSetVisibleSize;
    return this;
  }

  /** Screen orientation override. */
  public ScreenOrientation getScreenOrientation() {
    return screenOrientation;
  }

  /** Screen orientation override. */
  public SetDeviceMetricsOverrideParameters setScreenOrientation(
      ScreenOrientation screenOrientation) {
    this.screenOrientation = screenOrientation;
    return this;
  }

  /**
   * If set, the visible area of the page will be overridden to this viewport. This viewport change
   * is not observed by the page, e.g. viewport-relative elements do not change positions.
   */
  public Viewport getViewport() {
    return viewport;
  }

  /**
   * If set, the visible area of the page will be overridden to this viewport. This viewport change
   * is not observed by the page, e.g. viewport-relative elements do not change positions.
   */
  public SetDeviceMetricsOverrideParameters setViewport(Viewport viewport) {
    this.viewport = viewport;
    return this;
  }

  /**
   * If set, the display feature of a multi-segment screen. If not set, multi-segment support is
   * turned-off. Deprecated, use Emulation.setDisplayFeaturesOverride.
   */
  public DisplayFeature getDisplayFeature() {
    return displayFeature;
  }

  /**
   * If set, the display feature of a multi-segment screen. If not set, multi-segment support is
   * turned-off. Deprecated, use Emulation.setDisplayFeaturesOverride.
   */
  public SetDeviceMetricsOverrideParameters setDisplayFeature(DisplayFeature displayFeature) {
    this.displayFeature = displayFeature;
    return this;
  }

  /**
   * If set, the posture of a foldable device. If not set the posture is set to continuous.
   * Deprecated, use Emulation.setDevicePostureOverride.
   */
  public DevicePosture getDevicePosture() {
    return devicePosture;
  }

  /**
   * If set, the posture of a foldable device. If not set the posture is set to continuous.
   * Deprecated, use Emulation.setDevicePostureOverride.
   */
  public SetDeviceMetricsOverrideParameters setDevicePosture(DevicePosture devicePosture) {
    this.devicePosture = devicePosture;
    return this;
  }

  /** Scrollbar type. Default: `default`. */
  public SetDeviceMetricsOverrideScrollbarType getScrollbarType() {
    return scrollbarType;
  }

  /** Scrollbar type. Default: `default`. */
  public SetDeviceMetricsOverrideParameters setScrollbarType(
      SetDeviceMetricsOverrideScrollbarType scrollbarType) {
    this.scrollbarType = scrollbarType;
    return this;
  }

  /**
   * If set to true, enables screen orientation lock emulation, which intercepts
   * screen.orientation.lock() calls from the page and reports orientation changes via
   * screenOrientationLockChanged events. This is useful for emulating mobile device orientation
   * lock behavior in responsive design mode.
   */
  public Boolean getScreenOrientationLockEmulation() {
    return screenOrientationLockEmulation;
  }

  /**
   * If set to true, enables screen orientation lock emulation, which intercepts
   * screen.orientation.lock() calls from the page and reports orientation changes via
   * screenOrientationLockChanged events. This is useful for emulating mobile device orientation
   * lock behavior in responsive design mode.
   */
  public SetDeviceMetricsOverrideParameters setScreenOrientationLockEmulation(
      Boolean screenOrientationLockEmulation) {
    this.screenOrientationLockEmulation = screenOrientationLockEmulation;
    return this;
  }
}
