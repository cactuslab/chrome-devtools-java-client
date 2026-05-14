package com.github.kklisura.cdt.protocol.types.audits;

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

/** Parameters for the getEncodedResponse command. */
public class GetEncodedResponseParameters {

  @ParamName("requestId")
  private String requestId;

  @ParamName("encoding")
  private GetEncodedResponseEncoding encoding;

  @Optional
  @ParamName("quality")
  private Double quality;

  @Optional
  @ParamName("sizeOnly")
  private Boolean sizeOnly;

  /** Identifier of the network request to get content for. */
  public String getRequestId() {
    return requestId;
  }

  /** Identifier of the network request to get content for. */
  public GetEncodedResponseParameters setRequestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

  /** The encoding to use. */
  public GetEncodedResponseEncoding getEncoding() {
    return encoding;
  }

  /** The encoding to use. */
  public GetEncodedResponseParameters setEncoding(GetEncodedResponseEncoding encoding) {
    this.encoding = encoding;
    return this;
  }

  /** The quality of the encoding (0-1). (defaults to 1) */
  public Double getQuality() {
    return quality;
  }

  /** The quality of the encoding (0-1). (defaults to 1) */
  public GetEncodedResponseParameters setQuality(Double quality) {
    this.quality = quality;
    return this;
  }

  /** Whether to only return the size information (defaults to false). */
  public Boolean getSizeOnly() {
    return sizeOnly;
  }

  /** Whether to only return the size information (defaults to false). */
  public GetEncodedResponseParameters setSizeOnly(Boolean sizeOnly) {
    this.sizeOnly = sizeOnly;
    return this;
  }
}
