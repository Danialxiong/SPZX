package com.xiong.spzx.manager.controller;

import com.github.pagehelper.PageInfo;
import com.xiong.spzx.manager.service.ProductSpecService;
import com.xiong.spzx.model.entity.product.ProductSpec;
import com.xiong.spzx.model.vo.common.Result;
import com.xiong.spzx.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title ProductSpecController
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 23:14
 */
@RestController
@RequestMapping(value="/admin/product/productSpec")
public class ProductSpecController {

    @Autowired
    private ProductSpecService productSpecService ;

    /**
     * 分页查询
     * @param page  当前页
     * @param limit 每页显示的记录数
     * @return 分页查询结果
     */
    @GetMapping("/{page}/{limit}")
    public Result<PageInfo<ProductSpec>> findByPage(@PathVariable Integer page, @PathVariable Integer limit) {
        PageInfo<ProductSpec> pageInfo = productSpecService.findByPage(page, limit);
        return Result.build(pageInfo , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 保存
     * @param productSpec 产品规格
     * @return 保存结果
     */
    @PostMapping("save")
    public Result save(@RequestBody ProductSpec productSpec) {
        productSpecService.save(productSpec);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 修改
     * @param productSpec 产品规格
     * @return 修改结果
     */
    @PutMapping("updateById")
    public Result updateById(@RequestBody ProductSpec productSpec) {
        productSpecService.updateById(productSpec);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 删除
     * @param id 产品规格id
     * @return 删除结果
     */
    @DeleteMapping("/deleteById/{id}")
    public Result removeById(@PathVariable Long id) {
        productSpecService.deleteById(id);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 查询所有
     * @return 查询结果
     */
    @GetMapping("findAll")
    public Result findAll() {
        List<ProductSpec> list = productSpecService.findAll();
        return Result.build(list , ResultCodeEnum.SUCCESS) ;
    }
}
