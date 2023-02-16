package com.godstime.HRMS.app.results;

public class ResultDataSuccess<T> extends ResultData<T>{

    public ResultDataSuccess(T data) {
        super(true, data);
    }


    public ResultDataSuccess(boolean success, T data) {
        super(true, data);
    }

    public ResultDataSuccess() {
        super(true);
    }

    public ResultDataSuccess(boolean success) {
        super(success);
    }

    public ResultDataSuccess(boolean success, String message, T data) {
        super(success, message, data);
    }
}
