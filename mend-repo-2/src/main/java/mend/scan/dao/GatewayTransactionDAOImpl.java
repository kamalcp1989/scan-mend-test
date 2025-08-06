/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Service;

import aero.sita.bordermanagement.uae.gw.bean.GatewayTransaction;
import aero.sita.bordermanagement.uae.gw.bean.GatewayTransactionRowMapper;
import aero.sita.bordermanagement.uae.gw.bean.IGatewayTransaction;
import aero.sita.bordermanagement.uae.gw.bean.ITransportStageQualifier;
import aero.sita.bordermanagement.uae.gw.bean.TransportStageQualifier;
import aero.sita.bordermanagement.uae.gw.bean.TransportStageQualifierRowMapper;


/**
 * GatewayTransactionDAOImpl
 */
@Service
public class GatewayTransactionDAOImpl {
	
	private static final Logger LOG = LoggerFactory.getLogger(GatewayTransactionDAOImpl.class);

    /**
     * Named JDBC template
     */
    @Autowired
    @Qualifier("namedJdbcTemplate")
    private NamedParameterJdbcTemplate  jdbcTemplate;
    
    private static final String UPDATE_DIRECTIVE_AND_RESPONSE_CODE = "UPDATE GATEWAY_TRANSACTION "
    		+ "SET BOARDING_DIRECTIVE = :boardingDirective, RESPONSE_CODE = :responseCode "
    		+ "WHERE EXPECTED_PASSENGER_ID = :expectedPassengerId";
    
    private static final String UPDATE_DIRECTIVE_AND_RESPONSE_CODE_MESSAGE_IDENTIFIER = "UPDATE GATEWAY_TRANSACTION "
    		+ "SET BOARDING_DIRECTIVE = :boardingDirective, RESPONSE_CODE = :responseCode "
    		+ "WHERE MESSAGE_IDENTIFIER = :messageIdentifier AND DOCUMENT_NUMBER =:documentNumber";
    
    private static final String UPDATE_DIRECTIVE_AND_RESPONSE_CODE_MESSAGE_IDENTIFIER_FOR_FLIGHT_CLOSURE = "UPDATE GATEWAY_TRANSACTION "
    		+ "SET BOARDING_DIRECTIVE = :boardingDirective, RESPONSE_CODE = :responseCode "
    		+ "WHERE MESSAGE_IDENTIFIER = :messageIdentifier ";
    
    private static final String SELECT_GATEWAY_TRANSACTION = "SELECT "+
    		"EXPECTED_PASSENGER_ID"+
            ", CORRELATION_ID"+
    		", MESSAGE_REF_NUMBER"+
    		", MESSAGE_RFF_NUMBER"+
            ", INTERCHANGE_CONTROL_REFERENCE"+
    		", GROUP_REF_NUMBER"+
            ", PAX_REF_NUMBER"+
    		", PAX_NAME_RECORD"+
            ", SEAT_NO"+
    		", GOVT_AGENCY_CODE"+
            ", FREQUENT_FLYER_ID"+
    		", SENDER_SYSTEM"+
    		", AIRLINE_CODE"+
    		", RESPONSE_CODE"+
    		", BOARDING_DIRECTIVE"+
    		", ERROR_CODE_1"+
    		", ERROR_CODE_2"+
    		", ERROR_CODE_3"+
    		", MESSAGE_IDENTIFIER"+
            "  FROM GATEWAY_TRANSACTION WHERE EXPECTED_PASSENGER_ID = :expectedPassengerId";
    
    private static final String SELECT_GATEWAY_TRANSACTION_BY_MSI_AND_DOCN = "SELECT "+
    		"EXPECTED_PASSENGER_ID"+
            ", CORRELATION_ID"+
    		", MESSAGE_REF_NUMBER"+
			", MESSAGE_RFF_NUMBER"+
            ", INTERCHANGE_CONTROL_REFERENCE"+
    		", GROUP_REF_NUMBER"+
            ", PAX_REF_NUMBER"+
    		", PAX_NAME_RECORD"+
            ", SEAT_NO"+
    		", GOVT_AGENCY_CODE"+
            ", FREQUENT_FLYER_ID"+
    		", SENDER_SYSTEM"+
    		", AIRLINE_CODE"+
    		", RESPONSE_CODE"+
    		", BOARDING_DIRECTIVE"+
    		", ERROR_CODE_1"+
    		", ERROR_CODE_2"+
    		", ERROR_CODE_3"+
    		", MESSAGE_IDENTIFIER"+
            "  FROM GATEWAY_TRANSACTION WHERE MESSAGE_IDENTIFIER = :messageIdentifier AND DOCUMENT_NUMBER =:documentNumber";
    
