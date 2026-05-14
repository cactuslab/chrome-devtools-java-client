package com.github.kklisura.cdt.protocol.types.storage;

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

/** Parameters for the setSharedStorageEntry command. */
public class SetSharedStorageEntryParameters {

  @ParamName("ownerOrigin")
  private String ownerOrigin;

  @ParamName("key")
  private String key;

  @ParamName("value")
  private String value;

  @Optional
  @ParamName("ignoreIfPresent")
  private Boolean ignoreIfPresent;

  public String getOwnerOrigin() {
    return ownerOrigin;
  }

  public SetSharedStorageEntryParameters setOwnerOrigin(String ownerOrigin) {
    this.ownerOrigin = ownerOrigin;
    return this;
  }

  public String getKey() {
    return key;
  }

  public SetSharedStorageEntryParameters setKey(String key) {
    this.key = key;
    return this;
  }

  public String getValue() {
    return value;
  }

  public SetSharedStorageEntryParameters setValue(String value) {
    this.value = value;
    return this;
  }

  /**
   * If `ignoreIfPresent` is included and true, then only sets the entry if `key` doesn't already
   * exist.
   */
  public Boolean getIgnoreIfPresent() {
    return ignoreIfPresent;
  }

  /**
   * If `ignoreIfPresent` is included and true, then only sets the entry if `key` doesn't already
   * exist.
   */
  public SetSharedStorageEntryParameters setIgnoreIfPresent(Boolean ignoreIfPresent) {
    this.ignoreIfPresent = ignoreIfPresent;
    return this;
  }
}
