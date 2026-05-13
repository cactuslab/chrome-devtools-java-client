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

/** A device bound session's cookie craving. */
@Experimental
public class DeviceBoundSessionCookieCraving {

  private String name;

  private String domain;

  private String path;

  private Boolean secure;

  private Boolean httpOnly;

  @Optional private CookieSameSite sameSite;

  /** The name of the craving. */
  public String getName() {
    return name;
  }

  /** The name of the craving. */
  public void setName(String name) {
    this.name = name;
  }

  /** The domain of the craving. */
  public String getDomain() {
    return domain;
  }

  /** The domain of the craving. */
  public void setDomain(String domain) {
    this.domain = domain;
  }

  /** The path of the craving. */
  public String getPath() {
    return path;
  }

  /** The path of the craving. */
  public void setPath(String path) {
    this.path = path;
  }

  /** The `Secure` attribute of the craving attributes. */
  public Boolean getSecure() {
    return secure;
  }

  /** The `Secure` attribute of the craving attributes. */
  public void setSecure(Boolean secure) {
    this.secure = secure;
  }

  /** The `HttpOnly` attribute of the craving attributes. */
  public Boolean getHttpOnly() {
    return httpOnly;
  }

  /** The `HttpOnly` attribute of the craving attributes. */
  public void setHttpOnly(Boolean httpOnly) {
    this.httpOnly = httpOnly;
  }

  /** The `SameSite` attribute of the craving attributes. */
  public CookieSameSite getSameSite() {
    return sameSite;
  }

  /** The `SameSite` attribute of the craving attributes. */
  public void setSameSite(CookieSameSite sameSite) {
    this.sameSite = sameSite;
  }
}
