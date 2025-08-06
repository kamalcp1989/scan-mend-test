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
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import aero.sita.bordermanagement.uae.gw.bean.CountrySubdivision.CountrySubvisionBuilder;

/**
 *
 * Main location bean.
 */
public final class Location extends AbstractBaseLocation implements ILocation {

    /** The sita IATA code for the location. */
    private final String iataSitaCode;

    /** The sita ICAO code for the location. */
    private final String icaoSitaCode;

    /** The sita UNLO code for the location. */
    private final String unLoSitaCode;

    /** Iata Code for the location. */
    private final String iataCode;

    /** IATA code valid from date. */
    private LocalDate iataValidFrom;

    /** IATA code valid to date. */
    private LocalDate iataValidTo;

    /** IATA name in default language, typically English. */
    private final String iataName;

    /** IATA name in national locale. */
    private final String iataNameNL;

    /** IATA short name in default language, typically English. */
    private final String iataShortName;

    /** IATA short name in national locale. */
    private final String iataShortNameNL;

    /** ICAO code. */
    private final String icaoCode;

    /** ICAO code valid from date. */
    private LocalDate icaoValidFrom;

    /** ICAO code valid to date. */
    private LocalDate icaoValidTo;

    /** ICAO name in default language, typically English. */
    private final String icaoName;

    /** ICAO name in national locale. */
    private final String icaoNameNL;

    /** ICAO short name in default language, typically English. */
    private final String icaoShortName;

    /** ICAO short name in national locale. */
    private final String icaoShortNameNL;

    /** UN/LO Codes. */
    private final String unLoCode;

    /** UN/LO code valid from date. */
    private LocalDate unLoValidFrom;

    /** UN/LO code valid to date. */
    private LocalDate unLoValidTo;

    /** UN/LO name in default language, typically English. */
    private final String unLoName;

    /** UN/LO name in national locale. */
    private final String unLoNameNL;

    /** UN/LO short name in default language, typically English. */
    private final String unLoShortName;

    /** UN/LO short name in national locale. */
    private final String unLoShortNameNL;

    /** Any other code. */
    private final String otherCode;

    /** Other code valid from date. */
    private LocalDate otherValidFrom;

    /** Other code valid to date. */
    private LocalDate otherValidTo;

    /** Other name in default language, typically English. */
    private final String otherName;

    /** Other name in national locale. */
    private final String otherNameNL;

    /** Other short name in default language, typically English. */
    private final String otherShortName;

    /** Other short name in national locale. */
    private final String otherShortNameNL;

    /** LocationType. */
    private final LocationType type;

    /** List of locationUsageTypes. */
    private final List<LocationUsageType> usageTypeList = new ArrayList<LocationUsageType>();

    /** city location. */
    private Location city;

    /** Country information. **/
    private ICountry country;

    /** Country subdivision information. **/
    private ICountrySubdivision countrySubdivision;

    /** The point of the Earths surface where this location resides. */
    private IGeoPoint geoPoint;

    /** The identifier associated to the time-zone this location resides in. */
    private Integer timeZoneId;

    /** The code associated to the time-zone this location resides in. */
    private String timeZoneCode;

    /**
     * Generates a <code>Location</code> object from the supplied
     * builder.
     * @param builder <code>Builder</code> object from which to create a new <code>Location</code>
     */
    private Location(final LocationBuilder builder) {
        super(builder);

        if (builder.type != null) {
            this.type = LocationType.valueOf(builder.type);
        } else {
            this.type = null;
        }

        this.iataSitaCode = builder.iataSitaCode;
        this.icaoSitaCode = builder.icaoSitaCode;
        this.unLoSitaCode = builder.unLoSitaCode;

        this.iataCode = builder.iataCode;
        this.iataValidFrom = builder.iataValidFrom;
        this.iataValidTo = builder.iataValidTo;
        this.iataName = builder.iataName;
        this.iataNameNL = builder.iataNameNL;
        this.iataShortName = builder.iataShortName;
        this.iataShortNameNL = builder.iataShortNameNL;

        this.icaoCode = builder.icaoCode;
        this.icaoValidFrom = builder.icaoValidFrom;
        this.icaoValidTo = builder.icaoValidTo;
        this.icaoName = builder.icaoName;
        this.icaoNameNL = builder.icaoNameNL;
        this.icaoShortName = builder.icaoShortName;
        this.icaoShortNameNL = builder.icaoShortNameNL;

        this.unLoCode = builder.unLoCode;
        this.unLoValidFrom = builder.unLoValidFrom;
        this.unLoValidTo = builder.unLoValidTo;
        this.unLoName = builder.unLoName;
        this.unLoNameNL = builder.unLoNameNL;
        this.unLoShortName = builder.unLoShortName;
        this.unLoShortNameNL = builder.unLoShortNameNL;

        this.otherCode = builder.otherCode;
        this.otherValidFrom = builder.otherValidFrom;
        this.otherValidTo = builder.otherValidTo;
        this.otherName = builder.otherName;
        this.otherNameNL = builder.otherNameNL;
        this.otherShortName = builder.otherShortName;
        this.otherShortNameNL = builder.otherShortNameNL;
        this.timeZoneId = builder.timeZoneId;
        this.timeZoneCode = builder.timeZoneCode;

        buildUsage(builder);

        // Optionally sets the geoPoint
        buildGeoPoint(builder);
        // Optionally sets the city.
        buildCity(builder);
        // Optionally sets the country subdivision.
        buildCountrySubvision(builder);
        // Optionally sets the Country.
        buildCountry(builder);
    }

