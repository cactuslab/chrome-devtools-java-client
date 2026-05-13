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
import java.util.List;

public class ComputedStyleForNode {

  private List<CSSComputedStyleProperty> computedStyle;

  @Experimental private ComputedStyleExtraFields extraFields;

  /** Computed style for the specified DOM node. */
  public List<CSSComputedStyleProperty> getComputedStyle() {
    return computedStyle;
  }

  /** Computed style for the specified DOM node. */
  public void setComputedStyle(List<CSSComputedStyleProperty> computedStyle) {
    this.computedStyle = computedStyle;
  }

  /** A list of non-standard "extra fields" which blink stores alongside each computed style. */
  public ComputedStyleExtraFields getExtraFields() {
    return extraFields;
  }

  /** A list of non-standard "extra fields" which blink stores alongside each computed style. */
  public void setExtraFields(ComputedStyleExtraFields extraFields) {
    this.extraFields = extraFields;
  }
}
