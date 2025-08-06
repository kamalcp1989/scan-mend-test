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
 * Used when selecting a single location by the  getCountryOf...service methods.
 * Standard implementation by {@link aero.sita.gsl.refdata.api.model.CountryKey}
 *
 * @see aero.sita.gsl.refdata.api.service.ICountryService#getCountryOfOrigin
 * @see aero.sita.gsl.refdata.api.service.ICountryService#getCountryOfBirth
 * @see aero.sita.gsl.refdata.api.service.ICountryService#getCountryOfIssue
 * @see aero.sita.gsl.refdata.api.model.CountryKey
 */
public interface ICountryKey extends IPoliticalStateKey {
    // Key interface
}
