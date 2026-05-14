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
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;

/** Parameters for the enable command. */
public class EnableParameters {

  @Experimental
  @Optional
  @ParamName("maxTotalBufferSize")
  private Integer maxTotalBufferSize;

  @Experimental
  @Optional
  @ParamName("maxResourceBufferSize")
  private Integer maxResourceBufferSize;

  @Optional
  @ParamName("maxPostDataSize")
  private Integer maxPostDataSize;

  @Experimental
  @Optional
  @ParamName("reportDirectSocketTraffic")
  private Boolean reportDirectSocketTraffic;

  @Experimental
  @Optional
  @ParamName("enableDurableMessages")
  private Boolean enableDurableMessages;

  /**
   * Buffer size in bytes to use when preserving network payloads (XHRs, etc). This is the maximum
   * number of bytes that will be collected by this DevTools session.
   */
  public Integer getMaxTotalBufferSize() {
    return maxTotalBufferSize;
  }

  /**
   * Buffer size in bytes to use when preserving network payloads (XHRs, etc). This is the maximum
   * number of bytes that will be collected by this DevTools session.
   */
  public EnableParameters setMaxTotalBufferSize(Integer maxTotalBufferSize) {
    this.maxTotalBufferSize = maxTotalBufferSize;
    return this;
  }

  /** Per-resource buffer size in bytes to use when preserving network payloads (XHRs, etc). */
  public Integer getMaxResourceBufferSize() {
    return maxResourceBufferSize;
  }

  /** Per-resource buffer size in bytes to use when preserving network payloads (XHRs, etc). */
  public EnableParameters setMaxResourceBufferSize(Integer maxResourceBufferSize) {
    this.maxResourceBufferSize = maxResourceBufferSize;
    return this;
  }

  /** Longest post body size (in bytes) that would be included in requestWillBeSent notification */
  public Integer getMaxPostDataSize() {
    return maxPostDataSize;
  }

  /** Longest post body size (in bytes) that would be included in requestWillBeSent notification */
  public EnableParameters setMaxPostDataSize(Integer maxPostDataSize) {
    this.maxPostDataSize = maxPostDataSize;
    return this;
  }

  /** Whether DirectSocket chunk send/receive events should be reported. */
  public Boolean getReportDirectSocketTraffic() {
    return reportDirectSocketTraffic;
  }

  /** Whether DirectSocket chunk send/receive events should be reported. */
  public EnableParameters setReportDirectSocketTraffic(Boolean reportDirectSocketTraffic) {
    this.reportDirectSocketTraffic = reportDirectSocketTraffic;
    return this;
  }

  /**
   * Enable storing response bodies outside of renderer, so that these survive a cross-process
   * navigation. Requires maxTotalBufferSize to be set. Currently defaults to false. This field is
   * being deprecated in favor of the dedicated configureDurableMessages command, due to the
   * possibility of deadlocks when awaiting Network.enable before issuing
   * Runtime.runIfWaitingForDebugger.
   */
  public Boolean getEnableDurableMessages() {
    return enableDurableMessages;
  }

  /**
   * Enable storing response bodies outside of renderer, so that these survive a cross-process
   * navigation. Requires maxTotalBufferSize to be set. Currently defaults to false. This field is
   * being deprecated in favor of the dedicated configureDurableMessages command, due to the
   * possibility of deadlocks when awaiting Network.enable before issuing
   * Runtime.runIfWaitingForDebugger.
   */
  public EnableParameters setEnableDurableMessages(Boolean enableDurableMessages) {
    this.enableDurableMessages = enableDurableMessages;
    return this;
  }
}