    private void buildUsage(final LocationBuilder builder) {
        if (builder.airFlag) {
            usageTypeList.add(LocationUsageType.AIR);
        }
        if (builder.roadFlag) {
            usageTypeList.add(LocationUsageType.ROAD);
        }
        if (builder.seaFlag) {
            usageTypeList.add(LocationUsageType.SEA);
        }
        if (builder.railFlag) {
            usageTypeList.add(LocationUsageType.RAIL);
        }
        if (builder.hotelFlag) {
            usageTypeList.add(LocationUsageType.HOTEL);
        }
        if (builder.carHireFlag) {
            usageTypeList.add(LocationUsageType.CAR_HIRE);
        }
        if (builder.shopFlag) {
            usageTypeList.add(LocationUsageType.SHOP);
        }
        if (builder.borderFlag) {
            usageTypeList.add(LocationUsageType.BORDER);
        }
    }

    /**
     * Builds everything to create a city.
     * @param builder Location Builder - information from the view.
     */
    private void buildGeoPoint(final LocationBuilder builder) {
        if (Math.abs(builder.latitude) != 0 && Math.abs(builder.longitude) != 0) {
            geoPoint = new GeoPoint(builder.latitude, builder.longitude);
        }
    }

    /**
     * Builds everything to create a city.
     * @param builder Location Builder - information from the view.
     */
    private void buildCity(final LocationBuilder builder) {
        // Build the city information.
        if (builder.isCityBuilder()) {
            Location.LocationBuilder cityBuilder = new Location.LocationBuilder();
            cityBuilder.setType(LocationType.CITY.name());
            cityBuilder.setSitaCode(builder.citySitaCode);
            cityBuilder.setIataCode(builder.cityIataCode);
            cityBuilder.setIataName(builder.cityIataName);
            cityBuilder.setIataShortName(builder.cityIataShortName);
            cityBuilder.setIataNameNL(builder.cityIataNameNL);
            cityBuilder.setIataShortNameNL(builder.cityIataShortNameNL);

            cityBuilder.setIcaoCode(builder.cityIcaoCode);
            cityBuilder.setIcaoName(builder.cityIcaoName);
            cityBuilder.setIcaoShortName(builder.cityIcaoShortName);
            cityBuilder.setIcaoNameNL(builder.cityIcaoNameNL);
            cityBuilder.setIcaoShortNameNL(builder.cityIcaoShortNameNL);

            cityBuilder.setUnLoCode(builder.cityUnLoCode);
            cityBuilder.setUnLoName(builder.cityUnLoName);
            cityBuilder.setUnLoShortName(builder.cityUnLoShortName);
            cityBuilder.setUnLoNameNL(builder.cityUnLoNameNL);
            cityBuilder.setUnLoShortNameNL(builder.cityUnLoShortNameNL);

            cityBuilder.setOtherCode(builder.cityOtherCode);
            cityBuilder.setOtherName(builder.cityOtherName);
            cityBuilder.setOtherShortName(builder.cityOtherShortName);
            cityBuilder.setOtherNameNL(builder.cityOtherNameNL);
            cityBuilder.setOtherShortNameNL(builder.cityOtherShortNameNL);

            cityBuilder.setCountrySitaCode(builder.countrySitaCode);
            cityBuilder.setCountryIso3Code(builder.countryIso3Code);
            cityBuilder.setCountryName(builder.countryName);
            cityBuilder.setCountryNameNL(builder.countryNameNL);
            cityBuilder.setCountryShortName(builder.countryShortName);
            cityBuilder.setCountryShortNameNL(builder.countryShortNameNL);

            cityBuilder.setCountrySubdivisionCode(builder.countrySubdivisionCode);
            cityBuilder.setCountrySubdivisionName(builder.countrySubdivisionName);
            cityBuilder.setCountrySubdivisionNameNL(builder.countrySubdivisionNameNL);
            
            cityBuilder.setIataValidFrom(builder.cityIataValidFrom);
            cityBuilder.setIataValidTo(builder.cityIataValidTo);
            cityBuilder.setIcaoValidFrom(builder.cityIcaoValidFrom);
            cityBuilder.setIcaoValidTo(builder.cityIcaoValidTo);
            cityBuilder.setUnLoValidFrom(builder.cityUnLoValidFrom);
            cityBuilder.setUnLoValidTo(builder.cityUnLoValidTo);
            cityBuilder.setOtherValidFrom(builder.cityOtherValidFrom);
            cityBuilder.setOtherValidTo(builder.cityOtherValidTo);
            
            city = cityBuilder.build();
        }
    }

