package aero.sita.bordermanagement.uae.gw.bean;

import java.sql.Date;

public class GatewayAuditLog implements IGatewayAuditLog {

	/**
	 * Serial Id generated default Id
	 */
	private static final long serialVersionUID = 1L;

	private Long auditLogId;

	private String messageId;

	private String messageType;

	private String message;

	private String systemCode;

	private String resultCode;

	private Date creationTimestamp;

	private String hostname;

	private String expectedPassengerId;
	
	private String correlationId;
	
	private String messageIdentifier;
	
	
	/**
	 * @return the correlationId
	 */
	@Override
	public final String getCorrelationId() {
		return correlationId;
	}

	/**
	 * @param correlationId the correlationId to set
	 */
	public final void setCorrelationId(final String correlationId) {
		this.correlationId = correlationId;
	}

	/**
	 * @return the auditLogId
	 */
	@Override
	public Long getAuditLogId() {
		return auditLogId;
	}

	/**
	 * @param auditLogId the auditLogId to set
	 */
	public void setAuditLogId(final Long auditLogId) {
		this.auditLogId = auditLogId;
	}

	/**
	 * @return the messageId
	 */
	@Override
	public String getMessageId() {
		return messageId;
	}

	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(final String messageId) {
		this.messageId = messageId;
	}

	/**
	 * @return the messageType
	 */
	@Override
	public String getMessageType() {
		return messageType;
	}

	/**
	 * @param messageType the messageType to set
	 */
	public void setMessageType(final String messageType) {
		this.messageType = messageType;
	}

	/**
	 * @return the message
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

	/**
	 * @return the systemCode
	 */
	@Override
	public String getSystemCode() {
		return systemCode;
	}

	/**
	 * @param systemCode the systemCode to set
	 */
	public void setSystemCode(final String systemCode) {
		this.systemCode = systemCode;
	}

	/**
	 * @return the resultCode
	 */
	@Override
	public String getResultCode() {
		return resultCode;
	}

	/**
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(final String resultCode) {
		this.resultCode = resultCode;
	}

	/**
	 * @return the creationTimestamp
	 */
	@Override
	public Date getCreationTimestamp() {
		return creationTimestamp;
	}

	/**
	 * @param creationTimestamp the creationTimestamp to set
	 */
	public void setCreationTimestamp(final Date creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	/**
	 * @return the hostname
	 */
	@Override
	public String getHostname() {
		return hostname;
	}

	/**
	 * @param hostname the hostname to set
	 */
	public void setHostname(final String hostname) {
		this.hostname = hostname;
	}

	/**
	 * @return the expectedPassengerId
	 */
	public String getExpectedPassengerId() {
		return expectedPassengerId;
	}

	/**
	 * @param expectedPassengerId the expectedPassengerId to set
	 */
	public void setExpectedPassengerId(final String expectedPassengerId) {
		this.expectedPassengerId = expectedPassengerId;
	}

	/**
	 * @return the messageIdentifier
	 */
	public String getMessageIdentifier() {
		return messageIdentifier;
	}

	/**
	 * @param messageIdentifier the messageIdentifier to set
	 */
	public void setMessageIdentifier(String messageIdentifier) {
		this.messageIdentifier = messageIdentifier;
	}



}
