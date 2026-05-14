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

/** Parameters for the captureScreenshot command. */
public class CaptureScreenshotParameters {

  @Optional
  @ParamName("format")
  private CaptureScreenshotFormat format;

  @Optional
  @ParamName("quality")
  private Integer quality;

  @Optional
  @ParamName("clip")
  private Viewport clip;

  @Experimental
  @Optional
  @ParamName("fromSurface")
  private Boolean fromSurface;

  @Experimental
  @Optional
  @ParamName("captureBeyondViewport")
  private Boolean captureBeyondViewport;

  @Experimental
  @Optional
  @ParamName("optimizeForSpeed")
  private Boolean optimizeForSpeed;

  /** Image compression format (defaults to png). */
  public CaptureScreenshotFormat getFormat() {
    return format;
  }

  /** Image compression format (defaults to png). */
  public CaptureScreenshotParameters setFormat(CaptureScreenshotFormat format) {
    this.format = format;
    return this;
  }

  /** Compression quality from range [0..100] (jpeg only). */
  public Integer getQuality() {
    return quality;
  }

  /** Compression quality from range [0..100] (jpeg only). */
  public CaptureScreenshotParameters setQuality(Integer quality) {
    this.quality = quality;
    return this;
  }

  /** Capture the screenshot of a given region only. */
  public Viewport getClip() {
    return clip;
  }

  /** Capture the screenshot of a given region only. */
  public CaptureScreenshotParameters setClip(Viewport clip) {
    this.clip = clip;
    return this;
  }

  /** Capture the screenshot from the surface, rather than the view. Defaults to true. */
  public Boolean getFromSurface() {
    return fromSurface;
  }

  /** Capture the screenshot from the surface, rather than the view. Defaults to true. */
  public CaptureScreenshotParameters setFromSurface(Boolean fromSurface) {
    this.fromSurface = fromSurface;
    return this;
  }

  /** Capture the screenshot beyond the viewport. Defaults to false. */
  public Boolean getCaptureBeyondViewport() {
    return captureBeyondViewport;
  }

  /** Capture the screenshot beyond the viewport. Defaults to false. */
  public CaptureScreenshotParameters setCaptureBeyondViewport(Boolean captureBeyondViewport) {
    this.captureBeyondViewport = captureBeyondViewport;
    return this;
  }

  /** Optimize image encoding for speed, not for resulting size (defaults to false) */
  public Boolean getOptimizeForSpeed() {
    return optimizeForSpeed;
  }

  /** Optimize image encoding for speed, not for resulting size (defaults to false) */
  public CaptureScreenshotParameters setOptimizeForSpeed(Boolean optimizeForSpeed) {
    this.optimizeForSpeed = optimizeForSpeed;
    return this;
  }
}
