package com.janedler.mysugar.db.service.db1;

import com.janedler.mysugar.db.entity.TUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dgd123
 * @since 2018-08-09
 */
public interface TUserService extends IService<TUser> {

    TUser getTUserByUserName(String userName);

    TUser getUserByUserNameAndPassword(String userNameRep, String password);
}
