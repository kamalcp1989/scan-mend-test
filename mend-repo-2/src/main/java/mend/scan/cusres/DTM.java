package aero.sita.bordermanagement.uae.gw.cusres;

import java.time.LocalDateTime;

public class DTM {
	
	
	private String DTMFunctionCode;
		
	private String DTMDateTimeStr;
	
	/**
	 * @return the dTMDateTimeStr
	 */
	public String getDTMDateTimeStr() {
		return DTMDateTimeStr;
	}

	/**
	 * @param dTMDateTimeStr the dTMDateTimeStr to set
	 */
	public void setDTMDateTimeStr(final String dTMDateTimeStr) {
		DTMDateTimeStr = dTMDateTimeStr;
	}

	public DTM(final String DTMFunctionCode, final String DTMDateTimeStr) {
		this.DTMFunctionCode = DTMFunctionCode;
		this.DTMDateTimeStr = DTMDateTimeStr;
	}

	/**
	 * @return the dTMFunctionCode
	 */
	public String getDTMFunctionCode() {
		return DTMFunctionCode;
	}

	/**
	 * @param dTMFunctionCode the dTMFunctionCode to set
	 */
	public void setDTMFunctionCode(final String dTMFunctionCode) {
		DTMFunctionCode = dTMFunctionCode;
	}
	
}
