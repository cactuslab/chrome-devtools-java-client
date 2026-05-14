package com.github.kklisura.cdt.protocol.types.page;

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

import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;

/** Parameters for the setInterceptFileChooserDialog command. */
public class SetInterceptFileChooserDialogParameters {

  @ParamName("enabled")
  private Boolean enabled;

  @Experimental
  @Optional
  @ParamName("cancel")
  private Boolean cancel;

  public Boolean getEnabled() {
    return enabled;
  }

  public SetInterceptFileChooserDialogParameters setEnabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  /**
   * If true, cancels the dialog by emitting relevant events (if any) in addition to not showing it
   * if the interception is enabled (default: false).
   */
  public Boolean getCancel() {
    return cancel;
  }

  /**
   * If true, cancels the dialog by emitting relevant events (if any) in addition to not showing it
   * if the interception is enabled (default: false).
   */
  public SetInterceptFileChooserDialogParameters setCancel(Boolean cancel) {
    this.cancel = cancel;
    return this;
  }
}
