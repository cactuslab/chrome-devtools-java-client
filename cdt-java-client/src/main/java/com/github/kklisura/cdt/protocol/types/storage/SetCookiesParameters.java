package com.github.kklisura.cdt.protocol.types.storage;

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
import com.github.kklisura.cdt.protocol.types.network.CookieParam;
import java.util.List;

/** Parameters for the setCookies command. */
public class SetCookiesParameters {

  @ParamName("cookies")
  private List<CookieParam> cookies;

  @Optional
  @ParamName("browserContextId")
  private String browserContextId;

  /** Cookies to be set. */
  public List<CookieParam> getCookies() {
    return cookies;
  }

  /** Cookies to be set. */
  public SetCookiesParameters setCookies(List<CookieParam> cookies) {
    this.cookies = cookies;
    return this;
  }

  /** Browser context to use when called on the browser endpoint. */
  public String getBrowserContextId() {
    return browserContextId;
  }

  /** Browser context to use when called on the browser endpoint. */
  public SetCookiesParameters setBrowserContextId(String browserContextId) {
    this.browserContextId = browserContextId;
    return this;
  }
}
