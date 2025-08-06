/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * StatusCodeRowMapper
 */
public class StatusCodeRowMapper implements RowMapper<IStatusCodeDesc> {

	public IStatusCodeDesc mapRow(final ResultSet resultSet, final int row) throws SQLException {
		
		final StatusCodeDesc statusCodeDesc = new StatusCodeDesc();
		
		statusCodeDesc.setMessageCode(String.valueOf(resultSet.getString("MESSAGE_CODE")));
		statusCodeDesc.setPaxStatusCode(String.valueOf(resultSet.getString("PAX_STATUS_CODE")));
		statusCodeDesc.setDesc(String.valueOf(resultSet.getString("DESCRIPTION")));
		if (resultSet.getString("DESCRIPTION_AR") != null) {
			statusCodeDesc.setDescAr(String.valueOf(resultSet.getString("DESCRIPTION_AR")));
		}
		return statusCodeDesc;
	}

}
