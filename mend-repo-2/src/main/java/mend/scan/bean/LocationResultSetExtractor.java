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

import org.apache.commons.lang3.StringUtils;

import aero.sita.bordermanagement.uae.gw.bean.Location.LocationBuilder;


/**
 * This Class utility class converts the JDBC ResultSet into List<ILocation> objects.
 *
 */
public class LocationResultSetExtractor extends AbstractBaseLocationResultSetExtractor<LocationBuilder, ILocation> {

    /**country code for this location. */
    private static final String COUNTRY_ISO3_CODE = "country_iso3_code";

    /**country code for this location. */
    private static final String COUNTRY_SITA_CODE = "country_sita_code";

    /** Boolean flag to indicate if entity can be used as Airport. */
    private static final String AIR_FLAG = "air_flag";

    /** Location type description. */
    private static final String TYPE = "type";

    /** data received. */
    private static final String DATA_RECEIVED = "data_received";

    /** iata code for location. */
    private static final String IATA_SITA_CODE = "iata_sita_code";

    /** icao code for location. */
    private static final String ICAO_SITA_CODE = "icao_sita_code";

    /** UN location code. */
    private static final String UN_LO_SITA_CODE = "unlo_sita_code";

    /** iata code for location. */
    private static final String IATA_CODE = "iata_code";

    /** icao code for location. */
    private static final String ICAO_CODE = "icao_code";

    /** UN location code. */
    private static final String UN_LO_CODE = "unLoCode";

    /** Any Other location code. */
    private static final String OTHER_CODE = "other_code";

    /** UN location name. */
    private static final String UN_LO_NAME = "unLoName";

    /** UN location name. */
    private static final String UN_LO_NAME_NL = "unLoNameNL";

    /** UN location short name. */
    private static final String UN_LO_SHORT_NAME = "unLoShortName";

    /** UN/LO short name in national locale. */
    private static final String UN_LO_SHORT_NAME_NL = "unLoShortNameNL";

    /** IATA name in default language, typically English. */
    private static final String IATA_NAME = "iata_name";

    /** IATA name in national locale. */
    private static final String IATA_NAME_NL = "iataNameNL";

    /** IATA short name in default language, typically English. */
    private static final String IATA_SHORT_NAME = "iata_short_name";

    /** IATA short name in national locale. */
    private static final String IATA_SHORT_NAME_NL = "iataShortNameNL";

    /** ICAO name in default language, typically English. */
    private static final String ICAO_NAME = "icao_name";

    /** ICAO name in national locale. */
    private static final String ICAO_NAME_NL = "icaoNameNL";

    /** ICAO short name in default language, typically English. */
    private static final String ICAO_SHORT_NAME = "icao_short_name";

    /** ICAO short name in national locale. */
    private static final String ICAO_SHORT_NAME_NL = "icaoShortNameNL";

    /** Other name in default language, typically English. */
    private static final String OTHER_NAME = "other_name";

    /** Other name in national locale. */
    private static final String OTHER_NAME_NL = "otherNameNL";

    /** Other short name in default language, typically English. */
    private static final String OTHER_SHORT_NAME = "other_short_name";

    /** Other short name in national locale. */
    private static final String OTHER_SHORT_NAME_NL = "otherShortNameNL";

    /** Country Sub division code. */
    private static final String COUNTRY_SUBDIV_CODE = "countrySubdivisionCode";

    /** Country Sub division name. */
    private static final String COUNTRY_SUBDIV_NAME = "countrySubdivisionName";

    /** Country Sub division name, national locale. */
    private static final String COUNTRY_SUBDIV_NAME_NL = "countrySubdivisionNameNL";

    /** Country name. */
    private static final String COUNTRY_NAME = "country_name";

    /** Country name, national locale. */
    private static final String COUNTRY_NAME_NL = "countryNameNL";

    /** Country short name. */
    private static final String COUNTRY_SHORT_NAME = "country_short_name";

    /** Country short name, national locale. */
    private static final String COUNTRY_SHORT_NAME_NL = "countryShortNameNL";

    /** Latitude. */
    private static final String LATITUDE = "latitude";

    /** Longitude. */
    private static final String LONGITUDE = "longitude";

    /** The reference to the time-zone identifier. */
    private static final String TIMEZONE_ID = "timeZoneId";

    /** The reference to the time-zone code. */
    private static final String TIMEZONE_CODE = "timeZoneCode";

    @Override
    protected LocationBuilder createBuilder() throws SQLException {
        LocationBuilder builder = new Location.LocationBuilder();
        return builder;
    }

