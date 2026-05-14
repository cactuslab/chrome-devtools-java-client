package com.github.kklisura.cdt.protocol.types.layertree;

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

/** Parameters for the replaySnapshot command. */
public class ReplaySnapshotParameters {

  @ParamName("snapshotId")
  private String snapshotId;

  @Optional
  @ParamName("fromStep")
  private Integer fromStep;

  @Optional
  @ParamName("toStep")
  private Integer toStep;

  @Optional
  @ParamName("scale")
  private Double scale;

  /** The id of the layer snapshot. */
  public String getSnapshotId() {
    return snapshotId;
  }

  /** The id of the layer snapshot. */
  public ReplaySnapshotParameters setSnapshotId(String snapshotId) {
    this.snapshotId = snapshotId;
    return this;
  }

  /** The first step to replay from (replay from the very start if not specified). */
  public Integer getFromStep() {
    return fromStep;
  }

  /** The first step to replay from (replay from the very start if not specified). */
  public ReplaySnapshotParameters setFromStep(Integer fromStep) {
    this.fromStep = fromStep;
    return this;
  }

  /** The last step to replay to (replay till the end if not specified). */
  public Integer getToStep() {
    return toStep;
  }

  /** The last step to replay to (replay till the end if not specified). */
  public ReplaySnapshotParameters setToStep(Integer toStep) {
    this.toStep = toStep;
    return this;
  }

  /** The scale to apply while replaying (defaults to 1). */
  public Double getScale() {
    return scale;
  }

  /** The scale to apply while replaying (defaults to 1). */
  public ReplaySnapshotParameters setScale(Double scale) {
    this.scale = scale;
    return this;
  }
}
