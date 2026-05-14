package com.github.kklisura.cdt.protocol.commands;

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

import com.github.kklisura.cdt.protocol.events.bluetoothemulation.CharacteristicOperationReceived;
import com.github.kklisura.cdt.protocol.events.bluetoothemulation.DescriptorOperationReceived;
import com.github.kklisura.cdt.protocol.events.bluetoothemulation.GattOperationReceived;
import com.github.kklisura.cdt.protocol.support.annotations.EventName;
import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;
import com.github.kklisura.cdt.protocol.support.annotations.ParamObject;
import com.github.kklisura.cdt.protocol.support.annotations.Returns;
import com.github.kklisura.cdt.protocol.support.types.EventHandler;
import com.github.kklisura.cdt.protocol.support.types.EventListener;
import com.github.kklisura.cdt.protocol.types.bluetoothemulation.CentralState;
import com.github.kklisura.cdt.protocol.types.bluetoothemulation.CharacteristicOperationType;
import com.github.kklisura.cdt.protocol.types.bluetoothemulation.CharacteristicProperties;
import com.github.kklisura.cdt.protocol.types.bluetoothemulation.DescriptorOperationType;
import com.github.kklisura.cdt.protocol.types.bluetoothemulation.GATTOperationType;
import com.github.kklisura.cdt.protocol.types.bluetoothemulation.ManufacturerData;
import com.github.kklisura.cdt.protocol.types.bluetoothemulation.ScanEntry;
import com.github.kklisura.cdt.protocol.types.bluetoothemulation.SimulateCharacteristicOperationResponseParameters;
import com.github.kklisura.cdt.protocol.types.bluetoothemulation.SimulateDescriptorOperationResponseParameters;
import java.util.List;

/** This domain allows configuring virtual Bluetooth devices to test the web-bluetooth API. */
@Experimental
public interface BluetoothEmulation {

  /**
   * Enable the BluetoothEmulation domain.
   *
   * @param state State of the simulated central.
   * @param leSupported If the simulated central supports low-energy.
   */
  void enable(
      @ParamName("state") CentralState state, @ParamName("leSupported") Boolean leSupported);

  /**
   * Set the state of the simulated central.
   *
   * @param state State of the simulated central.
   */
  void setSimulatedCentralState(@ParamName("state") CentralState state);

  /** Disable the BluetoothEmulation domain. */
  void disable();

  /**
   * Simulates a peripheral with |address|, |name| and |knownServiceUuids| that has already been
   * connected to the system.
   *
   * @param address
   * @param name
   * @param manufacturerData
   * @param knownServiceUuids
   */
  void simulatePreconnectedPeripheral(
      @ParamName("address") String address,
      @ParamName("name") String name,
      @ParamName("manufacturerData") List<ManufacturerData> manufacturerData,
      @ParamName("knownServiceUuids") List<String> knownServiceUuids);

  /**
   * Simulates an advertisement packet described in |entry| being received by the central.
   *
   * @param entry
   */
  void simulateAdvertisement(@ParamName("entry") ScanEntry entry);

  /**
   * Simulates the response code from the peripheral with |address| for a GATT operation of |type|.
   * The |code| value follows the HCI Error Codes from Bluetooth Core Specification Vol 2 Part D 1.3
   * List Of Error Codes.
   *
   * @param address
   * @param type
   * @param code
   */
  void simulateGATTOperationResponse(
      @ParamName("address") String address,
      @ParamName("type") GATTOperationType type,
      @ParamName("code") Integer code);

  /**
   * Simulates the response from the characteristic with |characteristicId| for a characteristic
   * operation of |type|. The |code| value follows the Error Codes from Bluetooth Core Specification
   * Vol 3 Part F 3.4.1.1 Error Response. The |data| is expected to exist when simulating a
   * successful read operation response.
   *
   * @param characteristicId
   * @param type
   * @param code
   */
  void simulateCharacteristicOperationResponse(
      @ParamName("characteristicId") String characteristicId,
      @ParamName("type") CharacteristicOperationType type,
      @ParamName("code") Integer code);

  /**
   * Simulates the response from the characteristic with |characteristicId| for a characteristic
   * operation of |type|. The |code| value follows the Error Codes from Bluetooth Core Specification
   * Vol 3 Part F 3.4.1.1 Error Response. The |data| is expected to exist when simulating a
   * successful read operation response.
   *
   * @param characteristicId
   * @param type
   * @param code
   * @param data
   */
  void simulateCharacteristicOperationResponse(
      @ParamName("characteristicId") String characteristicId,
      @ParamName("type") CharacteristicOperationType type,
      @ParamName("code") Integer code,
      @Optional @ParamName("data") String data);

