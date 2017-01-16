package com.kaishengit.mapper;

import com.kaishengit.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by sunny on 2017/1/16.
 */
public interface RoleMapper {
    List<Role> findAll();

    Role findById(Integer roleId);

    void addNewUserRole(@Param("userId") Integer userId,@Param("roleId") Integer roleId);

    void delUserRoleByUserId(Integer userId);
}
