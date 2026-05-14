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

/** Parameters for the setCookie command. */
public class SetCookieParameters {

  @ParamName("name")
  private String name;

  @ParamName("value")
  private String value;

  @Optional
  @ParamName("url")
  private String url;

  @Optional
  @ParamName("domain")
  private String domain;

  @Optional
  @ParamName("path")
  private String path;

  @Optional
  @ParamName("secure")
  private Boolean secure;

  @Optional
  @ParamName("httpOnly")
  private Boolean httpOnly;

  @Optional
  @ParamName("sameSite")
  private CookieSameSite sameSite;

  @Optional
  @ParamName("expires")
  private Double expires;

  @Experimental
  @Optional
  @ParamName("priority")
  private CookiePriority priority;

  @Experimental
  @Optional
  @ParamName("sourceScheme")
  private CookieSourceScheme sourceScheme;

  @Experimental
  @Optional
  @ParamName("sourcePort")
  private Integer sourcePort;

  @Experimental
  @Optional
  @ParamName("partitionKey")
  private CookiePartitionKey partitionKey;

  /** Cookie name. */
  public String getName() {
    return name;
  }

  /** Cookie name. */
  public SetCookieParameters setName(String name) {
    this.name = name;
    return this;
  }

  /** Cookie value. */
  public String getValue() {
    return value;
  }

  /** Cookie value. */
  public SetCookieParameters setValue(String value) {
    this.value = value;
    return this;
  }

  /**
   * The request-URI to associate with the setting of the cookie. This value can affect the default
   * domain, path, source port, and source scheme values of the created cookie.
   */
  public String getUrl() {
    return url;
  }

  /**
   * The request-URI to associate with the setting of the cookie. This value can affect the default
   * domain, path, source port, and source scheme values of the created cookie.
   */
  public SetCookieParameters setUrl(String url) {
    this.url = url;
    return this;
  }

  /** Cookie domain. */
  public String getDomain() {
    return domain;
  }

  /** Cookie domain. */
  public SetCookieParameters setDomain(String domain) {
    this.domain = domain;
    return this;
  }

  /** Cookie path. */
  public String getPath() {
    return path;
  }

  /** Cookie path. */
  public SetCookieParameters setPath(String path) {
    this.path = path;
    return this;
  }

  /** True if cookie is secure. */
  public Boolean getSecure() {
    return secure;
  }

  /** True if cookie is secure. */
  public SetCookieParameters setSecure(Boolean secure) {
    this.secure = secure;
    return this;
  }

  /** True if cookie is http-only. */
  public Boolean getHttpOnly() {
    return httpOnly;
  }

  /** True if cookie is http-only. */
  public SetCookieParameters setHttpOnly(Boolean httpOnly) {
    this.httpOnly = httpOnly;
    return this;
  }

  /** Cookie SameSite type. */
  public CookieSameSite getSameSite() {
    return sameSite;
  }

  /** Cookie SameSite type. */
  public SetCookieParameters setSameSite(CookieSameSite sameSite) {
    this.sameSite = sameSite;
    return this;
  }

  /** Cookie expiration date, session cookie if not set */
  public Double getExpires() {
    return expires;
  }

  /** Cookie expiration date, session cookie if not set */
  public SetCookieParameters setExpires(Double expires) {
    this.expires = expires;
    return this;
  }

  /** Cookie Priority type. */
  public CookiePriority getPriority() {
    return priority;
  }

  /** Cookie Priority type. */
  public SetCookieParameters setPriority(CookiePriority priority) {
    this.priority = priority;
    return this;
  }

  /** Cookie source scheme type. */
  public CookieSourceScheme getSourceScheme() {
    return sourceScheme;
  }

  /** Cookie source scheme type. */
  public SetCookieParameters setSourceScheme(CookieSourceScheme sourceScheme) {
    this.sourceScheme = sourceScheme;
    return this;
  }

  /**
   * Cookie source port. Valid values are {-1, [1, 65535]}, -1 indicates an unspecified port. An
   * unspecified port value allows protocol clients to emulate legacy cookie scope for the port.
   * This is a temporary ability and it will be removed in the future.
   */
  public Integer getSourcePort() {
    return sourcePort;
  }

  /**
   * Cookie source port. Valid values are {-1, [1, 65535]}, -1 indicates an unspecified port. An
   * unspecified port value allows protocol clients to emulate legacy cookie scope for the port.
   * This is a temporary ability and it will be removed in the future.
   */
  public SetCookieParameters setSourcePort(Integer sourcePort) {
    this.sourcePort = sourcePort;
    return this;
  }

  /** Cookie partition key. If not set, the cookie will be set as not partitioned. */
  public CookiePartitionKey getPartitionKey() {
    return partitionKey;
  }

  /** Cookie partition key. If not set, the cookie will be set as not partitioned. */
  public SetCookieParameters setPartitionKey(CookiePartitionKey partitionKey) {
    this.partitionKey = partitionKey;
    return this;
  }
}
