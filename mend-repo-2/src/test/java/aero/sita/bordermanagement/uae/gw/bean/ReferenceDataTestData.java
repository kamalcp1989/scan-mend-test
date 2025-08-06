/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2013
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.bean;

/**
 * Interface defining useful data for Reference Data tests.
 *
 */
public interface ReferenceDataTestData {

//    int SITA_CODE = 3;
    String SITA_CODE = "3";
    String SITA_CODE_2452188 = "2452188";
    String NOT_EXISTS_SITA_CODE = "00";
    String INVALID_SITA_CODE = "@$";
    String NULL_SITA_CODE = null;

    String USER ="DB_USER";
    String IATA_SITA_CODE = "IATA_CODE";
    String ICAO_SITA_CODE = "ICAO_CODE";
    String UNLOC_SITA_CODE = "UNLOC_CODE";

    String IATA_CODE = "IATA_CODE";
    String ICAO_CODE = "ICAO_CODE";
    String UNLOC_CODE = "UNLOC_CODE";
    String OTHER_CODE = "OTHER_CODE";

    String ISO_CODE_1 = "1";
    String ISO_CODE_2 = "12";
    String ISO_CODE_3 = "123";

    // Not implemented.
    String TIMEZONE = null;

    String IATA_NAME = "IATA_NAME";
    String IATA_NAME_NL = "IATA_NAME_NL";
    String IATA_NAME_SHORT = "IATA_NAME_SHORT";
    String IATA_NAME_SHORT_NL = "IATA_NAME_SHORT_NL";

    String ICAO_NAME = "ICAO_NAME";
    String ICAO_NAME_NL = "ICAO_NAME_NL";
    String ICAO_NAME_SHORT = "ICAO_NAME_SHORT";
    String ICAO_NAME_SHORT_NL = "ICAO_NAME_SHORT_NL";

    String UNLO_NAME = "UNLO_NAME";
    String UNLO_NAME_NL = "UNLO_NAME_NL";
    String UNLO_NAME_SHORT = "UNLO_NAME_SHORT";
    String UNLO_NAME_SHORT_NL = "UNLO_NAME_SHORT_NL";

    String OTHER_NAME = "OTHER_NAME";
    String OTHER_NAME_NL = "OTHER_NAME_NL";
    String OTHER_NAME_SHORT = "OTHER_NAME_SHORT";
    String OTHER_NAME_SHORT_NL = "OTHER_NAME_SHORT_NL";

    String TRUE_FLAG = "Y";
    String CITY_IATA_CODE = "CITY_IATA_CODE";
    String CITY_IATA_NAME = "CITY_IATA_NAME";
    String CITY_IATA_NAME_SHORT = "CITY_IATA_NAME_SHORT";
    String CITY_IATA_NAME_NL = "CITY_IATA_NAME_NL";
    String CITY_IATA_NAME_SHORT_NL = "CITY_IATA_NAME_SHORT_NL";

    String CITY_ICAO_CODE = "CITY_ICAO_CODE";
    String CITY_ICAO_NAME = "CITY_ICAO_NAME";
    String CITY_ICAO_NAME_SHORT = "CITY_ICAO_NAME_SHORT";
    String CITY_ICAO_NAME_NL = "CITY_ICAO_NAME_NL";
    String CITY_ICAO_NAME_SHORT_NL = "CITY_ICAO_NAME_SHORT_NL";

    String CITY_UNLO_CODE = "CITY_UNLO_CODE";
    String CITY_UNLO_NAME = "CITY_UNLO_NAME";
    String CITY_UNLO_NAME_SHORT = "CITY_UNLO_NAME_SHORT";
    String CITY_UNLO_NAME_NL = "CITY_UNLO_NAME_NL";
    String CITY_UNLO_NAME_SHORT_NL = "CITY_UNLO_NAME_SHORT_NL";

    String CITY_OTHER_CODE = "CITY_OTHER_CODE";
    String CITY_OTHER_NAME = "CITY_OTHER_NAME";
    String CITY_OTHER_NAME_SHORT = "CITY_OTHER_NAME_SHORT";
    String CITY_OTHER_NAME_NL = "CITY_OTHER_NAME_NL";
    String CITY_OTHER_NAME_SHORT_NL = "CITY_OTHER_NAME_SHORT_NL";

    String COUNTRY_CODE = "COUNTRY_CODE";
    String COUNTRY_NAME = "COUNTRY_NAME";
    String COUNTRY_NAME_SHORT = "COUNTRY_NAME_SHORT";
    String COUNTRY_NAME_NL = "COUNTRY_NAME_NL";
    String COUNTRY_NAME_SHORT_NL = "COUNTRY_NAME_SHORT_NL";

    String COUNTRY_SUBDIVISION_CODE = "COUNTRY_SUBDIVISION_CODE";
    String COUNTRY_SUBDIVISION_NAME = "COUNTRY_SUBDIVISION_NAME";
    String COUNTRY_SUBDIVISION_NAME_SHORT = "COUNTRY_SUBDIVISION_NAME_SHORT";
    String COUNTRY_SUBDIVISION_NAME_NL = "COUNTRY_SUBDIVISION_NAME_NL";
    String COUNTRY_SUBDIVISION_NAME_SHORT_NL = "COUNTRY_SUBDIVISION_NAME_SHORT_NL";

    Integer TIME_ZONE_ID = Integer.valueOf(12);

    //IATA opertor codes
    String OPERATOR_SITA_CODE_BRITISH = "SOP0001449";

    String OPERATOR_IATA_CODE_BRITISH = "BA";
    String OPERATOR_IATA_CODE_VIRGIN = "VS";
    String OPERATOR_IATA_CODE_BMIBABY = "WW";

    String OPERATOR_INVALID_IATA_CODE = "@$";

    //ICAO opertor codes
    String OPERATOR_ICAO_CODE_BRITISH = "BAW";
    String OPERATOR_ICAO_CODE_VIRGIN = "VIR";
    String OPERATOR_ICAO_CODE_BMIBABY = "BMI";

    //OTHER opertor codes
    String OPERATOR_OTHER_CODE_XXX = "XXX";

    //TEST opertor codes
    String OPERATOR_IATA_CODE_TEST = "TT";

    // Generic tests
    String NAME = "NAME";
    String NAME_NL = "NAME_NL";
    String CODE = "CODE";
    String TYPE = "TYPE";

    String GROUP_CODE = "CODE";
    String LOCATION_SUBDIVISION_ID = "LOCATION_SUBDIVISION_ID";
    String SITA_LOCATION_ID = "SITA_LOCATION_ID";

    String DESCRIPTION = "DESCRIPTION";
    String DESCRIPTION_NL = "DESCRIPTION_NL";

    String OPERATOR_IATA_CODE_JAPAN_AIR = "JC";
    String OPERATOR_SITA_CODE_JAPAN_AIR = "SOP0000333";

    String OPERATOR_IATA_CODE_JG_AIR = "JG";
    String OPERATOR_SITA_CODE_JG_AIR = "SOP0000334";
    String OPERATOR_ICAO_CODE_JG_AIR = "JAG";
}
