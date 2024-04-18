package com.xiong.spzx.manager.service;

import com.xiong.spzx.model.entity.system.SysMenu;
import com.xiong.spzx.model.vo.system.SysMenuVo;

import java.util.List;

/**
 * @title SysMenuService
 * @description: TODO
 * @author: laughing
 * @create: 4/17/24 19:24
 */
public interface SysMenuService {

    List<SysMenu> findNodes();

    void save(SysMenu sysMenu);

    void updateById(SysMenu sysMenu);

    void removeById(Long id);

    List<SysMenuVo> findUserMenuList();
}
