package com.xiong.spzx.manager.controller;

import com.xiong.spzx.manager.service.SysMenuService;
import com.xiong.spzx.model.entity.system.SysMenu;
import com.xiong.spzx.model.vo.common.Result;
import com.xiong.spzx.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title SysMenuController
 * @description: TODO
 * @author: laughing
 * @create: 4/17/24 19:24
 */
@RestController
@RequestMapping(value="/admin/system/sysMenu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 查询菜单节点
     * @return 菜单节点
     */
    @GetMapping("/findNodes")
    public Result<List<SysMenu>> findNodes() {
        List<SysMenu> list = sysMenuService.findNodes();
        return Result.build(list , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 保存菜单
     * @param sysMenu 菜单信息
     * @return 保存结果
     */
    @PostMapping("/save")
    public Result save(@RequestBody SysMenu sysMenu) {
        sysMenuService.save(sysMenu);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 根据ID更新菜单
     * @param sysMenu 菜单信息
     * @return 更新结果
     */
    @PutMapping("/updateById")
    public Result updateById(@RequestBody SysMenu sysMenu) {
        sysMenuService.updateById(sysMenu);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 根据ID删除菜单
     * @param id 菜单ID
     * @return 删除结果
     */
    @DeleteMapping("/removeById/{id}")
    public Result removeById(@PathVariable Long id) {
        sysMenuService.removeById(id);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }
}
