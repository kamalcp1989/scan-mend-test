/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2014
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.bean;


/**
 * Interface for the {@code AbstractPoliticalState} class.
 */
public interface IPoliticalState extends IBaseLocation {

    /**
     * Get the state's 1 character code.
     * @return the state code
     */
    String getIsoCode1();
    
    /**
     * Get the state's 2 character code.
     * @return the state code
     */
    String getIsoCode2();
    
    /**
     * Get the state's 3 character code.
     * @return the state  code
     */
    String getIsoCode3();
    
    /**
     * Finds the first code defined in the following order:
     * IsoCode3, IsoCode2, IsoCode1.
     * @return preferred code.
     */
    String getPreferredCode();
}
