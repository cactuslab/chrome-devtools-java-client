package com.github.kklisura.cdt.protocol.events.storage;

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

import com.github.kklisura.cdt.protocol.types.storage.SharedStorageAccessMethod;

/**
 * A shared storage run or selectURL operation finished its execution. The following parameters are
 * included in all events.
 */
public class SharedStorageWorkletOperationExecutionFinished {

  private Double finishedTime;

  private Integer executionTime;

  private SharedStorageAccessMethod method;

  private String operationId;

  private String workletTargetId;

  private String mainFrameId;

  private String ownerOrigin;

  /** Time that the operation finished. */
  public Double getFinishedTime() {
    return finishedTime;
  }

  /** Time that the operation finished. */
  public void setFinishedTime(Double finishedTime) {
    this.finishedTime = finishedTime;
  }

  /**
   * Time, in microseconds, from start of shared storage JS API call until end of operation
   * execution in the worklet.
   */
  public Integer getExecutionTime() {
    return executionTime;
  }

  /**
   * Time, in microseconds, from start of shared storage JS API call until end of operation
   * execution in the worklet.
   */
  public void setExecutionTime(Integer executionTime) {
    this.executionTime = executionTime;
  }

  /** Enum value indicating the Shared Storage API method invoked. */
  public SharedStorageAccessMethod getMethod() {
    return method;
  }

  /** Enum value indicating the Shared Storage API method invoked. */
  public void setMethod(SharedStorageAccessMethod method) {
    this.method = method;
  }

  /** ID of the operation call. */
  public String getOperationId() {
    return operationId;
  }

  /** ID of the operation call. */
  public void setOperationId(String operationId) {
    this.operationId = operationId;
  }

  /**
   * Hex representation of the DevTools token used as the TargetID for the associated shared storage
   * worklet.
   */
  public String getWorkletTargetId() {
    return workletTargetId;
  }

  /**
   * Hex representation of the DevTools token used as the TargetID for the associated shared storage
   * worklet.
   */
  public void setWorkletTargetId(String workletTargetId) {
    this.workletTargetId = workletTargetId;
  }

  /** DevTools Frame Token for the primary frame tree's root. */
  public String getMainFrameId() {
    return mainFrameId;
  }

  /** DevTools Frame Token for the primary frame tree's root. */
  public void setMainFrameId(String mainFrameId) {
    this.mainFrameId = mainFrameId;
  }

  /** Serialization of the origin owning the Shared Storage data. */
  public String getOwnerOrigin() {
    return ownerOrigin;
  }

  /** Serialization of the origin owning the Shared Storage data. */
  public void setOwnerOrigin(String ownerOrigin) {
    this.ownerOrigin = ownerOrigin;
  }
}
