package com.xiong.spzx.manager.mapper;

import com.xiong.spzx.model.entity.system.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @title SysMenuMapper
 * @description: TODO
 * @author: laughing
 * @create: 4/17/24 19:25
 */
@Mapper
public interface SysMenuMapper {

    public abstract List<SysMenu> selectAll();

    public abstract  void insert(SysMenu sysMenu);

    public abstract void updateById(SysMenu sysMenu);

    public abstract int countByParentId(Long id);

    public abstract void deleteById(Long id);

    public abstract List<SysMenu> selectListByUserId(Long userId);

    public abstract SysMenu selectById(Long id) ;
}
