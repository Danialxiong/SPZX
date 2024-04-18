package com.xiong.spzx.manager.mapper;

import com.xiong.spzx.model.entity.product.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @title CategoryMapper
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 21:29
 */
@Mapper
public interface CategoryMapper {

    public abstract List<Category> selectByParentId(Long parentId);

    public abstract int countByParentId(Long id);

    public abstract List<Category> selectAll();

    public abstract void batchInsert(List<Category> categoryList);
}
