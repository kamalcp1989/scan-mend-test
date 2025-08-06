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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * Defines the APP error codes. All errors need to be reported back to the
 * CG in the form of APP error codes. There are a lot already defined.
 *
 * The existing error codes must be reused where ever possible.We should aim
 * to add a minimum of additional error codes in the course of this project.
 *
 * Error codes should be defined as needed (i.e. We are not going to define
 * each and every APP error code here - only the ones that we use.)
 *
 * A full list of error codes can be found in "APP-BSD v2.4.pdf" in appendix E.
 *
 * Uses a Java 1.5 enum
 */
public final class ErrorCode extends DynamicEnumeration {

    /** Defines the set of VALUES of message Types. */
    private static final Map<String, ErrorCode> VALUES = new ConcurrentHashMap<>();

    //-----------------------------------------------------------------------
    //
    // Internal Error Codes.
    //
    //-----------------------------------------------------------------------
    /** An unknown error. */
    public static final ErrorCode ERROR_0000_UNKNOWN = new ErrorCode("0000");

    /** Indicates that the a context already exists in the scheduler. */
    public static final ErrorCode ERROR_0001_CONTEXT_ALREADY_REGISTERED = new ErrorCode("0001");
    /** An invalid date. */
    public static final ErrorCode ERROR_0010_INVALID_DATE = new ErrorCode("0010");
    /** An invalid time. */
    public static final ErrorCode ERROR_0011_INVALID_TIME = new ErrorCode("0011");
    /** An invalid date/time. */
    public static final ErrorCode ERROR_0012_INVALID_DATE_TIME = new ErrorCode("0012");
    /** Missing date time. */
    public static final ErrorCode ERROR_0013_MISSING_DATE_TIME = new ErrorCode("0013");

    /** An invalid request type. */
    public static final ErrorCode ERROR_0020_INVALID_REQUEST_TYPE = new ErrorCode("0020");
    /** A missing header. */
    public static final ErrorCode ERROR_0021_MISSING_HEADER = new ErrorCode("0021");

    /** Missing transaction id. */
    public static final ErrorCode ERROR_0022_MISSING_TRANSACTION_ID = new ErrorCode("0022");
    /** Invalid transaction id. */
    public static final ErrorCode ERROR_0023_INVALID_TRANSACTION_ID = new ErrorCode("0023");
    /** A missing username. */
    public static final ErrorCode ERROR_0024_MISSING_USERNAME = new ErrorCode("0024");
    /** An invalid username. */
    public static final ErrorCode ERROR_0025_INVALID_USERNAME = new ErrorCode("0025");

    /** An airport code. */
    public static final ErrorCode ERROR_0030_AIRPORT_CODE = new ErrorCode("0030");

    /** An error code indicating a socket conversation timeout error. */
    public static final ErrorCode ERROR_0100_SOCKET_CONVERSATION_TIMEOUT = new ErrorCode("0100");
    /** An error code indicating a socket conversation connection error. */
    public static final ErrorCode ERROR_0101_SOCKET_CONVERSATION_CONNECTION_ERROR = new ErrorCode("0101");


    /** An error code indicating a socket conversation timeout error. */
    public static final ErrorCode ERROR_0200_SCHEDULES_TIMEOUT = new ErrorCode("0200");
    /** An error code indicating a socket conversation connection error. */
    public static final ErrorCode ERROR_0201_SCHEDULES_CONNECTION_ERROR = new ErrorCode("0201");

