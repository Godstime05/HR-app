package com.godstime.HRMS.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(Long id) {
        super("Could not find department with id: " + id);
    }
//
//    public DepartmentNotFoundException(String name) {
//        super("Could not find department with name: " + name);
//    }
//
//    public DepartmentNotFoundException(Long managerId) {
//        super("Could not find department with manager id: " + managerId);
//    }
//
    public DepartmentNotFoundException(String location) {
        super("Could not find department with location: " + location);
    }
}
