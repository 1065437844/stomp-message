package com.xsungroup.stomp.message.controller;

import com.xsungroup.stomp.message.dto.LocationMessageDto;
import com.xsungroup.stomp.message.dto.MessageAck;
import com.xsungroup.stomp.message.entity.MapLocationEntity;
import com.xsungroup.stomp.message.service.MapLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.UUID;

/**
 * @author 梁建军
 * 创建日期： 2019/11/15
 * 创建时间： 19:54
 * @version 1.0
 * @since 1.0
 */
@Controller
public class LocationController {

    @Autowired
    private MapLocationService mapLocationService;

    /**
     * 消息确认
     */
    @MessageMapping("location")
    @SendToUser(value = "/exchange/amq.direct/message.ack", broadcast = false)
    public MessageAck location(LocationMessageDto message, Principal principal) {

        //纠正时间，当上传的时间与服务器时间差大于五分钟，就会把时间修改到5分钟内
        if (message.getLocationList().size() > 0) {
            final MapLocationEntity mapLocationEntity = message.getLocationList().get(0);
            if (mapLocationEntity.getTime() != null) {
                final long l = System.currentTimeMillis() - mapLocationEntity.getTime() - 5 * 60 * 1000;
                if (l > 0 || l < -(5 * 60 * 100)) {
                    for (MapLocationEntity locationEntity : message.getLocationList()) {
                        if (locationEntity.getTime() == null) {
                            locationEntity.setTime(System.currentTimeMillis() - 5 * 60 * 1000);
                        } else {
                            locationEntity.setTime(locationEntity.getTime() + l);
                        }
                    }
                }
            }
        }

        for (MapLocationEntity mapLocationEntity : message.getLocationList()) {
            mapLocationEntity.setId(UUID.randomUUID().toString().replace("-", ""));
            mapLocationEntity.setUserId(principal.getName());
        }

        mapLocationService.saveOrUpdateBatch(message.getLocationList());

        return new MessageAck(message.getMessageId());

    }

}
