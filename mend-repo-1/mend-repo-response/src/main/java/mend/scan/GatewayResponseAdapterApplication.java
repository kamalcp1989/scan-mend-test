package aero.sita.bordermanagement.uae.gw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import mend.scan.LoggingProperties;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class GatewayResponseAdapterApplication {
	
    private static final Logger LOG = LoggerFactory.getLogger(GatewayResponseAdapterApplication.class);
    
    /** The name to use as the fishTag for application logging. */
    public static final String APPLICATION_LOGGING_NAME = "GATEWAY-RESPONSE-ADAPTER";

	public static void main(String[] args) {
        create().run();
	}
	
	public static SpringApplicationBuilder create() {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(GatewayResponseAdapterApplication.class);
        return builder;
    }

}