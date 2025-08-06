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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * This class allows an implementation of the C enum keyword in Java.
 * <p>
 * This class should be subclassed to create the particular enumeration
 * required. Public static final variables should be defined for the
 * enumeration values. Methods can then use the enumeration, which is
 * type-safe.
 * <p>
 * The constructor should not be made public by the subclass. Instead,
 * the subclass should declare a method with the signature
 * <code>EnumSubclass create(String)</code> which allows extra items to
 * be added to the enumeration.
 * <p>
 * Each enumerated object must be set up with a String representing value.
 * The string is used for equality testing. (Thus the class is effectively
 * a typed String.) Even though public static final variables have been
 * declared, equals() should be used for comparison in case the object
 * has been cloned or serialized.
 */

public abstract class DynamicEnumeration implements Serializable, Comparable<DynamicEnumeration> {

    /** <code>iName</code>. */
    private final String name;

    /**
     * UEnumeration constructor.
     *
     * @param name A human readable unique name for the enumeration value. By
     * convention in CamelCase (java class name format).
     */
    protected DynamicEnumeration(final String name) {
        super();
        if (name == null) {
            throw new IllegalArgumentException("Enumeration name must not be null");
        }

        this.name = name;
    }

    //-----------------------------------------------------------------------
    /**
     * Get the name handling null.
     *
     * @param enumeration  the enumeration instance to get the name of, may be null
     * @return the name of the enumeration, or null
     */
    public static String getNameHandlingNull(final DynamicEnumeration enumeration) {
        if (enumeration == null) {
            return null;
        }
        return enumeration.getName();
    }

    //-----------------------------------------------------------------------
    /**
     * Equality test. This should be used in preference to ==.
     *
     * @param obj  the object to compare to
     * @return true if the enumerations are equal
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj instanceof DynamicEnumeration) {
            return getClass().equals(obj.getClass()) && ((DynamicEnumeration) obj).getName().equals(name);
        }
        return false;
    }

    /**
     * Gets a hash code value for the enumeration compatable with the
     * equals method.
     *
     * @return  a hash code value for this object.
     */
    @Override
    public int hashCode() {
        return getClass().getName().hashCode() + name.hashCode();
    }

    /**
     * Compares this object with another, based alphabetically on the name.
     *
     * @param obj  the object to compare to
     * @return -1 if this object is before obj, 0 if the objects are the same
     *         and 1 if this object is after obj.
     */
    public int compareTo(final DynamicEnumeration obj) {
        return name.compareTo(obj.getName());
    }

    //-----------------------------------------------------------------------
    /**
     * Returns a string suitable for debugging.
     *
     * @return a debugging string
     */
    @Override
    public String toString() {
        return getName();
    }

    /**
     * Takes a string and splits the string into a set of parameters.
     *
     * @param text The text to split.
     * @return A list of strings split by ","
     */
    protected static List<String> splitParameters(final String text) {
        String[] paramStrings = StringUtils.split(text, ",");

        // Cycle around the params and trim each parameter to avoid spaces
        List<String> params = new ArrayList<>();

        for (String paramString : paramStrings) {
            String param = paramString.trim();
            params.add(param);
        }

        return params;
    }

	public String getName() {
		return name;
	}
    
    

}
