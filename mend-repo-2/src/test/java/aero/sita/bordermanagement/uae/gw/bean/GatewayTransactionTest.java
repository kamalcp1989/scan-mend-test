package aero.sita.bordermanagement.uae.gw.bean;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class GatewayTransactionTest {

    @Test
    void testAllSettersAndGetters() {
        GatewayTransaction txn = new GatewayTransaction();

        // Set values
        txn.setExpectedPassengerId(1001L);
        txn.setMessageRefNumber("MSG123");
        txn.setGroupRefNumber("GRP789");
        txn.setCorrelationId("CORR456");
        txn.setTransactionDatetime(LocalDateTime.now());
        txn.setAppResponseDatetime(LocalDateTime.now().plusSeconds(60));
        txn.setUpdateVersionNo(2);
        txn.setInterchangeControlReference("INT456");
        txn.setApplicationSenderIdentification("APP001");
        txn.setControllingAgency("ICAO");
        txn.setMessageTypeVersionNumber("1.1");
        txn.setTravellerType("Passenger");
        txn.setMessageType("PAXLST");
        txn.setPartyNameOperator("Emirates");
        txn.setSenderTelephone("+9711234567");
        txn.setSenderFax("+9711234568");
        txn.setSenderEmail("sender@example.com");
        txn.setPartySurname("Doe");
        txn.setPartyFirstName("John");
        txn.setPartySecondName("Middle");
        txn.setAddressStreet("123 Airport Road");
        txn.setAddressCity("Dubai");
        txn.setAddressStateProvince("DU");
        txn.setAddressZipCode("00000");
        txn.setAddressCountry("AE");
        txn.setGender("M");
        txn.setDateOfBirth(LocalDate.of(1990, 1, 1));
        txn.setBagtagNo("BT123");
        txn.setBaggageCount(2);
        txn.setBaggageWeight(new BigDecimal("40.5"));
        txn.setFreeText("VIP Passenger");
        txn.setCustomsClearanceAirport("DXB");
        txn.setCountryOfResidence("AE");
        txn.setCountryOfBirth("IN");
        txn.setPartyTelephone("+9715555555");
        txn.setPartyFax("+9715555556");
        txn.setPartyEmail("john.doe@example.com");
        txn.setPartyNationality("IN");
        txn.setSeatNo("22A");
        txn.setFrequentFlyerId("EK123456");
        txn.setGovtAgencyCode("GOV001");
        txn.setPaxRefNumber("PRN999");
        txn.setPaxNameRecord("PNR0001");
        txn.setPaxInfoVarificationIndicator(true);
        txn.setDocumentType("P");
        txn.setDocumentNumber("A1234567");
        txn.setDocumentIssueDate(LocalDate.of(2015, 1, 1));
        txn.setDocumentExpiryDate(LocalDate.of(2025, 1, 1));
        txn.setDocumentIssuingCountry("IN");
        txn.setAdditionalDocumentType("VISA");
        txn.setAdditionalDocumentNumber("V123456");
        txn.setAdditionalDocumentIssueDate(LocalDate.of(2020, 6, 1));
        txn.setAdditionalDocumentExpiryDate(LocalDate.of(2026, 6, 1));
        txn.setAdditionalDocumentIssuingCountry("AE");

        // Verify a few fields
        assertEquals("MSG123", txn.getMessageRefNumber());
        assertEquals("PAXLST", txn.getMessageType());
        assertEquals("22A", txn.getSeatNo());
        assertEquals(LocalDate.of(1990, 1, 1), txn.getDateOfBirth());
        assertEquals(new BigDecimal("40.5"), txn.getBaggageWeight());
        assertTrue(txn.getPaxInfoVarificationIndicator());
    }
}

