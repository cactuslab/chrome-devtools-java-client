package com.github.kklisura.cdt.protocol.types.page;

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

/** Parameters for the generateTestReport command. */
public class GenerateTestReportParameters {

  @ParamName("message")
  private String message;

  @Optional
  @ParamName("group")
  private String group;

  /** Message to be displayed in the report. */
  public String getMessage() {
    return message;
  }

  /** Message to be displayed in the report. */
  public GenerateTestReportParameters setMessage(String message) {
    this.message = message;
    return this;
  }

  /** Specifies the endpoint group to deliver the report to. */
  public String getGroup() {
    return group;
  }

  /** Specifies the endpoint group to deliver the report to. */
  public GenerateTestReportParameters setGroup(String group) {
    this.group = group;
    return this;
  }
}
