package com.xiong.spzx.manager.interceptor;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.xiong.spzx.model.entity.system.SysUser;
import com.xiong.spzx.model.vo.common.Result;
import com.xiong.spzx.model.vo.common.ResultCodeEnum;
import com.xiong.spzx.utils.AuthContextUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * @title LoginAuthInterceptor
 * @description: TODO
 * @author: laughing
 * @create: 3/29/24 17:25
 */
@Component
public class LoginAuthInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取请求方式
        //如果请求方式是options，直接放行
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        //2.从请求头里获取token
        String token = request.getHeader("token");
        //3.判断token是否为空，如果为空，直接返回错误提示
        if (StrUtil.isEmpty(token)) {
            responseNoLoginInfo(response);
            return false;
        }
        //4.如果token不为空，从redis中获取用户信息
        String userInfoString = redisTemplate.opsForValue().get("user:token" + token);

        //5.判断用户信息是否为空，如果为空，直接返回错误提示
        if (StrUtil.isEmpty(userInfoString)) {
            responseNoLoginInfo(response);
            return false;
        }
        //6.如果用户信息不为空，把用户信息存入ThreadLocal里面
        AuthContextUtil.set(JSON.parseObject(userInfoString, SysUser.class));

        //7.把redis里面的token重新设置过期时间
        redisTemplate.expire("user:token" + token, 30, TimeUnit.MINUTES);

        //8.放行
        return true;
    }

    //响应208状态码给前端
    private void responseNoLoginInfo(HttpServletResponse response) {
        Result<Object> result = Result.build(null, ResultCodeEnum.LOGIN_AUTH);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(JSON.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        AuthContextUtil.remove();  // 移除threadLocal中的数据
    }
}
