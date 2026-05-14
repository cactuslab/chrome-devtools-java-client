package com.github.kklisura.cdt.protocol.types.dom;

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

/** Parameters for the performSearch command. */
public class PerformSearchParameters {

  @ParamName("query")
  private String query;

  @Optional
  @ParamName("includeUserAgentShadowDOM")
  private Boolean includeUserAgentShadowDOM;

  /** Plain text or query selector or XPath search query. */
  public String getQuery() {
    return query;
  }

  /** Plain text or query selector or XPath search query. */
  public PerformSearchParameters setQuery(String query) {
    this.query = query;
    return this;
  }

  /** True to search in user agent shadow DOM. */
  public Boolean getIncludeUserAgentShadowDOM() {
    return includeUserAgentShadowDOM;
  }

  /** True to search in user agent shadow DOM. */
  public PerformSearchParameters setIncludeUserAgentShadowDOM(Boolean includeUserAgentShadowDOM) {
    this.includeUserAgentShadowDOM = includeUserAgentShadowDOM;
    return this;
  }
}