    private static final String SELECT_GATEWAY_TRANSACTION_FLIGHT_CLOSURE = "SELECT "+
    		"EXPECTED_PASSENGER_ID"+
            ", CORRELATION_ID"+
    		", MESSAGE_REF_NUMBER"+
			", MESSAGE_RFF_NUMBER"+
            ", INTERCHANGE_CONTROL_REFERENCE"+
    		", GROUP_REF_NUMBER"+
            ", PAX_REF_NUMBER"+
    		", PAX_NAME_RECORD"+
            ", SEAT_NO"+
    		", GOVT_AGENCY_CODE"+
            ", FREQUENT_FLYER_ID"+
    		", SENDER_SYSTEM"+
    		", AIRLINE_CODE"+
    		", RESPONSE_CODE"+
    		", BOARDING_DIRECTIVE"+
    		", ERROR_CODE_1"+
    		", ERROR_CODE_2"+
    		", ERROR_CODE_3"+
    		", MESSAGE_IDENTIFIER"+
            "  FROM GATEWAY_TRANSACTION WHERE MESSAGE_IDENTIFIER = :messageIdentifier";
    
    private static final String SELECT_TRANSPORT_STAGE_QUALIFIER = """
            SELECT * FROM TRANSPORT_STAGE_QUALIFIER
            WHERE CORRELATION_ID = :correlationId
        """;
    
    private static final String DELETE_TRANSPORT_STAGE_QUALIFIER = """
            DELETE FROM TRANSPORT_STAGE_QUALIFIER
            WHERE CORRELATION_ID = :correlationId
        """;
    
 // Step 2: Bulk insert
    private static final String INSERT_TRANSPORT_STAGE_QUALIFIER = """
        INSERT INTO TRANSPORT_STAGE_QUALIFIER (
            CORRELATION_ID,
            JOURNEY_IDENTIFIER,
            CARRIER_CODE,
            LOCATION_FUNCTION_CODE,
            LOCATION_NAME_CODE,
            DTM_FUNCTION_CODE,
            DTM_DATETIME
        ) VALUES (
            :correlationId,
            :journeyIdentifier,
            :carrierCode,
            :locationFunctionCode,
            :locationNameCode,
            :dtmFunctionCode,
            :dtmDatetime
        )
    """;
    
    
    private static final String INSERT_GATEWAY_TRANSACTION_APP_CANCEL_QUERY = """
            INSERT INTO gateway_transaction (
                correlation_Id, transaction_datetime, app_response_datetime, update_version_no,
                interchange_control_reference, sender_system, airline_code,
                message_type_version_number, traveller_type, message_type, message_ref_number, message_rff_number,group_ref_number, party_name_operator,
                sender_telephone, sender_fax, sender_email, party_first_name, party_second_name, party_surname, address_street,
                address_city, address_state_province, address_zip_code, address_country, gender, date_of_birth,
                free_text, customs_clearance_airport,
                country_of_residence, country_of_birth, party_telephone, party_fax, party_email,
                party_nationality, seat_no, frequent_flyer_id, govt_agency_code, pax_ref_number,
                pax_name_record, pax_info_varification_indicator, document_type, document_number,
                document_issue_date, document_expiry_date, document_issuing_country, response_code, processing_status, message_Identifier
              )
              VALUES (
                :correlationId, :transactionDatetime, :appResponseDatetime, :updateVersionNo,
                :interchangeControlReference, :senderSystem, :airlineCode,
                :messageTypeVersionNumber, :travellerType, :messageType, :messageRefNumber, :messageRffNumber,:groupRefNumber, :partyNameOperator,
                :senderTelephone, :senderFax, :senderEmail, :partyFirstName, :partySecondName, :partySurname, :addressStreet,
                :addressCity, :addressStateProvince, :addressZipCode, :addressCountry, :gender, :dateOfBirth,
                :freeText, :customsClearanceAirport,
                :countryOfResidence, :countryOfBirth, :partyTelephone, :partyFax, :partyEmail,
                :partyNationality, :seatNo, :frequentFlyerId, :govtAgencyCode, :paxRefNumber,
                :paxNameRecord, :paxInfoVarificationIndicator, :documentType, :documentNumber,
                :documentIssueDate, :documentExpiryDate, :documentIssuingCountry, :responseCode, :processingStatus, :messageIdentifier
              )
            """;
    
