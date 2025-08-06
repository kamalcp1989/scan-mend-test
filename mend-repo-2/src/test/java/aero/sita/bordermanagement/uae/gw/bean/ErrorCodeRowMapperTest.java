package aero.sita.bordermanagement.uae.gw.bean;

import aero.sita.bordermanagement.uae.gw.bean.ErrorDesc;
import aero.sita.bordermanagement.uae.gw.bean.ErrorCodeRowMapper;
import aero.sita.bordermanagement.uae.gw.bean.IErrorDesc;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ErrorCodeRowMapperTest {

    @Test
    public void testMapRow_WithArabicDescription() throws SQLException {
        // Arrange
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getString("ERROR_CODE")).thenReturn("ERR001");
        when(resultSet.getString("DESCRIPTION")).thenReturn("Some error description");
        when(resultSet.getString("DESCRIPTION_AR")).thenReturn("بعض الوصف");

        ErrorCodeRowMapper rowMapper = new ErrorCodeRowMapper();

        // Act
        IErrorDesc result = rowMapper.mapRow(resultSet, 1);

        // Assert
        assertNotNull(result);
        assertTrue(result instanceof ErrorDesc);
        ErrorDesc errorDesc = (ErrorDesc) result;

        assertEquals("ERR001", errorDesc.getErrorCode());
        assertEquals("Some error description", errorDesc.getDesc());
        assertEquals("بعض الوصف", errorDesc.getDescAr());
    }

    @Test
    public void testMapRow_WithoutArabicDescription() throws SQLException {
        // Arrange
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getString("ERROR_CODE")).thenReturn("ERR002");
        when(resultSet.getString("DESCRIPTION")).thenReturn("Another error");
        when(resultSet.getString("DESCRIPTION_AR")).thenReturn(null);

        ErrorCodeRowMapper rowMapper = new ErrorCodeRowMapper();

        // Act
        IErrorDesc result = rowMapper.mapRow(resultSet, 2);

        // Assert
        assertNotNull(result);
        assertTrue(result instanceof ErrorDesc);
        ErrorDesc errorDesc = (ErrorDesc) result;

        assertEquals("ERR002", errorDesc.getErrorCode());
        assertEquals("Another error", errorDesc.getDesc());
        assertNull(errorDesc.getDescAr());
    }
}
