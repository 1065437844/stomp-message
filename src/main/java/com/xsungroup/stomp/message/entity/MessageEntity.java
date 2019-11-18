package com.xsungroup.stomp.message.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author 开发者
 * @since 2019-11-15
 */
@Data
@Accessors(chain = true)
@TableName("m_message")
public class MessageEntity {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.UUID)
    private String messageId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 消息类型 1 ：通知消息 2：服务消息
     */
    private Integer type;
    /**
     * 是否在消息列表中显示
     */
    private Integer isShowList;
    /**
     * 标题
     */
    private String title;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 消息样式类型 1 普通消息（标题和内容）  2 自定义消息（使用showType 的样式进行显示）
     * 当使用自定义消息的时候，客户端没有对应的showType的时候，将使用普通消息样式显示
     */
    private Integer styleType;
    /**
     * 显示类型，用于定义多种不同的显示样式
     */
    private String showType;
    /**
     * 用于自定义样式的数据
     */
    private String showTypeParameterJson;
    /**
     * 点击事件
     */
    private String clickEvent;
    /**
     * 点击事件参数
     */
    private String clickEventParameterJson;
    /**
     * 触发事件名称，接收到这条消息时候的处理
     */
    private String triggerEvent;
    /**
     * 触发事件参数
     */
    private String triggerEventParameterJson;
    /**
     * 是否在通知栏显示
     * 1 在通知了显示
     * 0 不在通知栏显示
     */
    private Integer isNotification;
    /**
     * 通知栏标题
     */
    private String notificationTitle;
    /**
     * 通知栏内容
     */
    private String notificationContent;
    /**
     * 已读
     */
    private Integer isRead;
    /**
     * 读取时间
     */
    private Long readTime;
    /**
     * 消息是否在消息通道确认
     */
    private Integer isAck;
    /**
     * 消息确认时间
     */
    private Long ackTime;
    /**
     * 消息超时时间，超过这个时间将不好从消息通道中推送
     */
    private Long timeoutTime;
    private Integer isAble;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;


}
