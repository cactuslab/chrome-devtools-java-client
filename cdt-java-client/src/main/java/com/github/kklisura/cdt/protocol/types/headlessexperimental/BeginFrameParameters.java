package com.github.kklisura.cdt.protocol.types.headlessexperimental;

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

/** Parameters for the beginFrame command. */
public class BeginFrameParameters {

  @Optional
  @ParamName("frameTimeTicks")
  private Double frameTimeTicks;

  @Optional
  @ParamName("interval")
  private Double interval;

  @Optional
  @ParamName("noDisplayUpdates")
  private Boolean noDisplayUpdates;

  @Optional
  @ParamName("screenshot")
  private ScreenshotParams screenshot;

  /**
   * Timestamp of this BeginFrame in Renderer TimeTicks (milliseconds of uptime). If not set, the
   * current time will be used.
   */
  public Double getFrameTimeTicks() {
    return frameTimeTicks;
  }

  /**
   * Timestamp of this BeginFrame in Renderer TimeTicks (milliseconds of uptime). If not set, the
   * current time will be used.
   */
  public BeginFrameParameters setFrameTimeTicks(Double frameTimeTicks) {
    this.frameTimeTicks = frameTimeTicks;
    return this;
  }

  /**
   * The interval between BeginFrames that is reported to the compositor, in milliseconds. Defaults
   * to a 60 frames/second interval, i.e. about 16.666 milliseconds.
   */
  public Double getInterval() {
    return interval;
  }

  /**
   * The interval between BeginFrames that is reported to the compositor, in milliseconds. Defaults
   * to a 60 frames/second interval, i.e. about 16.666 milliseconds.
   */
  public BeginFrameParameters setInterval(Double interval) {
    this.interval = interval;
    return this;
  }

  /**
   * Whether updates should not be committed and drawn onto the display. False by default. If true,
   * only side effects of the BeginFrame will be run, such as layout and animations, but any visual
   * updates may not be visible on the display or in screenshots.
   */
  public Boolean getNoDisplayUpdates() {
    return noDisplayUpdates;
  }

  /**
   * Whether updates should not be committed and drawn onto the display. False by default. If true,
   * only side effects of the BeginFrame will be run, such as layout and animations, but any visual
   * updates may not be visible on the display or in screenshots.
   */
  public BeginFrameParameters setNoDisplayUpdates(Boolean noDisplayUpdates) {
    this.noDisplayUpdates = noDisplayUpdates;
    return this;
  }

  /**
   * If set, a screenshot of the frame will be captured and returned in the response. Otherwise, no
   * screenshot will be captured. Note that capturing a screenshot can fail, for example, during
   * renderer initialization. In such a case, no screenshot data will be returned.
   */
  public ScreenshotParams getScreenshot() {
    return screenshot;
  }

  /**
   * If set, a screenshot of the frame will be captured and returned in the response. Otherwise, no
   * screenshot will be captured. Note that capturing a screenshot can fail, for example, during
   * renderer initialization. In such a case, no screenshot data will be returned.
   */
  public BeginFrameParameters setScreenshot(ScreenshotParams screenshot) {
    this.screenshot = screenshot;
    return this;
  }
}
