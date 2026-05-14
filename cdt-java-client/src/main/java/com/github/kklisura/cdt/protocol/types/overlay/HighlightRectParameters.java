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

/** Parameters for the highlightRect command. */
public class HighlightRectParameters {

  @ParamName("x")
  private Integer x;

  @ParamName("y")
  private Integer y;

  @ParamName("width")
  private Integer width;

  @ParamName("height")
  private Integer height;

  @Optional
  @ParamName("color")
  private RGBA color;

  @Optional
  @ParamName("outlineColor")
  private RGBA outlineColor;

  /** X coordinate */
  public Integer getX() {
    return x;
  }

  /** X coordinate */
  public HighlightRectParameters setX(Integer x) {
    this.x = x;
    return this;
  }

  /** Y coordinate */
  public Integer getY() {
    return y;
  }

  /** Y coordinate */
  public HighlightRectParameters setY(Integer y) {
    this.y = y;
    return this;
  }

  /** Rectangle width */
  public Integer getWidth() {
    return width;
  }

  /** Rectangle width */
  public HighlightRectParameters setWidth(Integer width) {
    this.width = width;
    return this;
  }

  /** Rectangle height */
  public Integer getHeight() {
    return height;
  }

  /** Rectangle height */
  public HighlightRectParameters setHeight(Integer height) {
    this.height = height;
    return this;
  }

  /** The highlight fill color (default: transparent). */
  public RGBA getColor() {
    return color;
  }

  /** The highlight fill color (default: transparent). */
  public HighlightRectParameters setColor(RGBA color) {
    this.color = color;
    return this;
  }

  /** The highlight outline color (default: transparent). */
  public RGBA getOutlineColor() {
    return outlineColor;
  }

  /** The highlight outline color (default: transparent). */
  public HighlightRectParameters setOutlineColor(RGBA outlineColor) {
    this.outlineColor = outlineColor;
    return this;
  }
}
