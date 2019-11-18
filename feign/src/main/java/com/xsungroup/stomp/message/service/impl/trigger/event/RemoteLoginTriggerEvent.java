package com.xsungroup.stomp.message.service.impl.trigger.event;

import lombok.Data;

import java.util.List;

/**
 * @author 梁建军
 * 创建日期： 2019/11/18
 * 创建时间： 17:27
 * @version 1.0
 * @since 1.0
 */
public class RemoteLoginTriggerEvent implements TriggerEvent<RemoteLoginTriggerEvent.Bean> {

    private Bean bean = new Bean();

    private RemoteLoginTriggerEvent(List<String> userSessionIds) {
        this.bean.setUserSessionIds(userSessionIds);
    }

    @Override
    public String getName() {
        return "RemoteLogin";
    }

    @Override
    public Bean getParameter() {
        return bean;
    }

    @Data
    public static class Bean {
        private List<String> userSessionIds;
    }

    public static class Builder {
        private List<String> userSessionIds;

        public Builder() {
        }

        public Builder setUserSessionIds(List<String> userSessionIds) {
            this.userSessionIds = userSessionIds;
            return this;
        }

        public RemoteLoginTriggerEvent build() {
            return new RemoteLoginTriggerEvent(userSessionIds);
        }
    }
}
