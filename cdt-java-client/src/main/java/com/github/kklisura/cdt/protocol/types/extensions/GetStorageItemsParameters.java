package com.github.kklisura.cdt.protocol.types.extensions;

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

/** Parameters for the getStorageItems command. */
public class GetStorageItemsParameters {

  @ParamName("id")
  private String id;

  @ParamName("storageArea")
  private StorageArea storageArea;

  @Optional
  @ParamName("keys")
  private List<String> keys;

  /** ID of extension. */
  public String getId() {
    return id;
  }

  /** ID of extension. */
  public GetStorageItemsParameters setId(String id) {
    this.id = id;
    return this;
  }

  /** StorageArea to retrieve data from. */
  public StorageArea getStorageArea() {
    return storageArea;
  }

  /** StorageArea to retrieve data from. */
  public GetStorageItemsParameters setStorageArea(StorageArea storageArea) {
    this.storageArea = storageArea;
    return this;
  }

  /** Keys to retrieve. */
  public List<String> getKeys() {
    return keys;
  }

  /** Keys to retrieve. */
  public GetStorageItemsParameters setKeys(List<String> keys) {
    this.keys = keys;
    return this;
  }
}