    private static final String INSERT_GATEWAY_TRANSACTION_APP_CHECKIN_QUERY = """
            INSERT INTO gateway_transaction (
                expected_passenger_id, correlation_Id, transaction_datetime, app_response_datetime, update_version_no,
                interchange_control_reference, sender_system, airline_code,
                message_type_version_number, traveller_type, message_type, message_ref_number, message_rff_number,group_ref_number, party_name_operator,
                sender_telephone, sender_fax, sender_email, party_first_name, party_second_name, party_surname, address_street,
                address_city, address_state_province, address_zip_code, address_country, gender, date_of_birth,
                free_text, customs_clearance_airport,
                country_of_residence, country_of_birth, party_telephone, party_fax, party_email,
                party_nationality, seat_no, frequent_flyer_id, govt_agency_code, pax_ref_number,
                pax_name_record, pax_info_varification_indicator, document_type, document_number,
                document_issue_date, document_expiry_date, document_issuing_country, response_code, processing_status, message_Identifier
              )
              VALUES (
                :expectedPassengerId, :correlationId, :transactionDatetime, :appResponseDatetime, :updateVersionNo,
                :interchangeControlReference, :senderSystem, :airlineCode,
                :messageTypeVersionNumber, :travellerType, :messageType, :messageRefNumber, :messageRffNumber,:groupRefNumber, :partyNameOperator,
                :senderTelephone, :senderFax, :senderEmail, :partyFirstName, :partySecondName, :partySurname, :addressStreet,
                :addressCity, :addressStateProvince, :addressZipCode, :addressCountry, :gender, :dateOfBirth,
                :freeText, :customsClearanceAirport,
                :countryOfResidence, :countryOfBirth, :partyTelephone, :partyFax, :partyEmail,
                :partyNationality, :seatNo, :frequentFlyerId, :govtAgencyCode, :paxRefNumber,
                :paxNameRecord, :paxInfoVarificationIndicator, :documentType, :documentNumber,
                :documentIssueDate, :documentExpiryDate, :documentIssuingCountry, :responseCode, :processingStatus, :messageIdentifier
              )
            """;

    
    public List<GatewayTransaction> findGatewayTransactionByCorrelationId(List<GatewayTransaction> gatewayTransactions) {
    	
    	for (GatewayTransaction gatewayTransaction : gatewayTransactions) {
    		Map<String, Object> params = Map.of("expectedPassengerId", gatewayTransaction.getExpectedPassengerId());
    		IGatewayTransaction gt = jdbcTemplate.queryForObject(SELECT_GATEWAY_TRANSACTION, params, new GatewayTransactionRowMapper());
    		transformObjectFromDb(gatewayTransaction, gt);
    	}
        return gatewayTransactions;
        
    }
    public List<GatewayTransaction> findGatewayTransactionByMessageIdentifierAndDocNumber(List<GatewayTransaction> gatewayTransactions) {
    	for (GatewayTransaction gatewayTransaction : gatewayTransactions) {
    		Map<String, Object> params = Map.of(			        
			        "messageIdentifier", gatewayTransaction.getMessageIdentifier(),
			        "documentNumber", gatewayTransaction.getDocumentNumber()
			    );
    		IGatewayTransaction gt = jdbcTemplate.queryForObject(SELECT_GATEWAY_TRANSACTION_BY_MSI_AND_DOCN, params, new GatewayTransactionRowMapper());
    		transformObjectFromDb(gatewayTransaction, gt);
    	}
    
        return gatewayTransactions;
        
    }
    
    public List<GatewayTransaction> findGatewayTransactionForFlightClosure(List<GatewayTransaction> gatewayTransactions) {
    	for (GatewayTransaction gatewayTransaction : gatewayTransactions) {
    		Map<String, Object> params = Map.of(			        
			        "messageIdentifier", gatewayTransaction.getMessageIdentifier()
			    );
    		IGatewayTransaction gt = jdbcTemplate.queryForObject(SELECT_GATEWAY_TRANSACTION_FLIGHT_CLOSURE, params, new GatewayTransactionRowMapper());
    		transformObjectFromDb(gatewayTransaction, gt);
    	}
    
        return gatewayTransactions;
        
    }
    
