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

import org.apache.commons.lang3.BooleanUtils;


/**
 *
 * BaseLocation class for reference data.
 */
public abstract class AbstractBaseLocation extends AbstractReferenceData implements IBaseLocation {
 
    /** National locale location name. */
    private final String nameNL;
    
    /** Short location name in default language, typically English. */
    private final String shortName;

    /** National locale short location name. */
    private final String shortNameNL;
    
    /** Is there any associated flight, traveller information etc. */
    private final boolean dataReceived;
    
    /** List of the groups associated to this location . */
    //private List<IGroup> groupList = new ArrayList<IGroup>();

    @Override
    public String getNameNL() {
        return nameNL;
    }

    @Override
    public String getShortName() {
        return shortName;
    }

    @Override
    public String getShortNameNL() {
        return shortNameNL;
    }

    @Override
    public boolean isDataReceived() {
        return dataReceived;
    }
    
    //@Override
    //public List<IGroup> getGroups() {
    //    return groupList;
   // }

    /**
     * Constructor for a <code>BaseLocation</code> object from the supplied
     * builder.
     * @param builder <code>Builder</code> object from which to create a new <code>BaseLocation</code>
     */
    protected AbstractBaseLocation(final BaseLocationBuilder builder) {
        super(builder);
        this.nameNL = builder.nameNL;
        this.shortName = builder.shortName;
        this.shortNameNL = builder.shortNameNL;
        this.dataReceived = builder.dataReceived;
     //   this.groupList = new ArrayList<IGroup>(builder.groupList);
    }
    
    /**
     * Builder class used by DAO classes to create a Location object.
     */
    //public abstract static class BaseLocationBuilder extends AbstractReferenceBuilder implements IGroupReferenceDataBuilder {
    
    public abstract static class BaseLocationBuilder extends AbstractReferenceBuilder {
        
        /** National locale location name. */
        private String nameNL;
        
        /** Short location name in default language, typically English. */
        private String shortName;

        /** National locale short location name. */
        private String shortNameNL;

        /** Is there any associated flight, traveller information etc. */
        private boolean dataReceived;
        
        /** Set of the groups associated to this country . */
        //private Set<IGroup> groupList = new LinkedHashSet<IGroup>();
        /**
         * Add group to country.
         * @param group Group object.
         */
       // public void addGroup(final IGroup group) {
         //   this.groupList.add(group);
        //}

        public void setNameNL(final String nameNL) {
            this.nameNL = nameNL;
        }

        public void setShortName(final String shortName) {
            this.shortName = shortName;
        }

        public void setShortNameNL(final String shortNameNL) {
            this.shortNameNL = shortNameNL;
        }

        public void setDataReceived(final String dataReceived) {
            this.dataReceived = BooleanUtils.toBoolean(dataReceived);
        }
        /**
         * abstract build method.
         * @return object of type IBaseReferenceDataCode
         */
        public abstract IBaseLocation build();
    }

}
