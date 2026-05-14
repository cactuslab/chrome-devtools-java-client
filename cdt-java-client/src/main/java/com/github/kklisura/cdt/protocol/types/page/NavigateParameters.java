package com.github.kklisura.cdt.protocol.types.page;

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

/** Parameters for the navigate command. */
public class NavigateParameters {

  @ParamName("url")
  private String url;

  @Optional
  @ParamName("referrer")
  private String referrer;

  @Optional
  @ParamName("transitionType")
  private TransitionType transitionType;

  @Optional
  @ParamName("frameId")
  private String frameId;

  @Experimental
  @Optional
  @ParamName("referrerPolicy")
  private ReferrerPolicy referrerPolicy;

  /** URL to navigate the page to. */
  public String getUrl() {
    return url;
  }

  /** URL to navigate the page to. */
  public NavigateParameters setUrl(String url) {
    this.url = url;
    return this;
  }

  /** Referrer URL. */
  public String getReferrer() {
    return referrer;
  }

  /** Referrer URL. */
  public NavigateParameters setReferrer(String referrer) {
    this.referrer = referrer;
    return this;
  }

  /** Intended transition type. */
  public TransitionType getTransitionType() {
    return transitionType;
  }

  /** Intended transition type. */
  public NavigateParameters setTransitionType(TransitionType transitionType) {
    this.transitionType = transitionType;
    return this;
  }

  /** Frame id to navigate, if not specified navigates the top frame. */
  public String getFrameId() {
    return frameId;
  }

  /** Frame id to navigate, if not specified navigates the top frame. */
  public NavigateParameters setFrameId(String frameId) {
    this.frameId = frameId;
    return this;
  }

  /** Referrer-policy used for the navigation. */
  public ReferrerPolicy getReferrerPolicy() {
    return referrerPolicy;
  }

  /** Referrer-policy used for the navigation. */
  public NavigateParameters setReferrerPolicy(ReferrerPolicy referrerPolicy) {
    this.referrerPolicy = referrerPolicy;
    return this;
  }
}
