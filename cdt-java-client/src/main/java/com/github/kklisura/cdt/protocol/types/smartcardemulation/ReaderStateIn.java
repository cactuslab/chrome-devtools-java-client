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

public class ReaderStateIn {

  private String reader;

  private ReaderStateFlags currentState;

  private Integer currentInsertionCount;

  public String getReader() {
    return reader;
  }

  public void setReader(String reader) {
    this.reader = reader;
  }

  public ReaderStateFlags getCurrentState() {
    return currentState;
  }

  public void setCurrentState(ReaderStateFlags currentState) {
    this.currentState = currentState;
  }

  public Integer getCurrentInsertionCount() {
    return currentInsertionCount;
  }

  public void setCurrentInsertionCount(Integer currentInsertionCount) {
    this.currentInsertionCount = currentInsertionCount;
  }
}
