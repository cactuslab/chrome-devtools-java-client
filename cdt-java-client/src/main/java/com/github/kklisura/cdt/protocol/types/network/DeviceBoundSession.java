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
import java.util.List;

/** A device bound session. */
@Experimental
public class DeviceBoundSession {

  private DeviceBoundSessionKey key;

  private String refreshUrl;

  private DeviceBoundSessionInclusionRules inclusionRules;

  private List<DeviceBoundSessionCookieCraving> cookieCravings;

  private Double expiryDate;

  @Optional private String cachedChallenge;

  private List<String> allowedRefreshInitiators;

  /** The site and session ID of the session. */
  public DeviceBoundSessionKey getKey() {
    return key;
  }

  /** The site and session ID of the session. */
  public void setKey(DeviceBoundSessionKey key) {
    this.key = key;
  }

  /** See comments on `net::device_bound_sessions::Session::refresh_url_`. */
  public String getRefreshUrl() {
    return refreshUrl;
  }

  /** See comments on `net::device_bound_sessions::Session::refresh_url_`. */
  public void setRefreshUrl(String refreshUrl) {
    this.refreshUrl = refreshUrl;
  }

  /** See comments on `net::device_bound_sessions::Session::inclusion_rules_`. */
  public DeviceBoundSessionInclusionRules getInclusionRules() {
    return inclusionRules;
  }

  /** See comments on `net::device_bound_sessions::Session::inclusion_rules_`. */
  public void setInclusionRules(DeviceBoundSessionInclusionRules inclusionRules) {
    this.inclusionRules = inclusionRules;
  }

  /** See comments on `net::device_bound_sessions::Session::cookie_cravings_`. */
  public List<DeviceBoundSessionCookieCraving> getCookieCravings() {
    return cookieCravings;
  }

  /** See comments on `net::device_bound_sessions::Session::cookie_cravings_`. */
  public void setCookieCravings(List<DeviceBoundSessionCookieCraving> cookieCravings) {
    this.cookieCravings = cookieCravings;
  }

  /** See comments on `net::device_bound_sessions::Session::expiry_date_`. */
  public Double getExpiryDate() {
    return expiryDate;
  }

  /** See comments on `net::device_bound_sessions::Session::expiry_date_`. */
  public void setExpiryDate(Double expiryDate) {
    this.expiryDate = expiryDate;
  }

  /** See comments on `net::device_bound_sessions::Session::cached_challenge__`. */
  public String getCachedChallenge() {
    return cachedChallenge;
  }

  /** See comments on `net::device_bound_sessions::Session::cached_challenge__`. */
  public void setCachedChallenge(String cachedChallenge) {
    this.cachedChallenge = cachedChallenge;
  }

  /** See comments on `net::device_bound_sessions::Session::allowed_refresh_initiators_`. */
  public List<String> getAllowedRefreshInitiators() {
    return allowedRefreshInitiators;
  }

  /** See comments on `net::device_bound_sessions::Session::allowed_refresh_initiators_`. */
  public void setAllowedRefreshInitiators(List<String> allowedRefreshInitiators) {
    this.allowedRefreshInitiators = allowedRefreshInitiators;
  }
}
