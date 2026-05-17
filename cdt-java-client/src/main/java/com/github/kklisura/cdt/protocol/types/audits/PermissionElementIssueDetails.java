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

import com.github.kklisura.cdt.protocol.support.annotations.Optional;

/** This issue warns about improper usage of the &lt;permission&gt; element. */
public class PermissionElementIssueDetails {

  private PermissionElementIssueType issueType;

  @Optional private String type;

  @Optional private Integer nodeId;

  @Optional private Boolean isWarning;

  @Optional private String permissionName;

  @Optional private String occluderNodeInfo;

  @Optional private String occluderParentNodeInfo;

  @Optional private String disableReason;

  public PermissionElementIssueType getIssueType() {
    return issueType;
  }

  public void setIssueType(PermissionElementIssueType issueType) {
    this.issueType = issueType;
  }

  /** The value of the type attribute. */
  public String getType() {
    return type;
  }

  /** The value of the type attribute. */
  public void setType(String type) {
    this.type = type;
  }

  /** The node ID of the &lt;permission&gt; element. */
  public Integer getNodeId() {
    return nodeId;
  }

  /** The node ID of the &lt;permission&gt; element. */
  public void setNodeId(Integer nodeId) {
    this.nodeId = nodeId;
  }

  /** True if the issue is a warning, false if it is an error. */
  public Boolean getIsWarning() {
    return isWarning;
  }

  /** True if the issue is a warning, false if it is an error. */
  public void setIsWarning(Boolean isWarning) {
    this.isWarning = isWarning;
  }

  /**
   * Fields for message construction: Used for messages that reference a specific permission name
   */
  public String getPermissionName() {
    return permissionName;
  }

  /**
   * Fields for message construction: Used for messages that reference a specific permission name
   */
  public void setPermissionName(String permissionName) {
    this.permissionName = permissionName;
  }

  /** Used for messages about occlusion */
  public String getOccluderNodeInfo() {
    return occluderNodeInfo;
  }

  /** Used for messages about occlusion */
  public void setOccluderNodeInfo(String occluderNodeInfo) {
    this.occluderNodeInfo = occluderNodeInfo;
  }

  /** Used for messages about occluder's parent */
  public String getOccluderParentNodeInfo() {
    return occluderParentNodeInfo;
  }

  /** Used for messages about occluder's parent */
  public void setOccluderParentNodeInfo(String occluderParentNodeInfo) {
    this.occluderParentNodeInfo = occluderParentNodeInfo;
  }

  /** Used for messages about activation disabled reason */
  public String getDisableReason() {
    return disableReason;
  }

  /** Used for messages about activation disabled reason */
  public void setDisableReason(String disableReason) {
    this.disableReason = disableReason;
  }
}
