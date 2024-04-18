package com.xiong.spzx.manager.utils;

import com.xiong.spzx.model.entity.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @title MenuHelper
 * @description: 菜单树工具类
 * @author: laughing
 * @create: 4/17/24 19:30
 */
public class MenuHelper {

    /**
     * 使用递归方法建菜单
     * @param sysMenuList 菜单列表
     * @return 菜单树
     */
    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList) {
        List<SysMenu> trees = new ArrayList<>();
        for (SysMenu sysMenu : sysMenuList) {
            if (sysMenu.getParentId() == 0) {
                trees.add(findChildren(sysMenu,sysMenuList));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     * @param treeNodes 菜单列表
     * @return 菜单树
     */
    public static SysMenu findChildren(SysMenu sysMenu, List<SysMenu> treeNodes) {
        sysMenu.setChildren(new ArrayList<>());
        for (SysMenu it : treeNodes) {
            if(sysMenu.getId().longValue() == it.getParentId().longValue()) {
                //if (sysMenu.getChildren() == null) {
                //    sysMenu.setChildren(new ArrayList<>());
                //}
                sysMenu.getChildren().add(findChildren(it,treeNodes));
            }
        }
        return sysMenu;
    }
}
