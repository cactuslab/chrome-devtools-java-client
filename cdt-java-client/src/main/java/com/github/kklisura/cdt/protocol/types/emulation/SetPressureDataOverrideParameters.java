package com.github.kklisura.cdt.protocol.types.emulation;

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

/** Parameters for the setPressureDataOverride command. */
public class SetPressureDataOverrideParameters {

  @ParamName("source")
  private PressureSource source;

  @ParamName("state")
  private PressureState state;

  @Optional
  @ParamName("ownContributionEstimate")
  private Double ownContributionEstimate;

  public PressureSource getSource() {
    return source;
  }

  public SetPressureDataOverrideParameters setSource(PressureSource source) {
    this.source = source;
    return this;
  }

  public PressureState getState() {
    return state;
  }

  public SetPressureDataOverrideParameters setState(PressureState state) {
    this.state = state;
    return this;
  }

  public Double getOwnContributionEstimate() {
    return ownContributionEstimate;
  }

  public SetPressureDataOverrideParameters setOwnContributionEstimate(
      Double ownContributionEstimate) {
    this.ownContributionEstimate = ownContributionEstimate;
    return this;
  }
}
