package com.openadmin.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.openadmin")
@MapperScan("com.openadmin.**.mapper")
public class OpenAdminApplication {
    public static void main(String[] args) { SpringApplication.run(OpenAdminApplication.class, args); }
}
