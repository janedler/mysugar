package com.janedler.mysugar.exception;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "")
public class CommonException extends BaseException{

    public CommonException(){
        super();
    }

    public CommonException(int resultCode, String message) {
        super();
        this.resultResp.message = message;
        this.resultResp.resultCode = resultCode;
    }
}
