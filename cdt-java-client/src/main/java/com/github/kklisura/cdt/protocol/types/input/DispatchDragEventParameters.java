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

/** Parameters for the dispatchDragEvent command. */
public class DispatchDragEventParameters {

  @ParamName("type")
  private DispatchDragEventType type;

  @ParamName("x")
  private Double x;

  @ParamName("y")
  private Double y;

  @ParamName("data")
  private DragData data;

  @Optional
  @ParamName("modifiers")
  private Integer modifiers;

  /** Type of the drag event. */
  public DispatchDragEventType getType() {
    return type;
  }

  /** Type of the drag event. */
  public DispatchDragEventParameters setType(DispatchDragEventType type) {
    this.type = type;
    return this;
  }

  /** X coordinate of the event relative to the main frame's viewport in CSS pixels. */
  public Double getX() {
    return x;
  }

  /** X coordinate of the event relative to the main frame's viewport in CSS pixels. */
  public DispatchDragEventParameters setX(Double x) {
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
  public DispatchDragEventParameters setY(Double y) {
    this.y = y;
    return this;
  }

  public DragData getData() {
    return data;
  }

  public DispatchDragEventParameters setData(DragData data) {
    this.data = data;
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
  public DispatchDragEventParameters setModifiers(Integer modifiers) {
    this.modifiers = modifiers;
    return this;
  }
}
