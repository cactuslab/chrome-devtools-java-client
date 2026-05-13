package com.github.kklisura.cdt.protocol.types.smartcardemulation;

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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Indicates the PC/SC error code.
 *
 * <p>This maps to: PC/SC Lite: https://pcsclite.apdu.fr/api/group__ErrorCodes.html Microsoft:
 * https://learn.microsoft.com/en-us/windows/win32/secauthn/authentication-return-values
 */
public enum ResultCode {
  @JsonProperty("success")
  SUCCESS,
  @JsonProperty("removed-card")
  REMOVED_CARD,
  @JsonProperty("reset-card")
  RESET_CARD,
  @JsonProperty("unpowered-card")
  UNPOWERED_CARD,
  @JsonProperty("unresponsive-card")
  UNRESPONSIVE_CARD,
  @JsonProperty("unsupported-card")
  UNSUPPORTED_CARD,
  @JsonProperty("reader-unavailable")
  READER_UNAVAILABLE,
  @JsonProperty("sharing-violation")
  SHARING_VIOLATION,
  @JsonProperty("not-transacted")
  NOT_TRANSACTED,
  @JsonProperty("no-smartcard")
  NO_SMARTCARD,
  @JsonProperty("proto-mismatch")
  PROTO_MISMATCH,
  @JsonProperty("system-cancelled")
  SYSTEM_CANCELLED,
  @JsonProperty("not-ready")
  NOT_READY,
  @JsonProperty("cancelled")
  CANCELLED,
  @JsonProperty("insufficient-buffer")
  INSUFFICIENT_BUFFER,
  @JsonProperty("invalid-handle")
  INVALID_HANDLE,
  @JsonProperty("invalid-parameter")
  INVALID_PARAMETER,
  @JsonProperty("invalid-value")
  INVALID_VALUE,
  @JsonProperty("no-memory")
  NO_MEMORY,
  @JsonProperty("timeout")
  TIMEOUT,
  @JsonProperty("unknown-reader")
  UNKNOWN_READER,
  @JsonProperty("unsupported-feature")
  UNSUPPORTED_FEATURE,
  @JsonProperty("no-readers-available")
  NO_READERS_AVAILABLE,
  @JsonProperty("service-stopped")
  SERVICE_STOPPED,
  @JsonProperty("no-service")
  NO_SERVICE,
  @JsonProperty("comm-error")
  COMM_ERROR,
  @JsonProperty("internal-error")
  INTERNAL_ERROR,
  @JsonProperty("server-too-busy")
  SERVER_TOO_BUSY,
  @JsonProperty("unexpected")
  UNEXPECTED,
  @JsonProperty("shutdown")
  SHUTDOWN,
  @JsonProperty("unknown-card")
  UNKNOWN_CARD,
  @JsonProperty("unknown")
  UNKNOWN
}