    /**
     * Builds everything to create a country subdivision.
     * @param builder Location Builder - information from the view.
     */
    private void buildCountrySubvision(final LocationBuilder builder) {
        // Build the country subdivision information.
        if (builder.isCountrySubDivisionBuilder()) {
            CountrySubvisionBuilder countrySubdivisionBuilder = new CountrySubvisionBuilder();
            countrySubdivisionBuilder.setCode(builder.countrySubdivisionCode);
            countrySubdivisionBuilder.setName(builder.countrySubdivisionName);
            countrySubdivisionBuilder.setNameNL(builder.countrySubdivisionNameNL);
            countrySubdivision = countrySubdivisionBuilder.build();
        }
    }

    /**
     * Builds everything to create a country.
     * @param builder Location Builder - information from the view.
     */
    private void buildCountry(final LocationBuilder builder) {
        // Build the country information.
        Country.CountryBuilder countryBuilder = new Country.CountryBuilder();
        countryBuilder.setSitaCode(builder.countrySitaCode);
        countryBuilder.setIsoCode3(builder.countryIso3Code);
        countryBuilder.setName(builder.countryName);
        countryBuilder.setNameNL(builder.countryNameNL);
        countryBuilder.setShortName(builder.countryShortName);
        countryBuilder.setShortNameNL(builder.countryShortNameNL);
        country = countryBuilder.build();
    }

    @Override
    public IGeoPoint getGeoPoint() {
        return geoPoint;
    }

    @Override
    public Integer getTimeZoneId() {
        return timeZoneId;
    }

    @Override
    public String getTimeZoneCode() {
        return timeZoneCode;
    }

    @Override
    public String getIataSitaCode() {
        return iataSitaCode;
    }

    @Override
    public String getIcaoSitaCode() {
        return icaoSitaCode;
    }

    @Override
    public String getUnLoSitaCode() {
        return unLoSitaCode;
    }

    @Override
    public String getIataCode() {
        return iataCode;
    }

    @Override
    public String getIcaoCode() {
        return icaoCode;
    }

    @Override
    public String getUnLoCode() {
        return unLoCode;
    }

    @Override
    public String getOtherCode() {
        return otherCode;
    }

    @Override
    public LocationType getPrimaryLocationType() {
        return type;
    }

    @Override
    @Deprecated
    public LocationType getType() {
        return type;
    }

    @Override
    public List<LocationUsageType> getUsageTypeList() {
        return usageTypeList;
    }


    @Override
    public ILocation getCity() {
        return city;
    }

    @Override
    public ICountry getCountry() {
        return country;
    }

    @Override
    public ICountrySubdivision getCountrySubdivision() {
        return countrySubdivision;
    }

    @Override
    public boolean isIataCodeAvailable() {
        return StringUtils.isNotEmpty(iataCode);
    }

    @Override
    public boolean isIcaoCodeAvailable() {
        return StringUtils.isNotEmpty(icaoCode);
    }

    @Override
    public boolean isUnLoCodeAvailable() {
        return StringUtils.isNotEmpty(unLoCode);
    }

    @Override
    public boolean isOtherCodeAvailable() {
        return StringUtils.isNotEmpty(otherCode);
    }

    @Override
    @Deprecated
    public boolean isType(final LocationType type) {
        return type == getType();
    }

    @Override
    @Deprecated
    public boolean isAirport() {
        return isType(LocationType.AIRPORT);
    }

    @Override
    @Deprecated
    public boolean isSeaport() {
        return isType(LocationType.SEAPORT);
    }

    @Override
    @Deprecated
    public boolean isBusStation() {
        return isType(LocationType.BUS_STATION);
    }

    @Override
    @Deprecated
    public boolean isRailStation() {
        return isType(LocationType.RAIL_STATION);
    }

    @Override
    @Deprecated
    public boolean isCommercial() {
        return isType(LocationType.COMMERCIAL);
    }

    @Override
    @Deprecated
    public boolean isCity() {
        return isType(LocationType.CITY);
    }

    @Override
    @Deprecated
    public boolean isBorderPoint() {
        return isType(LocationType.BORDER_POINT);
    }

    @Override
    public boolean isUsageType(final LocationUsageType usageType) {
        return usageTypeList.contains(usageType);
    }

    @Override
    public boolean isAirUsage() {
        return isUsageType(LocationUsageType.AIR);
    }

    @Override
    public boolean isRoadUsage() {
        return isUsageType(LocationUsageType.ROAD);
    }

    @Override
    public boolean isSeaUsage() {
        return isUsageType(LocationUsageType.SEA);
    }

