package com.github.kklisura.cdt.protocol.types.io;

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

/** Parameters for the read command. */
public class ReadParameters {

  @ParamName("handle")
  private String handle;

  @Optional
  @ParamName("offset")
  private Integer offset;

  @Optional
  @ParamName("size")
  private Integer size;

  /** Handle of the stream to read. */
  public String getHandle() {
    return handle;
  }

  /** Handle of the stream to read. */
  public ReadParameters setHandle(String handle) {
    this.handle = handle;
    return this;
  }

  /**
   * Seek to the specified offset before reading (if not specified, proceed with offset following
   * the last read). Some types of streams may only support sequential reads.
   */
  public Integer getOffset() {
    return offset;
  }

  /**
   * Seek to the specified offset before reading (if not specified, proceed with offset following
   * the last read). Some types of streams may only support sequential reads.
   */
  public ReadParameters setOffset(Integer offset) {
    this.offset = offset;
    return this;
  }

  /** Maximum number of bytes to read (left upon the agent discretion if not specified). */
  public Integer getSize() {
    return size;
  }

  /** Maximum number of bytes to read (left upon the agent discretion if not specified). */
  public ReadParameters setSize(Integer size) {
    this.size = size;
    return this;
  }
}
