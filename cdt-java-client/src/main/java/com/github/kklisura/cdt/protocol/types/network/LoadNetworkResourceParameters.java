package com.github.kklisura.cdt.protocol.types.network;

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

/** Parameters for the loadNetworkResource command. */
public class LoadNetworkResourceParameters {

  @Optional
  @ParamName("frameId")
  private String frameId;

  @ParamName("url")
  private String url;

  @ParamName("options")
  private LoadNetworkResourceOptions options;

  /**
   * Frame id to get the resource for. Mandatory for frame targets, and should be omitted for worker
   * targets.
   */
  public String getFrameId() {
    return frameId;
  }

  /**
   * Frame id to get the resource for. Mandatory for frame targets, and should be omitted for worker
   * targets.
   */
  public LoadNetworkResourceParameters setFrameId(String frameId) {
    this.frameId = frameId;
    return this;
  }

  /** URL of the resource to get content for. */
  public String getUrl() {
    return url;
  }

  /** URL of the resource to get content for. */
  public LoadNetworkResourceParameters setUrl(String url) {
    this.url = url;
    return this;
  }

  /** Options for the request. */
  public LoadNetworkResourceOptions getOptions() {
    return options;
  }

  /** Options for the request. */
  public LoadNetworkResourceParameters setOptions(LoadNetworkResourceOptions options) {
    this.options = options;
    return this;
  }
}
