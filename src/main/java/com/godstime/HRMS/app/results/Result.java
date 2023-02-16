package com.godstime.HRMS.app.results;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Result {

    private boolean success;

    private String message;

    public Result(boolean success) {
        this.success = success;
        this.message = "No Message";
    }
}
