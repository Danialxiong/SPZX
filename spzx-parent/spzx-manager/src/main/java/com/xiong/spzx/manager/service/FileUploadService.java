package com.xiong.spzx.manager.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @title FileUploadService
 * @description: TODO
 * @author: laughing
 * @create: 4/11/24 19:11
 */
public interface FileUploadService {
    String fileUpload(MultipartFile multipartFile);
}
