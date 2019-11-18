package com.xsungroup.stomp.message.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xsungroup.stomp.message.common.BeanConverter;
import com.xsungroup.stomp.message.dto.MessageDto;
import com.xsungroup.stomp.message.entity.MessageEntity;
import com.xsungroup.stomp.message.mapper.MessageMapper;
import com.xsungroup.stomp.message.service.MessageService;
import com.xsungroup.stomp.message.service.StompMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 开发者
 * @since 2019-11-15
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, MessageEntity> implements MessageService {

    @Autowired
    private StompMessageService stompMessageService;

    @Override
    public void create(MessageDto t) {
        MessageEntity messageEntity = BeanConverter.convert(MessageEntity.class, t);
        messageEntity.setGmtCreate(LocalDateTime.now());
        messageEntity.setGmtModified(LocalDateTime.now());
        save(messageEntity);
        stompMessageService.send(messageEntity);
    }

    @Async
    @Override
    public void ack(String userId, List<String> messageIds) {
        UpdateWrapper<MessageEntity> wrapper = new UpdateWrapper<>();
        wrapper.in("message_id", messageIds);
        wrapper.eq("user_id", userId);
        wrapper.set("is_ack", 1);
        wrapper.set("ack_time", System.currentTimeMillis());
        update(wrapper);
    }

    @Override
    public List<MessageEntity> unAckHistory(String userId) {
        QueryWrapper<MessageEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        wrapper.eq("is_ack", 0);
        wrapper.gt("timeout_time", System.currentTimeMillis());
        return list(wrapper);
    }
}
