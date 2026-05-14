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

/** Parameters for the getDocument command. */
public class GetDocumentParameters {

  @Optional
  @ParamName("depth")
  private Integer depth;

  @Optional
  @ParamName("pierce")
  private Boolean pierce;

  /**
   * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the entire
   * subtree or provide an integer larger than 0.
   */
  public Integer getDepth() {
    return depth;
  }

  /**
   * The maximum depth at which children should be retrieved, defaults to 1. Use -1 for the entire
   * subtree or provide an integer larger than 0.
   */
  public GetDocumentParameters setDepth(Integer depth) {
    this.depth = depth;
    return this;
  }

  /**
   * Whether or not iframes and shadow roots should be traversed when returning the subtree (default
   * is false).
   */
  public Boolean getPierce() {
    return pierce;
  }

  /**
   * Whether or not iframes and shadow roots should be traversed when returning the subtree (default
   * is false).
   */
  public GetDocumentParameters setPierce(Boolean pierce) {
    this.pierce = pierce;
    return this;
  }
}
