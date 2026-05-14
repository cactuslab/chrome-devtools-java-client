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

/** Parameters for the setResponseOverrideBits command. */
public class SetResponseOverrideBitsParameters {

  @ParamName("authenticatorId")
  private String authenticatorId;

  @Optional
  @ParamName("isBogusSignature")
  private Boolean isBogusSignature;

  @Optional
  @ParamName("isBadUV")
  private Boolean isBadUV;

  @Optional
  @ParamName("isBadUP")
  private Boolean isBadUP;

  public String getAuthenticatorId() {
    return authenticatorId;
  }

  public SetResponseOverrideBitsParameters setAuthenticatorId(String authenticatorId) {
    this.authenticatorId = authenticatorId;
    return this;
  }

  /**
   * If isBogusSignature is set, overrides the signature in the authenticator response to be zero.
   * Defaults to false.
   */
  public Boolean getIsBogusSignature() {
    return isBogusSignature;
  }

  /**
   * If isBogusSignature is set, overrides the signature in the authenticator response to be zero.
   * Defaults to false.
   */
  public SetResponseOverrideBitsParameters setIsBogusSignature(Boolean isBogusSignature) {
    this.isBogusSignature = isBogusSignature;
    return this;
  }

  /**
   * If isBadUV is set, overrides the UV bit in the flags in the authenticator response to be zero.
   * Defaults to false.
   */
  public Boolean getIsBadUV() {
    return isBadUV;
  }

  /**
   * If isBadUV is set, overrides the UV bit in the flags in the authenticator response to be zero.
   * Defaults to false.
   */
  public SetResponseOverrideBitsParameters setIsBadUV(Boolean isBadUV) {
    this.isBadUV = isBadUV;
    return this;
  }

  /**
   * If isBadUP is set, overrides the UP bit in the flags in the authenticator response to be zero.
   * Defaults to false.
   */
  public Boolean getIsBadUP() {
    return isBadUP;
  }

  /**
   * If isBadUP is set, overrides the UP bit in the flags in the authenticator response to be zero.
   * Defaults to false.
   */
  public SetResponseOverrideBitsParameters setIsBadUP(Boolean isBadUP) {
    this.isBadUP = isBadUP;
    return this;
  }
}
