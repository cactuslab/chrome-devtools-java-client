package com.github.kklisura.cdt.protocol.types.browser;

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

/** Parameters for the grantPermissions command. */
public class GrantPermissionsParameters {

  @ParamName("permissions")
  private List<PermissionType> permissions;

  @Optional
  @ParamName("origin")
  private String origin;

  @Optional
  @ParamName("browserContextId")
  private String browserContextId;

  public List<PermissionType> getPermissions() {
    return permissions;
  }

  public GrantPermissionsParameters setPermissions(List<PermissionType> permissions) {
    this.permissions = permissions;
    return this;
  }

  /** Origin the permission applies to, all origins if not specified. */
  public String getOrigin() {
    return origin;
  }

  /** Origin the permission applies to, all origins if not specified. */
  public GrantPermissionsParameters setOrigin(String origin) {
    this.origin = origin;
    return this;
  }

  /** BrowserContext to override permissions. When omitted, default browser context is used. */
  public String getBrowserContextId() {
    return browserContextId;
  }

  /** BrowserContext to override permissions. When omitted, default browser context is used. */
  public GrantPermissionsParameters setBrowserContextId(String browserContextId) {
    this.browserContextId = browserContextId;
    return this;
  }
}
