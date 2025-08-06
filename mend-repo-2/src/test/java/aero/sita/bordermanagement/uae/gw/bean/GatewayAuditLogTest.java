package aero.sita.bordermanagement.uae.gw.bean;

import aero.sita.bordermanagement.uae.gw.bean.GatewayAuditLog;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

public class GatewayAuditLogTest {

    @Test
    public void testGettersAndSetters() {
        GatewayAuditLog log = new GatewayAuditLog();

        Long auditLogId = 1L;
        String messageId = "msg123";
        String messageType = "typeA";
        String message = "sample message";
        String systemCode = "SYS001";
        String resultCode = "SUCCESS";
        Date creationTimestamp = Date.valueOf("2025-06-16");
        String hostname = "host1";
        String expectedPassengerId = "passengerX";
        String correlationId = "corr123";

        log.setAuditLogId(auditLogId);
        log.setMessageId(messageId);
        log.setMessageType(messageType);
        log.setMessage(message);
        log.setSystemCode(systemCode);
        log.setResultCode(resultCode);
        log.setCreationTimestamp(creationTimestamp);
        log.setHostname(hostname);
        log.setExpectedPassengerId(expectedPassengerId);
        log.setCorrelationId(correlationId);

        assertEquals(auditLogId, log.getAuditLogId());
        assertEquals(messageId, log.getMessageId());
        assertEquals(messageType, log.getMessageType());
        assertEquals(message, log.getMessage());
        assertEquals(systemCode, log.getSystemCode());
        assertEquals(resultCode, log.getResultCode());
        assertEquals(creationTimestamp, log.getCreationTimestamp());
        assertEquals(hostname, log.getHostname());
        assertEquals(expectedPassengerId, log.getExpectedPassengerId());
        assertEquals(correlationId, log.getCorrelationId());
    }
}
