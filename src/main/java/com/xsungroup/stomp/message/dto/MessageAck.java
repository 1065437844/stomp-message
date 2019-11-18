package com.xsungroup.stomp.message.dto;

import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @author 梁建军
 * 创建日期： 2019/11/13
 * 创建时间： 14:19
 * @version 1.0
 * @since 1.0
 */
@Data
public class MessageAck {

    public MessageAck(List<String> messageIds) {
        this.messageIds = messageIds;
    }

    public MessageAck() {
    }

    public MessageAck(String messageId) {
        messageIds = Collections.singletonList(messageId);
    }


    private List<String> messageIds;
}