    //-----------------------------------------------------------------------
    //
    // The APP/ETAS Error Codes.
    //
    //-----------------------------------------------------------------------
    /** Invalid or missing action. */
    public static final ErrorCode ERROR_5000_ACTION_INCORRECT_MISSING = new ErrorCode("5000");
    /** Valid family name required. */
    public static final ErrorCode ERROR_5001_VALID_FAMILY_NAME_REQUIRED = new ErrorCode("5001");
    /** Valid given names or '-' required. */
    public static final ErrorCode ERROR_5002_VALID_GIVEN_NAMES_OR_A_DASH_REQUIRED = new ErrorCode("5002");
    /** Valid nationality required. */
    public static final ErrorCode ERROR_5003_VALID_NATIONALITY_REQUIRED = new ErrorCode("5003");
    /** Valid document number required. */
    public static final ErrorCode ERROR_5004_VALID_DOCUMENT_NUMBER_REQUIRED = new ErrorCode("5004");
    /** Valid document expiry date required. */
    public static final ErrorCode ERROR_5005_VALID_DOCUMENT_EXPIRY_DATE_REQUIED = new ErrorCode("5005");
    /** Valid date of birth required. */
    public static final ErrorCode ERROR_5006_VALID_DATE_OF_BIRTH_REQUIRED = new ErrorCode("5006");
    /** Valid country of birth required. */
    public static final ErrorCode ERROR_5007_VALID_COUNTRY_OF_BIRTH_REQUIRED = new ErrorCode("5007");
    /** Valid sex code required. */
    public static final ErrorCode ERROR_5008_VALID_SEX_CODE_REQUIRED = new ErrorCode("5008");
    /** Document number must be blank if document type is 'N'. */
    public static final ErrorCode ERROR_5010_DOCUMENT_NUMBER_MUST_BE_BLANK_IF_DOCUMENT_TYPE_IS_N = new ErrorCode("5010");
    /** Valid crew type required. */
    public static final ErrorCode ERROR_5011_VALID_CREW_TYPE_REQUIRED = new ErrorCode("5011");
    /** Valid type of travel required. */
    public static final ErrorCode ERROR_5012_VALID_TYPE_OF_TRAVEL_REQUIRED = new ErrorCode("5012");
    /** Invalid arrival date. */
    public static final ErrorCode ERROR_5013_INVALID_ARRIVAL_DATE = new ErrorCode("5013");
    /** Credit card number required. */
    public static final ErrorCode ERROR_5014_CREDIT_CARD_NUMBER_REQUIRED = new ErrorCode("5014");
    /** Valid credit card expiry date required. */
    public static final ErrorCode ERROR_5015_CREDIT_CARD_EXPIRY_DATE_REQUIRED = new ErrorCode("5015");
    /** The Constant ERROR_5016_VALID_DATE_OF_EFFECT_REQUIRED. */
    public static final ErrorCode ERROR_5016_VALID_DATE_OF_EFFECT_REQUIRED = new ErrorCode("5016");
    /** The Constant ERROR_5017_VALID_NAME_CHANGE_REASON_REQUIRED. */
    public static final ErrorCode ERROR_5017_VALID_NAME_CHANGE_REASON_REQUIRED = new ErrorCode("5017");
    /** Issuing authority contains invalid chars. */
    public static final ErrorCode ERROR_5018_ISSUING_AUTHORITY_CONTAINS_INVALID_CHARS = new ErrorCode("5018");
    /** Slash not permitted - use hyphen instead. */
    public static final ErrorCode ERROR_5019_SLASH_NOT_PERMITTED_USE_HYPHEN = new ErrorCode("5019");
    /** The Constant ERROR_5020_VALID_SELECTION_FOR_ADDITIONAL_ALIAS. */
    public static final ErrorCode ERROR_5020_INVALID_SELECTION_FOR_ADDITIONAL_ALIAS = new ErrorCode("5020");
    /** Invalid selection for temporary visa declaration. **/
    public static final ErrorCode ERROR_5025_INVALID_SELECTION_FOR_TEMPORARY_VISA_DECLARATION = new ErrorCode("5025");
    /** Invalid selection for domestic violence conviction. **/
    public static final ErrorCode ERROR_5026_INVALID_SELECTION_FOR_DOMESTIC_VIOLENCE_CONVICTION = new ErrorCode("5026");
    /** Invalid selection for domestic violence order. **/
    public static final ErrorCode ERROR_5027_INVALID_SELECTION_FOR_DOMESTIC_VIOLENCE_ORDER = new ErrorCode("5027");
    /** Previous screen error – transaction not completed. */
    public static final ErrorCode ERROR_5030_PREVIOUS_SCREEN_ERROR_TRANSACTION_NOT_COMPLETE = new ErrorCode("5030");
    /** valid card holder name required. */
    public static final ErrorCode ERROR_5040_VALID_CARD_HOLDER_NAME_REQUIRED = new ErrorCode("5040");
    /** Valid issuing state required. */
    public static final ErrorCode ERROR_5047_VALID_ISSUING_STATE_REQUIRED = new ErrorCode("5047");
    /** Document date of issue invalid. */
    public static final ErrorCode ERROR_5048_DOCUMENT_DATE_OF_ISSUE_INVALID = new ErrorCode("5048");
    /** Document date of issue invalid. */
    public static final ErrorCode ERROR_5049_VALID_ISSUING_AUTHORITY_REQUIRED = new ErrorCode("5049");
    /** More input lines expected. */
    public static final ErrorCode ERROR_5051_MORE_INPUT_LINES_EXPECTED = new ErrorCode("5051");
    /** Enter Y for new ETA or start new transaction. */
    public static final ErrorCode ERROR_5053_ENTER_Y_FOR_NEW_ETA_OR_START_NEW_TRANSACTION = new ErrorCode("5053");
    /** Not authorised to access ETA system. */
    public static final ErrorCode ERROR_5054_NOT_AUTHORISED_TO_ACCESS_ETA_SYSTEM = new ErrorCode("5054");
    /** Illegal Message Type/Sub-Type received from AP. */
    public static final ErrorCode ERROR_5056_ILLEGAL_MESSAGE_TYPE_SUB_TYPE_RECEIVED_FROM_AP = new ErrorCode("5056");
    /** No response from ETA-APP System. Please try again later. */
    public static final ErrorCode ERROR_5057_NO_RESPONSE_FROM_ETA_APP_SYSTEM_PLEASE_TRY_AGAIN_LATER = new ErrorCode("5057");
    /** No PNR Creation/Retrieval allowed when using the MAPC System. Please user IG to ignore. */
    public static final ErrorCode ERROR_5058_NO_PNR_CREATION_RETRIEVAL_ALLOWED_WHEN_USING_MAPC_SYSTEM = new ErrorCode("5058");
    /** Illegal ETA Subtopic. */
    public static final ErrorCode ERROR_5059_ILLEGAL_ETA_SUBTOPIC = new ErrorCode("5059");
    /** Must have at least 12 screen lines to use etas system. */
    public static final ErrorCode ERROR_5060_MUST_HAVE_AT_LEAST_12_LINES_FOR_ETA_SYSTEM = new ErrorCode("5060");
    /** Unknown Error response returned by the AP System. */
    public static final ErrorCode ERROR_5061_UNKNOWN_ERROR_RESPONSE_RETURNED_BY_AP_SYSTEM = new ErrorCode("5061");
    /** Unknown Error response returned by the AP System. */
    public static final ErrorCode ERROR_5062_ONLY_ONE_INPUT_OPTION_MAY_BE_SELECTED = new ErrorCode("5062");
    /** Reversal Transactions details cannot be displayed. */
    public static final ErrorCode ERROR_5063_DETAILS_OF_REVERSAL_CANNOT_BE_DISPLAYED = new ErrorCode("5063");
    /** History retrieval not authorised. */
    public static final ErrorCode ERROR_5064_HISTORY_RERIEVAL_NOT_AUTHORISED = new ErrorCode("5064");
    /** Move Up not allowed. */
    public static final ErrorCode ERROR_5065_MU_NOT_ALLOWED = new ErrorCode("5065");
    /** Move Down not allowed. */
    public static final ErrorCode ERROR_5066_MD_NOT_ALLOWED = new ErrorCode("5066");
    /** Not allowed as primary transaction. */
    public static final ErrorCode ERROR_5067_NOT_ALLOWED_AS_PRIMARY_TRANSACTION = new ErrorCode("5067");
    /** Too many check-in locations open. */
    public static final ErrorCode ERROR_5068_TOO_MANY_CHECK_IN_LOCATIONS_OPEN = new ErrorCode("5068");
    /** Screen less than 14 lines. Use command line. */
    public static final ErrorCode ERROR_5069_SCREEN_LESS_THAN_14_LINES_USE_COMMAND_LINE = new ErrorCode("5069");
    /** Not authorised to access CTA system. */
    public static final ErrorCode ERROR_5070_NOT_AUTHORISED_TO_ACCESS_CTA_SYSTEM = new ErrorCode("5070");
    /** No match to previous passport number. */
    public static final ErrorCode ERROR_5071_NO_MATCH_TO_PREVIOUS_PASSPORT_NUMBER = new ErrorCode("5071");
    /** Must have at least 64 characters per screen line to use etas system. */
    public static final ErrorCode ERROR_5072_MUST_HAVE_AT_LEAST_64_CHARACTERS_PER_LINE_FOR_ETA_SYSTEM = new ErrorCode("5072");
    /** Enter Y to reverse or start new transaction. */
    public static final ErrorCode ERROR_5073_ENTER_Y_TO_REVERSE_OR_START_NEW_TRANSACTION = new ErrorCode("5073");
    /** Must select an option or start new transaction. */
    public static final ErrorCode ERROR_5074_MUST_SELECT_AN_OPTION_OR_START_NEW_TRANSACTION = new ErrorCode("5074");
    /** No match to previous family name. */
    public static final ErrorCode ERROR_5075_NO_MATCH_TO_PREVIOUS_FAMILY_NAME = new ErrorCode("5075");
    /** No match to previous nationality. */
    public static final ErrorCode ERROR_5076_NO_MATCH_TO_PREVIOUS_NATIONALITY = new ErrorCode("5076");
    /** No match to previous first given name. */
    public static final ErrorCode ERROR_5077_NO_MATCH_TO_PREVIOUS_FIRST_GIVEN_NAME = new ErrorCode("5077");
    /** No match to previous second given name. */
    public static final ErrorCode ERROR_5078_NO_MATCH_TO_PREVIOUS_SECOND_GIVEN_NAME = new ErrorCode("5078");
    /** No match to previous second given name. */
    public static final ErrorCode ERROR_5079_NO_MATCH_TO_PREVIOUS_OTHER_GIVEN_NAME = new ErrorCode("5079");
    /** Invalid selection for additional citizenship. */
    public static final ErrorCode ERROR_5100_INVALID_SELECTION_FOR_ADDITIONAL_CITIZENSHIP = new ErrorCode("5100");
    /** Required if other citizenship held. */
    public static final ErrorCode ERROR_5101_REQUIRED_IF_OTHER_CITIZENSHIP_HELD = new ErrorCode("5101");
    /** Must be blank if no other citizenship held. */
    public static final ErrorCode ERROR_5102_MUST_BE_BLANK_IF_NO_ADDITIONAL_CITIZENSHIP = new ErrorCode("5102");
    /** Invalid  citizenship country code. */
    public static final ErrorCode ERROR_5103_INVALID_CITIZENSHIP_COUNTRY_CODE = new ErrorCode("5103");
    /** At least one address line is required. */
    public static final ErrorCode ERROR_5104_AT_LEAST_ONE_ADDRESS_LINE_REQUIRED = new ErrorCode("5104");
    /** Address contains invalid characters. */
    public static final ErrorCode ERROR_5105_ADDRESS_CONTAINS_INVALID_CHARACTERS = new ErrorCode("5105");
    /** Invalid telephone country code. */
    public static final ErrorCode ERROR_5106_INVALID_TELEPHONE_COUNTRY_CODE = new ErrorCode("5106");
    /** Incomplete home telephone number. */
    public static final ErrorCode ERROR_5107_INCOMPLETE_HOME_TELEPHONE_NUMBER = new ErrorCode("5107");
    /** Invalid telephone area code. */
    public static final ErrorCode ERROR_5108_INVALID_TELEPHONE_AREA_CODE = new ErrorCode("5108");
    /** Invalid telephone number. */
    public static final ErrorCode ERROR_5109_INVALID_TELEPHONE_NUMBER = new ErrorCode("5109");
    /** Incomplete business telephone number. */
    public static final ErrorCode ERROR_5110_INCOMPLETE_BUSINESS_TELEPHONE_NUMBER = new ErrorCode("5110");
    /** Incomplete mobile telephone number. */
    public static final ErrorCode ERROR_5111_INVALID_MOBILE_TELEPHONE_NUMBER = new ErrorCode("5111");
    /** Email address contains invalid characters. */
    public static final ErrorCode ERROR_5112_EMAIL_ADDRESS_CONTAINS_INVALID_CHARACTERS = new ErrorCode("5112");
    /** Invalid selection for additional passport. */
    public static final ErrorCode ERROR_5113_INVALID_SELECTION_FOR_ADDITIONAL_PASSPORT = new ErrorCode("5113");
    /** Required if other passport held. */
    public static final ErrorCode ERROR_5114_REQUIRED_IF_OTHER_PASSPORT_HELD = new ErrorCode("5114");
    /** Must be blank if no other passport held. */
    public static final ErrorCode ERROR_5115_MUST_BE_BLANK_IF_NO_ADDITIONAL_PASSPORT = new ErrorCode("5115");
    /** Invalid passport country code. */
    public static final ErrorCode ERROR_5116_INVALID_PASSPORT_COUNTRY_CODE = new ErrorCode("5116");
    /** Email address required code. */
    public static final ErrorCode ERROR_5117_EMAIL_ADDRESS_IS_REQUIRED = new ErrorCode("5117");
    /** Invalid selection for other name. */
    public static final ErrorCode ERROR_5121_INVALID_OTHER_NAME = new ErrorCode("5121");
    /** Invalid selection for criminal conviction. */
    public static final ErrorCode ERROR_5122_INVALID_CRIMINAL_CONVICTION = new ErrorCode("5122");
    /** Invalid user logon supplied. */
    public static final ErrorCode ERROR_5123_INVALID_NATIONAL_ID_NUMBER = new ErrorCode("5123");
    /** Invalid user logon supplied. */
    public static final ErrorCode ERROR_5150_VALID_LOGON_REQUIRED = new ErrorCode("5150");
    /** Invalid country of residence. */
    public static final ErrorCode ERROR_5200_INVALID_COUNTRY_OF_RESIDENCE = new ErrorCode("5200");
    /** Invalid traveler origin. */
    public static final ErrorCode ERROR_5201_INVALID_TRAVELER_ORIGIN = new ErrorCode("5201");
    /** Invalid traveler destination. */
    public static final ErrorCode ERROR_5202_INVALID_TRAVELER_DESTINATION = new ErrorCode("5202");
    /** Invalid passenger reference. */
    public static final ErrorCode ERROR_5203_INVALID_PASSENGER_REFERENCE = new ErrorCode("5203");
    /** Invalid country for additional data. */
    public static final ErrorCode ERROR_5204_INVALID_COUNTRY_FOR_ADDITIONAL_DATA = new ErrorCode("5204");
    /** Invalid additional travel document type. */
    public static final ErrorCode ERROR_5205_INVALID_ADDITIONAL_TRAVEL_DOCUMENT_TYPE = new ErrorCode("5205");
    /** Invalid additional travel document number. */
    public static final ErrorCode ERROR_5206_INVALID_ADDITIONAL_TRAVEL_DOCUMENT_NUMBER = new ErrorCode("5206");
    /** Invalid additional travel document country of issuance. */
    public static final ErrorCode ERROR_5207_INVALID_ADDITIONAL_TRAVEL_DOCUMENT_COUNTRY_OF_ISSUANCE = new ErrorCode("5207");
    /** Invalid additional travel document expiration date. */
    public static final ErrorCode ERROR_5208_INVALID_ADDITIONAL_TRAVEL_DOCUMENT_EXPIRATION_DATE = new ErrorCode("5208");
    /** Invalid address number and street. */
    public static final ErrorCode ERROR_5209_INVALID_ADDRESS_NUMBER_AND_STREET = new ErrorCode("5209");
    /** Invalid address city. */
    public static final ErrorCode ERROR_5210_INVALID_ADDRESS_CITY = new ErrorCode("5210");
    /** Invalid address state. */
    public static final ErrorCode ERROR_5211_INVALID_ADDRESS_STATE = new ErrorCode("5211");
    /** Invalid address postal code. */
    public static final ErrorCode ERROR_5212_INVALID_ADDRESS_POSTAL_CODE = new ErrorCode("5212");
    /** Valid First Name required. */
    public static final ErrorCode ERROR_5213_VALID_FIRST_NAME_REQUIRED = new ErrorCode("5213");
    /** Invalid message format. */
    public static final ErrorCode ERROR_5214_INVALID_MESSAGE_FORMAT = new ErrorCode("5214");
    /** Invalid transaction type qualifier. */
    public static final ErrorCode ERROR_5215_INVALID_TRANSACTION_TYPE_QUALIFIER = new ErrorCode("5215");
    /** Check-in port required. */
    public static final ErrorCode ERROR_5216_INVALID_CHECK_IN_PORT = new ErrorCode("5216");
    /** Domestic flight number not provided or format invalid. */
    public static final ErrorCode ERROR_5217_DOMESTIC_FLIGHT_NUMBER_NOT_PROVIDED_OR_FORMAT_INVALID = new ErrorCode("5217");
    /** Domestic flight departure date invalid. */
    public static final ErrorCode ERROR_5218_DOMESTIC_FLIGHT_DEPARTURE_DATE_INVALID = new ErrorCode("5218");
    /** Domestic flight departure date outside allowable range. */
    public static final ErrorCode ERROR_5219_DOMESTIC_FLIGHT_DEPARTURE_DATE_OUTSIDE_ALLOWABLE_RANGE = new ErrorCode("5219");
    /** Valid domestic flight departure time required. */
    public static final ErrorCode ERROR_5220_VALID_DOMESTIC_FLIGHT_DEPARTURE_TIME_REQUIRED = new ErrorCode("5220");
    /** Valid domestic flight arrival date required. */
    public static final ErrorCode ERROR_5221_VALID_DOMESTIC_FLIGHT_ARRIVAL_DATE_REQUIRED = new ErrorCode("5221");
    /** Valid domestic flight arrival time required. */
    public static final ErrorCode ERROR_5222_VALID_DOMESTIC_FLIGHT_ARRIVAL_TIME_REQUIRED = new ErrorCode("5222");
    /** Invalid country for gate pass request. */
    public static final ErrorCode ERROR_5223_INVALID_COUNTRY_FOR_GATE_PASS_REQUEST = new ErrorCode("5223");
    /** Invalid carrier for gate pass request. */
    public static final ErrorCode ERROR_5224_INVALID_CARRIER_FOR_GATE_PASS_REQUEST = new ErrorCode("5224");
    /** Invalid country for overflight. */
    public static final ErrorCode ERROR_5225_INVALID_COUNTRY_FOR_OVERFLIGHT = new ErrorCode("5225");
    /** Invalid airport for gate pass request. */
    public static final ErrorCode ERROR_5226_INVALID_AIRPORT_FOR_GATE_PASS_REQUEST = new ErrorCode("5226");
    /** Invalid place of birth city. */
    public static final ErrorCode ERROR_5227_INVALID_PLACE_OF_BIRTH_CITY = new ErrorCode("5227");
    /** Invalid place of birth state. */
    public static final ErrorCode ERROR_5228_INVALID_PLACE_OF_BIRTH_STATE = new ErrorCode("5228");
    /** Invalid itinerary flight number. */
    public static final ErrorCode ERROR_5229_INVALID_ITINERARY_FLIGHT_NUMBER = new ErrorCode("5229");
    /** Invalid itinerary flight departure port. */
    public static final ErrorCode ERROR_5230_INVALID_ITINERARY_FLIGHT_DEPARTURE_PORT = new ErrorCode("5230");
    /** Invalid itinerary flight departure date. */
    public static final ErrorCode ERROR_5231_INVALID_ITINERARY_FLIGHT_DEPARTURE_DATE = new ErrorCode("5231");
    /** Invalid itinerary flight departure time. */
    public static final ErrorCode ERROR_5232_INVALID_ITINERARY_FLIGHT_DEPARTURE_TIME = new ErrorCode("5232");
    /** Invalid itinerary flight arrival port. */
    public static final ErrorCode ERROR_5233_INVALID_ITINERARY_FLIGHT_ARRIVAL_PORT = new ErrorCode("5233");
    /** Invalid itinerary flight arrival date. */
    public static final ErrorCode ERROR_5234_INVALID_ITINERARY_FLIGHT_ARRIVAL_DATE = new ErrorCode("5234");
    /** Invalid itinerary flight arrival time. */
    public static final ErrorCode ERROR_5235_INVALID_ITINERARY_FLIGHT_ARRIVAL_TIME = new ErrorCode("5235");
    /** Invalid passenger redress number. */
    public static final ErrorCode ERROR_5236_INVALID_PASSENGER_REDRESS_NUMBER = new ErrorCode("5236");
    /** Invalid known traveller number. */
    public static final ErrorCode ERROR_5237_INVALID_KNOWN_TRAVELLER_NUMBER = new ErrorCode("5237");
    /** Flight number not provided or format invalid. */
    public static final ErrorCode ERROR_5238_FLIGHT_NUMBER_NOT_PROVIDED_OR_FORMAT_INVALID = new ErrorCode("5238");
    /** Invalid type of flight. */
    public static final ErrorCode ERROR_5239_INVALID_TYPE_OF_FLIGHT = new ErrorCode("5239");
    /** Invalid data verification flag. */
    public static final ErrorCode ERROR_5240_INVALID_DATA_VERIFICATION_FLAG = new ErrorCode("5240");
    /** Invalid gate pass validity date.*/
    public static final ErrorCode ERROR_5241_INVALID_GATE_PASS_VALIDITY_DATE = new ErrorCode("5241");
    /** Gate pass validity date outside allowable range.*/
    public static final ErrorCode ERROR_5242_GATE_PASS_VALIDITY_DATE_OUTSIDE_ALLOWABLE_RANGE = new ErrorCode("5242");
    /** Invalid request sequence number.*/
    public static final ErrorCode ERROR_5243_INVALID_REQUEST_SEQUENCE_NUMBER = new ErrorCode("5243");
    /** Invalid document type for gate pass request.*/
    public static final ErrorCode ERROR_5244_INVALID_DOCUMENT_TYPE_FOR_GATE_PASS_REQUEST = new ErrorCode("5244");
    /** Too many gate pass requests in message.*/
    public static final ErrorCode ERROR_5245_TOO_MANY_GATE_PASS_REQUESTS_IN_MESSAGE = new ErrorCode("5245");
    /** Invalid message content.*/
    public static final ErrorCode ERROR_5246_INVALID_MESSAGE_CONTENT = new ErrorCode("5246");
    /** Flight is not an international flight. */
    public static final ErrorCode ERROR_5247_FLIGHT_IS_NOT_AN_INTERNATIONAL_FLIGHT = new ErrorCode("5247");
    /** Domestic flight not in airline schedules. */
    public static final ErrorCode ERROR_5248_DOMESTIC_FLIGHT_NOT_IN_AIRLINE_SCHEDULES = new ErrorCode("5248");
    /** Airports not in same country. */
    public static final ErrorCode ERROR_5249_AIRPORTS_NOT_IN_SAME_COUNTRY = new ErrorCode("5249");
    /** Overflight ports not valid for internatinal flight. */
    public static final ErrorCode ERROR_5250_OVERFLIGHT_PORTS_NOT_VALID_FOR_INTERNATIONAL_FLIGHT = new ErrorCode("5250");
    /** Country specified not valid for overflight. */
    public static final ErrorCode ERROR_5251_COUNTRY_SPECIFIED_NOT_VALID_FOR_OVERFLIGHT = new ErrorCode("5251");
    /** Expected flight not International flight. */
    public static final ErrorCode ERROR_5252_EXPECTED_FLIGHT_NOT_INTERNATIONAL_FLIGHT = new ErrorCode("5252");
    /** Country requiring manifest not valid for flight. */
    public static final ErrorCode ERROR_5253_COUNTRY_REQUIRING_MANIFEST_NOT_VALID_FOR_FLIGHT = new ErrorCode("5253");
    /** Country providing status not valid for flight. */
    public static final ErrorCode ERROR_5254_COUNTRY_PROVIDING_STATUS_NOT_VALID_FOR_FLIGHT = new ErrorCode("5254");
    /** Airport and country for gate pass not consistent. */
    public static final ErrorCode ERROR_5255_AIRPORT_AND_COUNTRY_FOR_GATE_PASS_NOT_CONSISTENT = new ErrorCode("5255");
    /** Transaction not required by any APP country. */
    public static final ErrorCode ERROR_5256_TRANSACTION_NOT_REQUIRED_BY_ANY_APP_COUNTRY = new ErrorCode("5256");
    /** Invalid action code. */
    public static final ErrorCode ERROR_5257_INVALID_ACTION_CODE = new ErrorCode("5257");
    /** Airline not certified for unscheduled flights. */
    public static final ErrorCode ERROR_5258_AIRLINE_NOT_CERTIFIED_FOR_UNSCHEDULED_FLIGHTS = new ErrorCode("5258");
    /** Invalid characters in input data. */
    public static final ErrorCode ERROR_5259_INVALID_CHARACTERS_IN_INPUT_DATA = new ErrorCode("5259");
    /** More than five countries in transaction. */
    public static final ErrorCode ERROR_5260_TOO_MANY_AUTHOTIRIES_IN_TRANSACTION = new ErrorCode("5260");
    /** Domestic flight origin invalid. */
    public static final ErrorCode ERROR_5261_DOMESTIC_FLIGHT_ORIGIN_INVALID = new ErrorCode("5261");
    /** Domestic flight destination invalid. */
    public static final ErrorCode ERROR_5262_DOMESTIC_FLIGHT_DESTINATION_INVALID = new ErrorCode("5262");
    /** Overflight segment origin invalid. */
    public static final ErrorCode ERROR_5263_OVERFLIGHT_SEGMENT_ORIGIN_INVALID = new ErrorCode("5263");
    /** Overflight segment destination invalid. */
    public static final ErrorCode ERROR_5264_OVERFLIGHT_SEGMENT_DESTINATION_INVALID = new ErrorCode("5264");
    /** Overflight segment destination invalid. */
    public static final ErrorCode ERROR_5265_OVERFLIGHT_FLIGHT_NUMBER_NOT_PROVIDED_OR_FORMAT_INVALID = new ErrorCode("5265");
    /** Overflight segment departure date invalid. */
    public static final ErrorCode ERROR_5266_OVERFLIGHT_SEGMENT_DEPARTURE_DATE_INVALID = new ErrorCode("5266");
    /** Overflight segment departure date outrside of allowable range. */
    public static final ErrorCode ERROR_5267_OVERFLIGHT_SEGMENT_DEPARTURE_DATE_OUTSIDE_ALLOWABLE_RANGE = new ErrorCode("5267");
    /** Invalid additional address country code. */
    public static final ErrorCode ERROR_5268_INVALID_ADDITIONAL_ADDRESS_COUNTRY_CODE = new ErrorCode("5268");
    /** Invalid additional address country code. */
    public static final ErrorCode ERROR_5269_CANNOT_CLOSE_MORE_THAN_ONE_FLIGHT_SEGMENT = new ErrorCode("5269");
    /** Too many travellers in transaction. */
    public static final ErrorCode ERROR_5270_TOO_MANY_TRAVELLERS_IN_TRANSACTION = new ErrorCode("5270");

