package com.xiong.spzx.manager.mapper;

import com.xiong.spzx.model.entity.product.ProductSpec;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @title ProductSpecMapper
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 23:15
 */
@Mapper
public interface ProductSpecMapper {

    public abstract List<ProductSpec> findByPage();

    public abstract void save(ProductSpec productSpec);

    public abstract void updateById(ProductSpec productSpec);

    public abstract void deleteById(Long id);
}
