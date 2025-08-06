/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * GatewayTransaction class
 */
public class GatewayTransaction implements IGatewayTransaction {

    /**
	 * Serial ID
	 */
	private static final long serialVersionUID = -3490122551062794891L;

	/**
     * Unique ID for the source transaction.
     */
    private Long expectedPassengerId;
    
	/**
     * Unique ID for the source transaction.
     */
    private String messageRefNumber;
    
	/**
     * Group REF number for trailer
     */
    private String groupRefNumber;
    
    /**
     * Unique ID for the correlation with IBM MQ Header.
     */
    private String correlationId;

    /**
     * Timestamp of when the transaction was initiated.
     */
    private LocalDateTime transactionDatetime;

    /**
     * Timestamp of when the application responded.
     */
    private LocalDateTime appResponseDatetime;

    /**
     * Version number used for update tracking.
     */
    private int updateVersionNo;

    /**
     * Reference number for the interchange control.
     */
    private String interchangeControlReference;

    /**
     * Sender System UNB Segment 0004 Airline or DCS.
     */
    private String senderSystem;

    /**
     * Airline Code UNG Segment 0040.
     */
    private String airlineCode;

    /**
     * Version number of the message type.
     */
    private String messageTypeVersionNumber;

    /**
     * Type of the traveller (e.g., passenger, crew).
     */
    private String travellerType;

    /**
     * Type of the message (e.g., PAXLST, CUSRES).
     */
    private String messageType;

    /**
     * Name of the operating party or organization.
     */
    private String partyNameOperator;

    /**
     * Telephone number of the sender.
     */
    private String senderTelephone;

    /**
     * Fax number of the sender.
     */
    private String senderFax;

    /**
     * Email address of the sender.
     */
    private String senderEmail;

    /**
     * Surname of the party/traveller.
     */
    private String partySurname;

    /**
     * First name of the party/traveller.
     */
    private String partyFirstName;

    /**
     * Second name or middle name of the party/traveller.
     */
    private String partySecondName;

    /**
     * Street portion of the party's address.
     */
    private String addressStreet;

    /**
     * City portion of the party's address.
     */
    private String addressCity;

    /**
     * State or province in the party's address.
     */
    private String addressStateProvince;

    /**
     * ZIP or postal code in the address.
     */
    private String addressZipCode;

    /**
     * Country name or code of the address.
     */
    private String addressCountry;

    /**
     * Gender of the traveller.
     */
    private String gender;

    /**
     * Date of birth of the traveller.
     */
    private LocalDate dateOfBirth;

    /**
     * Tag number for the traveller's baggage.
     */
    private String bagtagNo;

    /**
     * Total number of baggage items.
     */
    private Integer baggageCount;

    /**
     * Total weight of the baggage.
     */
    private BigDecimal baggageWeight;

    /**
     * Free text comments or remarks.
     */
    private String freeText;

    /**
     * Airport designated for customs clearance.
     */
    private String customsClearanceAirport;

    /**
     * Country of residence of the traveller.
     */
    private String countryOfResidence;

    /**
     * Country of birth of the traveller.
     */
    private String countryOfBirth;

    /**
     * Traveller's telephone number.
     */
    private String partyTelephone;

    /**
     * Traveller's fax number.
     */
    private String partyFax;

    /**
     * Traveller's email address.
     */
    private String partyEmail;

    /**
     * Nationality of the traveller.
     */
    private String partyNationality;

    /**
     * Assigned seat number.
     */
    private String seatNo;

    /**
     * Traveller's frequent flyer ID.
     */
    private String frequentFlyerId;

    /**
     * Government agency code, if applicable.
     */
    private String govtAgencyCode;

    /**
     * Passenger reference number.
     */
    private String paxRefNumber;

    /**
     * Passenger name record reference.
     */
    private String paxNameRecord;

    /**
     * Flag indicating if passenger information was verified.
     */
    private Boolean paxInfoVarificationIndicator;

    /**
     * Type of the identification document.
     */
    private String documentType;

    /**
     * Number of the identification document.
     */
    private String documentNumber;

