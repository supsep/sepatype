package com.sepatype.util;

import static com.sepatype.SepatypeConstants.AND;
import static com.sepatype.SepatypeConstants.BELOW_HUNDRED;
import static com.sepatype.SepatypeConstants.BELOW_TEN;
import static com.sepatype.SepatypeConstants.BELOW_TWENTY;
import static com.sepatype.SepatypeConstants.BILLION;
import static com.sepatype.SepatypeConstants.HUNDRED;
import static com.sepatype.SepatypeConstants.MILLION;
import static com.sepatype.SepatypeConstants.NEGATIVE;
import static com.sepatype.SepatypeConstants.QUADRILLION;
import static com.sepatype.SepatypeConstants.QUINTILLION;
import static com.sepatype.SepatypeConstants.THOUSAND;
import static com.sepatype.SepatypeConstants.TRILLION;
import static com.sepatype.SepatypeConstants.ZERO;

public final class LongToWordUtil {

    /**
     * This method converts a long value into a English word representation of the long value.
     * @param num Long value to be converted.
     * @return English word representation of the long value
     */
    public static final String longToWords(long num) {
        boolean negative = false;
        if (num == 0L) {
            return ZERO;
        }
        else if (num == Long.MIN_VALUE) {
            // This is a special case where Math.abs() cannot handle Long.MIN_VALUE as mentioned in javadoc.
            negative = true;
            num = Long.MAX_VALUE;
        }
        else if (num < 0L) {
            negative = true;
            num = Math.abs(num);
        }

        String result = findString(num);
        return postProcessWordValue(result.trim(), negative, num);
    }

    /**
     * This method is responsible for post processing of the word value. It commits the following actions:
     *  1) Capitalize first letter in the string.
     *  2) Add "and" after the hundreds value if there are tens or ones values.
     *  3) Append "Negative" to beginning of string if it is a negative value.
     * @param wordValue
     * @return
     */
    private static final String postProcessWordValue(String wordValue, boolean negative, long num) {
        // Append negative if negative value
        if (negative) {
            wordValue = NEGATIVE + wordValue;
        }

        // Capitalize first letter
        wordValue = wordValue.substring(0,1).toUpperCase() + wordValue.substring(1);

        // Insert "and" if value required
        if (num > 100L && num % 100L != 0L){
            int index = 0;

            // Find index for whitespace before Ones values
            if (num % 10 >= 0) {
                index = wordValue.lastIndexOf(" ");
            }

            // Find index for whitespace for tens greater than 20 (Since 11-19 is special case words)
            if (num % 10 > 0 && num % 100 > 20) {
                index = wordValue.lastIndexOf(" ");
                index = wordValue.lastIndexOf(" ", index - 1);
            }
            wordValue = wordValue.substring(0, index) + AND + wordValue.substring(index);
        }

        return wordValue;
    }

    /**
     * Recursive solution to convert a long value into a english word representation of the value.
     * @param num Long value to be converted.
     * @return
     */
    private static final String findString(long num) {
        String result;
        if (num < 10L) {
            result = BELOW_TEN[(int) num];
        }
        else if (num < 20L) {
            result = BELOW_TWENTY[(int) (num-10L)];
        }
        else if (num < 100L) {
            result = BELOW_HUNDRED[(int) (num/10L)] + " " + findString(num % 10L);
        }
        else if (num < 1000L) {
            result = findString(num / 100L) + HUNDRED + findString(num % 100L);
        }
        else if (num < 1000000L) {
            result = findString(num/1000L) + THOUSAND + findString(num % 1000L);
        }
        else if (num < 1000000000L) {
            result = findString(num/1000000L) + MILLION + findString(num % 1000000L);
        }
        else if (num < 1000000000000L) {
            result = findString(num/1000000000L) + BILLION
                + findString(num % 1000000000L);
        }
        else if (num < 1000000000000000L) {
            result = findString(num/1000000000000L) + TRILLION
                + findString(num % 1000000000000L);
        }
        else if (num < 1000000000000000000L) {
            result = findString(num/1000000000000000L) + QUADRILLION
                + findString(num % 1000000000000000L);
        }
        else {
            result = findString(num/1000000000000000000L) + QUINTILLION
                + findString(num % 1000000000000000000L);
        }
        return result.trim();
    }
}
