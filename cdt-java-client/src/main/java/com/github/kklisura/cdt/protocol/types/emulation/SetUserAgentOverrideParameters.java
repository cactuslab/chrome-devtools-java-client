package com.github.kklisura.cdt.protocol.types.emulation;

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

/** Parameters for the setUserAgentOverride command. */
public class SetUserAgentOverrideParameters {

  @ParamName("userAgent")
  private String userAgent;

  @Optional
  @ParamName("acceptLanguage")
  private String acceptLanguage;

  @Optional
  @ParamName("platform")
  private String platform;

  @Experimental
  @Optional
  @ParamName("userAgentMetadata")
  private UserAgentMetadata userAgentMetadata;

  /** User agent to use. */
  public String getUserAgent() {
    return userAgent;
  }

  /** User agent to use. */
  public SetUserAgentOverrideParameters setUserAgent(String userAgent) {
    this.userAgent = userAgent;
    return this;
  }

  /** Browser language to emulate. */
  public String getAcceptLanguage() {
    return acceptLanguage;
  }

  /** Browser language to emulate. */
  public SetUserAgentOverrideParameters setAcceptLanguage(String acceptLanguage) {
    this.acceptLanguage = acceptLanguage;
    return this;
  }

  /** The platform navigator.platform should return. */
  public String getPlatform() {
    return platform;
  }

  /** The platform navigator.platform should return. */
  public SetUserAgentOverrideParameters setPlatform(String platform) {
    this.platform = platform;
    return this;
  }

  /** To be sent in Sec-CH-UA-* headers and returned in navigator.userAgentData */
  public UserAgentMetadata getUserAgentMetadata() {
    return userAgentMetadata;
  }

  /** To be sent in Sec-CH-UA-* headers and returned in navigator.userAgentData */
  public SetUserAgentOverrideParameters setUserAgentMetadata(UserAgentMetadata userAgentMetadata) {
    this.userAgentMetadata = userAgentMetadata;
    return this;
  }
}
