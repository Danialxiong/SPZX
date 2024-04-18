package com.xiong.spzx.manager.controller;

import com.github.pagehelper.PageInfo;
import com.xiong.spzx.manager.service.SysRoleService;
import com.xiong.spzx.model.dto.system.SysRoleDto;
import com.xiong.spzx.model.entity.system.SysRole;
import com.xiong.spzx.model.vo.common.Result;
import com.xiong.spzx.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @title SysRoleController
 * @description: 角色Controller
 * @author: laughing
 * @create: 4/11/24 16:00
 */
@RestController
@RequestMapping(value = "/admin/system/sysRole")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService ;

    /**
     * 角色分页查询
     * @param sysRoleDto 查询条件
     * @param pageNum 页码
     * @param pageSize 每页显示数量
     * @return 分页数据
     */
    @PostMapping("/findByPage/{pageNum}/{pageSize}")
    public Result<PageInfo<SysRole>> findByPage(@RequestBody SysRoleDto sysRoleDto ,
                                                @PathVariable(value = "pageNum") Integer pageNum ,
                                                @PathVariable(value = "pageSize") Integer pageSize) {
        PageInfo<SysRole> pageInfo = sysRoleService.findByPage(sysRoleDto , pageNum , pageSize) ;
        return Result.build(pageInfo , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 角色新增
     * @param sysRole 角色信息
     * @return 新增结果
     */
    @PostMapping(value = "/saveSysRole")
    public Result saveSysRole(@RequestBody SysRole sysRole) {
        sysRoleService.saveSysRole(sysRole) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 角色修改
     * @param sysRole  角色信息
     * @return 修改结果
     */
    @PutMapping(value = "/updateSysRole")
    public Result updateSysRole(@RequestBody SysRole sysRole) {
        sysRoleService.updateSysRole(sysRole) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 角色删除
     * @param id  角色id
     * @return 删除结果
     */
    @DeleteMapping(value = "/deleteById/{id}")
    public Result deleteSysRole(@PathVariable(value = "id") Integer id) {
        sysRoleService.deleteSysRole(id) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 查询所有角色
     * @return 所有角色
     */
    @GetMapping(value = "/findAllRoles")
    public Result<Map<String , Object>> findAllRoles() {
        Map<String, Object> resultMap = sysRoleService.findAllRoles();
        return Result.build(resultMap , ResultCodeEnum.SUCCESS)  ;
    }

    /**
     * 查询用户所有角色
     * @param userId 用户id
     * @return 用户所有角色
     */
    @GetMapping(value = "/findAllRoles/{userId}")
    public Result<Map<String , Object>> findAllRoles(@PathVariable(value = "userId") Long userId) {
        Map<String, Object> resultMap = sysRoleService.findAllRoles(userId);
        return Result.build(resultMap , ResultCodeEnum.SUCCESS)  ;
    }
}
