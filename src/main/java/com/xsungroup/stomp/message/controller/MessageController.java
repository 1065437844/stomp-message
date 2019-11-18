package com.xsungroup.stomp.message.controller;


import com.xsungroup.stomp.message.dto.MessageDto;
import com.xsungroup.stomp.message.service.MessageService;
import com.xsungroup.stomp.message.vo.ResponseInfo;
import com.xsungroup.stomp.message.vo.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 开发者
 * @since 2019-11-15
 */
@Api(tags = "")
@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    private MessageService messageService;
    /**
     * 新增方法
     */
    @ApiOperation(value = "新增")
    @PostMapping("/create")
    public ResponseInfo create(@RequestBody @Validated MessageDto t) {
        messageService.create(t);
        return ResponseUtil.success();
    }
}

