package com.github.kklisura.cdt.protocol.types.input;

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

/** Parameters for the synthesizeScrollGesture command. */
public class SynthesizeScrollGestureParameters {

  @ParamName("x")
  private Double x;

  @ParamName("y")
  private Double y;

  @Optional
  @ParamName("xDistance")
  private Double xDistance;

  @Optional
  @ParamName("yDistance")
  private Double yDistance;

  @Optional
  @ParamName("xOverscroll")
  private Double xOverscroll;

  @Optional
  @ParamName("yOverscroll")
  private Double yOverscroll;

  @Optional
  @ParamName("preventFling")
  private Boolean preventFling;

  @Optional
  @ParamName("speed")
  private Integer speed;

  @Optional
  @ParamName("gestureSourceType")
  private GestureSourceType gestureSourceType;

  @Optional
  @ParamName("repeatCount")
  private Integer repeatCount;

  @Optional
  @ParamName("repeatDelayMs")
  private Integer repeatDelayMs;

  @Optional
  @ParamName("interactionMarkerName")
  private String interactionMarkerName;

  /** X coordinate of the start of the gesture in CSS pixels. */
  public Double getX() {
    return x;
  }

  /** X coordinate of the start of the gesture in CSS pixels. */
  public SynthesizeScrollGestureParameters setX(Double x) {
    this.x = x;
    return this;
  }

  /** Y coordinate of the start of the gesture in CSS pixels. */
  public Double getY() {
    return y;
  }

  /** Y coordinate of the start of the gesture in CSS pixels. */
  public SynthesizeScrollGestureParameters setY(Double y) {
    this.y = y;
    return this;
  }

  /** The distance to scroll along the X axis (positive to scroll left). */
  public Double getXDistance() {
    return xDistance;
  }

  /** The distance to scroll along the X axis (positive to scroll left). */
  public SynthesizeScrollGestureParameters setXDistance(Double xDistance) {
    this.xDistance = xDistance;
    return this;
  }

  /** The distance to scroll along the Y axis (positive to scroll up). */
  public Double getYDistance() {
    return yDistance;
  }

  /** The distance to scroll along the Y axis (positive to scroll up). */
  public SynthesizeScrollGestureParameters setYDistance(Double yDistance) {
    this.yDistance = yDistance;
    return this;
  }

  /**
   * The number of additional pixels to scroll back along the X axis, in addition to the given
   * distance.
   */
  public Double getXOverscroll() {
    return xOverscroll;
  }

  /**
   * The number of additional pixels to scroll back along the X axis, in addition to the given
   * distance.
   */
  public SynthesizeScrollGestureParameters setXOverscroll(Double xOverscroll) {
    this.xOverscroll = xOverscroll;
    return this;
  }

  /**
   * The number of additional pixels to scroll back along the Y axis, in addition to the given
   * distance.
   */
  public Double getYOverscroll() {
    return yOverscroll;
  }

  /**
   * The number of additional pixels to scroll back along the Y axis, in addition to the given
   * distance.
   */
  public SynthesizeScrollGestureParameters setYOverscroll(Double yOverscroll) {
    this.yOverscroll = yOverscroll;
    return this;
  }

  /** Prevent fling (default: true). */
  public Boolean getPreventFling() {
    return preventFling;
  }

  /** Prevent fling (default: true). */
  public SynthesizeScrollGestureParameters setPreventFling(Boolean preventFling) {
    this.preventFling = preventFling;
    return this;
  }

  /** Swipe speed in pixels per second (default: 800). */
  public Integer getSpeed() {
    return speed;
  }

  /** Swipe speed in pixels per second (default: 800). */
  public SynthesizeScrollGestureParameters setSpeed(Integer speed) {
    this.speed = speed;
    return this;
  }

  /**
   * Which type of input events to be generated (default: 'default', which queries the platform for
   * the preferred input type).
   */
  public GestureSourceType getGestureSourceType() {
    return gestureSourceType;
  }

  /**
   * Which type of input events to be generated (default: 'default', which queries the platform for
   * the preferred input type).
   */
  public SynthesizeScrollGestureParameters setGestureSourceType(
      GestureSourceType gestureSourceType) {
    this.gestureSourceType = gestureSourceType;
    return this;
  }

  /** The number of times to repeat the gesture (default: 0). */
  public Integer getRepeatCount() {
    return repeatCount;
  }

  /** The number of times to repeat the gesture (default: 0). */
  public SynthesizeScrollGestureParameters setRepeatCount(Integer repeatCount) {
    this.repeatCount = repeatCount;
    return this;
  }

  /** The number of milliseconds delay between each repeat. (default: 250). */
  public Integer getRepeatDelayMs() {
    return repeatDelayMs;
  }

  /** The number of milliseconds delay between each repeat. (default: 250). */
  public SynthesizeScrollGestureParameters setRepeatDelayMs(Integer repeatDelayMs) {
    this.repeatDelayMs = repeatDelayMs;
    return this;
  }

  /** The name of the interaction markers to generate, if not empty (default: ""). */
  public String getInteractionMarkerName() {
    return interactionMarkerName;
  }

  /** The name of the interaction markers to generate, if not empty (default: ""). */
  public SynthesizeScrollGestureParameters setInteractionMarkerName(String interactionMarkerName) {
    this.interactionMarkerName = interactionMarkerName;
    return this;
  }
}
