package com.xiong.spzx.manager.mapper;

import com.xiong.spzx.model.entity.product.ProductDetails;
import org.apache.ibatis.annotations.Mapper;

/**
 * @title ProductDetailsMapper
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 23:46
 */
@Mapper
public interface ProductDetailsMapper {

    public abstract void save(ProductDetails productDetails);

    public abstract ProductDetails selectByProductId(Long id);

    public abstract void updateById(ProductDetails productDetails);

    public abstract void deleteByProductId(Long id);
}
