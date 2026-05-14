package com.github.kklisura.cdt.protocol.types.fedcm;

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

/** Parameters for the enable command. */
public class EnableParameters {

  @Optional
  @ParamName("disableRejectionDelay")
  private Boolean disableRejectionDelay;

  /**
   * Allows callers to disable the promise rejection delay that would normally happen, if this is
   * unimportant to what's being tested. (step 4 of
   * https://fedidcg.github.io/FedCM/#browser-api-rp-sign-in)
   */
  public Boolean getDisableRejectionDelay() {
    return disableRejectionDelay;
  }

  /**
   * Allows callers to disable the promise rejection delay that would normally happen, if this is
   * unimportant to what's being tested. (step 4 of
   * https://fedidcg.github.io/FedCM/#browser-api-rp-sign-in)
   */
  public EnableParameters setDisableRejectionDelay(Boolean disableRejectionDelay) {
    this.disableRejectionDelay = disableRejectionDelay;
    return this;
  }
}
