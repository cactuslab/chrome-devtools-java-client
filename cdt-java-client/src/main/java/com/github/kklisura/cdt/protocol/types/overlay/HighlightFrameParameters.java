package com.github.kklisura.cdt.protocol.types.overlay;

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
import com.github.kklisura.cdt.protocol.types.dom.RGBA;

/** Parameters for the highlightFrame command. */
public class HighlightFrameParameters {

  @ParamName("frameId")
  private String frameId;

  @Optional
  @ParamName("contentColor")
  private RGBA contentColor;

  @Optional
  @ParamName("contentOutlineColor")
  private RGBA contentOutlineColor;

  /** Identifier of the frame to highlight. */
  public String getFrameId() {
    return frameId;
  }

  /** Identifier of the frame to highlight. */
  public HighlightFrameParameters setFrameId(String frameId) {
    this.frameId = frameId;
    return this;
  }

  /** The content box highlight fill color (default: transparent). */
  public RGBA getContentColor() {
    return contentColor;
  }

  /** The content box highlight fill color (default: transparent). */
  public HighlightFrameParameters setContentColor(RGBA contentColor) {
    this.contentColor = contentColor;
    return this;
  }

  /** The content box highlight outline color (default: transparent). */
  public RGBA getContentOutlineColor() {
    return contentOutlineColor;
  }

  /** The content box highlight outline color (default: transparent). */
  public HighlightFrameParameters setContentOutlineColor(RGBA contentOutlineColor) {
    this.contentOutlineColor = contentOutlineColor;
    return this;
  }
}
