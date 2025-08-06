package aero.sita.bordermanagement.uae.gw.bean;


import aero.sita.bordermanagement.uae.gw.bean.GatewayTransaction;
import aero.sita.bordermanagement.uae.gw.bean.IGatewayTransaction;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GatewayTransactionRowMapperTest {
	
	
	
	@Test
    public void testMapRow() throws SQLException {
        // Mock ResultSet
        ResultSet rs = mock(ResultSet.class);

        // Set up mock values
        when(rs.getLong("EXPECTED_PASSENGER_ID")).thenReturn(101L);
        when(rs.getString("CORRELATION_ID")).thenReturn("CID123");
        when(rs.getString("MESSAGE_REF_NUMBER")).thenReturn("MRN001");
        when(rs.getLong("INTERCHANGE_CONTROL_REFERENCE")).thenReturn(202406L);
        when(rs.getString("GROUP_REF_NUMBER")).thenReturn("GRP987");
        when(rs.getString("PAX_REF_NUMBER")).thenReturn("PAX555");
        when(rs.getString("PAX_NAME_RECORD")).thenReturn("DOE/JOHN");
        when(rs.getString("SEAT_NO")).thenReturn("12A");
        when(rs.getString("GOVT_AGENCY_CODE")).thenReturn("UAE");
        when(rs.getString("FREQUENT_FLYER_ID")).thenReturn("FF123456");
        when(rs.getString("APPLICATION_SENDER_IDENTIFICATION")).thenReturn("SITA");

        // Execute mapper
        GatewayTransactionRowMapper mapper = new GatewayTransactionRowMapper();
        IGatewayTransaction txn = mapper.mapRow(rs, 1);

        // Verify results
        assertNotNull(txn);
        assertEquals(101L, txn.getExpectedPassengerId());
        assertEquals("CID123", txn.getCorrelationId());
        assertEquals("MRN001", txn.getMessageRefNumber());
        assertEquals("202406", txn.getInterchangeControlReference());
        assertEquals("GRP987", txn.getGroupRefNumber());
        assertEquals("PAX555", txn.getPaxRefNumber());
        assertEquals("DOE/JOHN", txn.getPaxNameRecord());
        assertEquals("12A", txn.getSeatNo());
        assertEquals("UAE", txn.getGovtAgencyCode());
        assertEquals("FF123456", txn.getFrequentFlyerId());
        assertEquals("SITA", txn.getApplicationSenderIdentification());
    }

}
