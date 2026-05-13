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

/**
 * Represents the provenance of an ad resource or element. Only one of `filterlistRule` or
 * `adScriptAncestry` can be set. If `filterlistRule` is provided, the resource URL directly matches
 * a filter list rule. If `adScriptAncestry` is provided, an ad script initiated the resource fetch
 * or appended the element to the DOM. If neither is provided, the entity is known to be an ad, but
 * provenance tracking information is unavailable.
 */
@Experimental
public class AdProvenance {

  @Optional private String filterlistRule;

  @Optional private AdAncestry adScriptAncestry;

  /** The filterlist rule that matched, if any. */
  public String getFilterlistRule() {
    return filterlistRule;
  }

  /** The filterlist rule that matched, if any. */
  public void setFilterlistRule(String filterlistRule) {
    this.filterlistRule = filterlistRule;
  }

  /** The script ancestry that created the ad, if any. */
  public AdAncestry getAdScriptAncestry() {
    return adScriptAncestry;
  }

  /** The script ancestry that created the ad, if any. */
  public void setAdScriptAncestry(AdAncestry adScriptAncestry) {
    this.adScriptAncestry = adScriptAncestry;
  }
}
