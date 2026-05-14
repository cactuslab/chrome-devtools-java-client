package com.github.kklisura.cdt.protocol.types.target;

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

/** Parameters for the autoAttachRelated command. */
public class AutoAttachRelatedParameters {

  @ParamName("targetId")
  private String targetId;

  @ParamName("waitForDebuggerOnStart")
  private Boolean waitForDebuggerOnStart;

  @Experimental
  @Optional
  @ParamName("filter")
  private List<FilterEntry> filter;

  public String getTargetId() {
    return targetId;
  }

  public AutoAttachRelatedParameters setTargetId(String targetId) {
    this.targetId = targetId;
    return this;
  }

  /**
   * Whether to pause new targets when attaching to them. Use `Runtime.runIfWaitingForDebugger` to
   * run paused targets.
   */
  public Boolean getWaitForDebuggerOnStart() {
    return waitForDebuggerOnStart;
  }

  /**
   * Whether to pause new targets when attaching to them. Use `Runtime.runIfWaitingForDebugger` to
   * run paused targets.
   */
  public AutoAttachRelatedParameters setWaitForDebuggerOnStart(Boolean waitForDebuggerOnStart) {
    this.waitForDebuggerOnStart = waitForDebuggerOnStart;
    return this;
  }

  /** Only targets matching filter will be attached. */
  public List<FilterEntry> getFilter() {
    return filter;
  }

  /** Only targets matching filter will be attached. */
  public AutoAttachRelatedParameters setFilter(List<FilterEntry> filter) {
    this.filter = filter;
    return this;
  }
}
