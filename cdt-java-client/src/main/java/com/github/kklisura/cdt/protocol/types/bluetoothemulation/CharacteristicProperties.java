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

/**
 * Describes the properties of a characteristic. This follows Bluetooth Core Specification BT 4.2
 * Vol 3 Part G 3.3.1. Characteristic Properties.
 */
public class CharacteristicProperties {

  @Optional private Boolean broadcast;

  @Optional private Boolean read;

  @Optional private Boolean writeWithoutResponse;

  @Optional private Boolean write;

  @Optional private Boolean notify;

  @Optional private Boolean indicate;

  @Optional private Boolean authenticatedSignedWrites;

  @Optional private Boolean extendedProperties;

  public Boolean getBroadcast() {
    return broadcast;
  }

  public void setBroadcast(Boolean broadcast) {
    this.broadcast = broadcast;
  }

  public Boolean getRead() {
    return read;
  }

  public void setRead(Boolean read) {
    this.read = read;
  }

  public Boolean getWriteWithoutResponse() {
    return writeWithoutResponse;
  }

  public void setWriteWithoutResponse(Boolean writeWithoutResponse) {
    this.writeWithoutResponse = writeWithoutResponse;
  }

  public Boolean getWrite() {
    return write;
  }

  public void setWrite(Boolean write) {
    this.write = write;
  }

  public Boolean getNotify() {
    return notify;
  }

  public void setNotify(Boolean notify) {
    this.notify = notify;
  }

  public Boolean getIndicate() {
    return indicate;
  }

  public void setIndicate(Boolean indicate) {
    this.indicate = indicate;
  }

  public Boolean getAuthenticatedSignedWrites() {
    return authenticatedSignedWrites;
  }

  public void setAuthenticatedSignedWrites(Boolean authenticatedSignedWrites) {
    this.authenticatedSignedWrites = authenticatedSignedWrites;
  }

  public Boolean getExtendedProperties() {
    return extendedProperties;
  }

  public void setExtendedProperties(Boolean extendedProperties) {
    this.extendedProperties = extendedProperties;
  }
}