    /**
     * Date when the identification document was issued.
     */
    private LocalDate documentIssueDate;

    /**
     * Expiry date of the identification document.
     */
    private LocalDate documentExpiryDate;

    /**
     * Country that issued the document.
     */
    private String documentIssuingCountry;
    
    
    
    /**
     * Type of the identification document.
     */
    private String additionalDocumentType;

    /**
     * Number of the identification document.
     */
    private String additionalDocumentNumber;

    /**
     * Date when the identification document was issued.
     */
    private LocalDate additionalDocumentIssueDate;

    /**
     * Expiry date of the identification document.
     */
    private LocalDate additionalDocumentExpiryDate;

    /**
     * Country that issued the document.
     */
    private String additionalDocumentIssuingCountry;
    
    private String boardingDirective;
    
    
    private String errorCode1;
    
    private String errorCode2;
    
    private String errorCode3;
    
    private String messageIdentifier;
    
    
    /**
	 * @return the boardingDirective
	 */
	public String getBoardingDirective() {
		return boardingDirective;
	}
	/**
	 * @param boardingDirective the boardingDirective to set
	 */
	public void setBoardingDirective(final String boardingDirective) {
		this.boardingDirective = boardingDirective;
	}
	
	
	
	/**
	 * @return the errorCode1
	 */
	public String getErrorCode1() {
		return errorCode1;
	}
	/**
	 * @param errorCode1 the errorCode1 to set
	 */
	public void setErrorCode1(final String errorCode1) {
		this.errorCode1 = errorCode1;
	}
	/**
	 * @return the errorCode2
	 */
	public String getErrorCode2() {
		return errorCode2;
	}
	/**
	 * @param errorCode2 the errorCode2 to set
	 */
	public void setErrorCode2(final String errorCode2) {
		this.errorCode2 = errorCode2;
	}
	/**
	 * @return the errorCode3
	 */
	public String getErrorCode3() {
		return errorCode3;
	}
	/**
	 * @param errorCode3 the errorCode3 to set
	 */
	public void setErrorCode3(final String errorCode3) {
		this.errorCode3 = errorCode3;
	}
	/**
	 * @return the additionalDocumentType
	 */
	public String getAdditionalDocumentType() {
		return additionalDocumentType;
	}
	/**
	 * @param additionalDocumentType the additionalDocumentType to set
	 */
	public void setAdditionalDocumentType(final String additionalDocumentType) {
		this.additionalDocumentType = additionalDocumentType;
	}
	/**
	 * @return the additionalDocumentNumber
	 */
	public String getAdditionalDocumentNumber() {
		return additionalDocumentNumber;
	}
	/**
	 * @param additionalDocumentNumber the additionalDocumentNumber to set
	 */
	public void setAdditionalDocumentNumber(final String additionalDocumentNumber) {
		this.additionalDocumentNumber = additionalDocumentNumber;
	}
	/**
	 * @return the additionalDocumentIssueDate
	 */
	public LocalDate getAdditionalDocumentIssueDate() {
		return additionalDocumentIssueDate;
	}
	/**
	 * @param additionalDocumentIssueDate the additionalDocumentIssueDate to set
	 */
	public void setAdditionalDocumentIssueDate(final LocalDate additionalDocumentIssueDate) {
		this.additionalDocumentIssueDate = additionalDocumentIssueDate;
	}
	/**
	 * @return the additionalDocumentExpiryDate
	 */
	public LocalDate getAdditionalDocumentExpiryDate() {
		return additionalDocumentExpiryDate;
	}
	/**
	 * @param additionalDocumentExpiryDate the additionalDocumentExpiryDate to set
	 */
	public void setAdditionalDocumentExpiryDate(final LocalDate additionalDocumentExpiryDate) {
		this.additionalDocumentExpiryDate = additionalDocumentExpiryDate;
	}
	/**
	 * @return the additionalDocumentIssuingCountry
	 */
	public String getAdditionalDocumentIssuingCountry() {
		return additionalDocumentIssuingCountry;
	}
	/**
	 * @param additionalDocumentIssuingCountry the additionalDocumentIssuingCountry to set
	 */
	public void setAdditionalDocumentIssuingCountry(final String additionalDocumentIssuingCountry) {
		this.additionalDocumentIssuingCountry = additionalDocumentIssuingCountry;
	}
	/**
	 * @return the serialversionuid
	 */
	public static final long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
     * Response code returned by the processing system.
     */
    private String responseCode;

