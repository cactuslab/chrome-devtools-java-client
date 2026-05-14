package com.github.kklisura.cdt.protocol.types.heapprofiler;

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
  private Double samplingInterval;

  @Optional
  @ParamName("stackDepth")
  private Double stackDepth;

  @Optional
  @ParamName("includeObjectsCollectedByMajorGC")
  private Boolean includeObjectsCollectedByMajorGC;

  @Optional
  @ParamName("includeObjectsCollectedByMinorGC")
  private Boolean includeObjectsCollectedByMinorGC;

  /**
   * Average sample interval in bytes. Poisson distribution is used for the intervals. The default
   * value is 32768 bytes.
   */
  public Double getSamplingInterval() {
    return samplingInterval;
  }

  /**
   * Average sample interval in bytes. Poisson distribution is used for the intervals. The default
   * value is 32768 bytes.
   */
  public StartSamplingParameters setSamplingInterval(Double samplingInterval) {
    this.samplingInterval = samplingInterval;
    return this;
  }

  /** Maximum stack depth. The default value is 128. */
  public Double getStackDepth() {
    return stackDepth;
  }

  /** Maximum stack depth. The default value is 128. */
  public StartSamplingParameters setStackDepth(Double stackDepth) {
    this.stackDepth = stackDepth;
    return this;
  }

  /**
   * By default, the sampling heap profiler reports only objects which are still alive when the
   * profile is returned via getSamplingProfile or stopSampling, which is useful for determining
   * what functions contribute the most to steady-state memory usage. This flag instructs the
   * sampling heap profiler to also include information about objects discarded by major GC, which
   * will show which functions cause large temporary memory usage or long GC pauses.
   */
  public Boolean getIncludeObjectsCollectedByMajorGC() {
    return includeObjectsCollectedByMajorGC;
  }

  /**
   * By default, the sampling heap profiler reports only objects which are still alive when the
   * profile is returned via getSamplingProfile or stopSampling, which is useful for determining
   * what functions contribute the most to steady-state memory usage. This flag instructs the
   * sampling heap profiler to also include information about objects discarded by major GC, which
   * will show which functions cause large temporary memory usage or long GC pauses.
   */
  public StartSamplingParameters setIncludeObjectsCollectedByMajorGC(
      Boolean includeObjectsCollectedByMajorGC) {
    this.includeObjectsCollectedByMajorGC = includeObjectsCollectedByMajorGC;
    return this;
  }

  /**
   * By default, the sampling heap profiler reports only objects which are still alive when the
   * profile is returned via getSamplingProfile or stopSampling, which is useful for determining
   * what functions contribute the most to steady-state memory usage. This flag instructs the
   * sampling heap profiler to also include information about objects discarded by minor GC, which
   * is useful when tuning a latency-sensitive application for minimal GC activity.
   */
  public Boolean getIncludeObjectsCollectedByMinorGC() {
    return includeObjectsCollectedByMinorGC;
  }

  /**
   * By default, the sampling heap profiler reports only objects which are still alive when the
   * profile is returned via getSamplingProfile or stopSampling, which is useful for determining
   * what functions contribute the most to steady-state memory usage. This flag instructs the
   * sampling heap profiler to also include information about objects discarded by minor GC, which
   * is useful when tuning a latency-sensitive application for minimal GC activity.
   */
  public StartSamplingParameters setIncludeObjectsCollectedByMinorGC(
      Boolean includeObjectsCollectedByMinorGC) {
    this.includeObjectsCollectedByMinorGC = includeObjectsCollectedByMinorGC;
    return this;
  }
}
