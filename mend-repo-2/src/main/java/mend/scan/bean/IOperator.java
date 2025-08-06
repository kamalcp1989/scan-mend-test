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

import java.time.LocalDate;


/**
 * Interface for the main operator bean.
 */
public interface IOperator extends IReferenceData {

    /**
     * Gets the iata code for the operator.
     * @return iata code for the operator.
     */
    String getIataCode();

    /**
     * Gets the IATA name in default language, typically English.
     * @return IATA name in default language, typically English.
     */
    String getIataName();

    /**
     * Gets the ICAO code for the operator.
     * @return ICAO code for the operator.
     */
    String getIcaoCode();

    /**
     * Gets the ICAO name in default language, typically English.
     * @return ICAO name in default language, typically English.
     */
    String getIcaoName();

    /**
     * Gets the Other code for the operator.
     * @return the Other code for the operator.
     */
    String getOtherCode();

    /**
     * Gets the Other code name in default language, typically English.
     * @return Other code name in default language, typically English.
     */
    String getOtherName();

    /**
     * Gets the preferred code name in default language, typically English.
     * @return preferred code  name in default language, typically English.
     */
    String getPreferredName();

    /**
     * Does this operator contain the given type?
     * @param type OperatorType to search for.
     * @return true if this operator contains this OperatorType
     */
    boolean isType(OperatorType type);

    /**
     * Gets the Operator Type for this operator for example AIR, BUS, SEA etc.
     * @return Operator Type for operator for example AIR, BUS, SEA etc.
     */
    OperatorType getType();

    /***
     * Is this an Air operator?
     * @return true if OperatorType is Air type
     */
    boolean isAir();

    /***
     * Is this an General Aviation operator?
     * @return true if OperatorType is General Aviation type
     */
    boolean isGeneralAviation();

    /***
     * Is this an Seat operator?
     * @return true if OperatorType is Sea type
     */
    boolean isSea();

    /**
     * Gets the Operator Type Description in default language, typically English.
     * @return Operator Type Description in default language, typically English.
     */
    String getTypeDescription();

    /**
     * Gets the Operator Type Description in national locale.
     * @return Operator Type Description in national locale.
     */
    String getTypeDescriptionNL();

    /**
     * Gets the country information for the operator.
     * @return Country information for the operator.
     */
    ICountry getCountry();

    /**
     * Does this operator have an IATA Code?
     * @return true if operator has code.
     */
    boolean isIataCode();

    /**
     * Does this operator have a ICAO code?
     * @return true if operator has code.
     */
    boolean isIcaoCode();

    /**
     * Does this operator have a.n. other type of code?
     * @return true if operator has code.
     */
    boolean isOtherCode();

    /**
     * Is there any associated flight, traveller information etc.
     * @return boolean true or false based associated flight, traveller information.
     */
    boolean isDataReceived();

    /**
     * Gets a key to uniquely identify this operator.
     * @return a key to uniquely identify this operator.
     */
    IOperatorKey getIdentifier();

    /**
     * Gets the preferred code  in default language, typically English.
     * @return preferred code   in default language, typically English.
     */
    String getPreferredCode();

    /**
     * gets the iata code valid from Date.
     *
     * @return iata valid from date.
     */
    LocalDate getIataValidFrom();

    /**
     * gets the iata code valid to Date.
     *
     * @return iata valid to date.
     */
    LocalDate getIataValidTo();

    /**
     * gets the icao code valid from Date.
     *
     * @return icao valid from date.
     */
    LocalDate getIcaoValidFrom();

    /**
     * gets the icao code valid to Date.
     *
     * @return icao valid to date.
     */
    LocalDate getIcaoValidTo();

    /**
     * gets the other code valid from Date.
     *
     * @return other valid from date.
     */
    LocalDate getOtherValidFrom();

    /**
     * gets the other code valid to Date.
     *
     * @return other valid to date.
     */
    LocalDate getOtherValidTo();

    /**
     * Gets the operator other id.
     *
     * @return the other id
     */
    String getOtherId();
}
