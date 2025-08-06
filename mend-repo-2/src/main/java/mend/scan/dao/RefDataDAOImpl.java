/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import aero.sita.bordermanagement.uae.gw.bean.CountryResultSetExtractor;
import aero.sita.bordermanagement.uae.gw.bean.ErrorCodeRowMapper;
import aero.sita.bordermanagement.uae.gw.bean.ICountry;
import aero.sita.bordermanagement.uae.gw.bean.IErrorDesc;
import aero.sita.bordermanagement.uae.gw.bean.ILocation;
import aero.sita.bordermanagement.uae.gw.bean.IOperator;
import aero.sita.bordermanagement.uae.gw.bean.IStatusCodeDesc;
import aero.sita.bordermanagement.uae.gw.bean.LocationResultSetExtractor;
import aero.sita.bordermanagement.uae.gw.bean.OperatorResultSetExtractor;
import aero.sita.bordermanagement.uae.gw.bean.StatusCodeRowMapper;
/**
 * DAO class for Reference Data Configuration
 */
@Service
public class RefDataDAOImpl {
	
    /**
     * NamedParameterJdbcTemplate JDBC Template
     */
    @Autowired
    @Qualifier("namedJdbcTemplate")
    private NamedParameterJdbcTemplate  jdbcTemplate;
    
    /**
     * NamedParameterJdbcTemplate JDBC Template
     */
    @Autowired
    @Qualifier("refDataNamedJdbcTemplate")
    private NamedParameterJdbcTemplate  refDataNamedJdbcTemplate;
	
	/**
	 * Logger final
	 */
	private static final Logger LOG = LoggerFactory.getLogger(RefDataDAOImpl.class);
	
	/**
	 * SQL Select Query for APP Status Code
	 */
	private static final String QUERY_STATUS_CODE_DESC =  "SELECT "
			+ "DESCRIPTION, "
			+ "DESCRIPTION_AR, "
			+ "MESSAGE_CODE, "
			+ "PAX_STATUS_CODE "
			+ "FROM STATUS_CODE_DESCRIPTION ";
	
	
	/**
	 * SQL Select Query for Gateway Error Code
	 */
	private static final String QUERY_ERROR_CODE_DESC =  "SELECT "
			+ "ERROR_CODE, "
			+ "DESCRIPTION, "
			+ "DESCRIPTION_AR "
			+ "FROM ERROR_CODE ";
	
	
    /** Selection from the country view. */
    protected static final String COUNTRY_VIEW_SELECT = "SELECT country_v.country_id sitaCode" +
            ", country_v.code_a1 isoCode1, country_v.code_a2 isoCode2, country_v.code_a3 isOCode3" +
            ", country_v.name, country_v.name_nl nameNL" +
            ", country_v.short_name, country_v.short_name_nl shortNameNL" +
            ", country_v.enabled" +
            ", country_v.country_of_origin_flag countryOfOrigin" +
            ", country_v.country_of_issue_flag countryOfIssue" +
            ", country_v.country_of_birth_flag countryOfBirth" +
            ", country_v.nationality_flag nationality" +
            ", country_v.group_id group_sita_code" +
            ", country_v.group_code group_code" +
            ", country_v.group_description group_description, country_v.group_description_nl group_description_nl" +
            ", country_v.group_enabled group_enabled" +
            " FROM country_v";
    
