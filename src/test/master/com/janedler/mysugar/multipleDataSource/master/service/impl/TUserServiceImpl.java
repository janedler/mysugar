package com.janedler.mysugar.multipleDataSource.master.service.impl;

import com.janedler.mysugar.multipleDataSource.master.entity.TUser;
import com.janedler.mysugar.multipleDataSource.master.mapper.TUserMapper;
import com.janedler.mysugar.multipleDataSource.master.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Janedler
 * @since 2018-08-08
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
