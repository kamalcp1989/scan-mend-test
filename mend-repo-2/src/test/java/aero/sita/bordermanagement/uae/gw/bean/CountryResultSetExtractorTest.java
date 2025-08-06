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

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aero.sita.bordermanagement.uae.gw.bean.Country.CountryBuilder;



/**
 *Test class for CountryResultsetExtractor.
 */
public class CountryResultSetExtractorTest {
    private CountryResultSetExtractor resultSetExtractor;

    @BeforeEach
    public void setup() {
        resultSetExtractor = new CountryResultSetExtractor();
    }

    @Test
    public void testExtractData() {
        try {
            ResultSet mockRS = mock(ResultSet.class);
            CountryBuilder expected = new Country.CountryBuilder();
            expected.setIsoCode3("GBR");
            expected.setName("Great Britan");
            //GroupBuilder expectedGroupBuilder = new Group.GroupBuilder();
            //expectedGroupBuilder.setDescription("GROUP_DESCRIPTION");
            //expectedGroupBuilder.setDescriptionNL("GROUP_DESCRIPTION_NL");
            //expectedGroupBuilder.setCode("CODE");
            //Group expectedGroup = expectedGroupBuilder.build();
            //expected.addGroup(expectedGroupBuilder.build());
            when(mockRS.next()).thenReturn(true).thenReturn(false);
            when(mockRS.getString("isoCode3")).thenReturn("GBR");
            when(mockRS.getString("name")).thenReturn("Great Britan");
            when(mockRS.getString("group_code")).thenReturn("CODE");
            when(mockRS.getString("group_description")).thenReturn("GROUP_DESCRIPTION");
            when(mockRS.getString("group_description_nl")).thenReturn("GROUP_DESCRIPTION_NL");

            ICountry expectedCountry = expected.build();

            List<ICountry> countriesReturned = resultSetExtractor.extractData(mockRS);
            ICountry actual = countriesReturned.get(0);
            //List<IGroup> actualGroupList = actual.getGroups();
            //IGroup actualGroup = actualGroupList.get(0);
            //Assert.assertNotNull(countriesReturned);
            //Assert.assertEquals(actual.getIsoCode3(), expectedCountry.getIsoCode3());
            //Assert.assertNotNull(actual.getIdentifier());
            //Assert.assertEquals(actual.getName(), expectedCountry.getName());
            //Assert.assertEquals(actual.getIdentifier().getCode(), expected.getIdentifier().getCode());
            //Assert.assertEquals(actualGroup.getCode(), expectedGroup.getCode());
            //Assert.assertEquals(actualGroup.getDescription(), expectedGroup.getDescription());
            //Assert.assertEquals(actualGroup.getDescriptionNL(), expectedGroup.getDescriptionNL());

        } catch (SQLException e) {
            fail("was not expecting an Exception");
        }
    }

}
