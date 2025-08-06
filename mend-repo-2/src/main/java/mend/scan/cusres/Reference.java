/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.cusres;

/**
 * @author Kamal.Patel
 *
 */
public class Reference {

    /**
     * qualifier String
     */
    public String qualifier;

    /**
     * value String
     */
    public String value;

    /**
     * @param qualifier
     * @param value
     */
    /**
     * @param qualifier
     * @param value
     */
    public Reference(final String qualifier, final String value) {
        this.qualifier = qualifier;
        this.value = value;
    }

    /**
     * @return String
     */
    public String getQualifier() {
        return qualifier;
    }

    /**
     * @param qualifier
     */
    public void setQualifier(final String qualifier) {
        this.qualifier = qualifier;
    }

    /**
     * @return String
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(final String value) {
        this.value = value;
    }
}
