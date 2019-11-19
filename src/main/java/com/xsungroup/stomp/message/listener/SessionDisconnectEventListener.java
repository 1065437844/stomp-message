package com.xsungroup.stomp.message.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.security.Principal;

/**
 * @author 梁建军
 * 创建日期： 2019/11/13
 * 创建时间： 17:04
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@Component
public class SessionDisconnectEventListener implements ApplicationListener<SessionDisconnectEvent> {
    @Override
    public void onApplicationEvent(SessionDisconnectEvent event) {
        final Principal user = event.getUser();
        if (user == null) {
            return;
        }
        log.info("用户 {} 断开", user.getName());
    }
}
