package com.github.kklisura.cdt.protocol.types.pwa;

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

/** Parameters for the install command. */
public class InstallParameters {

  @ParamName("manifestId")
  private String manifestId;

  @Optional
  @ParamName("installUrlOrBundleUrl")
  private String installUrlOrBundleUrl;

  public String getManifestId() {
    return manifestId;
  }

  public InstallParameters setManifestId(String manifestId) {
    this.manifestId = manifestId;
    return this;
  }

  /** The location of the app or bundle overriding the one derived from the manifestId. */
  public String getInstallUrlOrBundleUrl() {
    return installUrlOrBundleUrl;
  }

  /** The location of the app or bundle overriding the one derived from the manifestId. */
  public InstallParameters setInstallUrlOrBundleUrl(String installUrlOrBundleUrl) {
    this.installUrlOrBundleUrl = installUrlOrBundleUrl;
    return this;
  }
}
