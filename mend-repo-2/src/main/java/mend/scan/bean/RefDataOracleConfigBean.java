/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration bean for Oracle database connection settings used in the UAE Gateway.
 * <p>
 * Holds essential properties such as JDBC URL, credentials, and driver class name.
 */
@Configuration
@ConfigurationProperties(prefix = "oracle.ref-datasource")
public class RefDataOracleConfigBean {

    /**
     * The JDBC URL used to connect to the Oracle database.
     */
    private String url;

    /**
     * The username used for database authentication.
     */
    private String username;

    /**
     * The password used for database authentication.
     */
    private String password;

    /**
     * The fully qualified name of the JDBC driver class.
     */
    private String driverClassName;

    /**
     * Gets the JDBC URL used for the Oracle database connection.
     *
     * @return the JDBC URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the JDBC URL used for the Oracle database connection.
     *
     * @param url the JDBC URL to set
     */
    public void setUrl(final String url) {
        this.url = url;
    }

    /**
     * Gets the username for the Oracle database.
     *
     * @return the database username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for the Oracle database.
     *
     * @param username the username to set
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Gets the password for the Oracle database.
     *
     * @return the database password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the Oracle database.
     *
     * @param password the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Gets the fully qualified name of the JDBC driver class.
     *
     * @return the JDBC driver class name
     */
    public String getDriverClassName() {
        return driverClassName;
    }

    /**
     * Sets the fully qualified name of the JDBC driver class.
     *
     * @param driverClassName the driver class name to set
     */
    public void setDriverClassName(final String driverClassName) {
        this.driverClassName = driverClassName;
    }
}

