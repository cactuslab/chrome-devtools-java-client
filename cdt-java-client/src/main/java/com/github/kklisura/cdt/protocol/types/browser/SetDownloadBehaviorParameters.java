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

/** Parameters for the setDownloadBehavior command. */
public class SetDownloadBehaviorParameters {

  @ParamName("behavior")
  private SetDownloadBehaviorBehavior behavior;

  @Optional
  @ParamName("browserContextId")
  private String browserContextId;

  @Optional
  @ParamName("downloadPath")
  private String downloadPath;

  @Optional
  @ParamName("eventsEnabled")
  private Boolean eventsEnabled;

  /**
   * Whether to allow all or deny all download requests, or use default Chrome behavior if available
   * (otherwise deny). |allowAndName| allows download and names files according to their download
   * guids.
   */
  public SetDownloadBehaviorBehavior getBehavior() {
    return behavior;
  }

  /**
   * Whether to allow all or deny all download requests, or use default Chrome behavior if available
   * (otherwise deny). |allowAndName| allows download and names files according to their download
   * guids.
   */
  public SetDownloadBehaviorParameters setBehavior(SetDownloadBehaviorBehavior behavior) {
    this.behavior = behavior;
    return this;
  }

  /** BrowserContext to set download behavior. When omitted, default browser context is used. */
  public String getBrowserContextId() {
    return browserContextId;
  }

  /** BrowserContext to set download behavior. When omitted, default browser context is used. */
  public SetDownloadBehaviorParameters setBrowserContextId(String browserContextId) {
    this.browserContextId = browserContextId;
    return this;
  }

  /**
   * The default path to save downloaded files to. This is required if behavior is set to 'allow' or
   * 'allowAndName'.
   */
  public String getDownloadPath() {
    return downloadPath;
  }

  /**
   * The default path to save downloaded files to. This is required if behavior is set to 'allow' or
   * 'allowAndName'.
   */
  public SetDownloadBehaviorParameters setDownloadPath(String downloadPath) {
    this.downloadPath = downloadPath;
    return this;
  }

  /** Whether to emit download events (defaults to false). */
  public Boolean getEventsEnabled() {
    return eventsEnabled;
  }

  /** Whether to emit download events (defaults to false). */
  public SetDownloadBehaviorParameters setEventsEnabled(Boolean eventsEnabled) {
    this.eventsEnabled = eventsEnabled;
    return this;
  }
}
