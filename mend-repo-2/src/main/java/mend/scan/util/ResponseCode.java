/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2001-2024
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.util;

import java.util.*;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/**
 * An enumeration to deal with the different types of responses.
 */
public final class ResponseCode {

    /** The warning helper to use. */
    private static WarningHelper cWarningHelper = WarningHelper.getInstance();

    //-----------------------------------------------------------------------
    /** A 0000 Error Response. */
    public static final ResponseCode RESPONSE_0000_ERROR = createInternal("0000", "RESPONSE_0000_ERROR", 0);

    /** A response code for apis storage. */
    public static final ResponseCode RESPONSE_8499_APIS_STORED = createInternal("8499", "RESPONSE_8499_APIS_STORED", PassengerStatus.STORED, 0);

    /** A queued response. */
    public static final ResponseCode RESPONSE_8500_QUEUED = createInternal("8500", "RESPONSE_8500_QUEUED", PassengerStatus.QUEUED, 0);

    /** A 8501 OK to board. */
    public static final ResponseCode RESPONSE_8501_OK_TO_BOARD = createInternal("8501", "RESPONSE_8501_OK_TO_BOARD", PassengerStatus.OK_TO_BOARD, 0);
    /** Do not board, may be overridden. */
    public static final ResponseCode RESPONSE_8502_DO_NOT_BOARD_CAN_OVERRIDE = createInternal("8502", "RESPONSE_8502_DO_NOT_BOARD_CAN_OVERRIDE", PassengerStatus.DO_NOT_BOARD, 0);

    /** An unknown response. */
    public static final ResponseCode RESPONSE_8503_BOARD_IF_DOCS_OK = createInternal("8503", "RESPONSE_8503_BOARD_IF_DOCS_OK", PassengerStatus.OK_TO_BOARD, 0);

    /** A 8505 Cancelled response. */
    public static final ResponseCode RESPONSE_8505_CANCELLED = createInternal("8505", "RESPONSE_8505_CANCELLED", PassengerStatus.CANCELLED, 0);
    /** A 8506 No record response. */
    public static final ResponseCode RESPONSE_8506_NO_RECORD = createInternal("8506", "RESPONSE_8506_NO_RECORD", PassengerStatus.NOT_FOUND, 0);
    /** A 8507 Duplicate name response. */
    public static final ResponseCode RESPONSE_8507_DUPLICATE_NAME = createInternal("8507", "RESPONSE_8507_DUPLICATE_NAME", 0);
    /** A 8508 contact agency response. */
    public static final ResponseCode RESPONSE_8508_CONTACT_AGENCY = createInternal("8508", "RESPONSE_8508_CONTACT_AGENCY", 0);

    /* -=========================== NZ Responses =======================- */
    /** A 8509 NZ border closed response. */
    public static final ResponseCode RESPONSE_8509_BORDER_CLOSED = createInternal("8509", "RESPONSE_8509_BORDER_CLOSED", PassengerStatus.DO_NOT_BOARD, 0);

    /* -=========================== AU Responses =======================- */
    /** A 8510 contact aus boc response. */
    public static final ResponseCode RESPONSE_8510_CONTACT_AUS_BOC = createInternal("8510", "RESPONSE_8510_CONTACT_AUS_BOC", 0);

    /** Do not board, no override. */
    public static final ResponseCode RESPONSE_8515_DO_NOT_BOARD_NO_OVERRIDE = createInternal("8515", "RESPONSE_8515_DO_NOT_BOARD_NO_OVERRIDE", PassengerStatus.DO_NOT_BOARD, 0);

    /* -========================== AU/NZ Responses =====================- */
    /** A 8516 insufficient data response. */
    public static final ResponseCode RESPONSE_8516_INSUFFICIENT_DATA = createInternal("8516", "RESPONSE_8516_INSUFFICIENT_DATA", 0);
    /** A 8517 override accepted response. */
    public static final ResponseCode RESPONSE_8517_OVERRIDE_ACCEPTED = createInternal("8517", "RESPONSE_8517_OVERRIDE_ACCEPTED", PassengerStatus.OK_TO_BOARD, 0);

    /* -=========================== NZ Responses =======================- */
    /** A 8519 brd with owt response. */
    public static final ResponseCode RESPONSE_8519_BRD_WITH_OWT = createInternal("8519", "RESPONSE_8519_BRD_WITH_OWT", PassengerStatus.OK_TO_BOARD, 0);
    /** A 8520 Contact NZIS Agency response. */
    public static final ResponseCode RESPONSE_8520_CONTACT_NZIS_AGENCY = createInternal("8520", "RESPONSE_8520_CONTACT_NZIS_AGENCY", 0);
    /** A 8525 ETA not found response. */
    public static final ResponseCode RESPONSE_8525_NZ_ETA_NOT_FOUND = createInternal("8525", "RESPONSE_8525_NZ_ETA_NOT_FOUND", PassengerStatus.DO_NOT_BOARD, 0);

    /* -=========================== BH Responses =======================- */
    /** A 8530 Do not board, contact GDNPR code. */
    public static final ResponseCode RESPONSE_8530_CONTACT_GDNPR = createInternal("8530", "RESPONSE_8530_CONTACT_GDNPR", 0);

    /* -========================= US CBP Responses =====================- */
    /** A 8540 do not board message. */
    public static final ResponseCode RESPONSE_8540_DO_NOT_BOARD = createInternal("8540", "RESPONSE_8540_DO_NOT_BOARD", PassengerStatus.DO_NOT_BOARD, 0);
    /** A 8541 Selectee response. */
    public static final ResponseCode RESPONSE_8541_SELECTEE = createInternal("8541", "RESPONSE_8541_SELECTEE", PassengerStatus.ADVISORY_SELECTEE, 0);
    /** Do not board, travel document not on file. */
    public static final ResponseCode RESPONSE_8542_DO_NOT_BOARD_TRAVEL_DOCUMENT_NOT_ON_FILE = createInternal("8542", "RESPONSE_8542_DO_NOT_BOARD_TRAVEL_DOCUMENT_NOT_ON_FILE", PassengerStatus.DO_NOT_BOARD, 0);

