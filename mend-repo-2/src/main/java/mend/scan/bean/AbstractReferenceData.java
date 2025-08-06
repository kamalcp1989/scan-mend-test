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

import java.util.Date;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
/**
 *
 * Abstract reference data class for all reference data objects, eg Location, Carrier.
 */
public abstract class AbstractReferenceData implements IReferenceData {

    /** Sita Code for the this reference data entity. */
    private final String sitaCode;

    /** Is reference data item enabled. */
    private final boolean enabled;

    /** Name of reference data in default language, typically English. */
    private final String name;

    /** Created by. */
    private final String createdBy;

    /** Created date. */
    private final Date createdDatetime;

    /** Modified by. */
    private final String modifiedBy;

    /** Modified date. */
    private final Date modifiedDatetime;

    /**
     * Abstract constructor a <code>Location</code> object from the supplied
     * builder.
     * @param builder <code>Builder</code> object from which to create a new <code>AbstractReferenceData</code>
     */
    protected AbstractReferenceData(final AbstractReferenceBuilder builder) {
        this.sitaCode = builder.sitaCode;
        this.enabled = builder.enabled;
        this.name = builder.name;
        this.createdBy = builder.createdBy;
        this.createdDatetime = builder.createdDatetime;
        this.modifiedBy = builder.modifiedBy;
        this.modifiedDatetime = builder.modifiedDatetime;
    }

    /**
     * Abstract constructor a <code>Location</code> object from the supplied
     * builder.
     * @param referenceData <code>IReferenceData</code> object from which to create a new <code>AbstractReferenceData</code>
     */
    protected AbstractReferenceData(final IReferenceData referenceData) {
        this.sitaCode = referenceData.getSitaCode();
        this.enabled = referenceData.isEnabled();
        this.name = referenceData.getName();
        this.createdBy = referenceData.getCreatedBy();
        this.createdDatetime = referenceData.getCreatedDatetime();
        this.modifiedBy = referenceData.getModifiedBy();
        this.modifiedDatetime = referenceData.getModifiedDatetime();
    }

    @Override
    public String getSitaCode() {
        return sitaCode;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    @Override
    public String getModifiedBy() {
        return modifiedBy;
    }

    @Override
    public Date getModifiedDatetime() {
        return modifiedDatetime;
    }

    @Override
    public boolean isSitaCode() {
        return StringUtils.isNotEmpty(sitaCode);
    }

    /**
     * Builder class used by DAO classes to create core Reference Data object.
     */
    public abstract static class AbstractReferenceBuilder {

        /** Sita Code for the this reference data entity. */
        private String sitaCode;

        /** Is reference data item enabled. */
        private boolean enabled;

        /** Name of reference data in default language, typically English. */
        private String name;

        /** Created by. */
        private String createdBy;

        /** Created date. */
        private Date createdDatetime;

        /** Modified by. */
        private String modifiedBy;

        /** Modified date. */
        private Date modifiedDatetime;

        public void setSitaCode(final String sitaCode) {
            this.sitaCode = sitaCode;
        }

        public void setEnabled(final String enabled) {
            this.enabled = BooleanUtils.toBoolean(enabled);
        }

        public void setName(final String name) {
            this.name = name;
        }

        public void setCreatedBy(final String createdBy) {
            this.createdBy = createdBy;
        }

        public void setCreatedDatetime(final Date createdDatetime) {
            this.createdDatetime = createdDatetime;
        }

        public void setModifiedBy(final String modifiedBy) {
            this.modifiedBy = modifiedBy;
        }

        public void setModifiedDatetime(final Date modifiedDatetime) {
            this.modifiedDatetime = modifiedDatetime;
        }

        /**
         * abstract build method.
         * @return object of type IReferenceData
         */
        public abstract IReferenceData build();

    }
}
