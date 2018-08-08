package com.janedler.mysugar.mapper;

import com.janedler.mysugar.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Janedler
 * @since 2018-07-26
 */
public interface TUserMapper extends BaseMapper<TUser> {

    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    @Select("SELECT id,userName,password,permission from t_user where userName = #{userName} limit 1")
    TUser getTUserByUserName(@Param("userName") String userName);


    /**
     * 根据用户名与密码获取用户信息
     *
     * @param userName
     * @return
     */
    @Select("SELECT id,userName,password,permission from t_user where userName = #{userName} And password=#{password}  limit 1")
    TUser getUserByUserNameAndPassword(@Param("userName")String userName,String password);

}
