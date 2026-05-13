package com.github.kklisura.cdt.protocol.types.network;

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

/**
 * Identifies the script on the stack that caused a resource or element to be labeled as an ad. For
 * resources, this indicates the context that triggered the fetch. For elements, this indicates the
 * context that caused the element to be appended to the DOM.
 */
@Experimental
public class AdScriptIdentifier {

  private String scriptId;

  private String debuggerId;

  private String name;

  /** The script's V8 identifier. */
  public String getScriptId() {
    return scriptId;
  }

  /** The script's V8 identifier. */
  public void setScriptId(String scriptId) {
    this.scriptId = scriptId;
  }

  /** V8's debugging ID for the v8::Context. */
  public String getDebuggerId() {
    return debuggerId;
  }

  /** V8's debugging ID for the v8::Context. */
  public void setDebuggerId(String debuggerId) {
    this.debuggerId = debuggerId;
  }

  /** The script's url (or generated name based on id if inline script). */
  public String getName() {
    return name;
  }

  /** The script's url (or generated name based on id if inline script). */
  public void setName(String name) {
    this.name = name;
  }
}
