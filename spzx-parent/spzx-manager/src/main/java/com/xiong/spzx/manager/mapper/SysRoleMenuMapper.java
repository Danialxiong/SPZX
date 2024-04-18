package com.xiong.spzx.manager.mapper;

import com.xiong.spzx.model.dto.system.AssginMenuDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @title SysRoleMenuMapper
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 17:48
 */
@Mapper
public interface SysRoleMenuMapper {

    public abstract List<Long> findSysRoleMenuByRoleId(Long roleId);

    public abstract void deleteByRoleId(Long roleId);

    public abstract void doAssign(AssginMenuDto assginMenuDto);

    public abstract  void updateSysRoleMenuIsHalf(Long menuId);

}
