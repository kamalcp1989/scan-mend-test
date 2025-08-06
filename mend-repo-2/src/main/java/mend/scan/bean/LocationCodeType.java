/* This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2011
 * Confidential. All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.bean;

/**
 * Enum of possible location code types used for retrieving location information from a datasource.
 *
 * @author snash
 *
 */
public enum LocationCodeType {
    /** IATA code type. The code type is IATA and formatted as 3 alphabetic characters.*/
    IATA,
    /** ICAO code type. The code type is ICAO and formatted as 4 alphanumeric characters.*/
    ICAO,
    /** UNLOC code type. The code type is UNLOCODE and formatted as 5 alphanumeric characters.*/
    UNLOC,
    /** SITA code type. The code type is SITA and formatted as >= 3 and <= 10 alphanumeric characters.*/
    SITA,
    /** Unknown code type. The code type is UNKNOWN and may be of any format.*/
    UNKNOWN,
    /** Other code type. The code type is OTHER and is of a bespoke format - >= 3 and <= 10 alphanumeric characters.*/
    OTHER;
}
