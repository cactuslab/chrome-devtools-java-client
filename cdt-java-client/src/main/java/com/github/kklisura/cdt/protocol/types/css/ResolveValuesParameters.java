package com.github.kklisura.cdt.protocol.types.css;

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
import com.github.kklisura.cdt.protocol.types.dom.PseudoType;
import java.util.List;

/** Parameters for the resolveValues command. */
public class ResolveValuesParameters {

  @ParamName("values")
  private List<String> values;

  @ParamName("nodeId")
  private Integer nodeId;

  @Optional
  @ParamName("propertyName")
  private String propertyName;

  @Optional
  @ParamName("pseudoType")
  private PseudoType pseudoType;

  @Optional
  @ParamName("pseudoIdentifier")
  private String pseudoIdentifier;

  /** Cascade-dependent keywords (revert/revert-layer) do not work. */
  public List<String> getValues() {
    return values;
  }

  /** Cascade-dependent keywords (revert/revert-layer) do not work. */
  public ResolveValuesParameters setValues(List<String> values) {
    this.values = values;
    return this;
  }

  /** Id of the node in whose context the expression is evaluated */
  public Integer getNodeId() {
    return nodeId;
  }

  /** Id of the node in whose context the expression is evaluated */
  public ResolveValuesParameters setNodeId(Integer nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /** Only longhands and custom property names are accepted. */
  public String getPropertyName() {
    return propertyName;
  }

  /** Only longhands and custom property names are accepted. */
  public ResolveValuesParameters setPropertyName(String propertyName) {
    this.propertyName = propertyName;
    return this;
  }

  /**
   * Pseudo element type, only works for pseudo elements that generate elements in the tree, such as
   * ::before and ::after.
   */
  public PseudoType getPseudoType() {
    return pseudoType;
  }

  /**
   * Pseudo element type, only works for pseudo elements that generate elements in the tree, such as
   * ::before and ::after.
   */
  public ResolveValuesParameters setPseudoType(PseudoType pseudoType) {
    this.pseudoType = pseudoType;
    return this;
  }

  /** Pseudo element custom ident. */
  public String getPseudoIdentifier() {
    return pseudoIdentifier;
  }

  /** Pseudo element custom ident. */
  public ResolveValuesParameters setPseudoIdentifier(String pseudoIdentifier) {
    this.pseudoIdentifier = pseudoIdentifier;
    return this;
  }
}
