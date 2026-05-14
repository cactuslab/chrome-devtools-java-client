package com.github.kklisura.cdt.protocol.types.memory;

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

/** Parameters for the startSampling command. */
public class StartSamplingParameters {

  @Optional
  @ParamName("samplingInterval")
  private Integer samplingInterval;

  @Optional
  @ParamName("suppressRandomness")
  private Boolean suppressRandomness;

  /** Average number of bytes between samples. */
  public Integer getSamplingInterval() {
    return samplingInterval;
  }

  /** Average number of bytes between samples. */
  public StartSamplingParameters setSamplingInterval(Integer samplingInterval) {
    this.samplingInterval = samplingInterval;
    return this;
  }

  /** Do not randomize intervals between samples. */
  public Boolean getSuppressRandomness() {
    return suppressRandomness;
  }

  /** Do not randomize intervals between samples. */
  public StartSamplingParameters setSuppressRandomness(Boolean suppressRandomness) {
    this.suppressRandomness = suppressRandomness;
    return this;
  }
}
