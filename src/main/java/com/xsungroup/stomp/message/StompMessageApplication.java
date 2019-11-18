package com.xsungroup.stomp.message;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
@MapperScan(basePackages = {"com.xsungroup.stomp.message.mapper"})
public class StompMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StompMessageApplication.class, args);
    }

}
