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

import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;

/** Parameters for the stopTrackingHeapObjects command. */
public class StopTrackingHeapObjectsParameters {

  @Optional
  @ParamName("reportProgress")
  private Boolean reportProgress;

  @Deprecated
  @Optional
  @ParamName("treatGlobalObjectsAsRoots")
  private Boolean treatGlobalObjectsAsRoots;

  @Optional
  @ParamName("captureNumericValue")
  private Boolean captureNumericValue;

  @Experimental
  @Optional
  @ParamName("exposeInternals")
  private Boolean exposeInternals;

  /**
   * If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken
   * when the tracking is stopped.
   */
  public Boolean getReportProgress() {
    return reportProgress;
  }

  /**
   * If true 'reportHeapSnapshotProgress' events will be generated while snapshot is being taken
   * when the tracking is stopped.
   */
  public StopTrackingHeapObjectsParameters setReportProgress(Boolean reportProgress) {
    this.reportProgress = reportProgress;
    return this;
  }

  /** Deprecated in favor of `exposeInternals`. */
  public Boolean getTreatGlobalObjectsAsRoots() {
    return treatGlobalObjectsAsRoots;
  }

  /** Deprecated in favor of `exposeInternals`. */
  public StopTrackingHeapObjectsParameters setTreatGlobalObjectsAsRoots(
      Boolean treatGlobalObjectsAsRoots) {
    this.treatGlobalObjectsAsRoots = treatGlobalObjectsAsRoots;
    return this;
  }

  /** If true, numerical values are included in the snapshot */
  public Boolean getCaptureNumericValue() {
    return captureNumericValue;
  }

  /** If true, numerical values are included in the snapshot */
  public StopTrackingHeapObjectsParameters setCaptureNumericValue(Boolean captureNumericValue) {
    this.captureNumericValue = captureNumericValue;
    return this;
  }

  /** If true, exposes internals of the snapshot. */
  public Boolean getExposeInternals() {
    return exposeInternals;
  }

  /** If true, exposes internals of the snapshot. */
  public StopTrackingHeapObjectsParameters setExposeInternals(Boolean exposeInternals) {
    this.exposeInternals = exposeInternals;
    return this;
  }
}
