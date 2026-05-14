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

/** Parameters for the setBreakpointOnFunctionCall command. */
public class SetBreakpointOnFunctionCallParameters {

  @ParamName("objectId")
  private String objectId;

  @Optional
  @ParamName("condition")
  private String condition;

  /** Function object id. */
  public String getObjectId() {
    return objectId;
  }

  /** Function object id. */
  public SetBreakpointOnFunctionCallParameters setObjectId(String objectId) {
    this.objectId = objectId;
    return this;
  }

  /**
   * Expression to use as a breakpoint condition. When specified, debugger will stop on the
   * breakpoint if this expression evaluates to true.
   */
  public String getCondition() {
    return condition;
  }

  /**
   * Expression to use as a breakpoint condition. When specified, debugger will stop on the
   * breakpoint if this expression evaluates to true.
   */
  public SetBreakpointOnFunctionCallParameters setCondition(String condition) {
    this.condition = condition;
    return this;
  }
}
