package com.xiong.spzx.manager.service.impl;

import com.xiong.spzx.manager.mapper.ProductUnitMapper;
import com.xiong.spzx.manager.service.ProductUnitService;
import com.xiong.spzx.model.entity.base.ProductUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title ProductUnitServiceImpl
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 23:42
 */
@Service
public class ProductUnitServiceImpl implements ProductUnitService {

    @Autowired
    private ProductUnitMapper productUnitMapper ;

    @Override
    public List<ProductUnit> findAll() {
        return productUnitMapper.findAll() ;
    }

}
