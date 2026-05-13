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
public class WorkAreaInsets {

  @Optional private Integer top;

  @Optional private Integer left;

  @Optional private Integer bottom;

  @Optional private Integer right;

  /** Work area top inset in pixels. Default is 0; */
  public Integer getTop() {
    return top;
  }

  /** Work area top inset in pixels. Default is 0; */
  public void setTop(Integer top) {
    this.top = top;
  }

  /** Work area left inset in pixels. Default is 0; */
  public Integer getLeft() {
    return left;
  }

  /** Work area left inset in pixels. Default is 0; */
  public void setLeft(Integer left) {
    this.left = left;
  }

  /** Work area bottom inset in pixels. Default is 0; */
  public Integer getBottom() {
    return bottom;
  }

  /** Work area bottom inset in pixels. Default is 0; */
  public void setBottom(Integer bottom) {
    this.bottom = bottom;
  }

  /** Work area right inset in pixels. Default is 0; */
  public Integer getRight() {
    return right;
  }

  /** Work area right inset in pixels. Default is 0; */
  public void setRight(Integer right) {
    this.right = right;
  }
}
