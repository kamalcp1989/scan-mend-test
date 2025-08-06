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

import java.util.Date;

/**
 *
 * Interface for all reference data objects, eg Location, Carrier.
 */
public interface IReferenceData {

    /**
     * Is this reference data item enabled?
     * @return is reference data item enabled.
     */
    boolean isEnabled();

    /**
     * Get the name of reference data in default language, typically English.
     * @return name of reference data in default language, typically English.
     */
    String getName();

    /**
     * Gets the reference of the person who created this reference data item in the data store.
     * @return created by.
     */
    String getCreatedBy();

    /**
     * Gets the data and time when this reference data item was created in the data store.
     * @return created date.
     */
    Date getCreatedDatetime();

    /**
     * Gets the reference of the person who last modified this reference data item in the data store.
     * @return modified by.
     */
    String getModifiedBy();
    
    
    /**
     * Gets the data and time when this reference data item was last modified in the data store.
     * @return modified date.
     */
    Date getModifiedDatetime();

    /**
     * Get the unique identifier for this reference data entity.
     * @return int the unique identifier.
     */
    String getSitaCode();

    /**
     * Does the unique identifier for this reference data entity exist.
     * @return boolean true if unique identifier is set.
     */
    boolean isSitaCode();

}
