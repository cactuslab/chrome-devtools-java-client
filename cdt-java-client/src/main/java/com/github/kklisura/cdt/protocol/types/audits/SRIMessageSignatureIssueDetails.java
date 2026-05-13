package com.github.kklisura.cdt.protocol.types.audits;

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

import java.util.List;

public class SRIMessageSignatureIssueDetails {

  private SRIMessageSignatureError error;

  private String signatureBase;

  private List<String> integrityAssertions;

  private AffectedRequest request;

  public SRIMessageSignatureError getError() {
    return error;
  }

  public void setError(SRIMessageSignatureError error) {
    this.error = error;
  }

  public String getSignatureBase() {
    return signatureBase;
  }

  public void setSignatureBase(String signatureBase) {
    this.signatureBase = signatureBase;
  }

  public List<String> getIntegrityAssertions() {
    return integrityAssertions;
  }

  public void setIntegrityAssertions(List<String> integrityAssertions) {
    this.integrityAssertions = integrityAssertions;
  }

  public AffectedRequest getRequest() {
    return request;
  }

  public void setRequest(AffectedRequest request) {
    this.request = request;
  }
}