	private void transformObjectFromDb(GatewayTransaction gatewayTransaction, IGatewayTransaction gt) {
		gatewayTransaction.setResponseCode(gt.getResponseCode());
		gatewayTransaction.setBoardingDirective(gt.getBoardingDirective());
		gatewayTransaction.setCorrelationId(gt.getCorrelationId());
		gatewayTransaction.setMessageRefNumber(gt.getMessageRefNumber());
		gatewayTransaction.setTnRefNumber(gt.getTnRefNumber());
		gatewayTransaction.setInterchangeControlReference(gt.getInterchangeControlReference());
		gatewayTransaction.setGroupRefNumber(gt.getGroupRefNumber());
		gatewayTransaction.setPaxRefNumber(gt.getPaxRefNumber());
		gatewayTransaction.setPaxNameRecord(gt.getPaxNameRecord());
		gatewayTransaction.setSeatNo(gt.getSeatNo());
		gatewayTransaction.setGovtAgencyCode(gt.getGovtAgencyCode());
		gatewayTransaction.setFrequentFlyerId(gt.getFrequentFlyerId());
		gatewayTransaction.setSenderSystem(gt.getSenderSystem());
		gatewayTransaction.setAirlineCode(gt.getAirlineCode());
		gatewayTransaction.setErrorCode1(gt.getErrorCode1());
		gatewayTransaction.setErrorCode2(gt.getErrorCode2());
		gatewayTransaction.setErrorCode2(gt.getErrorCode2());
		gatewayTransaction.setMessageIdentifier(gt.getMessageIdentifier());
	}
    
    public List<ITransportStageQualifier> findTransportStageQualifierByCorrelationId(String correlationId) {
        Map<String, Object> params = Map.of("correlationId", correlationId);
        return jdbcTemplate.query(SELECT_TRANSPORT_STAGE_QUALIFIER, params, new TransportStageQualifierRowMapper());
    }
    
    
    /**
     * @param transaction
     */
    //@Transactional
    public void insertOrUpdate(final List<GatewayTransaction> txList, final List<TransportStageQualifier> tsqList, final String msgType) {
		if ("XR".equals(msgType)) {
			cancelCheckInTransaction(txList);
		} else {
			appCheckInTransaction(txList);
		}
    	for (IGatewayTransaction tx : txList) {
    		deleteByCorrelationId(tx.getCorrelationId());
    	}
    	

        List<Map<String, Object>> paramList = tsqList.stream().map(q -> {
            Map<String, Object> map = new HashMap<>();
            map.put("correlationId", q.getCorrelationId());
            map.put("journeyIdentifier", q.getJourneyIdentifier());
            map.put("carrierCode", q.getCarrierCode());
            map.put("locationFunctionCode", q.getLocationFunctionCode());
            map.put("locationNameCode", q.getLocationNameCode());
            map.put("dtmFunctionCode", q.getDTMFunctionCode());
            map.put("dtmDatetime", q.getDTMDateTime());
            return map;
        }).toList();

        SqlParameterSource[] batchParams = SqlParameterSourceUtils.createBatch(paramList.toArray());

        jdbcTemplate.batchUpdate(INSERT_TRANSPORT_STAGE_QUALIFIER, batchParams);
    	 
    }

