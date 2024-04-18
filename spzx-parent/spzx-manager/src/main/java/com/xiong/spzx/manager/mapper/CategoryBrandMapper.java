package com.xiong.spzx.manager.mapper;

import com.xiong.spzx.model.dto.product.CategoryBrandDto;
import com.xiong.spzx.model.entity.product.CategoryBrand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @title CategoryBrandMapper
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 22:51
 */
@Mapper
public interface CategoryBrandMapper {

    public abstract List<CategoryBrand> findByPage(CategoryBrandDto CategoryBrandDto);

    public abstract void save(CategoryBrand categoryBrand);

    public abstract void updateById(CategoryBrand categoryBrand);

    public abstract void deleteById(Long id);

}
