/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.config;

import java.util.Collections;

import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter;

import com.ibm.mq.jakarta.jms.MQConnectionFactory;
import com.ibm.mq.spring.boot.MQConfigurationProperties;
import com.ibm.mq.spring.boot.MQConnectionFactoryFactory;

import jakarta.jms.ConnectionFactory;

/**
 * External MQ Configuration
 */
@Configuration
public class ExtQueueConfiguration {

	@Value("${uae.gateway.external.mq.queueManager}")
	private String mqManager;

	@Value("${uae.gateway.external.mq.connName}")
	private String connectionName;

	/**
	 * @param qManager
	 * @param qChannel
	 * @param qConnectionName
	 * @return MQConfigurationProperties
	 */
	@Bean(name = "extMqConfigurationProperties")
	public MQConfigurationProperties mqConfigurationProperties(
			@Value("${uae.gateway.external.mq.queueManager}") final String qManager,
			@Value("${uae.gateway.external.mq.channel}") final String qChannel,
			@Value("${uae.gateway.external.mq.connName}") final String qConnectionName) {

		MQConfigurationProperties mqProps = new MQConfigurationProperties();
		mqProps.setQueueManager(qManager);
		mqProps.setChannel(qChannel);
		mqProps.setConnName(qConnectionName);
		return mqProps;
	}

	/**
	 * @param extMqConfigurationProperties
	 * @return MQConnectionFactoryFactory
	 */
	@Bean(name = "extMqConnectionFactoryFactory")
	public MQConnectionFactoryFactory mqQueueConnectionFactoryFactory(
			@Qualifier("extMqConfigurationProperties") final MQConfigurationProperties extMqConfigurationProperties) {
		return new MQConnectionFactoryFactory(extMqConfigurationProperties, Collections.emptyList());
	}

	/**
	 * @param connFactory
	 * @return JmsTransactionManager
	 */
	@Bean
	public JmsTransactionManager transactionManagerExt(
			@Qualifier("extMqSecuredConnectionFactory") final ConnectionFactory connFactory) {
		JmsTransactionManager transactionManager = new JmsTransactionManager();
		transactionManager.setConnectionFactory(connFactory);
		return transactionManager;
	}

	/**
	 * @param extMqConnectionFactoryFactory
	 * @return MQConnectionFactory
	 */
	@Bean(name = "extMqConnectionFactory")
	public MQConnectionFactory mqQueueConnectionFactory(
			@Qualifier("extMqConnectionFactoryFactory") final MQConnectionFactoryFactory extMqConnectionFactoryFactory) {
		return extMqConnectionFactoryFactory.createConnectionFactory(MQConnectionFactory.class);
	}

	/**
	 * @param extMqConnectionFactory
	 * @param username
	 * @param password
	 * @return UserCredentialsConnectionFactoryAdapter
	 */
	@Bean(name = "extMqSecuredConnectionFactory")
	public UserCredentialsConnectionFactoryAdapter extMqSecuredConnectionFactory(
			@Qualifier("extMqConnectionFactory") final MQConnectionFactory extMqConnectionFactory,
			@Value("${uae.gateway.external.mq.user}") final String username,
			@Value("${uae.gateway.external.mq.password}") final String password) {
		UserCredentialsConnectionFactoryAdapter adapter = new UserCredentialsConnectionFactoryAdapter();
		adapter.setTargetConnectionFactory(extMqConnectionFactory);
		adapter.setUsername(username);
		adapter.setPassword(password);
		return adapter;
	}

	/**
	 * @param targetConnectionFactory
	 * @return CachingConnectionFactory
	 */
	@Bean(name = "extRequestConnectionFactory")
	public CachingConnectionFactory gatewayServiceRequestConnectionFactory(
			@Qualifier("extMqSecuredConnectionFactory") final ConnectionFactory targetConnectionFactory) {
		CachingConnectionFactory factory = new CachingConnectionFactory(targetConnectionFactory);
		factory.setReconnectOnException(true);
		factory.setCacheConsumers(true);
		factory.setSessionCacheSize(1);
		return factory;
	}

	/**
	 * @param extRequestConnectionFactory
	 * @return JmsComponent
	 */
	@Bean(name = "extJms")
	public JmsComponent jms(
			@Qualifier("extRequestConnectionFactory") final ConnectionFactory extRequestConnectionFactory) {
		JmsComponent jms = new JmsComponent();
		jms.setConnectionFactory(extRequestConnectionFactory);
		jms.setDeliveryMode(1);
		jms.setCacheLevelName("CACHE_CONSUMER");
		jms.setExplicitQosEnabled(true);
		return jms;
	}
}
