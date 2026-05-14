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
import java.util.List;

/** Parameters for the emulateNetworkConditionsByRule command. */
public class EmulateNetworkConditionsByRuleParameters {

  @Deprecated
  @Optional
  @ParamName("offline")
  private Boolean offline;

  @Optional
  @ParamName("emulateOfflineServiceWorker")
  private Boolean emulateOfflineServiceWorker;

  @ParamName("matchedNetworkConditions")
  private List<NetworkConditions> matchedNetworkConditions;

  /**
   * True to emulate internet disconnection. Deprecated, use the offline property in
   * matchedNetworkConditions or emulateOfflineServiceWorker instead.
   */
  public Boolean getOffline() {
    return offline;
  }

  /**
   * True to emulate internet disconnection. Deprecated, use the offline property in
   * matchedNetworkConditions or emulateOfflineServiceWorker instead.
   */
  public EmulateNetworkConditionsByRuleParameters setOffline(Boolean offline) {
    this.offline = offline;
    return this;
  }

  /** True to emulate offline service worker. */
  public Boolean getEmulateOfflineServiceWorker() {
    return emulateOfflineServiceWorker;
  }

  /** True to emulate offline service worker. */
  public EmulateNetworkConditionsByRuleParameters setEmulateOfflineServiceWorker(
      Boolean emulateOfflineServiceWorker) {
    this.emulateOfflineServiceWorker = emulateOfflineServiceWorker;
    return this;
  }

  /**
   * Configure conditions for matching requests. If multiple entries match a request, the first
   * entry wins. Global conditions can be configured by leaving the urlPattern for the conditions
   * empty. These global conditions are also applied for throttling of p2p connections.
   */
  public List<NetworkConditions> getMatchedNetworkConditions() {
    return matchedNetworkConditions;
  }

  /**
   * Configure conditions for matching requests. If multiple entries match a request, the first
   * entry wins. Global conditions can be configured by leaving the urlPattern for the conditions
   * empty. These global conditions are also applied for throttling of p2p connections.
   */
  public EmulateNetworkConditionsByRuleParameters setMatchedNetworkConditions(
      List<NetworkConditions> matchedNetworkConditions) {
    this.matchedNetworkConditions = matchedNetworkConditions;
    return this;
  }
}
