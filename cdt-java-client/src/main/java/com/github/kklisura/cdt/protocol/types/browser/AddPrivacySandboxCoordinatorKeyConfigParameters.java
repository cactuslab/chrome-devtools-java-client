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

/** Parameters for the addPrivacySandboxCoordinatorKeyConfig command. */
public class AddPrivacySandboxCoordinatorKeyConfigParameters {

  @ParamName("api")
  private PrivacySandboxAPI api;

  @ParamName("coordinatorOrigin")
  private String coordinatorOrigin;

  @ParamName("keyConfig")
  private String keyConfig;

  @Optional
  @ParamName("browserContextId")
  private String browserContextId;

  public PrivacySandboxAPI getApi() {
    return api;
  }

  public AddPrivacySandboxCoordinatorKeyConfigParameters setApi(PrivacySandboxAPI api) {
    this.api = api;
    return this;
  }

  public String getCoordinatorOrigin() {
    return coordinatorOrigin;
  }

  public AddPrivacySandboxCoordinatorKeyConfigParameters setCoordinatorOrigin(
      String coordinatorOrigin) {
    this.coordinatorOrigin = coordinatorOrigin;
    return this;
  }

  public String getKeyConfig() {
    return keyConfig;
  }

  public AddPrivacySandboxCoordinatorKeyConfigParameters setKeyConfig(String keyConfig) {
    this.keyConfig = keyConfig;
    return this;
  }

  /** BrowserContext to perform the action in. When omitted, default browser context is used. */
  public String getBrowserContextId() {
    return browserContextId;
  }

  /** BrowserContext to perform the action in. When omitted, default browser context is used. */
  public AddPrivacySandboxCoordinatorKeyConfigParameters setBrowserContextId(
      String browserContextId) {
    this.browserContextId = browserContextId;
    return this;
  }
}
