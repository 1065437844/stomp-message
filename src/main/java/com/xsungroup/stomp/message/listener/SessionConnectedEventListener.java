package com.xsungroup.stomp.message.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

/**
 * @author 梁建军
 * 创建日期： 2019/11/13
 * 创建时间： 17:02
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@Component
public class SessionConnectedEventListener implements ApplicationListener<SessionConnectedEvent> {
    @Override
    public void onApplicationEvent(SessionConnectedEvent event) {
        log.info("用户 {} 连接成功", event.getUser().getName());

    }
}
