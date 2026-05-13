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

import com.github.kklisura.cdt.protocol.support.annotations.Optional;

/** Section of the body of a CSS function rule. */
public class CSSFunctionNode {

  @Optional private CSSFunctionConditionNode condition;

  @Optional private CSSStyle style;

  /** A conditional block. If set, style should not be set. */
  public CSSFunctionConditionNode getCondition() {
    return condition;
  }

  /** A conditional block. If set, style should not be set. */
  public void setCondition(CSSFunctionConditionNode condition) {
    this.condition = condition;
  }

  /** Values set by this node. If set, condition should not be set. */
  public CSSStyle getStyle() {
    return style;
  }

  /** Values set by this node. If set, condition should not be set. */
  public void setStyle(CSSStyle style) {
    this.style = style;
  }
}
