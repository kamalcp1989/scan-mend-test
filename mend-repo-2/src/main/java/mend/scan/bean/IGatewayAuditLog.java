/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * Interface IGatewayAuditLog
 */
public interface IGatewayAuditLog extends Serializable {

	
	/**
	 * @return Long
	 */
	Long getAuditLogId();
	
	/**
	 * @return String
	 */
	String getMessageId();
	
	/**
	 * @return Date
	 */
	String getMessageType();
	
	/**
	 * @return Date
	 */
	String getMessage();
	
	/**
	 * @return Date
	 */
	String getSystemCode();
	
	/**
	 * @return Date
	 */
	String getResultCode();
	
	/**
	 * @return String
	 */
	Date getCreationTimestamp();
	
	/**
	 * @return String
	 */
	String getHostname();
	
	/**
	 * @return String
	 */
	String getExpectedPassengerId();
	
	
	String getCorrelationId();
	
	String getMessageIdentifier();
}
