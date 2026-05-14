package com.github.kklisura.cdt.protocol.types.pwa;

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

/** Parameters for the changeAppUserSettings command. */
public class ChangeAppUserSettingsParameters {

  @ParamName("manifestId")
  private String manifestId;

  @Optional
  @ParamName("linkCapturing")
  private Boolean linkCapturing;

  @Optional
  @ParamName("displayMode")
  private DisplayMode displayMode;

  public String getManifestId() {
    return manifestId;
  }

  public ChangeAppUserSettingsParameters setManifestId(String manifestId) {
    this.manifestId = manifestId;
    return this;
  }

  /**
   * If user allows the links clicked on by the user in the app's scope, or extended scope if the
   * manifest has scope extensions and the flags `DesktopPWAsLinkCapturingWithScopeExtensions` and
   * `WebAppEnableScopeExtensions` are enabled.
   *
   * <p>Note, the API does not support resetting the linkCapturing to the initial value,
   * uninstalling and installing the web app again will reset it.
   *
   * <p>TODO(crbug.com/339453269): Setting this value on ChromeOS is not supported yet.
   */
  public Boolean getLinkCapturing() {
    return linkCapturing;
  }

  /**
   * If user allows the links clicked on by the user in the app's scope, or extended scope if the
   * manifest has scope extensions and the flags `DesktopPWAsLinkCapturingWithScopeExtensions` and
   * `WebAppEnableScopeExtensions` are enabled.
   *
   * <p>Note, the API does not support resetting the linkCapturing to the initial value,
   * uninstalling and installing the web app again will reset it.
   *
   * <p>TODO(crbug.com/339453269): Setting this value on ChromeOS is not supported yet.
   */
  public ChangeAppUserSettingsParameters setLinkCapturing(Boolean linkCapturing) {
    this.linkCapturing = linkCapturing;
    return this;
  }

  public DisplayMode getDisplayMode() {
    return displayMode;
  }

  public ChangeAppUserSettingsParameters setDisplayMode(DisplayMode displayMode) {
    this.displayMode = displayMode;
    return this;
  }
}
