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

/** Parameters for the setPermission command. */
public class SetPermissionParameters {

  @ParamName("permission")
  private PermissionDescriptor permission;

  @ParamName("setting")
  private PermissionSetting setting;

  @Optional
  @ParamName("origin")
  private String origin;

  @Optional
  @ParamName("embeddedOrigin")
  private String embeddedOrigin;

  @Optional
  @ParamName("browserContextId")
  private String browserContextId;

  /** Descriptor of permission to override. */
  public PermissionDescriptor getPermission() {
    return permission;
  }

  /** Descriptor of permission to override. */
  public SetPermissionParameters setPermission(PermissionDescriptor permission) {
    this.permission = permission;
    return this;
  }

  /** Setting of the permission. */
  public PermissionSetting getSetting() {
    return setting;
  }

  /** Setting of the permission. */
  public SetPermissionParameters setSetting(PermissionSetting setting) {
    this.setting = setting;
    return this;
  }

  /** Embedding origin the permission applies to, all origins if not specified. */
  public String getOrigin() {
    return origin;
  }

  /** Embedding origin the permission applies to, all origins if not specified. */
  public SetPermissionParameters setOrigin(String origin) {
    this.origin = origin;
    return this;
  }

  /**
   * Embedded origin the permission applies to. It is ignored unless the embedding origin is present
   * and valid. If the embedding origin is provided but the embedded origin isn't, the embedding
   * origin is used as the embedded origin.
   */
  public String getEmbeddedOrigin() {
    return embeddedOrigin;
  }

  /**
   * Embedded origin the permission applies to. It is ignored unless the embedding origin is present
   * and valid. If the embedding origin is provided but the embedded origin isn't, the embedding
   * origin is used as the embedded origin.
   */
  public SetPermissionParameters setEmbeddedOrigin(String embeddedOrigin) {
    this.embeddedOrigin = embeddedOrigin;
    return this;
  }

  /** Context to override. When omitted, default browser context is used. */
  public String getBrowserContextId() {
    return browserContextId;
  }

  /** Context to override. When omitted, default browser context is used. */
  public SetPermissionParameters setBrowserContextId(String browserContextId) {
    this.browserContextId = browserContextId;
    return this;
  }
}
