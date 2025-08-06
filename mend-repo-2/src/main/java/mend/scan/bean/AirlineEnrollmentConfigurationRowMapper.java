/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * AirlineEnrollmentConfigurationRowMapper
 */
public class AirlineEnrollmentConfigurationRowMapper implements RowMapper<IAirlineEnrollment> {

	public IAirlineEnrollment mapRow(final ResultSet resultSet, final int row) throws SQLException {
		
		final AirlineEnrollment airlineConfig = new AirlineEnrollment();
		
		airlineConfig.setEnrollmentId(Long.valueOf(resultSet.getLong("ENROLLMENT_ID")));
		airlineConfig.setSenderSystem(String.valueOf(resultSet.getString("SENDER_SYSTEM")));
		airlineConfig.setAirlineCodes(String.valueOf(resultSet.getString("AIRLINE_CODES")));
		airlineConfig.setEnrollmentStartDate(resultSet.getDate("ENROLLMENT_START_DATE"));
		airlineConfig.setCreatedDate(resultSet.getDate("CREATED_DATE"));
		airlineConfig.setLastModifiedDate(resultSet.getDate("LAST_MODIFIED_DATE"));
		airlineConfig.setServiceRequestQueue(resultSet.getString("SERVICE_REQUEST_QUEUE"));
		airlineConfig.setServiceResponseQueue(resultSet.getString("SERVICE_RESPONSE_QUEUE"));
		airlineConfig.setConcurrentConsumer(resultSet.getLong("CONCURRENT_CONSUMER"));
		airlineConfig.setMaxConcurrentConsumer(resultSet.getLong("MAX_CONCURRENT_CONSUMER"));
		String autoResponder = resultSet.getString("AUTO_RESPONDER");
		if ("Y".equalsIgnoreCase(autoResponder)) {
			airlineConfig.setAutoResponder(true);;	
		}
		return airlineConfig;
	}

}
