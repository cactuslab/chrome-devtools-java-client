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

import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;

/** Session event details specific to refresh. */
@Experimental
public class RefreshEventDetails {

  private RefreshEventDetailsRefreshResult refreshResult;

  @Optional private DeviceBoundSessionFetchResult fetchResult;

  @Optional private DeviceBoundSession newSession;

  private Boolean wasFullyProactiveRefresh;

  @Optional private DeviceBoundSessionFailedRequest failedRequest;

  /** The result of a refresh. */
  public RefreshEventDetailsRefreshResult getRefreshResult() {
    return refreshResult;
  }

  /** The result of a refresh. */
  public void setRefreshResult(RefreshEventDetailsRefreshResult refreshResult) {
    this.refreshResult = refreshResult;
  }

  /** If there was a fetch attempt, the result of that. */
  public DeviceBoundSessionFetchResult getFetchResult() {
    return fetchResult;
  }

  /** If there was a fetch attempt, the result of that. */
  public void setFetchResult(DeviceBoundSessionFetchResult fetchResult) {
    this.fetchResult = fetchResult;
  }

  /**
   * The session display if there was a newly created session. This is populated for any refresh
   * event that modifies the session config.
   */
  public DeviceBoundSession getNewSession() {
    return newSession;
  }

  /**
   * The session display if there was a newly created session. This is populated for any refresh
   * event that modifies the session config.
   */
  public void setNewSession(DeviceBoundSession newSession) {
    this.newSession = newSession;
  }

  /**
   * See comments on `net::device_bound_sessions::RefreshEventResult::was_fully_proactive_refresh`.
   */
  public Boolean getWasFullyProactiveRefresh() {
    return wasFullyProactiveRefresh;
  }

  /**
   * See comments on `net::device_bound_sessions::RefreshEventResult::was_fully_proactive_refresh`.
   */
  public void setWasFullyProactiveRefresh(Boolean wasFullyProactiveRefresh) {
    this.wasFullyProactiveRefresh = wasFullyProactiveRefresh;
  }

  /** Details about a failed device bound session network request if there was one. */
  public DeviceBoundSessionFailedRequest getFailedRequest() {
    return failedRequest;
  }

  /** Details about a failed device bound session network request if there was one. */
  public void setFailedRequest(DeviceBoundSessionFailedRequest failedRequest) {
    this.failedRequest = failedRequest;
  }
}
