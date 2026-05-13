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

/** Session event details specific to creation. */
@Experimental
public class CreationEventDetails {

  private DeviceBoundSessionFetchResult fetchResult;

  @Optional private DeviceBoundSession newSession;

  @Optional private DeviceBoundSessionFailedRequest failedRequest;

  /** The result of the fetch attempt. */
  public DeviceBoundSessionFetchResult getFetchResult() {
    return fetchResult;
  }

  /** The result of the fetch attempt. */
  public void setFetchResult(DeviceBoundSessionFetchResult fetchResult) {
    this.fetchResult = fetchResult;
  }

  /**
   * The session if there was a newly created session. This is populated for all successful creation
   * events.
   */
  public DeviceBoundSession getNewSession() {
    return newSession;
  }

  /**
   * The session if there was a newly created session. This is populated for all successful creation
   * events.
   */
  public void setNewSession(DeviceBoundSession newSession) {
    this.newSession = newSession;
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
