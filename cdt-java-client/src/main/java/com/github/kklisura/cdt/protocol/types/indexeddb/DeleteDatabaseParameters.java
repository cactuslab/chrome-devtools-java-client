package com.github.kklisura.cdt.protocol.types.indexeddb;

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
import com.github.kklisura.cdt.protocol.types.storage.StorageBucket;

/** Parameters for the deleteDatabase command. */
public class DeleteDatabaseParameters {

  @Optional
  @ParamName("securityOrigin")
  private String securityOrigin;

  @Optional
  @ParamName("storageKey")
  private String storageKey;

  @Optional
  @ParamName("storageBucket")
  private StorageBucket storageBucket;

  @ParamName("databaseName")
  private String databaseName;

  /**
   * At least and at most one of securityOrigin, storageKey, or storageBucket must be specified.
   * Security origin.
   */
  public String getSecurityOrigin() {
    return securityOrigin;
  }

  /**
   * At least and at most one of securityOrigin, storageKey, or storageBucket must be specified.
   * Security origin.
   */
  public DeleteDatabaseParameters setSecurityOrigin(String securityOrigin) {
    this.securityOrigin = securityOrigin;
    return this;
  }

  /** Storage key. */
  public String getStorageKey() {
    return storageKey;
  }

  /** Storage key. */
  public DeleteDatabaseParameters setStorageKey(String storageKey) {
    this.storageKey = storageKey;
    return this;
  }

  /** Storage bucket. If not specified, it uses the default bucket. */
  public StorageBucket getStorageBucket() {
    return storageBucket;
  }

  /** Storage bucket. If not specified, it uses the default bucket. */
  public DeleteDatabaseParameters setStorageBucket(StorageBucket storageBucket) {
    this.storageBucket = storageBucket;
    return this;
  }

  /** Database name. */
  public String getDatabaseName() {
    return databaseName;
  }

  /** Database name. */
  public DeleteDatabaseParameters setDatabaseName(String databaseName) {
    this.databaseName = databaseName;
    return this;
  }
}
