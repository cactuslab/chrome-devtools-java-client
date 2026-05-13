package com.github.kklisura.cdt.protocol.types.storage;

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
import java.util.List;

/**
 * Bundles the parameters for shared storage access events whose presence/absence can vary according
 * to SharedStorageAccessType.
 */
public class SharedStorageAccessParams {

  @Optional private String scriptSourceUrl;

  @Optional private String dataOrigin;

  @Optional private String operationName;

  @Optional private String operationId;

  @Optional private Boolean keepAlive;

  @Optional private SharedStoragePrivateAggregationConfig privateAggregationConfig;

  @Optional private String serializedData;

  @Optional private List<SharedStorageUrlWithMetadata> urlsWithMetadata;

  @Optional private String urnUuid;

  @Optional private String key;

  @Optional private String value;

  @Optional private Boolean ignoreIfPresent;

  @Optional private Integer workletOrdinal;

  @Optional private String workletTargetId;

  @Optional private String withLock;

  @Optional private String batchUpdateId;

  @Optional private Integer batchSize;

  /**
   * Spec of the module script URL. Present only for SharedStorageAccessMethods: addModule and
   * createWorklet.
   */
  public String getScriptSourceUrl() {
    return scriptSourceUrl;
  }

  /**
   * Spec of the module script URL. Present only for SharedStorageAccessMethods: addModule and
   * createWorklet.
   */
  public void setScriptSourceUrl(String scriptSourceUrl) {
    this.scriptSourceUrl = scriptSourceUrl;
  }

  /**
   * String denoting "context-origin", "script-origin", or a custom origin to be used as the
   * worklet's data origin. Present only for SharedStorageAccessMethod: createWorklet.
   */
  public String getDataOrigin() {
    return dataOrigin;
  }

  /**
   * String denoting "context-origin", "script-origin", or a custom origin to be used as the
   * worklet's data origin. Present only for SharedStorageAccessMethod: createWorklet.
   */
  public void setDataOrigin(String dataOrigin) {
    this.dataOrigin = dataOrigin;
  }

  /**
   * Name of the registered operation to be run. Present only for SharedStorageAccessMethods: run
   * and selectURL.
   */
  public String getOperationName() {
    return operationName;
  }

  /**
   * Name of the registered operation to be run. Present only for SharedStorageAccessMethods: run
   * and selectURL.
   */
  public void setOperationName(String operationName) {
    this.operationName = operationName;
  }

  /** ID of the operation call. Present only for SharedStorageAccessMethods: run and selectURL. */
  public String getOperationId() {
    return operationId;
  }

  /** ID of the operation call. Present only for SharedStorageAccessMethods: run and selectURL. */
  public void setOperationId(String operationId) {
    this.operationId = operationId;
  }

  /**
   * Whether or not to keep the worket alive for future run or selectURL calls. Present only for
   * SharedStorageAccessMethods: run and selectURL.
   */
  public Boolean getKeepAlive() {
    return keepAlive;
  }

  /**
   * Whether or not to keep the worket alive for future run or selectURL calls. Present only for
   * SharedStorageAccessMethods: run and selectURL.
   */
  public void setKeepAlive(Boolean keepAlive) {
    this.keepAlive = keepAlive;
  }

  /**
   * Configures the private aggregation options. Present only for SharedStorageAccessMethods: run
   * and selectURL.
   */
  public SharedStoragePrivateAggregationConfig getPrivateAggregationConfig() {
    return privateAggregationConfig;
  }

  /**
   * Configures the private aggregation options. Present only for SharedStorageAccessMethods: run
   * and selectURL.
   */
  public void setPrivateAggregationConfig(
      SharedStoragePrivateAggregationConfig privateAggregationConfig) {
    this.privateAggregationConfig = privateAggregationConfig;
  }

  /**
   * The operation's serialized data in bytes (converted to a string). Present only for
   * SharedStorageAccessMethods: run and selectURL. TODO(crbug.com/401011862): Consider updating
   * this parameter to binary.
   */
  public String getSerializedData() {
    return serializedData;
  }

  /**
   * The operation's serialized data in bytes (converted to a string). Present only for
   * SharedStorageAccessMethods: run and selectURL. TODO(crbug.com/401011862): Consider updating
   * this parameter to binary.
   */
  public void setSerializedData(String serializedData) {
    this.serializedData = serializedData;
  }

  /**
   * Array of candidate URLs' specs, along with any associated metadata. Present only for
   * SharedStorageAccessMethod: selectURL.
   */
  public List<SharedStorageUrlWithMetadata> getUrlsWithMetadata() {
    return urlsWithMetadata;
  }

