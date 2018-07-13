package com.janedler.mysugar.domain.response;


public class ResultResp {

    public int resultCode;

    public String message;

    public static final ResultResp defaultResp() {
        ResultResp resultResp = new ResultResp();
        resultResp.message = "操作成功";
        return resultResp;
    }

    public static final ResultResp defaultResp(String message) {
        ResultResp resultResp = new ResultResp();
        resultResp.message = message;
        return resultResp;
    }
}
