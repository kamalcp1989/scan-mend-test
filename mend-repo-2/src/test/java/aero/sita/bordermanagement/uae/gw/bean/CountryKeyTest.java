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

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CountryKeyTest implements ReferenceDataTestData {

    @Test
    public void countryKeyConstructor() {
        ICountryKey countryKey = new CountryKey(IATA_CODE, PoliticalStateCodeType.ISO3);
        
        assertEquals(IATA_CODE, countryKey.getCode());
        assertEquals(PoliticalStateCodeType.ISO3, countryKey.getCodeType());
    }
    
}
