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

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aero.sita.bordermanagement.uae.gw.bean.Country.CountryBuilder;

/**
 * This Class utility class converts the JDBC ResultSet into List<ICountry> objects.
 *
 */
public class CountryResultSetExtractor extends AbstractPoliticalStateResultSetExtractor<CountryBuilder, ICountry> {
    
    /** the logger. */
    private static final Logger LOG = LoggerFactory.getLogger(CountryResultSetExtractor.class);
    /** Boolean flag to indicate if entity can be used as Country of origin. */
    private static final String COUNTRY_OF_ORIGIN_FLAG = "countryOfOrigin";
    /** Boolean flag to indicate if country can be used as Country of issue. */
    private static final String COUNTRY_OF_ISSUE_FLAG = "countryOfIssue";
    /** Boolean flag to indicate if country can be used as Country of birth. */
    private static final String COUNTRY_OF_BIRTH_FLAG = "countryOfBirth";
    /** Boolean flag to indicate if country can be used as Nationality. */
    private static final String NATIONALITY_FLAG = "nationality";

    @Override
    protected CountryBuilder createBuilder() throws SQLException {
        CountryBuilder countryBuilder = new Country.CountryBuilder();
        return countryBuilder;
    }
    
    @Override
    protected void mapReferenceDataRow(
            final ResultSet rs,
            final CountryBuilder countryBuilder) throws SQLException {
        
        super.mapReferenceDataRow(rs, countryBuilder);
        
        if (LOG.isTraceEnabled()) {
        	LOG.trace("CountryResultSetExtractor " + rs.getString(ISOCODE3) + " cob=" + rs.getString(COUNTRY_OF_BIRTH_FLAG) +":"+ BooleanUtils.toBoolean(rs.getString(COUNTRY_OF_BIRTH_FLAG))
                    + " coi=" + rs.getString(COUNTRY_OF_ISSUE_FLAG) + ":" + BooleanUtils.toBoolean(rs.getString(COUNTRY_OF_ISSUE_FLAG))
                    + " coo=" + rs.getString(COUNTRY_OF_ORIGIN_FLAG) + ":" + BooleanUtils.toBoolean(rs.getString(COUNTRY_OF_ORIGIN_FLAG))
                    + " nat=" + rs.getString(NATIONALITY_FLAG) + ":" +BooleanUtils.toBoolean(rs.getString(NATIONALITY_FLAG)) 
                    + " using " + org.apache.commons.lang3.BooleanUtils.class.getProtectionDomain().getCodeSource().getLocation());
        }
        countryBuilder.setCountryOfBirth(rs.getString(COUNTRY_OF_BIRTH_FLAG));
        countryBuilder.setCountryOfIssue(rs.getString(COUNTRY_OF_ISSUE_FLAG));
        countryBuilder.setCountryOfOrigin(rs.getString(COUNTRY_OF_ORIGIN_FLAG));
        countryBuilder.setNationality(rs.getString(NATIONALITY_FLAG));
    }
}
