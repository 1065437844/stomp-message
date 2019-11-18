package com.xsungroup.stomp.message.common;

import java.security.Principal;

/**
 * @author 梁建军
 * 创建日期： 2019/11/15
 * 创建时间： 19:40
 * @version 1.0
 * @since 1.0
 */
public class UserPrincipal implements Principal {

    private String userId;

    private boolean tourist = false;

    public UserPrincipal(String userId, boolean tourist) {
        this.userId = userId;
        this.tourist = tourist;
    }

    public UserPrincipal(String userId) {
        this.userId = userId;
    }

    @Override
    public String getName() {
        return userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isTourist() {
        return tourist;
    }

    public void setTourist(boolean tourist) {
        this.tourist = tourist;
    }
}
