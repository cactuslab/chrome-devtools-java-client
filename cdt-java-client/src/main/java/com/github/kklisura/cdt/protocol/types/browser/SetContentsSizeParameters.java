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

/** Parameters for the setContentsSize command. */
public class SetContentsSizeParameters {

  @ParamName("windowId")
  private Integer windowId;

  @Optional
  @ParamName("width")
  private Integer width;

  @Optional
  @ParamName("height")
  private Integer height;

  /** Browser window id. */
  public Integer getWindowId() {
    return windowId;
  }

  /** Browser window id. */
  public SetContentsSizeParameters setWindowId(Integer windowId) {
    this.windowId = windowId;
    return this;
  }

  /**
   * The window contents width in DIP. Assumes current width if omitted. Must be specified if
   * 'height' is omitted.
   */
  public Integer getWidth() {
    return width;
  }

  /**
   * The window contents width in DIP. Assumes current width if omitted. Must be specified if
   * 'height' is omitted.
   */
  public SetContentsSizeParameters setWidth(Integer width) {
    this.width = width;
    return this;
  }

  /**
   * The window contents height in DIP. Assumes current height if omitted. Must be specified if
   * 'width' is omitted.
   */
  public Integer getHeight() {
    return height;
  }

  /**
   * The window contents height in DIP. Assumes current height if omitted. Must be specified if
   * 'width' is omitted.
   */
  public SetContentsSizeParameters setHeight(Integer height) {
    this.height = height;
    return this;
  }
}