    /** Function code required. */
    public static final ErrorCode ERROR_5501_FUNCTION_CODE_REQUIRED = new ErrorCode("5501");
    /** Function code invalid. */
    public static final ErrorCode ERROR_5502_FUNCTION_CODE_INVALID = new ErrorCode("5502");
    /** Flight already open for this location. */
    public static final ErrorCode ERROR_5503_FLIGHT_ALREADY_OPEN_FOR_THIS_LOCATION = new ErrorCode("5503");
    /** Flight not open for this location. */
    public static final ErrorCode ERROR_5504_FLIGHT_NOT_OPEN_FOR_THIS_LOCATION = new ErrorCode("5504");
    /** No matching open flights for this location. */
    public static final ErrorCode ERROR_5505_NO_MATCHING_OPEN_FLIGHTS_FOR_THIS_LOCATION = new ErrorCode("5505");
    /** Flight number required. */
    public static final ErrorCode ERROR_5506_FLIGHT_NUMBER_REQUIRED = new ErrorCode("5506");
    /** Invalid flight number format. */
    public static final ErrorCode ERROR_5507_INVALID_FLIGHT_NUMBER_FORMAT = new ErrorCode("5507");
    /** Departure date required. */
    public static final ErrorCode ERROR_5508_DEPARTURE_DATE_REQUIRED = new ErrorCode("5508");
    /** Invalid departure date. */
    public static final ErrorCode ERROR_5509_INVALID_DEPARTURE_DATE = new ErrorCode("5509");
    /** Departure date outside allowable range. */
    public static final ErrorCode ERROR_5510_DEPARTURE_DATE_OUTSIDE_ALLOWABLE_RANGE = new ErrorCode("5510");
    /** Board point airport code required. */
    public static final ErrorCode ERROR_5511_BOARD_POINT_AIRPORT_CODE_REQUIRED = new ErrorCode("5511");
    /** Board point airport invalid. */
    public static final ErrorCode ERROR_5512_BOARD_POINT_AIRPORT_INVALID = new ErrorCode("5512");
    /** Off point airport code required. */
    public static final ErrorCode ERROR_5513_OFF_POINT_AIRPORT_CODE_REQUIRED = new ErrorCode("5513");
    /** Off point airport invalid. */
    public static final ErrorCode ERROR_5514_OFF_POINT_AIRPORT_INVALID = new ErrorCode("5514");
    /** Already at top of list. */
    public static final ErrorCode ERROR_5515_ALREADY_AT_TOP_OF_LIST = new ErrorCode("5515");
    /** Already at bottom of list. */
    public static final ErrorCode ERROR_5516_ALREADY_AT_BOTTOM_OF_LIST = new ErrorCode("5516");
    /** Invalid item selection string. */
    public static final ErrorCode ERROR_5517_INVALID_ITEM_SELECTION_STRING = new ErrorCode("5517");
    /** Selected item not on list. */
    public static final ErrorCode ERROR_5518_SELECTED_ITEM_NOT_ON_LIST = new ErrorCode("5518");
    /** No open flights. Open or specify flight. */
    public static final ErrorCode ERROR_5519_NO_OPEN_FLIGHTS_OPEN_OR_SPECIFY_FLIGHT = new ErrorCode("5519");
    /** More than one open flight. Provide more details. */
    public static final ErrorCode ERROR_5520_MORE_THAN_ONE_OPEN_FLIGHT_PROVIDE_MORE_DETAILS = new ErrorCode("5520");
    /** More than one matching flight. Provide more details. */
    public static final ErrorCode ERROR_5521_MORE_THAN_ONE_MATCHING_FLIGHT_PROVIDE_MORE_DETAILS = new ErrorCode("5521");
    /** No matching flights. */
    public static final ErrorCode ERROR_5522_NO_MATCHING_FLIGHTS = new ErrorCode("5522");
    /** Not authorised to access APP System. */
    public static final ErrorCode ERROR_5523_NOT_AUTHORISED_TO_ACCESS_APP_SYSTEM = new ErrorCode("5523");
    /** Document information not supplied. */
    public static final ErrorCode ERROR_5524_DOCUMENT_INFORMATION_NOT_SUPPLIED = new ErrorCode("5524");
    /** Mandatory data groups not present in message. */
    public static final ErrorCode ERROR_5525_MANDATORY_DATA_GROUPS_NOT_PRESENT_IN_MESSAGE = new ErrorCode("5525");
    /** User Id required. */
    public static final ErrorCode ERROR_5526_USER_ID_REQUIRED = new ErrorCode("5526");
    /** Invalid check-in flight number format. */
    public static final ErrorCode ERROR_5527_INVALID_CHECK_IN_FLIGHT_NUMBER_FORMAT = new ErrorCode("5527");
    /** International flight number not provided or format invalid. */
    public static final ErrorCode ERROR_5528_INTERNATIONAL_FLIGHT_NUMBER_NOT_PROVIDED_OR_FORMAT_INVALID = new ErrorCode("5528");
    /** International flight origin invalid. */
    public static final ErrorCode ERROR_5529_INTERNATIONAL_FLIGHT_ORIGIN_INVALID = new ErrorCode("5529");
    /** International flight destination invalid. */
    public static final ErrorCode ERROR_5530_INTERNATIONAL_FLIGHT_DESTINATION_INVALID = new ErrorCode("5530");
    /** International flight departure date invalid. */
    public static final ErrorCode ERROR_5531_INTERNATIONAL_FLIGHT_DEPARTURE_DATE_INVALID = new ErrorCode("5531");
    /** International flight departure date outside allowable range. */
    public static final ErrorCode ERROR_5532_INTERNATIONAL_FLIGHT_DEPARTURE_DATE_OUTSIDE_ALLOWABLE_RANGE = new ErrorCode("5532");
    /** Expected port code invalid. */
    public static final ErrorCode ERROR_5533_EXPECTED_PORT_CODE_INVALID = new ErrorCode("5533");
    /** Invalid expected flight number format. */
    public static final ErrorCode ERROR_5535_INVALID_EXPECTED_FLIGHT_NUMBER_FORMAT = new ErrorCode("5535");
    /** Expected flight not in schedules. */
    public static final ErrorCode ERROR_5536_EXPECTED_FLIGHT_NOT_IN_SCHEDULES = new ErrorCode("5536");
    /** Expected flight date invalid. */
    public static final ErrorCode ERROR_5537_EXPECTED_FLIGHT_DATE_INVALID = new ErrorCode("5537");
    /** Expected flight date outside allowable range. */
    public static final ErrorCode ERROR_5538_EXPECTED_FLIGHT_DATE_OUTSIDE_ALLOWABLE_RANGE = new ErrorCode("5538");
    /** Passenger sequence number invalid. */
    public static final ErrorCode ERROR_5539_PASSENGER_SEQUENCE_NUMBER_INVALID = new ErrorCode("5539");
    /** Pax or Crew Indicator invalid. */
    public static final ErrorCode ERROR_5540_PAX_OR_CREW_INDICATOR_INVALID = new ErrorCode("5540");
    /** Passport check character does not match passport number. */
    public static final ErrorCode ERROR_5541_PASSPORT_CHECK_CHARACTER_DOES_NOT_MATCH_PASSPORT_NUMBER = new ErrorCode("5541");
    /** Supplementary document type invalid. */
    public static final ErrorCode ERROR_5542_SUPPLEMENTARY_DOCUMENT_TYPE_INVALID = new ErrorCode("5542");
    /** Supplementary document check character does not match. */
    public static final ErrorCode ERROR_5543_SUPPLEMENTARY_DOCUMENT_CHECK_CHARACTER_DOES_NOT_MATCH = new ErrorCode("5543");
    /** Invalid Date of Birth. */
    public static final ErrorCode ERROR_5544_INVALID_DATE_OF_BIRTH = new ErrorCode("5544");
    /** Date of Birth outside allowable range. */
    public static final ErrorCode ERROR_5545_DATE_OF_BIRTH_OUTSIDE_ALLOWABLE_RANGE = new ErrorCode("5545");
    /** Invalid Sex. */
    public static final ErrorCode ERROR_5546_INVALID_SEX = new ErrorCode("5546");
    /** Country of birth invalid. */
    public static final ErrorCode ERROR_5547_COUNTRY_OF_BIRTH_INVALID = new ErrorCode("5547");
    /** Holder-endorsee flag invalid. */
    public static final ErrorCode ERROR_5548_HOLDER_ENDORSEE_FLAG_INVALID = new ErrorCode("5548");
    /** Both airports in same country. */
    public static final ErrorCode ERROR_5549_BOTH_AIRPORTS_IN_SAME_COUNTRY = new ErrorCode("5549");
    /** Countries not participating in APP System. */
    public static final ErrorCode ERROR_5550_COUNTRIES_NOT_PARTICIPATING_IN_APP_SYSTEM = new ErrorCode("5550");
    /** Check-in location not authorised to process transaction. */
    public static final ErrorCode ERROR_5551_CHECK_IN_LOCATION_NOT_AUTHORISED_TO_PROCESS_TRANSACTION = new ErrorCode("5551");
    /** Flight not in airline schedules. */
    public static final ErrorCode ERROR_5552_FLIGHT_NOT_IN_AIRLINE_SCHEDULES = new ErrorCode("5552");
    /** Trans-border date invalid. */
    public static final ErrorCode ERROR_5557_TRANS_BORDER_DATE_INVALID = new ErrorCode("5557");
    /** Trans-border port code invalid. */
    public static final ErrorCode ERROR_5558_TRANS_BORDER_PORT_CODE_INVALID = new ErrorCode("5558");
    /** Document type invalid. */
    public static final ErrorCode ERROR_5560_DOCUMENT_TYPE_INVALID = new ErrorCode("5560");
    /** No overrides are valid in APP at this time. */
    public static final ErrorCode ERROR_5563_NO_OVERRIDES_ARE_VALID_IN_APP_AT_THIS_TIME = new ErrorCode("5563");
    /** Only passports are valid for APP at this time. */
    public static final ErrorCode ERROR_5564_ONLY_PASSPORTS_ARE_VALID_FOR_APP_AT_THIS_TIME = new ErrorCode("5564");
    /** APP not required for transfers at this time. */
    public static final ErrorCode ERROR_5565_APP_NOT_REQUIRED_FOR_TRANSFERS_AT_THIS_TIME = new ErrorCode("5565");
    /** APP not required for Document Types 'O' or 'N' at this time. */
    public static final ErrorCode ERROR_5566_APP_NOT_REQUIRED_FOR_DOCUMENT_TYPES_O_OR_N_AT_THIS_TIME = new ErrorCode("5566");
    /** Countries can only process document type 'P'. */
    public static final ErrorCode ERROR_5567_COUNTRIES_CAN_ONLY_PROCESS_DOCUMENT_TYPE_P = new ErrorCode("5567");
    /** Inconsistent requirements for persons in message. */
    public static final ErrorCode ERROR_5568_INCONSISTENT_REQUIREMENTS_FOR_PERSONS_IN_MESSAGE = new ErrorCode("5568");
    /** Participating countries cannot process these transactions. */
    public static final ErrorCode ERROR_5569_PARTICIPATING_COUNTRIES_CANNOT_PROCESS_THESE_TRANSACTIONS = new ErrorCode("5569");
    /** Given names contain invalid characters. */
    public static final ErrorCode ERROR_5571_GIVEN_NAMES_CONTAIN_INVALID_CHARACTERS = new ErrorCode("5571");
    /** Issuing state invalid. */
    public static final ErrorCode ERROR_5572_ISSUING_STATE_INVALID = new ErrorCode("5572");
    /** Document expiry date invalid. */
    public static final ErrorCode ERROR_5573_DOCUMENT_EXPIRY_DATE_INVALID = new ErrorCode("5573");
    /** Transfer at origin flag invalid. */
    public static final ErrorCode ERROR_5574_TRANSFER_AT_ORIGIN_FLAG_INVALID = new ErrorCode("5574");
    /** Transfer at destination flag invalid. */
    public static final ErrorCode ERROR_5575_TRANSFER_AT_DESTINATION_FLAG_INVALID = new ErrorCode("5575");
    /** PNR source invalid. */
    public static final ErrorCode ERROR_5576_PNR_SOURCE_INVALID = new ErrorCode("5576");
    /** Access to APP System via on-line is not available at present. */
    public static final ErrorCode ERROR_5577_ACCESS_TO_APP_SYSTEM_VIA_ON_LINE_IS_NOT_AVAILABLE_AT_PRESENT = new ErrorCode("5577");
    /** No expected movement to cancel. */
    public static final ErrorCode ERROR_5578_NO_EXPECTED_MOVEMENT_TO_CANCEL = new ErrorCode("5578");
    /** Data capture not required at this time. */
    public static final ErrorCode ERROR_5579_DATA_CAPTURE_NOT_REQUIRED_AT_THIS_TIME = new ErrorCode("5579");
    /** Override codes and countries inconsistent with passenger status. */
    public static final ErrorCode ERROR_5580_OVERRIDE_CODES_AND_COUNTRIES_INCONSISTENT_WITH_PASSENGER_STATUS = new ErrorCode("5580");
    /** Handle multiple response flag invalid. */
    public static final ErrorCode ERROR_5581_HANDLE_MULTIPLE_RESPONSE_FLAG_INVALID = new ErrorCode("5581");
    /** Message version not supported. */
    public static final ErrorCode ERROR_5582_MESSAGE_VERSION_NOT_SUPPORTED = new ErrorCode("5582");
    /** Scheduled/unscheduled flight flag invalid. */
    public static final ErrorCode ERROR_5583_SCHEDULED_UNSCHEDULED_FLIGHT_FLAG_INVALID = new ErrorCode("5583");
    /** Valid international flight time required. */
    public static final ErrorCode ERROR_5584_VALID_INTERNATIONAL_FLIGHT_TIME_REQUIRED = new ErrorCode("5584");
    /** Valid international flight arrival date required. */
    public static final ErrorCode ERROR_5585_VALID_INTERNATIONAL_FLIGHT_ARRIVAL_DATE_REQUIRED = new ErrorCode("5585");
    /** Valid international flight arrival time required. */
    public static final ErrorCode ERROR_5586_VALID_INTERNATIONAL_FLIGHT_ARRIVAL_TIME_REQUIRED = new ErrorCode("5586");
    /** Expected flight time invalid. */
    public static final ErrorCode ERROR_5587_EXPECTED_FLIGHT_TIME_INVALID = new ErrorCode("5587");
    /** Trans-border flight time invalid. */
    public static final ErrorCode ERROR_5588_TRANS_BORDER_FLIGHT_TIME_INVALID = new ErrorCode("5588");
    /** Override code or country invalid. */
    public static final ErrorCode ERROR_5589_OVERRIDE_CODE_OR_COUNTRY_INVALID = new ErrorCode("5589");
    /** Expected passenger identifier invalid. */
    public static final ErrorCode ERROR_5590_EXPECTED_PASSENGER_IDENTIFIER_INVALID = new ErrorCode("5590");
    /** Valid issuing state required. */
    public static final ErrorCode ERROR_5591_VALID_ISSUING_STATE_REQUIRED = new ErrorCode("5591");
    /** PNR record locator required if PNR source given. */
    public static final ErrorCode ERROR_5592_PNR_RECORD_LOCATOR_REQUIRED_IF_PNR_SOURCE_GIVEN = new ErrorCode("5592");
    /** International flight not in airline schedules. */
    public static final ErrorCode ERROR_5593_INTERNATIONAL_FLIGHT_NOT_IN_AIRLINE_SCHEDULES = new ErrorCode("5593");
    /** Country not configured to provide data requested. */
    public static final ErrorCode ERROR_5594_COUNTRY_NOT_CONFIGURED_TO_PROVIDE_DATA_REQUESTED = new ErrorCode("5594");
    /** Country not on international flight. */
    public static final ErrorCode ERROR_5595_COUNTRY_NOT_ON_INTERNATIONAL_FLIGHT = new ErrorCode("5595");
    /** Page reference required. */
    public static final ErrorCode ERROR_5596_PAGE_REFERENCE_REQUIRED = new ErrorCode("5596");
    /** Invalid Page reference. */
    public static final ErrorCode ERROR_5597_INVALID_PAGE_REFERENCE = new ErrorCode("5597");
    /** Effective date required. */
    public static final ErrorCode ERROR_5600_EFFECTIVE_DATE_REQUIRED = new ErrorCode("5600");
    /** Invalid effective date. */
    public static final ErrorCode ERROR_5601_INVALID_EFFECTIVE_DATE = new ErrorCode("5601");
    /** Effective date outside allowable range. */
    public static final ErrorCode ERROR_5602_EFFECTIVE_DATE_OUTSIDE_ALLOWABLE_RANGE = new ErrorCode("5602");
    /** Discontinue date required. */
    public static final ErrorCode ERROR_5603_DISCONTINUE_DATE_REQUIRED = new ErrorCode("5603");
    /** Invalid discontinue date. */
    public static final ErrorCode ERROR_5604_INVALID_DISCONTINUE_DATE = new ErrorCode("5604");
    /** Discontinue date outside allowable range. */
    public static final ErrorCode ERROR_5605_DISCONTINUE_DATE_OUTSIDE_ALLOWABLE_RANGE = new ErrorCode("5605");
    /** Invalid frequency. */
    public static final ErrorCode ERROR_5606_INVALID_FREQUENCY = new ErrorCode("5606");
    /** Origin airport code required. */
    public static final ErrorCode ERROR_5607_ORIGIN_AIRPORT_CODE_REQUIRED = new ErrorCode("5607");
    /** Origin airport invalid. */
    public static final ErrorCode ERROR_5608_ORIGIN_AIRPORT_INVALID = new ErrorCode("5608");
    /** Departure time required. */
    public static final ErrorCode ERROR_5609_DEPARTURE_TIME_REQUIRED = new ErrorCode("5609");
    /** Departure time invalid. */
    public static final ErrorCode ERROR_5610_DEPARTURE_TIME_INVALID = new ErrorCode("5610");
    /** Arrival time required. */
    public static final ErrorCode ERROR_5611_ARRIVAL_TIME_REQUIRED = new ErrorCode("5611");
    /** Arrival time invalid. */
    public static final ErrorCode ERROR_5612_ARRIVAL_TIME_INVALID = new ErrorCode("5612");
    /** Arrival airport code required. */
    public static final ErrorCode ERROR_5613_ARRIVAL_AIRPORT_CODE_REQUIRED = new ErrorCode("5613");
    /** Arrival airport invalid. */
    public static final ErrorCode ERROR_5614_ARRIVAL_AIRPORT_INVALID = new ErrorCode("5614");
    /** Flight already loaded. */
    public static final ErrorCode ERROR_5615_FLIGHT_SCHEDULE_ALREADY_LOADED = new ErrorCode("5615");
    /** PNR record locator invalid. */
    public static final ErrorCode ERROR_5616_PNR_RECORD_LOCATOR_INVALID = new ErrorCode("5616");
    /** Slash appears after the Expiry Date field, but should not. */
    public static final ErrorCode ERROR_5617_SLASH_APPEARS_AFTER_THE_EXPIRY_DATE_FIELD_BUT_SHOULD_NOT = new ErrorCode("5617");
    /** Slash appears after the Off Point field, but should not. */
    public static final ErrorCode ERROR_5618_SLASH_APPEARS_AFTER_THE_OFF_POINT_FIELD_BUT_SHOULD_NOT = new ErrorCode("5618");
    /** PNR record locator must be blank if PNR source is blank. */
    public static final ErrorCode ERROR_5619_PNR_RECORD_LOCATOR_MUST_BE_BLANK_IF_PNR_SOURCE_IS_BLANK = new ErrorCode("5619");
    /** Trans-border port country not consistent with int flight. */
    public static final ErrorCode ERROR_5620_TRANS_BORDER_PORT_COUNTRY_NOT_CONSISTENT_WITH_INT_FLIGHT = new ErrorCode("5620");
    /** Too many passenger data groups in message. */
    public static final ErrorCode ERROR_5621_TOO_MANY_PASSENGER_DATA_GROUPS_IN_MESSAGE = new ErrorCode("5621");
    /** Expected Flight not within origin or destination country. */
    public static final ErrorCode ERROR_5622_EXPECTED_FLIGHT_NOT_WITHIN_ORIGIN_OR_DESTINATION_COUNTRY = new ErrorCode("5622");
    /** Expected Flight not consistent with International Flight. */
    public static final ErrorCode ERROR_5623_EXPECTED_FLIGHT_NOT_CONSISTENT_WITH_INTERNATIONAL_FLIGHT = new ErrorCode("5623");
    /** Invalid flight type. */
    public static final ErrorCode ERROR_5624_INVALID_FLIGHT_TYPE = new ErrorCode("5624");
    /** Matching flight schedule not found. */
    public static final ErrorCode ERROR_5625_MATCHING_FLIGHT_SCHEDULE_NOT_FOUND = new ErrorCode("5625");
    /** Carrier code required. */
    public static final ErrorCode ERROR_5626_CARRIER_CODE_REQUIRED = new ErrorCode("5626");
    /** Invalid carrier code. */
    public static final ErrorCode ERROR_5627_INVALID_CARRIER_CODE_FORMAT = new ErrorCode("5627");
    /** No schedules found for carrier. */
    public static final ErrorCode ERROR_5628_NO_SCHEDULES_FOUND_FOR_CARRIER = new ErrorCode("5628");
    /** No schedules found for carrier. */
    public static final ErrorCode ERROR_5629_NEW_SCHEDULE_INCONSISTENT_WITH_EXISTING_SCHEDULE = new ErrorCode("5629");
    /** Invalid additional document flag. */
    public static final ErrorCode ERROR_5630_ADDITIONAL_DOC_FLAG_INVALID = new ErrorCode("5630");
    /** Invalid additional document type. */
    public static final ErrorCode ERROR_5631_ADDITIONAL_DOC_TYPE_INVALID = new ErrorCode("5631");
    /** Invalid document check character. */
    public static final ErrorCode ERROR_5632_DOCUMENT_CHECK_CHARACTER_INVALID = new ErrorCode("5632");
    /** invalid document issue date. */
    public static final ErrorCode ERROR_5633_DOCUMENT_ISSUE_DATE_INVALID = new ErrorCode("5633");
    /** Unable to perform an Interpol Check. */
    public static final ErrorCode ERROR_5640_UNABLE_TO_PERFORM_INTERPOL_CHECK = new ErrorCode("5640");
    /** Message does not contain valid manifest request. */
    public static final ErrorCode ERROR_5650_MESSAGE_DOES_NOT_CONTAIN_VALID_MANIFEST_REQUEST = new ErrorCode("5650");
    /** Country not origin or next country in which flight lands. */
    public static final ErrorCode ERROR_5651_COUNTRY_NOT_ORIGIN_OR_NEXT_COUNTRY_IN_WHICH_FLIGHT_LANDS = new ErrorCode("5651");
    /** Passenger manifest requirement invalid. */
    public static final ErrorCode ERROR_5652_PASSENGER_MANIFEST_REQUIREMENT_INVALID = new ErrorCode("5652");
    /** Crew manifest requirement invalid. */
    public static final ErrorCode ERROR_5653_CREW_MANIFEST_REQUIREMENT_INVALID = new ErrorCode("5653");
    /** Country does not require manifests of the specified type. */
    public static final ErrorCode ERROR_5654_COUNTRY_DOES_NOT_REQUIRE_MANIFESTS_OF_THE_SPECIFIED_TYPE = new ErrorCode("5654");
    /** Specified flight is not international flight. */
    public static final ErrorCode ERROR_5655_SPECIFIED_FLIGHT_IS_NOT_INTERNATIONAL_FLIGHT = new ErrorCode("5655");
    /** Country does not require manifests. */
    public static final ErrorCode ERROR_5656_COUNTRY_DOES_NOT_REQUIRE_MANIFESTS = new ErrorCode("5656");
    /** Airline not authorised to use message version. */
    public static final ErrorCode ERROR_5657_AIRLINE_NOT_AUTHORISED_TO_USE_MESSAGE_VERSION = new ErrorCode("5657");
    /** Invalid field count. */
    public static final ErrorCode ERROR_5658_INVALID_FIELD_COUNT = new ErrorCode("5658");
    /** Screen version not supported. */
    public static final ErrorCode ERROR_5659_SCREEN_VERSION_NOT_SUPPORTED = new ErrorCode("5659");
    /** Message does not contain valid manifest request. */
    public static final ErrorCode ERROR_5660_SCREEN_DOES_NOT_CONTAIN_VALID_MANIFEST_REQUEST = new ErrorCode("5660");
    /** Message does not contain valid date and time. */
    public static final ErrorCode ERROR_5670_INVALID_DATE_AND_TIME = new ErrorCode("5670");
    /** Message does not contain valid transaction id. */
    public static final ErrorCode ERROR_5671_INVALID_TRANSACTION_ID = new ErrorCode("5671");
    /** Message does not contain valid carrier type. */
    public static final ErrorCode ERROR_5672_INVALID_CARRIER_TYPE = new ErrorCode("5672");
    /** Message does not contain valid offset. */
    public static final ErrorCode ERROR_5680_INVALID_OFFSET_REQUESTED = new ErrorCode("5680");
    /** Message does not contain valid record lime. */
    public static final ErrorCode ERROR_5681_INVALID_RECORD_LIMIT_REQUESTED = new ErrorCode("5681");
    /** Message does not contain valid setting for total count. */
    public static final ErrorCode ERROR_5682_INVALID_SETTING_FOR_TOTAL_COUNT = new ErrorCode("5682");
    /** Message does not contain valid setting for total count. */
    public static final ErrorCode ERROR_5690_INVALID_MOVEMENT_TYPE = new ErrorCode("5690");
    /** Message does not contain valid setting for total count. */
    public static final ErrorCode ERROR_5691_INVALID_SETTING_FOR_INCLUDE_REPEATED_MOVEMENTS = new ErrorCode("5691");
    /** Valid country code required. */
    public static final ErrorCode ERROR_5702_VALID_COUNTRY_CODE_REQUIRED = new ErrorCode("5702");
    /** Invalid e-ticket number. */
    public static final ErrorCode ERROR_5714_INVALID_ETICKET_NUMBER = new ErrorCode("5714");

