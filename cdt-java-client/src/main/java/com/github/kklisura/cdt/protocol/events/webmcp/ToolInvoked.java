package com.github.kklisura.cdt.protocol.events.webmcp;

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

/** Event fired when a tool invocation starts. */
public class ToolInvoked {

  private String toolName;

  private String frameId;

  private String invocationId;

  private String input;

  /** Name of the tool to invoke. */
  public String getToolName() {
    return toolName;
  }

  /** Name of the tool to invoke. */
  public void setToolName(String toolName) {
    this.toolName = toolName;
  }

  /** Frame id */
  public String getFrameId() {
    return frameId;
  }

  /** Frame id */
  public void setFrameId(String frameId) {
    this.frameId = frameId;
  }

  /** Invocation identifier. */
  public String getInvocationId() {
    return invocationId;
  }

  /** Invocation identifier. */
  public void setInvocationId(String invocationId) {
    this.invocationId = invocationId;
  }

  /** The input parameters used for the invocation. */
  public String getInput() {
    return input;
  }

  /** The input parameters used for the invocation. */
  public void setInput(String input) {
    this.input = input;
  }
}
