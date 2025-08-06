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


/**
 * Base class for extracting information for base location data - including groups.
 * @param <BuilderType> type of BaseLocationBuilder
 * @param <T> type of IBaseLocation
 */
public abstract class AbstractBaseLocationResultSetExtractor<BuilderType extends AbstractBaseLocation.BaseLocationBuilder, T extends IBaseLocation> extends AbstractBaseResultSetExtractor<BuilderType, T>{

    /** Name of entity in default language, typically English. */
    protected static final String NAME = "name";
    /** National locale entity name. */
    protected static final String NAME_NL = "nameNL";
    /** Short Name of entity in default language, typically English. */
    protected static final String SHORT_NAME = "short_name";
    /** National locale entity short name. */
    protected static final String SHORT_NAME_NL = "shortNameNL";

    
    /**
     * Method to map the common values for the row returned from the DB query.
     * @param rs  the DB result set
     * @param builder the builder previously created by createBuilderAndMapSpecificPoliticalStateRow
     * @throws SQLException  when there is a problem with the result set
     */
    protected void mapReferenceDataRow(final ResultSet rs, final BuilderType builder) throws SQLException {
        super.mapReferenceDataRow(rs, builder);
    }

}
