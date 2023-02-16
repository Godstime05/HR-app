package com.godstime.HRMS.app.results;

public class ResultSuccess extends Result{

    public ResultSuccess(String message) {
        super(true, message);
    }

    public ResultSuccess() {
        super(true);
    }
}
