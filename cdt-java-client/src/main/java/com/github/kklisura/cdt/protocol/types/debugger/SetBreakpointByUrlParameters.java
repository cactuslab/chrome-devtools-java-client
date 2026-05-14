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

/** Parameters for the setBreakpointByUrl command. */
public class SetBreakpointByUrlParameters {

  @ParamName("lineNumber")
  private Integer lineNumber;

  @Optional
  @ParamName("url")
  private String url;

  @Optional
  @ParamName("urlRegex")
  private String urlRegex;

  @Optional
  @ParamName("scriptHash")
  private String scriptHash;

  @Optional
  @ParamName("columnNumber")
  private Integer columnNumber;

  @Optional
  @ParamName("condition")
  private String condition;

  /** Line number to set breakpoint at. */
  public Integer getLineNumber() {
    return lineNumber;
  }

  /** Line number to set breakpoint at. */
  public SetBreakpointByUrlParameters setLineNumber(Integer lineNumber) {
    this.lineNumber = lineNumber;
    return this;
  }

  /** URL of the resources to set breakpoint on. */
  public String getUrl() {
    return url;
  }

  /** URL of the resources to set breakpoint on. */
  public SetBreakpointByUrlParameters setUrl(String url) {
    this.url = url;
    return this;
  }

  /**
   * Regex pattern for the URLs of the resources to set breakpoints on. Either `url` or `urlRegex`
   * must be specified.
   */
  public String getUrlRegex() {
    return urlRegex;
  }

  /**
   * Regex pattern for the URLs of the resources to set breakpoints on. Either `url` or `urlRegex`
   * must be specified.
   */
  public SetBreakpointByUrlParameters setUrlRegex(String urlRegex) {
    this.urlRegex = urlRegex;
    return this;
  }

  /** Script hash of the resources to set breakpoint on. */
  public String getScriptHash() {
    return scriptHash;
  }

  /** Script hash of the resources to set breakpoint on. */
  public SetBreakpointByUrlParameters setScriptHash(String scriptHash) {
    this.scriptHash = scriptHash;
    return this;
  }

  /** Offset in the line to set breakpoint at. */
  public Integer getColumnNumber() {
    return columnNumber;
  }

  /** Offset in the line to set breakpoint at. */
  public SetBreakpointByUrlParameters setColumnNumber(Integer columnNumber) {
    this.columnNumber = columnNumber;
    return this;
  }

  /**
   * Expression to use as a breakpoint condition. When specified, debugger will only stop on the
   * breakpoint if this expression evaluates to true.
   */
  public String getCondition() {
    return condition;
  }

  /**
   * Expression to use as a breakpoint condition. When specified, debugger will only stop on the
   * breakpoint if this expression evaluates to true.
   */
  public SetBreakpointByUrlParameters setCondition(String condition) {
    this.condition = condition;
    return this;
  }
}
