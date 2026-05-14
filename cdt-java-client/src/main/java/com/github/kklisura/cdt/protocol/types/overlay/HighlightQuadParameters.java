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
import java.util.List;

/** Parameters for the highlightQuad command. */
public class HighlightQuadParameters {

  @ParamName("quad")
  private List<Double> quad;

  @Optional
  @ParamName("color")
  private RGBA color;

  @Optional
  @ParamName("outlineColor")
  private RGBA outlineColor;

  /** Quad to highlight */
  public List<Double> getQuad() {
    return quad;
  }

  /** Quad to highlight */
  public HighlightQuadParameters setQuad(List<Double> quad) {
    this.quad = quad;
    return this;
  }

  /** The highlight fill color (default: transparent). */
  public RGBA getColor() {
    return color;
  }

  /** The highlight fill color (default: transparent). */
  public HighlightQuadParameters setColor(RGBA color) {
    this.color = color;
    return this;
  }

  /** The highlight outline color (default: transparent). */
  public RGBA getOutlineColor() {
    return outlineColor;
  }

  /** The highlight outline color (default: transparent). */
  public HighlightQuadParameters setOutlineColor(RGBA outlineColor) {
    this.outlineColor = outlineColor;
    return this;
  }
}
