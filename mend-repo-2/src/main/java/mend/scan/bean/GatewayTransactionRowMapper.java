/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * GatewayTransactionRowMapper
 */
public class GatewayTransactionRowMapper implements RowMapper<IGatewayTransaction> {

	public IGatewayTransaction mapRow(final ResultSet resultSet, final int row) throws SQLException {
		
		final GatewayTransaction gatewayTransaction = new GatewayTransaction();
		
		gatewayTransaction.setExpectedPassengerId(Long.valueOf(resultSet.getLong("EXPECTED_PASSENGER_ID")));
		gatewayTransaction.setCorrelationId(String.valueOf(resultSet.getString("CORRELATION_ID")));
		gatewayTransaction.setMessageRefNumber(String.valueOf(resultSet.getString("MESSAGE_REF_NUMBER")));
		gatewayTransaction.setTnRefNumber(String.valueOf(resultSet.getString("MESSAGE_RFF_NUMBER")));
		gatewayTransaction.setInterchangeControlReference(String.valueOf(resultSet.getLong("INTERCHANGE_CONTROL_REFERENCE")));
		gatewayTransaction.setGroupRefNumber(String.valueOf(resultSet.getString("GROUP_REF_NUMBER")));
		gatewayTransaction.setPaxRefNumber(String.valueOf(resultSet.getString("PAX_REF_NUMBER")));
		gatewayTransaction.setPaxNameRecord(String.valueOf(resultSet.getString("PAX_NAME_RECORD")));
		if (resultSet.getString("SEAT_NO") != null) {
			gatewayTransaction.setSeatNo(String.valueOf(resultSet.getString("SEAT_NO")));
		}
		if (resultSet.getString("GOVT_AGENCY_CODE") != null) {
			gatewayTransaction.setGovtAgencyCode(String.valueOf(resultSet.getString("GOVT_AGENCY_CODE")));
		}
		if (resultSet.getString("FREQUENT_FLYER_ID") != null) {
			gatewayTransaction.setFrequentFlyerId(String.valueOf(resultSet.getString("FREQUENT_FLYER_ID")));
		}
		gatewayTransaction.setSenderSystem(String.valueOf(resultSet.getString("SENDER_SYSTEM")));
		gatewayTransaction.setAirlineCode(String.valueOf(resultSet.getString("AIRLINE_CODE")));
		if (resultSet.getString("BOARDING_DIRECTIVE") != null) {
			gatewayTransaction.setBoardingDirective(resultSet.getString("BOARDING_DIRECTIVE"));
		}
		
		if (resultSet.getString("RESPONSE_CODE") != null) {
			gatewayTransaction.setResponseCode(resultSet.getString("RESPONSE_CODE"));
		}
		
		if (resultSet.getString("ERROR_CODE_1") != null) {
			gatewayTransaction.setErrorCode1(resultSet.getString("ERROR_CODE_1"));
		}
		
		if (resultSet.getString("ERROR_CODE_2") != null) {
			gatewayTransaction.setErrorCode2(resultSet.getString("ERROR_CODE_2"));
		}
		
		if (resultSet.getString("ERROR_CODE_3") != null) {
			gatewayTransaction.setErrorCode3(resultSet.getString("ERROR_CODE_3"));
		}
		if (resultSet.getString("MESSAGE_IDENTIFIER") != null) {
			gatewayTransaction.setMessageIdentifier(resultSet.getString("MESSAGE_IDENTIFIER"));
		}
		
		return gatewayTransaction;	
	
	}
}
