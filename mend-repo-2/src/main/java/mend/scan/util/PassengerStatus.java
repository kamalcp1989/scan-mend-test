/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2001-2022
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.util;

import java.util.HashMap;
import java.util.Map;

/**
 * An enumeration to represent the passenger's status.
 */

public enum PassengerStatus {

    //-----------------------------------------------------------------------
    // Internal passenger status:
    /** Passenger created status. */
    PASSENGER_CREATED("PC", "PASSENGER_CREATED", false, false, 0),

    //-----------------------------------------------------------------------
    // Internal passenger status's:
    /** Passenger created status. */
    PRE_CHECKED_IN("PC", "PRE_CHECKED_IN", false, false, 0),
    /** Passenger created status. */
    CHECKED_IN("PC", "CHECKED_IN", false, false, 0),

    /** Batch queued. */
    QUEUED("Q", "QUEUED", false, false, 0),

    //-----------------------------------------------------------------------
    // Status's that we can report back to the carrier:
    /** OK to board status. */
    OK_TO_BOARD("B", "OK_TO_BOARD", true, false, 0),
    /** Advisory Selectee. Boarding pass may be issued.*/
    ADVISORY_SELECTEE("B", "ADVISORY_SELECTEE", true, false, 1),
    /** Not OK to board (Can be overridden). */
    DO_NOT_BOARD("D", "DO_NOT_BOARD", true, false, 2),
    /** Passenger has been cancelled. */
    CANCELLED("C", "CANCELLED", true, false, 4),
    /** Not OK to board (cannot be overridden). */
    BORDER_CLOSED("X", "BORDER CLOSED", true, false, 3),
    /** Unable to determine status of passenger. */
    UNABLE_TO_DETERMINE_STATUS("U", "UNABLE_TO_DETERMINE_STATUS", true, false, 2),
    /** Required data is incomplete. */
    REQUIRED_DATA_INCOMPLETE("I", "REQUIRED_DATA_INCOMPLETE", true, false, 2),
    /** Passenger has been cancelled. */
    FLIGHT_CANCELLED("FC", "FLIGHT_CANCELLED", false, false, 4),
    /** Passenger not found. */
    NOT_FOUND("N", "NOT_FOUND", true, false, 4),
    /** A timeout has occurred. */
    TIMEOUT("T", "TIMEOUT", true, false, 4),
    /** An error has occurred. */
    ERROR("E", "ERROR", true, false, 4),
    /** Archive status, can this be removed? */
    ARCHIVE("A", "ARCHIVE", true, false, 4),

    //-----------------------------------------------------------------------
    // Passenger update pending status's:
    /** Pending a status. */
    PENDING("P", "PENDING", false, true, 4),
    /** The informational update is complete. */
    INFORMATION_UPDATE_COMPLETE("P", "INFORMATION_UPDATE_COMPLETE", false, false, 4),
    /** Pending on a informational update. */
    INFORMATION_UPDATE_PENDING("P", "INFORMATION_UPDATE_PENDING", false, true, INFORMATION_UPDATE_COMPLETE, 4),
    /**
     * Pending on a qualified update. Note: there is
     * no qualified update complete status as  this is the
     * status as returned from the government.
     */
    QUALIFIED_UPDATE_PENDING("P", "QUALIFIED_UPDATE_PENDING", false, true, 4),
    /** An itinerary change cancellation is complete. */
    ITINERARY_CHANGE_CANCEL_COMPLETE("P", "ITINERARY_CHANGE_CANCEL_COMPLETE", false, false, 4),
    /** An itinerary change is pending. */
    ITINERARY_CHANGE_CANCEL_PENDING("P", "ITINERARY_CHANGE_CANCEL_PENDING", false, true, ITINERARY_CHANGE_CANCEL_COMPLETE, 4),

    /** No change in data has been detected. */
    NO_CHANGE_IN_DATA("N", "NO_CHANGE_IN_DATA", false, false, 4),

    /** A pre-check in request has been received after the passenger has been checked in. */
    IGNORE_PRE_CHECK_IN("N", "IGNORE_PRE_CHECK_IN", false, false, 4),

    //-----------------------------------------------------------------------
    // Passenger cancellation pending status's:
    /** Cancel pending. */
    CANCEL_PENDING("CP", "CANCEL_PENDING", false, true, CANCELLED, 4),
    /** Cancel reservation pending. */
    CANCEL_RESERVATION_PENDING("CRP", "CANCEL_RESERVATION_PENDING", false, true, CANCELLED, 4),
    /** Cancel reservation pending. */
    REDUCTION_IN_PARTY_COMPLETE("RIPC", "REDUCTION_IN_PARTY_COMPLETE", false, false, 4),
    /** Cancel reservation pending. */
    REDUCTION_IN_PARTY_PENDING("RIPP", "REDUCTION_IN_PARTY_PENDING", false, true, REDUCTION_IN_PARTY_COMPLETE, 4),

    //-----------------------------------------------------------------------
    // Taiwan status:
    /** Duplicate passenger. */
    DUPLICATE_PASSENGER("E", "DUPLICATE_PASSENGER", false, false, 4),

    //-----------------------------------------------------------------------
    // Internal passenger status:
    /** Cancel pending. */
    GOVERNMENT_OVERRIDE("GO", "GOVERNMENT_OVERRIDE", false, false, 4),

    /** Cancelled as part of the flight close process. */
    CANCELLED_ON_FLIGHT_CLOSE("COC", "CANCELLED_ON_FLIGHT_CLOSE", false, false, 4),

    //-----------------------------------------------------------------------
    // Batch APIS status's:
    /** Stored in the database. */
    STORED("S", "STORED", false, false, 4);

