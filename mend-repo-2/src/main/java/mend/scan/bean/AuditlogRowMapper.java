/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * TransportStageQualifierRowMapper
 */
public class AuditlogRowMapper implements RowMapper<IGatewayAuditLog> {

	public IGatewayAuditLog mapRow(final ResultSet resultSet, final int row) throws SQLException {
		final GatewayAuditLog gatewayAuditLog = new GatewayAuditLog();
		gatewayAuditLog.setAuditLogId(Long.valueOf(resultSet.getLong("AUDIT_LOG_ID")));
		gatewayAuditLog.setCorrelationId(String.valueOf(resultSet.getString("CORRELATION_ID")));
		gatewayAuditLog.setMessageIdentifier(String.valueOf(resultSet.getString("MESSAGE_IDENTIFIER")));
		return gatewayAuditLog;
	}
}
