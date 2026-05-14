package com.github.kklisura.cdt.protocol.types.bluetoothemulation;

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

/** Parameters for the simulateCharacteristicOperationResponse command. */
public class SimulateCharacteristicOperationResponseParameters {

  @ParamName("characteristicId")
  private String characteristicId;

  @ParamName("type")
  private CharacteristicOperationType type;

  @ParamName("code")
  private Integer code;

  @Optional
  @ParamName("data")
  private String data;

  public String getCharacteristicId() {
    return characteristicId;
  }

  public SimulateCharacteristicOperationResponseParameters setCharacteristicId(
      String characteristicId) {
    this.characteristicId = characteristicId;
    return this;
  }

  public CharacteristicOperationType getType() {
    return type;
  }

  public SimulateCharacteristicOperationResponseParameters setType(
      CharacteristicOperationType type) {
    this.type = type;
    return this;
  }

  public Integer getCode() {
    return code;
  }

  public SimulateCharacteristicOperationResponseParameters setCode(Integer code) {
    this.code = code;
    return this;
  }

  public String getData() {
    return data;
  }

  public SimulateCharacteristicOperationResponseParameters setData(String data) {
    this.data = data;
    return this;
  }
}
