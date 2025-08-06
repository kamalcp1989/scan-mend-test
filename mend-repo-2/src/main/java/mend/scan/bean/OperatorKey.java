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
 * The attributes that make up a unique Operator.
 *
 */
public class OperatorKey implements IOperatorKey {

    
    private String code;

    /** Operator Code type. */
    private OperatorCodeType codeType;

    /** Operator type. */
    private OperatorType type;

    /**
     * Constructor for Operator Key, its code and its type.
     * @param code code of the operator.
     * @param codeType code type of the operator.
     * @param type of the operator.
     */
    public OperatorKey(final String code, final OperatorCodeType codeType, final OperatorType type) {
        this.code = code;
        this.codeType = codeType;
        this.type = type;
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
    public OperatorCodeType getCodeType() {
        return codeType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OperatorType getType() {
        return type;
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
