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

/**
 * Represents a point on the Earth's surface, in latitude and longitude coordinates.
 */
public interface IGeoPoint {

    /**
     * Gets the decimal degrees value of the latitude.
     * @return the decimal degrees value of the latitude.
     */
    double getLatitude();

    /**
     * Gets the decimal degrees value of the longitude.
     * @return the decimal degrees value of the longitude.
     */
    double getLongitude();

    /**
     * Outputs the geo point as a Degree Minute Second string value.
     * @return the geo point as a Degree Minute Second string value.
     */
    String toDMSString();

    /**
     * Returns the latitude as a Degree Minute Second string value.
     * @return the latitude as a Degree Minute Second string value
     */
    String toLatitudeDMS();

    /**
     * Returns the latitude as a Degree Minute Second string value.
     * @return the latitude as a Degree Minute Second string value
     */
    String toLongitudeDMS();
}
