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

package com.google.cloud.gaming.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.gaming.v1.GameServerDeploymentsServiceClient;
import com.google.cloud.gaming.v1.GameServerDeploymentsServiceSettings;
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
 * Auto-configuration for {@link GameServerDeploymentsServiceClient}.
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
@ConditionalOnClass(GameServerDeploymentsServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.gaming.v1.game-server-deployments-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(GameServerDeploymentsServiceSpringProperties.class)
public class GameServerDeploymentsServiceSpringAutoConfiguration {
  private final GameServerDeploymentsServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER =
      LogFactory.getLog(GameServerDeploymentsServiceSpringAutoConfiguration.class);

  protected GameServerDeploymentsServiceSpringAutoConfiguration(
      GameServerDeploymentsServiceSpringProperties clientProperties,
      CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from GameServerDeploymentsService-specific configuration");
      }
      this.credentialsProvider =
          ((CredentialsProvider) new DefaultCredentialsProvider(this.clientProperties));
    } else {
      this.credentialsProvider = credentialsProvider;
    }
  }

  /**
   * Provides a default transport channel provider bean. The default is gRPC and will default to it
   * unless the useRest option is provided to use HTTP transport instead
   *
   * @return a default transport channel provider.
   */
  @Bean
  @ConditionalOnMissingBean(name = "defaultGameServerDeploymentsServiceTransportChannelProvider")
  public TransportChannelProvider defaultGameServerDeploymentsServiceTransportChannelProvider() {
    if (this.clientProperties.getUseRest()) {
      return GameServerDeploymentsServiceSettings.defaultHttpJsonTransportProviderBuilder().build();
    }
    return GameServerDeploymentsServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a GameServerDeploymentsServiceSettings bean configured to use the default credentials
   * provider (obtained with gameServerDeploymentsServiceCredentials()) and its default transport
   * channel provider (defaultGameServerDeploymentsServiceTransportChannelProvider()). It also
   * configures the quota project ID if provided. It will configure an executor provider in case
   * there is more than one thread configured in the client
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in GameServerDeploymentsServiceSpringProperties. Method-level properties will take precedence
   * over service-level properties if available, and client library defaults will be used if neither
   * are specified.
   *
   * @param defaultTransportChannelProvider TransportChannelProvider to use in the settings.
   * @return a {@link GameServerDeploymentsServiceSettings} bean configured with {@link
   *     TransportChannelProvider} bean.
   */
  @Bean
  @ConditionalOnMissingBean
  public GameServerDeploymentsServiceSettings gameServerDeploymentsServiceSettings(
      @Qualifier("defaultGameServerDeploymentsServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    GameServerDeploymentsServiceSettings.Builder clientSettingsBuilder;
    if (this.clientProperties.getUseRest()) {
      clientSettingsBuilder = GameServerDeploymentsServiceSettings.newHttpJsonBuilder();
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using REST (HTTP/JSON) transport.");
      }
    } else {
      clientSettingsBuilder = GameServerDeploymentsServiceSettings.newBuilder();
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
          GameServerDeploymentsServiceSettings.defaultExecutorProviderBuilder()
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
      RetrySettings listGameServerDeploymentsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listGameServerDeploymentsSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .listGameServerDeploymentsSettings()
          .setRetrySettings(listGameServerDeploymentsRetrySettings);

      RetrySettings getGameServerDeploymentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getGameServerDeploymentSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .getGameServerDeploymentSettings()
          .setRetrySettings(getGameServerDeploymentRetrySettings);

      RetrySettings getGameServerDeploymentRolloutRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getGameServerDeploymentRolloutSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .getGameServerDeploymentRolloutSettings()
          .setRetrySettings(getGameServerDeploymentRolloutRetrySettings);

      RetrySettings previewGameServerDeploymentRolloutRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.previewGameServerDeploymentRolloutSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .previewGameServerDeploymentRolloutSettings()
          .setRetrySettings(previewGameServerDeploymentRolloutRetrySettings);

      RetrySettings fetchDeploymentStateRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.fetchDeploymentStateSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .fetchDeploymentStateSettings()
          .setRetrySettings(fetchDeploymentStateRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry listGameServerDeploymentsRetry = clientProperties.getListGameServerDeploymentsRetry();
    if (listGameServerDeploymentsRetry != null) {
      RetrySettings listGameServerDeploymentsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listGameServerDeploymentsSettings().getRetrySettings(),
              listGameServerDeploymentsRetry);
      clientSettingsBuilder
          .listGameServerDeploymentsSettings()
          .setRetrySettings(listGameServerDeploymentsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listGameServerDeployments from properties.");
      }
    }
    Retry getGameServerDeploymentRetry = clientProperties.getGetGameServerDeploymentRetry();
    if (getGameServerDeploymentRetry != null) {
      RetrySettings getGameServerDeploymentRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getGameServerDeploymentSettings().getRetrySettings(),
              getGameServerDeploymentRetry);
      clientSettingsBuilder
          .getGameServerDeploymentSettings()
          .setRetrySettings(getGameServerDeploymentRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getGameServerDeployment from properties.");
      }
    }
    Retry getGameServerDeploymentRolloutRetry =
        clientProperties.getGetGameServerDeploymentRolloutRetry();
    if (getGameServerDeploymentRolloutRetry != null) {
      RetrySettings getGameServerDeploymentRolloutRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getGameServerDeploymentRolloutSettings().getRetrySettings(),
              getGameServerDeploymentRolloutRetry);
      clientSettingsBuilder
          .getGameServerDeploymentRolloutSettings()
          .setRetrySettings(getGameServerDeploymentRolloutRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getGameServerDeploymentRollout from properties.");
      }
    }
    Retry previewGameServerDeploymentRolloutRetry =
        clientProperties.getPreviewGameServerDeploymentRolloutRetry();
    if (previewGameServerDeploymentRolloutRetry != null) {
      RetrySettings previewGameServerDeploymentRolloutRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.previewGameServerDeploymentRolloutSettings().getRetrySettings(),
              previewGameServerDeploymentRolloutRetry);
      clientSettingsBuilder
          .previewGameServerDeploymentRolloutSettings()
          .setRetrySettings(previewGameServerDeploymentRolloutRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for previewGameServerDeploymentRollout from properties.");
      }
    }
    Retry fetchDeploymentStateRetry = clientProperties.getFetchDeploymentStateRetry();
    if (fetchDeploymentStateRetry != null) {
      RetrySettings fetchDeploymentStateRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.fetchDeploymentStateSettings().getRetrySettings(),
              fetchDeploymentStateRetry);
      clientSettingsBuilder
          .fetchDeploymentStateSettings()
          .setRetrySettings(fetchDeploymentStateRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for fetchDeploymentState from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  /**
   * Provides a GameServerDeploymentsServiceClient bean configured with
   * GameServerDeploymentsServiceSettings.
   *
   * @param gameServerDeploymentsServiceSettings settings to configure an instance of client bean.
   * @return a {@link GameServerDeploymentsServiceClient} bean configured with {@link
   *     GameServerDeploymentsServiceSettings}
   */
  @Bean
  @ConditionalOnMissingBean
  public GameServerDeploymentsServiceClient gameServerDeploymentsServiceClient(
      GameServerDeploymentsServiceSettings gameServerDeploymentsServiceSettings)
      throws IOException {
    return GameServerDeploymentsServiceClient.create(gameServerDeploymentsServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-game-server-deployments-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}