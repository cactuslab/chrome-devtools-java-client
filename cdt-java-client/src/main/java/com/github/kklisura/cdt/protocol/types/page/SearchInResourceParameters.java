package com.github.kklisura.cdt.protocol.types.page;

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

/** Parameters for the searchInResource command. */
public class SearchInResourceParameters {

  @ParamName("frameId")
  private String frameId;

  @ParamName("url")
  private String url;

  @ParamName("query")
  private String query;

  @Optional
  @ParamName("caseSensitive")
  private Boolean caseSensitive;

  @Optional
  @ParamName("isRegex")
  private Boolean isRegex;

  /** Frame id for resource to search in. */
  public String getFrameId() {
    return frameId;
  }

  /** Frame id for resource to search in. */
  public SearchInResourceParameters setFrameId(String frameId) {
    this.frameId = frameId;
    return this;
  }

  /** URL of the resource to search in. */
  public String getUrl() {
    return url;
  }

  /** URL of the resource to search in. */
  public SearchInResourceParameters setUrl(String url) {
    this.url = url;
    return this;
  }

  /** String to search for. */
  public String getQuery() {
    return query;
  }

  /** String to search for. */
  public SearchInResourceParameters setQuery(String query) {
    this.query = query;
    return this;
  }

  /** If true, search is case sensitive. */
  public Boolean getCaseSensitive() {
    return caseSensitive;
  }

  /** If true, search is case sensitive. */
  public SearchInResourceParameters setCaseSensitive(Boolean caseSensitive) {
    this.caseSensitive = caseSensitive;
    return this;
  }

  /** If true, treats string parameter as regex. */
  public Boolean getIsRegex() {
    return isRegex;
  }

  /** If true, treats string parameter as regex. */
  public SearchInResourceParameters setIsRegex(Boolean isRegex) {
    this.isRegex = isRegex;
    return this;
  }
}
