package com.github.kklisura.cdt.protocol.types.storage;

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

/** Parameters for the overrideQuotaForOrigin command. */
public class OverrideQuotaForOriginParameters {

  @ParamName("origin")
  private String origin;

  @Optional
  @ParamName("quotaSize")
  private Double quotaSize;

  /** Security origin. */
  public String getOrigin() {
    return origin;
  }

  /** Security origin. */
  public OverrideQuotaForOriginParameters setOrigin(String origin) {
    this.origin = origin;
    return this;
  }

  /**
   * The quota size (in bytes) to override the original quota with. If this is called multiple
   * times, the overridden quota will be equal to the quotaSize provided in the final call. If this
   * is called without specifying a quotaSize, the quota will be reset to the default value for the
   * specified origin. If this is called multiple times with different origins, the override will be
   * maintained for each origin until it is disabled (called without a quotaSize).
   */
  public Double getQuotaSize() {
    return quotaSize;
  }

  /**
   * The quota size (in bytes) to override the original quota with. If this is called multiple
   * times, the overridden quota will be equal to the quotaSize provided in the final call. If this
   * is called without specifying a quotaSize, the quota will be reset to the default value for the
   * specified origin. If this is called multiple times with different origins, the override will be
   * maintained for each origin until it is disabled (called without a quotaSize).
   */
  public OverrideQuotaForOriginParameters setQuotaSize(Double quotaSize) {
    this.quotaSize = quotaSize;
    return this;
  }
}