    @Override
    protected String getReferenceDataKey(final ResultSet rs) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getReferenceDataKey(rs));
        return sb.toString();
    }

    @Override
    protected void mapReferenceDataRow(
            final ResultSet rs,
            final LocationBuilder builder) throws SQLException {
        super.mapReferenceDataRow(rs, builder);
        builder.setType(rs.getString(TYPE));
        builder.setIataCode(rs.getString(IATA_CODE));
        builder.setIataName(rs.getString(IATA_NAME));
        builder.setIataNameNL(StringUtils.isNotBlank(rs.getString(IATA_NAME_NL)) ? rs.getString(IATA_NAME_NL) : rs.getString(IATA_NAME));
        builder.setIataShortName(rs.getString(IATA_SHORT_NAME));
        builder.setIataShortNameNL(StringUtils.isNotBlank(rs.getString(IATA_SHORT_NAME_NL)) ? rs.getString(IATA_SHORT_NAME_NL) : rs.getString(IATA_SHORT_NAME));
        builder.setIcaoCode(rs.getString(ICAO_CODE));
        builder.setIcaoName(rs.getString(ICAO_NAME));
        builder.setIcaoNameNL(StringUtils.isNotBlank(rs.getString(ICAO_NAME_NL)) ? rs.getString(ICAO_NAME_NL) : rs.getString(ICAO_NAME));
        builder.setIcaoShortName(rs.getString(ICAO_SHORT_NAME));
        builder.setIcaoShortNameNL(StringUtils.isNotBlank(rs.getString(ICAO_SHORT_NAME_NL)) ? rs.getString(ICAO_SHORT_NAME_NL) : rs.getString(ICAO_SHORT_NAME));
        builder.setUnLoCode(rs.getString(UN_LO_CODE));
        builder.setUnLoName(rs.getString(UN_LO_NAME));
        builder.setUnLoNameNL(StringUtils.isNotBlank(rs.getString(UN_LO_NAME_NL)) ? rs.getString(UN_LO_NAME_NL) : rs.getString(UN_LO_NAME));
        builder.setUnLoShortName(rs.getString(UN_LO_SHORT_NAME));
        builder.setUnLoShortNameNL(StringUtils.isNotBlank(rs.getString(UN_LO_SHORT_NAME_NL)) ? rs.getString(UN_LO_SHORT_NAME_NL) : rs.getString(UN_LO_SHORT_NAME));
        builder.setOtherCode(rs.getString(OTHER_CODE));
        builder.setOtherName(rs.getString(OTHER_NAME));
        builder.setOtherNameNL(StringUtils.isNotBlank(rs.getString(OTHER_NAME_NL)) ? rs.getString(OTHER_NAME_NL) : rs.getString(OTHER_NAME));
        builder.setOtherShortName(rs.getString(OTHER_SHORT_NAME));
        builder.setOtherShortNameNL(StringUtils.isNotBlank(rs.getString(OTHER_SHORT_NAME_NL)) ? rs.getString(OTHER_SHORT_NAME_NL) : rs.getString(OTHER_SHORT_NAME));
        setLocationTypeFlags(rs, builder);
        int timezoneId = rs.getInt(TIMEZONE_ID);
        if (timezoneId > 0) {
            builder.setTimeZoneId(Integer.valueOf(timezoneId));
        }
        builder.setTimeZoneCode(rs.getString(TIMEZONE_CODE));
        mapCountryData(rs, builder);
    }

    private void setLocationTypeFlags(final ResultSet rs, final LocationBuilder builder) throws SQLException {
        builder.setAirFlag(rs.getString(AIR_FLAG));
    }

    private void mapCountryData(final ResultSet rs, final LocationBuilder builder) throws SQLException {
        builder.setCountryName(rs.getString(COUNTRY_NAME));
        builder.setCountryNameNL(StringUtils.isNotBlank(rs.getString(COUNTRY_NAME_NL)) ? rs.getString(COUNTRY_NAME_NL) : rs.getString(COUNTRY_NAME));
        builder.setCountrySitaCode(rs.getString(COUNTRY_SITA_CODE));
        builder.setCountryIso3Code(rs.getString(COUNTRY_ISO3_CODE));
        builder.setCountryShortName(rs.getString(COUNTRY_SHORT_NAME));
        builder.setCountryShortNameNL(StringUtils.isNotBlank(rs.getString(COUNTRY_SHORT_NAME_NL)) ? rs.getString(COUNTRY_SHORT_NAME_NL) : rs.getString(COUNTRY_SHORT_NAME));
        builder.setCountrySubdivisionCode(rs.getString(COUNTRY_SUBDIV_CODE));
        builder.setCountrySubdivisionName(rs.getString(COUNTRY_SUBDIV_NAME));
        builder.setCountrySubdivisionNameNL(StringUtils.isNotBlank(rs.getString(COUNTRY_SUBDIV_NAME_NL)) ? rs.getString(COUNTRY_SUBDIV_NAME_NL) : rs.getString(COUNTRY_SUBDIV_NAME));
    }
}
