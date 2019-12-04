package com.xsungroup.stomp.message.service.impl;

import com.xsungroup.stomp.message.service.StompMessageAsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author 梁建军
 * 创建日期： 2019/11/19
 * 创建时间： 14:45
 * @version 1.0
 * @since 1.0
 */
@Service
@Async
public class StompMessageAsyncServiceImpl extends StompMessageServiceImpl implements StompMessageAsyncService {

}