  /**
   * Simulates the response from the characteristic with |characteristicId| for a characteristic
   * operation of |type|. The |code| value follows the Error Codes from Bluetooth Core Specification
   * Vol 3 Part F 3.4.1.1 Error Response. The |data| is expected to exist when simulating a
   * successful read operation response.
   */
  void simulateCharacteristicOperationResponse(
      @ParamObject SimulateCharacteristicOperationResponseParameters parameters);

  /**
   * Simulates the response from the descriptor with |descriptorId| for a descriptor operation of
   * |type|. The |code| value follows the Error Codes from Bluetooth Core Specification Vol 3 Part F
   * 3.4.1.1 Error Response. The |data| is expected to exist when simulating a successful read
   * operation response.
   *
   * @param descriptorId
   * @param type
   * @param code
   */
  void simulateDescriptorOperationResponse(
      @ParamName("descriptorId") String descriptorId,
      @ParamName("type") DescriptorOperationType type,
      @ParamName("code") Integer code);

  /**
   * Simulates the response from the descriptor with |descriptorId| for a descriptor operation of
   * |type|. The |code| value follows the Error Codes from Bluetooth Core Specification Vol 3 Part F
   * 3.4.1.1 Error Response. The |data| is expected to exist when simulating a successful read
   * operation response.
   *
   * @param descriptorId
   * @param type
   * @param code
   * @param data
   */
  void simulateDescriptorOperationResponse(
      @ParamName("descriptorId") String descriptorId,
      @ParamName("type") DescriptorOperationType type,
      @ParamName("code") Integer code,
      @Optional @ParamName("data") String data);

  /**
   * Simulates the response from the descriptor with |descriptorId| for a descriptor operation of
   * |type|. The |code| value follows the Error Codes from Bluetooth Core Specification Vol 3 Part F
   * 3.4.1.1 Error Response. The |data| is expected to exist when simulating a successful read
   * operation response.
   */
  void simulateDescriptorOperationResponse(
      @ParamObject SimulateDescriptorOperationResponseParameters parameters);

  /**
   * Adds a service with |serviceUuid| to the peripheral with |address|.
   *
   * @param address
   * @param serviceUuid
   */
  @Returns("serviceId")
  String addService(
      @ParamName("address") String address, @ParamName("serviceUuid") String serviceUuid);

  /**
   * Removes the service respresented by |serviceId| from the simulated central.
   *
   * @param serviceId
   */
  void removeService(@ParamName("serviceId") String serviceId);

  /**
   * Adds a characteristic with |characteristicUuid| and |properties| to the service represented by
   * |serviceId|.
   *
   * @param serviceId
   * @param characteristicUuid
   * @param properties
   */
  @Returns("characteristicId")
  String addCharacteristic(
      @ParamName("serviceId") String serviceId,
      @ParamName("characteristicUuid") String characteristicUuid,
      @ParamName("properties") CharacteristicProperties properties);

  /**
   * Removes the characteristic respresented by |characteristicId| from the simulated central.
   *
   * @param characteristicId
   */
  void removeCharacteristic(@ParamName("characteristicId") String characteristicId);

  /**
   * Adds a descriptor with |descriptorUuid| to the characteristic respresented by
   * |characteristicId|.
   *
   * @param characteristicId
   * @param descriptorUuid
   */
  @Returns("descriptorId")
  String addDescriptor(
      @ParamName("characteristicId") String characteristicId,
      @ParamName("descriptorUuid") String descriptorUuid);

  /**
   * Removes the descriptor with |descriptorId| from the simulated central.
   *
   * @param descriptorId
   */
  void removeDescriptor(@ParamName("descriptorId") String descriptorId);

  /**
   * Simulates a GATT disconnection from the peripheral with |address|.
   *
   * @param address
   */
  void simulateGATTDisconnection(@ParamName("address") String address);

  /** Event for when a GATT operation of |type| to the peripheral with |address| happened. */
  @EventName("gattOperationReceived")
  EventListener onGattOperationReceived(EventHandler<GattOperationReceived> eventListener);

  /**
   * Event for when a characteristic operation of |type| to the characteristic respresented by
   * |characteristicId| happened. |data| and |writeType| is expected to exist when |type| is write.
   */
  @EventName("characteristicOperationReceived")
  EventListener onCharacteristicOperationReceived(
      EventHandler<CharacteristicOperationReceived> eventListener);

  /**
   * Event for when a descriptor operation of |type| to the descriptor respresented by
   * |descriptorId| happened. |data| is expected to exist when |type| is write.
   */
  @EventName("descriptorOperationReceived")
  EventListener onDescriptorOperationReceived(
      EventHandler<DescriptorOperationReceived> eventListener);
}
