package com.github.kklisura.cdt.protocol.types.autofill;

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

public class AddressField {

  private String name;

  private String value;

  /**
   * address field name, for example GIVEN_NAME. The full list of supported field names:
   * https://source.chromium.org/chromium/chromium/src/+/main:components/autofill/core/browser/field_types.cc;l=38
   */
  public String getName() {
    return name;
  }

  /**
   * address field name, for example GIVEN_NAME. The full list of supported field names:
   * https://source.chromium.org/chromium/chromium/src/+/main:components/autofill/core/browser/field_types.cc;l=38
   */
  public void setName(String name) {
    this.name = name;
  }

  /** address field value, for example Jon Doe. */
  public String getValue() {
    return value;
  }

  /** address field value, for example Jon Doe. */
  public void setValue(String value) {
    this.value = value;
  }
}
