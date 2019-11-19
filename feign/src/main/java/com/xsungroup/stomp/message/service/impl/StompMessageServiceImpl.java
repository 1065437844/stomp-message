package com.xsungroup.stomp.message.service.impl;

import com.alibaba.fastjson.JSON;
import com.xsungroup.stomp.message.api.StompMessageApi;
import com.xsungroup.stomp.message.dto.MessageDto;
import com.xsungroup.stomp.message.service.StompMessageService;
import com.xsungroup.stomp.message.service.impl.click.event.ClickEvent;
import com.xsungroup.stomp.message.service.impl.show.type.ShowType;
import com.xsungroup.stomp.message.service.impl.trigger.event.RemoteLoginTriggerEvent;
import com.xsungroup.stomp.message.service.impl.trigger.event.TriggerEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 梁建军
 * 创建日期： 2019/11/18
 * 创建时间： 17:14
 * @version 1.0
 * @since 1.0
 */
@Service
public class StompMessageServiceImpl implements StompMessageService {

    @Autowired
    private StompMessageApi stompMessageApi;


    @Override
    public void remoteLogin(String userId, List<String> userSessionIds) {
        final StompMessage stompMessage = new StompMessage.Builder()
                .setUserId(userId)
                .setTriggerEvent(
                        new RemoteLoginTriggerEvent.Builder()
                                .setUserSessionIds(userSessionIds)
                                .build()
                )
                .build();
        sendMessage(stompMessage);
    }

    @Override
    public void sendMessage(String userId, String title, String message) {
        final StompMessage stompMessage = new StompMessage.Builder()
                .setUserId(userId)
                .setTitle(title)
                .setContent(message)
                .setNotification(true)
                .setNotificationTitle(title)
                .setNotificationContent(message)
                .setShowList(true)
                .build();
        sendMessage(stompMessage);
    }

    private void sendMessage(StompMessage stompMessage) {
        MessageDto messageDto = new MessageDto();
        final ClickEvent clickEvent = stompMessage.getClickEvent();
        if (clickEvent != null) {
            messageDto.setClickEvent(clickEvent.getName());
            messageDto.setClickEventParameterJson(JSON.toJSONString(clickEvent.getParameter()));
        }
        messageDto.setContent(stompMessage.getContent());
        messageDto.setIsNotification(stompMessage.isNotification() ? 1 : 0);
        messageDto.setIsShowList(stompMessage.isShowList() ? 1 : 0);
        messageDto.setNotificationContent(stompMessage.getNotificationContent());
        messageDto.setNotificationTitle(stompMessage.getNotificationTitle());
        final ShowType showType = stompMessage.getShowType();
        if (showType != null) {
            messageDto.setShowType(showType.getName());
            messageDto.setShowTypeParameterJson(JSON.toJSONString(showType.getParameter()));
            messageDto.setStyleType(2);
        } else {
            messageDto.setStyleType(1);

        }
        messageDto.setTimeoutTime(stompMessage.getTimeoutTime());
        messageDto.setTitle(stompMessage.getTitle());
        final TriggerEvent triggerEvent = stompMessage.getTriggerEvent();
        if (triggerEvent != null) {
            messageDto.setTriggerEvent(triggerEvent.getName());
            messageDto.setTriggerEventParameterJson(JSON.toJSONString(triggerEvent.getParameter()));
        }
        messageDto.setType(stompMessage.getType().getType());
        messageDto.setUserId(stompMessage.getUserId());
        stompMessageApi.create(messageDto);
    }
}
