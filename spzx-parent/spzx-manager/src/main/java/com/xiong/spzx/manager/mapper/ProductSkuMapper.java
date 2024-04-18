package com.xiong.spzx.manager.mapper;

import com.xiong.spzx.model.entity.product.ProductSku;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @title ProductSkuMapper
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 23:45
 */
@Mapper
public interface ProductSkuMapper {

    public abstract void save(ProductSku productSku);

    public abstract List<ProductSku> selectByProductId(Long id);

    public abstract  void updateById(ProductSku productSku);

    public abstract void deleteByProductId(Long id);
}
