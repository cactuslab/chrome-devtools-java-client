package com.github.kklisura.cdt.protocol.types.css;

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
import java.util.List;

/** CSS function at-rule representation. */
public class CSSFunctionRule {

  private Value name;

  @Optional private String styleSheetId;

  private StyleSheetOrigin origin;

  private List<CSSFunctionParameter> parameters;

  private List<CSSFunctionNode> children;

  @Experimental @Optional private Integer originTreeScopeNodeId;

  /** Name of the function. */
  public Value getName() {
    return name;
  }

  /** Name of the function. */
  public void setName(Value name) {
    this.name = name;
  }

  /**
   * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet
   * rules) this rule came from.
   */
  public String getStyleSheetId() {
    return styleSheetId;
  }

  /**
   * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet
   * rules) this rule came from.
   */
  public void setStyleSheetId(String styleSheetId) {
    this.styleSheetId = styleSheetId;
  }

  /** Parent stylesheet's origin. */
  public StyleSheetOrigin getOrigin() {
    return origin;
  }

  /** Parent stylesheet's origin. */
  public void setOrigin(StyleSheetOrigin origin) {
    this.origin = origin;
  }

  /** List of parameters. */
  public List<CSSFunctionParameter> getParameters() {
    return parameters;
  }

  /** List of parameters. */
  public void setParameters(List<CSSFunctionParameter> parameters) {
    this.parameters = parameters;
  }

  /** Function body. */
  public List<CSSFunctionNode> getChildren() {
    return children;
  }

  /** Function body. */
  public void setChildren(List<CSSFunctionNode> children) {
    this.children = children;
  }

  /** The BackendNodeId of the DOM node that constitutes the origin tree scope of this rule. */
  public Integer getOriginTreeScopeNodeId() {
    return originTreeScopeNodeId;
  }

  /** The BackendNodeId of the DOM node that constitutes the origin tree scope of this rule. */
  public void setOriginTreeScopeNodeId(Integer originTreeScopeNodeId) {
    this.originTreeScopeNodeId = originTreeScopeNodeId;
  }
}
