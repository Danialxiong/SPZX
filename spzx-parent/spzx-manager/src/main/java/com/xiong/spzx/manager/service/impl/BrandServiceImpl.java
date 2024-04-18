package com.xiong.spzx.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiong.spzx.manager.mapper.BrandMapper;
import com.xiong.spzx.manager.service.BrandService;
import com.xiong.spzx.model.entity.product.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title BrandServiceImpl
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 22:26
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper ;

    @Override
    public PageInfo<Brand> findByPage(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<Brand> brandList = brandMapper.findByPage() ;
        return new PageInfo(brandList);
    }

    @Override
    public void save(Brand brand) {
        brandMapper.save(brand) ;
    }

    @Override
    public void updateById(Brand brand) {
        brandMapper.updateById(brand) ;
    }

    @Override
    public void deleteById(Long id) {
        brandMapper.deleteById(id) ;
    }
}
