package com.github.kklisura.cdt.protocol.types.target;

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

/** Parameters for the createTarget command. */
public class CreateTargetParameters {

  @ParamName("url")
  private String url;

  @Experimental
  @Optional
  @ParamName("left")
  private Integer left;

  @Experimental
  @Optional
  @ParamName("top")
  private Integer top;

  @Optional
  @ParamName("width")
  private Integer width;

  @Optional
  @ParamName("height")
  private Integer height;

  @Optional
  @ParamName("windowState")
  private WindowState windowState;

  @Experimental
  @Optional
  @ParamName("browserContextId")
  private String browserContextId;

  @Experimental
  @Optional
  @ParamName("enableBeginFrameControl")
  private Boolean enableBeginFrameControl;

  @Optional
  @ParamName("newWindow")
  private Boolean newWindow;

  @Optional
  @ParamName("background")
  private Boolean background;

  @Experimental
  @Optional
  @ParamName("forTab")
  private Boolean forTab;

  @Experimental
  @Optional
  @ParamName("hidden")
  private Boolean hidden;

  @Experimental
  @Optional
  @ParamName("focus")
  private Boolean focus;

  /** The initial URL the page will be navigated to. An empty string indicates about:blank. */
  public String getUrl() {
    return url;
  }

  /** The initial URL the page will be navigated to. An empty string indicates about:blank. */
  public CreateTargetParameters setUrl(String url) {
    this.url = url;
    return this;
  }

  /** Frame left origin in DIP (requires newWindow to be true or headless shell). */
  public Integer getLeft() {
    return left;
  }

  /** Frame left origin in DIP (requires newWindow to be true or headless shell). */
  public CreateTargetParameters setLeft(Integer left) {
    this.left = left;
    return this;
  }

  /** Frame top origin in DIP (requires newWindow to be true or headless shell). */
  public Integer getTop() {
    return top;
  }

  /** Frame top origin in DIP (requires newWindow to be true or headless shell). */
  public CreateTargetParameters setTop(Integer top) {
    this.top = top;
    return this;
  }

  /** Frame width in DIP (requires newWindow to be true or headless shell). */
  public Integer getWidth() {
    return width;
  }

  /** Frame width in DIP (requires newWindow to be true or headless shell). */
  public CreateTargetParameters setWidth(Integer width) {
    this.width = width;
    return this;
  }

  /** Frame height in DIP (requires newWindow to be true or headless shell). */
  public Integer getHeight() {
    return height;
  }

  /** Frame height in DIP (requires newWindow to be true or headless shell). */
  public CreateTargetParameters setHeight(Integer height) {
    this.height = height;
    return this;
  }

  /** Frame window state (requires newWindow to be true or headless shell). Default is normal. */
  public WindowState getWindowState() {
    return windowState;
  }

  /** Frame window state (requires newWindow to be true or headless shell). Default is normal. */
  public CreateTargetParameters setWindowState(WindowState windowState) {
    this.windowState = windowState;
    return this;
  }

  /** The browser context to create the page in. */
  public String getBrowserContextId() {
    return browserContextId;
  }

  /** The browser context to create the page in. */
  public CreateTargetParameters setBrowserContextId(String browserContextId) {
    this.browserContextId = browserContextId;
    return this;
  }

  /**
   * Whether BeginFrames for this target will be controlled via DevTools (headless shell only, not
   * supported on MacOS yet, false by default).
   */
  public Boolean getEnableBeginFrameControl() {
    return enableBeginFrameControl;
  }

  /**
   * Whether BeginFrames for this target will be controlled via DevTools (headless shell only, not
   * supported on MacOS yet, false by default).
   */
  public CreateTargetParameters setEnableBeginFrameControl(Boolean enableBeginFrameControl) {
    this.enableBeginFrameControl = enableBeginFrameControl;
    return this;
  }

  /** Whether to create a new Window or Tab (false by default, not supported by headless shell). */
  public Boolean getNewWindow() {
    return newWindow;
  }

  /** Whether to create a new Window or Tab (false by default, not supported by headless shell). */
  public CreateTargetParameters setNewWindow(Boolean newWindow) {
    this.newWindow = newWindow;
    return this;
  }

  /**
   * Whether to create the target in background or foreground (false by default, not supported by
   * headless shell).
   */
  public Boolean getBackground() {
    return background;
  }

  /**
   * Whether to create the target in background or foreground (false by default, not supported by
   * headless shell).
   */
  public CreateTargetParameters setBackground(Boolean background) {
    this.background = background;
    return this;
  }

  /** Whether to create the target of type "tab". */
  public Boolean getForTab() {
    return forTab;
  }

  /** Whether to create the target of type "tab". */
  public CreateTargetParameters setForTab(Boolean forTab) {
    this.forTab = forTab;
    return this;
  }

  /**
   * Whether to create a hidden target. The hidden target is observable via protocol, but not
   * present in the tab UI strip. Cannot be created with `forTab: true`, `newWindow: true` or
   * `background: false`. The life-time of the tab is limited to the life-time of the session.
   */
  public Boolean getHidden() {
    return hidden;
  }

  /**
   * Whether to create a hidden target. The hidden target is observable via protocol, but not
   * present in the tab UI strip. Cannot be created with `forTab: true`, `newWindow: true` or
   * `background: false`. The life-time of the tab is limited to the life-time of the session.
   */
  public CreateTargetParameters setHidden(Boolean hidden) {
    this.hidden = hidden;
    return this;
  }

  /**
   * If specified, the option is used to determine if the new target should be focused or not. By
   * default, the focus behavior depends on the value of the background field. For example,
   * background=false and focus=false will result in the target tab being opened but the browser
   * window remain unchanged (if it was in the background, it will remain in the background) and
   * background=false with focus=undefined will result in the window being focused. Using
   * background: true and focus: true is not supported and will result in an error.
   */
  public Boolean getFocus() {
    return focus;
  }

  /**
   * If specified, the option is used to determine if the new target should be focused or not. By
   * default, the focus behavior depends on the value of the background field. For example,
   * background=false and focus=false will result in the target tab being opened but the browser
   * window remain unchanged (if it was in the background, it will remain in the background) and
   * background=false with focus=undefined will result in the window being focused. Using
   * background: true and focus: true is not supported and will result in an error.
   */
  public CreateTargetParameters setFocus(Boolean focus) {
    this.focus = focus;
    return this;
  }
}
