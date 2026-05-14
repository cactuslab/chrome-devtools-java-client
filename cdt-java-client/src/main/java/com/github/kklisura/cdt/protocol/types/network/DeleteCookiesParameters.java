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

/** Parameters for the deleteCookies command. */
public class DeleteCookiesParameters {

  @ParamName("name")
  private String name;

  @Optional
  @ParamName("url")
  private String url;

  @Optional
  @ParamName("domain")
  private String domain;

  @Optional
  @ParamName("path")
  private String path;

  @Experimental
  @Optional
  @ParamName("partitionKey")
  private CookiePartitionKey partitionKey;

  /** Name of the cookies to remove. */
  public String getName() {
    return name;
  }

  /** Name of the cookies to remove. */
  public DeleteCookiesParameters setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * If specified, deletes all the cookies with the given name where domain and path match provided
   * URL.
   */
  public String getUrl() {
    return url;
  }

  /**
   * If specified, deletes all the cookies with the given name where domain and path match provided
   * URL.
   */
  public DeleteCookiesParameters setUrl(String url) {
    this.url = url;
    return this;
  }

  /** If specified, deletes only cookies with the exact domain. */
  public String getDomain() {
    return domain;
  }

  /** If specified, deletes only cookies with the exact domain. */
  public DeleteCookiesParameters setDomain(String domain) {
    this.domain = domain;
    return this;
  }

  /** If specified, deletes only cookies with the exact path. */
  public String getPath() {
    return path;
  }

  /** If specified, deletes only cookies with the exact path. */
  public DeleteCookiesParameters setPath(String path) {
    this.path = path;
    return this;
  }

  /**
   * If specified, deletes only cookies with the the given name and partitionKey where all partition
   * key attributes match the cookie partition key attribute.
   */
  public CookiePartitionKey getPartitionKey() {
    return partitionKey;
  }

  /**
   * If specified, deletes only cookies with the the given name and partitionKey where all partition
   * key attributes match the cookie partition key attribute.
   */
  public DeleteCookiesParameters setPartitionKey(CookiePartitionKey partitionKey) {
    this.partitionKey = partitionKey;
    return this;
  }
}
