/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2014-2016
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.exception;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class XmlValidationException extends MessageException {

    // ===========================================
    // Public Members
    // ===========================================

    // ===========================================
    // Private Members
    // ===========================================
    /** The raw errors. */
    private List<String> iRawErrorList = new ArrayList<>();

    // ===========================================
    // Static initialisers
    // ===========================================

    // ===========================================
    // Constructors
    // ===========================================
    /**
     * Instantiates a new xml validation exception.
     *
     * @param message the message
     * @param rawErrors the raw errors
     */
    public XmlValidationException(final String message, final List<String> rawErrors) {
        super(message);
        iRawErrorList = rawErrors;
    }

    // ===========================================
    // Public Methods
    // ===========================================
    /**
     * Gets the errorList field.
     *
     * @return the errorList
     */
    public List<String> getRawErrorList() {
        return iRawErrorList;
    }

    // ===========================================
    // Protected Methods
    // ===========================================

    // ===========================================
    // Private Methods
    // ===========================================
}
