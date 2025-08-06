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
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import aero.sita.bordermanagement.uae.gw.bean.AbstractReferenceData.AbstractReferenceBuilder;

/**
 * Base class for extracting reference data objects that can include group information.
 * @param <BuilderType> type of AbstractReferenceBuilder
 * @param <T> type of IReferenceData
 */
public abstract class AbstractBaseResultSetExtractor <BuilderType extends AbstractReferenceBuilder, T extends IReferenceData> implements ResultSetExtractor <List<T>>{

    /** Status field constant. */
    protected static final String SITA_CODE = "sitaCode";
    /** created date.*/
    protected static final String CREATED_DATETIME = "createdDatetime";
    /** modified date.*/
    protected static final String MODIFIED_DATETIME = "modifiedDatetime";

    /** Date field to indicate the valid IATA from date for a Location. */
    protected static final String IATA_VALID_FROM = "iata_valid_from";

    /** Date field to indicate the valid IATA to date for a Location. */
    protected static final String IATA_VALID_TO = "iata_valid_to";

    /** Date field to indicate the valid ICAO from date for a Location. */
    protected static final String ICAO_VALID_FROM = "icao_valid_from";

    /** Date field to indicate the valid ICAO to date for a Location. */
    protected static final String ICAO_VALID_TO = "icao_valid_to";

    /** Date field to indicate the valid UNLOC from date for a Location. */
    protected static final String UNLOC_VALID_FROM = "unloc_valid_from";

    /** Date field to indicate the valid UNLOC to date for a Location. */
    protected static final String UNLOC_VALID_TO = "unloc_valid_to";

    /** Date field to indicate the valid OTHER from date for a Location. */
    protected static final String OTHER_VALID_FROM = "other_valid_from";

    /** Date field to indicate the valid OTHER to date for a Location. */
    protected static final String OTHER_VALID_TO = "other_valid_to";


    /**
     * This method converts the JDBC ResultSet into List<T>.
     *
     * @param rs JDBC ResultSet.
     * @return List<T> list of IReferenceData objects.
     * @throws SQLException Database SQLException.
     * @throws DataAccessException when reading data got issues.
     * @see org.springframework.jdbc.core.ResultSetExtractor#extractData(java.sql.ResultSet)
     */
    @Override
    public List<T> extractData(final ResultSet rs) throws SQLException, DataAccessException {
        List<T> referenceDataList = new ArrayList<T>();

        Map<String, BuilderType> referenceDataBuilderMap = new LinkedHashMap<String, BuilderType>();
        //Map<String, IGroup> groupMap = new HashMap<String, IGroup>();

        while (rs.next()) {
            String key = getReferenceDataKey(rs);
            BuilderType builder = null;
            if (referenceDataBuilderMap.containsKey(key)) {
                builder = referenceDataBuilderMap.get(key);
            } else {
                builder = createBuilder();
                mapReferenceDataRow(rs, builder);
                referenceDataBuilderMap.put(key, builder);
            }
            //IGroup group = createGroup(rs, groupMap);
            //if (group != null) {
              //  builder.addGroup(group);
            //}
        }
        referenceDataList.addAll((Collection<? extends T>)createReferenceDataList(referenceDataBuilderMap.values()));
        return referenceDataList;
    }


    /**
     * Method is used for converting List<BuilderType> into a List<T>.
     *
     * @param builderList the list of builders returned by the database
     * @return List<T> the actual list of political state objects
     */
    @SuppressWarnings("unchecked")
    private List<IReferenceData> createReferenceDataList(final Collection<BuilderType> builderList) {
    	/**
        Collection<T> transformedCollection = CollectionUtils.collect(builderList, new Transformer() {
            @Override
            public Object transform(final Object input) {
                return ((AbstractReferenceBuilder) input).build();
            }
        });
        return new ArrayList<T>(transformedCollection);
        **/
    	 return builderList.stream()
    	            .map(input -> ((AbstractReferenceBuilder) input).build())
    	            .collect(Collectors.toList());
    }


    /**
     * Method to map the common values for the row returned from the DB query.
     * This method should be extended by sub classes to map any extra required columns.
     * @param rs  the DB result set
     * @param builder the builder to map the data to
     * @throws SQLException  when there is a problem with the result set
     */
    protected void mapReferenceDataRow(final ResultSet rs, final BuilderType builder) throws SQLException {
        builder.setSitaCode(rs.getString(SITA_CODE));
    }

    /**
     * Method to create the builder to be used when mapping rows returned from the DB queries.
     * @return BuilderType a typed builder from sub-class.
     * @throws SQLException  when there is a problem with the result set
     */
    protected abstract BuilderType createBuilder() throws SQLException;

    /**
     * gets the reference data key for the record to be unique.
     *
     * @param rs
     *            the result set
     * @return the reference data key.
     * @throws SQLException
     *             when there is a problem with the result set
     */
    protected String getReferenceDataKey(final ResultSet rs) throws SQLException {
        return rs.getString(SITA_CODE);
    }
    
    /**
     * Gets the local date from java.sql.date.
     *
     * @param resultSet the result set
     * @param columnLabel the column label
     * @return the local date
     * @throws SQLException the SQL exception
     */
    protected LocalDate getLocalDate(final ResultSet resultSet, final String columnLabel) throws SQLException {
        Timestamp dbTimestamp = resultSet.getTimestamp(columnLabel);
        if (dbTimestamp == null) {
            return null;
        }
        return dbTimestamp.toLocalDateTime().toLocalDate();
    }
}
