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
public class GeoPoint implements IGeoPoint {

    /** The decimal degrees value of the latitude. */
    private double latitude;

    /** The decimal degrees value of the longitude. */
    private double longitude;

    /** The seconds value to use in geo point calculations. */
    private static final int SECONDS = 60;

    /**
     * Constructs a GeoPoint from a given latitude and longitude.
     * @param latitude the decimal degrees value of the latitude
     * @param longitude the decimal degrees value of the longitude
     */
    public GeoPoint(final double latitude, final double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public double getLatitude() {
        return latitude;
    }

    @Override
    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toDMSString() {
        return toLatitudeDMS() + " " + toLongitudeDMS();
    }

    @Override
    public String toLatitudeDMS() {
        String direction = "N";
        if (latitude < 0) {
            direction = "S";
        }
        return convert(latitude) + direction;
    }

    @Override
    public String toLongitudeDMS() {
        String direction = "E";
        if (longitude < 0) {
            direction = "W";
        }
        return convert(longitude) + direction;
    }

    private String convert(final double decimalDegreesValue) {
        double valueToConvert = decimalDegreesValue;
        if (decimalDegreesValue < 0) {
            valueToConvert = decimalDegreesValue * -1;
        }

        // Degrees
        int i = Double.valueOf(valueToConvert).intValue();
        String str = Integer.toString(i) + ".";

        // Minutes
        double minutes = valueToConvert - i;
        minutes = minutes * SECONDS;
        i = Double.valueOf(minutes).intValue();
        str += Integer.toString(i) + ".";

        // Seconds
        double seconds = minutes - i;
        seconds = seconds * SECONDS;
        i = Double.valueOf(Math.round(seconds)).intValue();
        str += Integer.toString(i);

        return str;
    }
}
