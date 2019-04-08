package com.sepatype;

/**
 * Constant variables for use in the Sepatype program.
 */
public final class SepatypeConstants {
    // Constants for SepatypeServiceImpl evaluation
    public static final String[] BELOW_TEN = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine"};
    public static  final String[] BELOW_TWENTY = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public static final String[] BELOW_HUNDRED = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"};

    public static final String AND = "And ";
    public static final String NEGATIVE = "Negative ";
    public static final String ZERO = "Zero";
    public static final String HUNDRED = " Hundred ";
    public static final String THOUSAND = " Thousand ";
    public static final String MILLION = " Million ";
    public static final String BILLION  = " Billion ";
    public static final String TRILLION = " Trillion ";
    public static final String QUADRILLION = " Quadrillion ";
    public static final String QUINTILLION  = " Quintillion ";

    // Constants for SepatypeServiceImpl validation
    public static final String EMPTY_INPUT = "Input is empty.";

    public static final String INVALID_INPUT = "Input is not a valid input. Input must be between " + Long.MIN_VALUE
            + " and " + Long.MAX_VALUE + ".";

    /**
     * Private constructor preventing objects of this class.
     */
    private SepatypeConstants(){}
}
