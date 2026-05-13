package com.github.kklisura.cdt.protocol.events.storage;

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

import com.github.kklisura.cdt.protocol.types.storage.SharedStorageAccessMethod;
import com.github.kklisura.cdt.protocol.types.storage.SharedStorageAccessParams;
import com.github.kklisura.cdt.protocol.types.storage.SharedStorageAccessScope;

/**
 * Shared storage was accessed by the associated page. The following parameters are included in all
 * events.
 */
public class SharedStorageAccessed {

  private Double accessTime;

  private SharedStorageAccessScope scope;

  private SharedStorageAccessMethod method;

  private String mainFrameId;

  private String ownerOrigin;

  private String ownerSite;

  private SharedStorageAccessParams params;

  /** Time of the access. */
  public Double getAccessTime() {
    return accessTime;
  }

  /** Time of the access. */
  public void setAccessTime(Double accessTime) {
    this.accessTime = accessTime;
  }

  /** Enum value indicating the access scope. */
  public SharedStorageAccessScope getScope() {
    return scope;
  }

  /** Enum value indicating the access scope. */
  public void setScope(SharedStorageAccessScope scope) {
    this.scope = scope;
  }

  /** Enum value indicating the Shared Storage API method invoked. */
  public SharedStorageAccessMethod getMethod() {
    return method;
  }

  /** Enum value indicating the Shared Storage API method invoked. */
  public void setMethod(SharedStorageAccessMethod method) {
    this.method = method;
  }

  /** DevTools Frame Token for the primary frame tree's root. */
  public String getMainFrameId() {
    return mainFrameId;
  }

  /** DevTools Frame Token for the primary frame tree's root. */
  public void setMainFrameId(String mainFrameId) {
    this.mainFrameId = mainFrameId;
  }

  /** Serialization of the origin owning the Shared Storage data. */
  public String getOwnerOrigin() {
    return ownerOrigin;
  }

  /** Serialization of the origin owning the Shared Storage data. */
  public void setOwnerOrigin(String ownerOrigin) {
    this.ownerOrigin = ownerOrigin;
  }

  /** Serialization of the site owning the Shared Storage data. */
  public String getOwnerSite() {
    return ownerSite;
  }

  /** Serialization of the site owning the Shared Storage data. */
  public void setOwnerSite(String ownerSite) {
    this.ownerSite = ownerSite;
  }

  /**
   * The sub-parameters wrapped by `params` are all optional and their presence/absence depends on
   * `type`.
   */
  public SharedStorageAccessParams getParams() {
    return params;
  }

  /**
   * The sub-parameters wrapped by `params` are all optional and their presence/absence depends on
   * `type`.
   */
  public void setParams(SharedStorageAccessParams params) {
    this.params = params;
  }
}
