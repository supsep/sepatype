package com.sepatype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This class is the entry point for the Sepatype application. The main action is to validate
 * and convert a number into english word representation of the input.
 *
 * The input must meet the following criteria:
 *        1) Input must not be empty
 *        2) Input must be digits of base 10.
 *        3) Input must be greater than Long.MIN_VALUE
 *        4) Input must be less than Long.MAX_VALUE
 */
public class SepatypeSolution {
    private static final SepatypeService service = new SepatypeService();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter some text, or' to quit");

        while (true) {
            try {
                String input = br.readLine();
                final long inputLong = service.validateInput(input);
                final SepatypeValue sepatypeValue = new SepatypeValue(inputLong);
                final String wordValue = service.longToWords(sepatypeValue.getLongValue());
                sepatypeValue.setWordValue(wordValue);
                printResult(sepatypeValue);
            } catch (SepatypeValidationException sve) {
                System.err.println(sve.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printResult(SepatypeValue sepatypeValue) {
        System.out.println(new StringBuilder("The word value for : ")
        .append(sepatypeValue.getLongValue())
        .append( " is: ")
        .append(sepatypeValue.getWordValue())
        .toString());
    }
}
