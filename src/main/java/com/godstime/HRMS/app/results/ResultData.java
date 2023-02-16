package com.godstime.HRMS.app.results;

import lombok.Getter;

public class ResultData<T> extends Result{

    @Getter
    private final T data;

    public ResultData(boolean success, T data) {
        super(success);
        this.data = data;
    }

    public ResultData(boolean success) {
        super(success);
        this.data=null;
    }

    public ResultData(boolean success, String message, T data) {
        super(success, message);
        this.data=data;
    }
}
