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

/** Parameters for the emulateTouchFromMouseEvent command. */
public class EmulateTouchFromMouseEventParameters {

  @ParamName("type")
  private EmulateTouchFromMouseEventType type;

  @ParamName("x")
  private Integer x;

  @ParamName("y")
  private Integer y;

  @ParamName("button")
  private MouseButton button;

  @Optional
  @ParamName("timestamp")
  private Double timestamp;

  @Optional
  @ParamName("deltaX")
  private Double deltaX;

  @Optional
  @ParamName("deltaY")
  private Double deltaY;

  @Optional
  @ParamName("modifiers")
  private Integer modifiers;

  @Optional
  @ParamName("clickCount")
  private Integer clickCount;

  /** Type of the mouse event. */
  public EmulateTouchFromMouseEventType getType() {
    return type;
  }

  /** Type of the mouse event. */
  public EmulateTouchFromMouseEventParameters setType(EmulateTouchFromMouseEventType type) {
    this.type = type;
    return this;
  }

  /** X coordinate of the mouse pointer in DIP. */
  public Integer getX() {
    return x;
  }

  /** X coordinate of the mouse pointer in DIP. */
  public EmulateTouchFromMouseEventParameters setX(Integer x) {
    this.x = x;
    return this;
  }

  /** Y coordinate of the mouse pointer in DIP. */
  public Integer getY() {
    return y;
  }

  /** Y coordinate of the mouse pointer in DIP. */
  public EmulateTouchFromMouseEventParameters setY(Integer y) {
    this.y = y;
    return this;
  }

  /** Mouse button. Only "none", "left", "right" are supported. */
  public MouseButton getButton() {
    return button;
  }

  /** Mouse button. Only "none", "left", "right" are supported. */
  public EmulateTouchFromMouseEventParameters setButton(MouseButton button) {
    this.button = button;
    return this;
  }

  /** Time at which the event occurred (default: current time). */
  public Double getTimestamp() {
    return timestamp;
  }

  /** Time at which the event occurred (default: current time). */
  public EmulateTouchFromMouseEventParameters setTimestamp(Double timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /** X delta in DIP for mouse wheel event (default: 0). */
  public Double getDeltaX() {
    return deltaX;
  }

  /** X delta in DIP for mouse wheel event (default: 0). */
  public EmulateTouchFromMouseEventParameters setDeltaX(Double deltaX) {
    this.deltaX = deltaX;
    return this;
  }

  /** Y delta in DIP for mouse wheel event (default: 0). */
  public Double getDeltaY() {
    return deltaY;
  }

  /** Y delta in DIP for mouse wheel event (default: 0). */
  public EmulateTouchFromMouseEventParameters setDeltaY(Double deltaY) {
    this.deltaY = deltaY;
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
  public EmulateTouchFromMouseEventParameters setModifiers(Integer modifiers) {
    this.modifiers = modifiers;
    return this;
  }

  /** Number of times the mouse button was clicked (default: 0). */
  public Integer getClickCount() {
    return clickCount;
  }

  /** Number of times the mouse button was clicked (default: 0). */
  public EmulateTouchFromMouseEventParameters setClickCount(Integer clickCount) {
    this.clickCount = clickCount;
    return this;
  }
}
