package com.xiong.spzx.manager.controller;

import com.xiong.spzx.manager.service.SysRoleMenuService;
import com.xiong.spzx.model.dto.system.AssginMenuDto;
import com.xiong.spzx.model.vo.common.Result;
import com.xiong.spzx.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @title SysRoleMenuController
 * @description: 角色菜单控制器
 * @author: laughing
 * @create: 4/18/24 17:46
 */
@RestController
@RequestMapping(value = "/admin/system/sysRoleMenu")
public class SysRoleMenuController {

    @Autowired
    private SysRoleMenuService sysRoleMenuService ;

    /**
     * 根据角色ID查询菜单
     * @param roleId 角色ID
     * @return 菜单数据
     */
    @GetMapping(value = "/findSysRoleMenuByRoleId/{roleId}")
    public Result<Map<String , Object>> findSysRoleMenuByRoleId(@PathVariable(value = "roleId") Long roleId) {
        Map<String , Object> sysRoleMenuList = sysRoleMenuService.findSysRoleMenuByRoleId(roleId) ;
        return Result.build(sysRoleMenuList , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 保存角色菜单
     * @param assginMenuDto 角色菜单数据
     * @return 保存结果
     */
    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssginMenuDto assginMenuDto) {
        sysRoleMenuService.doAssign(assginMenuDto);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }
}
