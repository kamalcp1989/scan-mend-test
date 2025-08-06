/* This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2014
 * Confidential. All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.bean;

/**
 * Enum of possible location usage types.
 *
 */
public enum LocationUsageType {
    /** Air usage type. */
    AIR,
    /** Road usage type. */
    ROAD,
    /** Sea usage type. */
    SEA,
    /** Rail usage type. */
    RAIL,
    /** Car hire usage type. */
    CAR_HIRE,
    /** Hotel usage type. */
    HOTEL,
    /** Shop usage type. */
    SHOP,
    /** Border usage type. */
    BORDER,
    /** Miscellaneous usage type. @deprecated no replacement*/
    @Deprecated
    MISC,
    /** Unknown usage type. */
    UNKNOWN,
}

