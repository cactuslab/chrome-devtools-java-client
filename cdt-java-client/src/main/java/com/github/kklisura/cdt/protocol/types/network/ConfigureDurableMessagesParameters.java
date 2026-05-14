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

/** Parameters for the configureDurableMessages command. */
public class ConfigureDurableMessagesParameters {

  @Optional
  @ParamName("maxTotalBufferSize")
  private Integer maxTotalBufferSize;

  @Optional
  @ParamName("maxResourceBufferSize")
  private Integer maxResourceBufferSize;

  /** Buffer size in bytes to use when preserving network payloads (XHRs, etc). */
  public Integer getMaxTotalBufferSize() {
    return maxTotalBufferSize;
  }

  /** Buffer size in bytes to use when preserving network payloads (XHRs, etc). */
  public ConfigureDurableMessagesParameters setMaxTotalBufferSize(Integer maxTotalBufferSize) {
    this.maxTotalBufferSize = maxTotalBufferSize;
    return this;
  }

  /** Per-resource buffer size in bytes to use when preserving network payloads (XHRs, etc). */
  public Integer getMaxResourceBufferSize() {
    return maxResourceBufferSize;
  }

  /** Per-resource buffer size in bytes to use when preserving network payloads (XHRs, etc). */
  public ConfigureDurableMessagesParameters setMaxResourceBufferSize(
      Integer maxResourceBufferSize) {
    this.maxResourceBufferSize = maxResourceBufferSize;
    return this;
  }
}
