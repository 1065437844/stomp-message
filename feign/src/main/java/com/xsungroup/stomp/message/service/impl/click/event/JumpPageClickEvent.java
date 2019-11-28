package com.xsungroup.stomp.message.service.impl.click.event;

import lombok.Data;

/**
 * @author 梁建军
 * 创建日期： 2019/11/28
 * 创建时间： 17:02
 * @version 1.0
 * @since 1.0
 * 跳转页面
 */
public class JumpPageClickEvent implements ClickEvent<JumpPageClickEvent.Bean> {

    private Bean bean = new Bean();

    public JumpPageClickEvent(String name, String id) {
        bean.setName(name);
        bean.setId(id);
    }


    @Override
    public String getName() {
        return "JumpPage";
    }

    @Override
    public Bean getParameter() {
        return bean;
    }

    @Data
    public static class Bean {

        /**
         * 页面名称
         */
        private String name;

        /**
         * ID
         */
        private String id;

    }


    public static class Builder {
        private String name;

        private String id;

        public Builder() {
        }

        public JumpPageClickEvent.Builder setShowPage(ShowPage showPage, String id) {
            this.name = showPage.getName();
            this.id = id;
            return this;
        }

        public JumpPageClickEvent build() {
            return new JumpPageClickEvent(name, id);
        }
    }

    public interface ShowPage {

        /**
         * 页面名称
         */
        String getName();
    }
}
