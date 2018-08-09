package com.janedler.mysugar.db.service.impl;

import com.janedler.mysugar.db.entity.TUser;
import com.janedler.mysugar.db.mapper.TUserMapper;
import com.janedler.mysugar.db.service.db1.TUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dgd123
 * @since 2018-08-09
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

    @Autowired
    TUserMapper tUserMapper;

    @Override
    public TUser getTUserByUserName(String userName) {
        return tUserMapper.getTUserByUserName(userName);
    }

    @Override
    public TUser getUserByUserNameAndPassword(String userNameRep, String password) {
        return tUserMapper.getUserByUserNameAndPassword(userNameRep, password);
    }
}
