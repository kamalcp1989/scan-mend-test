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
 * Implementation of ILocationKey, used to select a single location by the getLocationByKey service method.
 *
 * @see aero.sita.gsl.refdata.api.service.ILocationService#getLocationByKey
 *
 */
public class LocationKey implements ILocationKey {

    
    private String code;

    
    private LocationCodeType codeType;

    /**
     * Constructor for Location Key, its code and its type.
     * @param code code of the location key.
     * @param codeType code type of the location key.
     */
    public LocationKey(final String code, final LocationCodeType codeType) {
        this.code = code;
        this.codeType = codeType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getCode()  {
        return code;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocationCodeType getCodeType() {
        return codeType;
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
