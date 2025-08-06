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
 * <p>MessageException represents an error thrown during a message processing task.</p>
 * <p>Implementations of the MessageConsumer interface should throw this exception in response
 * to fatal message processing errors. </p>
 *
 * @version $Id: FatalMessageException.java 16724 2014-02-04 16:50:31Z alehane $
 * @author njones
 *
 */
public class FatalMessageException extends RuntimeException {

    /** The serialVersionUID. */
    private static final long serialVersionUID = -2552565009930604313L;

    // ------------------------------------------------------------------------
    /**
     * Constructs a MessageException with the specified detail message.
     *
     * @param message the detail message.
     */
    public FatalMessageException(final String message) {
        super(message);
    }

    /**
     * Constructs a MessageException with the specified detail message and
     * the specified cause.
     *
     * @param message The message.
     * @param cause The Throwable that caused the exception.
     */
    public FatalMessageException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
