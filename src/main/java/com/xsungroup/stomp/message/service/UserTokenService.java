package com.xsungroup.stomp.message.service;

/**
 * @author 梁建军
 * 创建日期： 2019/11/19
 * 创建时间： 10:46
 * @version 1.0
 * @since 1.0
 */

public interface UserTokenService {
    /**
     * 根据令牌获取用户Id
     *
     * @param token 用户令牌
     * @return 用户ID
     */
    String getUserId(String userId, String token);
}
