package com.xiong.spzx.manager.mapper;

import com.xiong.spzx.model.entity.product.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @title BrandMapper
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 22:26
 */
@Mapper
public interface BrandMapper {

    public abstract List<Brand> findByPage();

    public abstract void save(Brand brand);

    public abstract void updateById(Brand brand);

    public abstract void deleteById(Long id);

    public abstract List<Brand> findAll();

}
