package com.xiong.spzx.manager.controller;

import com.xiong.spzx.manager.service.CategoryService;
import com.xiong.spzx.model.entity.product.Category;
import com.xiong.spzx.model.vo.common.Result;
import com.xiong.spzx.model.vo.common.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @title CategoryController
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 21:27
 */
@RestController
@RequestMapping(value = "/admin/product/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 根据parentId获取下级节点
     * @param parentId  父节点id
     * @return 下级节点
     */
    @Operation(summary = "根据parentId获取下级节点")
    @GetMapping(value = "/findByParentId/{parentId}")
    public Result<List<Category>> findByParentId(@PathVariable Long parentId) {
        List<Category> list = categoryService.findByParentId(parentId);
        return Result.build(list , ResultCodeEnum.SUCCESS) ;
    }

    /**
     * 导出数据
     * @param response 响应
     */
    @GetMapping(value = "/exportData")
    public void exportData(HttpServletResponse response) {
        categoryService.exportData(response);
    }

    /**
     * 导入数据
     * @param file  文件
     * @return 结果
     */
    @PostMapping("importData")
    public Result importData(MultipartFile file) {
        categoryService.importData(file);
        return Result.build(null , ResultCodeEnum.SUCCESS) ;
    }
}
