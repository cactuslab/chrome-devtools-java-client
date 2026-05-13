package com.github.kklisura.cdt.protocol.types.smartcardemulation;

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

/** Maps to the |SCARD_STATE_*| flags. */
public class ReaderStateFlags {

  @Optional private Boolean unaware;

  @Optional private Boolean ignore;

  @Optional private Boolean changed;

  @Optional private Boolean unknown;

  @Optional private Boolean unavailable;

  @Optional private Boolean empty;

  @Optional private Boolean present;

  @Optional private Boolean exclusive;

  @Optional private Boolean inuse;

  @Optional private Boolean mute;

  @Optional private Boolean unpowered;

  public Boolean getUnaware() {
    return unaware;
  }

  public void setUnaware(Boolean unaware) {
    this.unaware = unaware;
  }

  public Boolean getIgnore() {
    return ignore;
  }

  public void setIgnore(Boolean ignore) {
    this.ignore = ignore;
  }

  public Boolean getChanged() {
    return changed;
  }

  public void setChanged(Boolean changed) {
    this.changed = changed;
  }

  public Boolean getUnknown() {
    return unknown;
  }

  public void setUnknown(Boolean unknown) {
    this.unknown = unknown;
  }

  public Boolean getUnavailable() {
    return unavailable;
  }

  public void setUnavailable(Boolean unavailable) {
    this.unavailable = unavailable;
  }

  public Boolean getEmpty() {
    return empty;
  }

  public void setEmpty(Boolean empty) {
    this.empty = empty;
  }

  public Boolean getPresent() {
    return present;
  }

  public void setPresent(Boolean present) {
    this.present = present;
  }

  public Boolean getExclusive() {
    return exclusive;
  }

  public void setExclusive(Boolean exclusive) {
    this.exclusive = exclusive;
  }

  public Boolean getInuse() {
    return inuse;
  }

  public void setInuse(Boolean inuse) {
    this.inuse = inuse;
  }

  public Boolean getMute() {
    return mute;
  }

  public void setMute(Boolean mute) {
    this.mute = mute;
  }

  public Boolean getUnpowered() {
    return unpowered;
  }

  public void setUnpowered(Boolean unpowered) {
    this.unpowered = unpowered;
  }
}
