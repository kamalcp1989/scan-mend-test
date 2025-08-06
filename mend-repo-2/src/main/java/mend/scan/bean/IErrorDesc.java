/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.io.Serializable;

/**
 * Interface IErrorDesc
 */
public interface IErrorDesc extends Serializable {
	/**
	 * @return String
	 */
	String getErrorCode();
	
	/**
	 * @return String
	 */
	String getDesc();
	
	/**
	 * @return String
	 */
	String getDescAr();
}
