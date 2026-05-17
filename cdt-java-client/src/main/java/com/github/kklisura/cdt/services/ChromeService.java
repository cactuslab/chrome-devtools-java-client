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

import com.github.kklisura.cdt.services.config.ChromeDevToolsServiceConfiguration;
import com.github.kklisura.cdt.services.exceptions.ChromeServiceException;
import com.github.kklisura.cdt.services.types.ChromeTab;
import com.github.kklisura.cdt.services.types.ChromeVersion;
import java.util.List;

/**
 * Chrome service definition.
 *
 * @author Kenan Klisura
 */
public interface ChromeService {
  /**
   * Gets the list of opened chrome tabs.
   *
   * @return List of chrome tabs.
   * @throws ChromeServiceException the chrome service exception
   */
  List<ChromeTab> getTabs() throws ChromeServiceException;

  /**
   * Creates a new chrome tab that points to about:blank
   *
   * @return Chrome tab.
   * @throws ChromeServiceException If creation fails for any reason.
   */
  ChromeTab createTab() throws ChromeServiceException;

  /**
   * Creates a new chrome tab.
   *
   * @param url the url
   * @return Created chrome tab.
   * @throws ChromeServiceException the chrome service exception
   */
  ChromeTab createTab(String url) throws ChromeServiceException;

  /**
   * Activates a tab.
   *
   * @param tab the tab
   * @throws ChromeServiceException the chrome service exception
   */
  void activateTab(ChromeTab tab) throws ChromeServiceException;

  /**
   * Closes a chrome tab.
   *
   * @param ta the ta
   * @throws ChromeServiceException the chrome service exception
   */
  void closeTab(ChromeTab ta) throws ChromeServiceException;

  /**
   * Gets the version info.
   *
   * @return Version info.
   * @throws ChromeServiceException If request fails for any reason.
   */
  ChromeVersion getVersion() throws ChromeServiceException;;

  /**
   * Creates a dev tools service to specified tab.
   *
   * @param tab Tab.
   * @param chromeDevToolsServiceConfiguration Service configuration.
   * @return Dev tools.
   */
  ChromeDevToolsService createDevToolsService(
      ChromeTab tab, ChromeDevToolsServiceConfiguration chromeDevToolsServiceConfiguration)
      throws ChromeServiceException;

  /**
   * Creates a dev tools service to specified tab with default service configuration.
   *
   * @param tab Tab.
   * @return Dev tools.
   */
  ChromeDevToolsService createDevToolsService(ChromeTab tab) throws ChromeServiceException;

  /**
   * Creates a dev tools service connected to the browser endpoint rather than a tab. Use this to
   * access browser-level commands such as {@code Target.createBrowserContext}.
   *
   * @return Dev tools.
   * @throws ChromeServiceException If creation fails for any reason.
   */
  ChromeDevToolsService createBrowserDevToolsService() throws ChromeServiceException;

  /**
   * Creates a dev tools service attached directly to a target given its id, for example a target
   * created via {@code Target.createTarget}. Useful when there is no {@link ChromeTab} from {@code
   * /json/list} to attach to.
   *
   * @param targetId Target id.
   * @return Dev tools.
   * @throws ChromeServiceException If creation fails for any reason.
   */
  ChromeDevToolsService createDevToolsService(String targetId) throws ChromeServiceException;

  /**
   * Creates a tab running in its own browser context, isolated from every other tab on this Chrome
   * instance: no shared cookies, storage or cache. {@link IsolatedTab#close()} disposes the tab and
   * its browser context, so the returned tab is intended to be used in a try-with-resources block.
   *
   * @return Isolated tab.
   * @throws ChromeServiceException If creation fails for any reason.
   */
  IsolatedTab createIsolatedTab() throws ChromeServiceException;
}
