/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.util;

/**
 * MessageConstants
 */
public final class MessageConstants {

    /** REPLY_TO_QUEUE_NAME_KEY exchange property name to set replyTo queues. */
    public static final String REPLY_TO_QUEUE_NAME =   "REPLY_TO_QUEUE_NAME";
    
    /** IBM_INT_MQ_COMPONENT exchange property name to set Internal Queue */
    public static final String IBM_INT_MQ_COMPONENT = "intJms:";
    
    /** IBM_EXT_MQ_COMPONENT exchange property name to set External Queue */
    public static final String IBM_EXT_MQ_COMPONENT = "extJms:";
    
    /** IBM_EXT_MQ_COMPONENT_REG exchange property name to set External Queue */
    public static final String IBM_EXT_MQ_COMPONENT_REG = "extJms";
    
    /** HYPHEN exchange property name to set - */
    public static final String HYPHEN = "-";
    
    /** IS_AUTO_RESPONDER exchange property name to set Autoresponder */
    public static final String IS_AUTO_RESPONDER = "IS_AUTO_RESPONDER";
    
    /** ... we also have a key for the proper JMS header for correlation IDs, to use in the response converter (sigh). */
    public static final String JMS_CORRELATION_ID = "JMSCorrelationID";
    
    /** MESSAGE_ID exchange property name to set MESSAGE_ID*/
    public static final String MESSAGE_ID = "MESSAGE_ID";
    
    /** Sender System exchange property name to set MESSAGE_ID*/
    public static final String SENDER_SYSTEM = "SENDER_SYSTEM";
    
    /** Sender System exchange property name to set MESSAGE_ID*/
    public static final String AIRLINE_CODES = "AIRLINE_CODES";
    
    /** Sender System exchange property name to set MESSAGE_TYPE*/
    public static final String MESSAGE_TYPE = "MESSAGE_TYPE";
    
    /** Sender System exchange property name to set EXPECTED_PASSENGER_ID*/
    public static final String EXPECTED_PASSENGER_ID = "EXPECTED_PASSENGER_ID";
    
    public static final String APP_RESPONSE_ROUTE = "APP_RESPONSE_ROUTE";
    
    public static final String MESSAGE_IDENTIFIER = "messageIdentifier";
    
    public static final String PAX_LIST_MSG_HEADER = "paxListMessage";
    
       
    public static final String CORRELATION_ID = "CorrelationID";
    
    
    private MessageConstants() { }
}