    /** Unscheduled Service Numbers Do Not Match. */
    public static final ErrorCode ERROR_5801_UNSCHEDULED_SERVICE_NUMBERS_DO_NOT_MATCH = new ErrorCode("5801");
    /** Unscheduled Origin Port Does Not Match. */
    public static final ErrorCode ERROR_5802_UNSCHEDULED_ORIGIN_PORT_DOES_NOT_MATCH = new ErrorCode("5802");
    /** Unscheduled Destination Port Does Not Match. */
    public static final ErrorCode ERROR_5803_UNSCHEDULED_DESTINATION_PORT_DOES_NOT_MATCH = new ErrorCode("5803");
    /** Unscheduled Departure Dates Do Not Match. */
    public static final ErrorCode ERROR_5804_UNSCHEDULED_DEPARTURE_DATES_TO_NOT_MATCH = new ErrorCode("5804");
    /** Unscheduled Service Number Missing. */
    public static final ErrorCode ERROR_5805_UNSCHEDULED_SERVICE_NUMBER_MISSING = new ErrorCode("5805");
    /** Unscheduled Service Number Invalid. */
    public static final ErrorCode ERROR_5806_UNSCHEDULED_SERVICE_NUMBER_INVALID = new ErrorCode("5806");
    /** Unscheduled Origin Port Missing. */
    public static final ErrorCode ERROR_5807_UNSCHEDULED_ORIGIN_PORT_MISSING = new ErrorCode("5807");
    /** Unscheduled Origin Port Invalid. */
    public static final ErrorCode ERROR_5808_UNSCHEDULED_ORIGIN_PORT_INVALID = new ErrorCode("5808");
    /** Unscheduled Destination Port Missing. */
    public static final ErrorCode ERROR_5809_UNSCHEDULED_DESTINATION_PORT_MISSING = new ErrorCode("5809");
    /** Unscheduled Destination Port Invalid. */
    public static final ErrorCode ERROR_5810_UNSCHEDULED_DESTINATION_PORT_INVALID = new ErrorCode("5810");
    /** Unscheduled Departure Date Missing. */
    public static final ErrorCode ERROR_5811_UNSCHEDULED_DEPARTURE_DATE_MISSING = new ErrorCode("5811");
    /** Unscheduled Departure Date Invalid. */
    public static final ErrorCode ERROR_5812_UNSCHEDULED_DEPARTURE_DATE_INVALID = new ErrorCode("5812");
    /** Unscheduled Departure Time Missing. */
    public static final ErrorCode ERROR_5813_UNSCHEDULED_DEPARTURE_TIME_MISSING = new ErrorCode("5813");
    /** Unscheduled Departure Time Invalid. */
    public static final ErrorCode ERROR_5814_UNSCHEDULED_DEPARTURE_TIME_INVALID = new ErrorCode("5814");
    /** Unscheduled Arrival Date Missing. */
    public static final ErrorCode ERROR_5815_UNSCHEDULED_ARRIVAL_DATE_MISSING = new ErrorCode("5815");
    /** Unscheduled Arrival Date Invalid. */
    public static final ErrorCode ERROR_5816_UNSCHEDULED_ARRIVAL_DATE_INVALID = new ErrorCode("5816");
    /** Unscheduled Arrival Time Missing. */
    public static final ErrorCode ERROR_5817_UNSCHEDULED_ARRIVAL_TIME_MISSING = new ErrorCode("5817");
    /** Unscheduled Arrival Time Invalid. */
    public static final ErrorCode ERROR_5818_UNSCHEDULED_ARRIVAL_TIME_INVALID = new ErrorCode("5818");
    /** Unscheduled Inconsistent Port Details. */
    public static final ErrorCode ERROR_5819_UNSCHEDULED_INCONSISTENT_PORT_DETAILS = new ErrorCode("5819");
    /** Unscheduled Inconsistent Date Details. */
    public static final ErrorCode ERROR_5820_UNSCHEDULED_INCONSISTENT_DATE_DETAILS = new ErrorCode("5820");

