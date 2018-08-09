package com.janedler.mysugar.db1.service.impl;

import com.janedler.mysugar.db1.entity.TUser;
import com.janedler.mysugar.db1.mapper.TUserMapper;
import com.janedler.mysugar.db1.service.TUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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

}
