package com.xsungroup.stomp.message.vo;

import lombok.Data;

import java.util.List;

/**
 * @author 梁建军
 * 创建日期： 2019/11/13
 * 创建时间： 14:28
 * @version 1.0
 * @since 1.0
 */
@Data
public class UnAckHistoryMessageVo {

    private List<MessageVo> messageList;
}
