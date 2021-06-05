package com.gk.minidaodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"config/spring-minidao.xml"})
public class MinidaodemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinidaodemoApplication.class, args);
    }

}
