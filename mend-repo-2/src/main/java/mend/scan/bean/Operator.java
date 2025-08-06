/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2009-2016
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.bean;

import java.util.*;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import java.time.LocalDate;

/**
 *
 * Main operator bean.
 */
public final class Operator extends AbstractReferenceData implements IOperator {

    /** Iata Code for the operator. */
    private final String iataCode;

    /** IATA name in default language, typically English. */
    private final String iataName;

    /** ICAO code. */
    private final String icaoCode;

    /** ICAO name in default language, typically English. */
    private final String icaoName;

      /** Any other code. */
    private final String otherCode;

    /** Other name in default language, typically English. */
    private final String otherName;

    /** OperatorType. */
    private final OperatorType type;

    /** Operator type Description, typically English. */
    private String typeDescription;

    /** Operator type Description in national locale. */
    private String typeDescriptionNL;

    /** Country . */
    private ICountry country;

    /** Is there any associated flight, traveller information etc. */
    private boolean dataReceived;

    /** iata valid from date . */
    private LocalDate iataValidFrom;

    /** iata valid to date . */
    private LocalDate iataValidTo;

    /** icao valid from date . */
    private LocalDate icaoValidFrom;

    /** icao valid to date . */
    private LocalDate icaoValidTo;

    /** other valid from date . */
    private LocalDate otherValidFrom;

    /** other valid to date . */
    private LocalDate otherValidTo;

    /** The other id. */
    private String otherId;

