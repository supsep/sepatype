package com.sepatype;

/**
 * Constant variables for use in the Sepatype program.
 */
public final class SepatypeConstants {
    // Constants for SepatypeService evaluation
    protected static final String[] BELOW_TEN = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine"};
    protected static  final String[] BELOW_TWENTY = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    protected static final String[] BELOW_HUNDRED = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"};

    protected static final String NEGATIVE = "Negative ";
    protected static final String ZERO = "Zero";
    protected static final String HUNDRED = " Hundred ";
    protected static final String THOUSAND = " Thousand ";
    protected static final String MILLION = " Million ";
    protected static final String BILLION  = " Billion ";
    protected static final String TRILLION = " Trillion ";
    protected static final String QUADRILLION = " Quadrillion ";
    protected static final String QUINTILLION  = " Quintillion ";

    // Constants for SepatypeService validation
    protected static final String EMPTY_INPUT = "Input is empty.";

    protected static final String INVALID_INPUT = "Input is not a valid input. Input must be between " + Long.MIN_VALUE
            + " and " + Long.MAX_VALUE + ".";

    /**
     * Private constructor preventing objects of this class.
     */
    private SepatypeConstants(){}
}
