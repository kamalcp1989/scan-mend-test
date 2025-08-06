package aero.sita.bordermanagement.uae.gw.bean;


import aero.sita.bordermanagement.uae.gw.bean.ITransportStageQualifier;
import aero.sita.bordermanagement.uae.gw.bean.TransportStageQualifierRowMapper;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TransportStageQualifierRowMapperTest {
	
	@Test
    public void testMapRow() throws SQLException {
        // Mock the ResultSet
        ResultSet rs = mock(ResultSet.class);

        // Define mock behavior
        when(rs.getString("CORRELATION_ID")).thenReturn("CID001");
        when(rs.getString("CARRIER_CODE")).thenReturn("EK");
        when(rs.getString("JOURNEY_IDENTIFIER")).thenReturn("JI123");
        when(rs.getString("DTM_FUNCTION_CODE")).thenReturn("132");
        when(rs.getString("LOCATION_FUNCTION_CODE")).thenReturn("178");
        when(rs.getString("LOCATION_NAME_CODE")).thenReturn("DXB");
        when(rs.getString("DTM_DATETIME")).thenReturn("202506150930");

        // Run the mapper
        TransportStageQualifierRowMapper mapper = new TransportStageQualifierRowMapper();
        ITransportStageQualifier result = mapper.mapRow(rs, 1);

        // Assertions
        assertNotNull(result);
        assertEquals("CID001", result.getCorrelationId());
        assertEquals("EK", result.getCarrierCode());
        assertEquals("JI123", result.getJourneyIdentifier());
        assertEquals("132", result.getDTMFunctionCode());
        assertEquals("178", result.getLocationFunctionCode());
        assertEquals("DXB", result.getLocationNameCode());
        assertEquals("202506150930", result.getDTMDateTime());
    }

}
