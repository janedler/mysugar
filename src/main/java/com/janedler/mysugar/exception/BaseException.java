package com.janedler.mysugar.exception;


import com.janedler.mysugar.domain.response.ResultResp;

public abstract class BaseException extends RuntimeException {

    public ResultResp resultResp;

    public BaseException() {
        resultResp = new ResultResp();
    }
}
