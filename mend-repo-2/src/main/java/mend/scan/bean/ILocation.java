/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2018
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.time.LocalDate;
import java.util.List;



/**
 * Interface for the main location bean.
 */
public interface ILocation extends IBaseLocation {

    /**
     * Gets the sita code for the location.
     * @return sita code for the location.
     */
    String getSitaCode();

    /**
     * Gets the sita code specific for the iata location.
     * @return iata sita code for the location.
     */
    String getIataSitaCode();

    /**
     * Gets the sita code specific for the icao location.
     * @return icao sita code for the location.
     */
    String getIcaoSitaCode();

    /**
     * Gets the sita code specific for the unlo location.
     * @return unlo sita code for the location.
     */
    String getUnLoSitaCode();

    /**
     * Gets the iata code for the location.
     * @return iata code for the location.
     */
    String getIataCode();

    /**
     * Gets the iata valid from.
     *
     * @return the iata valid from
     */
    LocalDate getIataValidFrom();

    /**
     * Gets the iata valid to.
     *
     * @return the iata valid to
     */
    LocalDate getIataValidTo();

    /**
     * Gets the IATA name in default language, typically English.
     * @return IATA name in default language, typically English.
     */
    String getIataName();

    /**
     * Gets the IATA name in national locale.
     * @return IATA name in national locale.
     */
    String getIataNameNL();

    /**
     * Gets the IATA short name in default language, typically English.
     * @return IATA short name in default language, typically English.
     */
    String getIataShortName();

    /**
     * Gets the IATA short name in national locale.
     * @return IATA short name in national locale.
     */
    String getIataShortNameNL();

    /**
     * Gets the ICAO code for the location.
     * @return ICAO code for the location.
     */
    String getIcaoCode();

    /**
     * Gets the icao valid from.
     *
     * @return the icao valid from
     */
    LocalDate getIcaoValidFrom();

    /**
     * Gets the icao valid to.
     *
     * @return the icao valid to
     */
    LocalDate getIcaoValidTo();

    /**
     * Gets the ICAO name in default language, typically English.
     * @return ICAO name in default language, typically English.
     */
    String getIcaoName();

    /**
     * Gets the ICAO name in national locale.
     * @return ICAO name in national locale.
     */
    String getIcaoNameNL();

    /**
     * Gets the ICAO short name in default language, typically English.
     * @return ICAO short name in default language, typically English.
     */
    String getIcaoShortName();

    /**
     * Gets the ICAO short name in national locale.
     * @return ICAO short name in national locale.
     */
    String getIcaoShortNameNL();

    /**
     * Gets the UN/LOCode code for the location.
     * @return UN/LOCode code for the location.
     */
    String getUnLoCode();

    /**
     * Gets the un loc valid from.
     *
     * @return the un loc valid from
     */
    LocalDate getUnLoValidFrom();

    /**
     * Gets the un loc valid to.
     *
     * @return the un loc valid to
     */
    LocalDate getUnLoValidTo();

    /**
     * Gets the UN/LOCODE name in default language, typically English.
     * @return UN/LOCODE name in default language, typically English.
     */
    String getUnLoName();

    /**
     * Gets the UN/LOCODE name in national locale.
     * @return UN/LOCODE name in national locale.
     */
    String getUnLoNameNL();

    /**
     * Gets the UN/LOCODE short name in default language, typically English.
     * @return UN/LOCODE short name in default language, typically English.
     */
    String getUnLoShortName();

    /**
     * Gets the UN/LOCODE short name in national locale.
     * @return UN/LOCODE short name in national locale.
     */
    String getUnLoShortNameNL();

    /**
     * Gets the other code for the location.
     * @return other code for the location.
     */
    String getOtherCode();

    /**
     * Gets the other valid from.
     *
     * @return the other valid from
     */
    LocalDate getOtherValidFrom();

    /**
     * Gets the other valid to.
     *
     * @return the other valid to
     */
    LocalDate getOtherValidTo();

    /**
     * Gets the Other code name in default language, typically English.
     * @return Other code name in default language, typically English.
     */
    String getOtherName();

    /**
     * Gets the Other code name in national locale.
     * @return Other code name in national locale.
     */
    String getOtherNameNL();

    /**
     * Gets the Other code short name in default language, typically English.
     * @return Other code short name in default language, typically English.
     */
    String getOtherShortName();

    /**
     * Gets the Other code short name in national locale.
     * @return Other code short name in national locale.
     */
    String getOtherShortNameNL();

    /**
     * Finds the first name defined in the following order:
     * Other, IATA, ICAO, UN/LOCODE.
     * @return preferred code  name in default language, typically English.
     */
    String getPreferredName();

    /**
     * Finds the first name defined in the following order:
     * Other, IATA, ICAO, UN/LOCODE.
     * @return Preferred code  name in national locale.
     */
    String getPreferredNameNL();

    /**
     * Finds the first name defined in the following order:
     * Other, IATA, ICAO, UN/LOCODE.
     * @return Preferred code  short name in default language, typically English.
     */
    String getPreferredShortName();

