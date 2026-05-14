package com.github.kklisura.cdt.protocol.types.runtime;

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

/** Parameters for the getProperties command. */
public class GetPropertiesParameters {

  @ParamName("objectId")
  private String objectId;

  @Optional
  @ParamName("ownProperties")
  private Boolean ownProperties;

  @Experimental
  @Optional
  @ParamName("accessorPropertiesOnly")
  private Boolean accessorPropertiesOnly;

  @Experimental
  @Optional
  @ParamName("generatePreview")
  private Boolean generatePreview;

  @Experimental
  @Optional
  @ParamName("nonIndexedPropertiesOnly")
  private Boolean nonIndexedPropertiesOnly;

  /** Identifier of the object to return properties for. */
  public String getObjectId() {
    return objectId;
  }

  /** Identifier of the object to return properties for. */
  public GetPropertiesParameters setObjectId(String objectId) {
    this.objectId = objectId;
    return this;
  }

  /**
   * If true, returns properties belonging only to the element itself, not to its prototype chain.
   */
  public Boolean getOwnProperties() {
    return ownProperties;
  }

  /**
   * If true, returns properties belonging only to the element itself, not to its prototype chain.
   */
  public GetPropertiesParameters setOwnProperties(Boolean ownProperties) {
    this.ownProperties = ownProperties;
    return this;
  }

  /**
   * If true, returns accessor properties (with getter/setter) only; internal properties are not
   * returned either.
   */
  public Boolean getAccessorPropertiesOnly() {
    return accessorPropertiesOnly;
  }

  /**
   * If true, returns accessor properties (with getter/setter) only; internal properties are not
   * returned either.
   */
  public GetPropertiesParameters setAccessorPropertiesOnly(Boolean accessorPropertiesOnly) {
    this.accessorPropertiesOnly = accessorPropertiesOnly;
    return this;
  }

  /** Whether preview should be generated for the results. */
  public Boolean getGeneratePreview() {
    return generatePreview;
  }

  /** Whether preview should be generated for the results. */
  public GetPropertiesParameters setGeneratePreview(Boolean generatePreview) {
    this.generatePreview = generatePreview;
    return this;
  }

  /** If true, returns non-indexed properties only. */
  public Boolean getNonIndexedPropertiesOnly() {
    return nonIndexedPropertiesOnly;
  }

  /** If true, returns non-indexed properties only. */
  public GetPropertiesParameters setNonIndexedPropertiesOnly(Boolean nonIndexedPropertiesOnly) {
    this.nonIndexedPropertiesOnly = nonIndexedPropertiesOnly;
    return this;
  }
}
