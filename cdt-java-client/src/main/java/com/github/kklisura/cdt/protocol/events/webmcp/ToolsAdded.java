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

import com.github.kklisura.cdt.protocol.types.webmcp.Tool;
import java.util.List;

/** Event fired when new tools are added. */
public class ToolsAdded {

  private List<Tool> tools;

  /** Array of tools that were added. */
  public List<Tool> getTools() {
    return tools;
  }

  /** Array of tools that were added. */
  public void setTools(List<Tool> tools) {
    this.tools = tools;
  }
}
