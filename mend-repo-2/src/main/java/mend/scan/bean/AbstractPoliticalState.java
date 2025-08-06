/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2014
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import org.apache.commons.lang3.StringUtils;

/**
 * Abstract class for representing a political state of some kind, such as a 
 * country or a nationality.
 */
public class AbstractPoliticalState extends AbstractBaseLocation implements IPoliticalState {

    /** One letter iso code for the state. */
    protected String isoCode1;
    
    /** Two letter iso code for the state. */
    protected String isoCode2;
    
    /** Three letter iso code for the state. */
    protected String isoCode3;
    
    /**
     * Constructor for a {@code AbstractPoliticalState} object from the supplied
     * builder.
     * @param builder {@code Builder} object from which to create a new {@code BaseLocation}
     */
    public AbstractPoliticalState(final PoliticalStateBuilder builder) {
        super(builder);

        this.isoCode1 = builder.isoCode1;
        this.isoCode2 = builder.isoCode2;
        this.isoCode3 = builder.isoCode3;
    }

    @Override
    public String getIsoCode1() {
        return isoCode1;
    }

    @Override
    public String getIsoCode3() {
        return isoCode3;
    }

    @Override
    public String getIsoCode2() {
        return isoCode2;
    }
    
    @Override
    public String getPreferredCode() {
        if (StringUtils.isNotEmpty(getIsoCode3())) {
            return getIsoCode3();
        } else if (StringUtils.isNotEmpty(getIsoCode2())) {
            return getIsoCode2();
        }
        return getIsoCode1();
    }
    
    /**
     * Builder class used by DAO classes to create a political state object.
     */
    public abstract static class PoliticalStateBuilder extends BaseLocationBuilder {
        
        /** One-letter ISO code for the state. */
        protected String isoCode1;
        
        /** Two-letter ISO code for the state. */
        protected String isoCode2;

        /** Three-letter ISO code for the state. */
        protected String isoCode3;

        public void setIsoCode1(final String isoCode1) {
            this.isoCode1 = isoCode1;
        }

        public void setIsoCode2(final String isoCode2) {
            this.isoCode2 = isoCode2;
        }

        public void setIsoCode3(final String isoCode3) {
            this.isoCode3 = isoCode3;
        }
        
        /** 
         * Build a {@code Country} object from this builder.
         * @return Pre-populated {@code Country}
         */
        public abstract IPoliticalState build();
    }
}
