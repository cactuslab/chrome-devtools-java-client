package com.github.kklisura.cdt.protocol.types.dom;

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

/** Parameters for the setAttributesAsText command. */
public class SetAttributesAsTextParameters {

  @ParamName("nodeId")
  private Integer nodeId;

  @ParamName("text")
  private String text;

  @Optional
  @ParamName("name")
  private String name;

  /** Id of the element to set attributes for. */
  public Integer getNodeId() {
    return nodeId;
  }

  /** Id of the element to set attributes for. */
  public SetAttributesAsTextParameters setNodeId(Integer nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /** Text with a number of attributes. Will parse this text using HTML parser. */
  public String getText() {
    return text;
  }

  /** Text with a number of attributes. Will parse this text using HTML parser. */
  public SetAttributesAsTextParameters setText(String text) {
    this.text = text;
    return this;
  }

  /**
   * Attribute name to replace with new attributes derived from text in case text parsed
   * successfully.
   */
  public String getName() {
    return name;
  }

  /**
   * Attribute name to replace with new attributes derived from text in case text parsed
   * successfully.
   */
  public SetAttributesAsTextParameters setName(String name) {
    this.name = name;
    return this;
  }
}
