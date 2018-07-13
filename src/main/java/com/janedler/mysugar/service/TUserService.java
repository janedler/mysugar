package com.janedler.mysugar.service;

import com.janedler.mysugar.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Janedler
 * @since 2018-07-13
 */
public interface TUserService extends IService<TUser> {


    /**
     * 根据用户名获取用户信息
     *
     * @param username
     * @return
     */
    TUser getUserByUserName(String username);

    /**
     * 根据用户名与密码获取用户信息
     *
     * @param username
     * @return
     */
    TUser getUserByUserNameAndPassword(String username,String password);

}
