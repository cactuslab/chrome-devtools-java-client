package com.github.kklisura.cdt.protocol.types.crashreportcontext;

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

/** Key-value pair in CrashReportContext. */
public class CrashReportContextEntry {

  private String key;

  private String value;

  private String frameId;

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  /** The ID of the frame where the key-value pair was set. */
  public String getFrameId() {
    return frameId;
  }

  /** The ID of the frame where the key-value pair was set. */
  public void setFrameId(String frameId) {
    this.frameId = frameId;
  }
}
