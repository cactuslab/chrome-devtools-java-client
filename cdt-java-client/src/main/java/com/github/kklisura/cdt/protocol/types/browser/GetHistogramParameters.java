package com.github.kklisura.cdt.protocol.types.browser;

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

/** Parameters for the getHistogram command. */
public class GetHistogramParameters {

  @ParamName("name")
  private String name;

  @Optional
  @ParamName("delta")
  private Boolean delta;

  /** Requested histogram name. */
  public String getName() {
    return name;
  }

  /** Requested histogram name. */
  public GetHistogramParameters setName(String name) {
    this.name = name;
    return this;
  }

  /** If true, retrieve delta since last delta call. */
  public Boolean getDelta() {
    return delta;
  }

  /** If true, retrieve delta since last delta call. */
  public GetHistogramParameters setDelta(Boolean delta) {
    this.delta = delta;
    return this;
  }
}
