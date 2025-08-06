/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2009
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.util.List;

/**
 * Interface for Base Location class.
 */
public interface IBaseLocation extends IReferenceData {

    /**
     * Gets the national locale location name.
     * @return national locale location name.
     */
    String getNameNL();

    /**
     * Gets the short location name in default language, typically English.
     * @return short location name in default language, typically English.
     */
    String getShortName();

    /**
     * Gets the short location name in national locale.
     * @return short location name in national locale.
     */
    String getShortNameNL();

    /**
     * Is there associated data with this location, eg, flight, traveller information.
     * @return is there associated data with this location, eg, flight, traveller information.
     */
    boolean isDataReceived();
    
    /**
     * Returns the list of the groups associated to this location.
     * @return list of associated groups for this location.
     */
    //List<IGroup> getGroups();

}
