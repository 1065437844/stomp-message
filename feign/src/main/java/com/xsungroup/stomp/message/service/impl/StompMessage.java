package com.xsungroup.stomp.message.service.impl;

import com.xsungroup.stomp.message.service.impl.click.event.ClickEvent;
import com.xsungroup.stomp.message.service.impl.show.type.ShowType;
import com.xsungroup.stomp.message.service.impl.trigger.event.TriggerEvent;
import lombok.Getter;

/**
 * @author 梁建军
 * 创建日期： 2019/11/18
 * 创建时间： 18:42
 * @version 1.0
 * @since 1.0
 */
@Getter
public class StompMessage {

    private final ClickEvent clickEvent;

    private final ShowType showType;

    private final TriggerEvent triggerEvent;

    private final boolean notification;

    private final String notificationTitle;

    private final String notificationContent;

    private final boolean showList;

    private final Long timeoutTime;

    private final String title;

    private final String content;

    private final StompMessageType type;

    private final String userId;

    public StompMessage(Builder builder) {
        this.clickEvent = builder.clickEvent;
        this.showType = builder.showType;
        this.triggerEvent = builder.triggerEvent;
        this.notification = builder.notification;
        this.notificationTitle = builder.notificationTitle;
        this.notificationContent = builder.notificationContent;
        this.showList = builder.showList;
        this.timeoutTime = builder.timeoutTime;
        this.title = builder.title;
        this.content = builder.content;
        this.type = builder.type;
        this.userId = builder.userId;
    }



    public static class Builder {

        private ClickEvent clickEvent;

        private ShowType showType;

        private TriggerEvent triggerEvent;

        private boolean notification;

        private String notificationTitle;

        private String notificationContent;

        private boolean showList;

        private Long timeoutTime;

        private String title;

        private String content;

        private StompMessageType type = StompMessageType.NOTIFICATION_MESSAGE;

        private String userId;

        public Builder setClickEvent(ClickEvent clickEvent) {
            this.clickEvent = clickEvent;
            return this;
        }

        public Builder setShowType(ShowType showType) {
            this.showType = showType;
            return this;
        }

        public Builder setTriggerEvent(TriggerEvent triggerEvent) {
            this.triggerEvent = triggerEvent;
            return this;
        }

        public Builder setNotification(boolean notification) {
            this.notification = notification;
            return this;
        }

        public Builder setNotificationTitle(String notificationTitle) {
            this.notificationTitle = notificationTitle;
            return this;
        }

        public Builder setNotificationContent(String notificationContent) {
            this.notificationContent = notificationContent;
            return this;
        }

        public Builder setShowList(boolean showList) {
            this.showList = showList;
            return this;
        }

        public Builder setTimeoutTime(Long timeoutTime) {
            this.timeoutTime = timeoutTime;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setType(StompMessageType type) {
            this.type = type;
            return this;
        }

        public Builder setUserId(String userId) {
            this.userId = userId;
            return this;
        }

        public StompMessage build() {
            return new StompMessage(this);
        }
    }


    public enum StompMessageType {


        NOTIFICATION_MESSAGE(1)/*通知消息*/,

        SERVICE_MESSAGE(2)/*服务消息*/;

        private final int type;

        StompMessageType(int type) {

            this.type = type;
        }

        public int getType() {
            return type;
        }
    }
}
