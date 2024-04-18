package com.xiong.spzx.manager.mapper;

import com.xiong.spzx.model.dto.product.ProductDto;
import com.xiong.spzx.model.entity.product.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @title ProductMapper
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 23:36
 */
@Mapper
public interface ProductMapper {

    public abstract List<Product> findByPage(ProductDto productDto);

    public abstract void save(Product product);

    public abstract Product selectById(Long id);

    public abstract  void updateById(Product product);

    public abstract void deleteById(Long id);

}
