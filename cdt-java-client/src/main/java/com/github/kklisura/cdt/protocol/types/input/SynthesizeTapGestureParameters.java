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

/** Parameters for the synthesizeTapGesture command. */
public class SynthesizeTapGestureParameters {

  @ParamName("x")
  private Double x;

  @ParamName("y")
  private Double y;

  @Optional
  @ParamName("duration")
  private Integer duration;

  @Optional
  @ParamName("tapCount")
  private Integer tapCount;

  @Optional
  @ParamName("gestureSourceType")
  private GestureSourceType gestureSourceType;

  /** X coordinate of the start of the gesture in CSS pixels. */
  public Double getX() {
    return x;
  }

  /** X coordinate of the start of the gesture in CSS pixels. */
  public SynthesizeTapGestureParameters setX(Double x) {
    this.x = x;
    return this;
  }

  /** Y coordinate of the start of the gesture in CSS pixels. */
  public Double getY() {
    return y;
  }

  /** Y coordinate of the start of the gesture in CSS pixels. */
  public SynthesizeTapGestureParameters setY(Double y) {
    this.y = y;
    return this;
  }

  /** Duration between touchdown and touchup events in ms (default: 50). */
  public Integer getDuration() {
    return duration;
  }

  /** Duration between touchdown and touchup events in ms (default: 50). */
  public SynthesizeTapGestureParameters setDuration(Integer duration) {
    this.duration = duration;
    return this;
  }

  /** Number of times to perform the tap (e.g. 2 for double tap, default: 1). */
  public Integer getTapCount() {
    return tapCount;
  }

  /** Number of times to perform the tap (e.g. 2 for double tap, default: 1). */
  public SynthesizeTapGestureParameters setTapCount(Integer tapCount) {
    this.tapCount = tapCount;
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
  public SynthesizeTapGestureParameters setGestureSourceType(GestureSourceType gestureSourceType) {
    this.gestureSourceType = gestureSourceType;
    return this;
  }
}
