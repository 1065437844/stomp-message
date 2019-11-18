package com.xsungroup.stomp.message.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @description: 信息返回实体封装
 * @author: kingJing
 * @Date: 2019/7/8 14:54
 */
@Data
public class ResponseInfo<T> implements Serializable {

    private int code;

    private String message;

    private T data;
    /**
     * 发生错误的解决方案或原因
     */
    @ApiModelProperty(value = "在调试过程中的解决方案，帮助解决问题，不能用于显示 ", hidden = true)
    private String resolvent;
}
