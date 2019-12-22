package com.app.breeze.dao;

import com.app.breeze.domain.entity.ControlUser;
import com.app.breeze.domain.request.UserRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: breeze
 * @PackageName: com.app.breeze.dao
 * @ClassName: UserDao
 * @Description:
 * @author: wangjie
 * @date: 2019/12/21  20:05
 * @Copyright: 趣医网络技术服务有限公司 版权所有 Copyright (c) 2019
 */
@Mapper
public interface UserDao {

    ControlUser findUserInfoByAccount(String account);


    List<Map<String,Object>> findUserInfoByHospitalCode(String hosCode);

    Integer addUser(UserRequest user);

    void batchAddUser(List<UserRequest> userRequestList);

    Integer addUserRoleRef(@Param("userId") Integer userId, @Param("roleId") Integer roleId);

    Integer checkUserRoleRef(Integer userId);


    Integer valideUser(@Param("userId") Integer userId, @Param("isValide") String isValide, @Param("modifiedTime") Date time, @Param("modifiedPerson") Integer mId);

    Integer resetPassword(@Param("userId") Integer id,@Param("password") String password);

    ControlUser findUserById(Integer userId);

    Integer deleteUser(Integer id);

    Integer countUsersByPhone(String phone);

}
