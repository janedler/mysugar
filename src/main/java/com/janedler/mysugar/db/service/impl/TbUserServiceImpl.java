package com.janedler.mysugar.db.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.janedler.mysugar.common.DBTypeEnum;
import com.janedler.mysugar.common.DataSourceSwitch;
import com.janedler.mysugar.db.entity.TbUser;
import com.janedler.mysugar.db.mapper.TbUserMapper;
import com.janedler.mysugar.db.service.db2.TbUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dgd123
 * @since 2018-08-09
 */
@Service

public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {

    @DataSourceSwitch(DBTypeEnum.db2)
    @Override
    public List<TbUser> getTbUserList() {
        return selectPage(new Page<>(2,8),new EntityWrapper<>()).getRecords();
    }

}
