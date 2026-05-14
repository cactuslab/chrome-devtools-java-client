package com.github.kklisura.cdt.protocol.types.webauthn;

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

/** Parameters for the enable command. */
public class EnableParameters {

  @Optional
  @ParamName("enableUI")
  private Boolean enableUI;

  /**
   * Whether to enable the WebAuthn user interface. Enabling the UI is recommended for debugging and
   * demo purposes, as it is closer to the real experience. Disabling the UI is recommended for
   * automated testing. Supported at the embedder's discretion if UI is available. Defaults to
   * false.
   */
  public Boolean getEnableUI() {
    return enableUI;
  }

  /**
   * Whether to enable the WebAuthn user interface. Enabling the UI is recommended for debugging and
   * demo purposes, as it is closer to the real experience. Disabling the UI is recommended for
   * automated testing. Supported at the embedder's discretion if UI is available. Defaults to
   * false.
   */
  public EnableParameters setEnableUI(Boolean enableUI) {
    this.enableUI = enableUI;
    return this;
  }
}
