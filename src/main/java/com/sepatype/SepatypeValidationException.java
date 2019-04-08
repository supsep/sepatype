package com.sepatype;

/**
 * This exception is a specific exception class for validating input for the Sepatype application.
 */
public class SepatypeValidationException extends Exception {
    public SepatypeValidationException(String message) {
        super(message);
    }
}
