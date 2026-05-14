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

import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import com.github.kklisura.cdt.protocol.support.annotations.ParamName;

/** Parameters for the queryObjects command. */
public class QueryObjectsParameters {

  @ParamName("prototypeObjectId")
  private String prototypeObjectId;

  @Optional
  @ParamName("objectGroup")
  private String objectGroup;

  /** Identifier of the prototype to return objects for. */
  public String getPrototypeObjectId() {
    return prototypeObjectId;
  }

  /** Identifier of the prototype to return objects for. */
  public QueryObjectsParameters setPrototypeObjectId(String prototypeObjectId) {
    this.prototypeObjectId = prototypeObjectId;
    return this;
  }

  /** Symbolic group name that can be used to release the results. */
  public String getObjectGroup() {
    return objectGroup;
  }

  /** Symbolic group name that can be used to release the results. */
  public QueryObjectsParameters setObjectGroup(String objectGroup) {
    this.objectGroup = objectGroup;
    return this;
  }
}
