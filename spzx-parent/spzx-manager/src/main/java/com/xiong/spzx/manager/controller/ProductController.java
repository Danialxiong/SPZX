package com.xiong.spzx.manager.controller;

import com.github.pagehelper.PageInfo;
import com.xiong.spzx.manager.service.ProductService;
import com.xiong.spzx.model.dto.product.ProductDto;
import com.xiong.spzx.model.entity.product.Product;
import com.xiong.spzx.model.vo.common.Result;
import com.xiong.spzx.model.vo.common.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @title ProductController
 * @description: 商品管理控制器类
 * @author: laughing
 * @create: 4/18/24 23:36
 */
@RestController
@RequestMapping(value="/admin/product/product")
public class ProductController {

    @Autowired
    private ProductService productService ;

    /**
     * 分页查询商品
     * @param page 当前页
     * @param limit 每页显示的记录数
     * @param productDto 查询条件
     * @return Result
     */
    @GetMapping(value = "/{page}/{limit}")
    public Result<PageInfo<Product>> findByPage(@PathVariable Integer page, @PathVariable Integer limit, ProductDto productDto) {
        PageInfo<Product> pageInfo = productService.findByPage(page, limit, productDto);
        return Result.build(pageInfo , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 保存商品
     * @param product 商品实体类
     * @return Result
     */
    @PostMapping("/save")
    public Result save(@RequestBody Product product) {
        productService.save(product);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 根据id查询商品
     * @param id 商品id
     * @return Result
     */
    @GetMapping("/getById/{id}")
    public Result<Product> getById(@PathVariable Long id) {
        Product product = productService.getById(id);
        return Result.build(product , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 更新商品
     * @param product 商品实体类
     * @return Result
     */
    @PutMapping("/updateById")
    public Result updateById(@Parameter(name = "product", description = "请求参数实体类", required = true) @RequestBody Product product) {
        productService.updateById(product);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 删除商品
     * @param id 商品id
     * @return Result
     */
    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@Parameter(name = "id", description = "商品id", required = true) @PathVariable Long id) {
        productService.deleteById(id);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 更新审核状态
     * @param id 商品id
     * @param auditStatus 审核状态
     * @return Result
     */
    @GetMapping("/updateAuditStatus/{id}/{auditStatus}")
    public Result updateAuditStatus(@PathVariable Long id, @PathVariable Integer auditStatus) {
        productService.updateAuditStatus(id, auditStatus);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 更新状态
     * @param id 商品id
     * @param status 状态
     * @return Result
     */
    @GetMapping("/updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable Long id, @PathVariable Integer status) {
        productService.updateStatus(id, status);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }
}
