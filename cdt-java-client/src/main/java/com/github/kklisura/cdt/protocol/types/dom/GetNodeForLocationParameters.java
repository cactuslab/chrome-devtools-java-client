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

/** Parameters for the getNodeForLocation command. */
public class GetNodeForLocationParameters {

  @ParamName("x")
  private Integer x;

  @ParamName("y")
  private Integer y;

  @Optional
  @ParamName("includeUserAgentShadowDOM")
  private Boolean includeUserAgentShadowDOM;

  @Optional
  @ParamName("ignorePointerEventsNone")
  private Boolean ignorePointerEventsNone;

  /** X coordinate. */
  public Integer getX() {
    return x;
  }

  /** X coordinate. */
  public GetNodeForLocationParameters setX(Integer x) {
    this.x = x;
    return this;
  }

  /** Y coordinate. */
  public Integer getY() {
    return y;
  }

  /** Y coordinate. */
  public GetNodeForLocationParameters setY(Integer y) {
    this.y = y;
    return this;
  }

  /** False to skip to the nearest non-UA shadow root ancestor (default: false). */
  public Boolean getIncludeUserAgentShadowDOM() {
    return includeUserAgentShadowDOM;
  }

  /** False to skip to the nearest non-UA shadow root ancestor (default: false). */
  public GetNodeForLocationParameters setIncludeUserAgentShadowDOM(
      Boolean includeUserAgentShadowDOM) {
    this.includeUserAgentShadowDOM = includeUserAgentShadowDOM;
    return this;
  }

  /** Whether to ignore pointer-events: none on elements and hit test them. */
  public Boolean getIgnorePointerEventsNone() {
    return ignorePointerEventsNone;
  }

  /** Whether to ignore pointer-events: none on elements and hit test them. */
  public GetNodeForLocationParameters setIgnorePointerEventsNone(Boolean ignorePointerEventsNone) {
    this.ignorePointerEventsNone = ignorePointerEventsNone;
    return this;
  }
}
