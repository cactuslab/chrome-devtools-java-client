package com.github.kklisura.cdt.protocol.types.debugger;

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

/** Parameters for the getPossibleBreakpoints command. */
public class GetPossibleBreakpointsParameters {

  @ParamName("start")
  private Location start;

  @Optional
  @ParamName("end")
  private Location end;

  @Optional
  @ParamName("restrictToFunction")
  private Boolean restrictToFunction;

  /** Start of range to search possible breakpoint locations in. */
  public Location getStart() {
    return start;
  }

  /** Start of range to search possible breakpoint locations in. */
  public GetPossibleBreakpointsParameters setStart(Location start) {
    this.start = start;
    return this;
  }

  /**
   * End of range to search possible breakpoint locations in (excluding). When not specified, end of
   * scripts is used as end of range.
   */
  public Location getEnd() {
    return end;
  }

  /**
   * End of range to search possible breakpoint locations in (excluding). When not specified, end of
   * scripts is used as end of range.
   */
  public GetPossibleBreakpointsParameters setEnd(Location end) {
    this.end = end;
    return this;
  }

  /** Only consider locations which are in the same (non-nested) function as start. */
  public Boolean getRestrictToFunction() {
    return restrictToFunction;
  }

  /** Only consider locations which are in the same (non-nested) function as start. */
  public GetPossibleBreakpointsParameters setRestrictToFunction(Boolean restrictToFunction) {
    this.restrictToFunction = restrictToFunction;
    return this;
  }
}
