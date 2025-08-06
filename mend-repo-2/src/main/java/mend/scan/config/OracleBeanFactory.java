/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.config;

import oracle.jdbc.pool.OracleDataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import aero.sita.bordermanagement.uae.gw.bean.RefDataOracleConfigBean;
import aero.sita.bordermanagement.uae.gw.bean.UAEGatewayOracleConfigBean;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * OracleBeanFactory
 */
@Configuration
public class OracleBeanFactory {

	private static final Logger LOG = LoggerFactory.getLogger(OracleBeanFactory.class);
	
	/**
	 * @param props
	 * @return Oracle Datasource
	 * @throws SQLException
	 */
	@Bean(name="dataSource")
    public DataSource dataSource(final UAEGatewayOracleConfigBean props) throws SQLException {
		
		LOG.info("UAEGatewayOracleBeanFactory :: "+props.getUrl()+" driverClass:: "+ props.getDriverClassName()+ " Username: "+props.getUsername()+ " Password: "+props.getPassword());
        OracleDataSource ds = new OracleDataSource();
        ds.setURL(props.getUrl());
        ds.setUser(props.getUsername());
        ds.setPassword(props.getPassword());
        return ds;
    }

    /**
     * @param dataSource
     * @return JdbcTemplate
     */
    @Bean(name="jdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") final DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
    @Bean(name = "namedJdbcTemplate")
    public NamedParameterJdbcTemplate namedJdbcTemplate(@Qualifier("dataSource") DataSource ds) {
        return new NamedParameterJdbcTemplate(ds);
    }
    
    
	/**
	 * @param props
	 * @return Oracle Datasource
	 * @throws SQLException
	 */
	@Bean(name = "refDataSource")
    public DataSource refDataSource(final RefDataOracleConfigBean props) throws SQLException {
		
		LOG.info("RefDataOracleConfigBean :: "+props.getUrl()+" driverClass:: "+ props.getDriverClassName()+ " Username: "+props.getUsername()+ " Password: "+props.getPassword());
        OracleDataSource ds = new OracleDataSource();
        ds.setURL(props.getUrl());
        ds.setUser(props.getUsername());
        ds.setPassword(props.getPassword());
        return ds;
    }
	
    /**
     * @param dataSource
     * @return JdbcTemplate
     */
    @Bean(name = "refDataJdbcTemplate")
    public JdbcTemplate refDataJdbcTemplate(@Qualifier("refDataSource") final DataSource refDataSource) {
        return new JdbcTemplate(refDataSource);
    }
    
    @Bean(name = "refDataNamedJdbcTemplate")
    public NamedParameterJdbcTemplate refDataNamedJdbcTemplate(@Qualifier("refDataSource") DataSource ds) {
        return new NamedParameterJdbcTemplate(ds);
    }
}