    /**
     * Current status of message processing.
     */
    private String processingStatus;

    /**
     * Reference number for the transaction.
     */
    private String tnRefNumber;
    
    /**
	 * @return the groupRefNumber
	 */
    @Override
	public String getGroupRefNumber() {
		return groupRefNumber;
	}
	/**
	 * @param groupRefNumber the groupRefNumber to set
	 */
	public void setGroupRefNumber(final String groupRefNumber) {
		this.groupRefNumber = groupRefNumber;
	}
	/**
	 * @return the messageRefNumber
	 */
	@Override
	public String getMessageRefNumber() {
		return messageRefNumber;
	}
	/**
	 * @param messageRefNumber the messageRefNumber to set
	 */
	public void setMessageRefNumber(final String messageRefNumber) {
		this.messageRefNumber = messageRefNumber;
	}
	/**
	 * @return the correlationId
	 */
	public String getCorrelationId() {
		return correlationId;
	}
	/**
	 * @param correlationId the correlationId to set
	 */
	public void setCorrelationId(final String correlationId) {
		this.correlationId = correlationId;
	}
	
	public String getTnRefNumber() {
        return tnRefNumber;
    }
    /**
     * @param tnRefNumber
     */
    public void setTnRefNumber(final String tnRefNumber) {
        this.tnRefNumber = tnRefNumber;
    }
    
