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

/** Parameters for the resume command. */
public class ResumeParameters {

  @Optional
  @ParamName("terminateOnResume")
  private Boolean terminateOnResume;

  /**
   * Set to true to terminate execution upon resuming execution. In contrast to
   * Runtime.terminateExecution, this will allows to execute further JavaScript (i.e. via
   * evaluation) until execution of the paused code is actually resumed, at which point termination
   * is triggered. If execution is currently not paused, this parameter has no effect.
   */
  public Boolean getTerminateOnResume() {
    return terminateOnResume;
  }

  /**
   * Set to true to terminate execution upon resuming execution. In contrast to
   * Runtime.terminateExecution, this will allows to execute further JavaScript (i.e. via
   * evaluation) until execution of the paused code is actually resumed, at which point termination
   * is triggered. If execution is currently not paused, this parameter has no effect.
   */
  public ResumeParameters setTerminateOnResume(Boolean terminateOnResume) {
    this.terminateOnResume = terminateOnResume;
    return this;
  }
}
