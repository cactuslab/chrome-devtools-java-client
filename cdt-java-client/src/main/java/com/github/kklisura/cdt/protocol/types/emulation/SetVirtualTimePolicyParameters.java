package com.github.kklisura.cdt.protocol.types.emulation;

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

/** Parameters for the setVirtualTimePolicy command. */
public class SetVirtualTimePolicyParameters {

  @ParamName("policy")
  private VirtualTimePolicy policy;

  @Optional
  @ParamName("budget")
  private Double budget;

  @Optional
  @ParamName("maxVirtualTimeTaskStarvationCount")
  private Integer maxVirtualTimeTaskStarvationCount;

  @Optional
  @ParamName("initialVirtualTime")
  private Double initialVirtualTime;

  public VirtualTimePolicy getPolicy() {
    return policy;
  }

  public SetVirtualTimePolicyParameters setPolicy(VirtualTimePolicy policy) {
    this.policy = policy;
    return this;
  }

  /**
   * If set, after this many virtual milliseconds have elapsed virtual time will be paused and a
   * virtualTimeBudgetExpired event is sent.
   */
  public Double getBudget() {
    return budget;
  }

  /**
   * If set, after this many virtual milliseconds have elapsed virtual time will be paused and a
   * virtualTimeBudgetExpired event is sent.
   */
  public SetVirtualTimePolicyParameters setBudget(Double budget) {
    this.budget = budget;
    return this;
  }

  /**
   * If set this specifies the maximum number of tasks that can be run before virtual is forced
   * forwards to prevent deadlock.
   */
  public Integer getMaxVirtualTimeTaskStarvationCount() {
    return maxVirtualTimeTaskStarvationCount;
  }

  /**
   * If set this specifies the maximum number of tasks that can be run before virtual is forced
   * forwards to prevent deadlock.
   */
  public SetVirtualTimePolicyParameters setMaxVirtualTimeTaskStarvationCount(
      Integer maxVirtualTimeTaskStarvationCount) {
    this.maxVirtualTimeTaskStarvationCount = maxVirtualTimeTaskStarvationCount;
    return this;
  }

  /** If set, base::Time::Now will be overridden to initially return this value. */
  public Double getInitialVirtualTime() {
    return initialVirtualTime;
  }

  /** If set, base::Time::Now will be overridden to initially return this value. */
  public SetVirtualTimePolicyParameters setInitialVirtualTime(Double initialVirtualTime) {
    this.initialVirtualTime = initialVirtualTime;
    return this;
  }
}
