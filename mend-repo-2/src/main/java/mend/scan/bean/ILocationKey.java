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
 * Used when selecting a single location by the getLocationByKey service method.
 * Standard implementation by {@link aero.sita.gsl.refdata.api.model.LocationKey}
 * 
 * @see aero.sita.gsl.refdata.api.service.ILocationService#getLocationByKey
 * @see aero.sita.gsl.refdata.api.model.LocationKey
 */
public interface ILocationKey {

    /**
     * Used to get the location using the combination of code and type (IATA, ICAO, UNLOC, SITA, UNKNOWN, OTHER).
     * @see aero.sita.gsl.refdata.api.enumeration.LocationCodeType 
     * 
     * @return location code to use when retrieving location data.
     */
    String getCode();

    /**
     * Used to get the location using the combination of type (IATA, ICAO, UNLOC, SITA, UNKNOWN, OTHER) and code.
     * @see aero.sita.gsl.refdata.api.enumeration.LocationCodeType 
     * 
     * @return code type to use when retrieving location data.
     */
    LocationCodeType getCodeType();

    
}
