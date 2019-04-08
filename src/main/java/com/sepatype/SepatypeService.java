package com.sepatype;

import static com.sepatype.SepatypeConstants.AND;
import static com.sepatype.SepatypeConstants.BELOW_HUNDRED;
import static com.sepatype.SepatypeConstants.BELOW_TEN;
import static com.sepatype.SepatypeConstants.BELOW_TWENTY;
import static com.sepatype.SepatypeConstants.BILLION;
import static com.sepatype.SepatypeConstants.EMPTY_INPUT;
import static com.sepatype.SepatypeConstants.HUNDRED;
import static com.sepatype.SepatypeConstants.INVALID_INPUT;
import static com.sepatype.SepatypeConstants.MILLION;
import static com.sepatype.SepatypeConstants.NEGATIVE;
import static com.sepatype.SepatypeConstants.QUADRILLION;
import static com.sepatype.SepatypeConstants.QUINTILLION;
import static com.sepatype.SepatypeConstants.THOUSAND;
import static com.sepatype.SepatypeConstants.TRILLION;
import static com.sepatype.SepatypeConstants.ZERO;

/**
 * This service is responsible for various actions for Sepatype program.
 */
public class SepatypeService {

    /**
     * This method validates input from user based on the following criteria:
     *  1) Input must not be empty
     *  2) Input must be digits of base 10.
     *  3) Input must be greater than Long.MIN_VALUE
     *  4) Input must be less than Long.MAX_VALUE
     *
     * @param input String input by user.
     * @return long value validated and converted from user input.
     * @throws SepatypeValidationException when validation criteria is not met.
     */
    public long validateInput(String input) throws SepatypeValidationException {
        if (input == null || input.length() < 1) {
            throw new SepatypeValidationException(EMPTY_INPUT);
        }

        long value;

        try {
            value = Long.parseLong(input.trim());
        } catch (NumberFormatException nfe) {
            throw new SepatypeValidationException(INVALID_INPUT);
        }

        return value;
    }

    /**
     * This method converts a long value into a English word representation of the long value.
     * @param num Long value to be converted.
     * @return English word representation of the long value
     */
    public String longToWords(long num) {
        boolean negative = false;
        if (num == 0L) {
            return ZERO;
        } else if (num < 0L) {
            negative = true;
            num = Math.abs(num);
        }

        String result = findString(num);
        return negative ? NEGATIVE + result : result;
    }

    /**
     * Recursive solution to convert a long value into a english word representation of the value.
     * @param num Long value to be converted.
     * @return
     */
    private String findString(long num) {
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
