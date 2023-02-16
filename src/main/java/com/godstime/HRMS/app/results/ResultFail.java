package com.godstime.HRMS.app.results;

public class ResultFail extends Result{

    public ResultFail( String message) {
        super(false, message);
    }

    public ResultFail() {
        super(false);
    }
}
