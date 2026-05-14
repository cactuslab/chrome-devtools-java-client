package com.github.kklisura.cdt.protocol.types.profiler;

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

/** Parameters for the startPreciseCoverage command. */
public class StartPreciseCoverageParameters {

  @Optional
  @ParamName("callCount")
  private Boolean callCount;

  @Optional
  @ParamName("detailed")
  private Boolean detailed;

  @Optional
  @ParamName("allowTriggeredUpdates")
  private Boolean allowTriggeredUpdates;

  /** Collect accurate call counts beyond simple 'covered' or 'not covered'. */
  public Boolean getCallCount() {
    return callCount;
  }

  /** Collect accurate call counts beyond simple 'covered' or 'not covered'. */
  public StartPreciseCoverageParameters setCallCount(Boolean callCount) {
    this.callCount = callCount;
    return this;
  }

  /** Collect block-based coverage. */
  public Boolean getDetailed() {
    return detailed;
  }

  /** Collect block-based coverage. */
  public StartPreciseCoverageParameters setDetailed(Boolean detailed) {
    this.detailed = detailed;
    return this;
  }

  /** Allow the backend to send updates on its own initiative */
  public Boolean getAllowTriggeredUpdates() {
    return allowTriggeredUpdates;
  }

  /** Allow the backend to send updates on its own initiative */
  public StartPreciseCoverageParameters setAllowTriggeredUpdates(Boolean allowTriggeredUpdates) {
    this.allowTriggeredUpdates = allowTriggeredUpdates;
    return this;
  }
}
