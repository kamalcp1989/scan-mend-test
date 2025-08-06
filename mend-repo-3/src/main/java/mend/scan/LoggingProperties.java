/*
 * Copyright SITA Advanced Travel Solutions Limited 2021
 * Confidential. All rights reserved.
 */
package mend.scan;

import org.apache.logging.log4j.core.lookup.MainMapLookup;

/**
 * A helper class for registering logging properties.
 */
public final class LoggingProperties {

    private LoggingProperties() {
    }

    public static void registerLoggingProperties(final String appDomain, final String appName, final String appVersion) {
        MainMapLookup.setMainArguments("applicationDomain", appDomain, "applicationName", appName, "applicationVersion", appVersion);
    }
}
