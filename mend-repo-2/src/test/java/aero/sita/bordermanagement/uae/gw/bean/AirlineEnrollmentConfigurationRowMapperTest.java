package aero.sita.bordermanagement.uae.gw.bean;
import aero.sita.bordermanagement.uae.gw.bean.AirlineEnrollment;
import aero.sita.bordermanagement.uae.gw.bean.IAirlineEnrollment;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AirlineEnrollmentConfigurationRowMapperTest {

    @Test
    public void testMapRow() throws SQLException {
        // Mock ResultSet
        ResultSet resultSet = Mockito.mock(ResultSet.class);

        // Prepare mock behavior
        when(resultSet.getLong("ENROLLMENT_ID")).thenReturn(123L);
        when(resultSet.getString("SERVICE_ID")).thenReturn("SVC001");
        Date startDate = Date.valueOf("2025-01-01");
        Date createdDate = Date.valueOf("2025-01-02");
        Date modifiedDate = Date.valueOf("2025-01-03");
        when(resultSet.getDate("ENROLLMENT_START_DATE")).thenReturn(startDate);
        when(resultSet.getDate("CREATED_DATE")).thenReturn(createdDate);
        when(resultSet.getDate("LAST_MODIFIED_DATE")).thenReturn(modifiedDate);
        when(resultSet.getString("SERVICE_REQUEST_QUEUE")).thenReturn("REQ.Q");
        when(resultSet.getString("SERVICE_RESPONSE_QUEUE")).thenReturn("RESP.Q");
        when(resultSet.getString("AUTO_RESPONDER")).thenReturn("Y");

        // Run mapper
        AirlineEnrollmentConfigurationRowMapper rowMapper = new AirlineEnrollmentConfigurationRowMapper();
        IAirlineEnrollment enrollment = rowMapper.mapRow(resultSet, 1);

        // Validate result
        assertNotNull(enrollment);
        assertEquals(123L, enrollment.getEnrollmentId());
        assertEquals("SVC001", enrollment.getSenderSystem());
        assertEquals(startDate, enrollment.getEnrollmentStartDate());
        assertEquals(createdDate, enrollment.getCreatedDate());
        assertEquals(modifiedDate, enrollment.getLastModifiedDate());
        assertEquals("REQ.Q", enrollment.getServiceRequestQueue());
        assertEquals("RESP.Q", enrollment.getServiceResponseQueue());
        assertTrue(enrollment.isAutoResponder());
    }
}

