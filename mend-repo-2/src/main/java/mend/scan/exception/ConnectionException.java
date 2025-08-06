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
 * <p>ConnectionException represents an error thrown during a message processing task.
 * when a given message cannot be processed by the specified processor.</p>
 *
 * <p>Implementations of the MessageConsumer interface should throw this exception in response
 * to unknown messages. </p>
 *
 * @version $Id: ConnectionException.java 16724 2014-02-04 16:50:31Z alehane $
 * @author njones
 *
 */
public class ConnectionException extends FatalMessageException {

    /** The serialVersionUID. */
    private static final long serialVersionUID = 1221046722441598883L;

    // ------------------------------------------------------------------------
    /**
     * Constructs an UnknownMessageException with the specified detail message.
     *
     * @param message the detail message.
     */
    public ConnectionException(final String message) {
        super(message);
    }

    /**
     * Constructs an UnknownMessageException with the specified detail message and
     * the specified cause.
     *
     * @param message The message.
     * @param cause The Throwable that caused the exception.
     */
    public ConnectionException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
