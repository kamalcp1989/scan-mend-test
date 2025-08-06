/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2001-2023
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.util;

import org.apache.logging.log4j.*;

/**
 * A helper class that will log warning messages to a warning log file.
 */
public class WarningHelper {

    /** The warning helper instance to give out. */
    private static final WarningHelper INSTANCE = new WarningHelper();

    /** The warning logger. */
    private static final Logger WARNING_LOG = LogManager.getLogger("Warning");

    //-----------------------------------------------------------------------
    /**
     * Gets the warning helper instance to use.
     *
     * @return  The warning helper instance to use.
     */
    public static WarningHelper getInstance() {
        return INSTANCE;
    }

    //-----------------------------------------------------------------------
    /**
     * Logs the initial message into the system and the reason why it's being logged.
     *
     * @param warningMessage  The warning message to log.
     */
	/*
	 * public void logWarning(final String warningMessage) {
	 * 
	 * WARNING_LOG.warn(warningMessage); }
	 */

    //-----------------------------------------------------------------------
    /**
     * Logs the initial message into the system and the reason why it's being logged.
     *
     * @param context  The message context.
     * @param warningMessage  The warning message to log.
     */
    public void logWarning(final String warningMessage) {

        logWarning(warningMessage, false);
    }

    //-----------------------------------------------------------------------
    /**
     * Logs the initial message into the system and the reason why it's being logged.
     *
     * @param context  The message context.
     * @param warningMessage  The warning message to log.
     * @param dumpContext  true if the entire context tree should be dumped, false otherwise.
     */
    public void logWarning(
            final String warningMessage,
            final boolean dumpContext) {

        

		/*
		 * String message; if (root.getRequestMessage() instanceof RawMessage) { message
		 * = ((RawMessage) root.getRequestMessage()).toString(); } else if
		 * (root.getResponseMessage() instanceof RawMessage) { message = ((RawMessage)
		 * root.getResponseMessage()).toString(); } else { message =
		 * "WARNING CANNOT FIND RAW TEXT MESSAGE!!!!"; }
		 * 
		 * StringBuilder buffer = new StringBuilder();
		 * 
		 * buffer.append("DATA_SOURCE: "); buffer.append(root.getDataSourceType());
		 * buffer.append(", WARNING: "); buffer.append(warningMessage);
		 * buffer.append(" MESSAGE: ["); buffer.append(message); buffer.append(']');
		 * 
		 * if (dumpContext) { WARNING_LOG.warn(() ->
		 * MessageContextHelper.dumpMessageContext(context, buffer.toString(), true)); }
		 * else { WARNING_LOG.warn(buffer); }
		 */
    }

    /**
     * Checks whether WARNING_LOG is enabled for the {@link Level#WARN WARN} Level.
     *
     * @return boolean - {@code true} if this Logger is enabled for level {@link Level#WARN WARN}, {@code false} otherwise.
     */
    public boolean isEnabled() {
        return WARNING_LOG.isWarnEnabled();
    }
}
