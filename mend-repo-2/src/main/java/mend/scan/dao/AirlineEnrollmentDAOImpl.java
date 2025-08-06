/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import aero.sita.bordermanagement.uae.gw.bean.AirlineEnrollmentConfigurationRowMapper;
import aero.sita.bordermanagement.uae.gw.bean.IAirlineEnrollment;

/**
 * DAO class for Enrollment Configuration
 */
@Service
public class AirlineEnrollmentDAOImpl {
	
    /**
     * NamedParameterJdbcTemplate JDBC Template
     */
    @Autowired
    @Qualifier("namedJdbcTemplate")
    private NamedParameterJdbcTemplate  jdbcTemplate;
	
	/**
	 * Logger final
	 */
	private static final Logger LOG = LoggerFactory.getLogger(AirlineEnrollmentDAOImpl.class);
	
	/**
	 * SQL Select Query
	 */
	private static final String QUERY_AIRILNE_ENROLLMENT_CONFIGURATION =  "SELECT "
			+ "ENROLLMENT_ID, "
			+ "SENDER_SYSTEM, "
			+ "AIRLINE_CODES, "
			+ "ENROLLMENT_START_DATE, "
			+ "CREATED_DATE, "
			+ "LAST_MODIFIED_DATE, "
			+ "SERVICE_REQUEST_QUEUE, "
			+ "SERVICE_RESPONSE_QUEUE, "
			+ "CONCURRENT_CONSUMER, "
			+ "MAX_CONCURRENT_CONSUMER, "
			+ "AUTO_RESPONDER "
			+ "FROM AIRLINE_ENROLLMENT_CONFIGURATION ";
	
	/**
	 * SQL Where condition
	 */
	private static final String QUERY_AIRILNE_ENROLLMENT_CONFIGURATION_WHERE =  "WHERE SENDER_SYSTEM IN (:senderSystem)";
	
	
	/**
	 * @param configuredAirlines
	 * @return List<IAirlineEnrollment>
	 */
	@Cacheable("enrolledAirlines")
	public List<IAirlineEnrollment> getEnrolledAirlines(final List<String> configuredAirlines) {
		StringBuilder localStringBuilder = new StringBuilder(QUERY_AIRILNE_ENROLLMENT_CONFIGURATION);
		localStringBuilder.append(QUERY_AIRILNE_ENROLLMENT_CONFIGURATION_WHERE);
		Map<String, Object> params = new HashMap<>();
		params.put("senderSystem", configuredAirlines);
        List<IAirlineEnrollment> configurationList = jdbcTemplate.query(localStringBuilder.toString(), params, new AirlineEnrollmentConfigurationRowMapper());
        return configurationList;
    }
	
	@Cacheable("allEnrolledSystem")
	public List<IAirlineEnrollment> getAllEnrolledAirlines() {
		StringBuilder localStringBuilder = new StringBuilder(QUERY_AIRILNE_ENROLLMENT_CONFIGURATION);
		Map<String, Object> params = new HashMap<>();
        List<IAirlineEnrollment> configurationList = jdbcTemplate.query(localStringBuilder.toString(), params, new AirlineEnrollmentConfigurationRowMapper());
        return configurationList;
	}
}
