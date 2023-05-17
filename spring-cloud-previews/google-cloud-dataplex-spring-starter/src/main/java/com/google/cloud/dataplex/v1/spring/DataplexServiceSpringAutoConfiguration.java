/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.dataplex.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.dataplex.v1.DataplexServiceClient;
import com.google.cloud.dataplex.v1.DataplexServiceSettings;
import com.google.cloud.spring.autoconfigure.core.GcpContextAutoConfiguration;
import com.google.cloud.spring.core.DefaultCredentialsProvider;
import com.google.cloud.spring.core.Retry;
import com.google.cloud.spring.core.util.RetryUtil;
import java.io.IOException;
import java.util.Collections;
import javax.annotation.Generated;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Auto-configuration for {@link DataplexServiceClient}.
 *
 * <p>Provides auto-configuration for Spring Boot
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default transport provider is used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@AutoConfiguration
@AutoConfigureAfter(GcpContextAutoConfiguration.class)
@ConditionalOnClass(DataplexServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.dataplex.v1.dataplex-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(DataplexServiceSpringProperties.class)
public class DataplexServiceSpringAutoConfiguration {
  private final DataplexServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(DataplexServiceSpringAutoConfiguration.class);

  protected DataplexServiceSpringAutoConfiguration(
      DataplexServiceSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from DataplexService-specific configuration");
      }
      this.credentialsProvider =
          ((CredentialsProvider) new DefaultCredentialsProvider(this.clientProperties));
    } else {
      this.credentialsProvider = credentialsProvider;
    }
  }

  /**
   * Provides a default transport channel provider bean. The default is gRPC and will default to it
   * unless the useRest option is supported and provided to use HTTP transport instead
   *
   * @return a default transport channel provider.
   */
  @Bean
  @ConditionalOnMissingBean(name = "defaultDataplexServiceTransportChannelProvider")
  public TransportChannelProvider defaultDataplexServiceTransportChannelProvider() {
    if (this.clientProperties.getUseRest()) {
      return DataplexServiceSettings.defaultHttpJsonTransportProviderBuilder().build();
    }
    return DataplexServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a DataplexServiceSettings bean configured to use a DefaultCredentialsProvider and the
   * client library's default transport channel provider
   * (defaultDataplexServiceTransportChannelProvider()). It also configures the quota project ID and
   * executor thread count, if provided through properties.
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in DataplexServiceSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   *
   * @param defaultTransportChannelProvider TransportChannelProvider to use in the settings.
   * @return a {@link DataplexServiceSettings} bean configured with {@link TransportChannelProvider}
   *     bean.
   */
  @Bean
  @ConditionalOnMissingBean
  public DataplexServiceSettings dataplexServiceSettings(
      @Qualifier("defaultDataplexServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    DataplexServiceSettings.Builder clientSettingsBuilder;
    if (this.clientProperties.getUseRest()) {
      clientSettingsBuilder = DataplexServiceSettings.newHttpJsonBuilder();
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using REST (HTTP/JSON) transport.");
      }
    } else {
      clientSettingsBuilder = DataplexServiceSettings.newBuilder();
    }
    clientSettingsBuilder
        .setCredentialsProvider(this.credentialsProvider)
        .setTransportChannelProvider(defaultTransportChannelProvider)
        .setHeaderProvider(this.userAgentHeaderProvider());
    if (this.clientProperties.getQuotaProjectId() != null) {
      clientSettingsBuilder.setQuotaProjectId(this.clientProperties.getQuotaProjectId());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Quota project id set to "
                + this.clientProperties.getQuotaProjectId()
                + ", this overrides project id from credentials.");
      }
    }
    if (this.clientProperties.getExecutorThreadCount() != null) {
      ExecutorProvider executorProvider =
          DataplexServiceSettings.defaultExecutorProviderBuilder()
              .setExecutorThreadCount(this.clientProperties.getExecutorThreadCount())
              .build();
      clientSettingsBuilder.setBackgroundExecutorProvider(executorProvider);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Background executor thread count is "
                + this.clientProperties.getExecutorThreadCount());
      }
    }
    Retry serviceRetry = clientProperties.getRetry();
    if (serviceRetry != null) {
      RetrySettings listLakesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLakesSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listLakesSettings().setRetrySettings(listLakesRetrySettings);

      RetrySettings getLakeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLakeSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getLakeSettings().setRetrySettings(getLakeRetrySettings);

      RetrySettings listLakeActionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLakeActionsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listLakeActionsSettings()
          .setRetrySettings(listLakeActionsRetrySettings);

      RetrySettings listZonesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listZonesSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listZonesSettings().setRetrySettings(listZonesRetrySettings);

      RetrySettings getZoneRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getZoneSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getZoneSettings().setRetrySettings(getZoneRetrySettings);

      RetrySettings listZoneActionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listZoneActionsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listZoneActionsSettings()
          .setRetrySettings(listZoneActionsRetrySettings);

      RetrySettings listAssetsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listAssetsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listAssetsSettings().setRetrySettings(listAssetsRetrySettings);

      RetrySettings getAssetRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getAssetSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getAssetSettings().setRetrySettings(getAssetRetrySettings);

      RetrySettings listAssetActionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listAssetActionsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listAssetActionsSettings()
          .setRetrySettings(listAssetActionsRetrySettings);

      RetrySettings listTasksRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listTasksSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listTasksSettings().setRetrySettings(listTasksRetrySettings);

      RetrySettings getTaskRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getTaskSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getTaskSettings().setRetrySettings(getTaskRetrySettings);

      RetrySettings listJobsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listJobsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listJobsSettings().setRetrySettings(listJobsRetrySettings);

      RetrySettings runTaskRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.runTaskSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.runTaskSettings().setRetrySettings(runTaskRetrySettings);

      RetrySettings getJobRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getJobSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getJobSettings().setRetrySettings(getJobRetrySettings);

      RetrySettings cancelJobRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.cancelJobSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.cancelJobSettings().setRetrySettings(cancelJobRetrySettings);

      RetrySettings listEnvironmentsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listEnvironmentsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listEnvironmentsSettings()
          .setRetrySettings(listEnvironmentsRetrySettings);

      RetrySettings getEnvironmentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getEnvironmentSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getEnvironmentSettings().setRetrySettings(getEnvironmentRetrySettings);

      RetrySettings listSessionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listSessionsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listSessionsSettings().setRetrySettings(listSessionsRetrySettings);

      RetrySettings listLocationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLocationsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listLocationsSettings().setRetrySettings(listLocationsRetrySettings);

      RetrySettings getLocationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLocationSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getLocationSettings().setRetrySettings(getLocationRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry listLakesRetry = clientProperties.getListLakesRetry();
    if (listLakesRetry != null) {
      RetrySettings listLakesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLakesSettings().getRetrySettings(), listLakesRetry);
      clientSettingsBuilder.listLakesSettings().setRetrySettings(listLakesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listLakes from properties.");
      }
    }
    Retry getLakeRetry = clientProperties.getGetLakeRetry();
    if (getLakeRetry != null) {
      RetrySettings getLakeRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLakeSettings().getRetrySettings(), getLakeRetry);
      clientSettingsBuilder.getLakeSettings().setRetrySettings(getLakeRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getLake from properties.");
      }
    }
    Retry listLakeActionsRetry = clientProperties.getListLakeActionsRetry();
    if (listLakeActionsRetry != null) {
      RetrySettings listLakeActionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLakeActionsSettings().getRetrySettings(),
              listLakeActionsRetry);
      clientSettingsBuilder
          .listLakeActionsSettings()
          .setRetrySettings(listLakeActionsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listLakeActions from properties.");
      }
    }
    Retry listZonesRetry = clientProperties.getListZonesRetry();
    if (listZonesRetry != null) {
      RetrySettings listZonesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listZonesSettings().getRetrySettings(), listZonesRetry);
      clientSettingsBuilder.listZonesSettings().setRetrySettings(listZonesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listZones from properties.");
      }
    }
    Retry getZoneRetry = clientProperties.getGetZoneRetry();
    if (getZoneRetry != null) {
      RetrySettings getZoneRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getZoneSettings().getRetrySettings(), getZoneRetry);
      clientSettingsBuilder.getZoneSettings().setRetrySettings(getZoneRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getZone from properties.");
      }
    }
    Retry listZoneActionsRetry = clientProperties.getListZoneActionsRetry();
    if (listZoneActionsRetry != null) {
      RetrySettings listZoneActionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listZoneActionsSettings().getRetrySettings(),
              listZoneActionsRetry);
      clientSettingsBuilder
          .listZoneActionsSettings()
          .setRetrySettings(listZoneActionsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listZoneActions from properties.");
      }
    }
    Retry listAssetsRetry = clientProperties.getListAssetsRetry();
    if (listAssetsRetry != null) {
      RetrySettings listAssetsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listAssetsSettings().getRetrySettings(), listAssetsRetry);
      clientSettingsBuilder.listAssetsSettings().setRetrySettings(listAssetsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listAssets from properties.");
      }
    }
    Retry getAssetRetry = clientProperties.getGetAssetRetry();
    if (getAssetRetry != null) {
      RetrySettings getAssetRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getAssetSettings().getRetrySettings(), getAssetRetry);
      clientSettingsBuilder.getAssetSettings().setRetrySettings(getAssetRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getAsset from properties.");
      }
    }
    Retry listAssetActionsRetry = clientProperties.getListAssetActionsRetry();
    if (listAssetActionsRetry != null) {
      RetrySettings listAssetActionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listAssetActionsSettings().getRetrySettings(),
              listAssetActionsRetry);
      clientSettingsBuilder
          .listAssetActionsSettings()
          .setRetrySettings(listAssetActionsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listAssetActions from properties.");
      }
    }
    Retry listTasksRetry = clientProperties.getListTasksRetry();
    if (listTasksRetry != null) {
      RetrySettings listTasksRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listTasksSettings().getRetrySettings(), listTasksRetry);
      clientSettingsBuilder.listTasksSettings().setRetrySettings(listTasksRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listTasks from properties.");
      }
    }
    Retry getTaskRetry = clientProperties.getGetTaskRetry();
    if (getTaskRetry != null) {
      RetrySettings getTaskRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getTaskSettings().getRetrySettings(), getTaskRetry);
      clientSettingsBuilder.getTaskSettings().setRetrySettings(getTaskRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getTask from properties.");
      }
    }
    Retry listJobsRetry = clientProperties.getListJobsRetry();
    if (listJobsRetry != null) {
      RetrySettings listJobsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listJobsSettings().getRetrySettings(), listJobsRetry);
      clientSettingsBuilder.listJobsSettings().setRetrySettings(listJobsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listJobs from properties.");
      }
    }
    Retry runTaskRetry = clientProperties.getRunTaskRetry();
    if (runTaskRetry != null) {
      RetrySettings runTaskRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.runTaskSettings().getRetrySettings(), runTaskRetry);
      clientSettingsBuilder.runTaskSettings().setRetrySettings(runTaskRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for runTask from properties.");
      }
    }
    Retry getJobRetry = clientProperties.getGetJobRetry();
    if (getJobRetry != null) {
      RetrySettings getJobRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getJobSettings().getRetrySettings(), getJobRetry);
      clientSettingsBuilder.getJobSettings().setRetrySettings(getJobRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getJob from properties.");
      }
    }
    Retry cancelJobRetry = clientProperties.getCancelJobRetry();
    if (cancelJobRetry != null) {
      RetrySettings cancelJobRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.cancelJobSettings().getRetrySettings(), cancelJobRetry);
      clientSettingsBuilder.cancelJobSettings().setRetrySettings(cancelJobRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for cancelJob from properties.");
      }
    }
    Retry listEnvironmentsRetry = clientProperties.getListEnvironmentsRetry();
    if (listEnvironmentsRetry != null) {
      RetrySettings listEnvironmentsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listEnvironmentsSettings().getRetrySettings(),
              listEnvironmentsRetry);
      clientSettingsBuilder
          .listEnvironmentsSettings()
          .setRetrySettings(listEnvironmentsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listEnvironments from properties.");
      }
    }
    Retry getEnvironmentRetry = clientProperties.getGetEnvironmentRetry();
    if (getEnvironmentRetry != null) {
      RetrySettings getEnvironmentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getEnvironmentSettings().getRetrySettings(),
              getEnvironmentRetry);
      clientSettingsBuilder.getEnvironmentSettings().setRetrySettings(getEnvironmentRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getEnvironment from properties.");
      }
    }
    Retry listSessionsRetry = clientProperties.getListSessionsRetry();
    if (listSessionsRetry != null) {
      RetrySettings listSessionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listSessionsSettings().getRetrySettings(), listSessionsRetry);
      clientSettingsBuilder.listSessionsSettings().setRetrySettings(listSessionsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listSessions from properties.");
      }
    }
    Retry listLocationsRetry = clientProperties.getListLocationsRetry();
    if (listLocationsRetry != null) {
      RetrySettings listLocationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLocationsSettings().getRetrySettings(), listLocationsRetry);
      clientSettingsBuilder.listLocationsSettings().setRetrySettings(listLocationsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listLocations from properties.");
      }
    }
    Retry getLocationRetry = clientProperties.getGetLocationRetry();
    if (getLocationRetry != null) {
      RetrySettings getLocationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLocationSettings().getRetrySettings(), getLocationRetry);
      clientSettingsBuilder.getLocationSettings().setRetrySettings(getLocationRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getLocation from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  /**
   * Provides a DataplexServiceClient bean configured with DataplexServiceSettings.
   *
   * @param dataplexServiceSettings settings to configure an instance of client bean.
   * @return a {@link DataplexServiceClient} bean configured with {@link DataplexServiceSettings}
   */
  @Bean
  @ConditionalOnMissingBean
  public DataplexServiceClient dataplexServiceClient(
      DataplexServiceSettings dataplexServiceSettings) throws IOException {
    return DataplexServiceClient.create(dataplexServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-dataplex-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
