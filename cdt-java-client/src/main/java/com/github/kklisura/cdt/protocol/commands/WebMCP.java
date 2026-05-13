package com.github.kklisura.cdt.protocol.commands;

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

import com.github.kklisura.cdt.protocol.events.webmcp.ToolInvoked;
import com.github.kklisura.cdt.protocol.events.webmcp.ToolResponded;
import com.github.kklisura.cdt.protocol.events.webmcp.ToolsAdded;
import com.github.kklisura.cdt.protocol.events.webmcp.ToolsRemoved;
import com.github.kklisura.cdt.protocol.support.annotations.EventName;
import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;
import com.github.kklisura.cdt.protocol.support.annotations.Returns;
import com.github.kklisura.cdt.protocol.support.types.EventHandler;
import com.github.kklisura.cdt.protocol.support.types.EventListener;
import java.util.Map;

@Experimental
public interface WebMCP {

  /**
   * Enables the WebMCP domain, allowing events to be sent. Enabling the domain will trigger a
   * toolsAdded event for all currently registered tools.
   */
  void enable();

  /** Disables the WebMCP domain. */
  void disable();

  /**
   * Invokes a registered tool.
   *
   * @param frameId Frame in which to invoke the tool.
   * @param toolName Name of the tool to invoke.
   * @param input Input parameters for the tool, matching the tool's inputSchema.
   */
  @Returns("invocationId")
  String invokeTool(
      @ParamName("frameId") String frameId,
      @ParamName("toolName") String toolName,
      @ParamName("input") Map<String, Object> input);

  /**
   * Cancels a pending tool invocation.
   *
   * @param invocationId Invocation identifier to cancel.
   */
  void cancelInvocation(@ParamName("invocationId") String invocationId);

  /** Event fired when new tools are added. */
  @EventName("toolsAdded")
  EventListener onToolsAdded(EventHandler<ToolsAdded> eventListener);

  /** Event fired when tools are removed. */
  @EventName("toolsRemoved")
  EventListener onToolsRemoved(EventHandler<ToolsRemoved> eventListener);

  /** Event fired when a tool invocation starts. */
  @EventName("toolInvoked")
  EventListener onToolInvoked(EventHandler<ToolInvoked> eventListener);

  /** Event fired when a tool invocation completes or fails. */
  @EventName("toolResponded")
  EventListener onToolResponded(EventHandler<ToolResponded> eventListener);
}