    /* -========================= KW Responses =========================- */
    /** A 8550 Do Not Board response. */
    public static final ResponseCode RESPONSE_8550_CONTACT_MOI = createInternal("8550", "RESPONSE_8550_CONTACT_MOI", PassengerStatus.DO_NOT_BOARD, 0);

    /* -=============== General Health Responses =================- */
    /** Do not board, check VISA. */
    public static final ResponseCode RESPONSE_8551_DO_NOT_BOARD_CHECK_VISA = createInternal("8551", "RESPONSE_8551_DO_NOT_BOARD_CHECK_VISA", PassengerStatus.DO_NOT_BOARD, 0);
    /** Do not board, check Waiver or VISA. */
    public static final ResponseCode RESPONSE_8552_DO_NOT_BOARD_CHECK_WAIVER_OR_VISA = createInternal("8552", "RESPONSE_8552_DO_NOT_BOARD_CHECK_WAIVER_OR_VISA", PassengerStatus.DO_NOT_BOARD, 0);
    /** OK To Board, check health requirements. */
    public static final ResponseCode RESPONSE_8553_OK_TO_BOARD_IF_HEALTH_DOCS_OK = createInternal("8553", "RESPONSE_8553_OK_TO_BOARD_IF_HEALTH_DOCS_OK", PassengerStatus.OK_TO_BOARD, 0);
    /** Do not board, eta or visa still in progress. */
    public static final ResponseCode RESPONSE_8554_DO_NOT_BOARD_ETA_OR_VISA_STILL_IN_PROGRESS = createInternal("8554", "RESPONSE_8554_DO_NOT_BOARD_ETA_OR_VISA_STILL_IN_PROGRESS", PassengerStatus.DO_NOT_BOARD, 0);
    /** Do not board, check ETA or VISA. */
    public static final ResponseCode RESPONSE_8555_DO_NOT_BOARD_CHECK_ETA_OR_VISA = createInternal("8555", "RESPONSE_8555_DO_NOT_BOARD_CHECK_ETA_OR_VISA", PassengerStatus.DO_NOT_BOARD, 0);


