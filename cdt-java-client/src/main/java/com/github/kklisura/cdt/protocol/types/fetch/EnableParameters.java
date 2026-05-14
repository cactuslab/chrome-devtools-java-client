package com.github.kklisura.cdt.protocol.types.fetch;

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
import java.util.List;

/** Parameters for the enable command. */
public class EnableParameters {

  @Optional
  @ParamName("patterns")
  private List<RequestPattern> patterns;

  @Optional
  @ParamName("handleAuthRequests")
  private Boolean handleAuthRequests;

  /**
   * If specified, only requests matching any of these patterns will produce fetchRequested event
   * and will be paused until clients response. If not set, all requests will be affected.
   */
  public List<RequestPattern> getPatterns() {
    return patterns;
  }

  /**
   * If specified, only requests matching any of these patterns will produce fetchRequested event
   * and will be paused until clients response. If not set, all requests will be affected.
   */
  public EnableParameters setPatterns(List<RequestPattern> patterns) {
    this.patterns = patterns;
    return this;
  }

  /**
   * If true, authRequired events will be issued and requests will be paused expecting a call to
   * continueWithAuth.
   */
  public Boolean getHandleAuthRequests() {
    return handleAuthRequests;
  }

  /**
   * If true, authRequired events will be issued and requests will be paused expecting a call to
   * continueWithAuth.
   */
  public EnableParameters setHandleAuthRequests(Boolean handleAuthRequests) {
    this.handleAuthRequests = handleAuthRequests;
    return this;
  }
}
