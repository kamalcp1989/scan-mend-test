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
 * Enum of possible location site types used for retrieving location information from a datasource.
 */
public enum LocationType {
    /** Airport location. */
    AIRPORT,
    /** Bus station location. */
    BUS_STATION,
    /** Sea port location. */
    SEAPORT,
    /** Rail station location. */
    RAIL_STATION,
    /** A commercial location. */
    COMMERCIAL,
    /** City location type. */
    CITY,
    /** Unknown location. */
    UNKNOWN,
    /** Border point location. */
    BORDER_POINT;
}

