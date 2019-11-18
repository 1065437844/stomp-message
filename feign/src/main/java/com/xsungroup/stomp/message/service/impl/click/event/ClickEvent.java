package com.xsungroup.stomp.message.service.impl.click.event;

/**
 * @author 梁建军
 * 创建日期： 2019/11/18
 * 创建时间： 18:44
 * @version 1.0
 * @since 1.0
 */
public interface ClickEvent<T> {

    /**
     * 名称
     *
     * @return 名称
     */
    String getName();

    /**
     * 参数
     *
     * @return 参数
     */
    T getParameter();
}