    /**
     * Generates a <code>Operator</code> object from the supplied
     * builder.
     * @param builder <code>Builder</code> object from which to create a new <code>Operator</code>
     */
    private Operator(final OperatorBuilder builder) {
        super(builder);

        if (builder.type != null) {
            this.type = OperatorType.valueOf(builder.type);
        } else {
            this.type = null;
        }

        this.iataCode = builder.iataCode;
        this.iataName = builder.iataName;

        this.icaoCode = builder.icaoCode;
        this.icaoName = builder.icaoName;

        this.otherCode = builder.otherCode;
        this.otherName = builder.otherName;
        this.otherId = builder.otherId;

        this.typeDescription = builder.typeDescription;
        this.typeDescriptionNL = builder.typeDescriptionNL;

        this.dataReceived = builder.dataReceived;

        // Optionally sets the Country.
        buildCountry(builder);

        this.iataValidFrom = builder.iataValidFrom;
        this.iataValidTo = builder.iataValidTo;
        this.icaoValidFrom = builder.icaoValidFrom;
        this.icaoValidTo = builder.icaoValidTo;
        this.otherValidFrom = builder.otherValidFrom;
        this.otherValidTo = builder.otherValidTo;

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
    public String getOtherCode() {
        return otherCode;
    }


    @Override
    public OperatorType getType() {
        return type;
    }

    @Override
    public boolean isIataCode() {
        return StringUtils.isNotEmpty(iataCode);
    }

    @Override
    public boolean isIcaoCode() {
        return StringUtils.isNotEmpty(icaoCode);
    }

    @Override
    public boolean isOtherCode() {
        return StringUtils.isNotEmpty(otherCode);
    }

    @Override
    public boolean isType(final OperatorType type) {
        return type == getType();
    }

    @Override
    public String getIataName() {
        return iataName;
    }

    @Override
    public String getIcaoName() {
        return icaoName;
    }

    @Override
    public String getOtherName() {
        return otherName;
    }

    @Override
    public String getTypeDescription() {
        return typeDescription;
    }

    @Override
    public String getTypeDescriptionNL() {
        return typeDescriptionNL;
    }

    @Override
    public ICountry getCountry() {
        return country;
    }

    @Override
    public boolean isDataReceived() {
        return dataReceived;
    }
    @Override
    public String getPreferredName() {
        if (StringUtils.isNotEmpty(getOtherName())) {
            return getOtherName();
        } else if (StringUtils.isNotEmpty(getIataName())) {
            return getIataName();
        }
        return getIcaoName();
    }

    @Override
    public String getPreferredCode() {
        if (StringUtils.isNotEmpty(getOtherCode())) {
            return getOtherCode();
        } else if (StringUtils.isNotEmpty(getIataCode())) {
            return getIataCode();
        }
        return getIcaoCode();
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

    /**
     * {@inheritDoc}
     */
    public String getCode() {
        return getPreferredCode();
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
    public LocalDate getOtherValidFrom() {
        return otherValidFrom;
    }

    @Override
    public LocalDate getOtherValidTo() {
        return otherValidTo;
    }

    @Override
    public String getOtherId() {
        return otherId;
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
     * Builder class used by DAO classes to create a Operator object.
     */
    public static final class OperatorBuilder extends AbstractReferenceBuilder {

        /** The operator type. */
        private String type;

        /** Iata Code for the operator. */
        private String iataCode;

        /** IATA name in default language, typically English. */
        private String iataName;

        /** ICAO code. */
        private String icaoCode;

        /** ICAO name in default language, typically English. */
        private String icaoName;

        /** Any other code. */
        private String otherCode;

        /** Other name in default language, typically English. */
        private String otherName;

        /** Operator type Description, typically English. */
        private String typeDescription;

        /** Operator type Description in national locale. */
        private String typeDescriptionNL;

        /** SITA Country code. */
        private String countryCode;
        /** ISO 1 country code. */
        private String isoCode1;
        /** ISO 2 country code. */
        private String isoCode2;
        /** ISO 3 country code. */
        private String isoCode3;

        /** Country name. */
        private String countryName;

        /** Is there any associated flight, traveller information etc. */
        private boolean dataReceived;

        /** iata valid from date . */
        private LocalDate iataValidFrom;

        /** iata valid to date . */
        private LocalDate iataValidTo;

        /** icao valid from date . */
        private LocalDate icaoValidFrom;

        /** icao valid to date . */
        private LocalDate icaoValidTo;

        /** other valid from date . */
        private LocalDate otherValidFrom;

        /** other valid to date . */
        private LocalDate otherValidTo;

        /** The other id. */
        private String otherId;

        /**
         * Default constructor.
         */
        public OperatorBuilder() {
        }

        /**
         * Create a builder from an existing operator.
         * @param operator the operator to create the builder from.
         */
        public OperatorBuilder(final IOperator operator) {
            if (operator != null) {
                if (operator.getType() != null) {
                    this.type = operator.getType().name();
                }
                setSitaCode(operator.getSitaCode());
                this.iataCode = operator.getIataCode();
                this.iataName = operator.getIataName();

                this.icaoCode = operator.getIcaoCode();
                this.icaoName = operator.getIcaoName();

                this.otherCode = operator.getOtherCode();
                this.otherName = operator.getOtherName();
                this.otherId = operator.getOtherId();

                this.typeDescription = operator.getTypeDescription();
                this.typeDescriptionNL = operator.getTypeDescriptionNL();

                this.dataReceived = operator.isDataReceived();

                if (operator.getCountry() != null) {
                    this.countryCode = operator.getCountry().getSitaCode();
                    this.isoCode1 = operator.getCountry().getIsoCode1();
                    this.isoCode2 = operator.getCountry().getIsoCode2();
                    this.isoCode3 = operator.getCountry().getIsoCode3();
                }

                this.iataValidFrom = operator.getIataValidFrom();
                this.iataValidTo = operator.getIataValidTo();
                this.icaoValidFrom = operator.getIcaoValidFrom();
                this.icaoValidTo = operator.getIcaoValidTo();
                this.otherValidFrom = operator.getOtherValidFrom();
                this.otherValidTo = operator.getOtherValidTo();
            }
        }

        public void setType(final String type) {
            this.type = type;
        }

        /**
         * Allows setting of type using the proper enum.
         * @param type the required type
         */
        public void setType(final OperatorType type) {
            if (type != null) {
                this.type = type.name();
            }
        }

        public void setIataCode(final String iataCode) {
            this.iataCode = iataCode;
        }

        public void setIataName(final String iataName) {
            this.iataName = iataName;
        }

        public void setIcaoCode(final String icaoCode) {
            this.icaoCode = icaoCode;
        }

        public void setIcaoName(final String icaoName) {
            this.icaoName = icaoName;
        }

        public void setOtherCode(final String otherCode) {
            this.otherCode = otherCode;
        }

        public void setOtherName(final String otherName) {
            this.otherName = otherName;
        }
        public void setCountryCode(final String countryCode) {
            this.countryCode = countryCode;
        }
        public void setIsoCode1(final String isoCode1) {
            this.isoCode1 = isoCode1;
        }
        public void setIsoCode2(final String isoCode2) {
            this.isoCode2 = isoCode2;
        }
        public void setIsoCode3(final String isoCode3) {
            this.isoCode3 = isoCode3;
        }

        public void setCountryName(final String countryName) {
            this.countryName = countryName;
        }

        public void setTypeDescription(final String typeDescription) {
            this.typeDescription = typeDescription;
        }

        public void setTypeDescriptionNL(final String typeDescriptionNL) {
            this.typeDescriptionNL = typeDescriptionNL;
        }

        public void setDataReceived(final String dataReceived) {
            this.dataReceived = BooleanUtils.toBoolean(dataReceived);
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

        public void setOtherValidFrom(final LocalDate otherValidFrom) {
            this.otherValidFrom = otherValidFrom;
        }

        public void setOtherValidTo(final LocalDate otherValidTo) {
            this.otherValidTo = otherValidTo;
        }

        public void setOtherId(final String otherId) {
            this.otherId = otherId;
        }

        /**
        * Build a <code>Operator</code> object from this builder.
        * @return Pre-populated <code>Operator</code>
        */
        public Operator build() {
            return new Operator(this);
        }

    }

    /**
     * Builds everything to create a country.
     * @param builder Location Builder - information from the view.
     */
    private void buildCountry(final OperatorBuilder builder) {
        // Build the country information.
        Country.CountryBuilder countryBuilder = new Country.CountryBuilder();
        countryBuilder.setSitaCode(builder.countryCode);
        countryBuilder.setIsoCode1(builder.isoCode1);
        countryBuilder.setIsoCode2(builder.isoCode2);
        countryBuilder.setIsoCode3(builder.isoCode3);
        countryBuilder.setName(builder.countryName);
        this.country = countryBuilder.build();
    }

    @Override
    public boolean isAir() {
        return isType(OperatorType.AIR);
    }

    @Override
    public boolean isGeneralAviation() {
        return isType(OperatorType.GAV);
    }

    @Override
    public boolean isSea() {
        return isType(OperatorType.SEA);
    }

    @Override
    public IOperatorKey getIdentifier() {
        if (getSitaCode() != null) {
            return new OperatorKey(getSitaCode(), OperatorCodeType.SITA, getType());
        }
        if (getOtherCode() != null) {
            return new OperatorKey(getOtherCode(), OperatorCodeType.OTHER, getType());
        }
        if (getIataCode() != null) {
            return new OperatorKey(getIataCode(), OperatorCodeType.IATA, getType());
        }
        if (getIcaoCode() != null) {
            return new OperatorKey(getIcaoCode(), OperatorCodeType.ICAO, getType());
        }

        return null;
    }

}
