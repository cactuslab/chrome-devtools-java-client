package com.github.kklisura.cdt.protocol.events.network;

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
import com.github.kklisura.cdt.protocol.types.network.ChallengeEventDetails;
import com.github.kklisura.cdt.protocol.types.network.CreationEventDetails;
import com.github.kklisura.cdt.protocol.types.network.RefreshEventDetails;
import com.github.kklisura.cdt.protocol.types.network.TerminationEventDetails;

/** Triggered when a device bound session event occurs. */
@Experimental
public class DeviceBoundSessionEventOccurred {

  private String eventId;

  private String site;

  private Boolean succeeded;

  @Optional private String sessionId;

  @Optional private CreationEventDetails creationEventDetails;

  @Optional private RefreshEventDetails refreshEventDetails;

  @Optional private TerminationEventDetails terminationEventDetails;

  @Optional private ChallengeEventDetails challengeEventDetails;

  /** A unique identifier for this session event. */
  public String getEventId() {
    return eventId;
  }

  /** A unique identifier for this session event. */
  public void setEventId(String eventId) {
    this.eventId = eventId;
  }

  /** The site this session event is associated with. */
  public String getSite() {
    return site;
  }

  /** The site this session event is associated with. */
  public void setSite(String site) {
    this.site = site;
  }

  /** Whether this event was considered successful. */
  public Boolean getSucceeded() {
    return succeeded;
  }

  /** Whether this event was considered successful. */
  public void setSucceeded(Boolean succeeded) {
    this.succeeded = succeeded;
  }

  /** The session ID this event is associated with. May not be populated for failed events. */
  public String getSessionId() {
    return sessionId;
  }

  /** The session ID this event is associated with. May not be populated for failed events. */
  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  /** The below are the different session event type details. Exactly one is populated. */
  public CreationEventDetails getCreationEventDetails() {
    return creationEventDetails;
  }

  /** The below are the different session event type details. Exactly one is populated. */
  public void setCreationEventDetails(CreationEventDetails creationEventDetails) {
    this.creationEventDetails = creationEventDetails;
  }

  public RefreshEventDetails getRefreshEventDetails() {
    return refreshEventDetails;
  }

  public void setRefreshEventDetails(RefreshEventDetails refreshEventDetails) {
    this.refreshEventDetails = refreshEventDetails;
  }

  public TerminationEventDetails getTerminationEventDetails() {
    return terminationEventDetails;
  }

  public void setTerminationEventDetails(TerminationEventDetails terminationEventDetails) {
    this.terminationEventDetails = terminationEventDetails;
  }

  public ChallengeEventDetails getChallengeEventDetails() {
    return challengeEventDetails;
  }

  public void setChallengeEventDetails(ChallengeEventDetails challengeEventDetails) {
    this.challengeEventDetails = challengeEventDetails;
  }
}
