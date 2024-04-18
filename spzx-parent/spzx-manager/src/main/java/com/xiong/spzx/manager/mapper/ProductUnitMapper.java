package com.xiong.spzx.manager.mapper;

import com.xiong.spzx.model.entity.base.ProductUnit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @title ProductUnitMapper
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 23:40
 */
@Mapper
public interface ProductUnitMapper {

    public abstract List<ProductUnit> findAll();

}
