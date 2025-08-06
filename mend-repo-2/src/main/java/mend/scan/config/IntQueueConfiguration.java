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
import org.springframework.jms.core.JmsTemplate;

import com.ibm.mq.jakarta.jms.MQConnectionFactory;
import com.ibm.mq.spring.boot.MQConfigurationProperties;
import com.ibm.mq.spring.boot.MQConnectionFactoryFactory;

import jakarta.jms.ConnectionFactory;

/**
 * Internal Queue Configuration
 */
@Configuration
public class IntQueueConfiguration {
	
    /**
     * @param qManager
     * @param qChannel
     * @param qConnectionName
     * @return MQConfigurationProperties
     */
    @Bean(name="mqConfigurationProperties")
    public MQConfigurationProperties mqConfigurationProperties(
            @Value("${uae.gateway.internal.mq.queueManager}") final String qManager,
            @Value("${uae.gateway.internal.mq.channel}") final String qChannel,
            @Value("${uae.gateway.internal.mq.connName}") final String qConnectionName) {
        
        MQConfigurationProperties mqProps = new MQConfigurationProperties();
        mqProps.setQueueManager(qManager);
        mqProps.setChannel(qChannel);
        mqProps.setConnName(qConnectionName);
        return mqProps;
    }
    
    
    /**
     * @param mqConfigurationProperties
     * @return MQConnectionFactoryFactory
     */
    @Bean(name= "mqConnectionFactoryFactory")
    public MQConnectionFactoryFactory mqQueueConnectionFactoryFactory(
            @Qualifier("mqConfigurationProperties") final MQConfigurationProperties mqConfigurationProperties) {
        
        return new MQConnectionFactoryFactory(mqConfigurationProperties, Collections.emptyList());
    }
    
    /**
     * @param connFactory
     * @return JmsTransactionManager
     */
    @Bean
    public JmsTransactionManager transactionManager(@Qualifier("mqSecuredConnectionFactory") final ConnectionFactory connFactory) {
        JmsTransactionManager transactionManager = new JmsTransactionManager();
        transactionManager.setConnectionFactory(connFactory);
        return transactionManager;
    }
    
    /**
     * @param mqQueueConnectionFactoryFactory
     * @return MQConnectionFactory
     */
    @Bean(name= "mqConnectionFactory")
    public MQConnectionFactory mqQueueConnectionFactory(
            @Qualifier("mqConnectionFactoryFactory") final MQConnectionFactoryFactory mqQueueConnectionFactoryFactory) {
        
        return mqQueueConnectionFactoryFactory.createConnectionFactory(MQConnectionFactory.class);
    }
    
    
    /**
     * @param mqConnectionFactory
     * @param username
     * @param password
     * @return UserCredentialsConnectionFactoryAdapter
     */
    @Bean(name = "mqSecuredConnectionFactory")
    public UserCredentialsConnectionFactoryAdapter mqSecuredConnectionFactory(
        @Qualifier("mqConnectionFactory") final MQConnectionFactory mqConnectionFactory,
        @Value("${uae.gateway.external.mq.user}") final String username,
        @Value("${uae.gateway.external.mq.password}") final String password) {
        UserCredentialsConnectionFactoryAdapter adapter = new UserCredentialsConnectionFactoryAdapter();
        adapter.setTargetConnectionFactory(mqConnectionFactory);
        adapter.setUsername(username);
        adapter.setPassword(password);
        return adapter;
    }
    
    /**
     * @param targetConnectionFactory
     * @return CachingConnectionFactory
     */
    @Bean(name = "gatewayServiceRequestConnectionFactory")
    public CachingConnectionFactory gatewayServiceRequestConnectionFactory(
        @Qualifier("mqSecuredConnectionFactory") final ConnectionFactory targetConnectionFactory) {
        CachingConnectionFactory factory = new CachingConnectionFactory(targetConnectionFactory);
        factory.setReconnectOnException(true);
        factory.setCacheConsumers(true);
        factory.setSessionCacheSize(1);
        return factory;
    }
    
    /**
     * @param gatewayServiceRequestConnectionFactory
     * @return JmsComponent
     */
    @Bean(name = "intJms")
    public JmsComponent jms(
        @Qualifier("gatewayServiceRequestConnectionFactory") final ConnectionFactory gatewayServiceRequestConnectionFactory) {
        JmsComponent jms = new JmsComponent();
        jms.setConnectionFactory(gatewayServiceRequestConnectionFactory);
        jms.setDeliveryMode(1);
        jms.setCacheLevelName("CACHE_CONSUMER");
        jms.setExplicitQosEnabled(true);
        return jms;
    }
    
    /**
     * @param gatewayServiceRequestConnectionFactory
     * @return JmsTemplate
     */
    @Bean(name = "jmsTemplate")
    public JmsTemplate jmsTemplate(@Qualifier("gatewayServiceRequestConnectionFactory") final ConnectionFactory gatewayServiceRequestConnectionFactory) {
        return new JmsTemplate(gatewayServiceRequestConnectionFactory);
    }
    
    
}