	/**
	 * @param txList
	 */
	private void appCheckInTransaction(final List<GatewayTransaction> txList) {
		for (IGatewayTransaction transaction : txList) {
			MapSqlParameterSource params = new MapSqlParameterSource()
					.addValue("expectedPassengerId", transaction.getExpectedPassengerId())
					.addValue("correlationId", transaction.getCorrelationId())
					.addValue("transactionDatetime", transaction.getTransactionDatetime())
					.addValue("appResponseDatetime", transaction.getAppResponseDatetime())
					.addValue("updateVersionNo", transaction.getUpdateVersionNo())
					.addValue("interchangeControlReference", transaction.getInterchangeControlReference())
					.addValue("senderSystem", transaction.getSenderSystem())
					.addValue("airlineCode", transaction.getAirlineCode())
					.addValue("messageTypeVersionNumber", transaction.getMessageTypeVersionNumber())
					.addValue("travellerType", transaction.getTravellerType())
					.addValue("messageType", transaction.getMessageType())
					.addValue("messageRefNumber", transaction.getMessageRefNumber())
					.addValue("messageRffNumber", transaction.getTnRefNumber())
					.addValue("groupRefNumber", transaction.getGroupRefNumber())
					.addValue("partyNameOperator", transaction.getPartyNameOperator())
					.addValue("senderTelephone", transaction.getSenderTelephone())
					.addValue("senderFax", transaction.getSenderFax())
					.addValue("senderEmail", transaction.getSenderEmail())
					.addValue("partyFirstName", transaction.getPartyFirstName())
					.addValue("partySurname", transaction.getPartySurname())
					.addValue("partySecondName", transaction.getPartySecondName())
					.addValue("addressStreet", transaction.getAddressStreet())
					.addValue("addressCity", transaction.getAddressCity())
					.addValue("addressStateProvince", transaction.getAddressStateProvince())
					.addValue("addressZipCode", transaction.getAddressZipCode())
					.addValue("addressCountry", transaction.getAddressCountry())
					.addValue("gender", transaction.getGender())
					.addValue("dateOfBirth", transaction.getDateOfBirth())
					.addValue("freeText", transaction.getFreeText())
					.addValue("customsClearanceAirport", transaction.getCustomsClearanceAirport())
					.addValue("countryOfResidence", transaction.getCountryOfResidence())
					.addValue("countryOfBirth", transaction.getCountryOfBirth())
					.addValue("partyTelephone", transaction.getPartyTelephone())
					.addValue("partyFax", transaction.getPartyFax())
					.addValue("partyEmail", transaction.getPartyEmail())
					.addValue("partyNationality", transaction.getPartyNationality())
					.addValue("seatNo", transaction.getSeatNo())
					.addValue("frequentFlyerId", transaction.getFrequentFlyerId())
					.addValue("govtAgencyCode", transaction.getGovtAgencyCode())
					.addValue("paxRefNumber", transaction.getPaxRefNumber())
					.addValue("paxNameRecord", transaction.getPaxNameRecord())
					.addValue("paxInfoVarificationIndicator", transaction.getPaxInfoVarificationIndicator())
					.addValue("documentType", transaction.getDocumentType())
					.addValue("documentNumber", transaction.getDocumentNumber())
					.addValue("documentIssueDate", transaction.getDocumentIssueDate())
					.addValue("documentExpiryDate", transaction.getDocumentExpiryDate())
					.addValue("documentIssuingCountry", transaction.getDocumentIssuingCountry())
					.addValue("responseCode", transaction.getResponseCode())
					.addValue("processingStatus", transaction.getProcessingStatus())
					.addValue("messageIdentifier", transaction.getMessageIdentifier());

			jdbcTemplate.update(INSERT_GATEWAY_TRANSACTION_APP_CHECKIN_QUERY, params);
		}
	}

	private void cancelCheckInTransaction(final List<GatewayTransaction> txList) {
		for (IGatewayTransaction transaction : txList) {
			MapSqlParameterSource params = new MapSqlParameterSource()
					.addValue("correlationId", transaction.getCorrelationId())
					.addValue("transactionDatetime", transaction.getTransactionDatetime())
					.addValue("appResponseDatetime", transaction.getAppResponseDatetime())
					.addValue("updateVersionNo", transaction.getUpdateVersionNo())
					.addValue("interchangeControlReference", transaction.getInterchangeControlReference())
					.addValue("senderSystem", transaction.getSenderSystem())
					.addValue("airlineCode", transaction.getAirlineCode())
					.addValue("messageTypeVersionNumber", transaction.getMessageTypeVersionNumber())
					.addValue("travellerType", transaction.getTravellerType())
					.addValue("messageType", transaction.getMessageType())
					.addValue("messageRefNumber", transaction.getMessageRefNumber())
					.addValue("messageRffNumber", transaction.getTnRefNumber())
					.addValue("groupRefNumber", transaction.getGroupRefNumber())
					.addValue("partyNameOperator", transaction.getPartyNameOperator())
					.addValue("senderTelephone", transaction.getSenderTelephone())
					.addValue("senderFax", transaction.getSenderFax())
					.addValue("senderEmail", transaction.getSenderEmail())
					.addValue("partyFirstName", transaction.getPartyFirstName())
					.addValue("partySurname", transaction.getPartySurname())
					.addValue("partySecondName", transaction.getPartySecondName())
					.addValue("addressStreet", transaction.getAddressStreet())
					.addValue("addressCity", transaction.getAddressCity())
					.addValue("addressStateProvince", transaction.getAddressStateProvince())
					.addValue("addressZipCode", transaction.getAddressZipCode())
					.addValue("addressCountry", transaction.getAddressCountry())
					.addValue("gender", transaction.getGender())
					.addValue("dateOfBirth", transaction.getDateOfBirth())
					.addValue("freeText", transaction.getFreeText())
					.addValue("customsClearanceAirport", transaction.getCustomsClearanceAirport())
					.addValue("countryOfResidence", transaction.getCountryOfResidence())
					.addValue("countryOfBirth", transaction.getCountryOfBirth())
					.addValue("partyTelephone", transaction.getPartyTelephone())
					.addValue("partyFax", transaction.getPartyFax())
					.addValue("partyEmail", transaction.getPartyEmail())
					.addValue("partyNationality", transaction.getPartyNationality())
					.addValue("seatNo", transaction.getSeatNo())
					.addValue("frequentFlyerId", transaction.getFrequentFlyerId())
					.addValue("govtAgencyCode", transaction.getGovtAgencyCode())
					.addValue("paxRefNumber", transaction.getPaxRefNumber())
					.addValue("paxNameRecord", transaction.getPaxNameRecord())
					.addValue("paxInfoVarificationIndicator", transaction.getPaxInfoVarificationIndicator())
					.addValue("documentType", transaction.getDocumentType())
					.addValue("documentNumber", transaction.getDocumentNumber())
					.addValue("documentIssueDate", transaction.getDocumentIssueDate())
					.addValue("documentExpiryDate", transaction.getDocumentExpiryDate())
					.addValue("documentIssuingCountry", transaction.getDocumentIssuingCountry())
					.addValue("responseCode", transaction.getResponseCode())
					.addValue("processingStatus", transaction.getProcessingStatus())
					.addValue("messageIdentifier", transaction.getMessageIdentifier());

			jdbcTemplate.update(INSERT_GATEWAY_TRANSACTION_APP_CANCEL_QUERY, params);
		}
	}
    
