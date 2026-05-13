package com.github.kklisura.cdt.protocol.types.webmcp;

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
import com.github.kklisura.cdt.protocol.types.runtime.StackTrace;
import java.util.Map;

/** Definition of a tool that can be invoked. */
public class Tool {

  private String name;

  private String description;

  @Optional private Map<String, Object> inputSchema;

  @Optional private Annotation annotations;

  private String frameId;

  @Optional private Integer backendNodeId;

  @Optional private StackTrace stackTrace;

  /** Tool name. */
  public String getName() {
    return name;
  }

  /** Tool name. */
  public void setName(String name) {
    this.name = name;
  }

  /** Tool description. */
  public String getDescription() {
    return description;
  }

  /** Tool description. */
  public void setDescription(String description) {
    this.description = description;
  }

  /** Schema for the tool's input parameters. */
  public Map<String, Object> getInputSchema() {
    return inputSchema;
  }

  /** Schema for the tool's input parameters. */
  public void setInputSchema(Map<String, Object> inputSchema) {
    this.inputSchema = inputSchema;
  }

  /** Optional annotations for the tool. */
  public Annotation getAnnotations() {
    return annotations;
  }

  /** Optional annotations for the tool. */
  public void setAnnotations(Annotation annotations) {
    this.annotations = annotations;
  }

  /** Frame identifier associated with the tool registration. */
  public String getFrameId() {
    return frameId;
  }

  /** Frame identifier associated with the tool registration. */
  public void setFrameId(String frameId) {
    this.frameId = frameId;
  }

  /** Optional node ID for declarative tools. */
  public Integer getBackendNodeId() {
    return backendNodeId;
  }

  /** Optional node ID for declarative tools. */
  public void setBackendNodeId(Integer backendNodeId) {
    this.backendNodeId = backendNodeId;
  }

  /** The stack trace at the time of the registration. */
  public StackTrace getStackTrace() {
    return stackTrace;
  }

  /** The stack trace at the time of the registration. */
  public void setStackTrace(StackTrace stackTrace) {
    this.stackTrace = stackTrace;
  }
}
