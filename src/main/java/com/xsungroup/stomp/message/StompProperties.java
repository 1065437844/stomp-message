package com.xsungroup.stomp.message;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 梁建军
 * 创建日期： 2019/9/26
 * 创建时间： 9:58
 * @version 1.0
 * @since 1.0
 */
@ConfigurationProperties(prefix = "spring.stomp")
public class StompProperties {

    private String relayHost = "127.0.0.1";

    private int relayPort = 61613;

    private String clientLogin = "guest";

    private String clientPasscode = "guest";

    private String systemLogin = "guest";

    private String systemPasscode = "guest";

    public String getRelayHost() {
        return relayHost;
    }

    public void setRelayHost(String relayHost) {
        this.relayHost = relayHost;
    }

    public int getRelayPort() {
        return relayPort;
    }

    public void setRelayPort(int relayPort) {
        this.relayPort = relayPort;
    }

    public String getClientLogin() {
        return clientLogin;
    }

    public void setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;
    }

    public String getClientPasscode() {
        return clientPasscode;
    }

    public void setClientPasscode(String clientPasscode) {
        this.clientPasscode = clientPasscode;
    }

    public String getSystemLogin() {
        return systemLogin;
    }

    public void setSystemLogin(String systemLogin) {
        this.systemLogin = systemLogin;
    }

    public String getSystemPasscode() {
        return systemPasscode;
    }

    public void setSystemPasscode(String systemPasscode) {
        this.systemPasscode = systemPasscode;
    }
}
