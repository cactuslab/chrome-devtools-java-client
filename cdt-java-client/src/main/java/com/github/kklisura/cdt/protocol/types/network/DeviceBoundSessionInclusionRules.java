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
import java.util.List;

/** A device bound session's inclusion rules. */
@Experimental
public class DeviceBoundSessionInclusionRules {

  private String origin;

  private Boolean includeSite;

  private List<DeviceBoundSessionUrlRule> urlRules;

  /** See comments on `net::device_bound_sessions::SessionInclusionRules::origin_`. */
  public String getOrigin() {
    return origin;
  }

  /** See comments on `net::device_bound_sessions::SessionInclusionRules::origin_`. */
  public void setOrigin(String origin) {
    this.origin = origin;
  }

  /**
   * Whether the whole site is included. See comments on
   * `net::device_bound_sessions::SessionInclusionRules::include_site_` for more details; this
   * boolean is true if that value is populated.
   */
  public Boolean getIncludeSite() {
    return includeSite;
  }

  /**
   * Whether the whole site is included. See comments on
   * `net::device_bound_sessions::SessionInclusionRules::include_site_` for more details; this
   * boolean is true if that value is populated.
   */
  public void setIncludeSite(Boolean includeSite) {
    this.includeSite = includeSite;
  }

  /** See comments on `net::device_bound_sessions::SessionInclusionRules::url_rules_`. */
  public List<DeviceBoundSessionUrlRule> getUrlRules() {
    return urlRules;
  }

  /** See comments on `net::device_bound_sessions::SessionInclusionRules::url_rules_`. */
  public void setUrlRules(List<DeviceBoundSessionUrlRule> urlRules) {
    this.urlRules = urlRules;
  }
}
