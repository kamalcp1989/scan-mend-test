/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Interface IGatewayTransaction
 */
public interface IGatewayTransaction extends Serializable {


	/**
	 * @return expected passenger id
	 */
	public Long getExpectedPassengerId();
	
    /**
     * @return correlation id
     */
    public String getCorrelationId();

    /**
     * Gets the transaction date and time.
     * 
     * @return the transaction datetime
     */
    public LocalDateTime getTransactionDatetime();

    /**
     * Gets the application response date and time.
     * 
     * @return the app response datetime
     */
    public LocalDateTime getAppResponseDatetime();

    /**
     * Gets the update version number.
     * 
     * @return the update version number
     */
    public int getUpdateVersionNo();

    /**
     * Gets the interchange control reference.
     * 
     * @return the interchange control reference
     */
    public String getInterchangeControlReference();

    /**
     * Gets the application sender identification.
     * 
     * @return the application sender identification
     */
    public String getSenderSystem();

    /**
     * Gets the controlling agency.
     * 
     * @return the controlling agency
     */
    public String getAirlineCode();

    /**
     * Gets the message type version number.
     * 
     * @return the message type version number
     */
    public String getMessageTypeVersionNumber();

    /**
     * Gets the traveller type.
     * 
     * @return the traveller type
     */
    public String getTravellerType();

    /**
     * Gets the message type.
     * 
     * @return the message type
     */
    public String getMessageType();
    
    public String getMessageRefNumber();
    
    public String getGroupRefNumber();

    /**
     * Gets the operator's party name.
     * 
     * @return the party name of the operator
     */
    public String getPartyNameOperator();

    /**
     * Gets the sender's telephone number.
     * 
     * @return the sender telephone
     */
    public String getSenderTelephone();

    /**
     * Gets the sender's fax number.
     * 
     * @return the sender fax
     */
    public String getSenderFax();

    /**
     * Gets the sender's email address.
     * 
     * @return the sender email
     */
    public String getSenderEmail();

    /**
     * Gets the first name of the party.
     * 
     * @return the party first name
     */
    public String getPartyFirstName();

    /**
     * Gets the surname of the party.
     * 
     * @return the party surname
     */
    public String getPartySurname();

    /**
     * Gets the second name of the party.
     * 
     * @return the party second name
     */
    public String getPartySecondName();

    /**
     * Gets the street address.
     * 
     * @return the street address
     */
    public String getAddressStreet();

    /**
     * Gets the city of the address.
     * 
     * @return the address city
     */
    public String getAddressCity();

    /**
     * Gets the state or province of the address.
     * 
     * @return the address state or province
     */
    public String getAddressStateProvince();

    /**
     * Gets the zip code of the address.
     * 
     * @return the address zip code
     */
    public String getAddressZipCode();

    /**
     * Gets the country of the address.
     * 
     * @return the address country
     */
    public String getAddressCountry();

    /**
     * Gets the gender of the individual.
     * 
     * @return the gender
     */
    public String getGender();

    /**
     * Gets the date of birth.
     * 
     * @return the date of birth
     */
    public LocalDate getDateOfBirth();

    /**
     * Gets the bag tag number.
     * 
     * @return the bag tag number
     */
    public String getBagtagNo();

    /**
     * Gets the baggage count.
     * 
     * @return the baggage count
     */
    public Integer getBaggageCount();

    /**
     * Gets the baggage weight.
     * 
     * @return the baggage weight
     */
    public BigDecimal getBaggageWeight();

    /**
     * Gets the free text information.
     * 
     * @return the free text
     */
    public String getFreeText();

    /**
     * Gets the customs clearance airport.
     * 
     * @return the customs clearance airport
     */
    public String getCustomsClearanceAirport();

    /**
     * Gets the country of residence.
     * 
     * @return the country of residence
     */
    public String getCountryOfResidence();

    /**
     * Gets the country of birth.
     * 
     * @return the country of birth
     */
    public String getCountryOfBirth();

    /**
     * Gets the party's telephone number.
     * 
     * @return the party telephone
     */
    public String getPartyTelephone();

    /**
     * Gets the party's fax number.
     * 
     * @return the party fax
     */
    public String getPartyFax();

    /**
     * Gets the party's email address.
     * 
     * @return the party email
     */
    public String getPartyEmail();

    /**
     * Gets the nationality of the party.
     * 
     * @return the party nationality
     */
    public String getPartyNationality();

    /**
     * Gets the seat number.
     * 
     * @return the seat number
     */
    public String getSeatNo();

    /**
     * Gets the frequent flyer ID.
     * 
     * @return the frequent flyer ID
     */
    public String getFrequentFlyerId();

    /**
     * Gets the government agency code.
     * 
     * @return the government agency code
     */
    public String getGovtAgencyCode();

    /**
     * Gets the passenger reference number.
     * 
     * @return the passenger reference number
     */
    public String getPaxRefNumber();

    /**
     * Gets the passenger name record.
     * 
     * @return the passenger name record
     */
    public String getPaxNameRecord();

    /**
     * Gets the passenger information verification indicator.
     * 
     * @return the passenger info verification indicator
     */
    public Boolean getPaxInfoVarificationIndicator();

    /**
     * Gets the document type.
     * 
     * @return the document type
     */
    public String getDocumentType();

    /**
     * Gets the document number.
     * 
     * @return the document number
     */
    public String getDocumentNumber();

    /**
     * Gets the date the document was issued.
     * 
     * @return the document issue date
     */
    public LocalDate getDocumentIssueDate();

    /**
     * Gets the date the document expires.
     * 
     * @return the document expiry date
     */
    public LocalDate getDocumentExpiryDate();

    /**
     * Gets the country that issued the document.
     * 
     * @return the document issuing country
     */
    public String getDocumentIssuingCountry();

    /**
     * Gets the response code.
     * 
     * @return the response code
     */
    public String getResponseCode();

    /**
     * Gets the processing status.
     * 
     * @return the processing status
     */
    public String getProcessingStatus();

    /**
     * Gets the TN reference number.
     * 
     * @return the TN reference number
     */
    public String getTnRefNumber();
    
    public String getAdditionalDocumentType();
    
    public String getAdditionalDocumentNumber();
    
    public LocalDate getAdditionalDocumentIssueDate();
    
    public LocalDate getAdditionalDocumentExpiryDate();
    
    public String getAdditionalDocumentIssuingCountry();
    
    public String getBoardingDirective();
    
    public String getErrorCode1();
    
    public String getErrorCode2();
    
    public String getErrorCode3();
    
    /**
	 * @return messageIdentifier
	 */
	public String getMessageIdentifier();


}
