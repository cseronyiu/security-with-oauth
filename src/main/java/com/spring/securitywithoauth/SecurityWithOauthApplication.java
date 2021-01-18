package com.spring.securitywithoauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
public class SecurityWithOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityWithOauthApplication.class, args);
    }

}
