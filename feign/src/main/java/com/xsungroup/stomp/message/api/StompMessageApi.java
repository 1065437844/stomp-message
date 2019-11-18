package com.xsungroup.stomp.message.api;

import com.xsungroup.stomp.message.dto.MessageDto;
import com.xsungroup.stomp.message.vo.ResponseInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 梁建军
 * 创建日期： 2019/11/18
 * 创建时间： 17:10
 * @version 1.0
 * @since 1.0
 */
@Component
@FeignClient(value = "xinya-message", url = "${xinya-message}")
public interface StompMessageApi {

    @ApiOperation(value = "新增")
    @PostMapping("/api/message/create")
    ResponseInfo create(@RequestBody @Validated MessageDto t);
}
