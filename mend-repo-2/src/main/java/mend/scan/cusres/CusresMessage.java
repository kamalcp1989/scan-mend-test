/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.cusres;

import java.util.List;

import aero.sita.bordermanagement.uae.gw.bean.TransportStageQualifier;

/**
 * @author SITA
 *
 */
public class CusresMessage {

    /**
     * interchangeSender : String
     */
    private String interchangeSender;

    /**
     * interchangeReceiver : String UNB 0004
     */
    private String interchangeReceiver;
    
    
    /**
     * airlineCode : String UNG 0040
     */
    private String airlineCode;

    /**
     * messageRef : String e.g., MSG001
     */
    private String messageRef;

    /**
     * responseCode : String e.g., ERR42
     */
    private String responseCode;

    /**
     * references : List<Reference> e.g., TN, CRN, etc.
     */
    private List<Reference> references;

    /**
     * freeTextLines : List<String>
     */
    private List<String> freeTextLines;

    /**
     * errorCodes : List<String>
     */
    public List<String> errorCodes;

    /**
     * documentReferences : List<String>
     */
    public List<String> documentReferences;

    /**
     * timestamp : String Format: yyyyMMddHHmm
     */
    private String timestamp;

    /**
     * interchangeControlRef : String e.g., 000001
     */
    private String interchangeControlRef;

    /**
     * messageControlRef : String e.g., MSG001
     */
    private String messageControlRef;

    /**
     * groupReference : String
     */
    private String groupReference;

    /**
     * locations : List<Location>
     */
    private List<Location> locations;

    /**
     * arrivalDateTime : String DTM+232
     */
    private String arrivalDateTime;

    /**
     * departureDateTime : String DTM+189
     */
    private String departureDateTime;

    /**
     * transportDetails : TransportDetails
     */
    private TransportDetails transportDetails;
    
    
    private List<TransportStageQualifier> transportStageQualifier;

    
    private List<Group4PaxRef> grp4PaxRef;

    /**
     * messageGroupId : String
     */
    private String messageGroupId;

    /**
     * interchangeDate : String
     */
    private String interchangeDate;

    /**
     * interchangeTime : String
     */
    private String interchangeTime;

    /**
     * agencyCode : String
     */
    private String agencyCode;

    /**
     * syntaxVersion : String
     */
    private String syntaxVersion;
    
    /**
     * syntaxVersion : String
     */
    private String responseFtxMsg;
    
    
    

    /**
	 * @return the grp4PaxRef
	 */
	public List<Group4PaxRef> getGrp4PaxRef() {
		return grp4PaxRef;
	}

	/**
	 * @param grp4PaxRef the grp4PaxRef to set
	 */
	public void setGrp4PaxRef(final List<Group4PaxRef> grp4PaxRef) {
		this.grp4PaxRef = grp4PaxRef;
	}

	/**
	 * @return the transportStageQualifier
	 */
	public List<TransportStageQualifier> getTransportStageQualifier() {
		return transportStageQualifier;
	}

	/**
	 * @param transportStageQualifier the transportStageQualifier to set
	 */
	public void setTransportStageQualifier(final List<TransportStageQualifier> transportStageQualifier) {
		this.transportStageQualifier = transportStageQualifier;
	}

	/**
     * @return String
     */
    public String getMessageGroupId() {
        return messageGroupId;
    }

    /**
     * @param messageGroupId
     */
    public void setMessageGroupId(final String messageGroupId) {
        this.messageGroupId = messageGroupId;
    }

    /**
     * @return String
     */
    public String getInterchangeDate() {
        return interchangeDate;
    }

    /**
     * @param interchangeDate
     */
    public void setInterchangeDate(final String interchangeDate) {
        this.interchangeDate = interchangeDate;
    }

    /**
     * @return String
     */
    public String getInterchangeTime() {
        return interchangeTime;
    }

    /**
     * @param interchangeTime
     */
    public void setInterchangeTime(final String interchangeTime) {
        this.interchangeTime = interchangeTime;
    }

    /**
     * @return String
     */
    public String getAgencyCode() {
        return agencyCode;
    }

    /**
     * @param agencyCode
     */
    public void setAgencyCode(final String agencyCode) {
        this.agencyCode = agencyCode;
    }

    /**
     * @return String
     */
    public String getSyntaxVersion() {
        return syntaxVersion;
    }

