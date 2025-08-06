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

import org.apache.commons.lang3.StringUtils;

/**
 * Base class for extracting information for Country, Nationality etc - including groups.
 * @param <BuilderType> type of PoliticalStateBuilder
 * @param <T> type of PoliticalState
 */
public abstract class AbstractPoliticalStateResultSetExtractor<BuilderType extends AbstractPoliticalState.PoliticalStateBuilder, T extends IPoliticalState> extends AbstractBaseLocationResultSetExtractor<BuilderType, T>{

    /** One-letter ISO code for the state. */
    protected static final String ISOCODE1 = "isoCode1";
    /** Two-letter ISO code for the state. */
    protected static final String ISOCODE2 = "isoCode2";
    /** Three-letter ISO code for the state. */
    protected static final String ISOCODE3 = "isoCode3";
    /** Name of state in default language, typically English. */
    protected static final String NAME = "name";
    /** Is reference data item enabled. */
    protected static final String ENABLED = "enabled";

    /**
     * Method to map the common values for the row returned from the DB query.
     * @param rs  the DB result set
     * @param builder the builder previously created by createBuilderAndMapSpecificPoliticalStateRow
     * @throws SQLException  when there is a problem with the result set
     */
    protected void mapReferenceDataRow(final ResultSet rs, final BuilderType builder) throws SQLException {
        super.mapReferenceDataRow(rs, builder);
        builder.setName(rs.getString(NAME));
        builder.setNameNL(StringUtils.isNotBlank(rs.getString(AbstractBaseLocationResultSetExtractor.NAME_NL)) ? rs.getString(AbstractBaseLocationResultSetExtractor.NAME_NL) : rs.getString(AbstractBaseLocationResultSetExtractor.NAME));
        builder.setShortName(rs.getString(AbstractBaseLocationResultSetExtractor.SHORT_NAME));
        builder.setShortNameNL(StringUtils.isNotBlank(rs.getString(AbstractBaseLocationResultSetExtractor.SHORT_NAME_NL)) ? rs.getString(AbstractBaseLocationResultSetExtractor.SHORT_NAME_NL) : rs.getString(AbstractBaseLocationResultSetExtractor.SHORT_NAME));
        builder.setIsoCode1(rs.getString(ISOCODE1));
        builder.setIsoCode2(rs.getString(ISOCODE2));
        builder.setIsoCode3(rs.getString(ISOCODE3));
        builder.setName(rs.getString(NAME));
        builder.setEnabled(rs.getString(ENABLED));
    }

}
