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
 * Enum of possible code types used for retrieving political state information from a datasource.
 *
 * @author snash
 *
 */
public enum PoliticalStateCodeType {
    /** SITA political state code type. The code type is SITA and formatted as >= 3 and <= 10 alphanumeric characters.*/
    SITA,
    /** ISO-1 political state code type. The code type is ISO-1 and formatted as a single alphabetic character.*/
    ISO1,
    /** ISO-2 political state code type. The code type is ISO-2 and formatted as 2 alphabetic characters.*/
    ISO2,
    /** ISO-3 political state code type. The code type is ISO-3 and formatted as 3 alphabetic characters.*/
    ISO3,
    /** Unknown code type. The code type is UNKNOWN and may be of any format.*/
    UNKNOWN;
}

