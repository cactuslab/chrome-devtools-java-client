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

/** Represents a dictionary object passed in as privateAggregationConfig to run or selectURL. */
public class SharedStoragePrivateAggregationConfig {

  @Optional private String aggregationCoordinatorOrigin;

  @Optional private String contextId;

  private Integer filteringIdMaxBytes;

  @Optional private Integer maxContributions;

  /** The chosen aggregation service deployment. */
  public String getAggregationCoordinatorOrigin() {
    return aggregationCoordinatorOrigin;
  }

  /** The chosen aggregation service deployment. */
  public void setAggregationCoordinatorOrigin(String aggregationCoordinatorOrigin) {
    this.aggregationCoordinatorOrigin = aggregationCoordinatorOrigin;
  }

  /** The context ID provided. */
  public String getContextId() {
    return contextId;
  }

  /** The context ID provided. */
  public void setContextId(String contextId) {
    this.contextId = contextId;
  }

  /** Configures the maximum size allowed for filtering IDs. */
  public Integer getFilteringIdMaxBytes() {
    return filteringIdMaxBytes;
  }

  /** Configures the maximum size allowed for filtering IDs. */
  public void setFilteringIdMaxBytes(Integer filteringIdMaxBytes) {
    this.filteringIdMaxBytes = filteringIdMaxBytes;
  }

  /** The limit on the number of contributions in the final report. */
  public Integer getMaxContributions() {
    return maxContributions;
  }

  /** The limit on the number of contributions in the final report. */
  public void setMaxContributions(Integer maxContributions) {
    this.maxContributions = maxContributions;
  }
}
