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

import com.github.kklisura.cdt.protocol.support.annotations.Experimental;

@Experimental
public class BlockPattern {

  private String urlPattern;

  private Boolean block;

  /**
   * URL pattern to match. Patterns use the URLPattern constructor string syntax
   * (https://urlpattern.spec.whatwg.org/) and must be absolute. Example: `*://*:*&#47;*.css`.
   */
  public String getUrlPattern() {
    return urlPattern;
  }

  /**
   * URL pattern to match. Patterns use the URLPattern constructor string syntax
   * (https://urlpattern.spec.whatwg.org/) and must be absolute. Example: `*://*:*&#47;*.css`.
   */
  public void setUrlPattern(String urlPattern) {
    this.urlPattern = urlPattern;
  }

  /**
   * Whether or not to block the pattern. If false, a matching request will not be blocked even if
   * it matches a later `BlockPattern`.
   */
  public Boolean getBlock() {
    return block;
  }

  /**
   * Whether or not to block the pattern. If false, a matching request will not be blocked even if
   * it matches a later `BlockPattern`.
   */
  public void setBlock(Boolean block) {
    this.block = block;
  }
}
