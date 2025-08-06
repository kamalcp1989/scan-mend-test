/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package mend.scan;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author SITA
 *
 */
@SpringBootApplication
@EnableJms
@EnableScheduling
@EnableCaching
public class GatewayRequestAdapterApplication {

    /** The name to use as the fishTag for application logging. */
    public static final String APPLICATION_LOGGING_NAME = "GATEWAY-REQUEST-ADAPTER";

    /**
     * @param args
     */
    public static void main(String[] args) {
        create().run();
    }

    /**
     * @return SpringApplicationBuilder
     */
    public static SpringApplicationBuilder create() {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(GatewayRequestAdapterApplication.class);
        return builder;
    }
}
