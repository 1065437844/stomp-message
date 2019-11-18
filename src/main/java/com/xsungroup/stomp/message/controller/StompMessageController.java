package com.xsungroup.stomp.message.controller;

import com.xsungroup.stomp.message.common.BeanConverter;
import com.xsungroup.stomp.message.dto.MessageAck;
import com.xsungroup.stomp.message.entity.MessageEntity;
import com.xsungroup.stomp.message.service.MessageService;
import com.xsungroup.stomp.message.vo.MessageVo;
import com.xsungroup.stomp.message.vo.UnAckHistoryMessageVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.List;

/**
 * @author 梁建军
 * 创建日期： 2019/11/13
 * 创建时间： 14:15
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@Controller
public class StompMessageController {


    @Autowired
    private MessageService messageService;

    /**
     * 消息确认
     */
    @MessageMapping("message.ack")
    public void ack(MessageAck message, Principal principal) {
        log.info("用户{} 确定了消息 {}", principal.getName(), message.getMessageIds());
        messageService.ack(principal.getName(), message.getMessageIds());
    }

    /**
     * 未确认消息历史
     */
    @MessageMapping("message.unAckHistory")
    @SendToUser(value = "/exchange/amq.direct/message.unAckHistory", broadcast = false)
    public UnAckHistoryMessageVo unAckHistory(Principal principal) {

        UnAckHistoryMessageVo unAckHistoryMessageVo = new UnAckHistoryMessageVo();

        final List<MessageEntity> messageEntities = messageService.unAckHistory(principal.getName());

        unAckHistoryMessageVo.setMessageList(BeanConverter.convert(MessageVo.class, messageEntities));
        return unAckHistoryMessageVo;
    }
}
