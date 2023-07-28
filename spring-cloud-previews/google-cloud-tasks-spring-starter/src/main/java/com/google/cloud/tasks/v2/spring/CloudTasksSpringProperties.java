/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.tasks.v2.spring;

import com.google.api.core.BetaApi;
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import com.google.cloud.spring.core.Retry;
import javax.annotation.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** Provides default property values for CloudTasks client bean */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties("com.google.cloud.tasks.v2.cloud-tasks")
public class CloudTasksSpringProperties implements CredentialsSupplier {
  /** OAuth2 credentials to authenticate and authorize calls to Google Cloud Client Libraries. */
  @NestedConfigurationProperty
  private final Credentials credentials =
      new Credentials("https://www.googleapis.com/auth/cloud-platform");
  /** Quota project to use for billing. */
  private String quotaProjectId;
  /** Number of threads used for executors. */
  private Integer executorThreadCount;
  /** Allow override of default transport channel provider to use REST instead of gRPC. */
  private boolean useRest = false;
  /** Allow override of retry settings at service level, applying to all of its RPC methods. */
  @NestedConfigurationProperty private Retry retry;
  /**
   * Allow override of retry settings at method-level for listQueues. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listQueuesRetry;
  /**
   * Allow override of retry settings at method-level for getQueue. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getQueueRetry;
  /**
   * Allow override of retry settings at method-level for createQueue. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createQueueRetry;
  /**
   * Allow override of retry settings at method-level for updateQueue. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateQueueRetry;
  /**
   * Allow override of retry settings at method-level for deleteQueue. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteQueueRetry;
  /**
   * Allow override of retry settings at method-level for purgeQueue. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry purgeQueueRetry;
  /**
   * Allow override of retry settings at method-level for pauseQueue. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry pauseQueueRetry;
  /**
   * Allow override of retry settings at method-level for resumeQueue. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry resumeQueueRetry;
  /**
   * Allow override of retry settings at method-level for getIamPolicy. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getIamPolicyRetry;
  /**
   * Allow override of retry settings at method-level for setIamPolicy. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry setIamPolicyRetry;
  /**
   * Allow override of retry settings at method-level for testIamPermissions. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry testIamPermissionsRetry;
  /**
   * Allow override of retry settings at method-level for listTasks. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listTasksRetry;
  /**
   * Allow override of retry settings at method-level for getTask. If defined, this takes precedence
   * over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getTaskRetry;
  /**
   * Allow override of retry settings at method-level for createTask. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createTaskRetry;
  /**
   * Allow override of retry settings at method-level for deleteTask. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteTaskRetry;
  /**
   * Allow override of retry settings at method-level for runTask. If defined, this takes precedence
   * over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry runTaskRetry;
  /**
   * Allow override of retry settings at method-level for listLocations. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listLocationsRetry;
  /**
   * Allow override of retry settings at method-level for getLocation. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getLocationRetry;

  @Override
  public Credentials getCredentials() {
    return this.credentials;
  }

  public String getQuotaProjectId() {
    return this.quotaProjectId;
  }

  public void setQuotaProjectId(String quotaProjectId) {
    this.quotaProjectId = quotaProjectId;
  }

  public boolean getUseRest() {
    return this.useRest;
  }

  public void setUseRest(boolean useRest) {
    this.useRest = useRest;
  }

  public Integer getExecutorThreadCount() {
    return this.executorThreadCount;
  }

  public void setExecutorThreadCount(Integer executorThreadCount) {
    this.executorThreadCount = executorThreadCount;
  }

  public Retry getRetry() {
    return this.retry;
  }

  public void setRetry(Retry retry) {
    this.retry = retry;
  }

  public Retry getListQueuesRetry() {
    return this.listQueuesRetry;
  }

  public void setListQueuesRetry(Retry listQueuesRetry) {
    this.listQueuesRetry = listQueuesRetry;
  }

  public Retry getGetQueueRetry() {
    return this.getQueueRetry;
  }

  public void setGetQueueRetry(Retry getQueueRetry) {
    this.getQueueRetry = getQueueRetry;
  }

  public Retry getCreateQueueRetry() {
    return this.createQueueRetry;
  }

  public void setCreateQueueRetry(Retry createQueueRetry) {
    this.createQueueRetry = createQueueRetry;
  }

  public Retry getUpdateQueueRetry() {
    return this.updateQueueRetry;
  }

  public void setUpdateQueueRetry(Retry updateQueueRetry) {
    this.updateQueueRetry = updateQueueRetry;
  }

  public Retry getDeleteQueueRetry() {
    return this.deleteQueueRetry;
  }

  public void setDeleteQueueRetry(Retry deleteQueueRetry) {
    this.deleteQueueRetry = deleteQueueRetry;
  }

  public Retry getPurgeQueueRetry() {
    return this.purgeQueueRetry;
  }

  public void setPurgeQueueRetry(Retry purgeQueueRetry) {
    this.purgeQueueRetry = purgeQueueRetry;
  }

  public Retry getPauseQueueRetry() {
    return this.pauseQueueRetry;
  }

  public void setPauseQueueRetry(Retry pauseQueueRetry) {
    this.pauseQueueRetry = pauseQueueRetry;
  }

  public Retry getResumeQueueRetry() {
    return this.resumeQueueRetry;
  }

  public void setResumeQueueRetry(Retry resumeQueueRetry) {
    this.resumeQueueRetry = resumeQueueRetry;
  }

  public Retry getGetIamPolicyRetry() {
    return this.getIamPolicyRetry;
  }

  public void setGetIamPolicyRetry(Retry getIamPolicyRetry) {
    this.getIamPolicyRetry = getIamPolicyRetry;
  }

  public Retry getSetIamPolicyRetry() {
    return this.setIamPolicyRetry;
  }

  public void setSetIamPolicyRetry(Retry setIamPolicyRetry) {
    this.setIamPolicyRetry = setIamPolicyRetry;
  }

  public Retry getTestIamPermissionsRetry() {
    return this.testIamPermissionsRetry;
  }

  public void setTestIamPermissionsRetry(Retry testIamPermissionsRetry) {
    this.testIamPermissionsRetry = testIamPermissionsRetry;
  }

  public Retry getListTasksRetry() {
    return this.listTasksRetry;
  }

  public void setListTasksRetry(Retry listTasksRetry) {
    this.listTasksRetry = listTasksRetry;
  }

  public Retry getGetTaskRetry() {
    return this.getTaskRetry;
  }

  public void setGetTaskRetry(Retry getTaskRetry) {
    this.getTaskRetry = getTaskRetry;
  }

  public Retry getCreateTaskRetry() {
    return this.createTaskRetry;
  }

  public void setCreateTaskRetry(Retry createTaskRetry) {
    this.createTaskRetry = createTaskRetry;
  }

  public Retry getDeleteTaskRetry() {
    return this.deleteTaskRetry;
  }

  public void setDeleteTaskRetry(Retry deleteTaskRetry) {
    this.deleteTaskRetry = deleteTaskRetry;
  }

  public Retry getRunTaskRetry() {
    return this.runTaskRetry;
  }

  public void setRunTaskRetry(Retry runTaskRetry) {
    this.runTaskRetry = runTaskRetry;
  }

  public Retry getListLocationsRetry() {
    return this.listLocationsRetry;
  }

  public void setListLocationsRetry(Retry listLocationsRetry) {
    this.listLocationsRetry = listLocationsRetry;
  }

  public Retry getGetLocationRetry() {
    return this.getLocationRetry;
  }

  public void setGetLocationRetry(Retry getLocationRetry) {
    this.getLocationRetry = getLocationRetry;
  }
}
