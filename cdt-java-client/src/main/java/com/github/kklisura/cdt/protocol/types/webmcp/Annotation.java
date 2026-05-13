package com.github.kklisura.cdt.protocol.types.webmcp;

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

/** Tool annotations */
public class Annotation {

  @Optional private Boolean readOnly;

  @Optional private Boolean untrustedContent;

  @Optional private Boolean autosubmit;

  /** A hint indicating that the tool does not modify any state. */
  public Boolean getReadOnly() {
    return readOnly;
  }

  /** A hint indicating that the tool does not modify any state. */
  public void setReadOnly(Boolean readOnly) {
    this.readOnly = readOnly;
  }

  /**
   * A hint indicating that the tool output may contain untrusted content, ex: UGC, 3rd party data.
   */
  public Boolean getUntrustedContent() {
    return untrustedContent;
  }

  /**
   * A hint indicating that the tool output may contain untrusted content, ex: UGC, 3rd party data.
   */
  public void setUntrustedContent(Boolean untrustedContent) {
    this.untrustedContent = untrustedContent;
  }

  /** If the declarative tool was declared with the autosubmit attribute. */
  public Boolean getAutosubmit() {
    return autosubmit;
  }

  /** If the declarative tool was declared with the autosubmit attribute. */
  public void setAutosubmit(Boolean autosubmit) {
    this.autosubmit = autosubmit;
  }
}
