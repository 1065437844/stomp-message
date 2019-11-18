package com.xsungroup.stomp.message;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 梁建军
 * 创建日期： 2019/11/18
 * 创建时间： 19:26
 * @version 1.0
 * @since 1.0
 */
@ComponentScan("com.xsungroup.stomp.message")
@EnableFeignClients("com.xsungroup.stomp.message")
public class AutoConfiguration {
}
