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

/** Parameters for the resetPermissions command. */
public class ResetPermissionsParameters {

  @Optional
  @ParamName("browserContextId")
  private String browserContextId;

  /** BrowserContext to reset permissions. When omitted, default browser context is used. */
  public String getBrowserContextId() {
    return browserContextId;
  }

  /** BrowserContext to reset permissions. When omitted, default browser context is used. */
  public ResetPermissionsParameters setBrowserContextId(String browserContextId) {
    this.browserContextId = browserContextId;
    return this;
  }
}
