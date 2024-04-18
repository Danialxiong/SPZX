package com.xiong.spzx.manager.service;

import com.github.pagehelper.PageInfo;
import com.xiong.spzx.model.entity.product.ProductSpec;

import java.util.List;

/**
 * @title ProductSpecService
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 23:15
 */
public interface ProductSpecService {

    PageInfo<ProductSpec> findByPage(Integer page, Integer limit);

    void save(ProductSpec productSpec);

    void updateById(ProductSpec productSpec);

    void deleteById(Long id);

    List<ProductSpec> findAll();
}
