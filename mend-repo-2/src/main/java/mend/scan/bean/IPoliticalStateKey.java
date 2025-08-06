/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2013
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.bean;

/**
 * Used when selecting a single political state entity by the  get...Of...service methods.
 */
public interface IPoliticalStateKey {

    /**
     * Used to get the political state using the combination of code and type (SITA, ISO-1, ISO-2, ISO-3).
     * @see aero.sita.gsl.refdata.api.enumeration.PoliticalStateCodeType 
     * 
     * @return country code to use when retrieving country data.
     */
    String getCode();

    /**
     * Used to get the political state using the combination of code and type (SITA, ISO-1, ISO-2, ISO-3).
     * @see aero.sita.gsl.refdata.api.enumeration.PoliticalStateCodeType 
     * 
     * @return code type to use when retrieving country data.
     */
    PoliticalStateCodeType getCodeType();
}
