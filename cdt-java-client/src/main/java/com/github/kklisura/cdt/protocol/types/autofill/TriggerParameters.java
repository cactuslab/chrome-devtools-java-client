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

import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;

/** Parameters for the trigger command. */
public class TriggerParameters {

  @ParamName("fieldId")
  private Integer fieldId;

  @Optional
  @ParamName("frameId")
  private String frameId;

  @Optional
  @ParamName("card")
  private CreditCard card;

  @Optional
  @ParamName("address")
  private Address address;

  /** Identifies a field that serves as an anchor for autofill. */
  public Integer getFieldId() {
    return fieldId;
  }

  /** Identifies a field that serves as an anchor for autofill. */
  public TriggerParameters setFieldId(Integer fieldId) {
    this.fieldId = fieldId;
    return this;
  }

  /** Identifies the frame that field belongs to. */
  public String getFrameId() {
    return frameId;
  }

  /** Identifies the frame that field belongs to. */
  public TriggerParameters setFrameId(String frameId) {
    this.frameId = frameId;
    return this;
  }

  /**
   * Credit card information to fill out the form. Credit card data is not saved. Mutually exclusive
   * with `address`.
   */
  public CreditCard getCard() {
    return card;
  }

  /**
   * Credit card information to fill out the form. Credit card data is not saved. Mutually exclusive
   * with `address`.
   */
  public TriggerParameters setCard(CreditCard card) {
    this.card = card;
    return this;
  }

  /** Address to fill out the form. Address data is not saved. Mutually exclusive with `card`. */
  public Address getAddress() {
    return address;
  }

  /** Address to fill out the form. Address data is not saved. Mutually exclusive with `card`. */
  public TriggerParameters setAddress(Address address) {
    this.address = address;
    return this;
  }
}
