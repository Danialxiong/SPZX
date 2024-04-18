package com.xiong.spzx.manager.service;

import com.github.pagehelper.PageInfo;
import com.xiong.spzx.model.entity.product.Brand;

import java.util.List;

/**
 * @title BrandService
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 22:26
 */
public interface BrandService {
    PageInfo<Brand> findByPage(Integer page, Integer limit);

    void save(Brand brand);

    void updateById(Brand brand);

    void deleteById(Long id);

    List<Brand> findAll();
}