    /** Invalid of missing message header. */
    public static final ErrorCode ERROR_5821_INVALID_OR_MISSING_MESSAGE_HEADER = new ErrorCode("5821");
    /** Invalid of missing Header BGM. */
    public static final ErrorCode ERROR_5822_INVALID_OR_MISSING_BGM = new ErrorCode("5822");
    /** Invalid of missing Header RFF. */
    public static final ErrorCode ERROR_5823_INVALID_OR_MISSING_RFF_LEVEL_0 = new ErrorCode("5823");
    /** Invalid of missing Group 1 NAD, party point of contact. */
    public static final ErrorCode ERROR_5824_INVALID_OR_MISSING_PARTY_POINT_OF_CONTACT = new ErrorCode("5824");
    /** Invalid or missing Group 1 COM. */
    public static final ErrorCode ERROR_5825_INVALID_OR_MISSING_PARTY_CONTACT_DETAILS = new ErrorCode("5825");
    /** Invalid or Missing Transport Stage Code Qualifier Group 2 TDT. */
    public static final ErrorCode ERROR_5826_INVALID_OR_MISSING_TRANSPORT_STAGE_CODE_QUALIFIER = new ErrorCode("5826");
    /** Invalid or Missing Group 4 MEA. */
    public static final ErrorCode ERROR_5827_INVALID_OR_MISSING_MEA = new ErrorCode("5827");
    /** Invalid or Missing Trailer CNT. */
    public static final ErrorCode ERROR_5828_INVALID_OR_MISSING_CNT = new ErrorCode("5828");
    /** Invalid or Missing Trailer UNT. */
    public static final ErrorCode ERROR_5829_INVALID_OR_MISSING_UNT = new ErrorCode("5829");
    /** Invalid of missing Header Function code Qualifier for Passenger. */
    public static final ErrorCode ERROR_5830_INVALID_OR_MISSING_FUNCTION_CODE_QUALIFIER_FOR_PASSENGER = new ErrorCode("5830");
    /** Invalid or missing Group 5 DTM, travel document date. */
    public static final ErrorCode ERROR_5831_INVALID_OR_MISSING_DOCUMENT_DATE = new ErrorCode("5831");
    /** Invalid Communication Address Qualifier for Passengers COM Group 4 Passenger. */
    public static final ErrorCode ERROR_5832_INVALID_COMMUNICATION_ADDRESS_QUALIFIER_FOR_PASSENGERS = new ErrorCode("5832");
    /** Invalid Fax Number Group 4 COM :FX. */
    public static final ErrorCode ERROR_5833_INVALID_FAX_NUMBER = new ErrorCode("5833");
    /** Invalid or missing Group 1 COM, telephone number. */
    public static final ErrorCode ERROR_5834_INVALID_OR_MISSING_PARTY_POINT_OF_CONTACT_TELEPHONE = new ErrorCode("5834");
    /** Invalid or missing Group 1 COM, email address. */
    public static final ErrorCode ERROR_5835_INVALID_OR_MISSING_PARTY_POINT_OF_CONTACT_EMAIL = new ErrorCode("5835");
    /** Invalid or missing Group 1 COM, fax number. */
    public static final ErrorCode ERROR_5836_INVALID_OR_MISSING_PARTY_POINT_OF_CONTACT_FAX = new ErrorCode("5836");
    /** Invalid Government Agency Reference Number Group 4 RFF+AEA. */
    public static final ErrorCode ERROR_5837_INVALID_GOVERNMENT_AGENCY_REFERENCE_NUMBER = new ErrorCode("5837");
    /** Invalid Seat Number Group 4 RFF+SEA. */
    public static final ErrorCode ERROR_5838_INVALID_SEAT_NUMBER = new ErrorCode("5838");
    /** Invalid Baggage Details Group 4 FTX. */
    public static final ErrorCode ERROR_5839_INVALID_BAGGAGE_DETAILS = new ErrorCode("5839");
    /** Invalid Processing Information Code Group 4 GEI. */
    public static final ErrorCode ERROR_5840_INVALID_PROCESSING_INFORMATION_CODE = new ErrorCode("5840");
    /** Invalid or missing Group 5 COM, travel document. */
    public static final ErrorCode ERROR_5841_INVALID_OR_MISSING_TRAVEL_DOCUMENT = new ErrorCode("5841");
    /** Invalid or missing Group 4 LOC, clearance port. */
    public static final ErrorCode ERROR_5842_INVALID_OR_MISSING_CLEARANCE_PORT = new ErrorCode("5842");

    /** Topic not in system. */
    public static final ErrorCode ERROR_5995_TOPIC_NOT_IN_SYSTEM = new ErrorCode("5995");
    /** User help invalid action attempted. */
    public static final ErrorCode ERROR_5996_USER_HELP_MAINTENANCE_INVALID_ACTION = new ErrorCode("5996");
    /** User help invalid age number selected. */
    public static final ErrorCode ERROR_5997_USER_HELP_MAINTENANCE_INVALID_PAGE_NUMBER = new ErrorCode("5997");
    /** User help the required display screen was not submitted previously. */
    public static final ErrorCode ERROR_5998_USER_HELP_REQUIRED_SCREEN_NOT_SUBMITTED = new ErrorCode("5998");
    /** User help, password is invalid or missing. */
    public static final ErrorCode ERROR_5999_USER_HELP_PASSWORD_INAVLID_OR_MISSING = new ErrorCode("5999");


