package com.xiong.spzx.manager.service;

import com.github.pagehelper.PageInfo;
import com.xiong.spzx.model.dto.product.ProductDto;
import com.xiong.spzx.model.entity.product.Product;

/**
 * @title ProductService
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 23:36
 */
public interface ProductService {

    PageInfo<Product> findByPage(Integer page, Integer limit, ProductDto productDto);

    void save(Product product);

    Product getById(Long id);

    void updateById(Product product);

    void deleteById(Long id);

    void updateAuditStatus(Long id, Integer auditStatus);

    void updateStatus(Long id, Integer status);
}
