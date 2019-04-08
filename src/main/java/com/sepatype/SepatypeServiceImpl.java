package com.sepatype;


import static com.sepatype.SepatypeConstants.EMPTY_INPUT;
import static com.sepatype.SepatypeConstants.INVALID_INPUT;

import com.sepatype.util.LongToWordUtil;

/**
 * This service is responsible for various actions for Sepatype program.
 */
public class SepatypeServiceImpl implements SepatypeService {

    /**
     * This method validates input from user based on the following criteria:
     *  1) Input must not be empty
     *  2) Input must be digits of base 10.
     *  3) Input must be greater than Long.MIN_VALUE
     *  4) Input must be less than Long.MAX_VALUE
     *
     * This method is public to allow for unit tests (Would use @VisibleForTesting annotation)
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


    public SepatypeValue handleInput(String input) throws SepatypeValidationException {
        final long inputLong = validateInput(input);
        final SepatypeValue sepatypeValue = new SepatypeValue(inputLong);
        final String wordValue = LongToWordUtil.longToWords(sepatypeValue.getLongValue());
        sepatypeValue.setWordValue(wordValue);
        return sepatypeValue;
    }

}
