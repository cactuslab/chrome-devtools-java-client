package com.github.kklisura.cdt.protocol.commands;

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
import com.github.kklisura.cdt.protocol.support.annotations.ParamObject;
import com.github.kklisura.cdt.protocol.support.annotations.ReturnTypeParameter;
import com.github.kklisura.cdt.protocol.support.annotations.Returns;
import com.github.kklisura.cdt.protocol.types.extensions.ExtensionInfo;
import com.github.kklisura.cdt.protocol.types.extensions.GetStorageItemsParameters;
import com.github.kklisura.cdt.protocol.types.extensions.LoadUnpackedParameters;
import com.github.kklisura.cdt.protocol.types.extensions.StorageArea;
import java.util.List;
import java.util.Map;

/** Defines commands and events for browser extensions. */
@Experimental
public interface Extensions {

  /**
   * Runs an extension default action.
   *
   * @param id Extension id.
   * @param targetId A tab target ID to trigger the default extension action on.
   */
  void triggerAction(@ParamName("id") String id, @ParamName("targetId") String targetId);

  /**
   * Installs an unpacked extension from the filesystem similar to --load-extension CLI flags.
   * Returns extension ID once the extension has been installed.
   *
   * @param path Absolute file path.
   */
  @Returns("id")
  String loadUnpacked(@ParamName("path") String path);

  /**
   * Installs an unpacked extension from the filesystem similar to --load-extension CLI flags.
   * Returns extension ID once the extension has been installed.
   *
   * @param path Absolute file path.
   * @param enableInIncognito Enable the extension in incognito
   */
  @Returns("id")
  String loadUnpacked(
      @ParamName("path") String path,
      @Optional @ParamName("enableInIncognito") Boolean enableInIncognito);

  /**
   * Installs an unpacked extension from the filesystem similar to --load-extension CLI flags.
   * Returns extension ID once the extension has been installed.
   */
  @Returns("id")
  String loadUnpacked(@ParamObject LoadUnpackedParameters parameters);

  /** Gets a list of all unpacked extensions. */
  @Returns("extensions")
  @ReturnTypeParameter(ExtensionInfo.class)
  List<ExtensionInfo> getExtensions();

  /**
   * Uninstalls an unpacked extension (others not supported) from the profile.
   *
   * @param id Extension id.
   */
  void uninstall(@ParamName("id") String id);

  /**
   * Gets data from extension storage in the given `storageArea`. If `keys` is specified, these are
   * used to filter the result.
   *
   * @param id ID of extension.
   * @param storageArea StorageArea to retrieve data from.
   */
  @Returns("data")
  Map<String, Object> getStorageItems(
      @ParamName("id") String id, @ParamName("storageArea") StorageArea storageArea);

  /**
   * Gets data from extension storage in the given `storageArea`. If `keys` is specified, these are
   * used to filter the result.
   *
   * @param id ID of extension.
   * @param storageArea StorageArea to retrieve data from.
   * @param keys Keys to retrieve.
   */
  @Returns("data")
  Map<String, Object> getStorageItems(
      @ParamName("id") String id,
      @ParamName("storageArea") StorageArea storageArea,
      @Optional @ParamName("keys") List<String> keys);

  /**
   * Gets data from extension storage in the given `storageArea`. If `keys` is specified, these are
   * used to filter the result.
   */
  @Returns("data")
  Map<String, Object> getStorageItems(@ParamObject GetStorageItemsParameters parameters);

  /**
   * Removes `keys` from extension storage in the given `storageArea`.
   *
   * @param id ID of extension.
   * @param storageArea StorageArea to remove data from.
   * @param keys Keys to remove.
   */
  void removeStorageItems(
      @ParamName("id") String id,
      @ParamName("storageArea") StorageArea storageArea,
      @ParamName("keys") List<String> keys);

  /**
   * Clears extension storage in the given `storageArea`.
   *
   * @param id ID of extension.
   * @param storageArea StorageArea to remove data from.
   */
  void clearStorageItems(
      @ParamName("id") String id, @ParamName("storageArea") StorageArea storageArea);

  /**
   * Sets `values` in extension storage in the given `storageArea`. The provided `values` will be
   * merged with existing values in the storage area.
   *
   * @param id ID of extension.
   * @param storageArea StorageArea to set data in.
   * @param values Values to set.
   */
  void setStorageItems(
      @ParamName("id") String id,
      @ParamName("storageArea") StorageArea storageArea,
      @ParamName("values") Map<String, Object> values);
}
