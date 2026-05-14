package com.github.kklisura.cdt.protocol.types.network;

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
import java.util.List;

/** Parameters for the setBlockedURLs command. */
public class SetBlockedURLsParameters {

  @Optional
  @ParamName("urlPatterns")
  private List<BlockPattern> urlPatterns;

  @Deprecated
  @Optional
  @ParamName("urls")
  private List<String> urls;

  /**
   * Patterns to match in the order in which they are given. These patterns also take precedence
   * over any wildcard patterns defined in `urls`.
   */
  public List<BlockPattern> getUrlPatterns() {
    return urlPatterns;
  }

  /**
   * Patterns to match in the order in which they are given. These patterns also take precedence
   * over any wildcard patterns defined in `urls`.
   */
  public SetBlockedURLsParameters setUrlPatterns(List<BlockPattern> urlPatterns) {
    this.urlPatterns = urlPatterns;
    return this;
  }

  /** URL patterns to block. Wildcards ('*') are allowed. */
  public List<String> getUrls() {
    return urls;
  }

  /** URL patterns to block. Wildcards ('*') are allowed. */
  public SetBlockedURLsParameters setUrls(List<String> urls) {
    this.urls = urls;
    return this;
  }
}
