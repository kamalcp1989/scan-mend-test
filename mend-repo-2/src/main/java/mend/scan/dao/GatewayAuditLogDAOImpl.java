/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.dao;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import aero.sita.bordermanagement.uae.gw.bean.AuditlogRowMapper;
import aero.sita.bordermanagement.uae.gw.bean.IGatewayAuditLog;

/**
 * @author SITA
 *
 */
@Service
public class GatewayAuditLogDAOImpl {
	
	

	
    /**
     * Named JDBC template
     */
    @Autowired
    @Qualifier("namedJdbcTemplate")
    private NamedParameterJdbcTemplate  jdbcTemplate;
    
    
    private static final String SELECT_AUDIT_LOG_BY_MSI = """
            SELECT * FROM GATEWAY_TRANSACTION_AUDIT_LOG
            WHERE MESSAGE_IDENTIFIER = :messageIdentifier and MESSAGE_TYPE = :messageType
        """;
    
    
    public void insertLogRecord(final IGatewayAuditLog gatewayAuditLog) {
        String sql = """
            INSERT INTO GATEWAY_TRANSACTION_AUDIT_LOG (
                AUDIT_LOG_ID,
                MESSAGE_TYPE,
                MESSAGE,
                AIRLINECODE,
                RESULTCODE,
                CREATION_TIMESTAMP,
                HOSTNAME,
                CORRELATION_ID,
                MESSAGE_IDENTIFIER
            ) VALUES (
                GATEWAY_TRANSACTION_AUDIT_LOG_SEQ.NEXTVAL,
                :messageType,
                :message,
                :airlineCode,
                :resultCode,
                :creationTimestamp,
                :hostName,
                :correlationId,
                :messageIdentifier
            )
            """;

        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("messageType", gatewayAuditLog.getMessageType())
            .addValue("message", gatewayAuditLog.getMessage())
            .addValue("airlineCode", gatewayAuditLog.getSystemCode()) //Sending system code as airline code. AIRLINECODE column in table can be renamed.
            .addValue("resultCode", gatewayAuditLog.getResultCode())
            .addValue("creationTimestamp", java.time.LocalDateTime.now())
            .addValue("hostName", gatewayAuditLog.getHostname())
        	.addValue("correlationId", gatewayAuditLog.getCorrelationId())
        	.addValue("messageIdentifier", gatewayAuditLog.getMessageIdentifier());

        jdbcTemplate.update(sql, params);
    }
    
    public List<IGatewayAuditLog> findAuditLogByMsiAndMtype(String messageIdentifier, String messageType) {
    	Map<String, Object> params = Map.of(			        
		        "messageIdentifier", messageIdentifier,
		        "messageType", messageType
		    );
        return jdbcTemplate.query(SELECT_AUDIT_LOG_BY_MSI, params, new AuditlogRowMapper());
    }


}
