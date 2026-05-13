package com.github.kklisura.cdt.protocol.events.emulation;

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
import com.github.kklisura.cdt.protocol.types.emulation.ScreenOrientation;

/**
 * Fired when a page calls screen.orientation.lock() or screen.orientation.unlock() while device
 * emulation is enabled. This allows the DevTools frontend to update the emulated device orientation
 * accordingly.
 */
@Experimental
public class ScreenOrientationLockChanged {

  private Boolean locked;

  @Optional private ScreenOrientation orientation;

  /** Whether the screen orientation is currently locked. */
  public Boolean getLocked() {
    return locked;
  }

  /** Whether the screen orientation is currently locked. */
  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  /** The orientation lock type requested by the page. Only set when locked is true. */
  public ScreenOrientation getOrientation() {
    return orientation;
  }

  /** The orientation lock type requested by the page. Only set when locked is true. */
  public void setOrientation(ScreenOrientation orientation) {
    this.orientation = orientation;
  }
}
