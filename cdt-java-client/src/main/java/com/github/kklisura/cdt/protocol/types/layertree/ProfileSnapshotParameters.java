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
import com.github.kklisura.cdt.protocol.types.dom.Rect;

/** Parameters for the profileSnapshot command. */
public class ProfileSnapshotParameters {

  @ParamName("snapshotId")
  private String snapshotId;

  @Optional
  @ParamName("minRepeatCount")
  private Integer minRepeatCount;

  @Optional
  @ParamName("minDuration")
  private Double minDuration;

  @Optional
  @ParamName("clipRect")
  private Rect clipRect;

  /** The id of the layer snapshot. */
  public String getSnapshotId() {
    return snapshotId;
  }

  /** The id of the layer snapshot. */
  public ProfileSnapshotParameters setSnapshotId(String snapshotId) {
    this.snapshotId = snapshotId;
    return this;
  }

  /** The maximum number of times to replay the snapshot (1, if not specified). */
  public Integer getMinRepeatCount() {
    return minRepeatCount;
  }

  /** The maximum number of times to replay the snapshot (1, if not specified). */
  public ProfileSnapshotParameters setMinRepeatCount(Integer minRepeatCount) {
    this.minRepeatCount = minRepeatCount;
    return this;
  }

  /** The minimum duration (in seconds) to replay the snapshot. */
  public Double getMinDuration() {
    return minDuration;
  }

  /** The minimum duration (in seconds) to replay the snapshot. */
  public ProfileSnapshotParameters setMinDuration(Double minDuration) {
    this.minDuration = minDuration;
    return this;
  }

  /** The clip rectangle to apply when replaying the snapshot. */
  public Rect getClipRect() {
    return clipRect;
  }

  /** The clip rectangle to apply when replaying the snapshot. */
  public ProfileSnapshotParameters setClipRect(Rect clipRect) {
    this.clipRect = clipRect;
    return this;
  }
}
