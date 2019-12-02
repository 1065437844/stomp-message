package com.xsungroup.stomp.message.service;

import java.util.List;

/**
 * @author 梁建军
 * 创建日期： 2019/11/19
 * 创建时间： 14:45
 * @version 1.0
 * @since 1.0
 */
public interface StompMessageAsyncService  {

    void remoteLogin(String userId, List<String> userSessionIds);

    void sendMessage(String userId, String title, String message);
}