    @Override
    public boolean isRailUsage() {
        return isUsageType(LocationUsageType.RAIL);
    }

    @Override
    public boolean isHotelUsage() {
        return isUsageType(LocationUsageType.HOTEL);
    }

    @Override
    public boolean isCarHireUsage() {
        return isUsageType(LocationUsageType.CAR_HIRE);
    }

    @Override
    public boolean isShopUsage() {
        return isUsageType(LocationUsageType.SHOP);
    }

    @Override
    @Deprecated
    public boolean isMiscUsage() {
        return isUsageType(LocationUsageType.MISC);
    }

    @Override
    public boolean isBorderUsage() {
        return isUsageType(LocationUsageType.BORDER);
    }

    @Override
    public String getIataName() {
        return iataName;
    }

    @Override
    public String getIataNameNL() {
        return iataNameNL;
    }

    @Override
    public String getIataShortName() {
        return iataShortName;
    }

    @Override
    public String getIataShortNameNL() {
        return iataShortNameNL;
    }

    @Override
    public String getIcaoName() {
        return icaoName;
    }

    @Override
    public String getIcaoNameNL() {
        return icaoNameNL;
    }

    @Override
    public String getIcaoShortName() {
        return icaoShortName;
    }

    @Override
    public String getIcaoShortNameNL() {
        return icaoShortNameNL;
    }

    @Override
    public String getUnLoName() {
        return unLoName;
    }

    @Override
    public String getUnLoNameNL() {
        return unLoNameNL;
    }

    @Override
    public String getUnLoShortName() {
        return unLoShortName;
    }

    @Override
    public String getUnLoShortNameNL() {
        return unLoShortNameNL;
    }

    @Override
    public String getOtherName() {
        return otherName;
    }

    @Override
    public String getOtherNameNL() {
        return otherNameNL;
    }

    @Override
    public String getOtherShortName() {
        return otherShortName;
    }

    @Override
    public String getOtherShortNameNL() {
        return otherShortNameNL;
    }

    @Override
    public LocalDate getIataValidFrom() {
        return iataValidFrom;
    }

    @Override
    public LocalDate getIataValidTo() {
        return iataValidTo;
    }

    @Override
    public LocalDate getIcaoValidFrom() {
        return icaoValidFrom;
    }

    @Override
    public LocalDate getIcaoValidTo() {
        return icaoValidTo;
    }

    @Override
    public LocalDate getUnLoValidFrom() {
        return unLoValidFrom;
    }

    @Override
    public LocalDate getUnLoValidTo() {
        return unLoValidTo;
    }

    @Override
    public LocalDate getOtherValidFrom() {
        return otherValidFrom;
    }

    @Override
    public LocalDate getOtherValidTo() {
        return otherValidTo;
    }

    @Override
    public String getPreferredName() {
        if (StringUtils.isNotEmpty(getOtherName())) {
            return getOtherName();
        } else if (StringUtils.isNotEmpty(getIataName())) {
            return getIataName();
        } else if (StringUtils.isNotEmpty(getIcaoName())) {
            return getIcaoName();
        }
        return getUnLoName();
    }

    /***
     * For now this is just returning getPreferredName().
     * To be decided what it should return.  If IATA requested it
     * could return IATA code but what if SITA code for eg is requested.
     * @return getPreferredName()
     * @see aero.sita.gsl.refdata.api.model.AbstractReferenceData#getName()
     */
    @Override
    public String getName() {
        return getPreferredName();
    }

    @Override
    public String getPreferredNameNL() {
        if (StringUtils.isNotEmpty(getOtherNameNL())) {
            return getOtherNameNL();
        } else if (StringUtils.isNotEmpty(getIataNameNL())) {
            return getIataNameNL();
        } else if (StringUtils.isNotEmpty(getIcaoNameNL())) {
            return getIcaoNameNL();
        }
        return getUnLoNameNL();
    }

    /***
     * For now this is just returning getPreferredNameNL().
     * To be decided what it should return.  If IATA requested it
     * could return IATA code but what if SITA code for eg is requested.
     * @return getPreferredNameNL()
     */
    @Override
    public String getNameNL() {
        return getPreferredNameNL();
    }

    @Override
    public String getPreferredShortName() {
        if (StringUtils.isNotEmpty(getOtherShortName())) {
            return getOtherShortName();
        } else if (StringUtils.isNotEmpty(getIataShortName())) {
            return getIataShortName();
        } else if (StringUtils.isNotEmpty(getIcaoShortName())) {
            return getIcaoShortName();
        }
        return getUnLoShortName();
    }

    /***
     * For now this is just returning getPreferredShortName().
     * To be decided what it should return.  If IATA requested it
     * could return IATA code but what if SITA code for eg is requested.
     * @return getPreferredShortName()
     */
    @Override
    public String getShortName() {
        return getPreferredShortName();
    }

