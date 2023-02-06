package com.godstime.HRMS.app.exceptions;


public class PositionUpdateFailedException extends RuntimeException {
    public PositionUpdateFailedException(String message) {
        super(message);
    }
}
