package com.krealll.day6.model.exception;

public class CustomParseException extends Exception {

    public CustomParseException(){}

    public CustomParseException(String message) {
        super(message);
    }

    public CustomParseException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomParseException(Throwable cause) {
        super(cause);
    }

}
