/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2012
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.util.List;

/**
 * A country which can be defined by 1, 2 and/or 3 character code.
 * Its use can be one or more of the following:
 * Country of Origin (default use);
 * Nationality;
 * Country of issue;
 * Country of birth.
 */
public interface ICountry extends IIdentifiable<ICountryKey>, IPoliticalState {
    
    /**
    * Is country code applicable to use as country of origin?
     * @return countryOfOrigin true or false
     */
    boolean isCountryOfOrigin();
    
    /** 
     * Is country code applicable to use as a nationality?
     * @return nationality true or false
     */
    boolean isNationality();
    
    /**
     * Is country code applicable to use as country of issue?
     * @return countryOfIssue true or false
     */
    boolean isCountryOfIssue();
    
    /**
     * Is country code applicable to use as country of birth?
     * @return countryOfBirth true or false
     */
    boolean isCountryOfBirth();
    
    /**
     * Returns the list of the use of this country, by birth, country of origin, nationality, and/or country of issue.
     * @return list of usages for this country.
     */
    List<CountryUsageType> getUsageType();
    
}
