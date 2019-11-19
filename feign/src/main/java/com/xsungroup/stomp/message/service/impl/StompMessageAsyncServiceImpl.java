package com.xsungroup.stomp.message.service.impl;

import com.xsungroup.stomp.message.service.StompMessageAsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 梁建军
 * 创建日期： 2019/11/19
 * 创建时间： 14:45
 * @version 1.0
 * @since 1.0
 */
@Service
public class StompMessageAsyncServiceImpl extends StompMessageServiceImpl implements StompMessageAsyncService {
    @Override
    @Async
    public void remoteLogin(String userId, List<String> userSessionIds) {
        super.remoteLogin(userId, userSessionIds);
    }

    @Override
    @Async
    public void sendMessage(String userId, String title, String message) {
        super.sendMessage(userId, title, message);
    }
}
