package com.xsungroup.stomp.message.common;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;

/**
 * @author 梁建军
 * 创建日期： 2019/11/19
 * 创建时间： 13:48
 * @version 1.0
 * @since 1.0
 */
public class LoginFailedException extends MessagingException {
    public LoginFailedException(Message<?> message, String userId) {
        super(message, "用户登录失败 " + userId);
    }
}
