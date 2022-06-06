package com.csquared.incidents.exceptions;

public class EmptyStringException extends RuntimeException{

    public EmptyStringException() {
    }

    public EmptyStringException(String message) {
        super(message);
    }

}
