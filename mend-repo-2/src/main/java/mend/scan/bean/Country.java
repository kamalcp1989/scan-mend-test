/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2009-2016
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Object model representing a country.
 */
public final class Country extends AbstractPoliticalState implements ICountry {

    /** List indicating how a country can be used, for example by birth, issue, nationality and or country of origin. */
    private final List<CountryUsageType> usageTypeList = new ArrayList<CountryUsageType>();

    /**
     * Generates a {@code Country} object from the supplied
     * builder.
     * @param builder {@code Builder} object from which to create a new {@code Country}
     */
    private Country(final CountryBuilder builder) {
        super(builder);

        if (builder.countryOfOrigin) {
            this.usageTypeList.add(CountryUsageType.COUNTRY_OF_ORIGIN);
        }
        if (builder.nationality) {
            this.usageTypeList.add(CountryUsageType.NATIONALITY);
        }
        if (builder.countryOfIssue) {
            this.usageTypeList.add(CountryUsageType.COUNTRY_OF_ISSUE);
        }
        if (builder.countryOfBirth) {
            this.usageTypeList.add(CountryUsageType.COUNTRY_OF_BIRTH);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ICountryKey getIdentifier() {
        return new CountryKey(getIsoCode3(), PoliticalStateCodeType.ISO3);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCountryOfOrigin() {
        return usageTypeList.contains(CountryUsageType.COUNTRY_OF_ORIGIN);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isNationality() {
        return usageTypeList.contains(CountryUsageType.NATIONALITY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCountryOfIssue() {
        return usageTypeList.contains(CountryUsageType.COUNTRY_OF_ISSUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCountryOfBirth() {
        return usageTypeList.contains(CountryUsageType.COUNTRY_OF_BIRTH);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CountryUsageType> getUsageType() {
        return usageTypeList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Builder class used by DAO classes to create a Country object.
     */
    public static final class CountryBuilder extends PoliticalStateBuilder {

        /** Boolean flag to indicate if country can be used as Country of origin. */
        private boolean countryOfOrigin;

        /** Boolean flag to indicate if country can be used as Nationality. */
        private boolean nationality;

        /** Boolean flag to indicate if country can be used as Country of issue. */
        private boolean countryOfIssue;

        /** Boolean flag to indicate if country can be used as Country of birth. */
        private boolean countryOfBirth;

        public void setCountryOfOrigin(final String countryOfOrigin) {
            this.countryOfOrigin = BooleanUtils.toBoolean(countryOfOrigin);
        }

        public void setNationality(final String nationality) {
            this.nationality = BooleanUtils.toBoolean(nationality);
        }

        public void setCountryOfIssue(final String countryOfIssue) {
            this.countryOfIssue = BooleanUtils.toBoolean(countryOfIssue);
        }

        public void setCountryOfBirth(final String countryOfBirth) {
            this.countryOfBirth = BooleanUtils.toBoolean(countryOfBirth);
        }

        public ICountryKey getIdentifier() {
            return new CountryKey(super.isoCode3, PoliticalStateCodeType.ISO3);
        }

        /**
         * Build a {@code Country} object from this builder.
         * @return Pre-populated {@code Country}
         */
        public Country build() {
            return new Country(this);
        }
    }

}
