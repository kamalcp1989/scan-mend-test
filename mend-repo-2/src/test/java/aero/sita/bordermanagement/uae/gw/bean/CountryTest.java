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

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class CountryTest implements ReferenceDataTestData {

    private static final String Y = "Y";
    private static Country.CountryBuilder builder;

    @BeforeEach 
    public void setUp() throws Exception {
        builder = new Country.CountryBuilder();
    }

    @Test
    public void fullyPopulatedTest() {
        
        Date date = new Date();
        builder.setEnabled("true");
        builder.setCreatedBy(USER);
        builder.setCreatedDatetime(date);
        builder.setModifiedBy(USER);
        builder.setModifiedDatetime(date);
        builder.setSitaCode(SITA_CODE);
        builder.setIsoCode1(ISO_CODE_1);
        builder.setIsoCode2(ISO_CODE_2);
        builder.setIsoCode3(ISO_CODE_3);  
        builder.setCountryOfBirth(Y);
        builder.setCountryOfOrigin(Y);
        builder.setNationality(Y);
        builder.setCountryOfIssue(Y);
        builder.setName(IATA_NAME);
        builder.setNameNL(IATA_NAME_NL);
        builder.setShortName(IATA_NAME_SHORT);
        builder.setShortNameNL(IATA_NAME_SHORT_NL);       
        builder.setDataReceived(TRUE_FLAG);    
        
        Country country = builder.build();

        Assertions.assertTrue(country.isEnabled());
        Assertions.assertTrue(country.isCountryOfBirth());
        Assertions.assertTrue(country.isCountryOfIssue());
        Assertions.assertTrue(country.isCountryOfOrigin());
        Assertions.assertTrue(country.isNationality());
        Assertions.assertTrue(country.getUsageType().contains(CountryUsageType.COUNTRY_OF_BIRTH));
        Assertions.assertTrue(country.getUsageType().contains(CountryUsageType.COUNTRY_OF_ISSUE));
        Assertions.assertTrue(country.getUsageType().contains(CountryUsageType.COUNTRY_OF_ORIGIN));
        Assertions.assertTrue(country.getUsageType().contains(CountryUsageType.NATIONALITY));
        Assertions.assertEquals(country.getCreatedBy(), USER);
        Assertions.assertEquals(country.getCreatedDatetime(), date);
        Assertions.assertEquals(country.getModifiedBy(), USER);
        Assertions.assertEquals(country.getModifiedDatetime(), date);
        
        Assertions.assertEquals(SITA_CODE, country.getSitaCode());
        Assertions.assertTrue(country.isSitaCode());
        Assertions.assertEquals(ISO_CODE_1, country.getIsoCode1());
        Assertions.assertEquals(ISO_CODE_2, country.getIsoCode2());
        Assertions.assertEquals(ISO_CODE_3, country.getIsoCode3());

        Assertions.assertTrue(country.isDataReceived());
      }
}
