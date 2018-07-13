package com.janedler.mysugar.service.impl;

import com.janedler.mysugar.entity.TUser;
import com.janedler.mysugar.mapper.TUserMapper;
import com.janedler.mysugar.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Janedler
 * @since 2018-07-13
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

    @Autowired
    TUserMapper userMapper;

    @Override
    public TUser getUserByUserName(String username) {
        return userMapper.getTUserByUserName(username);
    }

    @Override
    public TUser getUserByUserNameAndPassword(String username, String password) {
        return userMapper.getUserByUserNameAndPassword(username, password);
    }
}
