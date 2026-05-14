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

/** Parameters for the synthesizePinchGesture command. */
public class SynthesizePinchGestureParameters {

  @ParamName("x")
  private Double x;

  @ParamName("y")
  private Double y;

  @ParamName("scaleFactor")
  private Double scaleFactor;

  @Optional
  @ParamName("relativeSpeed")
  private Integer relativeSpeed;

  @Optional
  @ParamName("gestureSourceType")
  private GestureSourceType gestureSourceType;

  /** X coordinate of the start of the gesture in CSS pixels. */
  public Double getX() {
    return x;
  }

  /** X coordinate of the start of the gesture in CSS pixels. */
  public SynthesizePinchGestureParameters setX(Double x) {
    this.x = x;
    return this;
  }

  /** Y coordinate of the start of the gesture in CSS pixels. */
  public Double getY() {
    return y;
  }

  /** Y coordinate of the start of the gesture in CSS pixels. */
  public SynthesizePinchGestureParameters setY(Double y) {
    this.y = y;
    return this;
  }

  /** Relative scale factor after zooming (>1.0 zooms in, <1.0 zooms out). */
  public Double getScaleFactor() {
    return scaleFactor;
  }

  /** Relative scale factor after zooming (>1.0 zooms in, <1.0 zooms out). */
  public SynthesizePinchGestureParameters setScaleFactor(Double scaleFactor) {
    this.scaleFactor = scaleFactor;
    return this;
  }

  /** Relative pointer speed in pixels per second (default: 800). */
  public Integer getRelativeSpeed() {
    return relativeSpeed;
  }

  /** Relative pointer speed in pixels per second (default: 800). */
  public SynthesizePinchGestureParameters setRelativeSpeed(Integer relativeSpeed) {
    this.relativeSpeed = relativeSpeed;
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
  public SynthesizePinchGestureParameters setGestureSourceType(
      GestureSourceType gestureSourceType) {
    this.gestureSourceType = gestureSourceType;
    return this;
  }
}
