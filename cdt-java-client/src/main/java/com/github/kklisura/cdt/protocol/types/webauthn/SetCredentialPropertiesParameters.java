package com.github.kklisura.cdt.protocol.types.webauthn;

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

/** Parameters for the setCredentialProperties command. */
public class SetCredentialPropertiesParameters {

  @ParamName("authenticatorId")
  private String authenticatorId;

  @ParamName("credentialId")
  private String credentialId;

  @Optional
  @ParamName("backupEligibility")
  private Boolean backupEligibility;

  @Optional
  @ParamName("backupState")
  private Boolean backupState;

  public String getAuthenticatorId() {
    return authenticatorId;
  }

  public SetCredentialPropertiesParameters setAuthenticatorId(String authenticatorId) {
    this.authenticatorId = authenticatorId;
    return this;
  }

  public String getCredentialId() {
    return credentialId;
  }

  public SetCredentialPropertiesParameters setCredentialId(String credentialId) {
    this.credentialId = credentialId;
    return this;
  }

  public Boolean getBackupEligibility() {
    return backupEligibility;
  }

  public SetCredentialPropertiesParameters setBackupEligibility(Boolean backupEligibility) {
    this.backupEligibility = backupEligibility;
    return this;
  }

  public Boolean getBackupState() {
    return backupState;
  }

  public SetCredentialPropertiesParameters setBackupState(Boolean backupState) {
    this.backupState = backupState;
    return this;
  }
}
