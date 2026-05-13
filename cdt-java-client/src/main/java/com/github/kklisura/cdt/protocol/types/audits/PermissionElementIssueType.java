package com.github.kklisura.cdt.protocol.types.audits;

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

public enum PermissionElementIssueType {
  @JsonProperty("InvalidType")
  INVALID_TYPE,
  @JsonProperty("FencedFrameDisallowed")
  FENCED_FRAME_DISALLOWED,
  @JsonProperty("CspFrameAncestorsMissing")
  CSP_FRAME_ANCESTORS_MISSING,
  @JsonProperty("PermissionsPolicyBlocked")
  PERMISSIONS_POLICY_BLOCKED,
  @JsonProperty("PaddingRightUnsupported")
  PADDING_RIGHT_UNSUPPORTED,
  @JsonProperty("PaddingBottomUnsupported")
  PADDING_BOTTOM_UNSUPPORTED,
  @JsonProperty("InsetBoxShadowUnsupported")
  INSET_BOX_SHADOW_UNSUPPORTED,
  @JsonProperty("RequestInProgress")
  REQUEST_IN_PROGRESS,
  @JsonProperty("UntrustedEvent")
  UNTRUSTED_EVENT,
  @JsonProperty("RegistrationFailed")
  REGISTRATION_FAILED,
  @JsonProperty("TypeNotSupported")
  TYPE_NOT_SUPPORTED,
  @JsonProperty("InvalidTypeActivation")
  INVALID_TYPE_ACTIVATION,
  @JsonProperty("SecurityChecksFailed")
  SECURITY_CHECKS_FAILED,
  @JsonProperty("ActivationDisabled")
  ACTIVATION_DISABLED,
  @JsonProperty("GeolocationDeprecated")
  GEOLOCATION_DEPRECATED,
  @JsonProperty("InvalidDisplayStyle")
  INVALID_DISPLAY_STYLE,
  @JsonProperty("NonOpaqueColor")
  NON_OPAQUE_COLOR,
  @JsonProperty("LowContrast")
  LOW_CONTRAST,
  @JsonProperty("FontSizeTooSmall")
  FONT_SIZE_TOO_SMALL,
  @JsonProperty("FontSizeTooLarge")
  FONT_SIZE_TOO_LARGE,
  @JsonProperty("InvalidSizeValue")
  INVALID_SIZE_VALUE
}
