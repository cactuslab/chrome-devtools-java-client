package com.github.kklisura.cdt.protocol.types.browser;

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

/** Parameters for the setDockTile command. */
public class SetDockTileParameters {

  @Optional
  @ParamName("badgeLabel")
  private String badgeLabel;

  @Optional
  @ParamName("image")
  private String image;

  public String getBadgeLabel() {
    return badgeLabel;
  }

  public SetDockTileParameters setBadgeLabel(String badgeLabel) {
    this.badgeLabel = badgeLabel;
    return this;
  }

  /** Png encoded image. (Encoded as a base64 string when passed over JSON) */
  public String getImage() {
    return image;
  }

  /** Png encoded image. (Encoded as a base64 string when passed over JSON) */
  public SetDockTileParameters setImage(String image) {
    this.image = image;
    return this;
  }
}
