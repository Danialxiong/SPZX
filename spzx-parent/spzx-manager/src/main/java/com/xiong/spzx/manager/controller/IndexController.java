package com.xiong.spzx.manager.controller;

import com.xiong.spzx.manager.service.SysMenuService;
import com.xiong.spzx.manager.service.SysUserService;
import com.xiong.spzx.manager.service.ValidateCodeService;
import com.xiong.spzx.model.dto.system.LoginDto;
import com.xiong.spzx.model.entity.system.SysUser;
import com.xiong.spzx.model.vo.common.Result;
import com.xiong.spzx.model.vo.common.ResultCodeEnum;
import com.xiong.spzx.model.vo.system.LoginVo;
import com.xiong.spzx.model.vo.system.SysMenuVo;
import com.xiong.spzx.model.vo.system.ValidateCodeVo;
import com.xiong.spzx.utils.AuthContextUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title IndexController
 * @description: TODO
 * @author: laughing
 * @create: 3/27/24 18:17
 */
@Tag(name = "用户接口" , description = "用户接口")
@RestController
@RequestMapping(value = "/admin/system/index")
public class IndexController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ValidateCodeService validateCodeService;

    @Autowired
    private SysMenuService sysMenuService;

    //获取当前登陆用户信息
    /*@Operation(summary = "获取当前登陆用户信息")
    @GetMapping("/getUserInfo")
    public Result<SysUser> getUserInfo(@RequestHeader("token") String token){
        SysUser sysUser = sysUserService.getUserInfo(token);
        return Result.build(sysUser, ResultCodeEnum.SUCCESS);
    }*/

    //获取当前登陆用户信息
    @Operation(summary = "获取当前登陆用户信息")
    @GetMapping("/getUserInfo")
    public Result<SysUser> getUserInfo(){
        return Result.build(AuthContextUtil.get(), ResultCodeEnum.SUCCESS);
    }

    //生成图片验证码
    @Operation(summary = "生成图片验证码")
    @GetMapping("/generateValidateCode")
    public Result<ValidateCodeVo> generateValidateCode() {
        ValidateCodeVo validateCodeVo = validateCodeService.generateValidateCode();
        return Result.build(validateCodeVo, ResultCodeEnum.SUCCESS);
    }

    /**
     * 登录
     */
    @Operation(summary = "登录")
    @PostMapping("/login")
    public Result login(@RequestBody LoginDto loginDto) {
        LoginVo login = sysUserService.login(loginDto);
        return Result.build(login, ResultCodeEnum.SUCCESS);
    }

    //退出登录
    @Operation(summary = "退出登录")
    @GetMapping("/logout")
    public Result logout(@RequestHeader("token") String token){
        sysUserService.logout(token);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }


    /**
     * 获取用户菜单
     * @return 菜单数据
     */
    @GetMapping("/menus")
    public Result menus() {
        List<SysMenuVo> sysMenuVoList =  sysMenuService.findUserMenuList() ;
        return Result.build(sysMenuVoList , ResultCodeEnum.SUCCESS) ;
    }
}
