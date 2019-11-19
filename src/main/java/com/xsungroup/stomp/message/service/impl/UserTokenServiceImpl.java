package com.xsungroup.stomp.message.service.impl;

import com.xsungroup.stomp.message.common.LoginFailedException;
import com.xsungroup.stomp.message.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 梁建军
 * 创建日期： 2019/11/19
 * 创建时间： 10:48
 * @version 1.0
 * @since 1.0
 */
@Service
public class UserTokenServiceImpl implements UserTokenService {

    String LOING_SHIRO_JWT_ID = "login:shiro:jwt:id:";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public String getUserId(String userId, String token) {
        String redisKey = LOING_SHIRO_JWT_ID + userId;
        final String redisToken = stringRedisTemplate.opsForValue().get(redisKey);
        if (!Objects.equals(token, redisToken)) {
            Map<String, Object> headers = new HashMap<>();
            headers.put("errorType", "login_failed");
            Message<String> message = new GenericMessage<>("登录失败", headers);
            throw new LoginFailedException(message);
        }
        return userId;
    }


}
