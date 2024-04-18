package com.xiong.spzx.manager.service;

import com.xiong.spzx.model.entity.product.Category;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @title CategoryService
 * @description: TODO
 * @author: laughing
 * @create: 4/18/24 21:28
 */
public interface CategoryService {

    List<Category> findByParentId(Long parentId);

    void exportData(HttpServletResponse response);

    void importData(MultipartFile file);
}
