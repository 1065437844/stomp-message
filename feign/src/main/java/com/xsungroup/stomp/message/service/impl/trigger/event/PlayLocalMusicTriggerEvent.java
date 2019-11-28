package com.xsungroup.stomp.message.service.impl.trigger.event;

import lombok.Data;

/**
 * @author 梁建军
 * 创建日期： 2019/11/28
 * 创建时间： 16:47
 * @version 1.0
 * @since 1.0
 * 播放机音乐
 */
public class PlayLocalMusicTriggerEvent implements TriggerEvent<PlayLocalMusicTriggerEvent.Bean> {

    private Bean bean = new Bean();

    public PlayLocalMusicTriggerEvent(String name) {
        bean.setName(name);
    }

    @Override
    public String getName() {
        return "PlayLocalMusic";
    }

    @Override
    public PlayLocalMusicTriggerEvent.Bean getParameter() {
        return bean;
    }

    /**
     * 音乐名称
     */
    @Data
    public static class Bean {

        /**
         * 音乐名称
         */
        private String name;

    }


    public static class Builder {
        private String name;

        public Builder() {
        }

        public PlayLocalMusicTriggerEvent.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public PlayLocalMusicTriggerEvent build() {
            return new PlayLocalMusicTriggerEvent(name);
        }
    }
}