    /**
     * Finds the first name defined in the following order:
     * Other, IATA, ICAO, UN/LOCODE.
     * @return Preferred code  short name in national locale.
     */
    String getPreferredShortNameNL();

    /**
     * Gets the location type this location represents.
     * @return the location type for this location.
     * @deprecated use getPrimaryLocationType instead
     */
    @Deprecated
    LocationType getType();

    /**
     * Gets the primary type of this location.
     * For example in the case of London Heathrow Airport the primary type is Airport even
     * though you can catch a plane, bus or train from it.
     * @return the location type for this location.
     */
    LocationType getPrimaryLocationType();


    /**
     * Gets the list of location usage types for this location.
     * @return list of location usage types for this location.
     */
    List<LocationUsageType> getUsageTypeList();


    /**
     * Gets the city location information.
     * @return city location information.
     */
    ILocation getCity();

    /**
     * Gets the Country information for the location.
     * @return Country information for the location.
     */
    ICountry getCountry();

    /**
     * Does this location have an IATA Code?
     * @return true if location has code.
     */
    boolean isIataCodeAvailable();

    /**
     * Does this location have a ICAO code?
     * @return true if location has code.
     */
    boolean isIcaoCodeAvailable();

    /**
     * Does this location have a UN/LO code?
     * @return true if location has code.
     */
    boolean isUnLoCodeAvailable();

    /**
     * Does this location have a.n. other type of code?
     * @return true if location has code.
     */
    boolean isOtherCodeAvailable();

    /**
     * Does this location contain the given type?
     * @param type locationType to search for.
     * @return true if this location contains this locationType
     * @deprecated use isUsageType instead
     */
    @Deprecated
    boolean isType(LocationType type);

    /**
     * Is this an airport location type.
     * @return true if this is an airport location type.
     * @deprecated use isAirUsage instead
     */
    @Deprecated
    boolean isAirport();

    /**
     * Is this a seaport location type.
     * @return true if this is an seaport location type.
     * @deprecated use isSeaUsage instead
     */
    @Deprecated
    boolean isSeaport();

    /**
     * Is this a bus station location type.
     * @return true if this is an bus station location type.
     * @deprecated use isBusUsage instead
     */
    @Deprecated
    boolean isBusStation();

    /**
     * Is this a road location type.
     * @return true if this is an rail station location type.
     * @deprecated use isRailUsage instead
     */
    @Deprecated
    boolean isRailStation();

    /**
     * Is this a commercial location type.
     * @return true if this is an commercial location type.
     * @deprecated no alternative
     */
    @Deprecated
    boolean isCommercial();

    /**
     * Is this a city location type.
     * @return true if this is an city location type.
     */
    boolean isCity();

    /**
     * Is this a border point location.
     * @return true if this is an border point location.
     * @deprecated use isBorderUsage instead
     */
    @Deprecated
    boolean isBorderPoint();

    /**
     * Does this location contain the given type?
     * @param usageType locationUsageType to search for.
     * @return true if this location contains this locationUsageType
     */
    boolean isUsageType(LocationUsageType usageType);

    /**
     * Is this location used as an air location.
     * @return true if this location is used as an air location
     */
    boolean isAirUsage();

    /**
     * Is this location used as a road location.
     * @return true if this location is used as an air location.
     */
    boolean isRoadUsage();

    /**
     * Is this location used as a sea location.
     * @return true if this location is used as a sea location.
     */
    boolean isSeaUsage();

    /**
     * Is this location used as a rail location.
     * @return true if this location is used as a rail location.
     */
    boolean isRailUsage();

    /**
     * Is this location used as a hotel location.
     * @return true if this location is used as a hotel location.
     */
    boolean isHotelUsage();

    /**
     * Is this location used as a car hire location.
     * @return true if this location is used as a car hire location.
     */
    boolean isCarHireUsage();

    /**
     * Is this location used as a shop location.
     * @return true if this location is used as a shop location.
     */
    boolean isShopUsage();

    /**
     * Is this location used as a misc location.
     * @return true if this location is used as a misc location.
     * @deprecated no replacement
     */
    @Deprecated
    boolean isMiscUsage();

    /**
     * Is this location used as a border location.
     * @return true if this location is used as a border location.
     */
    boolean isBorderUsage();

    /**
     * Get country subdivision information for this location.
     * @return ICountrySubdivision  the subdivision.
     */
    ICountrySubdivision getCountrySubdivision();

    /**
     * Finds the first code defined in the following order:
     * Other, IATA, ICAO, UN/LOCODE.
     * @return preferred code.
     */
    String getPreferredCode();

    /**
     * The point of the Earths surface where this location resides.
     * @return the point of the Earths surface where this location resides
     */
    IGeoPoint getGeoPoint();

    /**
     * The identifier associated to the time-zone this location resides in.
     * @return the identifier associated to the time-zone this location resides in
     */
    Integer getTimeZoneId();

    /**
     * The code associated to the time-zone this location resides in.
     * @return the code associated to the time-zone this location resides in
     */
    String getTimeZoneCode();
}
