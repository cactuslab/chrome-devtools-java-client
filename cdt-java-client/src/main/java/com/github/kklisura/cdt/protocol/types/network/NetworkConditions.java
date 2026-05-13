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

import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;

@Experimental
public class NetworkConditions {

  private String urlPattern;

  private Double latency;

  private Double downloadThroughput;

  private Double uploadThroughput;

  @Optional private ConnectionType connectionType;

  @Optional private Double packetLoss;

  @Optional private Integer packetQueueLength;

  @Optional private Boolean packetReordering;

  @Optional private Boolean offline;

  /**
   * Only matching requests will be affected by these conditions. Patterns use the URLPattern
   * constructor string syntax (https://urlpattern.spec.whatwg.org/) and must be absolute. If the
   * pattern is empty, all requests are matched (including p2p connections).
   */
  public String getUrlPattern() {
    return urlPattern;
  }

  /**
   * Only matching requests will be affected by these conditions. Patterns use the URLPattern
   * constructor string syntax (https://urlpattern.spec.whatwg.org/) and must be absolute. If the
   * pattern is empty, all requests are matched (including p2p connections).
   */
  public void setUrlPattern(String urlPattern) {
    this.urlPattern = urlPattern;
  }

  /** Minimum latency from request sent to response headers received (ms). */
  public Double getLatency() {
    return latency;
  }

  /** Minimum latency from request sent to response headers received (ms). */
  public void setLatency(Double latency) {
    this.latency = latency;
  }

  /** Maximal aggregated download throughput (bytes/sec). -1 disables download throttling. */
  public Double getDownloadThroughput() {
    return downloadThroughput;
  }

  /** Maximal aggregated download throughput (bytes/sec). -1 disables download throttling. */
  public void setDownloadThroughput(Double downloadThroughput) {
    this.downloadThroughput = downloadThroughput;
  }

  /** Maximal aggregated upload throughput (bytes/sec). -1 disables upload throttling. */
  public Double getUploadThroughput() {
    return uploadThroughput;
  }

  /** Maximal aggregated upload throughput (bytes/sec). -1 disables upload throttling. */
  public void setUploadThroughput(Double uploadThroughput) {
    this.uploadThroughput = uploadThroughput;
  }

  /** Connection type if known. */
  public ConnectionType getConnectionType() {
    return connectionType;
  }

  /** Connection type if known. */
  public void setConnectionType(ConnectionType connectionType) {
    this.connectionType = connectionType;
  }

  /**
   * WebRTC packet loss (percent, 0-100). 0 disables packet loss emulation, 100 drops all the
   * packets.
   */
  public Double getPacketLoss() {
    return packetLoss;
  }

  /**
   * WebRTC packet loss (percent, 0-100). 0 disables packet loss emulation, 100 drops all the
   * packets.
   */
  public void setPacketLoss(Double packetLoss) {
    this.packetLoss = packetLoss;
  }

  /** WebRTC packet queue length (packet). 0 removes any queue length limitations. */
  public Integer getPacketQueueLength() {
    return packetQueueLength;
  }

  /** WebRTC packet queue length (packet). 0 removes any queue length limitations. */
  public void setPacketQueueLength(Integer packetQueueLength) {
    this.packetQueueLength = packetQueueLength;
  }

  /** WebRTC packetReordering feature. */
  public Boolean getPacketReordering() {
    return packetReordering;
  }

  /** WebRTC packetReordering feature. */
  public void setPacketReordering(Boolean packetReordering) {
    this.packetReordering = packetReordering;
  }

  /** True to emulate internet disconnection. */
  public Boolean getOffline() {
    return offline;
  }

  /** True to emulate internet disconnection. */
  public void setOffline(Boolean offline) {
    this.offline = offline;
  }
}
