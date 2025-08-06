package mend.scan;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import mend.scan.*;
import mend.scan.LoggingProperties;

@SpringBootApplication
public class GatewayParserApplication {
	
    /** The name to use as the fishTag for application logging. */
    public static final String APPLICATION_LOGGING_NAME = "GATEWAY-PARSER";
	
	public static void main(String[] args) {
        create().run();
	}
	
	public static SpringApplicationBuilder create() {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(GatewayParserApplication.class);
        return builder;
    }

}
