package com.github.kklisura.cdt.protocol.types.network;

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

/** A fetch result for a device bound session creation or refresh. */
public enum DeviceBoundSessionFetchResult {
  @JsonProperty("Success")
  SUCCESS,
  @JsonProperty("KeyError")
  KEY_ERROR,
  @JsonProperty("SigningError")
  SIGNING_ERROR,
  @JsonProperty("TransientSigningError")
  TRANSIENT_SIGNING_ERROR,
  @JsonProperty("ServerRequestedTermination")
  SERVER_REQUESTED_TERMINATION,
  @JsonProperty("InvalidSessionId")
  INVALID_SESSION_ID,
  @JsonProperty("InvalidChallenge")
  INVALID_CHALLENGE,
  @JsonProperty("TooManyChallenges")
  TOO_MANY_CHALLENGES,
  @JsonProperty("InvalidFetcherUrl")
  INVALID_FETCHER_URL,
  @JsonProperty("InvalidRefreshUrl")
  INVALID_REFRESH_URL,
  @JsonProperty("TransientHttpError")
  TRANSIENT_HTTP_ERROR,
  @JsonProperty("ScopeOriginSameSiteMismatch")
  SCOPE_ORIGIN_SAME_SITE_MISMATCH,
  @JsonProperty("RefreshUrlSameSiteMismatch")
  REFRESH_URL_SAME_SITE_MISMATCH,
  @JsonProperty("MismatchedSessionId")
  MISMATCHED_SESSION_ID,
  @JsonProperty("MissingScope")
  MISSING_SCOPE,
  @JsonProperty("NoCredentials")
  NO_CREDENTIALS,
  @JsonProperty("SubdomainRegistrationWellKnownUnavailable")
  SUBDOMAIN_REGISTRATION_WELL_KNOWN_UNAVAILABLE,
  @JsonProperty("SubdomainRegistrationUnauthorized")
  SUBDOMAIN_REGISTRATION_UNAUTHORIZED,
  @JsonProperty("SubdomainRegistrationWellKnownMalformed")
  SUBDOMAIN_REGISTRATION_WELL_KNOWN_MALFORMED,
  @JsonProperty("SessionProviderWellKnownUnavailable")
  SESSION_PROVIDER_WELL_KNOWN_UNAVAILABLE,
  @JsonProperty("RelyingPartyWellKnownUnavailable")
  RELYING_PARTY_WELL_KNOWN_UNAVAILABLE,
  @JsonProperty("FederatedKeyThumbprintMismatch")
  FEDERATED_KEY_THUMBPRINT_MISMATCH,
  @JsonProperty("InvalidFederatedSessionUrl")
  INVALID_FEDERATED_SESSION_URL,
  @JsonProperty("InvalidFederatedKey")
  INVALID_FEDERATED_KEY,
  @JsonProperty("TooManyRelyingOriginLabels")
  TOO_MANY_RELYING_ORIGIN_LABELS,
  @JsonProperty("BoundCookieSetForbidden")
  BOUND_COOKIE_SET_FORBIDDEN,
  @JsonProperty("NetError")
  NET_ERROR,
  @JsonProperty("ProxyError")
  PROXY_ERROR,
  @JsonProperty("EmptySessionConfig")
  EMPTY_SESSION_CONFIG,
  @JsonProperty("InvalidCredentialsConfig")
  INVALID_CREDENTIALS_CONFIG,
  @JsonProperty("InvalidCredentialsType")
  INVALID_CREDENTIALS_TYPE,
  @JsonProperty("InvalidCredentialsEmptyName")
  INVALID_CREDENTIALS_EMPTY_NAME,
  @JsonProperty("InvalidCredentialsCookie")
  INVALID_CREDENTIALS_COOKIE,
  @JsonProperty("PersistentHttpError")
  PERSISTENT_HTTP_ERROR,
  @JsonProperty("RegistrationAttemptedChallenge")
  REGISTRATION_ATTEMPTED_CHALLENGE,
  @JsonProperty("InvalidScopeOrigin")
  INVALID_SCOPE_ORIGIN,
  @JsonProperty("ScopeOriginContainsPath")
  SCOPE_ORIGIN_CONTAINS_PATH,
  @JsonProperty("RefreshInitiatorNotString")
  REFRESH_INITIATOR_NOT_STRING,
  @JsonProperty("RefreshInitiatorInvalidHostPattern")
  REFRESH_INITIATOR_INVALID_HOST_PATTERN,
  @JsonProperty("InvalidScopeSpecification")
  INVALID_SCOPE_SPECIFICATION,
  @JsonProperty("MissingScopeSpecificationType")
  MISSING_SCOPE_SPECIFICATION_TYPE,
  @JsonProperty("EmptyScopeSpecificationDomain")
  EMPTY_SCOPE_SPECIFICATION_DOMAIN,
  @JsonProperty("EmptyScopeSpecificationPath")
  EMPTY_SCOPE_SPECIFICATION_PATH,
  @JsonProperty("InvalidScopeSpecificationType")
  INVALID_SCOPE_SPECIFICATION_TYPE,
  @JsonProperty("InvalidScopeIncludeSite")
  INVALID_SCOPE_INCLUDE_SITE,
  @JsonProperty("MissingScopeIncludeSite")
  MISSING_SCOPE_INCLUDE_SITE,
  @JsonProperty("FederatedNotAuthorizedByProvider")
  FEDERATED_NOT_AUTHORIZED_BY_PROVIDER,
  @JsonProperty("FederatedNotAuthorizedByRelyingParty")
  FEDERATED_NOT_AUTHORIZED_BY_RELYING_PARTY,
  @JsonProperty("SessionProviderWellKnownMalformed")
  SESSION_PROVIDER_WELL_KNOWN_MALFORMED,
  @JsonProperty("SessionProviderWellKnownHasProviderOrigin")
  SESSION_PROVIDER_WELL_KNOWN_HAS_PROVIDER_ORIGIN,
  @JsonProperty("RelyingPartyWellKnownMalformed")
  RELYING_PARTY_WELL_KNOWN_MALFORMED,
  @JsonProperty("RelyingPartyWellKnownHasRelyingOrigins")
  RELYING_PARTY_WELL_KNOWN_HAS_RELYING_ORIGINS,
  @JsonProperty("InvalidFederatedSessionProviderSessionMissing")
  INVALID_FEDERATED_SESSION_PROVIDER_SESSION_MISSING,
  @JsonProperty("InvalidFederatedSessionWrongProviderOrigin")
  INVALID_FEDERATED_SESSION_WRONG_PROVIDER_ORIGIN,
  @JsonProperty("InvalidCredentialsCookieCreationTime")
  INVALID_CREDENTIALS_COOKIE_CREATION_TIME,
  @JsonProperty("InvalidCredentialsCookieName")
  INVALID_CREDENTIALS_COOKIE_NAME,
  @JsonProperty("InvalidCredentialsCookieParsing")
  INVALID_CREDENTIALS_COOKIE_PARSING,
  @JsonProperty("InvalidCredentialsCookieUnpermittedAttribute")
  INVALID_CREDENTIALS_COOKIE_UNPERMITTED_ATTRIBUTE,
  @JsonProperty("InvalidCredentialsCookieInvalidDomain")
  INVALID_CREDENTIALS_COOKIE_INVALID_DOMAIN,
  @JsonProperty("InvalidCredentialsCookiePrefix")
  INVALID_CREDENTIALS_COOKIE_PREFIX,
  @JsonProperty("InvalidScopeRulePath")
  INVALID_SCOPE_RULE_PATH,
  @JsonProperty("InvalidScopeRuleHostPattern")
  INVALID_SCOPE_RULE_HOST_PATTERN,
  @JsonProperty("ScopeRuleOriginScopedHostPatternMismatch")
  SCOPE_RULE_ORIGIN_SCOPED_HOST_PATTERN_MISMATCH,
  @JsonProperty("ScopeRuleSiteScopedHostPatternMismatch")
  SCOPE_RULE_SITE_SCOPED_HOST_PATTERN_MISMATCH,
  @JsonProperty("SigningQuotaExceeded")
  SIGNING_QUOTA_EXCEEDED,
  @JsonProperty("InvalidConfigJson")
  INVALID_CONFIG_JSON,
  @JsonProperty("InvalidFederatedSessionProviderFailedToRestoreKey")
  INVALID_FEDERATED_SESSION_PROVIDER_FAILED_TO_RESTORE_KEY,
  @JsonProperty("FailedToUnwrapKey")
  FAILED_TO_UNWRAP_KEY,
  @JsonProperty("SessionDeletedDuringRefresh")
  SESSION_DELETED_DURING_REFRESH
}
