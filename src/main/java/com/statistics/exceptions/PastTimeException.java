package com.statistics.exceptions;

public class PastTimeException extends RuntimeException {
    public PastTimeException(String message){
        super(message);
    }
}
