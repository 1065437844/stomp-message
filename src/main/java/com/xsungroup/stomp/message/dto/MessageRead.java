package com.xsungroup.stomp.message.dto;

import lombok.Data;

import java.util.List;

/**
 * @author 梁建军
 * 创建日期： 2019/11/20
 * 创建时间： 11:44
 * @version 1.0
 * @since 1.0
 */
@Data
public class MessageRead {
    /**
     * 消息地址
     */
    private List<String> messageIds;
}
