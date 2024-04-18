package com.xiong.spzx.manager.controller;

import com.github.pagehelper.PageInfo;
import com.xiong.spzx.manager.service.CategoryBrandService;
import com.xiong.spzx.model.dto.product.CategoryBrandDto;
import com.xiong.spzx.model.entity.product.Brand;
import com.xiong.spzx.model.entity.product.CategoryBrand;
import com.xiong.spzx.model.vo.common.Result;
import com.xiong.spzx.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @title CategoryBrandController
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 22:50
 */
@RestController
@RequestMapping(value = "/admin/product/categoryBrand")
public class CategoryBrandController {

    @Autowired
    private CategoryBrandService categoryBrandService ;

    /**
     * 分页查询
     * @param page 当前页
     * @param limit 每页显示的记录数
     * @param CategoryBrandDto 查询条件
     * @return 分页查询结果
     */
    @GetMapping("/{page}/{limit}")
    public Result<PageInfo<CategoryBrand>> findByPage(@PathVariable Integer page, @PathVariable Integer limit, CategoryBrandDto CategoryBrandDto) {
        PageInfo<CategoryBrand> pageInfo = categoryBrandService.findByPage(page, limit, CategoryBrandDto);
        return Result.build(pageInfo , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 保存
     * @param categoryBrand 分类品牌
     * @return 保存结果
     */
    @PostMapping("/save")
    public Result save(@RequestBody CategoryBrand categoryBrand) {
        categoryBrandService.save(categoryBrand);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 修改
     * @param categoryBrand 分类品牌
     * @return 修改结果
     */
    @PutMapping("updateById")
    public Result updateById(@RequestBody CategoryBrand categoryBrand) {
        categoryBrandService.updateById(categoryBrand);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 根据id删除
     * @param id 分类品牌id
     * @return 删除结果
     */
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Long id) {
        categoryBrandService.deleteById(id);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 根据分类id查询品牌
     * @param categoryId 分类id
     * @return 查询结果
     */
    @GetMapping("/findBrandByCategoryId/{categoryId}")
    public Result findBrandByCategoryId(@PathVariable Long categoryId) {
        List<Brand> brandList =   categoryBrandService.findBrandByCategoryId(categoryId);
        return Result.build(brandList , ResultCodeEnum.SUCCESS) ;
    }
}
