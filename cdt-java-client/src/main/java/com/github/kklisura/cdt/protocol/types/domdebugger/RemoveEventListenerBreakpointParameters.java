package com.github.kklisura.cdt.protocol.types.domdebugger;

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

/** Parameters for the removeEventListenerBreakpoint command. */
public class RemoveEventListenerBreakpointParameters {

  @ParamName("eventName")
  private String eventName;

  @Experimental
  @Optional
  @ParamName("targetName")
  private String targetName;

  /** Event name. */
  public String getEventName() {
    return eventName;
  }

  /** Event name. */
  public RemoveEventListenerBreakpointParameters setEventName(String eventName) {
    this.eventName = eventName;
    return this;
  }

  /** EventTarget interface name. */
  public String getTargetName() {
    return targetName;
  }

  /** EventTarget interface name. */
  public RemoveEventListenerBreakpointParameters setTargetName(String targetName) {
    this.targetName = targetName;
    return this;
  }
}
