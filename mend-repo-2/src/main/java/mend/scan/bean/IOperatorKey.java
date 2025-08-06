/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2013
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.bean;

/**
 * The attributes that make up a unique Operator.
 * 
 */
public interface IOperatorKey {

    /**
     * Gets the operator code against its type.
     * 
     * @return operator code.
     */
    String getCode();

    /**
     * Gets the code of operator for example IATA, ICAO, SITA etc .
     * 
     * @return code type.
     */
    OperatorCodeType getCodeType();
    

    /**
     * Gets the type of operator for example AIR, BUS, SEA etc.
     * 
     * @return operator type.
     */
    OperatorType getType();

    
}
