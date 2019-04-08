package com.sepatype;

/**
 * Constant variables for use in the Sepatype program.
 */
public final class SepatypeConstants {

    // Constants for SepatypeServiceImpl evaluation
    public static final String[] BELOW_TEN = new String[] {"", "one", "two", "three", "four", "five", "six", "seven",
        "eight", "nine"};
    public static  final String[] BELOW_TWENTY = new String[] {"ten", "eleven", "twelve", "thirteen", "fourteen",
        "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    public static final String[] BELOW_HUNDRED = new String[] {"", "ten", "twenty", "thirty", "forty", "fifty",
        "sixty", "seventy", "eighty", "ninety"};

    public static final String AND = " and";
    public static final String NEGATIVE = "negative ";
    public static final String ZERO = "Zero";
    public static final String HUNDRED = " hundred ";
    public static final String THOUSAND = " thousand ";
    public static final String MILLION = " million ";
    public static final String BILLION  = " billion ";
    public static final String TRILLION = " trillion ";
    public static final String QUADRILLION = " quadrillion ";
    public static final String QUINTILLION  = " quintillion ";

    // Constants for SepatypeServiceImpl validation
    public static final String EMPTY_INPUT = "Input is empty.";

    public static final String INVALID_INPUT = "Input is not a valid input. Input must be between " + Long.MIN_VALUE
            + " and " + Long.MAX_VALUE + ". Commas are also accepted as part of the number.";

    /**
     * Private constructor preventing objects of this class.
     */
    private SepatypeConstants(){}
}
