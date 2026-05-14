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

import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;

/** Parameters for the handleJavaScriptDialog command. */
public class HandleJavaScriptDialogParameters {

  @ParamName("accept")
  private Boolean accept;

  @Optional
  @ParamName("promptText")
  private String promptText;

  /** Whether to accept or dismiss the dialog. */
  public Boolean getAccept() {
    return accept;
  }

  /** Whether to accept or dismiss the dialog. */
  public HandleJavaScriptDialogParameters setAccept(Boolean accept) {
    this.accept = accept;
    return this;
  }

  /**
   * The text to enter into the dialog prompt before accepting. Used only if this is a prompt
   * dialog.
   */
  public String getPromptText() {
    return promptText;
  }

  /**
   * The text to enter into the dialog prompt before accepting. Used only if this is a prompt
   * dialog.
   */
  public HandleJavaScriptDialogParameters setPromptText(String promptText) {
    this.promptText = promptText;
    return this;
  }
}
