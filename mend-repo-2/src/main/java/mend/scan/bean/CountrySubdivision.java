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

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * Object model representing a country subdivision.
 */
public final class CountrySubdivision extends AbstractBaseLocation implements ICountrySubdivision {

    /** Code of the country subdivision. */
    private final String code;

    /**
     * Generates a <code>CountrySubdivision</code> object from the supplied
     * builder.
     * @param builder <code>Builder</code> object from which to create a new <code>CountrySubdivision</code>
     */
    private CountrySubdivision(final CountrySubvisionBuilder builder) {
        super(builder);
        this.code = builder.code;
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

    /**
     * Builder class used by DAO classes to create a CountrySubdivision object.
     */
    public static final class CountrySubvisionBuilder extends BaseLocationBuilder {

        /** Code of the country subdivision. */
        private String code;

        /**
         * Set the code.
         * @param code to set
         */
        public void setCode(final String code) {
            this.code = code;
        }

        /**
         * Build a <code>CountrySubdivision</code> object from this builder.
         * @return Pre-populated <code>CountrySubdivision</code>
         */
        public CountrySubdivision build() {
            return new CountrySubdivision(this);
        }
    }
}
