/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2024
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.exception;

/**
 * InvalidFlightNumberException represents an error thrown when validating
 * the flight number.
 */
public class InvalidFlightNumberException extends IllegalArgumentException{

    /**
     * Constructor.
     * 
     * @param message the error message
     */
    public InvalidFlightNumberException(final String message) {
        super(message);
    }
    
    /**
     * Constructor.
     * 
     * @param message the error message
     * @param cause Throwable
     */
    public InvalidFlightNumberException(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructor.
     * 
     * @param cause Throwable
     */
    public InvalidFlightNumberException(final Throwable cause) {
        super(cause);
    }
    
    /**
     * Constructor.
     */
    public InvalidFlightNumberException() {
        super();
    }
}
