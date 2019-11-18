package com.xsungroup.stomp.message.service;

import java.util.List;

/**
 * @author 梁建军
 * 创建日期： 2019/11/18
 * 创建时间： 17:13
 * @version 1.0
 * @since 1.0
 */
public interface StompMessageService {


    void remoteLogin(String userId, List<String> userSessionIds);

}
