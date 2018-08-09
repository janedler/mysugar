package com.janedler.mysugar.db.service.db2;

import com.janedler.mysugar.db.entity.TbUser;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dgd123
 * @since 2018-08-09
 */
public interface TbUserService extends IService<TbUser> {


    List<TbUser> getTbUserList();

}
