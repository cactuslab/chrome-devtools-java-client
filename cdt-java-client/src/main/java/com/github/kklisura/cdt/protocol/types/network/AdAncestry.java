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

/**
 * Encapsulates the script ancestry and the root script filter list rule that caused the resource or
 * element to be labeled as an ad.
 */
@Experimental
public class AdAncestry {

  private List<AdScriptIdentifier> ancestryChain;

  @Optional private String rootScriptFilterlistRule;

  /**
   * A chain of `AdScriptIdentifier`s representing the ancestry of an ad script that led to the
   * creation of a resource or element. The chain is ordered from the script itself (lowest level)
   * up to its root ancestor that was flagged by a filter list.
   */
  public List<AdScriptIdentifier> getAncestryChain() {
    return ancestryChain;
  }

  /**
   * A chain of `AdScriptIdentifier`s representing the ancestry of an ad script that led to the
   * creation of a resource or element. The chain is ordered from the script itself (lowest level)
   * up to its root ancestor that was flagged by a filter list.
   */
  public void setAncestryChain(List<AdScriptIdentifier> ancestryChain) {
    this.ancestryChain = ancestryChain;
  }

  /**
   * The filter list rule that caused the root (last) script in `ancestryChain` to be tagged as an
   * ad.
   */
  public String getRootScriptFilterlistRule() {
    return rootScriptFilterlistRule;
  }

  /**
   * The filter list rule that caused the root (last) script in `ancestryChain` to be tagged as an
   * ad.
   */
  public void setRootScriptFilterlistRule(String rootScriptFilterlistRule) {
    this.rootScriptFilterlistRule = rootScriptFilterlistRule;
  }
}