    //-----------------------------------------------------------------------
    //
    // The CGAP Error Codes.
    //
    //-----------------------------------------------------------------------
    /** Validation error - unknown field. */
    public static final ErrorCode ERROR_6000_VALIDATION_ERROR_UNKNOWN_FIELD = new ErrorCode("6000");
    /** Invalid family name format. */
    public static final ErrorCode ERROR_6001_INVALID_FAMILY_NAME_FORMAT = new ErrorCode("6001");
    /** Given names format invalid. */
    public static final ErrorCode ERROR_6002_GIVEN_NAMES_FORMAT_INVALID = new ErrorCode("6002");
    /** Invalid nationality code. */
    public static final ErrorCode ERROR_6003_INVALID_NATIONALITY_CODE = new ErrorCode("6003");
    /** Invalid sex code. */
    public static final ErrorCode ERROR_6004_INVALID_SEX_CODE = new ErrorCode("6004");
    /** Invalid visa type. */
    public static final ErrorCode ERROR_6005_INVALID_VISA_TYPE = new ErrorCode("6005");
    /** Invalid middle name. */
    public static final ErrorCode ERROR_6006_INVALID_MIDDLE_NAME = new ErrorCode("6006");
    /** Invalid airline code. */
    public static final ErrorCode ERROR_6007_INVALID_AIRLINE_CODE = new ErrorCode("6007");
    /** Invalid expiry date. */
    public static final ErrorCode ERROR_6009_INVALID_EXPIRY_DATE = new ErrorCode("6009");
    /** Invalid country code. */
    public static final ErrorCode ERROR_6010_INVALID_COUNTRY_CODE = new ErrorCode("6010");
    /** Invalid country code. */
    public static final ErrorCode ERROR_6011_EMAIL_ADDRESS_MANDATORY = new ErrorCode("6011");
    /** Invalid evidence number. */
    public static final ErrorCode ERROR_6013_INVALID_EVIDENCE_NUMBER = new ErrorCode("6013");
    /** Invalid date of birth. */
    public static final ErrorCode ERROR_6015_INVALID_DATE_OF_BIRTH = new ErrorCode("6015");
    /** Date of birth outside allowable range. */
    public static final ErrorCode ERROR_6016_DATE_OF_BIRTH_OUTSIDE_ALLOWABLE_RANGE = new ErrorCode("6016");
    /** Expiry date outside allowable range. */
    public static final ErrorCode ERROR_6017_EXPIRY_DATE_OUTSIDE_ALLOWABLE_RANGE = new ErrorCode("6017");
    /** Invalid arrival date. */
    public static final ErrorCode ERROR_6018_INVALID_ARRIVAL_DATE = new ErrorCode("6018");
    /** Arrival date outside allowable range. */
    public static final ErrorCode ERROR_6019_ARRIVAL_DATE_OUTSIDE_ALLOWABLE_RANGE = new ErrorCode("6019");
    /** Invalid country code for country of birth. */
    public static final ErrorCode ERROR_6020_INVALID_COUNTRY_CODE_FOR_COUNTRY_OF_BIRTH = new ErrorCode("6020");
    /** ETA not implemented for airline. */
    public static final ErrorCode ERROR_6022_ETA_NOT_IMPLEMENTED_FOR_AIRLINE = new ErrorCode("6022");
    /** Maximum number of dependents exceeded. */
    public static final ErrorCode ERROR_6029_MAXIMUM_NUMBER_OF_DEPENDENTS_EXCEEDED = new ErrorCode("6029");
    /** Invalid passport number format. */
    public static final ErrorCode ERROR_6033_INVALID_PASSPORT_NUMBER_FORMAT = new ErrorCode("6033");
    /** Invalid scroll direction. */
    public static final ErrorCode ERROR_6036_INVALID_SCROLL_DIRECTION = new ErrorCode("6036");
    /** Invalid scroll hours. */
    public static final ErrorCode ERROR_6037_INVALID_SCROLL_HOURS = new ErrorCode("6037");
    /** Invalid board airport code. */
    public static final ErrorCode ERROR_6039_INVALID_BOARD_AIRPORT_CODE = new ErrorCode("6039");
    /** Valid credit card holder name required. */
    public static final ErrorCode ERROR_6040_VALID_CREDIT_CARD_HOLDER_NAME_REQUIRED = new ErrorCode("6040");
    /** Valid credit card expiry date required. */
    public static final ErrorCode ERROR_6041_VALID_CREDIT_CARD_EXPIRY_DATE_REQUIRED = new ErrorCode("6041");
    /** Valid credit card number required. */
    public static final ErrorCode ERROR_6042_VALID_CREDIT_CARD_NUMBER_REQUIRED = new ErrorCode("6042");
    /** Currently in Australia. Ineligible to apply. */
    public static final ErrorCode ERROR_6043_CURRENTLY_IN_AUSTRALIA__INELIGIBLE_TO_APPLY = new ErrorCode("6043");
    /** Invalid movement type code. Must either be 'AP', ST- or IT-. */
    public static final ErrorCode ERROR_6045_INVALID_MOVEMENT_TYPE_CODE = new ErrorCode("6045");
    /** Check-in port required. */
    public static final ErrorCode ERROR_6046_INVALID_CHECK_IN_PORT = new ErrorCode("6046");
    /** Check-in flight required. */
    public static final ErrorCode ERROR_6047_CHECK_IN_FLIGHT_REQUIRED = new ErrorCode("6047");
    /** Check-in date invalid. */
    public static final ErrorCode ERROR_6048_CHECK_IN_DATE_INVALID = new ErrorCode("6048");
    /** Check-in time invalid. */
    public static final ErrorCode ERROR_6049_CHECK_IN_TIME_INVALID = new ErrorCode("6049");
    /** Trans-border port not a valid airport code. */
    public static final ErrorCode ERROR_6050_TRANS_BORDER_PORT_NOT_A_VALID_AIRPORT_CODE = new ErrorCode("6050");
    /** Trans-border flight not given. */
    public static final ErrorCode ERROR_6051_TRANS_BORDER_FLIGHT_NOT_GIVEN = new ErrorCode("6051");
    /** Trans-border date invalid. */
    public static final ErrorCode ERROR_6052_TRANS_BORDER_DATE_INVALID = new ErrorCode("6052");
    /** Trans-border time invalid. */
    public static final ErrorCode ERROR_6053_TRANS_BORDER_TIME_INVALID = new ErrorCode("6053");
    /** Expected port not a valid airport code. */
    public static final ErrorCode ERROR_6054_EXPECTED_PORT_NOT_A_VALID_AIRPORT_CODE = new ErrorCode("6054");
    /** Expected flight required. */
    public static final ErrorCode ERROR_6055_EXPECTED_FLIGHT_REQUIRED = new ErrorCode("6055");
    /** Expected date invalid. */
    public static final ErrorCode ERROR_6056_EXPECTED_DATE_INVALID = new ErrorCode("6056");
    /** Expected time invalid. */
    public static final ErrorCode ERROR_6057_EXPECTED_TIME_INVALID = new ErrorCode("6057");
    /** Passenger sequence number required. */
    public static final ErrorCode ERROR_6058_PASSENGER_SEQUENCE_NUMBER_REQUIRED = new ErrorCode("6058");
    /** Pax/Crew indicator invalid. Must either be 'P', 'C' or 'X' only. */
    public static final ErrorCode ERROR_6059_PAX_CREW_INDICATOR_INVALID = new ErrorCode("6059");
    /** Expected direction invalid. Must either be 'I', 'O' or 'T' only. */
    public static final ErrorCode ERROR_6060_INVALID_DIRECTION = new ErrorCode("6060");
    /** Supplementary document type invalid. */
    public static final ErrorCode ERROR_6061_SUPPLEMENTARY_DOCUMENT_TYPE_INVALID = new ErrorCode("6061");
    /** Travel document type invalid. */
    public static final ErrorCode ERROR_6062_TRAVEL_DOCUMENT_TYPE_INVALID = new ErrorCode("6062");
    /** Endorsement code invalid. Must either be ' ' (a space) or 'S'. */
    public static final ErrorCode ERROR_6063_ENDORSEMENT_CODE_INVALID_MUST_EITHER_BE_A_SPACE_OR_S = new ErrorCode("6063");
    /** Neither travel nor supplementary document information was sent. */
    public static final ErrorCode ERROR_6064_NEITHER_TRAVEL_NOR_SUPPLEMENTARY_DOCUMENT_INFORMATION_WAS_SENT = new ErrorCode("6064");
    /** Invalid multiple response flag. */
    public static final ErrorCode ERROR_6065_INVALID_MULTIPLE_RESPONSE_FLAG = new ErrorCode("6065");
    /** Invalid Print Arrival/Departure Card flag. */
    public static final ErrorCode ERROR_6066_INVALID_PRINT_ARRIVAL_DEPARTURE_CARD_FLAG = new ErrorCode("6066");
    /** Invalid User Id. */
    public static final ErrorCode ERROR_6067_INVALID_USER_ID = new ErrorCode("6067");
    /** Expected Passenger ID is null. */
    public static final ErrorCode ERROR_6068_EXPECTED_PASSENGER_ID_IS_NULL = new ErrorCode("6068");
    /** Expected Passenger ID is not numeric. */
    public static final ErrorCode ERROR_6069_EXPECTED_PASSENGER_ID_IS_NOT_NUMERIC = new ErrorCode("6069");
    /** Expected Passenger ID is not unique. */
    public static final ErrorCode ERROR_6070_EXPECTED_PASSENGER_ID_IS_NOT_UNIQUE = new ErrorCode("6070");
    /** Invalid transaction source flag. */
    public static final ErrorCode ERROR_6071_INVALID_TRANSACTION_SOURCE_FLAG = new ErrorCode("6071");
    /** Invalid departure port. */
    public static final ErrorCode ERROR_6072_INVALID_DEPARTURE_PORT = new ErrorCode("6072");
    /** Invalid departure flight. */
    public static final ErrorCode ERROR_6073_INVALID_DEPARTURE_FLIGHT = new ErrorCode("6073");
    /** Invalid departure date. */
    public static final ErrorCode ERROR_6074_INVALID_DEPARTURE_DATE = new ErrorCode("6074");
    /** Invalid departure time. */
    public static final ErrorCode ERROR_6075_INVALID_DEPARTURE_TIME = new ErrorCode("6075");
    /** Invalid issuing state code. */
    public static final ErrorCode ERROR_6076_INVALID_ISSUING_STATE_CODE = new ErrorCode("6076");
    /** Invalid transit flag. */
    public static final ErrorCode ERROR_6077_INVALID_TRANSFER_FLAG = new ErrorCode("6077");
    /** Invalid override flag. */
    public static final ErrorCode ERROR_6078_INVALID_OVERRIDE_FLAG = new ErrorCode("6078");
    /** Invalid international flight board point. */
    public static final ErrorCode ERROR_6079_INVALID_INTERNATIONAL_FLIGHT_BOARD_POINT = new ErrorCode("6079");
    /** Invalid international flight off point. */
    public static final ErrorCode ERROR_6080_INVALID_INTERNATIONAL_FLIGHT_OFF_POINT = new ErrorCode("6080");
    /** Invalid message version. */
    public static final ErrorCode ERROR_6081_INVALID_MESSAGE_VERSION = new ErrorCode("6081");
    /** Override code supplied not valid in these circumstances. */
    public static final ErrorCode ERROR_6082_OVERRIDE_CODE_SUPPLIED_NOT_VALID_IN_THESE_CIRCUMSTANCES = new ErrorCode("6082");
    /** Invalid travel document number and type combination. */
    public static final ErrorCode ERROR_6083_INVALID_TRAVEL_DOCUMENT_NUMBER_AND_TYPE_COMBINATION = new ErrorCode("6083");
    /** Invalid country of birth code used. */
    public static final ErrorCode ERROR_6084_INVALID_COUNTRY_OF_BIRTH_CODE_USED = new ErrorCode("6084");
    /** Invalid crew id. */
    public static final ErrorCode ERROR_6085_INVALID_CREW_ID = new ErrorCode("6085");
    /** Invalid crew rating. */
    public static final ErrorCode ERROR_6086_INVALID_CREW_RATING = new ErrorCode("6086");
    /** Invalid issuing state. */
    public static final ErrorCode ERROR_6087_INVALID_ISSUING_STATE = new ErrorCode("6087");
    /** Invalid date of issue. */
    public static final ErrorCode ERROR_6088_INVALID_DATE_OF_ISSUE = new ErrorCode("6088");
    /** Invalid issuing authority. */
    public static final ErrorCode ERROR_6089_INVALID_ISSUING_AUTHORITY = new ErrorCode("6089");
    /** Date of issue outside allowable range. */
    public static final ErrorCode ERROR_6090_DATE_OF_ISSUE_OUTSIDE_ALLOWABLE_RANGE = new ErrorCode("6090");
    /** Issuing state required for document type Other. */
    public static final ErrorCode ERROR_6091_ISSUING_STATE_REQUIRED_FOR_DOCUMENT_TYPE_OTHER = new ErrorCode("6091");
    /** Override not authorised. */
    public static final ErrorCode ERROR_6092_OVERRIDE_NOT_AUTHORISED = new ErrorCode("6092");
    /** Invalid domestic departure port. */
    public static final ErrorCode ERROR_6093_INVALID_DOMESTIC_DEPATURE_PORT = new ErrorCode("6093");
    /** Invalid domestic flight number. */
    public static final ErrorCode ERROR_6094_INVALID_DOMESTIC_SERVICE_NUM = new ErrorCode("6094");
    /** Invalid domestic departure date. */
    public static final ErrorCode ERROR_6095_INVALID_DOMESTIC_DEPARTURE_DATE = new ErrorCode("6095");
    /** Invalid domestic departure time. */
    public static final ErrorCode ERROR_6096_INVALID_DOMESTIC_DEPARTURE_TIME = new ErrorCode("6096");
    /** Invalid domestic arrival port. */
    public static final ErrorCode ERROR_6097_INVALID_DOMESTIC_ARRIVAL_PORT = new ErrorCode("6097");
    /** Invalid domestic arrival date. */
    public static final ErrorCode ERROR_6097_INVALID_DOMESTIC_ARRIVAL_DATE = new ErrorCode("6098");
    /** Invalid domestic arrival time. */
    public static final ErrorCode ERROR_6098_INVALID_DOMESTIC_ARRIVAL_TIME = new ErrorCode("6099");
    /** Expired card. */
    public static final ErrorCode ERROR_6100_EXPIRED_CARD = new ErrorCode("6100");
    /** Invalid card number. */
    public static final ErrorCode ERROR_6101_INVALID_CARD_NUMBER = new ErrorCode("6101");
    /** EFT currently unavailable. Try again later. */
    public static final ErrorCode ERROR_6102_EFT_CURRENTLY_UNAVAILABLE__TRY_AGAIN_LATER = new ErrorCode("6102");
    /** Credit card payment not authorised. */
    public static final ErrorCode ERROR_6103_CREDIT_CARD_PAYMENT_NOT_AUTHORISED = new ErrorCode("6103");
    /** Invalid selection for additional citizenship. */
    public static final ErrorCode ERROR_6104_INVALID_SELECTION_FOR_ADDITIONAL_CITIZENSHIP = new ErrorCode("6104");
    /** Required if other citizenship held. */
    public static final ErrorCode ERROR_6105_REQUIRED_IF_OTHER_CITIZENSHIP_HELD = new ErrorCode("6105");
    /** Must be blank if no other citizenship held. */
    public static final ErrorCode ERROR_6106_MUST_BE_BLANK_IF_NO_OTHER_CITIZENSHIP_HELD = new ErrorCode("6106");
    /** Invalid citizenship country code. */
    public static final ErrorCode ERROR_6107_INVALID_CITIZENSHIP_COUNTRY_CODE = new ErrorCode("6107");
    /** At least one address line is required. */
    public static final ErrorCode ERROR_6108_AT_LEAST_ONE_ADDRESS_LINE_IS_REQUIRED = new ErrorCode("6108");
    /** Address contains invalid characters. */
    public static final ErrorCode ERROR_6109_ADDRESS_CONTAINS_INVALID_CHARACTERS = new ErrorCode("6109");
    /** Invalid telephone country code. */
    public static final ErrorCode ERROR_6110_INVALID_TELEPHONE_COUNTRY_CODE = new ErrorCode("6110");
    /** Incomplete home telephone number. */
    public static final ErrorCode ERROR_6111_INCOMPLETE_HOME_TELEPHONE_NUMBER = new ErrorCode("6111");
    /** Invalid telephone area code. */
    public static final ErrorCode ERROR_6112_INVALID_TELEPHONE_AREA_CODE = new ErrorCode("6112");
    /** Invalid telephone number. */
    public static final ErrorCode ERROR_6113_INVALID_TELEPHONE_NUMBER = new ErrorCode("6113");
    /** Incomplete business telephone number. */
    public static final ErrorCode ERROR_6114_INCOMPLETE_BUSINESS_TELEPHONE_NUMBER = new ErrorCode("6114");
    /** Incomplete mobile telephone number. */
    public static final ErrorCode ERROR_6115_INCOMPLETE_MOBILE_TELEPHONE_NUMBER = new ErrorCode("6115");
    /** Email address contains invalid characters. */
    public static final ErrorCode ERROR_6116_EMAIL_ADDRESS_CONTAINS_INVALID_CHARACTERS = new ErrorCode("6116");
    /** Email address format invalid. */
    public static final ErrorCode ERROR_6117_EMAIL_ADDRESS_FORMAT_INVALID = new ErrorCode("6117");
    /** At least one telephone number is required. */
    public static final ErrorCode ERROR_6118_AT_LEAST_ONE_TELEPHONE_NUMBER_IS_REQUIRED = new ErrorCode("6118");
    /** Nationality or citizenship codes repeated. */
    public static final ErrorCode ERROR_6119_NATIONALITY_OR_CITIZENSHIP_CODES_REPEATED = new ErrorCode("6119");
    /** Email address required. */
    public static final ErrorCode ERROR_6120_EMAIL_ADDRESS_REQUIRED = new ErrorCode("6120");
    /** Invalid In-Country 1 port code. */
    public static final ErrorCode ERROR_6200_INVALID_IN_COUNTRY_1_PORT_CODE = new ErrorCode("6200");
    /** Invalid In-Country 1 date. */
    public static final ErrorCode ERROR_6201_INVALID_IN_COUNTRY_1_DATE = new ErrorCode("6201");
    /** Invalid In-Country 1 time. */
    public static final ErrorCode ERROR_6202_INVALID_IN_COUNTRY_1_TIME = new ErrorCode("6202");
    /** Invalid In-Country 2 port code. */
    public static final ErrorCode ERROR_6203_INVALID_IN_COUNTRY_2_PORT_CODE = new ErrorCode("6203");
    /** Invalid In-Country 2 date. */
    public static final ErrorCode ERROR_6204_INVALID_IN_COUNTRY_2_DATE = new ErrorCode("6204");
    /** Invalid In-Country 2 time. */
    public static final ErrorCode ERROR_6205_INVALID_IN_COUNTRY_2_TIME = new ErrorCode("6205");
    /** Invalid In-Country 3 port code. */
    public static final ErrorCode ERROR_6206_INVALID_IN_COUNTRY_3_PORT_CODE = new ErrorCode("6206");
    /** Invalid In-Country 3 date. */
    public static final ErrorCode ERROR_6207_INVALID_IN_COUNTRY_3_DATE = new ErrorCode("6207");
    /** Invalid In-Country 3 time. */
    public static final ErrorCode ERROR_6208_INVALID_IN_COUNTRY_3_TIME = new ErrorCode("6208");
    /** Invalid In-Country 4 port code. */
    public static final ErrorCode ERROR_6209_INVALID_IN_COUNTRY_4_PORT_CODE = new ErrorCode("6209");
    /** Invalid In-Country 4 date. */
    public static final ErrorCode ERROR_6210_INVALID_IN_COUNTRY_4_DATE = new ErrorCode("6210");
    /** Invalid In-Country 4 time. */
    public static final ErrorCode ERROR_6211_INVALID_IN_COUNTRY_4_TIME = new ErrorCode("6211");
    /** Invalid In-Country 5 port code. */
    public static final ErrorCode ERROR_6212_INVALID_IN_COUNTRY_5_PORT_CODE = new ErrorCode("6212");
    /** Invalid In-Country 5 date. */
    public static final ErrorCode ERROR_6213_INVALID_IN_COUNTRY_5_DATE = new ErrorCode("6213");
    /** Invalid In-Country 5 time. */
    public static final ErrorCode ERROR_6214_INVALID_IN_COUNTRY_5_TIME = new ErrorCode("6214");
    /** Invalid Pax Manifest flag. */
    public static final ErrorCode ERROR_6215_INVALID_PAX_MANIFEST_FLAG = new ErrorCode("6215");
    /** Invalid Crew Manifest flag. */
    public static final ErrorCode ERROR_6216_INVALID_CREW_MANIFEST_FLAG = new ErrorCode("6216");
    /** Inbound - Trans-border and In-Country 1 details do not match. */
    public static final ErrorCode ERROR_6217_INBOUND_TRANS_BORDER_AND_IN_COUNTRY_1_DETAILS_DO_NOT_MATCH = new ErrorCode("6217");
    /** Manifest not found. */
    public static final ErrorCode ERROR_6218_MANIFEST_NOT_FOUND = new ErrorCode("6218");
    /** Outbound - Trans-border and last In-Country details do not match. */
    public static final ErrorCode ERROR_6219_OUTBOUND_TRANS_BORDER_AND_LAST_IN_COUNTRY_DETAILS_DO_NOT_MATCH = new ErrorCode("6219");
    /** Invalid Flight Origin Port Code. */
    public static final ErrorCode ERROR_6220_INVALID_FLIGHT_ORIGIN_PORT_CODE = new ErrorCode("6220");
    /** Foreign port not a valid airport code. */
    public static final ErrorCode ERROR_6221_FOREIGN_PORT_NOT_A_VALID_AIRPORT_CODE = new ErrorCode("6221");
    /** Foreign date invalid. */
    public static final ErrorCode ERROR_6222_FOREIGN_DATE_INVALID = new ErrorCode("6222");
    /** Foreign time invalid. */
    public static final ErrorCode ERROR_6223_FOREIGN_TIME_INVALID = new ErrorCode("6223");
    /** Invalid Passenger Redress Number. */
    public static final ErrorCode ERROR_6224_INVALID_PASSENGER_REDRESS_NUMBER = new ErrorCode("6224");
    /** Invalid PNR Locator. */
    public static final ErrorCode ERROR_6225_INVALID_PNR_LOCATOR = new ErrorCode("6225");
    /** Invalid PNR Source. */
    public static final ErrorCode ERROR_6226_INVALID_PNR_SOURCE = new ErrorCode("6226");
    /** Invalid Passenger Reference. */
    public static final ErrorCode ERROR_6227_INVALID_PASSENGER_REFERENCE = new ErrorCode("6227");
    /** Invalid Known Traveller Number. */
    public static final ErrorCode ERROR_6228_INVALID_KNOWN_TRAVELLER_NUMBER = new ErrorCode("6228");
    /** Invalid Page Reference. */
    public static final ErrorCode ERROR_6229_INVALID_PAGE_REFERENCE = new ErrorCode("6229");
    /** Selected Manifest Request Option not supported. */
    public static final ErrorCode ERROR_6230_SELECTED_MANIFEST_REQUEST_OPTION_NOT_SUPPORTED = new ErrorCode("6230");
    /** No movements found for this flight. */
    public static final ErrorCode ERROR_6231_NO_MOVEMENTS_FOUND_FOR_THIS_FLIGHT = new ErrorCode("6231");
    /** Invalid Last Foreign Port code. */
    public static final ErrorCode ERROR_6232_INVALID_LAST_FOREIGN_PORT_CODE = new ErrorCode("6232");
    /** Invalid Last Foreign Country code. */
    public static final ErrorCode ERROR_6233_INVALID_LAST_FOREIGN_COUNTRY_CODE = new ErrorCode("6233");
    /** Invalid flight segment. */
    public static final ErrorCode ERROR_6234_INVALID_FLIGHT_SEGMENT = new ErrorCode("6234");
    /** Valid agent logon required. */
    public static final ErrorCode ERROR_6240_VALID_AGENT_LOGON_REQUIRED = new ErrorCode("6240");
    /** Invalid other name selection. */
    public static final ErrorCode ERROR_6241_INVALID_OTHER_NAME_SELECTION = new ErrorCode("6241");
    /** Invalid criminal conviction selection. */
    public static final ErrorCode ERROR_6242_INVALID_CRIMINAL_CONVICTION_SELECTION = new ErrorCode("6242");
    /** Invalid national id format. */
    public static final ErrorCode ERROR_6243_INVALID_NATIONAL_ID_FORMAT = new ErrorCode("6243");
    /** Invalid selection for communication. */
    public static final ErrorCode ERROR_6244_INVALID_SELECTION_FOR_COMMUNICATION = new ErrorCode("6244");
    /** Valid IP Address required. */
    public static final ErrorCode ERROR_6245_VALID_IP_ADDRESS_REQUIRED = new ErrorCode("6245");
    /** Applicants current location is required. */
    public static final ErrorCode ERROR_6246_APPLICANT_CURRENT_LOCATION_REQUIRED = new ErrorCode("6246");
    /** National id required for nationality. */
    public static final ErrorCode ERROR_6247_NATIONAL_ID_REQUIRED_FOR_NATIONALITY = new ErrorCode("6247");
    /** Invalid other document number. */
    public static final ErrorCode ERROR_6250_INVALID_OTHER_DOCUMENT_NUMBER = new ErrorCode("6250");
    /** Invalid other nationality code. */
    public static final ErrorCode ERROR_6251_INVALID_OTHER_NATIONALITY_CODE = new ErrorCode("6251");
    /** Invalid other issuing state. */
    public static final ErrorCode ERROR_6252_INVALID_OTHER_ISSUING_STATE = new ErrorCode("6252");
    /** Invalid other issuing date. */
    public static final ErrorCode ERROR_6253_INVALID_OTHER_ISSUING_DATE = new ErrorCode("6253");
    /** Invalid other expiry date. */
    public static final ErrorCode ERROR_6254_INVALID_OTHER_EXPIRY_DATE = new ErrorCode("6254");
    /** Invalid other family name. */
    public static final ErrorCode ERROR_6255_INVALID_OTHER_FAMILY_NAME = new ErrorCode("6255");
    /** Invalid other given name. */
    public static final ErrorCode ERROR_6256_INVALID_OTHER_GIVEN_NAME = new ErrorCode("6256");
    /** Invalid other birth date. */
    public static final ErrorCode ERROR_6257_INVALID_OTHER_BIRTH_DATE = new ErrorCode("6257");
    /** Invalid other sex code. */
    public static final ErrorCode ERROR_6258_INVALID_OTHER_SEX_CODE = new ErrorCode("6258");
    /** Other expiry date outside allowable range. */
    public static final ErrorCode ERROR_6259_OTHER_EXPIRY_DATE_OUTSIDE_ALLOWABLE_RANGE = new ErrorCode("6259");
    /** Invalid alias family name. */
    public static final ErrorCode ERROR_6260_INVALID_ALIAS_FAMILY_NAME = new ErrorCode("6260");
    /** Invalid alias given name. */
    public static final ErrorCode ERROR_6261_INVALID_ALIAS_GIVEN_NAME = new ErrorCode("6261");
    /** Invalid alias sex code. */
    public static final ErrorCode ERROR_6262_INVALID_ALIAS_SEX_CODE = new ErrorCode("6262");
    /** Invalid alias effective date. */
    public static final ErrorCode ERROR_6263_INVALID_ALIAS_EFFECTIVE_DATE = new ErrorCode("6263");
    /** Invalid alias reason. */
    public static final ErrorCode ERROR_6264_INVALID_ALIAS_REASON = new ErrorCode("6264");
    /** Active Check-in transaction already exists for this document. */
    public static final ErrorCode ERROR_6270_ACTIVE_CHECK_IN_TRANSACTION_ALREADY_EXISTS_FOR_THIS_DOCUMENT = new ErrorCode("6270");
    /** Internal KIS Server Error. */
    public static final ErrorCode ERROR_6300_INTERNAL_KIS_SERVER_ERROR = new ErrorCode("6300");
    /** No valid status for passenger. */
    public static final ErrorCode ERROR_6400_NO_VALID_STATUS_FOR_PASSENGER = new ErrorCode("6400");
    /** No response from government system. Please try again later. */
    public static final ErrorCode ERROR_6879_NO_RESPONSE_FROM_APPLICATION_PROCESSOR = new ErrorCode("6879");
    /** AP Access Denied. */
    public static final ErrorCode ERROR_6888_AP_ACCESS_DENIED = new ErrorCode("6888");
    /** System maintenance in progress. Please try again later. */
    public static final ErrorCode ERROR_6900_SYSTEM_MAINTENANCE_IN_PROGRESS__PLEASE_TRY_AGAIN_LATER = new ErrorCode("6900");
    /** Message Type 1, Subtype 2. Agency cannot reverse an application it did not make. */
    public static final ErrorCode ERROR_6901_MESSAGE_TYPE_1_SUBTYPE_2_AGENCY_CANNOT_REVERSE_AN_APPLICATION_IT_DID_NOT_MAKE = new ErrorCode("6901");
    /** Invalid message format. Error code 2 will be the field number in error. */
    public static final ErrorCode ERROR_6910_INVALID_MESSAGE_FORMAT = new ErrorCode("6910");
    /** Unknown AP error - Error number not known. */
    public static final ErrorCode ERROR_6920_UNKNOWN_AP_ERROR_ERROR_NUMBER_NOT_KNOWN = new ErrorCode("6920");
    /** Invalid Passenger Address City. */
    public static final ErrorCode ERROR_6921_INVALID_PASSENGER_ADDRESS_CITY = new ErrorCode("6921");
    /** Invalid Passenger Address Postal Code. */
    public static final ErrorCode ERROR_6922_INVALID_PASSENGER_ADDRESS_POSTAL_CODE = new ErrorCode("6922");
    /** Invalid Passenger Address State. */
    public static final ErrorCode ERROR_6923_INVALID_PASSENGER_ADDRESS_STATE = new ErrorCode("6923");
    /** Invalid Passenger Address Street. */
    public static final ErrorCode ERROR_6924_INVALID_PASSENGER_ADDRESS_STREET = new ErrorCode("6924");
    /** Invalid country of residence. */
    public static final ErrorCode ERROR_6930_INVALID_COUNTRY_OF_RESIDENCE = new ErrorCode("6930");
    /** Invalid country of issuance. */
    public static final ErrorCode ERROR_6931_INVALID_COUNTRY_OF_ISSUANCE = new ErrorCode("6931");
    /** Invalid additional travel document type. */
    public static final ErrorCode ERROR_6932_INVALID_ADDITIONAL_TRAVEL_DOCUMENT_TYPE = new ErrorCode("6932");
    /** Invalid additional travel document expiry date. */
    public static final ErrorCode ERROR_6933_INVALID_ADDITIONAL_TRAVEL_DOCUMENT_EXPIRY_DATE = new ErrorCode("6933");
    /** Invalid passenger itinerary. */
    public static final ErrorCode ERROR_6934_INVALID_PASSENGER_ITINERARY = new ErrorCode("6934");
    /** Invalid document issue date. */
    public static final ErrorCode ERROR_6941_INVALID_DOCUMENT_ISSUE_DATE = new ErrorCode("6941");
    /** Invalid additional travel document number. */
    public static final ErrorCode ERROR_6942_INVALID_ADDITIONAL_TRAVEL_DOCUMENT_NUMBER = new ErrorCode("6942");
    /** Invalid additional travel document number issuing country. */
    public static final ErrorCode ERROR_6943_INVALID_ADDITIONAL_TRAVEL_DOCUMENT_ISSUING_COUNTRY = new ErrorCode("6943");
    /** Invalid or missing eticket number. */
    public static final ErrorCode ERROR_6950_INVALID_ETICKET_NUMBER = new ErrorCode("6950");
    /** Nationality ineligible for ETA. */
    public static final ErrorCode ERROR_6970_NATIONALITY_INELIGIBLE_FOR_ETA = new ErrorCode("6970");
    /** Nationality ineligible for ETA Type of Travel. */
    public static final ErrorCode ERROR_6971_NATIONALITY_INELIGIBLE_FOR_ETA_TYPE_OF_TRAVEL = new ErrorCode("6971");
    /** Sea crew may not apply for CTA. */
    public static final ErrorCode ERROR_6972_SEA_CREW_MAY_NOT_APPLY_FOR_CTA = new ErrorCode("6972");
    /** Sea crew already holds MCV. */
    public static final ErrorCode ERROR_6973_SEA_CREW_ALREADY_HOLDS_MCV = new ErrorCode("6973");
    /** ETA not required for applicants with Australian passport. */
    public static final ErrorCode ERROR_6974_ETA_NOT_REQUIRED_FOR_APPLICANTS_WITH_AUSTRALIAN_PASSPORT = new ErrorCode("6974");
    /** Nationality ineligible for CTA. */
    public static final ErrorCode ERROR_6975_NATIONALITY_INELIGIBLE_FOR_CTA = new ErrorCode("6975");
    /** System error with alert check. */
    public static final ErrorCode ERROR_6978_SYSTEM_ERROR_WITH_ALERT_CHECK = new ErrorCode("6978");
    /** No response from government system. Please try again later. */
    public static final ErrorCode ERROR_6979_NO_RESPONSE_FROM_GOVERNMENT_SYSTEM = new ErrorCode("6979");
    /** Duplicate Message ID. */
    public static final ErrorCode ERROR_6980_DUPLICATE_MESSAGE_ID = new ErrorCode("6980");
    /** Unknown Message Type/Sub-type. */
    public static final ErrorCode ERROR_6981_UNKNOWN_MESSAGE_TYPE_SUB_TYPE = new ErrorCode("6981");
    /** Message ID active. Need to use previous logical transaction Message ID. */
    public static final ErrorCode ERROR_6982_MESSAGE_ID_ACTIVE_NEED_TO_USE_PREVIOUS_LOGICAL_TRANSACTION_MESSAGE_ID = new ErrorCode("6982");
    /** Invalid Message ID. Need to use previous logical transaction Message Id. */
    public static final ErrorCode ERROR_6983_INVALID_MESSAGE_ID = new ErrorCode("6983");
    /** System error with alert check. */
    public static final ErrorCode ERROR_6984_SYSTEM_ERROR_WITH_ALERT_CHECK = new ErrorCode("6984");
    /** Duplicate Message ID. Message ID has been used by another User. */
    public static final ErrorCode ERROR_6985_DUPLICATE_MESSAGE_ID = new ErrorCode("6985");
    /** Not an ETA application. */
    public static final ErrorCode ERROR_6986_NOT_AN_ETA_APPLICATION = new ErrorCode("6986");
    /** No History or scrolling outside range. */
    public static final ErrorCode ERROR_6987_NO_HISTORY_OR_SCROLLING_OUTSIDE_RANGE = new ErrorCode("6987");
    /** Too many pax in transaction. */
    public static final ErrorCode ERROR_6988_TOO_MANY_PAX_IN_TRANSACTION = new ErrorCode("6988");
    /** History details - no corresponding ETA. */
    public static final ErrorCode ERROR_6989_HISTORY_DETAILS_NO_CORRESPONDING_ETA = new ErrorCode("6989");
    /** Arrival date outside range for visa class. */
    public static final ErrorCode ERROR_6990_ARRIVAL_DATE_OUTSIDE_RANGE_FOR_VISA_CLASS = new ErrorCode("6990");
    /** Passport expires before intended arrival date. */
    public static final ErrorCode ERROR_6991_PASSPORT_EXPIRES_BEFORE_INTENDED_ARRIVAL_DATE = new ErrorCode("6991");
    /** Credit card transaction reversal error. */
    public static final ErrorCode ERROR_6992_CREDIT_CARD_TRANSACTION_REVERSAL_ERROR = new ErrorCode("6992");
    /** Message Type 1, Subtype 2. Credit card manager error. */
    public static final ErrorCode ERROR_6993_MESSAGE_TYPE_1_SUBTYPE_2_CREDIT_CARD_MANAGER_ERROR = new ErrorCode("6993");
    /** Message Type 2, Subtype 3. Credit card manager error. */
    public static final ErrorCode ERROR_6994_MESSAGE_TYPE_2_SUBTYPE_3_CREDIT_CARD_MANAGER_ERROR = new ErrorCode("6994");
    /** Message Type 2, Subtype 3. Application does not require payment. */
    public static final ErrorCode ERROR_6995_MESSAGE_TYPE_2_SUBTYPE_3_APPLICATION_DOES_NOT_REQUIRE_PAYMENT = new ErrorCode("6995");
    /** Message Type 1, Subtype 2. Credit card manager error. */
    public static final ErrorCode ERROR_6996_MESSAGE_TYPE_1_SUBTYPE_2_CREDIT_CARD_MANAGER_ERROR = new ErrorCode("6996");
    /** Message Type 2, Subtype 2. Cannot grant ETA for this application. */
    public static final ErrorCode ERROR_6997_MESSAGE_TYPE_2_SUBTYPE_2_CANNOT_GRANT_ETA_FOR_THIS_APPLICATION = new ErrorCode("6997");
    /** AP Error: PRO*C Failed. */
    public static final ErrorCode ERROR_6998_AP_ERROR_PRO_C_FAILED = new ErrorCode("6998");
    /** AP Error: PL-SQL Failed. */
    public static final ErrorCode ERROR_6999_AP_ERROR_PL_SQL_FAILED = new ErrorCode("6999");
    /** Insufficient API data required. */
    public static final ErrorCode ERROR_7001_INSUFFICIENT_API_DATA_REQUIRED = new ErrorCode("7001");
    /** Origin or destination airport code not found. */
    public static final ErrorCode ERROR_7002_AIRPORT_CODE_NOT_FOUND = new ErrorCode("7002");

