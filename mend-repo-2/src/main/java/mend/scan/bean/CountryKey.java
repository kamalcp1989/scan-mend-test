/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2013-2016
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.bean;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Implementation of ICountryKey, used to select a single country by the getCountryOf... service method.
 *
 * @see aero.sita.gsl.refdata.api.service.ICountryService#getCountryOfOrigin
 * @see aero.sita.gsl.refdata.api.service.ICountryService#getCountryOfBirth
 * @see aero.sita.gsl.refdata.api.service.ICountryService#getCountryOfIssue
 *
 */
public class CountryKey implements ICountryKey {

    /** Code relating to one of the PoliticalStateCodeTypes. */
    private final PoliticalStateCodeType codeType;

    /** One, two or three letter iso code for country must be 1-3 characters. */
    private final String code;

    /**
     * Constructor for Country Key, its code and its type.
     * @param code code of the country key.
     * @param codeType political state code type of the country key.
     */
    public CountryKey(final String code, final PoliticalStateCodeType codeType) {
        this.codeType = codeType;
        this.code = code;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PoliticalStateCodeType getCodeType() {
        return codeType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCode() {
        return code;
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
}
