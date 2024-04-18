package com.xiong.spzx.manager.mapper;

import com.xiong.spzx.model.dto.system.SysRoleDto;
import com.xiong.spzx.model.entity.system.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @title SysRoleMapper
 * @description: TODO
 * @author: laughing
 * @create: 4/11/24 16:12
 */
@Mapper
public interface SysRoleMapper {
    public abstract List<SysRole> findByPage(SysRoleDto sysRoleDto);

    public abstract void saveSysRole(SysRole sysRole);

    public abstract void updateSysRole(SysRole sysRole);

    public abstract void deleteSysRole(Integer id);

    public abstract List<SysRole> findAllRoles();
}
