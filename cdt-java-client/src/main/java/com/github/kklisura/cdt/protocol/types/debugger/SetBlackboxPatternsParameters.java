package com.github.kklisura.cdt.protocol.types.debugger;

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

/** Parameters for the setBlackboxPatterns command. */
public class SetBlackboxPatternsParameters {

  @ParamName("patterns")
  private List<String> patterns;

  @Optional
  @ParamName("skipAnonymous")
  private Boolean skipAnonymous;

  /** Array of regexps that will be used to check script url for blackbox state. */
  public List<String> getPatterns() {
    return patterns;
  }

  /** Array of regexps that will be used to check script url for blackbox state. */
  public SetBlackboxPatternsParameters setPatterns(List<String> patterns) {
    this.patterns = patterns;
    return this;
  }

  /** If true, also ignore scripts with no source url. */
  public Boolean getSkipAnonymous() {
    return skipAnonymous;
  }

  /** If true, also ignore scripts with no source url. */
  public SetBlackboxPatternsParameters setSkipAnonymous(Boolean skipAnonymous) {
    this.skipAnonymous = skipAnonymous;
    return this;
  }
}
