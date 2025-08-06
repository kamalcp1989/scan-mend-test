package aero.sita.bordermanagement.uae.gw.bean;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ErrorDescTest {

    @Test
    public void testErrorCodeGetterSetter() {
        ErrorDesc errorDesc = new ErrorDesc();
        errorDesc.setErrorCode("ERR001");

        assertEquals("ERR001", errorDesc.getErrorCode());
    }

    @Test
    public void testDescGetterSetter() {
        ErrorDesc errorDesc = new ErrorDesc();
        errorDesc.setDesc("Generic error");

        assertEquals("Generic error", errorDesc.getDesc());
    }

    @Test
    public void testDescArGetterSetter() {
        ErrorDesc errorDesc = new ErrorDesc();
        errorDesc.setDescAr("خطأ عام");

        assertEquals("خطأ عام", errorDesc.getDescAr());
    }

    @Test
    public void testAllFieldsTogether() {
        ErrorDesc errorDesc = new ErrorDesc();
        errorDesc.setErrorCode("ERR002");
        errorDesc.setDesc("Connection timeout");
        errorDesc.setDescAr("انتهت مهلة الاتصال");

        assertAll(
            () -> assertEquals("ERR002", errorDesc.getErrorCode()),
            () -> assertEquals("Connection timeout", errorDesc.getDesc()),
            () -> assertEquals("انتهت مهلة الاتصال", errorDesc.getDescAr())
        );
    }
}
