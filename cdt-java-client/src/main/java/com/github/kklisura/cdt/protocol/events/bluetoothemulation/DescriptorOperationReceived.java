package com.github.kklisura.cdt.protocol.events.bluetoothemulation;

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
import com.github.kklisura.cdt.protocol.types.bluetoothemulation.DescriptorOperationType;

/**
 * Event for when a descriptor operation of |type| to the descriptor respresented by |descriptorId|
 * happened. |data| is expected to exist when |type| is write.
 */
public class DescriptorOperationReceived {

  private String descriptorId;

  private DescriptorOperationType type;

  @Optional private String data;

  public String getDescriptorId() {
    return descriptorId;
  }

  public void setDescriptorId(String descriptorId) {
    this.descriptorId = descriptorId;
  }

  public DescriptorOperationType getType() {
    return type;
  }

  public void setType(DescriptorOperationType type) {
    this.type = type;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }
}
