package com.xiong.spzx.manager.service;

import com.github.pagehelper.PageInfo;
import com.xiong.spzx.model.dto.system.AssginRoleDto;
import com.xiong.spzx.model.dto.system.LoginDto;
import com.xiong.spzx.model.dto.system.SysUserDto;
import com.xiong.spzx.model.entity.system.SysUser;
import com.xiong.spzx.model.vo.system.LoginVo;

/**
 * @title SysUserService
 * @description: TODO
 * @author: laughing
 * @create: 3/27/24 18:53
 */
public interface SysUserService {

    /**根据用户名查询用户数据*/
    public abstract LoginVo login(LoginDto loginDto);

    /**根据token获取用户信息*/
    SysUser getUserInfo(String token);

    /**退出登录*/
    void logout(String token);

    /**根据条件查询用户数据*/
    public abstract PageInfo<SysUser> findByPage(SysUserDto sysUserDto, Integer pageNum, Integer pageSize);

    /**添加用户*/
    void saveSysUser(SysUser sysUser);

    /**用户修改*/
    void updateSysUser(SysUser sysUser);

    /**根据id删除用户*/
    void deleteById(Long userId);

    void doAssign(AssginRoleDto assginRoleDto);
}
