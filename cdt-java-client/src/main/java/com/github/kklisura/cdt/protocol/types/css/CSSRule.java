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

import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;
import java.util.List;

/** CSS rule representation. */
public class CSSRule {

  @Optional private String styleSheetId;

  private SelectorList selectorList;

  @Experimental @Optional private List<String> nestingSelectors;

  private StyleSheetOrigin origin;

  private CSSStyle style;

  @Experimental @Optional private Integer originTreeScopeNodeId;

  @Optional private List<CSSMedia> media;

  @Experimental @Optional private List<CSSContainerQuery> containerQueries;

  @Experimental @Optional private List<CSSSupports> supports;

  @Experimental @Optional private List<CSSLayer> layers;

  @Experimental @Optional private List<CSSScope> scopes;

  @Experimental @Optional private List<CSSRuleType> ruleTypes;

  @Experimental @Optional private List<CSSStartingStyle> startingStyles;

  @Experimental @Optional private List<CSSNavigation> navigations;

  /**
   * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet
   * rules) this rule came from.
   */
  public String getStyleSheetId() {
    return styleSheetId;
  }

  /**
   * The css style sheet identifier (absent for user agent stylesheet and user-specified stylesheet
   * rules) this rule came from.
   */
  public void setStyleSheetId(String styleSheetId) {
    this.styleSheetId = styleSheetId;
  }

  /** Rule selector data. */
  public SelectorList getSelectorList() {
    return selectorList;
  }

  /** Rule selector data. */
  public void setSelectorList(SelectorList selectorList) {
    this.selectorList = selectorList;
  }

  /** Array of selectors from ancestor style rules, sorted by distance from the current rule. */
  public List<String> getNestingSelectors() {
    return nestingSelectors;
  }

  /** Array of selectors from ancestor style rules, sorted by distance from the current rule. */
  public void setNestingSelectors(List<String> nestingSelectors) {
    this.nestingSelectors = nestingSelectors;
  }

  /** Parent stylesheet's origin. */
  public StyleSheetOrigin getOrigin() {
    return origin;
  }

  /** Parent stylesheet's origin. */
  public void setOrigin(StyleSheetOrigin origin) {
    this.origin = origin;
  }

  /** Associated style declaration. */
  public CSSStyle getStyle() {
    return style;
  }

  /** Associated style declaration. */
  public void setStyle(CSSStyle style) {
    this.style = style;
  }

  /** The BackendNodeId of the DOM node that constitutes the origin tree scope of this rule. */
  public Integer getOriginTreeScopeNodeId() {
    return originTreeScopeNodeId;
  }

  /** The BackendNodeId of the DOM node that constitutes the origin tree scope of this rule. */
  public void setOriginTreeScopeNodeId(Integer originTreeScopeNodeId) {
    this.originTreeScopeNodeId = originTreeScopeNodeId;
  }

  /**
   * Media list array (for rules involving media queries). The array enumerates media queries
   * starting with the innermost one, going outwards.
   */
  public List<CSSMedia> getMedia() {
    return media;
  }

  /**
   * Media list array (for rules involving media queries). The array enumerates media queries
   * starting with the innermost one, going outwards.
   */
  public void setMedia(List<CSSMedia> media) {
    this.media = media;
  }

  /**
   * Container query list array (for rules involving container queries). The array enumerates
   * container queries starting with the innermost one, going outwards.
   */
  public List<CSSContainerQuery> getContainerQueries() {
    return containerQueries;
  }

  /**
   * Container query list array (for rules involving container queries). The array enumerates
   * container queries starting with the innermost one, going outwards.
   */
  public void setContainerQueries(List<CSSContainerQuery> containerQueries) {
    this.containerQueries = containerQueries;
  }

  /**
   * &#64;supports CSS at-rule array. The array enumerates &#64;supports at-rules starting with the
   * innermost one, going outwards.
   */
  public List<CSSSupports> getSupports() {
    return supports;
  }

  /**
   * &#64;supports CSS at-rule array. The array enumerates &#64;supports at-rules starting with the
   * innermost one, going outwards.
   */
  public void setSupports(List<CSSSupports> supports) {
    this.supports = supports;
  }

  /**
   * Cascade layer array. Contains the layer hierarchy that this rule belongs to starting with the
   * innermost layer and going outwards.
   */
  public List<CSSLayer> getLayers() {
    return layers;
  }

  /**
   * Cascade layer array. Contains the layer hierarchy that this rule belongs to starting with the
   * innermost layer and going outwards.
   */
  public void setLayers(List<CSSLayer> layers) {
    this.layers = layers;
  }

  /**
   * &#64;scope CSS at-rule array. The array enumerates &#64;scope at-rules starting with the
   * innermost one, going outwards.
   */
  public List<CSSScope> getScopes() {
    return scopes;
  }

  /**
   * &#64;scope CSS at-rule array. The array enumerates &#64;scope at-rules starting with the
   * innermost one, going outwards.
   */
  public void setScopes(List<CSSScope> scopes) {
    this.scopes = scopes;
  }

  /** The array keeps the types of ancestor CSSRules from the innermost going outwards. */
  public List<CSSRuleType> getRuleTypes() {
    return ruleTypes;
  }

  /** The array keeps the types of ancestor CSSRules from the innermost going outwards. */
  public void setRuleTypes(List<CSSRuleType> ruleTypes) {
    this.ruleTypes = ruleTypes;
  }

  /**
   * &#64;starting-style CSS at-rule array. The array enumerates &#64;starting-style at-rules
   * starting with the innermost one, going outwards.
   */
  public List<CSSStartingStyle> getStartingStyles() {
    return startingStyles;
  }

  /**
   * &#64;starting-style CSS at-rule array. The array enumerates &#64;starting-style at-rules
   * starting with the innermost one, going outwards.
   */
  public void setStartingStyles(List<CSSStartingStyle> startingStyles) {
    this.startingStyles = startingStyles;
  }

  /**
   * &#64;navigation CSS at-rule array. The array enumerates &#64;navigation at-rules starting with
   * the innermost one, going outwards.
   */
  public List<CSSNavigation> getNavigations() {
    return navigations;
  }

  /**
   * &#64;navigation CSS at-rule array. The array enumerates &#64;navigation at-rules starting with
   * the innermost one, going outwards.
   */
  public void setNavigations(List<CSSNavigation> navigations) {
    this.navigations = navigations;
  }
}
