/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.io.Serializable;

/**
 * Interface IStatusCodeDesc
 */
public interface IStatusCodeDesc extends Serializable {
	/**
	 * @return String
	 */
	String getMessageCode();
	
	/**
	 * @return String
	 */
	String getDesc();
	
	/**
	 * @return String
	 */
	String getDescAr();
	
	/**
	 * @return String
	 */
	String getPaxStatusCode();
}
