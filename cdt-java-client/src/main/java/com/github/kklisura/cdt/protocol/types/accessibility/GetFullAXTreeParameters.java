package com.github.kklisura.cdt.protocol.types.accessibility;

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

/** Parameters for the getFullAXTree command. */
public class GetFullAXTreeParameters {

  @Optional
  @ParamName("depth")
  private Integer depth;

  @Optional
  @ParamName("frameId")
  private String frameId;

  /**
   * The maximum depth at which descendants of the root node should be retrieved. If omitted, the
   * full tree is returned.
   */
  public Integer getDepth() {
    return depth;
  }

  /**
   * The maximum depth at which descendants of the root node should be retrieved. If omitted, the
   * full tree is returned.
   */
  public GetFullAXTreeParameters setDepth(Integer depth) {
    this.depth = depth;
    return this;
  }

  /**
   * The frame for whose document the AX tree should be retrieved. If omitted, the root frame is
   * used.
   */
  public String getFrameId() {
    return frameId;
  }

  /**
   * The frame for whose document the AX tree should be retrieved. If omitted, the root frame is
   * used.
   */
  public GetFullAXTreeParameters setFrameId(String frameId) {
    this.frameId = frameId;
    return this;
  }
}
