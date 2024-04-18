package com.xiong.spzx.manager.mapper;

import com.xiong.spzx.model.dto.system.SysUserDto;
import com.xiong.spzx.model.entity.system.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @title SysUserMapper
 * @description: TODO
 * @author: laughing
 * @create: 3/27/24 18:55
 */
@Mapper
public interface SysUserMapper {

    SysUser selectUserInfoByUserName(String userName);

    List<SysUser> findByPage(SysUserDto sysUserDto);

    void save(SysUser sysUser);

    void update(SysUser sysUser);

    void delete(Long userId);
}