    /** Selection from the operator view. */
    private static final String OPERATOR_VIEW_SELECT = "SELECT operator_v.sita_code as sitaCode"
            + ", operator_v.data_received"
            + ", operator_v.type_code as type"
            + ", operator_v.type_desc as typeDescription"
            + ", operator_v.type_desc_nl as typeDescriptionNL"
            + ", operator_v.iata_code"
            + ", operator_v.iata_name"
            + ", operator_v.icao_code"
            + ", operator_v.icao_name"
            + ", operator_v.other_code"
            + ", operator_v.other_name"
            + ", operator_v.other_operator_id"
            + ", operator_v.country_code"
            + ", operator_v.country_code_a3"
            + ", operator_v.country_code_a2"
            + ", operator_v.country_code_a1"
            + ", operator_v.country_name"
            + ", operator_v.iata_valid_from"
            + ", operator_v.iata_valid_to"
            + ", operator_v.icao_valid_from"
            + ", operator_v.icao_valid_to"
            + ", operator_v.other_valid_from"
            + ", operator_v.other_valid_to";
    
    
    /** Selection from the location view. */
    protected static final String LOCATION_VIEW_SELECT = "SELECT location_mv.sita_code as sitaCode"
            + ", location_mv.air_flag"
            + ", location_mv.type_desc AS type"
            + ", location_mv.iata_code"
            + ", location_mv.icao_code"
            + ", location_mv.unlo_code AS unLoCode"
            + ", location_mv.other_code"
            + ", location_mv.unlo_name AS unLoName"
            + ", location_mv.unlo_name_nl AS unLoNameNL"
            + ", location_mv.unlo_short_name AS unLoShortName"
            + ", location_mv.unlo_short_name_nl AS unLoShortNameNL"
            + ", location_mv.iata_name"
            + ", location_mv.iata_name_nl AS iataNameNL"
            + ", location_mv.iata_short_name"
            + ", location_mv.iata_short_name_nl AS iataShortNameNL"
            + ", location_mv.icao_name"
            + ", location_mv.icao_name_nl AS icaoNameNL"
            + ", location_mv.icao_short_name"
            + ", location_mv.icao_short_name_nl AS icaoShortNameNL"
            + ", location_mv.other_name"
            + ", location_mv.other_name_nl AS otherNameNL"
            + ", location_mv.other_short_name"
            + ", location_mv.other_short_name_nl AS otherShortNameNL"
            + ", location_mv.country_sita_code"
            + ", location_mv.country_code AS country_iso3_code"
            + ", location_mv.country_subdiv_code AS countrySubdivisionCode"
            + ", location_mv.country_subdiv_name AS countrySubdivisionName"
            + ", location_mv.country_subdiv_name_nl AS countrySubdivisionNameNL"
            + ", location_mv.country_name"
            + ", location_mv.country_name_nl AS countryNameNL"
            + ", location_mv.country_short_name"
            + ", location_mv.country_short_name_nl AS countryShortNameNL"
            + ", location_mv.timezone_id AS timeZoneId"
            + ", location_mv.timezone_code AS timeZoneCode"
            + " FROM location_v2_v location_mv"
            + " WHERE location_mv.air_flag='Y'";
    

    /**
     * String for "from" sql statement.
     *
     * @return sql from statement
     */
    protected String getOperatorTableName() {
        return OPERATOR_TABLE_NAME;
    }
    
    protected static final String ORDER_BY_SITA_CODE = " ORDER BY sitaCode ";

    /** Selection from the country view. */
    protected static final String ALL_COUNTRIES_SQL = COUNTRY_VIEW_SELECT + ORDER_BY_SITA_CODE;
    
    /** operator table/view name to be used. */
    private static final String OPERATOR_TABLE_NAME = " FROM operator_v ";

	@Cacheable("allStatusCode")
	public List<IStatusCodeDesc> getAllStatusCode() {
		StringBuilder localStringBuilder = new StringBuilder(QUERY_STATUS_CODE_DESC);
		Map<String, Object> params = new HashMap<>();
        List<IStatusCodeDesc> statusCodeList = jdbcTemplate.query(localStringBuilder.toString(), params, new StatusCodeRowMapper());
        return statusCodeList;
	}
	
	
	@Cacheable("allErrorCodeDesc")
	public List<IErrorDesc> getAllErrorCodeDesc() {
		StringBuilder localStringBuilder = new StringBuilder(QUERY_ERROR_CODE_DESC);
		Map<String, Object> params = new HashMap<>();
        List<IErrorDesc> errorCodeList = jdbcTemplate.query(localStringBuilder.toString(), params, new ErrorCodeRowMapper());
        return errorCodeList;
	}
	
	@Cacheable("allCountries")
    public List<ICountry> getAllCountries() {
        List<ICountry> countries = null;
        CountryResultSetExtractor mapper = new CountryResultSetExtractor();
        try {
        	countries = refDataNamedJdbcTemplate.query(ALL_COUNTRIES_SQL, mapper);
        } catch (EmptyResultDataAccessException ere) {
            countries = Collections.emptyList();
        }

        return countries;
    }
	
	@Cacheable("allOperators")
    public List<IOperator> getAllOperators() {
		List<IOperator> operators = null;
        try {
        	operators = refDataNamedJdbcTemplate.query(getOperatorSelectStatement() + ORDER_BY_SITA_CODE, new OperatorResultSetExtractor());
        } catch (EmptyResultDataAccessException ere) {
        	operators =  Collections.emptyList();
        }
        return operators;
    }
    
    /**
     * String to select operator information from the operator_v view to populate a Operator bean.
     * @return sql string
     */
    protected String getOperatorSelectStatement() {
        return OPERATOR_VIEW_SELECT + getOperatorTableName();
    }
    
    @Cacheable("allLocations")
    public List<ILocation> getAllLocations() {
    	List<ILocation> locations = null;
        LocationResultSetExtractor mapper = new LocationResultSetExtractor();
        try {
        	locations = refDataNamedJdbcTemplate.query(LOCATION_VIEW_SELECT + ORDER_BY_SITA_CODE, mapper);
        } catch (EmptyResultDataAccessException ere) {
        	locations = Collections.emptyList();
        }
        return locations;
    }
}
