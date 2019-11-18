package com.xsungroup.stomp.message.service.impl;

import com.xsungroup.stomp.message.common.BeanConverter;
import com.xsungroup.stomp.message.entity.MessageEntity;
import com.xsungroup.stomp.message.service.StompMessageService;
import com.xsungroup.stomp.message.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author 梁建军
 * 创建日期： 2019/11/15
 * 创建时间： 16:47
 * @version 1.0
 * @since 1.0
 */
@Service
public class StompMessageServiceImpl implements StompMessageService {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Override
    @Async
    public void send(MessageEntity messageEntity) {
        MessageVo messageVo = BeanConverter.convert(MessageVo.class, messageEntity);
        simpMessagingTemplate.convertAndSendToUser(messageVo.getUserId(), "/exchange/amq.direct/message.content", messageVo);
    }
}
