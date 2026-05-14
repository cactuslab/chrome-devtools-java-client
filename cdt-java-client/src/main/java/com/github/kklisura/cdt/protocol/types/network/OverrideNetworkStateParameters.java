package com.github.kklisura.cdt.protocol.types.network;

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

/** Parameters for the overrideNetworkState command. */
public class OverrideNetworkStateParameters {

  @ParamName("offline")
  private Boolean offline;

  @ParamName("latency")
  private Double latency;

  @ParamName("downloadThroughput")
  private Double downloadThroughput;

  @ParamName("uploadThroughput")
  private Double uploadThroughput;

  @Optional
  @ParamName("connectionType")
  private ConnectionType connectionType;

  /** True to emulate internet disconnection. */
  public Boolean getOffline() {
    return offline;
  }

  /** True to emulate internet disconnection. */
  public OverrideNetworkStateParameters setOffline(Boolean offline) {
    this.offline = offline;
    return this;
  }

  /** Minimum latency from request sent to response headers received (ms). */
  public Double getLatency() {
    return latency;
  }

  /** Minimum latency from request sent to response headers received (ms). */
  public OverrideNetworkStateParameters setLatency(Double latency) {
    this.latency = latency;
    return this;
  }

  /** Maximal aggregated download throughput (bytes/sec). -1 disables download throttling. */
  public Double getDownloadThroughput() {
    return downloadThroughput;
  }

  /** Maximal aggregated download throughput (bytes/sec). -1 disables download throttling. */
  public OverrideNetworkStateParameters setDownloadThroughput(Double downloadThroughput) {
    this.downloadThroughput = downloadThroughput;
    return this;
  }

  /** Maximal aggregated upload throughput (bytes/sec). -1 disables upload throttling. */
  public Double getUploadThroughput() {
    return uploadThroughput;
  }

  /** Maximal aggregated upload throughput (bytes/sec). -1 disables upload throttling. */
  public OverrideNetworkStateParameters setUploadThroughput(Double uploadThroughput) {
    this.uploadThroughput = uploadThroughput;
    return this;
  }

  /** Connection type if known. */
  public ConnectionType getConnectionType() {
    return connectionType;
  }

  /** Connection type if known. */
  public OverrideNetworkStateParameters setConnectionType(ConnectionType connectionType) {
    this.connectionType = connectionType;
    return this;
  }
}
