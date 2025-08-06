/*
 * Copyright ICP and SITA Advanced Travel Solutions Limited 2025-26 and
 * ICPConfidential. All rights reserve SITA and ICP.
 */
package aero.sita.bordermanagement.uae.gw.cusres;

/**
 * @author SITA
 *
 */
public class Delimiters {

    /**
     * component : String Component data element separator (typically ':')
     */
    public String component = ":";

    /**
     * element : String Data element separator (typically '+')
     */
    public String element = "+";

    /**
     * decimal : String Decimal notation character (typically '.')
     */
    public String decimal = ".";

    /**
     * release : String Release character used to escape separators (typically '?')
     */
    public String release = "?";

    /**
     * repetition : String Repetition separator (typically '*')
     */
    public String repetition = "*";

    /**
     * segment : String Segment terminator (typically ''')
     */
    public String segment = "'";

    /**
     * @return String
     */
    public String una() {
        return String.format("UNA%s%s%s%s%s%s", element, component, decimal, release, repetition, segment);
    }

}
