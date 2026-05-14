package com.github.kklisura.cdt.protocol.types.emulation;

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
import java.util.List;

/** Parameters for the setEmulatedMedia command. */
public class SetEmulatedMediaParameters {

  @Optional
  @ParamName("media")
  private String media;

  @Optional
  @ParamName("features")
  private List<MediaFeature> features;

  /** Media type to emulate. Empty string disables the override. */
  public String getMedia() {
    return media;
  }

  /** Media type to emulate. Empty string disables the override. */
  public SetEmulatedMediaParameters setMedia(String media) {
    this.media = media;
    return this;
  }

  /** Media features to emulate. */
  public List<MediaFeature> getFeatures() {
    return features;
  }

  /** Media features to emulate. */
  public SetEmulatedMediaParameters setFeatures(List<MediaFeature> features) {
    this.features = features;
    return this;
  }
}
