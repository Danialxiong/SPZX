package com.xiong.spzx.manager.controller;

import com.github.pagehelper.PageInfo;
import com.xiong.spzx.manager.service.SysUserService;
import com.xiong.spzx.model.dto.system.AssginRoleDto;
import com.xiong.spzx.model.dto.system.SysUserDto;
import com.xiong.spzx.model.entity.system.SysRole;
import com.xiong.spzx.model.entity.system.SysUser;
import com.xiong.spzx.model.vo.common.Result;
import com.xiong.spzx.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @title SysUserController
 * @description: TODO
 * @author: laughing
 * @create: 4/11/24 18:01
 */
@RestController
@RequestMapping(value = "/admin/system/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService ;

    /**
     * 分页查询用户数据
     * @param sysUserDto 查询条件
     * @param pageNum 页码
     * @param pageSize 每页显示的条数
     * @return 分页数据
     */
    @GetMapping(value = "/findByPage/{pageNum}/{pageSize}")
    public Result<PageInfo<SysRole>> findByPage(SysUserDto sysUserDto ,
                                                @PathVariable(value = "pageNum") Integer pageNum ,
                                                @PathVariable(value = "pageSize") Integer pageSize) {
        PageInfo<SysUser> pageInfo = sysUserService.findByPage(sysUserDto , pageNum , pageSize) ;
        return Result.build(pageInfo , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 添加用户
     * @param sysUser 用户信息
     */
    @PostMapping(value = "/saveSysUser")
    public Result saveSysUser(@RequestBody SysUser sysUser) {
        sysUserService.saveSysUser(sysUser) ;
        return Result.build(null, ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 用户修改
     * @param sysUser 用户信息
     */
    @PutMapping(value = "/updateSysUser")
    public Result updateSysUser(@RequestBody SysUser sysUser) {
        sysUserService.updateSysUser(sysUser) ;
        return Result.build(null, ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 用户删除
     * @param id 用户id
     */
    @DeleteMapping(value = "/deleteById/{userId}")
    public Result deleteById(@PathVariable(value = "userId") Long userId) {
        sysUserService.deleteById(userId) ;
        return Result.build(null, ResultCodeEnum.SUCCESS) ;
    }

    @PostMapping("/doAssign")
    public Result doAssign(@RequestBody AssginRoleDto assginRoleDto) {
        sysUserService.doAssign(assginRoleDto) ;
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }
}