	/**
	 * @return the expectedPassengerId
	 */
	public Long getExpectedPassengerId() {
		return expectedPassengerId;
	}
	/**
	 * @param expectedPassengerId the expectedPassengerId to set
	 */
	public void setExpectedPassengerId(final Long expectedPassengerId) {
		this.expectedPassengerId = expectedPassengerId;
	}
	public LocalDateTime getTransactionDatetime() {
        return transactionDatetime;
    }
    /**
     * @param transactionDatetime
     */
    public void setTransactionDatetime(final LocalDateTime transactionDatetime) {
        this.transactionDatetime = transactionDatetime;
    }
    public LocalDateTime getAppResponseDatetime() {
        return appResponseDatetime;
    }
    /**
     * @param appResponseDatetime
     */
    public void setAppResponseDatetime(final LocalDateTime appResponseDatetime) {
        this.appResponseDatetime = appResponseDatetime;
    }
    public int getUpdateVersionNo() {
        return updateVersionNo;
    }
    /**
     * @param updateVersionNo
     */
    public void setUpdateVersionNo(final int updateVersionNo) {
        this.updateVersionNo = updateVersionNo;
    }
    public String getInterchangeControlReference() {
        return interchangeControlReference;
    }
    /**
     * @param interchangeControlReference
     */
    public void setInterchangeControlReference(final String interchangeControlReference) {
        this.interchangeControlReference = interchangeControlReference;
    }
    /**
	 * @return the senderSystem
	 */
	public String getSenderSystem() {
		return senderSystem;
	}
	/**
	 * @param senderSystem the senderSystem to set
	 */
	public void setSenderSystem(final String senderSystem) {
		this.senderSystem = senderSystem;
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
	
	public String getMessageTypeVersionNumber() {
        return messageTypeVersionNumber;
    }
    /**
     * @param messageTypeVersionNumber
     */
    public void setMessageTypeVersionNumber(final String messageTypeVersionNumber) {
        this.messageTypeVersionNumber = messageTypeVersionNumber;
    }
    public String getTravellerType() {
        return travellerType;
    }
    /**
     * @param travellerType
     */
    public void setTravellerType(final String travellerType) {
        this.travellerType = travellerType;
    }
    public String getMessageType() {
        return messageType;
    }
    /**
     * @param messageType
     */
    public void setMessageType(final String messageType) {
        this.messageType = messageType;
    }
    public String getPartyNameOperator() {
        return partyNameOperator;
    }
    /**
     * @param partyNameOperator
     */
    public void setPartyNameOperator(final String partyNameOperator) {
        this.partyNameOperator = partyNameOperator;
    }
    public String getSenderTelephone() {
        return senderTelephone;
    }
    /**
     * @param senderTelephone
     */
    public void setSenderTelephone(final String senderTelephone) {
        this.senderTelephone = senderTelephone;
    }
    public String getSenderFax() {
        return senderFax;
    }
    /**
     * @param senderFax
     */
    public void setSenderFax(final String senderFax) {
        this.senderFax = senderFax;
    }
    public String getSenderEmail() {
        return senderEmail;
    }
    /**
     * @param senderEmail
     */
    public void setSenderEmail(final String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getPartyFirstName() {
        return partyFirstName;
    }
    /**
     * @param partyFirstName
     */
    public void setPartyFirstName(final String partyFirstName) {
        this.partyFirstName = partyFirstName;
    }
    
    public String getPartySurname() {
        return partySurname;
    }
    /**
     * @param partySurname
     */
    public void setPartySurname(final String partySurname) {
        this.partySurname = partySurname;
    }
    public String getPartySecondName() {
        return partySecondName;
    }
    /**
     * @param partySecondName
     */
    public void setPartySecondName(final String partySecondName) {
        this.partySecondName = partySecondName;
    }
    public String getAddressStreet() {
        return addressStreet;
    }
    /**
     * @param addressStreet
     */
    public void setAddressStreet(final String addressStreet) {
        this.addressStreet = addressStreet;
    }
    public String getAddressCity() {
        return addressCity;
    }
    /**
     * @param addressCity
     */
    public void setAddressCity(final String addressCity) {
        this.addressCity = addressCity;
    }
    public String getAddressStateProvince() {
        return addressStateProvince;
    }
    /**
     * @param addressStateProvince
     */
    public void setAddressStateProvince(final String addressStateProvince) {
        this.addressStateProvince = addressStateProvince;
    }
    public String getAddressZipCode() {
        return addressZipCode;
    }
    /**
     * @param addressZipCode
     */
    public void setAddressZipCode(final String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }
    public String getAddressCountry() {
        return addressCountry;
    }
    /**
     * @param addressCountry
     */
    public void setAddressCountry(final String addressCountry) {
        this.addressCountry = addressCountry;
    }
    public String getGender() {
        return gender;
    }
    /**
     * @param gender
     */
    public void setGender(final String gender) {
        this.gender = gender;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    /**
     * @param dateOfBirth
     */
    public void setDateOfBirth(final LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public String getBagtagNo() {
        return bagtagNo;
    }
    /**
     * @param bagtagNo
     */
    public void setBagtagNo(final String bagtagNo) {
        this.bagtagNo = bagtagNo;
    }
    public Integer getBaggageCount() {
        return baggageCount;
    }
    /**
     * @param baggageCount
     */
    public void setBaggageCount(final Integer baggageCount) {
        this.baggageCount = baggageCount;
    }
    public BigDecimal getBaggageWeight() {
        return baggageWeight;
    }
    /**
     * @param baggageWeight
     */
    public void setBaggageWeight(final BigDecimal baggageWeight) {
        this.baggageWeight = baggageWeight;
    }
    public String getFreeText() {
        return freeText;
    }
    /**
     * @param freeText
     */
    public void setFreeText(String freeText) {
        this.freeText = freeText;
    }
    public String getCustomsClearanceAirport() {
        return customsClearanceAirport;
    }
    /**
     * @param customsClearanceAirport
     */
    public void setCustomsClearanceAirport(final String customsClearanceAirport) {
        this.customsClearanceAirport = customsClearanceAirport;
    }
    public String getCountryOfResidence() {
        return countryOfResidence;
    }
    /**
     * @param countryOfResidence
     */
    public void setCountryOfResidence(final String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }
    public String getCountryOfBirth() {
        return countryOfBirth;
    }
    /**
     * @param countryOfBirth
     */
    public void setCountryOfBirth(final String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }
    public String getPartyTelephone() {
        return partyTelephone;
    }
    /**
     * @param partyTelephone
     */
    public void setPartyTelephone(final String partyTelephone) {
        this.partyTelephone = partyTelephone;
    }
    public String getPartyFax() {
        return partyFax;
    }
    /**
     * @param partyFax
     */
    public void setPartyFax(final String partyFax) {
        this.partyFax = partyFax;
    }
    public String getPartyEmail() {
        return partyEmail;
    }
    /**
     * @param partyEmail
     */
    public void setPartyEmail(final String partyEmail) {
        this.partyEmail = partyEmail;
    }
    public String getPartyNationality() {
        return partyNationality;
    }
    /**
     * @param partyNationality
     */
    public void setPartyNationality(final String partyNationality) {
        this.partyNationality = partyNationality;
    }
    public String getSeatNo() {
        return seatNo;
    }
    /**
     * @param seatNo
     */
    public void setSeatNo(final String seatNo) {
        this.seatNo = seatNo;
    }
    public String getFrequentFlyerId() {
        return frequentFlyerId;
    }
    /**
     * @param frequentFlyerId
     */
    public void setFrequentFlyerId(final String frequentFlyerId) {
        this.frequentFlyerId = frequentFlyerId;
    }
    public String getGovtAgencyCode() {
        return govtAgencyCode;
    }
    /**
     * @param govtAgencyCode
     */
    public void setGovtAgencyCode(final String govtAgencyCode) {
        this.govtAgencyCode = govtAgencyCode;
    }
    public String getPaxRefNumber() {
        return paxRefNumber;
    }
    /**
     * @param paxRefNumber
     */
    public void setPaxRefNumber(final String paxRefNumber) {
        this.paxRefNumber = paxRefNumber;
    }
    public String getPaxNameRecord() {
        return paxNameRecord;
    }
    /**
     * @param paxNameRecord
     */
    public void setPaxNameRecord(final String paxNameRecord) {
        this.paxNameRecord = paxNameRecord;
    }
    public Boolean getPaxInfoVarificationIndicator() {
        return paxInfoVarificationIndicator;
    }
    /**
     * @param paxInfoVarificationIndicator
     */
    public void setPaxInfoVarificationIndicator(final Boolean paxInfoVarificationIndicator) {
        this.paxInfoVarificationIndicator = paxInfoVarificationIndicator;
    }
    public String getDocumentType() {
        return documentType;
    }
    /**
     * @param documentType
     */
    public void setDocumentType(final String documentType) {
        this.documentType = documentType;
    }
    public String getDocumentNumber() {
        return documentNumber;
    }
    /**
     * @param documentNumber
     */
    public void setDocumentNumber(final String documentNumber) {
        this.documentNumber = documentNumber;
    }
    public LocalDate getDocumentIssueDate() {
        return documentIssueDate;
    }
    /**
     * @param documentIssueDate
     */
    public void setDocumentIssueDate(final LocalDate documentIssueDate) {
        this.documentIssueDate = documentIssueDate;
    }
    public LocalDate getDocumentExpiryDate() {
        return documentExpiryDate;
    }
    /**
     * @param documentExpiryDate
     */
    public void setDocumentExpiryDate(final LocalDate documentExpiryDate) {
        this.documentExpiryDate = documentExpiryDate;
    }
    public String getDocumentIssuingCountry() {
        return documentIssuingCountry;
    }
    /**
     * @param documentIssuingCountry
     */
    public void setDocumentIssuingCountry(final String documentIssuingCountry) {
        this.documentIssuingCountry = documentIssuingCountry;
    }
    public String getResponseCode() {
        return responseCode;
    }
    /**
     * @param responseCode
     */
    public void setResponseCode(final String responseCode) {
        this.responseCode = responseCode;
    }
    public String getProcessingStatus() {
        return processingStatus;
    }
    /**
     * @param processingStatus
     */
    public void setProcessingStatus(final String processingStatus) {
        this.processingStatus = processingStatus;
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
