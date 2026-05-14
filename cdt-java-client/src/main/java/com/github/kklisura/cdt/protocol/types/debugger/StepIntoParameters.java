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

import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;
import java.util.List;

/** Parameters for the stepInto command. */
public class StepIntoParameters {

  @Experimental
  @Optional
  @ParamName("breakOnAsyncCall")
  private Boolean breakOnAsyncCall;

  @Experimental
  @Optional
  @ParamName("skipList")
  private List<LocationRange> skipList;

  /**
   * Debugger will pause on the execution of the first async task which was scheduled before next
   * pause.
   */
  public Boolean getBreakOnAsyncCall() {
    return breakOnAsyncCall;
  }

  /**
   * Debugger will pause on the execution of the first async task which was scheduled before next
   * pause.
   */
  public StepIntoParameters setBreakOnAsyncCall(Boolean breakOnAsyncCall) {
    this.breakOnAsyncCall = breakOnAsyncCall;
    return this;
  }

  /** The skipList specifies location ranges that should be skipped on step into. */
  public List<LocationRange> getSkipList() {
    return skipList;
  }

  /** The skipList specifies location ranges that should be skipped on step into. */
  public StepIntoParameters setSkipList(List<LocationRange> skipList) {
    this.skipList = skipList;
    return this;
  }
}
