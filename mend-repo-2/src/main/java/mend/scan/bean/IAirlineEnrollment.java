/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * Interface IAirlineEnrollment
 */
public interface IAirlineEnrollment extends Serializable {

	
	/**
	 * @return Long
	 */
	Long getEnrollmentId();
	
	/**
	 * @return String
	 */
	String getSenderSystem();
	
	/**
	 * @return String
	 */
	String getAirlineCodes();
	
	/**
	 * @return Date
	 */
	Date getEnrollmentStartDate();
	
	/**
	 * @return Date
	 */
	Date getEnrollmentEndDate();
	
	/**
	 * @return Date
	 */
	Date getCreatedDate();
	
	/**
	 * @return Date
	 */
	Date getLastModifiedDate();
	
	/**
	 * @return String
	 */
	String getServiceRequestQueue();
	
	/**
	 * @return String
	 */
	String getServiceResponseQueue();
	
	/**
	 * @return Long
	 */
	Long getConcurrentConsumer();
	
	
	/**
	 * @return Long
	 */
	Long getMaxConcurrentConsumer(); 
	
	/**
	 * @return Boolean
	 */
	boolean isAutoResponder();
	
	/**
	 * @return String
	 */
	String getChannelName();
	
	/**
	 * @return String
	 */
	String userId();
	
	/**
	 * @return String
	 */
	String password();
	
}
