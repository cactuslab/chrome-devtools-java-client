package com.github.kklisura.cdt.protocol.types.input;

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

/** Parameters for the imeSetComposition command. */
public class ImeSetCompositionParameters {

  @ParamName("text")
  private String text;

  @ParamName("selectionStart")
  private Integer selectionStart;

  @ParamName("selectionEnd")
  private Integer selectionEnd;

  @Optional
  @ParamName("replacementStart")
  private Integer replacementStart;

  @Optional
  @ParamName("replacementEnd")
  private Integer replacementEnd;

  /** The text to insert */
  public String getText() {
    return text;
  }

  /** The text to insert */
  public ImeSetCompositionParameters setText(String text) {
    this.text = text;
    return this;
  }

  /** selection start */
  public Integer getSelectionStart() {
    return selectionStart;
  }

  /** selection start */
  public ImeSetCompositionParameters setSelectionStart(Integer selectionStart) {
    this.selectionStart = selectionStart;
    return this;
  }

  /** selection end */
  public Integer getSelectionEnd() {
    return selectionEnd;
  }

  /** selection end */
  public ImeSetCompositionParameters setSelectionEnd(Integer selectionEnd) {
    this.selectionEnd = selectionEnd;
    return this;
  }

  /** replacement start */
  public Integer getReplacementStart() {
    return replacementStart;
  }

  /** replacement start */
  public ImeSetCompositionParameters setReplacementStart(Integer replacementStart) {
    this.replacementStart = replacementStart;
    return this;
  }

  /** replacement end */
  public Integer getReplacementEnd() {
    return replacementEnd;
  }

  /** replacement end */
  public ImeSetCompositionParameters setReplacementEnd(Integer replacementEnd) {
    this.replacementEnd = replacementEnd;
    return this;
  }
}
