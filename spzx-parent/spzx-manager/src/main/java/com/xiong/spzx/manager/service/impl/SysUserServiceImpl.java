package com.xiong.spzx.manager.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiong.spzx.common.exception.CommonException;
import com.xiong.spzx.manager.mapper.SysRoleUserMapper;
import com.xiong.spzx.manager.mapper.SysUserMapper;
import com.xiong.spzx.manager.service.SysUserService;
import com.xiong.spzx.model.dto.system.AssginRoleDto;
import com.xiong.spzx.model.dto.system.LoginDto;
import com.xiong.spzx.model.dto.system.SysUserDto;
import com.xiong.spzx.model.entity.system.SysUser;
import com.xiong.spzx.model.vo.common.ResultCodeEnum;
import com.xiong.spzx.model.vo.system.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @title SysUserServiceImpl
 * @description: TODO
 * @author: laughing
 * @create: 3/27/24 18:54
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper ;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 根据用户名查询用户数据
     * @param loginDto
     * @return
     */
    @Override
    public LoginVo login(LoginDto loginDto) {
        //0.获取输入的验证码和redis中的key名称 loginDto获取到
        String captcha = loginDto.getCaptcha();
        String key = loginDto.getCodeKey();
        //0-1.根据获取的redis里面key，查询redis里面存储验证码
        String redisCode = redisTemplate.opsForValue().get("user:validate" + key);

        //0-2.比较输入的验证码和redis里面存储的验证码是否一致
        if(StrUtil.isEmpty(redisCode) || !StrUtil.endWithIgnoreCase(redisCode,captcha)){
            //0-3.如果不一致，抛出异常
            throw new CommonException(ResultCodeEnum.VALIDATECODE_ERROR);
        }

        //0-4.如果一致，删除redis里面验证码，继续执行下面的代码
        redisTemplate.delete("user:validate" + key);

        //1.获取用户名
        String userName = loginDto.getUserName();
        SysUser sysUser = sysUserMapper.selectUserInfoByUserName(userName);
        if(null == sysUser){
            throw new CommonException(ResultCodeEnum.LOGIN_ERROR);
        }

        //2.把输入的密码进行加密，然后和数据库中的密码进行比较
        String input_password = DigestUtils.md5DigestAsHex(loginDto.getPassword().getBytes());
        if (!input_password.equals(sysUser.getPassword())){
            throw new CommonException(ResultCodeEnum.LOGIN_ERROR);
        }

        //3.生成token，把token存入redis
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        redisTemplate.opsForValue().set("user:token"+token,
                JSON.toJSONString(sysUser),7, TimeUnit.DAYS);

        //4.返回token
        LoginVo loginVo = new LoginVo();
        loginVo.setToken(token);

        return loginVo;
    }

    /**
     * 获取当前登陆用户信息
     * @param token token
     * @return SysUser
     */
    @Override
    public SysUser getUserInfo(String token) {
        String s = redisTemplate.opsForValue().get("user:token" + token);
        if(StrUtil.isNotEmpty(s)){
            return JSON.parseObject(s, SysUser.class);
        }
        return null;
    }

    /**
     * 退出登录
     * @param token token
     */
    @Override
    public void logout(String token) {
        redisTemplate.delete("user:token" + token);
    }

    /**
     * 根据条件查询用户数据
     * @param sysUserDto
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<SysUser> findByPage(SysUserDto sysUserDto, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum , pageSize) ;
        List<SysUser> list = sysUserMapper.findByPage(sysUserDto);
        return new PageInfo<>(list);
    }

    /**
     * 添加用户
     * @param sysUser
     */
    @Override
    public void saveSysUser(SysUser sysUser) {
        //1 判断用户名是否存在
        SysUser user = sysUserMapper.selectUserInfoByUserName(sysUser.getUserName());
        if(null != user){
            throw new CommonException(ResultCodeEnum.USER_NAME_IS_EXISTS);
        }
        //2.密码加密
        String md5_password = DigestUtils.md5DigestAsHex(sysUser.getPassword().getBytes());
        sysUser.setPassword(md5_password);

        //3.设置status值 1 有效 0 无效
        sysUser.setStatus(1);

        sysUserMapper.save(sysUser);
    }

    /**
     * 用户修改
     * @param sysUser
     */
    @Override
    public void updateSysUser(SysUser sysUser) {
        sysUserMapper.update(sysUser);
    }

    /**
     * 根据id删除用户
     * @param userId
     */
    @Override
    public void deleteById(Long userId) {
        sysUserMapper.delete(userId);
    }

    @Transactional
    @Override
    public void doAssign(AssginRoleDto assginRoleDto) {

        // 删除之前的所有的用户所对应的角色数据
        sysRoleUserMapper.deleteByUserId(assginRoleDto.getUserId()) ;

        // 分配新的角色数据
        List<Long> roleIdList = assginRoleDto.getRoleIdList();
        roleIdList.forEach(roleId->{
            sysRoleUserMapper.doAssign(assginRoleDto.getUserId(),roleId);
        });
    }
}
