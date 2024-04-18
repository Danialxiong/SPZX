package com.xiong.spzx.manager.service.impl;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import com.xiong.spzx.manager.service.ValidateCodeService;
import com.xiong.spzx.model.vo.system.ValidateCodeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @title ValidateCodeServiceImpl
 * @description: TODO
 * @author: laughing
 * @create: 3/29/24 15:15
 */
@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 生成图片验证码
     * @return  ValidateCodeVo
     */
    @Override
    public ValidateCodeVo generateValidateCode() {
        //1.通过hutool工具生成图片验证码
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(150, 48, 4, 10);
        String code = circleCaptcha.getCode();//4位验证码值
        String imageBase64 = circleCaptcha.getImageBase64();//图片的base64编码

        //2.把验证码存入redis，设置redis的key：uuid，value：验证码
        //设置过期时间,5分钟    key：user:validate+uuid
        String key = UUID.randomUUID().toString().replaceAll("-", "");
        redisTemplate.opsForValue().set("user:validate"+key, code,5, TimeUnit.MINUTES);

        //3.返回验证码ValidateCodeVo对象
        ValidateCodeVo validateCodeVo = new ValidateCodeVo();
        validateCodeVo.setCodeKey(key);
        validateCodeVo.setCodeValue("data:image/png;base64,"+imageBase64);

        return validateCodeVo;
    }
}
