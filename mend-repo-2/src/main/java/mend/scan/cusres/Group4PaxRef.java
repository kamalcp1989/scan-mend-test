package aero.sita.bordermanagement.uae.gw.cusres;

import java.util.List;

public class Group4PaxRef {
 
	private List<Reference> references;
	
	private String appResponseCode;
	
	private String paxRefNumber;
	
	private String freeText;
	
	/**
	 * @return the paxRefNumber
	 */
	public String getPaxRefNumber() {
		return paxRefNumber;
	}

	/**
	 * @param paxRefNumber the paxRefNumber to set
	 */
	public void setPaxRefNumber(final String paxRefNumber) {
		this.paxRefNumber = paxRefNumber;
	}

	/**
	 * @return the freeText
	 */
	public String getFreeText() {
		return freeText;
	}

	/**
	 * @param freeText the freeText to set
	 */
	public void setFreeText(final String freeText) {
		this.freeText = freeText;
	}

	/**
	 * @return the appResponseCode
	 */
	public String getAppResponseCode() {
		return appResponseCode;
	}

	/**
	 * @param appResponseCode the appResponseCode to set
	 */
	public void setAppResponseCode(String appResponseCode) {
		this.appResponseCode = appResponseCode;
	}

	/**
	 * @return the references
	 */
	public List<Reference> getReferences() {
		return references;
	}

	/**
	 * @param references the references to set
	 */
	public void setReferences(final List<Reference> references) {
		this.references = references;
	}


	
	
	
}
