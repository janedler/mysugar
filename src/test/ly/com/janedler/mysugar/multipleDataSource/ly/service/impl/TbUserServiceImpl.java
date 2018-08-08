package com.janedler.mysugar.multipleDataSource.ly.service.impl;

import com.janedler.mysugar.multipleDataSource.ly.entity.TbUser;
import com.janedler.mysugar.multipleDataSource.ly.mapper.TbUserMapper;
import com.janedler.mysugar.multipleDataSource.ly.service.TbUserService;
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
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {

}
