package com.janedler.mysugar.domain.request;

import javax.validation.constraints.NotBlank;

public class LoginReq {

    @NotBlank(message = "用户名不能为空")
    public String userName;

    @NotBlank(message = "密码不能为空")
    public String password;


}
