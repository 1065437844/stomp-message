package com.xsungroup.stomp.message.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 开发者
 * @since 2019-11-15 15:16:11
 */
@ApiModel("")
@ToString
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class MessageDto implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 点击事件
     */
    @ApiModelProperty("点击事件")
    private String clickEvent;


    /**
     * 点击事件参数
     */
    @ApiModelProperty("点击事件参数")
    private String clickEventParameterJson;


    /**
     * 消息内容
     */
    @ApiModelProperty("消息内容")
    private String content;


    /**
     * 是否在通知栏显示
     * 1 在通知了显示
     * 0 不在通知栏显示
     */
    @ApiModelProperty("是否在通知栏显示 1在通知了显示   0不在通知栏显示")
    private String isNotification;


    /**
     * 是否在消息列表中显示
     */
    @ApiModelProperty("是否在消息列表中显示")
    private String isShowList;


    /**
     * 通知栏内容
     */
    @ApiModelProperty("通知栏内容")
    private String notificationContent;


    /**
     * 通知栏标题
     */
    @ApiModelProperty("通知栏标题")
    private String notificationTitle;


    /**
     * 显示类型，用于定义多种不同的显示样式
     */
    @ApiModelProperty("显示类型，用于定义多种不同的显示样式")
    private String showType;


    /**
     * 用于自定义样式的数据
     */
    @ApiModelProperty("用于自定义样式的数据")
    private String showTypeParameterJson;


    /**
     * 消息样式类型 1 普通消息（标题和内容）  2 自定义消息（使用showType 的样式进行显示）
     * 当使用自定义消息的时候，客户端没有对应的showType的时候，将使用普通消息样式显示
     */
    @ApiModelProperty("消息样式类型 1 普通消息（标题和内容）  2 自定义消息（使用showType 的样式进行显示）   当使用自定义消息的时候，客户端没有对应的showType的时候，将使用普通消息样式显示")
    private Integer styleType;


    /**
     * 消息超时时间，超过这个时间将不好从消息通道中推送
     */
    @ApiModelProperty("消息超时时间，超过这个时间将不好从消息通道中推送")
    private Long timeoutTime;


    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;


    /**
     * 触发事件名称，接收到这条消息时候的处理
     */
    @ApiModelProperty("触发事件名称，接收到这条消息时候的处理")
    private String triggerEvent;


    /**
     * 触发事件参数
     */
    @ApiModelProperty("触发事件参数")
    private String triggerEventParameterJson;


    /**
     * 消息类型 1 ：通知消息 2：服务消息
     */
    @ApiModelProperty("消息类型 1 ：通知消息 2：服务消息")
    private Integer type;


    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String userId;


    public interface Create {
    }

    public interface Update {
    }
}
