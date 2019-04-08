package com.sepatype;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
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
                final SepatypeValue value = new SepatypeValue(inputLong);
                final String wordValue = service.numberToWords(value.getLongValue());
                value.setWordValue(wordValue);
                System.out.println("The word value for : " + inputLong + " is: " + wordValue);
            } catch (SepatypeValidationException sve) {
                System.err.println(sve.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
