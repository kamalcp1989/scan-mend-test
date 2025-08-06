/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2001-2016
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.exception;

/**
 * <p>MessageFormatException represents an error thrown during a message processing task, such
 * as message parsing or formatting, when an unexpected error in found in the format of
 * the message.</p>
 *
 * @version $Id: MessageFormatException.java 2481 2009-06-26 10:03:59Z alehane $
 * @author Joe Johnston
 *
 */
public class MessageFormatException extends FatalMessageException {

    /** The serialVersionUID. */
    private static final long serialVersionUID = 1221046722441598883L;

    /** Flag to indicate if the message body should be logged.*/
    private boolean iLogMessageBody = true;

    // ------------------------------------------------------------------------
    /**
     * Constructs an MessageFormatException with the specified detail message.
     *
     * @param message the detail message.
     */
    public MessageFormatException(final String message) {
        super(message);
    }

    /**
     * Constructs an MessageFormatException with the specified detail message.
     *
     * @param message the detail message.
     * @param logMessageBody the log message body flag
     */
    public MessageFormatException(final String message, final boolean logMessageBody) {
        super(message);
        iLogMessageBody = logMessageBody;
    }

    /**
     * Constructs an MessageFormatException with the specified detail message and
     * the specified cause.
     *
     * @param message The message.
     * @param cause The Throwable that caused the exception.
     */
    public MessageFormatException(final String message, final Throwable cause) {
        super(message, cause);
    }

    // ------------------------------------------------------------------------
    /**
     * Gets the iLogMessageBody field.
     *
     * @return the iLogMessageBody
     */
    public boolean isLogMessageBody() {
        return iLogMessageBody;
    }

    /**
     * Sets the iLogMessageBody field.
     *
     * @param logMessageBody the logMessageBody to set
     */
    public void setLogMessageBody(final boolean logMessageBody) {
        iLogMessageBody = logMessageBody;
    }


}
