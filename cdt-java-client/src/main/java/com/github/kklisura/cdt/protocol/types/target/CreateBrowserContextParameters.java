package com.github.kklisura.cdt.protocol.types.target;

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
import java.util.List;

/** Parameters for the createBrowserContext command. */
public class CreateBrowserContextParameters {

  @Experimental
  @Optional
  @ParamName("disposeOnDetach")
  private Boolean disposeOnDetach;

  @Experimental
  @Optional
  @ParamName("proxyServer")
  private String proxyServer;

  @Experimental
  @Optional
  @ParamName("proxyBypassList")
  private String proxyBypassList;

  @Experimental
  @Optional
  @ParamName("originsWithUniversalNetworkAccess")
  private List<String> originsWithUniversalNetworkAccess;

  /** If specified, disposes this context when debugging session disconnects. */
  public Boolean getDisposeOnDetach() {
    return disposeOnDetach;
  }

  /** If specified, disposes this context when debugging session disconnects. */
  public CreateBrowserContextParameters setDisposeOnDetach(Boolean disposeOnDetach) {
    this.disposeOnDetach = disposeOnDetach;
    return this;
  }

  /** Proxy server, similar to the one passed to --proxy-server */
  public String getProxyServer() {
    return proxyServer;
  }

  /** Proxy server, similar to the one passed to --proxy-server */
  public CreateBrowserContextParameters setProxyServer(String proxyServer) {
    this.proxyServer = proxyServer;
    return this;
  }

  /** Proxy bypass list, similar to the one passed to --proxy-bypass-list */
  public String getProxyBypassList() {
    return proxyBypassList;
  }

  /** Proxy bypass list, similar to the one passed to --proxy-bypass-list */
  public CreateBrowserContextParameters setProxyBypassList(String proxyBypassList) {
    this.proxyBypassList = proxyBypassList;
    return this;
  }

  /**
   * An optional list of origins to grant unlimited cross-origin access to. Parts of the URL other
   * than those constituting origin are ignored.
   */
  public List<String> getOriginsWithUniversalNetworkAccess() {
    return originsWithUniversalNetworkAccess;
  }

  /**
   * An optional list of origins to grant unlimited cross-origin access to. Parts of the URL other
   * than those constituting origin are ignored.
   */
  public CreateBrowserContextParameters setOriginsWithUniversalNetworkAccess(
      List<String> originsWithUniversalNetworkAccess) {
    this.originsWithUniversalNetworkAccess = originsWithUniversalNetworkAccess;
    return this;
  }
}
