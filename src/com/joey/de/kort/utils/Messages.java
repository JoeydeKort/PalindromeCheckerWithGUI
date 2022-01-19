package com.joey.de.kort.utils;

public enum Messages {

    ENTER_A_NUMBER_OR_WORD("Enter a word or numbers"),
    ERROR_MESSAGE_NO_INPUT("Error! No input submitted"),
    SUCCESS_MESSAGE("Success! It is a palindrome!"),
    FAIL_MESSAGE("Sorry, try again. ");

    private final String message;

    Messages(String m) {
        this.message = m;
    }

    public String getMessage() {
        return message;
    }

}
