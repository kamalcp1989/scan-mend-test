/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

/**
 * Interface IGatewayAuditLog
 */
public interface ITransportStageQualifier extends Serializable {

	
	/**
	 * @return Date
	 */
	String getDTMDateTime();
	
	/**
	 * @return Date
	 */
	String getDTMFunctionCode();
	
	/**
	 * @return Date
	 */
	String getLocationNameCode();
	
	/**
	 * @return String
	 */
	String getLocationFunctionCode();
	
	/**
	 * @return String
	 */
	String getCarrierCode();
	
	/**
	 * @return String
	 */
	String getJourneyIdentifier();
	
	/**
	 * @return String
	 */
	String getCorrelationId();
}
