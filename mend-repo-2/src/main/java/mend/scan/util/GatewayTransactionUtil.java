package aero.sita.bordermanagement.uae.gw.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GatewayTransactionUtil {
	
	public static String generateEdifactTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd:HHmm");
        return now.format(formatter);
    }
}
