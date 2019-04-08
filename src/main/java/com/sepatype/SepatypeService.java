package com.sepatype;

public interface SepatypeService {

  long validateInput(String input) throws SepatypeValidationException;

  SepatypeValue handleInput(String input) throws SepatypeValidationException;

}
