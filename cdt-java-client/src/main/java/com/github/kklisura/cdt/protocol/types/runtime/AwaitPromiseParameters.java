package com.github.kklisura.cdt.protocol.types.runtime;

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

/** Parameters for the awaitPromise command. */
public class AwaitPromiseParameters {

  @ParamName("promiseObjectId")
  private String promiseObjectId;

  @Optional
  @ParamName("returnByValue")
  private Boolean returnByValue;

  @Optional
  @ParamName("generatePreview")
  private Boolean generatePreview;

  /** Identifier of the promise. */
  public String getPromiseObjectId() {
    return promiseObjectId;
  }

  /** Identifier of the promise. */
  public AwaitPromiseParameters setPromiseObjectId(String promiseObjectId) {
    this.promiseObjectId = promiseObjectId;
    return this;
  }

  /** Whether the result is expected to be a JSON object that should be sent by value. */
  public Boolean getReturnByValue() {
    return returnByValue;
  }

  /** Whether the result is expected to be a JSON object that should be sent by value. */
  public AwaitPromiseParameters setReturnByValue(Boolean returnByValue) {
    this.returnByValue = returnByValue;
    return this;
  }

  /** Whether preview should be generated for the result. */
  public Boolean getGeneratePreview() {
    return generatePreview;
  }

  /** Whether preview should be generated for the result. */
  public AwaitPromiseParameters setGeneratePreview(Boolean generatePreview) {
    this.generatePreview = generatePreview;
    return this;
  }
}