  /**
   * Array of candidate URLs' specs, along with any associated metadata. Present only for
   * SharedStorageAccessMethod: selectURL.
   */
  public void setUrlsWithMetadata(List<SharedStorageUrlWithMetadata> urlsWithMetadata) {
    this.urlsWithMetadata = urlsWithMetadata;
  }

  /**
   * Spec of the URN:UUID generated for a selectURL call. Present only for
   * SharedStorageAccessMethod: selectURL.
   */
  public String getUrnUuid() {
    return urnUuid;
  }

  /**
   * Spec of the URN:UUID generated for a selectURL call. Present only for
   * SharedStorageAccessMethod: selectURL.
   */
  public void setUrnUuid(String urnUuid) {
    this.urnUuid = urnUuid;
  }

  /**
   * Key for a specific entry in an origin's shared storage. Present only for
   * SharedStorageAccessMethods: set, append, delete, and get.
   */
  public String getKey() {
    return key;
  }

  /**
   * Key for a specific entry in an origin's shared storage. Present only for
   * SharedStorageAccessMethods: set, append, delete, and get.
   */
  public void setKey(String key) {
    this.key = key;
  }

  /**
   * Value for a specific entry in an origin's shared storage. Present only for
   * SharedStorageAccessMethods: set and append.
   */
  public String getValue() {
    return value;
  }

  /**
   * Value for a specific entry in an origin's shared storage. Present only for
   * SharedStorageAccessMethods: set and append.
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * Whether or not to set an entry for a key if that key is already present. Present only for
   * SharedStorageAccessMethod: set.
   */
  public Boolean getIgnoreIfPresent() {
    return ignoreIfPresent;
  }

  /**
   * Whether or not to set an entry for a key if that key is already present. Present only for
   * SharedStorageAccessMethod: set.
   */
  public void setIgnoreIfPresent(Boolean ignoreIfPresent) {
    this.ignoreIfPresent = ignoreIfPresent;
  }

  /**
   * A number denoting the (0-based) order of the worklet's creation relative to all other shared
   * storage worklets created by documents using the current storage partition. Present only for
   * SharedStorageAccessMethods: addModule, createWorklet.
   */
  public Integer getWorkletOrdinal() {
    return workletOrdinal;
  }

  /**
   * A number denoting the (0-based) order of the worklet's creation relative to all other shared
   * storage worklets created by documents using the current storage partition. Present only for
   * SharedStorageAccessMethods: addModule, createWorklet.
   */
  public void setWorkletOrdinal(Integer workletOrdinal) {
    this.workletOrdinal = workletOrdinal;
  }

  /**
   * Hex representation of the DevTools token used as the TargetID for the associated shared storage
   * worklet. Present only for SharedStorageAccessMethods: addModule, createWorklet, run, selectURL,
   * and any other SharedStorageAccessMethod when the SharedStorageAccessScope is
   * sharedStorageWorklet.
   */
  public String getWorkletTargetId() {
    return workletTargetId;
  }

  /**
   * Hex representation of the DevTools token used as the TargetID for the associated shared storage
   * worklet. Present only for SharedStorageAccessMethods: addModule, createWorklet, run, selectURL,
   * and any other SharedStorageAccessMethod when the SharedStorageAccessScope is
   * sharedStorageWorklet.
   */
  public void setWorkletTargetId(String workletTargetId) {
    this.workletTargetId = workletTargetId;
  }

  /**
   * Name of the lock to be acquired, if present. Optionally present only for
   * SharedStorageAccessMethods: batchUpdate, set, append, delete, and clear.
   */
  public String getWithLock() {
    return withLock;
  }

  /**
   * Name of the lock to be acquired, if present. Optionally present only for
   * SharedStorageAccessMethods: batchUpdate, set, append, delete, and clear.
   */
  public void setWithLock(String withLock) {
    this.withLock = withLock;
  }

  /**
   * If the method has been called as part of a batchUpdate, then this number identifies the batch
   * to which it belongs. Optionally present only for SharedStorageAccessMethods: batchUpdate
   * (required), set, append, delete, and clear.
   */
  public String getBatchUpdateId() {
    return batchUpdateId;
  }

  /**
   * If the method has been called as part of a batchUpdate, then this number identifies the batch
   * to which it belongs. Optionally present only for SharedStorageAccessMethods: batchUpdate
   * (required), set, append, delete, and clear.
   */
  public void setBatchUpdateId(String batchUpdateId) {
    this.batchUpdateId = batchUpdateId;
  }

  /**
   * Number of modifier methods sent in batch. Present only for SharedStorageAccessMethod:
   * batchUpdate.
   */
  public Integer getBatchSize() {
    return batchSize;
  }

  /**
   * Number of modifier methods sent in batch. Present only for SharedStorageAccessMethod:
   * batchUpdate.
   */
  public void setBatchSize(Integer batchSize) {
    this.batchSize = batchSize;
  }
}
