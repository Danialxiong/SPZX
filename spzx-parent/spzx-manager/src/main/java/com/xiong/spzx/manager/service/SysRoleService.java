package com.xiong.spzx.manager.service;

import com.github.pagehelper.PageInfo;
import com.xiong.spzx.model.dto.system.SysRoleDto;
import com.xiong.spzx.model.entity.system.SysRole;

import java.util.Map;

/**
 * @title SysRoleService
 * @description: TODO
 * @author: laughing
 * @create: 4/11/24 16:11
 */
public interface SysRoleService {
    public abstract PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer pageNum, Integer pageSize);

    void saveSysRole(SysRole sysRole);

    void updateSysRole(SysRole sysRole);

    void deleteSysRole(Integer id);

    Map<String, Object> findAllRoles();

    Map<String, Object> findAllRoles(Long userId);
}
