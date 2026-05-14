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
import java.util.List;

/** Parameters for the dispatchTouchEvent command. */
public class DispatchTouchEventParameters {

  @ParamName("type")
  private DispatchTouchEventType type;

  @ParamName("touchPoints")
  private List<TouchPoint> touchPoints;

  @Optional
  @ParamName("modifiers")
  private Integer modifiers;

  @Optional
  @ParamName("timestamp")
  private Double timestamp;

  /**
   * Type of the touch event. TouchEnd and TouchCancel must not contain any touch points, while
   * TouchStart and TouchMove must contains at least one.
   */
  public DispatchTouchEventType getType() {
    return type;
  }

  /**
   * Type of the touch event. TouchEnd and TouchCancel must not contain any touch points, while
   * TouchStart and TouchMove must contains at least one.
   */
  public DispatchTouchEventParameters setType(DispatchTouchEventType type) {
    this.type = type;
    return this;
  }

  /**
   * Active touch points on the touch device. One event per any changed point (compared to previous
   * touch event in a sequence) is generated, emulating pressing/moving/releasing points one by one.
   */
  public List<TouchPoint> getTouchPoints() {
    return touchPoints;
  }

  /**
   * Active touch points on the touch device. One event per any changed point (compared to previous
   * touch event in a sequence) is generated, emulating pressing/moving/releasing points one by one.
   */
  public DispatchTouchEventParameters setTouchPoints(List<TouchPoint> touchPoints) {
    this.touchPoints = touchPoints;
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
  public DispatchTouchEventParameters setModifiers(Integer modifiers) {
    this.modifiers = modifiers;
    return this;
  }

  /** Time at which the event occurred. */
  public Double getTimestamp() {
    return timestamp;
  }

  /** Time at which the event occurred. */
  public DispatchTouchEventParameters setTimestamp(Double timestamp) {
    this.timestamp = timestamp;
    return this;
  }
}