    /**
     * @param syntaxVersion
     */
    public void setSyntaxVersion(final String syntaxVersion) {
        this.syntaxVersion = syntaxVersion;
    }

    /**
     * @return TransportDetails
     */
    public TransportDetails getTransportDetails() {
        return transportDetails;
    }

    /**
     * @param transportDetails
     */
    public void setTransportDetails(final TransportDetails transportDetails) {
        this.transportDetails = transportDetails;
    }

    /**
     * @return List<Location>
     */
    public List<Location> getLocations() {
        return locations;
    }

    /**
     * @param locations
     */
    public void setLocations(final List<Location> locations) {
        this.locations = locations;
    }

    /**
     * @return String
     */
    public String getInterchangeSender() {
        return interchangeSender;
    }

    /**
     * @param interchangeSender
     */
    public void setInterchangeSender(final String interchangeSender) {
        this.interchangeSender = interchangeSender;
    }

    /**
     * @return String
     */
    public String getInterchangeReceiver() {
        return interchangeReceiver;
    }

    /**
     * @param interchangeReceiver
     */
    public void setInterchangeReceiver(final String interchangeReceiver) {
        this.interchangeReceiver = interchangeReceiver;
    }

    /**
     * @return String
     */
    public String getMessageRef() {
        return messageRef;
    }

    /**
     * @param messageRef
     */
    public void setMessageRef(final String messageRef) {
        this.messageRef = messageRef;
    }

    /**
     * @return String
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * @param responseCode
     */
    public void setResponseCode(final String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * @return List<Reference>
     */
    public List<Reference> getReferences() {
        return references;
    }

    /**
     * @param references
     */
    public void setReferences(final List<Reference> references) {
        this.references = references;
    }

    /**
     * @return List<String>
     */
    public List<String> getFreeTextLines() {
        return freeTextLines;
    }

    /**
     * @param freeTextLines
     */
    public void setFreeTextLines(final List<String> freeTextLines) {
        this.freeTextLines = freeTextLines;
    }

    /**
     * @return String
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp
     */
    public void setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return String
     */
    public String getInterchangeControlRef() {
        return interchangeControlRef;
    }

    /**
     * @param interchangeControlRef
     */
    public void setInterchangeControlRef(final String interchangeControlRef) {
        this.interchangeControlRef = interchangeControlRef;
    }

    /**
     * @return String
     */
    public String getMessageControlRef() {
        return messageControlRef;
    }

    /**
     * @param messageControlRef
     */
    public void setMessageControlRef(final String messageControlRef) {
        this.messageControlRef = messageControlRef;
    }

    /**
     * @return List<String>
     */
    public List<String> getErrorCodes() {
        return errorCodes;
    }

    /**
     * @param errorCodes
     */
    public void setErrorCodes(final List<String> errorCodes) {
        this.errorCodes = errorCodes;
    }

    /**
     * @return List<String>
     */
    public List<String> getDocumentReferences() {
        return documentReferences;
    }

    /**
     * @param documentReferences
     */
    public void setDocumentReferences(final List<String> documentReferences) {
        this.documentReferences = documentReferences;
    }

    /**
     * @param groupReference
     */
    public void setGroupReference(final String groupReference) {
        this.groupReference = groupReference;
    }

    /**
     * @return String
     */
    public String getArrivalDateTime() {
        return arrivalDateTime;
    }

    /**
     * @param arrivalDateTime
     */
    public void setArrivalDateTime(final String arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    /**
     * @return String
     */
    public String getDepartureDateTime() {
        return departureDateTime;
    }

    /**
     * @param departureDateTime
     */
    public void setDepartureDateTime(final String departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    /**
     * @return String
     */
    public String getGroupReference() {
        return groupReference;
    }

	/**
	 * @return the responseFtxMsg
	 */
	public String getResponseFtxMsg() {
		return responseFtxMsg;
	}

	/**
	 * @param responseFtxMsg the responseFtxMsg to set
	 */
	public void setResponseFtxMsg(final String responseFtxMsg) {
		this.responseFtxMsg = responseFtxMsg;
	}

	/**
	 * @return the airlineCode
	 */
	public String getAirlineCode() {
		return airlineCode;
	}

	/**
	 * @param airlineCode the airlineCode to set
	 */
	public void setAirlineCode(final String airlineCode) {
		this.airlineCode = airlineCode;
	}
	
	
    
    

}
