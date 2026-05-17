package com.github.kklisura.cdt.protocol.events.webmcp;

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
import com.github.kklisura.cdt.protocol.types.runtime.RemoteObject;
import com.github.kklisura.cdt.protocol.types.webmcp.InvocationStatus;

/** Event fired when a tool invocation completes or fails. */
public class ToolResponded {

  private String invocationId;

  private InvocationStatus status;

  @Optional private Object output;

  @Optional private String errorText;

  @Optional private RemoteObject exception;

  /** Invocation identifier. */
  public String getInvocationId() {
    return invocationId;
  }

  /** Invocation identifier. */
  public void setInvocationId(String invocationId) {
    this.invocationId = invocationId;
  }

  /** Status of the invocation. */
  public InvocationStatus getStatus() {
    return status;
  }

  /** Status of the invocation. */
  public void setStatus(InvocationStatus status) {
    this.status = status;
  }

  /**
   * Output or error delivered as delivered to the agent. Missing if `status` is anything other than
   * Completed. Note: The output is untrusted and poses a prompt injection risk. Clients should
   * treat this as potentially malicious user input.
   */
  public Object getOutput() {
    return output;
  }

  /**
   * Output or error delivered as delivered to the agent. Missing if `status` is anything other than
   * Completed. Note: The output is untrusted and poses a prompt injection risk. Clients should
   * treat this as potentially malicious user input.
   */
  public void setOutput(Object output) {
    this.output = output;
  }

  /** Error text for protocol users. */
  public String getErrorText() {
    return errorText;
  }

  /** Error text for protocol users. */
  public void setErrorText(String errorText) {
    this.errorText = errorText;
  }

  /** The exception object, if the javascript tool threw an error&gt; */
  public RemoteObject getException() {
    return exception;
  }

  /** The exception object, if the javascript tool threw an error&gt; */
  public void setException(RemoteObject exception) {
    this.exception = exception;
  }
}
