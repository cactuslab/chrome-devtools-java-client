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

/** Parameters for the startScreencast command. */
public class StartScreencastParameters {

  @Optional
  @ParamName("format")
  private StartScreencastFormat format;

  @Optional
  @ParamName("quality")
  private Integer quality;

  @Optional
  @ParamName("maxWidth")
  private Integer maxWidth;

  @Optional
  @ParamName("maxHeight")
  private Integer maxHeight;

  @Optional
  @ParamName("everyNthFrame")
  private Integer everyNthFrame;

  /** Image compression format. */
  public StartScreencastFormat getFormat() {
    return format;
  }

  /** Image compression format. */
  public StartScreencastParameters setFormat(StartScreencastFormat format) {
    this.format = format;
    return this;
  }

  /** Compression quality from range [0..100]. */
  public Integer getQuality() {
    return quality;
  }

  /** Compression quality from range [0..100]. */
  public StartScreencastParameters setQuality(Integer quality) {
    this.quality = quality;
    return this;
  }

  /** Maximum screenshot width. */
  public Integer getMaxWidth() {
    return maxWidth;
  }

  /** Maximum screenshot width. */
  public StartScreencastParameters setMaxWidth(Integer maxWidth) {
    this.maxWidth = maxWidth;
    return this;
  }

  /** Maximum screenshot height. */
  public Integer getMaxHeight() {
    return maxHeight;
  }

  /** Maximum screenshot height. */
  public StartScreencastParameters setMaxHeight(Integer maxHeight) {
    this.maxHeight = maxHeight;
    return this;
  }

  /** Send every n-th frame. */
  public Integer getEveryNthFrame() {
    return everyNthFrame;
  }

  /** Send every n-th frame. */
  public StartScreencastParameters setEveryNthFrame(Integer everyNthFrame) {
    this.everyNthFrame = everyNthFrame;
    return this;
  }
}
