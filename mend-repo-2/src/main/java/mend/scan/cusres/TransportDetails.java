/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.cusres;

/**
 * @author Kamal.Patel
 *
 */
public class TransportDetails {

    /**
     * stageCode : String Code representing the transport stage (e.g., main
     * carriage, pre-carriage)
     */
    private String stageCode;

    /**
     * transportId : String Unique identifier for the transport (e.g., flight number
     * or vessel ID)
     */
    private String transportId;

    /**
     * mode : String Mode of transport (e.g., 1=Sea, 2=Rail, 3=Road, 4=Air)
     */
    private String mode;

    /**
     * carrierCode : String Code representing the carrier (e.g., airline or shipping
     * line code)
     */
    private String carrierCode;

    /**
     * @return
     */
    public String getStageCode() {
        return stageCode;
    }

    /**
     * @param stageCode
     */
    public void setStageCode(final String stageCode) {
        this.stageCode = stageCode;
    }

    /**
     * @return String
     */
    public String getTransportId() {
        return transportId;
    }

    /**
     * @param transportId
     */
    public void setTransportId(final String transportId) {
        this.transportId = transportId;
    }

    /**
     * @return String
     */
    public String getMode() {
        return mode;
    }

    /**
     * @param mode
     */
    public void setMode(final String mode) {
        this.mode = mode;
    }

    /**
     * @return String
     */
    public String getCarrierCode() {
        return carrierCode;
    }

    /**
     * @param carrierCode
     */
    public void setCarrierCode(final String carrierCode) {
        this.carrierCode = carrierCode;
    }

}