    @Override
    public String getPreferredShortNameNL() {
        if (StringUtils.isNotEmpty(getOtherShortNameNL())) {
            return getOtherShortNameNL();
        } else if (StringUtils.isNotEmpty(getIataShortNameNL())) {
            return getIataShortNameNL();
        } else if (StringUtils.isNotEmpty(getIcaoShortNameNL())) {
            return getIcaoShortNameNL();
        }
        return getUnLoShortNameNL();
    }

    /***
     * For now this is just returning getPreferredShortNameNL().
     * To be decided what it should return.  If IATA requested it
     * could return IATA code but what if SITA code for eg is requested.
     * @return getPreferredShortNameNL()
     */
    @Override
    public String getShortNameNL() {
        return getPreferredShortNameNL();
    }

    @Override
    public String getPreferredCode() {
        if (StringUtils.isNotBlank(getIataCode())) {
            return getIataCode();
        } else if (StringUtils.isNotBlank(getIcaoCode())) {
            return getIcaoCode();
        } else if (StringUtils.isNotBlank(getUnLoCode())) {
            return getUnLoCode();
        } else if (StringUtils.isNotBlank(getOtherCode())) {
            return getOtherCode();
        }
        return getSitaCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    /**
     * Builder class used by DAO classes to create a Location object.
     */
    public static final class LocationBuilder extends BaseLocationBuilder {

        /** The location type. */
        private String type;

        /** The sita IATA code for the location. */
        private String iataSitaCode;

        /** The sita ICAO code for the location. */
        private String icaoSitaCode;

        /** The sita UNLO code for the location. */
        private String unLoSitaCode;

        /** Iata Code for the location. */
        private String iataCode;

        /** IATA code valid from date. */
        private LocalDate iataValidFrom;

        /** IATA code valid to date. */
        private LocalDate iataValidTo;

        /** IATA name in default language, typically English. */
        private String iataName;

        /** IATA name in national locale. */
        private String iataNameNL;

        /** IATA short name in default language, typically English. */
        private String iataShortName;

        /** IATA short name in national locale. */
        private String iataShortNameNL;

        /** ICAO code. */
        private String icaoCode;

        /** ICAO code valid from date. */
        private LocalDate icaoValidFrom;

        /** ICAO code valid to date. */
        private LocalDate icaoValidTo;

        /** ICAO name in default language, typically English. */
        private String icaoName;

        /** ICAO name in national locale. */
        private String icaoNameNL;

        /** ICAO short name in default language, typically English. */
        private String icaoShortName;

        /** ICAO short name in national locale. */
        private String icaoShortNameNL;

        /** UN/LO Codes. */
        private String unLoCode;

        /** UN/LO code valid from date. */
        private LocalDate unLoValidFrom;

        /** UN/LO code valid to date. */
        private LocalDate unLoValidTo;

        /** UN/LO name in default language, typically English. */
        private String unLoName;

        /** UN/LO name in national locale. */
        private String unLoNameNL;

        /** UN/LO short name in default language, typically English. */
        private String unLoShortName;

        /** UN/LO short name in national locale. */
        private String unLoShortNameNL;

        /** Any other code. */
        private String otherCode;

        /** Other code valid from date. */
        private LocalDate otherValidFrom;

        /** Other code valid to date. */
        private LocalDate otherValidTo;


        /** Other name in default language, typically English. */
        private String otherName;

        /** Other name in national locale. */
        private String otherNameNL;

        /** Other short name in default language, typically English. */
        private String otherShortName;

        /** Other short name in national locale. */
        private String otherShortNameNL;

        /** Whether this is an Air-related location. */
        private boolean airFlag;

        /** Whether this is a Road-based location. */
        private boolean roadFlag;

        /** Whether this is a Sea-based location. */
        private boolean seaFlag;

        /** Whether this is a Rail-based location. */
        private boolean railFlag;

        /** Whether this is a border location. */
        private boolean borderFlag;

        /** Whether this is a hotel-based location. */
        private boolean hotelFlag;

        /** Whether this is a Car hire-based location. */
        private boolean carHireFlag;

        /** Whether this is a Shop-based location. */
        private boolean shopFlag;

        /** SITA city code being returned from view. */
        private String citySitaCode;
        /** IATA city code being returned from view. */
        private String cityIataCode;
        /** IATA City name default default language. */
        private String cityIataName;
        /** IATA City name short default language. */
        private String cityIataShortName;
        /** IATA National locale City name. */
        private String cityIataNameNL;
        /** IATA City name short national locale. */
        private String cityIataShortNameNL;
        /** IATA City valid from date. */
        private LocalDate cityIataValidFrom;
        /** IATA City valid to date. */
        private LocalDate cityIataValidTo;

        /** ICAO city code. */
        private String cityIcaoCode;
        /** ICAO city name in default language, typically English. */
        private String cityIcaoName;
         /** ICAO city name in national locale. */
        private String cityIcaoNameNL;
        /** ICAO city short name in default language, typically English. */
        private String cityIcaoShortName;
        /** ICAO city short name in national locale. */
        private String cityIcaoShortNameNL;
        /** ICAO City valid from date. */
        private LocalDate cityIcaoValidFrom;
        /** ICAO City valid to date. */
        private LocalDate cityIcaoValidTo;

        /** UN/LOCode city code. */
        private String cityUnLoCode;
        /** UN/LOCode city name in default language, typically English. */
        private String cityUnLoName;
         /** UN/LOCode city name in national locale. */
        private String cityUnLoNameNL;
        /** UN/LOCode city short name in default language, typically English. */
        private String cityUnLoShortName;
        /** UN/LOCode city short name in national locale. */
        private String cityUnLoShortNameNL;
        /** UN/LOCode City valid from date. */
        private LocalDate cityUnLoValidFrom;
        /** UN/LOCode City valid to date. */
        private LocalDate cityUnLoValidTo;

        /** Other city code. */
        private String cityOtherCode;
        /** Other city name in default language, typically English. */
        private String cityOtherName;
         /** Other city name in national locale. */
        private String cityOtherNameNL;
        /** Other city short name in default language, typically English. */
        private String cityOtherShortName;
        /** Other city short name in national locale. */
        private String cityOtherShortNameNL;
        /** Other City valid from date. */
        private LocalDate cityOtherValidFrom;
        /** Other City valid to date. */
        private LocalDate cityOtherValidTo;

        /** Country code. */
        private String countrySitaCode;
        /** Country code. */
        private String countryIso3Code;
        /** Country name. */
        private String countryName;
        /** Country name, national locale. */
        private String countryNameNL;
        /** Country short name. */
        private String countryShortName;
        /** Country short name, national locale. */
        private String countryShortNameNL;

        /** Country Sub division code. */
        private String countrySubdivisionCode;
        /** Country Sub division name. */
        private String countrySubdivisionName;
        /** Country Sub division name, national locale. */
        private String countrySubdivisionNameNL;
        /** Latitude. */
        private double latitude;
        /** Longitude. */
        private double longitude;

        /** The identifier associated to the time-zone this location resides in. */
        private Integer timeZoneId;

        /** The code associated to the time-zone this location resides in. */
        private String timeZoneCode;

        /**
         * If any of the city fields are set, we will build the city.
         * @return true if city.
         */
        boolean isCityBuilder() {
            return StringUtils.isNotEmpty(citySitaCode)
                    || StringUtils.isNotEmpty(cityIataCode)
                    || StringUtils.isNotEmpty(cityIataName)
                    || StringUtils.isNotEmpty(cityIataShortName)
                    || StringUtils.isNotEmpty(cityIataNameNL)
                    || StringUtils.isNotEmpty(cityIataShortNameNL)
                    || StringUtils.isNotEmpty(cityIcaoCode)
                    || StringUtils.isNotEmpty(cityIcaoName)
                    || StringUtils.isNotEmpty(cityIcaoShortName)
                    || StringUtils.isNotEmpty(cityIcaoNameNL)
                    || StringUtils.isNotEmpty(cityIcaoShortNameNL)
                    || StringUtils.isNotEmpty(cityUnLoCode)
                    || StringUtils.isNotEmpty(cityUnLoName)
                    || StringUtils.isNotEmpty(cityUnLoShortName)
                    || StringUtils.isNotEmpty(cityUnLoNameNL)
                    || StringUtils.isNotEmpty(cityUnLoShortNameNL)
                    || StringUtils.isNotEmpty(cityOtherCode)
                    || StringUtils.isNotEmpty(cityOtherName)
                    || StringUtils.isNotEmpty(cityOtherShortName)
                    || StringUtils.isNotEmpty(cityOtherNameNL)
                    || StringUtils.isNotEmpty(cityOtherShortNameNL);

        }

        /**
         * If any of the country subdivision fields are set, we will build the country subdivision.
         * @return true if country subdivision.
         */
        boolean isCountrySubDivisionBuilder() {
            return StringUtils.isNotEmpty(countrySubdivisionCode)
                    || StringUtils.isNotEmpty(countrySubdivisionName)
                    || StringUtils.isNotEmpty(countrySubdivisionNameNL);

        }

        public void setTimeZoneId(final Integer timeZoneId) {
            this.timeZoneId = timeZoneId;
        }

        public void setTimeZoneCode(final String timeZoneCode) {
            this.timeZoneCode = timeZoneCode;
        }

        public void setLatitude(final double latitude) {
            this.latitude = latitude;
        }

        public void setLongitude(final double longitude) {
            this.longitude = longitude;
        }

        public void setType(final String type) {
            this.type = type;
        }

        public void setIataSitaCode(final String iataSitaCode) {
            this.iataSitaCode = iataSitaCode;
        }

        public void setIcaoSitaCode(final String icaoSitaCode) {
            this.icaoSitaCode = icaoSitaCode;
        }

        public void setUnLoSitaCode(final String unLoSitaCode) {
            this.unLoSitaCode = unLoSitaCode;
        }

        public void setIataCode(final String iataCode) {
            this.iataCode = iataCode;
        }

        public void setIataName(final String iataName) {
            this.iataName = iataName;
        }

        public void setIataNameNL(final String iataNameNL) {
            this.iataNameNL = iataNameNL;
        }

        public void setIataShortName(final String iataShortName) {
            this.iataShortName = iataShortName;
        }

        public void setIataShortNameNL(final String iataShortNameNL) {
            this.iataShortNameNL = iataShortNameNL;
        }

        public void setIcaoCode(final String icaoCode) {
            this.icaoCode = icaoCode;
        }

        public void setIcaoName(final String icaoName) {
            this.icaoName = icaoName;
        }

        public void setIcaoNameNL(final String icaoNameNL) {
            this.icaoNameNL = icaoNameNL;
        }

        public void setIcaoShortName(final String icaoShortName) {
            this.icaoShortName = icaoShortName;
        }

        public void setIcaoShortNameNL(final String icaoShortNameNL) {
            this.icaoShortNameNL = icaoShortNameNL;
        }

        public void setUnLoCode(final String unLoCode) {
            this.unLoCode = unLoCode;
        }

        public void setUnLoName(final String unLoName) {
            this.unLoName = unLoName;
        }

        public void setUnLoNameNL(final String unLoNameNL) {
            this.unLoNameNL = unLoNameNL;
        }

        public void setUnLoShortName(final String unLoShortName) {
            this.unLoShortName = unLoShortName;
        }

        public void setUnLoShortNameNL(final String unLoShortNameNL) {
            this.unLoShortNameNL = unLoShortNameNL;
        }

        public void setOtherCode(final String otherCode) {
            this.otherCode = otherCode;
        }

        public void setOtherName(final String otherName) {
            this.otherName = otherName;
        }

        public void setOtherNameNL(final String otherNameNL) {
            this.otherNameNL = otherNameNL;
        }

        public void setOtherShortName(final String otherShortName) {
            this.otherShortName = otherShortName;
        }

        public void setOtherShortNameNL(final String otherShortNameNL) {
            this.otherShortNameNL = otherShortNameNL;
        }

        public void setAirFlag(final String airFlag) {
            this.airFlag = BooleanUtils.toBoolean(airFlag);
        }

        public void setSeaFlag(final String seaFlag) {
            this.seaFlag = BooleanUtils.toBoolean(seaFlag);
        }

        public void setRoadFlag(final String roadFlag) {
            this.roadFlag = BooleanUtils.toBoolean(roadFlag);
        }

        public void setHotelFlag(final String hotelFlag) {
            this.hotelFlag = BooleanUtils.toBoolean(hotelFlag);
        }

        public void setRailFlag(final String railFlag) {
            this.railFlag = BooleanUtils.toBoolean(railFlag);
        }

        public void setCarHireFlag(final String carHireFlag) {
            this.carHireFlag = BooleanUtils.toBoolean(carHireFlag);
        }

        public void setShopFlag(final String shopFlag) {
            this.shopFlag = BooleanUtils.toBoolean(shopFlag);
        }

        public void setBorderFlag(final String borderFlag) {
            this.borderFlag = BooleanUtils.toBoolean(borderFlag);
        }

        public void setCitySitaCode(final String citySitaCode) {
            this.citySitaCode = citySitaCode;
        }

        public void setCityIataCode(final String cityIataCode) {
            this.cityIataCode = cityIataCode;
        }

        public void setCityIataName(final String cityName) {
            this.cityIataName = cityName;
        }

        public void setCityIataShortName(final String cityShortName) {
            this.cityIataShortName = cityShortName;
        }

        public void setCityIataNameNL(final String cityNameNL) {
            this.cityIataNameNL = cityNameNL;
        }

        public void setCityIataShortNameNL(final String cityShortNameNL) {
            this.cityIataShortNameNL = cityShortNameNL;
        }

        public void setCityIcaoCode(final String cityIcaoCode) {
            this.cityIcaoCode = cityIcaoCode;
        }

        public void setCityIcaoName(final String cityIcaoName) {
            this.cityIcaoName = cityIcaoName;
        }

        public void setCityIcaoNameNL(final String cityIcaoNameNL) {
            this.cityIcaoNameNL = cityIcaoNameNL;
        }

        public void setCityIcaoShortName(final String cityIcaoShortName) {
            this.cityIcaoShortName = cityIcaoShortName;
        }

        public void setCityIcaoShortNameNL(final String cityIcaoShortNameNL) {
            this.cityIcaoShortNameNL = cityIcaoShortNameNL;
        }

        public void setCityUnLoCode(final String cityUnLoCode) {
            this.cityUnLoCode = cityUnLoCode;
        }

        public void setCityUnLoName(final String cityUnLoName) {
            this.cityUnLoName = cityUnLoName;
        }

        public void setCityUnLoNameNL(final String cityUnLoNameNL) {
            this.cityUnLoNameNL = cityUnLoNameNL;
        }

        public void setCityUnLoShortName(final String cityUnLoShortName) {
            this.cityUnLoShortName = cityUnLoShortName;
        }

        public void setCityUnLoShortNameNL(final String cityUnLoShortNameNL) {
            this.cityUnLoShortNameNL = cityUnLoShortNameNL;
        }

        public void setCityOtherCode(final String cityOtherCode) {
            this.cityOtherCode = cityOtherCode;
        }

        public void setCityOtherName(final String cityOtherName) {
            this.cityOtherName = cityOtherName;
        }

        public void setCityOtherNameNL(final String cityOtherNameNL) {
            this.cityOtherNameNL = cityOtherNameNL;
        }

        public void setCityOtherShortName(final String cityOtherShortName) {
            this.cityOtherShortName = cityOtherShortName;
        }

        public void setCityOtherShortNameNL(final String cityOtherShortNameNL) {
            this.cityOtherShortNameNL = cityOtherShortNameNL;
        }

        public void setCityIataValidFrom(final LocalDate cityIataValidFrom) {
            this.cityIataValidFrom = cityIataValidFrom;
        }

        public void setCityIataValidTo(final LocalDate cityIataValidTo) {
            this.cityIataValidTo = cityIataValidTo;
        }

        public void setCityIcaoValidFrom(final LocalDate cityIcaoValidFrom) {
            this.cityIcaoValidFrom = cityIcaoValidFrom;
        }

        public void setCityIcaoValidTo(final LocalDate cityIcaoValidTo) {
            this.cityIcaoValidTo = cityIcaoValidTo;
        }

        public void setCityUnLoValidFrom(final LocalDate cityUnLoValidFrom) {
            this.cityUnLoValidFrom = cityUnLoValidFrom;
        }

        public void setCityUnLoValidTo(final LocalDate cityUnLoValidTo) {
            this.cityUnLoValidTo = cityUnLoValidTo;
        }

        public void setCityOtherValidFrom(final LocalDate cityOtherValidFrom) {
            this.cityOtherValidFrom = cityOtherValidFrom;
        }

        public void setCityOtherValidTo(final LocalDate cityOtherValidTo) {
            this.cityOtherValidTo = cityOtherValidTo;
        }

        public void setCountryName(final String countryName) {
            this.countryName = countryName;
        }

        public void setCountryNameNL(final String countryNameNL) {
            this.countryNameNL = countryNameNL;
        }

        public void setCountrySitaCode(final String countrySitaCode) {
            this.countrySitaCode = countrySitaCode;
        }

        public void setCountryIso3Code(final String countryIso3Code) {
            this.countryIso3Code = countryIso3Code;
        }

        public void setCountryShortName(final String countryShortName) {
            this.countryShortName = countryShortName;
        }

        public void setCountryShortNameNL(final String countryShortNameNL) {
            this.countryShortNameNL = countryShortNameNL;
        }

        public void setCountrySubdivisionCode(final String countrySubdivisionCode) {
            this.countrySubdivisionCode = countrySubdivisionCode;
        }

        public void setCountrySubdivisionName(final String countrySubdivisionName) {
            this.countrySubdivisionName = countrySubdivisionName;
        }

        public void setCountrySubdivisionNameNL(final String countrySubdivisionNameNL) {
            this.countrySubdivisionNameNL = countrySubdivisionNameNL;
        }

        public void setIataValidFrom(final LocalDate iataValidFrom) {
            this.iataValidFrom = iataValidFrom;
        }

        public void setIataValidTo(final LocalDate iataValidTo) {
            this.iataValidTo = iataValidTo;
        }

        public void setIcaoValidFrom(final LocalDate icaoValidFrom) {
            this.icaoValidFrom = icaoValidFrom;
        }

        public void setIcaoValidTo(final LocalDate icaoValidTo) {
            this.icaoValidTo = icaoValidTo;
        }

        public void setUnLoValidFrom(final LocalDate unLoValidFrom) {
            this.unLoValidFrom = unLoValidFrom;
        }

        public void setUnLoValidTo(final LocalDate unLoValidTo) {
            this.unLoValidTo = unLoValidTo;
        }

        public void setOtherValidFrom(final LocalDate otherValidFrom) {
            this.otherValidFrom = otherValidFrom;
        }

        public void setOtherValidTo(final LocalDate otherValidTo) {
            this.otherValidTo = otherValidTo;
        }

        /**
         * Build a <code>Location</code> object from this builder.
         * @return Pre-populated <code>Location</code>
         */
        public Location build() {
            return new Location(this);
        }
    }


}
