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

public class PartitioningBlobURLIssueDetails {

  private String url;

  private PartitioningBlobURLInfo partitioningBlobURLInfo;

  /** The BlobURL that failed to load. */
  public String getUrl() {
    return url;
  }

  /** The BlobURL that failed to load. */
  public void setUrl(String url) {
    this.url = url;
  }

  /** Additional information about the Partitioning Blob URL issue. */
  public PartitioningBlobURLInfo getPartitioningBlobURLInfo() {
    return partitioningBlobURLInfo;
  }

  /** Additional information about the Partitioning Blob URL issue. */
  public void setPartitioningBlobURLInfo(PartitioningBlobURLInfo partitioningBlobURLInfo) {
    this.partitioningBlobURLInfo = partitioningBlobURLInfo;
  }
}
