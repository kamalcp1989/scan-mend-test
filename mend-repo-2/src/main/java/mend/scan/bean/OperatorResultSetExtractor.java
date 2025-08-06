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

import aero.sita.bordermanagement.uae.gw.bean.Operator.OperatorBuilder;

/**
 * This Class utility class converts the JDBC ResultSet into List<IOperator> objects.
 *
 */
public class OperatorResultSetExtractor extends AbstractBaseResultSetExtractor<OperatorBuilder, IOperator> {

    /** OperatorType. */
    private static final String TYPE = "type";

    /** IATA Code for the operator. */
    private static final String IATA_CODE = "iata_code";

    /** IATA name in default language, typically English. */
    private static final String IATA_NAME = "iata_name";

    /** ICAO code. */
    private static final String ICAO_CODE = "icao_code";

    /** ICAO name in default language, typically English. */
    private static final String ICAO_NAME = "icao_name";

      /** Any other code. */
    private static final String OTHER_CODE = "other_code";

    /** Other name in default language, typically English. */
    private static final String OTHER_NAME = "other_name";

    /** Other Id of the operator. */
    private static final String OTHER_OPERATOR_ID = "other_operator_id";

    /** Operator type Description, typically English. */
    private static final String TYPE_DESCRIPTION = "typeDescription";

    /** Operator type Description in national locale. */
    private static final String TYPE_DESCRIPTION_NL = "typeDescriptionNL";

    /** Sita country code. */
    private static final String COUNTRY_CODE = "country_code";

    /** ISO 3 country code. */
    private static final String ISO3_COUNTRY_CODE = "country_code_a3";

    /** ISO 2 country code. */
    private static final String ISO2_COUNTRY_CODE = "country_code_a2";

    /** ISO 1 country code. */
    private static final String ISO1_COUNTRY_CODE = "country_code_a1";

    /** Country . */
    private static final String COUNTRY_NAME = "country_name";

    /** Is there any associated flight, traveller information etc. */
    private static final String DATA_RECEIVED = "data_received";

    @Override
    protected OperatorBuilder createBuilder() throws SQLException {
        OperatorBuilder operatorBuilder = new Operator.OperatorBuilder();
        return operatorBuilder;
    }

    @Override
    protected String getReferenceDataKey(final ResultSet rs) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getReferenceDataKey(rs));
        sb.append(getLocalDate(rs, IATA_VALID_FROM));
        sb.append(getLocalDate(rs, IATA_VALID_TO));
        sb.append(getLocalDate(rs, ICAO_VALID_FROM));
        sb.append(getLocalDate(rs, ICAO_VALID_TO));
        sb.append(getLocalDate(rs, OTHER_VALID_FROM));
        sb.append(getLocalDate(rs, OTHER_VALID_TO));
        return sb.toString();
    }

    @Override
    protected void mapReferenceDataRow(
            final ResultSet rs,
            final OperatorBuilder operatorBuilder) throws SQLException {
        super.mapReferenceDataRow(rs, operatorBuilder);
        operatorBuilder.setType(rs.getString(TYPE));
        operatorBuilder.setIataCode(rs.getString(IATA_CODE));
        operatorBuilder.setIataName(rs.getString(IATA_NAME));
        operatorBuilder.setIcaoCode(rs.getString(ICAO_CODE));
        operatorBuilder.setIcaoName(rs.getString(ICAO_NAME));
        operatorBuilder.setOtherCode(rs.getString(OTHER_CODE));
        operatorBuilder.setOtherName(rs.getString(OTHER_NAME));
        operatorBuilder.setOtherId(rs.getString(OTHER_OPERATOR_ID));
        operatorBuilder.setTypeDescription(rs.getString(TYPE_DESCRIPTION));
        operatorBuilder.setTypeDescriptionNL(StringUtils.isNotBlank(rs.getString(TYPE_DESCRIPTION_NL)) ? rs.getString(TYPE_DESCRIPTION_NL) : rs.getString(TYPE_DESCRIPTION));
        operatorBuilder.setCountryCode(rs.getString(COUNTRY_CODE));
        operatorBuilder.setIsoCode3(rs.getString(ISO3_COUNTRY_CODE));
        operatorBuilder.setIsoCode2(rs.getString(ISO2_COUNTRY_CODE));
        operatorBuilder.setIsoCode1(rs.getString(ISO1_COUNTRY_CODE));
        operatorBuilder.setCountryName(rs.getString(COUNTRY_NAME));
        operatorBuilder.setDataReceived(rs.getString(DATA_RECEIVED));
        operatorBuilder.setIataValidFrom(getLocalDate(rs, IATA_VALID_FROM));
        operatorBuilder.setIataValidTo(getLocalDate(rs, IATA_VALID_TO));
        operatorBuilder.setIcaoValidFrom(getLocalDate(rs, ICAO_VALID_FROM));
        operatorBuilder.setIcaoValidTo(getLocalDate(rs, ICAO_VALID_TO));
        operatorBuilder.setOtherValidFrom(getLocalDate(rs, OTHER_VALID_FROM));
        operatorBuilder.setOtherValidTo(getLocalDate(rs, OTHER_VALID_TO));
    }
}
