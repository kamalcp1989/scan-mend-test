package aero.sita.bordermanagement.uae.gw.bean;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import aero.sita.bordermanagement.uae.gw.cusres.Group3LocationDTM;

public class TransportStageQualifierTest {
	
	@Test
    public void testGettersAndSetters() {
		TransportStageQualifier obj = new TransportStageQualifier();

        String correlationId = "corr-123";
        String journeyIdentifier = "journey-456";
        String carrierCode = "CC789";
        List<Group3LocationDTM> grp3 = new ArrayList<>();
        // optionally add dummy Group3LocationDTM objects to grp3 if needed
        String locationFunctionCode = "LOCFC";
        String locationNameCode = "LOCNC";
        String DTMFunctionCode = "DTMFC";
        String DTMDateTime = "20250616T123000";

        obj.setCorrelationId(correlationId);
        obj.setJourneyIdentifier(journeyIdentifier);
        obj.setCarrierCode(carrierCode);
        obj.setGrp3(grp3);
        obj.setLocationFunctionCode(locationFunctionCode);
        obj.setLocationNameCode(locationNameCode);
        obj.setDTMFunctionCode(DTMFunctionCode);
        obj.setDTMDateTime(DTMDateTime);

        assertEquals(correlationId, obj.getCorrelationId());
        assertEquals(journeyIdentifier, obj.getJourneyIdentifier());
        assertEquals(carrierCode, obj.getCarrierCode());
        assertEquals(grp3, obj.getGrp3());
        assertEquals(locationFunctionCode, obj.getLocationFunctionCode());
        assertEquals(locationNameCode, obj.getLocationNameCode());
        assertEquals(DTMFunctionCode, obj.getDTMFunctionCode());
        assertEquals(DTMDateTime, obj.getDTMDateTime());
    }

}
