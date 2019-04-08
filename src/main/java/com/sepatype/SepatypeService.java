package com.sepatype;

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
 *
 */
public class SepatypeService {

    /**
     *
     * @param input
     * @return
     * @throws SepatypeValidationException
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
     *
     * @param num
     * @return
     */
    public String numberToWords(long num) {
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
            result = findString(num/100L) + HUNDRED +  findString(num % 100L);
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
