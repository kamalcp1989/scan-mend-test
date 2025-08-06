package aero.sita.bordermanagement.uae.gw.bean;

import java.time.LocalDateTime;
import java.util.List;

import aero.sita.bordermanagement.uae.gw.cusres.Group3LocationDTM;

public class TransportStageQualifier implements ITransportStageQualifier {

	/**
	 * Serial Version Id
	 */
	private static final long serialVersionUID = 8233574963676176026L;

	private String correlationId;
	
	private String journeyIdentifier;
	
	private String carrierCode;
	
	private List<Group3LocationDTM> grp3;
	
	private String locationFunctionCode;
	
	private String locationNameCode;
	
	private String DTMFunctionCode;
		
	private String DTMDateTime;
	
	@Override
	public String getDTMDateTime() {
		return this.DTMDateTime;
	}

	@Override
	public String getDTMFunctionCode() {
		return this.DTMFunctionCode;
	}

	@Override
	public String getLocationNameCode() {
		return this.locationNameCode;
	}

	@Override
	public String getLocationFunctionCode() {
		return this.locationFunctionCode;
	}
	
	
	
	/**
	 * @param locationFunctionCode the locationFunctionCode to set
	 */
	public void setLocationFunctionCode(final String locationFunctionCode) {
		this.locationFunctionCode = locationFunctionCode;
	}

	/**
	 * @param locationNameCode the locationNameCode to set
	 */
	public void setLocationNameCode(final String locationNameCode) {
		this.locationNameCode = locationNameCode;
	}

	/**
	 * @param dTMFunctionCode the dTMFunctionCode to set
	 */
	public void setDTMFunctionCode(final String dTMFunctionCode) {
		DTMFunctionCode = dTMFunctionCode;
	}

	/**
	 * @param dTMDateTime the dTMDateTime to set
	 */
	public void setDTMDateTime(final String dTMDateTime) {
		DTMDateTime = dTMDateTime;
	}

	/**
	 * @return the grp3
	 */
	public List<Group3LocationDTM> getGrp3() {
		return grp3;
	}

	/**
	 * @param grp3 the grp3 to set
	 */
	public void setGrp3(final List<Group3LocationDTM> grp3) {
		this.grp3 = grp3;
	}

	@Override
	public String getCarrierCode() {
		return this.carrierCode;
	}

	@Override
	public String getJourneyIdentifier() {
		return this.journeyIdentifier;
	}

	@Override
	public String getCorrelationId() {
		return this.correlationId;
	}

	/**
	 * @param correlationId the correlationId to set
	 */
	public final void setCorrelationId(final String correlationId) {
		this.correlationId = correlationId;
	}

	/**
	 * @param journeyIdentifier the journeyIdentifier to set
	 */
	public final void setJourneyIdentifier(final String journeyIdentifier) {
		this.journeyIdentifier = journeyIdentifier;
	}

	/**
	 * @param carrierCode the carrierCode to set
	 */
	public final void setCarrierCode(final String carrierCode) {
		this.carrierCode = carrierCode;
	}
}
