package com.xiong.spzx.manager.service;

import com.github.pagehelper.PageInfo;
import com.xiong.spzx.model.dto.product.CategoryBrandDto;
import com.xiong.spzx.model.entity.product.CategoryBrand;

/**
 * @title CategoryBrandService
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 22:51
 */
public interface CategoryBrandService {

    PageInfo<CategoryBrand> findByPage(Integer page, Integer limit, CategoryBrandDto categoryBrandDto);

    void save(CategoryBrand categoryBrand);

    void updateById(CategoryBrand categoryBrand);

    void deleteById(Long id);
}
