package com.github.kklisura.cdt.protocol.types.heapprofiler;

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

/** Parameters for the getObjectByHeapObjectId command. */
public class GetObjectByHeapObjectIdParameters {

  @ParamName("objectId")
  private String objectId;

  @Optional
  @ParamName("objectGroup")
  private String objectGroup;

  public String getObjectId() {
    return objectId;
  }

  public GetObjectByHeapObjectIdParameters setObjectId(String objectId) {
    this.objectId = objectId;
    return this;
  }

  /** Symbolic group name that can be used to release multiple objects. */
  public String getObjectGroup() {
    return objectGroup;
  }

  /** Symbolic group name that can be used to release multiple objects. */
  public GetObjectByHeapObjectIdParameters setObjectGroup(String objectGroup) {
    this.objectGroup = objectGroup;
    return this;
  }
}
