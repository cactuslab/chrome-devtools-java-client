package com.github.kklisura.cdt.protocol.types.audits;

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
import com.github.kklisura.cdt.protocol.types.network.AdAncestry;
import com.github.kklisura.cdt.protocol.types.runtime.StackTrace;

/**
 * The issue warns about blocked calls to privacy sensitive APIs via the Selective Permissions
 * Intervention.
 */
public class SelectivePermissionsInterventionIssueDetails {

  private String apiName;

  private AdAncestry adAncestry;

  @Optional private StackTrace stackTrace;

  /** Which API was intervened on. */
  public String getApiName() {
    return apiName;
  }

  /** Which API was intervened on. */
  public void setApiName(String apiName) {
    this.apiName = apiName;
  }

  /** Why the ad script using the API is considered an ad. */
  public AdAncestry getAdAncestry() {
    return adAncestry;
  }

  /** Why the ad script using the API is considered an ad. */
  public void setAdAncestry(AdAncestry adAncestry) {
    this.adAncestry = adAncestry;
  }

  /** The stack trace at the time of the intervention. */
  public StackTrace getStackTrace() {
    return stackTrace;
  }

  /** The stack trace at the time of the intervention. */
  public void setStackTrace(StackTrace stackTrace) {
    this.stackTrace = stackTrace;
  }
}
