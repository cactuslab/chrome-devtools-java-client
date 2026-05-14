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
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;

/** Parameters for the addRule command. */
public class AddRuleParameters {

  @ParamName("styleSheetId")
  private String styleSheetId;

  @ParamName("ruleText")
  private String ruleText;

  @ParamName("location")
  private SourceRange location;

  @Experimental
  @Optional
  @ParamName("nodeForPropertySyntaxValidation")
  private Integer nodeForPropertySyntaxValidation;

  /** The css style sheet identifier where a new rule should be inserted. */
  public String getStyleSheetId() {
    return styleSheetId;
  }

  /** The css style sheet identifier where a new rule should be inserted. */
  public AddRuleParameters setStyleSheetId(String styleSheetId) {
    this.styleSheetId = styleSheetId;
    return this;
  }

  /** The text of a new rule. */
  public String getRuleText() {
    return ruleText;
  }

  /** The text of a new rule. */
  public AddRuleParameters setRuleText(String ruleText) {
    this.ruleText = ruleText;
    return this;
  }

  /** Text position of a new rule in the target style sheet. */
  public SourceRange getLocation() {
    return location;
  }

  /** Text position of a new rule in the target style sheet. */
  public AddRuleParameters setLocation(SourceRange location) {
    this.location = location;
    return this;
  }

  /**
   * NodeId for the DOM node in whose context custom property declarations for registered properties
   * should be validated. If omitted, declarations in the new rule text can only be validated
   * statically, which may produce incorrect results if the declaration contains a var() for
   * example.
   */
  public Integer getNodeForPropertySyntaxValidation() {
    return nodeForPropertySyntaxValidation;
  }

  /**
   * NodeId for the DOM node in whose context custom property declarations for registered properties
   * should be validated. If omitted, declarations in the new rule text can only be validated
   * statically, which may produce incorrect results if the declaration contains a var() for
   * example.
   */
  public AddRuleParameters setNodeForPropertySyntaxValidation(
      Integer nodeForPropertySyntaxValidation) {
    this.nodeForPropertySyntaxValidation = nodeForPropertySyntaxValidation;
    return this;
  }
}
