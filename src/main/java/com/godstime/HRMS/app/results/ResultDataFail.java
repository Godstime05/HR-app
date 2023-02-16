package com.godstime.HRMS.app.results;

public class ResultDataFail<T> extends ResultData<T>{


    public ResultDataFail(boolean success, T data) {
        super(success, data);
    }

    public ResultDataFail(boolean success) {
        super(success);
    }

    public ResultDataFail(boolean success, String message, T data) {
        super(success, message, data);
    }

    public ResultDataFail(T data) {
        super(false, data);
    }


    public ResultDataFail() {
        super(false);
    }

    public ResultDataFail(String message, T data) {
        super(false, message, data);
    }
}
