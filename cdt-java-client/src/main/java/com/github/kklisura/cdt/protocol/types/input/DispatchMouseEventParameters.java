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

import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;

/** Parameters for the dispatchMouseEvent command. */
public class DispatchMouseEventParameters {

  @ParamName("type")
  private DispatchMouseEventType type;

  @ParamName("x")
  private Double x;

  @ParamName("y")
  private Double y;

  @Optional
  @ParamName("modifiers")
  private Integer modifiers;

  @Optional
  @ParamName("timestamp")
  private Double timestamp;

  @Optional
  @ParamName("button")
  private MouseButton button;

  @Optional
  @ParamName("buttons")
  private Integer buttons;

  @Optional
  @ParamName("clickCount")
  private Integer clickCount;

  @Experimental
  @Optional
  @ParamName("force")
  private Double force;

  @Experimental
  @Optional
  @ParamName("tangentialPressure")
  private Double tangentialPressure;

  @Optional
  @ParamName("tiltX")
  private Double tiltX;

  @Optional
  @ParamName("tiltY")
  private Double tiltY;

  @Experimental
  @Optional
  @ParamName("twist")
  private Integer twist;

  @Optional
  @ParamName("deltaX")
  private Double deltaX;

  @Optional
  @ParamName("deltaY")
  private Double deltaY;

  @Optional
  @ParamName("pointerType")
  private DispatchMouseEventPointerType pointerType;

  /** Type of the mouse event. */
  public DispatchMouseEventType getType() {
    return type;
  }

  /** Type of the mouse event. */
  public DispatchMouseEventParameters setType(DispatchMouseEventType type) {
    this.type = type;
    return this;
  }

  /** X coordinate of the event relative to the main frame's viewport in CSS pixels. */
  public Double getX() {
    return x;
  }

  /** X coordinate of the event relative to the main frame's viewport in CSS pixels. */
  public DispatchMouseEventParameters setX(Double x) {
    this.x = x;
    return this;
  }

  /**
   * Y coordinate of the event relative to the main frame's viewport in CSS pixels. 0 refers to the
   * top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
   */
  public Double getY() {
    return y;
  }

  /**
   * Y coordinate of the event relative to the main frame's viewport in CSS pixels. 0 refers to the
   * top of the viewport and Y increases as it proceeds towards the bottom of the viewport.
   */
  public DispatchMouseEventParameters setY(Double y) {
    this.y = y;
    return this;
  }

  /**
   * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default:
   * 0).
   */
  public Integer getModifiers() {
    return modifiers;
  }

  /**
   * Bit field representing pressed modifier keys. Alt=1, Ctrl=2, Meta/Command=4, Shift=8 (default:
   * 0).
   */
  public DispatchMouseEventParameters setModifiers(Integer modifiers) {
    this.modifiers = modifiers;
    return this;
  }

  /** Time at which the event occurred. */
  public Double getTimestamp() {
    return timestamp;
  }

  /** Time at which the event occurred. */
  public DispatchMouseEventParameters setTimestamp(Double timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /** Mouse button (default: "none"). */
  public MouseButton getButton() {
    return button;
  }

  /** Mouse button (default: "none"). */
  public DispatchMouseEventParameters setButton(MouseButton button) {
    this.button = button;
    return this;
  }

  /**
   * A number indicating which buttons are pressed on the mouse when a mouse event is triggered.
   * Left=1, Right=2, Middle=4, Back=8, Forward=16, None=0.
   */
  public Integer getButtons() {
    return buttons;
  }

  /**
   * A number indicating which buttons are pressed on the mouse when a mouse event is triggered.
   * Left=1, Right=2, Middle=4, Back=8, Forward=16, None=0.
   */
  public DispatchMouseEventParameters setButtons(Integer buttons) {
    this.buttons = buttons;
    return this;
  }

  /** Number of times the mouse button was clicked (default: 0). */
  public Integer getClickCount() {
    return clickCount;
  }

  /** Number of times the mouse button was clicked (default: 0). */
  public DispatchMouseEventParameters setClickCount(Integer clickCount) {
    this.clickCount = clickCount;
    return this;
  }

  /** The normalized pressure, which has a range of [0,1] (default: 0). */
  public Double getForce() {
    return force;
  }

  /** The normalized pressure, which has a range of [0,1] (default: 0). */
  public DispatchMouseEventParameters setForce(Double force) {
    this.force = force;
    return this;
  }

  /** The normalized tangential pressure, which has a range of [-1,1] (default: 0). */
  public Double getTangentialPressure() {
    return tangentialPressure;
  }

  /** The normalized tangential pressure, which has a range of [-1,1] (default: 0). */
  public DispatchMouseEventParameters setTangentialPressure(Double tangentialPressure) {
    this.tangentialPressure = tangentialPressure;
    return this;
  }

  /**
   * The plane angle between the Y-Z plane and the plane containing both the stylus axis and the Y
   * axis, in degrees of the range [-90,90], a positive tiltX is to the right (default: 0).
   */
  public Double getTiltX() {
    return tiltX;
  }

  /**
   * The plane angle between the Y-Z plane and the plane containing both the stylus axis and the Y
   * axis, in degrees of the range [-90,90], a positive tiltX is to the right (default: 0).
   */
  public DispatchMouseEventParameters setTiltX(Double tiltX) {
    this.tiltX = tiltX;
    return this;
  }

  /**
   * The plane angle between the X-Z plane and the plane containing both the stylus axis and the X
   * axis, in degrees of the range [-90,90], a positive tiltY is towards the user (default: 0).
   */
  public Double getTiltY() {
    return tiltY;
  }

  /**
   * The plane angle between the X-Z plane and the plane containing both the stylus axis and the X
   * axis, in degrees of the range [-90,90], a positive tiltY is towards the user (default: 0).
   */
  public DispatchMouseEventParameters setTiltY(Double tiltY) {
    this.tiltY = tiltY;
    return this;
  }

  /**
   * The clockwise rotation of a pen stylus around its own major axis, in degrees in the range
   * [0,359] (default: 0).
   */
  public Integer getTwist() {
    return twist;
  }

  /**
   * The clockwise rotation of a pen stylus around its own major axis, in degrees in the range
   * [0,359] (default: 0).
   */
  public DispatchMouseEventParameters setTwist(Integer twist) {
    this.twist = twist;
    return this;
  }

  /** X delta in CSS pixels for mouse wheel event (default: 0). */
  public Double getDeltaX() {
    return deltaX;
  }

  /** X delta in CSS pixels for mouse wheel event (default: 0). */
  public DispatchMouseEventParameters setDeltaX(Double deltaX) {
    this.deltaX = deltaX;
    return this;
  }

  /** Y delta in CSS pixels for mouse wheel event (default: 0). */
  public Double getDeltaY() {
    return deltaY;
  }

  /** Y delta in CSS pixels for mouse wheel event (default: 0). */
  public DispatchMouseEventParameters setDeltaY(Double deltaY) {
    this.deltaY = deltaY;
    return this;
  }

  /** Pointer type (default: "mouse"). */
  public DispatchMouseEventPointerType getPointerType() {
    return pointerType;
  }

  /** Pointer type (default: "mouse"). */
  public DispatchMouseEventParameters setPointerType(DispatchMouseEventPointerType pointerType) {
    this.pointerType = pointerType;
    return this;
  }
}
