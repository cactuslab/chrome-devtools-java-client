package com.github.kklisura.cdt.protocol.types.target;

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

/** Parameters for the exposeDevToolsProtocol command. */
public class ExposeDevToolsProtocolParameters {

  @ParamName("targetId")
  private String targetId;

  @Optional
  @ParamName("bindingName")
  private String bindingName;

  @Optional
  @ParamName("inheritPermissions")
  private Boolean inheritPermissions;

  public String getTargetId() {
    return targetId;
  }

  public ExposeDevToolsProtocolParameters setTargetId(String targetId) {
    this.targetId = targetId;
    return this;
  }

  /** Binding name, 'cdp' if not specified. */
  public String getBindingName() {
    return bindingName;
  }

  /** Binding name, 'cdp' if not specified. */
  public ExposeDevToolsProtocolParameters setBindingName(String bindingName) {
    this.bindingName = bindingName;
    return this;
  }

  /** If true, inherits the current root session's permissions (default: false). */
  public Boolean getInheritPermissions() {
    return inheritPermissions;
  }

  /** If true, inherits the current root session's permissions (default: false). */
  public ExposeDevToolsProtocolParameters setInheritPermissions(Boolean inheritPermissions) {
    this.inheritPermissions = inheritPermissions;
    return this;
  }
}
