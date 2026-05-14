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

/** Parameters for the setSensorOverrideEnabled command. */
public class SetSensorOverrideEnabledParameters {

  @ParamName("enabled")
  private Boolean enabled;

  @ParamName("type")
  private SensorType type;

  @Optional
  @ParamName("metadata")
  private SensorMetadata metadata;

  public Boolean getEnabled() {
    return enabled;
  }

  public SetSensorOverrideEnabledParameters setEnabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  public SensorType getType() {
    return type;
  }

  public SetSensorOverrideEnabledParameters setType(SensorType type) {
    this.type = type;
    return this;
  }

  public SensorMetadata getMetadata() {
    return metadata;
  }

  public SetSensorOverrideEnabledParameters setMetadata(SensorMetadata metadata) {
    this.metadata = metadata;
    return this;
  }
}
