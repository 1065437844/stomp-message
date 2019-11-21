package com.xsungroup.stomp.message.service;

import com.xsungroup.stomp.message.dto.MessageDto;
import com.xsungroup.stomp.message.entity.MessageEntity;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 开发者
 * @since 2019-11-15
 */
public interface MessageService {

    void create(MessageDto t);

    void ack(String userId, List<String> messageIds);

    List<MessageEntity> unAckHistory(String userId);

    void read(String name, List<String> messageIds);
}
