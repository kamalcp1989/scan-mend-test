/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * ErrorCodeRowMapper
 */
public class ErrorCodeRowMapper implements RowMapper<IErrorDesc> {

	public IErrorDesc mapRow(final ResultSet resultSet, final int row) throws SQLException {
		
		final ErrorDesc errorCodeDesc = new ErrorDesc();
		
		errorCodeDesc.setErrorCode(String.valueOf(resultSet.getString("ERROR_CODE")));
		errorCodeDesc.setDesc(String.valueOf(resultSet.getString("DESCRIPTION")));
		if (resultSet.getString("DESCRIPTION_AR") != null) {
			errorCodeDesc.setDescAr(String.valueOf(resultSet.getString("DESCRIPTION_AR")));
		}
		return errorCodeDesc;
	}

}
