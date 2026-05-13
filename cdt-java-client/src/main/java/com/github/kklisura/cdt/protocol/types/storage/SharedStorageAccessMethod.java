package com.github.kklisura.cdt.protocol.types.storage;

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

/** Enum of shared storage access methods. */
public enum SharedStorageAccessMethod {
  @JsonProperty("addModule")
  ADD_MODULE,
  @JsonProperty("createWorklet")
  CREATE_WORKLET,
  @JsonProperty("selectURL")
  SELECT_URL,
  @JsonProperty("run")
  RUN,
  @JsonProperty("batchUpdate")
  BATCH_UPDATE,
  @JsonProperty("set")
  SET,
  @JsonProperty("append")
  APPEND,
  @JsonProperty("delete")
  DELETE,
  @JsonProperty("clear")
  CLEAR,
  @JsonProperty("get")
  GET,
  @JsonProperty("keys")
  KEYS,
  @JsonProperty("values")
  VALUES,
  @JsonProperty("entries")
  ENTRIES,
  @JsonProperty("length")
  LENGTH,
  @JsonProperty("remainingBudget")
  REMAINING_BUDGET
}
