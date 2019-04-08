package com.sepatype;

/**
 * POJO Class that contains digit and english word representation of user input.
 */
public class SepatypeValue {
    private final long longValue;

    private String wordValue;

    public SepatypeValue(long value) {
        this.longValue = value;
    }

    public String getWordValue() {
        return wordValue;
    }

    public void setWordValue(String wordValue) {
        this.wordValue = wordValue;
    }

    public long getLongValue() {
        return longValue;
    }
}
