/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.sql.Date;

/**
 * Airline Enrollment class
 */
public class AirlineEnrollment implements IAirlineEnrollment {

    /** Serial version ID. */
    private static final long serialVersionUID = -882799239797814404L;
    
    /**
     * enrollmentId : Long  
     * Unique identifier for the enrollment record.
     */
    private Long enrollmentId;

    /**
     * Sender System : String  
     * Identifier for the associated service.
     */
    private String SenderSystem;
    
    /**
     * airlineCodes : String  
     * Unique identifier for the enrollment record.
     */
    private String airlineCodes;

    /**
     * enrollmentStartDate : Date  
     * Date when the enrollment becomes active.
     */
    private Date enrollmentStartDate;

    /**
     * enrollmentEndDate : Date  
     * Date when the enrollment is set to expire or end.
     */
    private Date enrollmentEndDate;

    /**
     * createdDate : Date  
     * Timestamp indicating when the enrollment was initially created.
     */
    private Date createdDate;

    /**
     * lastModifiedDate : Date  
     * Timestamp for the most recent update to the enrollment record.
     */
    private Date lastModifiedDate;

    /**
     * serviceRequestQueue : String  
     * Queue name used to send service requests.
     */
    private String serviceRequestQueue;

    /**
     * serviceResponseQueue : String  
     * Queue name from which service responses are received.
     */
    private String serviceResponseQueue;

    /**
     * isAutoResponder : boolean  
     * Flag to indicate whether the auto-responder feature is enabled for this enrollment.
     */
    private boolean isAutoResponder;

    /**
     * channelName : String  
     * Name of the communication channel used for this enrollment.
     */
    private String channelName;

    /**
     * userId : String  
     * Username used for authenticating with the service or channel.
     */
    private String userId;

    /**
     * password : String  
     * Password used for authentication. (Ensure this is securely stored and masked in logs/configs.)
     */
    private String password;
    
    /**
     * concurrentConsumer : Long  
     * Password used for authentication. (Ensure this is securely stored and masked in logs/configs.)
     */
    private Long concurrentConsumer;
    
    /**
     * maxConcurrentConsumer : Long  
     * Password used for authentication. (Ensure this is securely stored and masked in logs/configs.)
     */
    private Long maxConcurrentConsumer;
    
    
	/**
	 * @return the concurrentConsumer
	 */
	public Long getConcurrentConsumer() {
		return concurrentConsumer;
	}

	/**
	 * @param concurrentConsumer the concurrentConsumer to set
	 */
	public void setConcurrentConsumer(final Long concurrentConsumer) {
		this.concurrentConsumer = concurrentConsumer;
	}

	/**
	 * @return the maxConcurrentConsumer
	 */
	public Long getMaxConcurrentConsumer() {
		return maxConcurrentConsumer;
	}

	/**
	 * @param maxConcurrentConsumer the maxConcurrentConsumer to set
	 */
	public void setMaxConcurrentConsumer(final Long maxConcurrentConsumer) {
		this.maxConcurrentConsumer = maxConcurrentConsumer;
	}

	/**
	 * @return the airlineCodes
	 */
	public String getAirlineCodes() {
		return airlineCodes;
	}

	/**
	 * @param airlineCodes the airlineCodes to set
	 */
	public void setAirlineCodes(final String airlineCodes) {
		this.airlineCodes = airlineCodes;
	}

	/**
	 * @return the senderSystem
	 */
	public String getSenderSystem() {
		return SenderSystem;
	}

	/**
	 * @param senderSystem the senderSystem to set
	 */
	public void setSenderSystem(String senderSystem) {
		SenderSystem = senderSystem;
	}

	/**
	 * @param enrollmentId
	 */
	public void setEnrollmentId(final Long enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	/**
	 * @param enrollmentStartDate
	 */
	public void setEnrollmentStartDate(final Date enrollmentStartDate) {
		this.enrollmentStartDate = enrollmentStartDate;
	}

	/**
	 * @param enrollmentEndDate
	 */
	public void setEnrollmentEndDate(final Date enrollmentEndDate) {
		this.enrollmentEndDate = enrollmentEndDate;
	}

	/**
	 * @param createdDate
	 */
	public void setCreatedDate(final Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @param lastModifiedDate
	 */
	public void setLastModifiedDate(final Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	/**
	 * @param serviceRequestQueue
	 */
	public void setServiceRequestQueue(final String serviceRequestQueue) {
		this.serviceRequestQueue = serviceRequestQueue;
	}

	/**
	 * @param serviceResponseQueue
	 */
	public void setServiceResponseQueue(final String serviceResponseQueue) {
		this.serviceResponseQueue = serviceResponseQueue;
	}

	/**
	 * @param channelName
	 */
	public void setChannelName(final String channelName) {
		this.channelName = channelName;
	}

	/**
	 * @param userId
	 */
	public void setUserId(final String userId) {
		this.userId = userId;
	}

	/**
	 * @param password
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * getEnrollmentId returns Long
	 */
	public Long getEnrollmentId() {
		return this.enrollmentId;
	}

	/**
	 * Return Date
	 */
	public Date getEnrollmentStartDate() {
		return this.enrollmentStartDate;
	}

	/**
	 * Returns Date
	 */
	public Date getEnrollmentEndDate() {
		return this.enrollmentEndDate;
	}

	/**
	 * Returns Date
	 */
	public Date getCreatedDate() {
		return this.createdDate;
	}

	/**
	 * Returns Date
	 */
	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	/**
	 * Returns String
	 */
	public String getServiceRequestQueue() {
		return this.serviceRequestQueue;
	}

	/**
	 * Returns String
	 */
	public String getServiceResponseQueue() {
		return this.serviceResponseQueue;
	}

	/**
	 * Returns String
	 */
	public String getChannelName() {
		return this.channelName;
	}

	/**
	 * returns userId
	 */
	public String userId() {
		return this.userId;
	}

	/**
	 *  Returns password
	 */
	public String password() {
		return this.password;
	}
	
	/**
	 * Returns boolean
	 */
	public boolean isAutoResponder() {
		return isAutoResponder;
	}

	/**
	 * @param isAutoResponder
	 */
	public void setAutoResponder(final boolean isAutoResponder) {
		this.isAutoResponder = isAutoResponder;
	}

	@Override
	public String toString() {
		return "AirlineEnrollmentConfiguration [enrollmentId=" + enrollmentId + ", SenderSystem=" + SenderSystem
				+ ", enrollmentStartDate=" + enrollmentStartDate + ", enrollmentEndDate=" + enrollmentEndDate
				+ ", createdDate=" + createdDate + ", lastModifiedDate=" + lastModifiedDate + ", serviceRequestQueue="
				+ serviceRequestQueue + ", serviceResponseQueue=" + serviceResponseQueue + ", autoResponder="
				+ isAutoResponder + ", channelName=" + channelName + ", userId=" + userId + ", password=" + password
				+ "]";
	}
}
