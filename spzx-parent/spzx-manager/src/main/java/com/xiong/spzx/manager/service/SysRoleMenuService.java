package com.xiong.spzx.manager.service;

import com.xiong.spzx.model.dto.system.AssginMenuDto;

import java.util.Map;

/**
 * @title SysRoleMenuService
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 17:46
 */
public interface SysRoleMenuService {

    Map<String, Object> findSysRoleMenuByRoleId(Long roleId);

    void doAssign(AssginMenuDto assginMenuDto);
}
