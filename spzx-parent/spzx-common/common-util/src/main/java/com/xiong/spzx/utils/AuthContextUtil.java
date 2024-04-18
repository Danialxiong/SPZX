package com.xiong.spzx.utils;

import com.xiong.spzx.model.entity.system.SysUser;

/**
 * @title AuthContextUtil
 * @description: TODO
 * @author: laughing
 * @create: 3/29/24 17:23
 */
public class AuthContextUtil {

    //创建threadLocal对象
    private static final ThreadLocal<SysUser> threadLocal = new ThreadLocal<>();

    //将用户信息放入threadLocal
    public static void set(SysUser sysUser){
        threadLocal.set(sysUser);
    }

    //从threadLocal中获取用户信息
    public static SysUser get(){
        return threadLocal.get();
    }

    //从threadLocal中移除用户信息
    public static void remove(){
        threadLocal.remove();
    }

}