    /* -========================= US ESTA Responses ====================- */
    /** Do not board, insufficient ESTA data. */
    public static final ResponseCode RESPONSE_8560_DO_NOT_BOARD_INSUFFICIENT_ESTA_DATA = createInternal("8560", "RESPONSE_8560_DO_NOT_BOARD_INSUFFICIENT_ESTA_DATA", PassengerStatus.DO_NOT_BOARD, 11);
    /** An ok to board, esta not applicable. */
    public static final ResponseCode RESPONSE_8561_OK_TO_BOARD_ESTA_NOT_APPLICABLE = createInternal("8561", "RESPONSE_8561_OK_TO_BOARD_ESTA_NOT_APPLICABLE", PassengerStatus.OK_TO_BOARD, 0);
    /** OK to board, ESTA approved. */
    public static final ResponseCode RESPONSE_8562_OK_TO_BOARD_ESTA_APPROVED = createInternal("8562", "RESPONSE_8562_OK_TO_BOARD_ESTA_APPROVED", PassengerStatus.OK_TO_BOARD, 1);
    /** OK to board, ESTA data must be presented to check in staff. */
    public static final ResponseCode RESPONSE_8563_OK_TO_BOARD_NO_ESTA_FILED = createInternal("8563", "RESPONSE_8563_OK_TO_BOARD_NO_ESTA_FILED", PassengerStatus.OK_TO_BOARD, 3);
    /** OK to board, additional ESTA documentation is required by check in staff. */
    public static final ResponseCode RESPONSE_8564_OK_TO_BOARD_ADDITIONAL_ESTA_REQUIRED = createInternal("8564", "RESPONSE_8564_OK_TO_BOARD_ADDITIONAL_ESTA_REQUIRED", PassengerStatus.OK_TO_BOARD, 4);
    /** Both watch list and ESTA say do not board. */
    public static final ResponseCode RESPONSE_8565_DO_NOT_BOARD_WATCHLIST_AND_ESTA_INHIBITED = createInternal("8565", "RESPONSE_8565_DO_NOT_BOARD_WATCHLIST_AND_ESTA_INHIBITED", PassengerStatus.DO_NOT_BOARD, 10);
    /** ESTA has insufficient data, watch list is selectee. */
    public static final ResponseCode RESPONSE_8566_DO_NOT_BOARD_INSUFFICIENT_ESTA_WATCHLIST_SELECTEE = createInternal("8566", "RESPONSE_8566_DO_NOT_BOARD_INSUFFICIENT_ESTA_WATCHLIST_SELECTEE", PassengerStatus.DO_NOT_BOARD, 9);
    /** ESTA not applicable, watch list selectee. */
    public static final ResponseCode RESPONSE_8567_SELECTEE_ESTA_NOT_APPLICABLE = createInternal("8567", "RESPONSE_8567_SELECTEE_ESTA_NOT_APPLICABLE", PassengerStatus.ADVISORY_SELECTEE, 5);
    /** ESTA approved, watch list selectee. */
    public static final ResponseCode RESPONSE_8568_SELECTEE_ESTA_APPROVED = createInternal("8568", "RESPONSE_8568_SELECTEE_ESTA_APPROVED", PassengerStatus.ADVISORY_SELECTEE, 6);
    /** No ESTA filed, watch list selectee. */
    public static final ResponseCode RESPONSE_8569_SELECTEE_NO_ESTA_FILED = createInternal("8569", "RESPONSE_8569_SELECTEE_NO_ESTA_FILED", PassengerStatus.ADVISORY_SELECTEE, 7);
    /** ESTA requires US travel documentation, watch list selectee. */
    public static final ResponseCode RESPONSE_8570_SELECTEE_US_DOCS_REQUIRED = createInternal("8570", "RESPONSE_8570_SELECTEE_US_DOCS_REQUIRED", PassengerStatus.ADVISORY_SELECTEE, 8);
    /** Known passenger number accepted, ESTA not applicable. */
    public static final ResponseCode RESPONSE_8571_KNOWN_PAX_NUMBER_ACCEPTED_ESTA_NOT_APPLICABLE = createInternal("8571", "RESPONSE_8571_KNOWN_PAX_NUMBER_ACCEPTED_ESTA_NOT_APPLICABLE", PassengerStatus.OK_TO_BOARD, 0);
    /** Known passenger number accepted, ESTA approved. */
    public static final ResponseCode RESPONSE_8572_KNOWN_PAX_NUMBER_ACCEPTED_ESTA_APPROVED = createInternal("8572", "RESPONSE_8572_KNOWN_PAX_NUMBER_ACCEPTED_ESTA_APPROVED", PassengerStatus.OK_TO_BOARD, 0);
    /** Known passenger number accepted, No ESTA data filed.. */
    public static final ResponseCode RESPONSE_8573_KNOWN_PAX_NUMBER_ACCEPTED_NO_ESTA_DATA_FILED = createInternal("8573", "RESPONSE_8573_KNOWN_PAX_NUMBER_ACCEPTED_NO_ESTA_DATA_FILED", PassengerStatus.OK_TO_BOARD, 0);
    /** Known passenger number accepted, ETAS requires additional US Travel Document. */
    public static final ResponseCode RESPONSE_8574_KNOWN_PAX_NUMBER_ACCEPTED_REQUIRES_ADD_US_TVL_DOC = createInternal("8574", "RESPONSE_8574_KNOWN_PAX_NUMBER_ACCEPTED_REQUIRES_ADD_US_TVL_DOC", PassengerStatus.OK_TO_BOARD, 0);
    /** Known passenger number accepted, Insufficient ESTA data. */
    public static final ResponseCode RESPONSE_8575_KNOWN_PAX_NUMBER_ACCEPTED_INSUFFICIENT_ESTA_DATA = createInternal("8575", "RESPONSE_8575_KNOWN_PAX_NUMBER_ACCEPTED_INSUFFICIENT_ESTA_DATA", PassengerStatus.DO_NOT_BOARD, 0);
    /** Gate Pass can be issued. */
    public static final ResponseCode RESPONSE_8580_GATE_PASS_CAN_BE_ISSUED = createInternal("8580", "RESPONSE_8580_GATE_PASS_CAN_BE_ISSUED", PassengerStatus.OK_TO_BOARD, 0);
    /** Gate Pass cannot be issued. */
    public static final ResponseCode RESPONSE_8581_GATE_PASS_CANNOT_BE_ISSUED = createInternal("8581", "RESPONSE_8581_GATE_PASS_CANNOT_BE_ISSUED", PassengerStatus.DO_NOT_BOARD, 0);
    /** Gate Pass can be issued with extra security checks. */
    public static final ResponseCode RESPONSE_8582_GATE_PASS_CONDITIONAL_ISSUE = createInternal("8582", "RESPONSE_8582_GATE_PASS_CONDITIONAL_ISSUE", PassengerStatus.ADVISORY_SELECTEE, 0);
    /** Watch list inhibited and ESTA approved. */
    public static final ResponseCode RESPONSE_8583_DO_NOT_BOARD_WATCHLIST_INHIBITED_ESTA_APPROVED = createInternal("8583", "RESPONSE_8583_DO_NOT_BOARD_WATCHLIST_INHIBITED_ESTA_APPROVED", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list inhibited and no ESTA filed. */
    public static final ResponseCode RESPONSE_8584_DO_NOT_BOARD_WATCHLIST_INHIBITED_NO_ESTA_FILED = createInternal("8584", "RESPONSE_8584_DO_NOT_BOARD_WATCHLIST_INHIBITED_NO_ESTA_FILED", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list inhibited and US travel doc is required. */
    public static final ResponseCode RESPONSE_8585_DO_NOT_BOARD_WATCHLIST_INHIBITED_US_TRAVEL_DOC_REQUIRED = createInternal("8585", "RESPONSE_8585_DO_NOT_BOARD_WATCHLIST_INHIBITED_US_TRAVEL_DOC_REQUIRED", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list inhibited and insufficient ESTA. */
    public static final ResponseCode RESPONSE_8586_DO_NOT_BOARD_WATCHLIST_INHIBITED_INSUFFICIENT_ESTA_DATA = createInternal("8586", "RESPONSE_8586_DO_NOT_BOARD_WATCHLIST_INHIBITED_INSUFFICIENT_ESTA_DATA", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list inhibited and ESTA not applicable. */
    public static final ResponseCode RESPONSE_8587_DO_NOT_BOARD_WATCHLIST_INHIBITED_ESTA_NOT_APPLICABLE = createInternal("8587", "RESPONSE_8587_DO_NOT_BOARD_WATCHLIST_INHIBITED_ESTA_NOT_APPLICABLE", PassengerStatus.DO_NOT_BOARD, 10);

    /** Watch list cleared and doc validation visa on file. */
    public static final ResponseCode RESPONSE_8700_OK_TO_BOARD_WATCHLIST_CLEARED_DOC_VALIDATION_VISA_ON_FILE = createInternal("8700", "RESPONSE_8700_OK_TO_BOARD_WATCHLIST_CLEARED_DOC_VALIDATION_VISA_ON_FILE", PassengerStatus.OK_TO_BOARD, 0);
    /** Watch list cleared and doc validation no visa on file. */
    public static final ResponseCode RESPONSE_8701_DO_NOT_BOARD_WATCHLIST_CLEARED_DOC_VALIDATION_NO_VISA_ON_FILE = createInternal("8701", "RESPONSE_8701_DO_NOT_BOARD_WATCHLIST_CLEARED_DOC_VALIDATION_NO_VISA_ON_FILE", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list cleared and doc validation us doc on file. */
    public static final ResponseCode RESPONSE_8702_OK_TO_BOARD_WATCHLIST_CLEARED_DOC_VALIDATION_US_DOC_ON_FILE = createInternal("8702", "RESPONSE_8702_OK_TO_BOARD_WATCHLIST_CLEARED_DOC_VALIDATION_US_DOC_ON_FILE", PassengerStatus.OK_TO_BOARD, 0);
    /** Watch list cleared and doc validation no us doc on file. */
    public static final ResponseCode RESPONSE_8703_DO_NOT_BOARD_WATCHLIST_CLEARED_DOC_VALIDATION_NO_US_DOC_ON_FILE = createInternal("8703", "RESPONSE_8703_DO_NOT_BOARD_WATCHLIST_CLEARED_DOC_VALIDATION_NO_US_DOC_ON_FILE", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list cleared and doc validation doc validation recommends no board. */
    public static final ResponseCode RESPONSE_8704_DO_NOT_BOARD_WATCHLIST_CLEARED_DOC_VALIDATION_RECOMMEND_NO_BOARD = createInternal("8704", "RESPONSE_8704_DO_NOT_BOARD_WATCHLIST_CLEARED_DOC_VALIDATION_RECOMMEND_NO_BOARD", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list cleared and doc validation timeout. */
    public static final ResponseCode RESPONSE_8705_DO_NOT_BOARD_WATCHLIST_CLEARED_DOC_VALIDATION_TIMEOUT = createInternal("8705", "RESPONSE_8705_DO_NOT_BOARD_WATCHLIST_CLEARED_DOC_VALIDATION_TIMEOUT", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list cleared and doc validation pending review. */
    public static final ResponseCode RESPONSE_8706_DO_NOT_BOARD_WATCHLIST_CLEARED_DOC_VALIDATION_PENDING_REVIEW = createInternal("8706", "RESPONSE_8706_DO_NOT_BOARD_WATCHLIST_CLEARED_DOC_VALIDATION_PENDING_REVIEW", PassengerStatus.DO_NOT_BOARD, 10);

    /** Watch list inhibited and doc validation visa on file. */
    public static final ResponseCode RESPONSE_8707_DO_NOT_BOARD_WATCHLIST_INHIBITED_DOC_VALIDATION_VISA_ON_FILE = createInternal("8707", "RESPONSE_8707_DO_NOT_BOARD_WATCHLIST_INHIBITED_DOC_VALIDATION_VISA_ON_FILE", PassengerStatus.DO_NOT_BOARD, 0);
    /** Watch list inhibited and doc validation no visa on file. */
    public static final ResponseCode RESPONSE_8708_DO_NOT_BOARD_WATCHLIST_INHIBITED_DOC_VALIDATION_NO_VISA_ON_FILE = createInternal("8708", "RESPONSE_8708_DO_NOT_BOARD_WATCHLIST_INHIBITED_DOC_VALIDATION_NO_VISA_ON_FILE", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list inhibited and doc validation us doc on file. */
    public static final ResponseCode RESPONSE_8709_DO_NOT_BOARD_WATCHLIST_INHIBITED_DOC_VALIDATION_US_DOC_ON_FILE = createInternal("8709", "RESPONSE_8709_DO_NOT_BOARD_WATCHLIST_INHIBITED_DOC_VALIDATION_US_DOC_ON_FILE", PassengerStatus.DO_NOT_BOARD, 0);
    /** Watch list inhibited and doc validation no us doc on file. */
    public static final ResponseCode RESPONSE_8710_DO_NOT_BOARD_WATCHLIST_INHIBITED_DOC_VALIDATION__NO_US_DOC_ON_FILE = createInternal("8710", "RESPONSE_8710_DO_NOT_BOARD_WATCHLIST_INHIBITED_DOC_VALIDATION__NO_US_DOC_ON_FILE", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list inhibited and doc validation doc validation recommends no board. */
    public static final ResponseCode RESPONSE_8711_DO_NOT_BOARD_WATCHLIST_INHIBITED_DOC_VALIDATION_RECOMMEND_NO_BOARD = createInternal("8711", "RESPONSE_8711_DO_NOT_BOARD_WATCHLIST_INHIBITED_DOC_VALIDATION_RECOMMEND_NO_BOARD", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list inhibited and doc validation timeout. */
    public static final ResponseCode RESPONSE_8712_DO_NOT_BOARD_WATCHLIST_INHIBITED_DOC_VALIDATION_TIMEOUT = createInternal("8712", "RESPONSE_8712_DO_NOT_BOARD_WATCHLIST_INHIBITED_DOC_VALIDATION_TIMEOUT", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list inhibited and doc validation pending review. */
    public static final ResponseCode RESPONSE_8713_DO_NOT_BOARD_WATCHLIST_INHIBITED_DOC_VALIDATION_PENDING_REVIEW = createInternal("8713", "RESPONSE_8713_DO_NOT_BOARD_WATCHLIST_INHIBITED_DOC_VALIDATION_PENDING_REVIEW", PassengerStatus.DO_NOT_BOARD, 10);

    /** Watch list selectee and doc validation visa on file. */
    public static final ResponseCode RESPONSE_8714_OK_TO_BOARD_WATCHLIST_SELECTEE_DOC_VALIDATION_VISA_ON_FILE = createInternal("8714", "RESPONSE_8714_OK_TO_BOARD_WATCHLIST_SELECTEE_DOC_VALIDATION_VISA_ON_FILE", PassengerStatus.OK_TO_BOARD, 5);
    /** Watch list selectee and doc validation no visa on file. */
    public static final ResponseCode RESPONSE_8715_DO_NOT_BOARD_WATCHLIST_SELECTEE_DOC_VALIDATION_NO_VISA_ON_FILE = createInternal("8715", "RESPONSE_8715_DO_NOT_BOARD_WATCHLIST_SELECTEE_DOC_VALIDATION_NO_VISA_ON_FILE", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list selectee and doc validation us doc on file. */
    public static final ResponseCode RESPONSE_8716_OK_TO_BOARD_WATCHLIST_SELECTEE_DOC_VALIDATION_US_DOC_ON_FILE = createInternal("8716", "RESPONSE_8716_OK_TO_BOARD_WATCHLIST_SELECTEE_DOC_VALIDATION_US_DOC_ON_FILE", PassengerStatus.OK_TO_BOARD, 7);
    /** Watch list selectee and doc validation no us doc on file. */
    public static final ResponseCode RESPONSE_8717_DO_NOT_BOARD_WATCHLIST_SELECTEE_DOC_VALIDATION_NO_US_DOC_ON_FILE = createInternal("8717", "RESPONSE_8717_DO_NOT_BOARD_WATCHLIST_SELECTEE_DOC_VALIDATION_NO_US_DOC_ON_FILE", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list selectee and doc validation doc validation recommends no board. */
    public static final ResponseCode RESPONSE_8718_DO_NOT_BOARD_WATCHLIST_SELECTEE_DOC_VALIDATION_RECOMMEND_NO_BOARD = createInternal("8718", "RESPONSE_8718_DO_NOT_BOARD_WATCHLIST_SELECTEE_DOC_VALIDATION_RECOMMEND_NO_BOARD", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list selectee and doc validation timeout. */
    public static final ResponseCode RESPONSE_8719_DO_NOT_BOARD_WATCHLIST_SELECTEE_DOC_VALIDATION_TIMEOUT = createInternal("8719", "RESPONSE_8719_DO_NOT_BOARD_WATCHLIST_SELECTEE_DOC_VALIDATION_TIMEOUT", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list selectee and doc validation pending review. */
    public static final ResponseCode RESPONSE_8720_DO_NOT_BOARD_WATCHLIST_SELECTEE_DOC_VALIDATION_PENDING_REVIEW = createInternal("8720", "RESPONSE_8720_DO_NOT_BOARD_WATCHLIST_SELECTEE_DOC_VALIDATION_PENDING_REVIEW", PassengerStatus.DO_NOT_BOARD, 10);

    /** Watch list known pax number accepted and doc validation visa on file. */
    public static final ResponseCode RESPONSE_8721_OK_TO_BOARD_WATCHLIST_KNOWN_PAX_NUMBER_ACCEPTED_DOC_VALIDATION_VISA_ON_FILE = createInternal("8721", "RESPONSE_8721_OK_TO_BOARD_WATCHLIST_KNOWN_PAX_NUMBER_ACCEPTED_DOC_VALIDATION_VISA_ON_FILE", PassengerStatus.OK_TO_BOARD, 0);
    /** Watch list known pax number accepted and doc validation no visa on file. */
    public static final ResponseCode RESPONSE_8722_DO_NOT_BOARD_WATCHLIST_KNOWN_PAX_NUMBER_ACCEPTED_VALIDATION_NO_VISA_ON_FILE = createInternal("8722", "RESPONSE_8722_DO_NOT_BOARD_WATCHLIST_KNOWN_PAX_NUMBER_ACCEPTED_VALIDATION_NO_VISA_ON_FILE", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list known pax number accepted and doc validation us doc on file. */
    public static final ResponseCode RESPONSE_8723_OK_TO_BOARD_WATCHLIST_KNOWN_PAX_NUMBER_ACCEPTED_DOC_VALIDATION_US_DOC_ON_FILE = createInternal("8723", "RESPONSE_8723_OK_TO_BOARD_WATCHLIST_KNOWN_PAX_NUMBER_ACCEPTED_DOC_VALIDATION_US_DOC_ON_FILE", PassengerStatus.OK_TO_BOARD, 0);
    /** Watch list known pax number accepted and doc validation no us doc on file. */
    public static final ResponseCode RESPONSE_8724_DO_NOT_BOARD_WATCHLIST_KNOWN_PAX_NUMBER_ACCEPTED_DOC_VALIDATION__NO_US_DOC_ON_FILE = createInternal("8724", "RESPONSE_8724_DO_NOT_BOARD_WATCHLIST_KNOWN_PAX_NUMBER_ACCEPTED_DOC_VALIDATION__NO_US_DOC_ON_FILE", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list known pax number accepted and doc validation doc validation recommends no board. */
    public static final ResponseCode RESPONSE_8725_DO_NOT_BOARD_WATCHLIST_KNOWN_PAX_NUMBER_ACCEPTED_DOC_VALIDATION_RECOMMEND_NO_BOARD = createInternal("8725", "RESPONSE_8725_DO_NOT_BOARD_WATCHLIST_KNOWN_PAX_NUMBER_ACCEPTED_DOC_VALIDATION_RECOMMEND_NO_BOARD", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list known pax number accepted and doc validation timeout. */
    public static final ResponseCode RESPONSE_8726_DO_NOT_BOARD_WATCHLIST_KNOWN_PAX_NUMBER_ACCEPTED_DOC_VALIDATION_TIMEOUT = createInternal("8726", "RESPONSE_8726_DO_NOT_BOARD_WATCHLIST_KNOWN_PAX_NUMBER_ACCEPTED_DOC_VALIDATION_TIMEOUT", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list known pax number accepted and doc validation pending review. */
    public static final ResponseCode RESPONSE_8727_DO_NOT_BOARD_WATCHLIST_KNOWN_PAX_NUMBER_ACCEPTED_DOC_VALIDATION_PENDING_REVIEW = createInternal("8727", "RESPONSE_8727_DO_NOT_BOARD_WATCHLIST_KNOWN_PAX_NUMBER_ACCEPTED_DOC_VALIDATION_PENDING_REVIEW", PassengerStatus.DO_NOT_BOARD, 10);

    /** Watch list cleared no application for travel authorisation via EVUS on file. */
    public static final ResponseCode RESPONSE_8728_DO_NOT_BOARD_WATCHLIST_CLEARED_NO_APPLICATION_FOR_TRAVEL_AUTHORIZATION_VIA_EVUS_ON_FILE = createInternal("8728", "RESPONSE_8728_DO_NOT_BOARD_WATCHLIST_CLEARED_NO_APPLICATION_FOR_TRAVEL_AUTHORIZATION_VIA_EVUS_ON_FILE", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list inhibited no application for travel authorisation via EVUS on file. */
    public static final ResponseCode RESPONSE_8729_DO_NOT_BOARD_WATCHLIST_INHIBITED_NO_APPLICATION_FOR_TRAVEL_AUTHORIZATION_VIA_EVUS_ON_FILE = createInternal("8729", "RESPONSE_8729_DO_NOT_BOARD_WATCHLIST_INHIBITED_NO_APPLICATION_FOR_TRAVEL_AUTHORIZATION_VIA_EVUS_ON_FILE", PassengerStatus.DO_NOT_BOARD, 10);
    /** Watch list selectee no application for travel authorisation via EVUS on file. */
    public static final ResponseCode RESPONSE_8730_DO_NOT_BOARD_WATCHLIST_SELECTEE_NO_APPLICATION_FOR_TRAVEL_AUTHORIZATION_VIA_EVUS_ON_FILE = createInternal("8730", "RESPONSE_8730_DO_NOT_BOARD_WATCHLIST_SELECTEE_NO_APPLICATION_FOR_TRAVEL_AUTHORIZATION_VIA_EVUS_ON_FILE", PassengerStatus.DO_NOT_BOARD, 10);

    /** Gate Pass, OK to enter. */
    public static final ResponseCode RESPONSE_0001_OK_TO_ENTER = createInternal("0001", "RESPONSE_0001_OK_TO_ENTER", 0);
    /** Gate Pass, OK to enter. */
    public static final ResponseCode RESPONSE_0002_NOT_OK_TO_ENTER = createInternal("0002", "RESPONSE_0002_NOT_OK_TO_ENTER", 0);

    /* -========================= ZA Responses =========================- */
    /** Do not board, contact DHA. */
    public static final ResponseCode RESPONSE_8590_CONTACT_DHA = createInternal("8590", "RESPONSE_8590_CONTACT_DHA", PassengerStatus.DO_NOT_BOARD, 0);

    /* -========================= QA Responses ========================- */
    /** Do not board, contact gov. */
    public static final ResponseCode RESPONSE_8600_CONTACT_QATAR_GOVERNMENT = createInternal("8600", "RESPONSE_8600_CONTACT_QATAR_GOVERNMENT", PassengerStatus.DO_NOT_BOARD, 0);

    /* -========================= KR Responses =========================- */
    /** ok to board passenger not found. */
    public static final ResponseCode RESPONSE_8610_OK_TO_BOARD_PASSENGER_NOT_FOUND = createInternal("8610", "RESPONSE_8610_OK_TO_BOARD_PASSENGER_NOT_FOUND", PassengerStatus.OK_TO_BOARD, 0);
    /** ok to board due to timeout. */
    public static final ResponseCode RESPONSE_8611_OK_TO_BOARD_DUE_TO_TIMEOUT = createInternal("8611", "RESPONSE_8611_OK_TO_BOARD_DUE_TO_TIMEOUT", PassengerStatus.OK_TO_BOARD, 0);
    /** do not board. */
    public static final ResponseCode RESPONSE_8612_DO_NOT_BOARD = createInternal("8612", "RESPONSE_8612_DO_NOT_BOARD", PassengerStatus.DO_NOT_BOARD, 0);
    /** do not board insufficient data. */
    public static final ResponseCode RESPONSE_8613_DO_NOT_BOARD_INSUFFICIENT_DATA = createInternal("8613", "RESPONSE_8613_DO_NOT_BOARD_INSUFFICIENT_DATA", PassengerStatus.DO_NOT_BOARD, 0);

    /* -========================= TW Responses =========================- */
    /** OK To Board but check Taiwan documents. */
    public static final ResponseCode RESPONSE_8614_OK_TO_BOARD_CHECK_TW_DOCS = createInternal("8614", "RESPONSE_8614_OK_TO_BOARD_CHECK_TW_DOCS", PassengerStatus.OK_TO_BOARD, 0);

    /* -========================= Generic Gov Responses =========================- */
    /** do not board. */
    public static final ResponseCode RESPONSE_8615_DO_NOT_BOARD = createInternal("8615", "RESPONSE_8615_DO_NOT_BOARD", PassengerStatus.DO_NOT_BOARD, 0);


    /* -========================= SA Responses =========================- */
    /** ok to board passenger not found. */
    public static final ResponseCode RESPONSE_8620_CONTACT_SAUDI_GOVT = createInternal("8620", "RESPONSE_8620_CONTACT_SAUDI_GOVT", PassengerStatus.OK_TO_BOARD, 0);
    /** Do not board, visa not found. */
    public static final ResponseCode RESPONSE_8625_NO_VISA_FOUND = createInternal("8625", "RESPONSE_8625_NO_VISA_FOUND", PassengerStatus.DO_NOT_BOARD, 0);

    /* -========================= AE Responses =========================- */
    /** UAE specific response code, contact the UAE Govt. */
    public static final ResponseCode RESPONSE_8630_CONTACT_UAE_GOVT = createInternal("8630", "RESPONSE_8630_CONTACT_UAE_GOVT", PassengerStatus.DO_NOT_BOARD, 0);
    /** UAE specific response code, visa not found. */
    public static final ResponseCode RESPONSE_8635_VISA_NOT_FOUND = createInternal("8635", "RESPONSE_8635_VISA_NOT_FOUND", PassengerStatus.DO_NOT_BOARD, 0);

    /* -========================= OM Responses =========================- */
    /** OM specific response code, contact the OM Govt. */
    public static final ResponseCode RESPONSE_8640_CONTACT_OM_GOVT = createInternal("8640", "RESPONSE_8640_CONTACT_OM_GOVT", PassengerStatus.DO_NOT_BOARD, 0);

    /* -====================== Interpol Responses ======================- */
    /** The travel document has been validated by INTERPOL. */
    public static final ResponseCode RESPONSE_8650_INTERPOL_DOCS_OK = createInternal("8650", "RESPONSE_8650_INTERPOL_DOCS_OK", PassengerStatus.OK_TO_BOARD, 5);
    /** The travel document could not be validated and follow up is recommended. */
    public static final ResponseCode RESPONSE_8651_INTERPOL_STLD_HIT = createInternal("8651", "RESPONSE_8651_INTERPOL_STLD_HIT", PassengerStatus.DO_NOT_BOARD, 0);
    /** the document has been checked but the result cannot be displayed to user. */
    public static final ResponseCode RESPONSE_8652_INTERPOL_RESULT_WITHELD = createInternal("8652", "RESPONSE_8652_INTERPOL_RESULT_WITHELD", PassengerStatus.OK_TO_BOARD, 4);
    /** the document has been checked but the result cannot be displayed to user. */
    public static final ResponseCode RESPONSE_8653_INTERPOL_RESULT_WITHELD = createInternal("8653", "RESPONSE_8653_INTERPOL_RESULT_WITHELD", PassengerStatus.OK_TO_BOARD, 4);
    /** the document has been checked but the result cannot be displayed to user. */
    public static final ResponseCode RESPONSE_8654_INTERPOL_RESULT_WITHELD = createInternal("8654", "RESPONSE_8654_INTERPOL_RESULT_WITHELD", PassengerStatus.OK_TO_BOARD, 4);
    /** The document type is not supported by the SLTD database. The passenger can be allowed to board if their documents comply with the normal requirements for travel. */
    public static final ResponseCode RESPONSE_8655_INTERPOL_NOT_CHECKED = createInternal("8655", "RESPONSE_8655_INTERPOL_NOT_CHECKED", PassengerStatus.OK_TO_BOARD, 3);

    /* -========================= LK Responses =========================- */
    /** LK specific response code, contact the LK Govt. */
    public static final ResponseCode RESPONSE_8660_CONTACT_LK_GOVT = createInternal("8660", "RESPONSE_8660_CONTACT_LK_GOVT", PassengerStatus.DO_NOT_BOARD, 0);

    /* -========================= TH Responses =========================- */
    /** TH specific response code, contact the TH Govt. */
    public static final ResponseCode RESPONSE_8670_CONTACT_TH_GOVT = createInternal("8670", "RESPONSE_8670_CONTACT_TH_GOVT", PassengerStatus.DO_NOT_BOARD, 0);

    /* -========================= MM Responses =========================- */
    /** MM specific response code, contact the MM Govt. */
    public static final ResponseCode RESPONSE_8680_CONTACT_MM_GOVT = createInternal("8680", "RESPONSE_8680_CONTACT_MM_GOVT", PassengerStatus.DO_NOT_BOARD, 0);

    /* -========================= CBSA Responses =========================- */
    /** CA specific response code, contact the CA Govt. */
    public static final ResponseCode RESPONSE_8690_IRPA_DOC_NOT_APPLICABLE = createInternal("8690", "RESPONSE_8690_IRPA_DOC_NOT_APPLICABLE", PassengerStatus.OK_TO_BOARD, 0);

    /* -========================= LA Responses =========================- */
    /** LA specific response code, contact the LA Govt. */
    public static final ResponseCode RESPONSE_8750_CONTACT_LA_GOVT = createInternal("8750", "RESPONSE_8750_CONTACT_LA_GOVT", PassengerStatus.DO_NOT_BOARD, 0);

    /* -========================= SG Responses =========================- */
    /** SG specific response code, contact the SG Govt. */
    public static final ResponseCode RESPONSE_8760_CONTACT_SG_GOVT = createInternal("8760", "RESPONSE_8760_CONTACT_SG_GOVT", PassengerStatus.DO_NOT_BOARD, 0);

    /* -========================= MY Responses =========================- */
    /** SG specific response code, contact the MY Govt. */
    public static final ResponseCode RESPONSE_8770_CONTACT_MY_GOVT = createInternal("8770", "RESPONSE_8770_CONTACT_MY_GOVT", PassengerStatus.DO_NOT_BOARD, 0);

    /* -========================= Global Health Authority Responses =========================- */
    /** A 9501, ok to board, health status ok, response.  */
    public static final ResponseCode RESPONSE_9501_HEALTH_STATUS_OK_TO_BOARD = createInternal("9501", null, PassengerStatus.OK_TO_BOARD, 0);
    /** A 9502, do not board, health status denied, response.  */
    public static final ResponseCode RESPONSE_9502_HEALTH_STATUS_DENIED = createInternal("9502", "RESPONSE_9502_HEALTH_STATUS_DENIED", PassengerStatus.DO_NOT_BOARD, 0);
    /** A 9504, ok to board, check health docs, response.  */
    public static final ResponseCode RESPONSE_9503_HEALTH_STATUS_CHECK_DOCS = createInternal("9503", null, PassengerStatus.OK_TO_BOARD, 0);
    /** A 9510, do not board, contact gov, response.  */
    public static final ResponseCode RESPONSE_9510_HEALTH_STATUS_CONTACT_GOV = createInternal("9510", null, PassengerStatus.DO_NOT_BOARD, 0);

    //-----------------------------------------------------------------------
    /** The response code. */
    private String responseCode;
    /** The precedence of the code. */
    private int precendence;
    /** The associated passenger status. */
    private PassengerStatus passengerStatus;

    //-----------------------------------------------------------------------
    /** A map of response code lookup's. */
    private static Map<String, ResponseCode> cResponseCodeLookupMap;
    /** A set of unknown response codes. */
    private static Set<String> cUnknownResponseCodeSet;

    //-----------------------------------------------------------------------
    /**
     * Creates response code and adds to the to lookup map.
     *
     * Internal method that does not add any entries into the unknown
     * response code set.
     *
     * @param code  The response code.
     * @param legacyName  The legacy name of the enum value.
     * @param precedence  The precedence.
     * @return  The response code.
     */
    private static ResponseCode createInternal(final String code, final String legacyName, final int precedence) {
        return createInternal(code, legacyName, null, precedence);
    }

    /**
     * Creates response code and adds to the to lookup map.
     *
     * Internal method that does not add any entries into the unknown
     * response code set.
     *
     * @param code  The response code.
     * @param legacyName  The legacy name of the enum vale.
     * @param passengerStatus  The passenger status code.
     * @param precedence  The precedence.
     * @return  The response code.
     */
    private static ResponseCode createInternal(final String code, final String legacyName, final PassengerStatus passengerStatus, final int precedence) {

        if (StringUtils.isEmpty(code)) {
            return null;
        }

        synchronized (ResponseCode.class) {
            if (cResponseCodeLookupMap == null) {
                cResponseCodeLookupMap = new HashMap<>();
            }

            ResponseCode responseCode = cResponseCodeLookupMap.computeIfAbsent(
                code, key -> new ResponseCode(key, passengerStatus, precedence)
            );

            if (StringUtils.isNotEmpty(legacyName)) {
                cResponseCodeLookupMap.put(legacyName, responseCode);
            }

            return responseCode;
        }
    }

    /**
     * Clears the unknown response code set for testing purposes.
     */
    public static void resetUnknownResponseCodeSet() {
        synchronized (ResponseCode.class) {
            if (cUnknownResponseCodeSet == null) {
                return;
            }

            for (String code : cUnknownResponseCodeSet) {
                cResponseCodeLookupMap.remove(code);
            }

            cUnknownResponseCodeSet.clear();
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Constructor.
     *
     * @param code  The response code.
     * @param passengerStatus  The associated passenger status.
     * @param precendence  The precedence.
     */
    private ResponseCode(final String code, final PassengerStatus passengerStatus, final int precendence) {
        this.responseCode = code;
        this.precendence = precendence;
        this.passengerStatus = passengerStatus;
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the warning helper to use.
     *
     * @param warningHelper  The warning helper.
     */
    static void setWarningHelper(final WarningHelper warningHelper) {
        cWarningHelper = warningHelper;
    }

    //-----------------------------------------------------------------------
    /**
     * Gets a response code enumeration from a 4 digit response code.
     *
     * @param code  The 4 digit response code.
     * @return The found response code object, or null if not found.
     */
    public static ResponseCode getResponseCode(final String code) {
        return getResponseCode(code, null, true);
    }

    /**
     * Gets a response code enumeration from a 4 digit response code.
     *
     * @param code  The 4 digit response code.
     * @param createIfMissing  whether to create the response code if not found
     * @return The found response code object, or null if not found.
     */
    public static ResponseCode getResponseCode(final String code, final boolean createIfMissing) {
        return getResponseCode(code, null, createIfMissing);
    }

    /**
     * Gets a response code enumeration from a 4 digit response code.
     *
     * @param code  The 4 digit response code.
     * @param status  The passenger status.
     * @return The found response code object, or null if not found.
     */
    public static ResponseCode getResponseCode(final String code, final PassengerStatus status) {
        return getResponseCode(code, status, true);
    }

    /**
     * Gets a response code enumeration from a 4 digit response code.
     *
     * @param code  The 4 digit response code.
     * @param status  The passenger status.
     * @param createIfMissing  whether to create the response code if not found
     * @return The found response code object, or null if not found.
     */
    public static ResponseCode getResponseCode(
            final String code,
            final PassengerStatus status,
            final boolean createIfMissing) {
        ResponseCode responseCode = cResponseCodeLookupMap.get(code);

        if (responseCode == null && createIfMissing) {
            responseCode = createInternal(code, null, status, 0);

            if (responseCode != null) {
                synchronized (ResponseCode.class) {
                    if (cUnknownResponseCodeSet == null) {
                        cUnknownResponseCodeSet = new HashSet<>();
                    }

                    if (cUnknownResponseCodeSet.contains(code) == false) {
                        cWarningHelper.logWarning(String.format("Unknown response code received: %s", code));
                        cUnknownResponseCodeSet.add(code);
                    }
                }
            }
        }

        return responseCode;
    }

    /**
     * Gets the name of a response code value, handling null.
     *
     * @param responseCode  The response code.
     * @return  The name value, or null if code is null.
     */
	/*
	 * public static String getCodeHandlingNull(final ResponseCode responseCode) {
	 * if (responseCode != null) { return responseCode.getResponseCode(); }
	 * 
	 * return null; }
	 */

    //-----------------------------------------------------------------------
    /**
     * Checks to see if the current status has a lower precedence than
     * the given status. This will be used to find out if a passenger
     * status should be down-graded from say, OK to board, down to
     * not ok to board.
     *
     * @param status  The status to compare to.
     * @return 0 if the two status's have the same value, -1 if the current status is
     *     before the given status and 1 if the status if greater that the current
     *     status.
     */
    public int compare(final ResponseCode status) {
        if (precendence < status.precendence) {
            return -1;
        } else if (precendence > status.precendence) {
            return 1;
        } else {
            return 0;
        }
    }

}
