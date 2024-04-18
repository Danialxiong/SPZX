package com.xiong.spzx.common.exception;

import com.xiong.spzx.model.vo.common.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @title CommonException
 * @description: 自定义异常类
 * @author: laughing
 * @create: 3/29/24 14:56
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CommonException extends RuntimeException {

    private Integer code;

    private String message;

    private ResultCodeEnum resultCodeEnum;

    public CommonException(ResultCodeEnum resultCodeEnum) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
        this.resultCodeEnum = resultCodeEnum;
    }
}
