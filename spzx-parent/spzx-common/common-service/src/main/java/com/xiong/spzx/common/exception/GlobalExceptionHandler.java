package com.xiong.spzx.common.exception;

import com.xiong.spzx.model.vo.common.Result;
import com.xiong.spzx.model.vo.common.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @title GlobalExceptionHandler
 * @description: 统一异常处理类
 * @author: laughing
 * @create: 3/29/24 14:54
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // 全局异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result error(Exception e){
        logger.error(e.getMessage());
        return Result.build(null, ResultCodeEnum.SYSTEM_ERROR);
    }

    // 自定义异常处理
    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public Result error(CommonException e){
        return Result.build(null, e.getResultCodeEnum());
    }

}
