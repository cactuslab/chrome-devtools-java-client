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

import com.github.kklisura.cdt.protocol.support.annotations.Experimental;
import com.github.kklisura.cdt.protocol.support.annotations.Optional;

@Experimental
public class SafeAreaInsets {

  @Optional private Integer top;

  @Optional private Integer topMax;

  @Optional private Integer left;

  @Optional private Integer leftMax;

  @Optional private Integer bottom;

  @Optional private Integer bottomMax;

  @Optional private Integer right;

  @Optional private Integer rightMax;

  /** Overrides safe-area-inset-top. */
  public Integer getTop() {
    return top;
  }

  /** Overrides safe-area-inset-top. */
  public void setTop(Integer top) {
    this.top = top;
  }

  /** Overrides safe-area-max-inset-top. */
  public Integer getTopMax() {
    return topMax;
  }

  /** Overrides safe-area-max-inset-top. */
  public void setTopMax(Integer topMax) {
    this.topMax = topMax;
  }

  /** Overrides safe-area-inset-left. */
  public Integer getLeft() {
    return left;
  }

  /** Overrides safe-area-inset-left. */
  public void setLeft(Integer left) {
    this.left = left;
  }

  /** Overrides safe-area-max-inset-left. */
  public Integer getLeftMax() {
    return leftMax;
  }

  /** Overrides safe-area-max-inset-left. */
  public void setLeftMax(Integer leftMax) {
    this.leftMax = leftMax;
  }

  /** Overrides safe-area-inset-bottom. */
  public Integer getBottom() {
    return bottom;
  }

  /** Overrides safe-area-inset-bottom. */
  public void setBottom(Integer bottom) {
    this.bottom = bottom;
  }

  /** Overrides safe-area-max-inset-bottom. */
  public Integer getBottomMax() {
    return bottomMax;
  }

  /** Overrides safe-area-max-inset-bottom. */
  public void setBottomMax(Integer bottomMax) {
    this.bottomMax = bottomMax;
  }

  /** Overrides safe-area-inset-right. */
  public Integer getRight() {
    return right;
  }

  /** Overrides safe-area-inset-right. */
  public void setRight(Integer right) {
    this.right = right;
  }

  /** Overrides safe-area-max-inset-right. */
  public Integer getRightMax() {
    return rightMax;
  }

  /** Overrides safe-area-max-inset-right. */
  public void setRightMax(Integer rightMax) {
    this.rightMax = rightMax;
  }
}
