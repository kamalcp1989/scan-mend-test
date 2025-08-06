/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

/**
 * TransportStageQualifierRowMapper
 */
public class TransportStageQualifierRowMapper implements RowMapper<ITransportStageQualifier> {

	public ITransportStageQualifier mapRow(final ResultSet resultSet, final int row) throws SQLException {
		
		final TransportStageQualifier transportStageQualifier = new TransportStageQualifier();
		
		transportStageQualifier.setCorrelationId(String.valueOf(resultSet.getString("CORRELATION_ID")));
		transportStageQualifier.setCarrierCode(String.valueOf(resultSet.getString("CARRIER_CODE")));
		transportStageQualifier.setJourneyIdentifier(String.valueOf(resultSet.getString("JOURNEY_IDENTIFIER")));
		transportStageQualifier.setDTMFunctionCode(String.valueOf(resultSet.getString("DTM_FUNCTION_CODE")));
		transportStageQualifier.setLocationFunctionCode(String.valueOf(resultSet.getString("LOCATION_FUNCTION_CODE")));
		transportStageQualifier.setLocationNameCode(String.valueOf(resultSet.getString("LOCATION_NAME_CODE")));
		transportStageQualifier.setDTMDateTime(String.valueOf(resultSet.getString("DTM_DATETIME")));
        
		return transportStageQualifier;	
	}
}
