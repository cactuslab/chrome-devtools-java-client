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

/** A device bound session's inclusion URL rule. */
@Experimental
public class DeviceBoundSessionUrlRule {

  private DeviceBoundSessionUrlRuleRuleType ruleType;

  private String hostPattern;

  private String pathPrefix;

  /** See comments on `net::device_bound_sessions::SessionInclusionRules::UrlRule::rule_type`. */
  public DeviceBoundSessionUrlRuleRuleType getRuleType() {
    return ruleType;
  }

  /** See comments on `net::device_bound_sessions::SessionInclusionRules::UrlRule::rule_type`. */
  public void setRuleType(DeviceBoundSessionUrlRuleRuleType ruleType) {
    this.ruleType = ruleType;
  }

  /** See comments on `net::device_bound_sessions::SessionInclusionRules::UrlRule::host_pattern`. */
  public String getHostPattern() {
    return hostPattern;
  }

  /** See comments on `net::device_bound_sessions::SessionInclusionRules::UrlRule::host_pattern`. */
  public void setHostPattern(String hostPattern) {
    this.hostPattern = hostPattern;
  }

  /** See comments on `net::device_bound_sessions::SessionInclusionRules::UrlRule::path_prefix`. */
  public String getPathPrefix() {
    return pathPrefix;
  }

  /** See comments on `net::device_bound_sessions::SessionInclusionRules::UrlRule::path_prefix`. */
  public void setPathPrefix(String pathPrefix) {
    this.pathPrefix = pathPrefix;
  }
}
