package com.github.kklisura.cdt.protocol.types.target;

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
import java.util.List;

/** Parameters for the setDiscoverTargets command. */
public class SetDiscoverTargetsParameters {

  @ParamName("discover")
  private Boolean discover;

  @Experimental
  @Optional
  @ParamName("filter")
  private List<FilterEntry> filter;

  /** Whether to discover available targets. */
  public Boolean getDiscover() {
    return discover;
  }

  /** Whether to discover available targets. */
  public SetDiscoverTargetsParameters setDiscover(Boolean discover) {
    this.discover = discover;
    return this;
  }

  /**
   * Only targets matching filter will be attached. If `discover` is false, `filter` must be omitted
   * or empty.
   */
  public List<FilterEntry> getFilter() {
    return filter;
  }

  /**
   * Only targets matching filter will be attached. If `discover` is false, `filter` must be omitted
   * or empty.
   */
  public SetDiscoverTargetsParameters setFilter(List<FilterEntry> filter) {
    this.filter = filter;
    return this;
  }
}
