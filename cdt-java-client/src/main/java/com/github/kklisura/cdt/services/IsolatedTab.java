package com.github.kklisura.cdt.services;

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

import com.github.kklisura.cdt.protocol.commands.Target;

/**
 * A tab running in its own browser context, isolated from every other tab on the same Chrome
 * instance: no shared cookies, storage or cache. Created via {@link
 * ChromeService#createIsolatedTab()}.
 *
 * <p>{@link #close()} disposes the tab and its browser context, so it is intended to be used in a
 * try-with-resources block:
 *
 * <pre>
 * try (IsolatedTab tab = chromeService.createIsolatedTab()) {
 *   ChromeDevToolsService devToolsService = tab.getDevToolsService();
 *   // ...
 * }
 * </pre>
 *
 * @author Kenan Klisura
 */
public class IsolatedTab implements AutoCloseable {
  private final Target target;
  private final String browserContextId;
  private final String targetId;
  private final ChromeDevToolsService devToolsService;

  /**
   * Creates a new isolated tab.
   *
   * @param target Browser-level target command used to dispose this tab and its browser context.
   *     This is the shared browser session and must not be closed by this isolated tab.
   * @param browserContextId Id of the browser context owning this tab.
   * @param targetId Id of the tab target.
   * @param devToolsService Dev tools service attached to the tab target.
   */
  public IsolatedTab(
      Target target,
      String browserContextId,
      String targetId,
      ChromeDevToolsService devToolsService) {
    this.target = target;
    this.browserContextId = browserContextId;
    this.targetId = targetId;
    this.devToolsService = devToolsService;
  }

  /**
   * Returns the dev tools service attached to this tab.
   *
   * @return Dev tools service.
   */
  public ChromeDevToolsService getDevToolsService() {
    return devToolsService;
  }

  /**
   * Returns the id of this tab's target.
   *
   * @return Target id.
   */
  public String getTargetId() {
    return targetId;
  }

  /**
   * Returns the id of the browser context owning this tab.
   *
   * @return Browser context id.
   */
  public String getBrowserContextId() {
    return browserContextId;
  }

  /**
   * Closes the dev tools service, the tab target and disposes the browser context. The shared
   * browser-level dev tools service is left open.
   */
  @Override
  public void close() {
    try {
      // Closing the dev tools service self-evicts it from the chrome service cache.
      devToolsService.close();
    } finally {
      try {
        target.closeTarget(targetId);
      } finally {
        target.disposeBrowserContext(browserContextId);
      }
    }
  }
}