    //-----------------------------------------------------------------------
    /**
     * Private constructor.
     *
     * @param code  The error code.
     */
    private ErrorCode(final String code) {
        super(code);
        add(code);
    }

    /**
     * Adds the constructed instance to the value set.
     *
     * @param code  The code to add.
     */
    private void add(final String code) {
        if (VALUES.get(code) == null) {
            VALUES.remove(code);
            VALUES.put(code, this);
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Gets the error code.
     *
     * @return  The error code.
     */
    public String getErrorCode() {
        return getName();
    }

    //-----------------------------------------------------------------------
    /**
     * Gets an error code enum for an error code string.
     *
     * @param errorCode  The error code.
     * @return  The enum error code.
     */
    public static ErrorCode getErrorCode(final String errorCode) {
        if (StringUtils.isEmpty(errorCode)) {
            return null;
        }

        ErrorCode code = VALUES.get(errorCode);

        if (code == null && StringUtils.isNumeric(errorCode)) {
            code = new ErrorCode(errorCode);
        }
        return code;
    }

    //-----------------------------------------------------------------------
    /**
     * Creates a new error code.
     *
     * @param name  The name of the error code.
     * @return The error code.
     */
    public static ErrorCode createInstance(final String name) {

        // If we have a name in the form of "ERROR_<code>_BLAH_BLAH_BLAH", trim
        // out the <code> part to use:
        String code = name;
        if (StringUtils.isNumeric(code) == false && StringUtils.startsWith(code, "ERROR_")) {
            code = StringUtils.substringAfter(code, "ERROR_");

            if (StringUtils.contains(code, "_")) {
                code = StringUtils.substringBefore(code, "_");
            }
        }

        ErrorCode error = getErrorCode(code);

        if (error != null) {
            return error;
        }

        return new ErrorCode(name);
    }
}
