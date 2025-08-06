/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.cusres;

/**
 * @author SITA
 *
 */
public class Location {

    /**
     * qualifier String
     */
    public String qualifier;

    /**
     * locationCode String
     */
    public String locationCode;

    /**
     * @param qualifier
     * @param locationCode
     */
    public Location(final String qualifier, final String locationCode) {
        this.qualifier = qualifier;
        this.locationCode = locationCode;
    }

    /**
     * @return String
     */
    public String getQualifier() {
        return qualifier;
    }

    /**
     * @param qualifier
     */
    public void setQualifier(final String qualifier) {
        this.qualifier = qualifier;
    }

    /**
     * @return String
     */
    public String getLocationCode() {
        return locationCode;
    }

    /**
     * @param locationCode
     */
    public void setLocationCode(final String locationCode) {
        this.locationCode = locationCode;
    }

}
