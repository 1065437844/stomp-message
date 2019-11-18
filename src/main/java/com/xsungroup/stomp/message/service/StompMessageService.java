package com.xsungroup.stomp.message.service;

import com.xsungroup.stomp.message.entity.MessageEntity;

/**
 * @author 梁建军
 * 创建日期： 2019/11/15
 * 创建时间： 16:47
 * @version 1.0
 * @since 1.0
 */
public interface StompMessageService {
    void send(MessageEntity messageEntity);
}