    public void deleteByCorrelationId(final String correlationId) {
        Map<String, Object> params = Map.of("correlationId", correlationId);
        jdbcTemplate.update(DELETE_TRANSPORT_STAGE_QUALIFIER, params);
    }
    
    public void updateDirectiveAndResponseCode(List<GatewayTransaction> gatewayTransactions) {
		for(GatewayTransaction gatewayTransaction: gatewayTransactions) {
			Map<String, Object> params = Map.of(
			        "boardingDirective", gatewayTransaction.getBoardingDirective(),
			        "responseCode", gatewayTransaction.getResponseCode(),
			        "expectedPassengerId", gatewayTransaction.getExpectedPassengerId()
			    );
			jdbcTemplate.update(UPDATE_DIRECTIVE_AND_RESPONSE_CODE, params);
	   }
	}
    public void updateDirectiveAndResponseCodeForAppCancelCheckIn(List<GatewayTransaction> gatewayTransactions){
		for(GatewayTransaction gatewayTransaction: gatewayTransactions) {
			Map<String, Object> params = Map.of(
			        "boardingDirective", gatewayTransaction.getBoardingDirective(),
			        "responseCode", gatewayTransaction.getResponseCode(),
			        "messageIdentifier",gatewayTransaction.getMessageIdentifier(),
			        "documentNumber",gatewayTransaction.getDocumentNumber()
			    );
			jdbcTemplate.update(UPDATE_DIRECTIVE_AND_RESPONSE_CODE_MESSAGE_IDENTIFIER, params);
	   }
	}
    
    public void updateDirectiveAndResponseCodeForFlightClosure(List<GatewayTransaction> gatewayTransactions) {
    	for(GatewayTransaction gatewayTransaction: gatewayTransactions) {
			Map<String, Object> params = Map.of(
			        "boardingDirective", gatewayTransaction.getBoardingDirective(),
			        "responseCode", gatewayTransaction.getResponseCode(),
			        "messageIdentifier",gatewayTransaction.getMessageIdentifier()
			    );
			jdbcTemplate.update(UPDATE_DIRECTIVE_AND_RESPONSE_CODE_MESSAGE_IDENTIFIER_FOR_FLIGHT_CLOSURE, params);
	   }
    }
    
    public List<Long> getListOfExpectedPassengerId(int count, String movementIdSequence) {
        try {
       	String sql = "SELECT " + movementIdSequence + ".NEXTVAL FROM dual CONNECT BY LEVEL <= :size";
       	Map<String, Object> params = Map.of("size", count);

       	return jdbcTemplate.query(sql, params, new RowMapper<Long>() {
       	    public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
       	        return rs.getLong(1);
       	    }
   		});
       } catch(Exception e) {
       	LOG.error("Error While Executing Query." + e); 
       }
        return null;
     }
}