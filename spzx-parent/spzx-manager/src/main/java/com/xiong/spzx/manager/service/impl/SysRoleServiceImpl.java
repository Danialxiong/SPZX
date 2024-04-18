package com.xiong.spzx.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiong.spzx.manager.mapper.SysRoleMapper;
import com.xiong.spzx.manager.mapper.SysRoleUserMapper;
import com.xiong.spzx.manager.service.SysRoleService;
import com.xiong.spzx.model.dto.system.SysRoleDto;
import com.xiong.spzx.model.entity.system.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @title SysRoleServiceImpl
 * @description: TODO
 * @author: laughing
 * @create: 4/11/24 16:11
 */
// 接口实现类
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper ;

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper ;

    /**
     * 角色分页查询
     * @param sysRoleDto 查询条件
     * @param pageNum 页码
     * @param pageSize 每页显示数量
     * @return 分页数据
     */
    @Override
    public PageInfo<SysRole> findByPage(SysRoleDto sysRoleDto, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum , pageSize) ;
        List<SysRole> sysRoleList = sysRoleMapper.findByPage(sysRoleDto) ;
        PageInfo<SysRole> pageInfo = new PageInfo(sysRoleList) ;
        return pageInfo;
    }

    /**
     * 角色新增
     * @param sysRole 角色信息
     */
    @Override
    public void saveSysRole(SysRole sysRole) {
        sysRoleMapper.saveSysRole(sysRole);
    }

    /**
     * 角色修改
     * @param sysRole  角色信息
     */
    @Override
    public void updateSysRole(SysRole sysRole) {
        sysRoleMapper.updateSysRole(sysRole);
    }

    /**
     * 角色删除
     * @param id  角色id
     */
    @Override
    public void deleteSysRole(Integer id) {
        sysRoleMapper.deleteSysRole(id);
    }

    /**
     * 查询所有角色
     * @return
     */
    @Override
    public Map<String, Object> findAllRoles() {
        List<SysRole> sysRoleList = sysRoleMapper.findAllRoles() ;
        Map<String , Object> resultMap = new HashMap<>() ;
        resultMap.put("allRolesList" , sysRoleList) ;
        return resultMap;
    }

    /**
     * 查询所有角色
     * @return
     */
    @Override
    public Map<String, Object> findAllRoles(Long userId) {

        // 查询所有的角色数据
        List<SysRole> sysRoleList = sysRoleMapper.findAllRoles() ;

        // 查询当前登录用户的角色数据
        List<Long> sysRoles = sysRoleUserMapper.findSysUserRoleByUserId(userId);

        // 构建响应结果数据
        Map<String , Object> resultMap = new HashMap<>() ;
        resultMap.put("allRolesList" , sysRoleList) ;
        resultMap.put("sysUserRoles", sysRoles);

        return resultMap;
    }
}

