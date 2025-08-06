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
 * Enum of possible operator types.
 * 
 * @author reddy yattapu
 */
public enum OperatorType {
    /** Air operator type - typically carriers. */
    AIR,
    /** General Aviation operator type - airport owners. */
    GAV,
    /** Sea operator type - including ships/cruise vessels. */
    SEA,
    /** Bus operator type - including coaches. */
    BUS,
    /** Railway operator type. */
    RLY,
    /** Hotel operator type. */
    HTL,
    /** Commercial operator type - for example, car hire or other miscellaneous operators. */
    COM,

    /** Unknown operator type. */
    UNK;

    /**
     * This method check whether valid operator Type passed in or not.
     * @param operatorTypeVar operator type
     * @return boolean is Valid or not
     */
    public static boolean isValidType(final OperatorType operatorTypeVar) {
        for (OperatorType operatorType : OperatorType.values()) {
            if (operatorType == operatorTypeVar) {
                return true;
            }
        }
        return false;
    }
}

