/*
 * This code contains copyright information which is the proprietary property
 * of SITA Advanced Travel Solutions. No part of this code may be reproduced,
 * stored or transmitted in any form without the prior written permission of
 * SITA Advanced Travel Solutions.
 *
 * Copyright SITA Advanced Travel Solutions 2001-2016
 * All rights reserved.
 */
package aero.sita.bordermanagement.uae.gw.exception;

import java.util.ArrayList;
import java.util.List;

//import com.sita.pts.gateway.core.CGHelper;
import aero.sita.bordermanagement.uae.gw.util.ErrorCode;

/**
 * <p>MessageException represents an error thrown during a message processing task.</p>
 * <p>Implementations of the MessageConsumer interface should throw this exception in response
 * to non-fatal (i.e. expected) message processing errors. It is expected that most eceptions
 * thrown will be a subclass of this exception</p>
 *
 * @version $Id: MessageException.java 16724 2014-02-04 16:50:31Z alehane $
 * @author njones
 *
 */
public class MessageException extends Exception {

    /** The serialVersionUID. */
    private static final long serialVersionUID = -2552565009930604313L;
    /** The ErrorCode. */
    private List<ErrorCode> iErrorCodeList = new ArrayList<>();

    //------------------------------------------------------------------------
    /**
     * Constructor.
     *
     * @param message The error message.
     */
    public MessageException(final String message) {
        super(message);
    }

    /**
     * Constructor.
     *
     * @param message The error message.
     * @param th Throwable.
     */
    public MessageException(final String message, final Throwable th) {
        super(message, th);
    }

    /**
     * Constructs a MessageException with the specified detail message.
     *
     * @param message the detail message.
     * @param error The ErrorCode to use.
     */
    
    /**
    
    public MessageException(final String message, final ErrorCode error) {
        super(message);
        iErrorCodeList.add(error);
    }
    **/

    /**
     * Constructs a MessageException with the specified detail message.
     *
     * @param message the detail message.
     * @param errorList The ErrorCode list to use.
     */
    /**
    public MessageException(final String message, final List<ErrorCode> errorList) {
        super(message);
        iErrorCodeList.addAll(errorList);
    }
    **/

    /**
     * Constructs a MessageException with the specified detail message and
     * the specified cause.
     *
     * @param message The error message.
     * @param errorCode The ErrorCode to use.
     * @param cause The Throwable that caused the exception.
     */
    /**
    public MessageException(final String message, final ErrorCode errorCode, final Throwable cause) {
        super(message, cause);
        iErrorCodeList.add(errorCode);
    }
	**/
    //-----------------------------------------------------------------------
    /**
     * Gets the first error code.
     *
     * @return The ErrorCode.
     */
    /**
    public ErrorCode getErrorCode() {
        if (iErrorCodeList.isEmpty() == false) {
            return iErrorCodeList.get(0);
        }
        return null;
    }
    **/

    /**
     * Gets the complete error code list.
     *
     * @return the complete error code list.
     */
    /**
    public List<ErrorCode> getErrorCodeList() {
        return iErrorCodeList;
    }
	**/
    /**
     * Gets the error code list size.
     *
     * @return  The size of the error code list.
     */
    /**
    public int getErrorCodeListSize() {
        return iErrorCodeList.size();
    }
	**/
    /**
     * Gets a given error code from the list.
     *
     * @param index  The error code to retrieve.
     * @return  The error code.
     */
    /**
    public ErrorCode getErrorCode(final int index) {
        return iErrorCodeList.get(index);
    }
	**/
    //-----------------------------------------------------------------------
    /**
     * Performs an equality check.
     *
     * @param object  The object to compare against.
     * @return true if equal, false otherwise.
     * @see java.lang.Object#equals(java.lang.Object)
     */
    /**
    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        } else if (object instanceof MessageException == false) {
            return false;
        }

        MessageException other = (MessageException) object;

        return CGHelper.equalsHandlingEmpty(getMessage(), other.getMessage()) &&
            CGHelper.equalsHandlingNull(iErrorCodeList, other.iErrorCodeList);
    }
    **/

    /**
     * Gets the objects hash code.
     *
     * @return  The hash code.
     * @see java.lang.Object#hashCode()
     */
    /**
    @Override
    public int hashCode() {
        int hash = 3;

        hash += 7 * CGHelper.hashCodeHandlingNull(getMessage());
        hash += 11 * CGHelper.hashCodeHandlingNull(iErrorCodeList);

        return hash;
    }
    **/
}
