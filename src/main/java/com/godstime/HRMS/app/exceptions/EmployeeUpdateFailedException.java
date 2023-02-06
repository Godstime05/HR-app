package com.godstime.HRMS.app.exceptions;

public class EmployeeUpdateFailedException extends RuntimeException {
    public EmployeeUpdateFailedException(String message) {
        super(message);
    }
}