    //-----------------------------------------------------------------------
    /** The status code. */
    private String statusCode;

    /** The name of the status. */
    private String uniqueName;

    /**
     * The precedence value. i.e. a status with a higher value will take precedence of one with a lower value.
     * This will be used when splitting and combining messages to give the worst case scenario.
     */
    private int precendence;

    /** Is the passenger status reportable. */
    private boolean reportable;

    /** Is this status a pending status. */
    private boolean pending;

    /** The complete status. */
    private PassengerStatus completeStatus;

    //-----------------------------------------------------------------------
    /** Map of status's by their unique name. */
    private static final Map<String, PassengerStatus> STATUS_MAP = new HashMap<>();

    static {
        for (PassengerStatus status : PassengerStatus.values()) {
            STATUS_MAP.put(status.getUniqueName(), status);
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Private constructor.
     *
     * @param statusCode  The status code.
     * @param name  The unique name of the status code.
     * @param reportable  The reportable flag.
     * @param pending  Is this  a pending status
     * @param precedence  The precedence value.
     */
    PassengerStatus(
            final String statusCode,
            final String name,
            final boolean reportable,
            final boolean pending,
            final int precedence) {
        this.statusCode = statusCode;
        this.uniqueName = name;
        this.reportable = reportable;
        this.precendence = precedence;
        this.pending = pending;
    }

    //-----------------------------------------------------------------------
    /**
     * Private constructor.
     *
     * @param statusCode  The status code.
     * @param name  The unique name of the status code.
     * @param reportable  The reportable flag.
     * @param pending  Is this  a pending status
     * @param completedStatus  The completed status.
     * @param precedence  The precedence value.
     */
    PassengerStatus(
            final String statusCode,
            final String name,
            final boolean reportable,
            final boolean pending,
            final PassengerStatus completedStatus,
            final int precedence) {
        this.statusCode = statusCode;
        this.uniqueName = name;
        this.reportable = reportable;
        this.precendence = precedence;
        this.completeStatus = completedStatus;
        this.pending = pending;
    }

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
    public int compare(final PassengerStatus status) {
        if (precendence < status.precendence) {
            return -1;
        } else if (precendence > status.precendence) {
            return 1;
        } else {
            return 0;
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Gets a passenger status from a given status string.
     *
     * @param statusCode  The status code.
     * @return  The passenger status for the given code.
     */
    public static PassengerStatus getPassengerStatus(final String statusCode) {
        if ("B".equals(statusCode)) {
            return OK_TO_BOARD;
        } else if ("D".equals(statusCode)) {
            return DO_NOT_BOARD;
        } else if ("X".equals(statusCode)) {
            return BORDER_CLOSED;
        } else if ("U".equals(statusCode)) {
            return UNABLE_TO_DETERMINE_STATUS;
        } else if ("I".equals(statusCode)) {
            return REQUIRED_DATA_INCOMPLETE;
        } else if ("C".equals(statusCode)) {
            return CANCELLED;
        } else if ("N".equals(statusCode)) {
            return NOT_FOUND;
        } else if ("T".equals(statusCode)) {
            return TIMEOUT;
        } else if ("E".equals(statusCode)) {
            return ERROR;
        } else if ("A".equals(statusCode)) {
            return ARCHIVE;
        } else if ("P".equals(statusCode)) {
            return PENDING;
        } else {
            // Throw an error here?!?!
            return null;
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Gets a passenger status from a given status string.
     *
     * @param statusCode  The status code.
     * @return  The passenger status for the given code.
     */
    public static PassengerStatus getPassengerStatus(final char statusCode) {
        switch (statusCode) {
            case 'B':
                return OK_TO_BOARD;
            case 'D':
                return DO_NOT_BOARD;
            case 'X':
                return BORDER_CLOSED;
            case 'U':
                return UNABLE_TO_DETERMINE_STATUS;
            case 'I':
                return REQUIRED_DATA_INCOMPLETE;
            case 'C':
                return CANCELLED;
            case 'N':
                return NOT_FOUND;
            case 'T':
                return TIMEOUT;
            case 'E':
                return ERROR;
            case 'A':
                return ARCHIVE;
            case 'P':
                return PENDING;
            default:
                // Throw an error here?!?!
                return null;
        }
    }

    //-----------------------------------------------------------------------
    /**
     * Gets a passenger status by it's unique name.
     *
     * @param name  The name of the status to retrieve.
     * @return  The status or null if not found.
     */
    public static PassengerStatus getByUniqueName(final String name) {
        return STATUS_MAP.get(name);
    }

    /**
     * Gets a passenger status name handling null.
     * @param status  The passenger status.
     * @return  The name, or null if status is null.
     */
    public static String getUniqueNameHandlingNull(final PassengerStatus status) {
        if (status != null) {
            return status.getUniqueName();
        }

        return null;
    }

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getUniqueName() {
		return uniqueName;
	}

	public void setUniqueName(String uniqueName) {
		this.uniqueName = uniqueName;
	}

	public int getPrecendence() {
		return precendence;
	}

	public void setPrecendence(int precendence) {
		this.precendence = precendence;
	}

	public boolean isReportable() {
		return reportable;
	}

	public void setReportable(boolean reportable) {
		this.reportable = reportable;
	}

	public boolean isPending() {
		return pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

	public PassengerStatus getCompleteStatus() {
		return completeStatus;
	}

	public void setCompleteStatus(PassengerStatus completeStatus) {
		this.completeStatus = completeStatus;
	}

	public static Map<String, PassengerStatus> getStatusMap() {
		return STATUS_MAP;
	}
     
}
