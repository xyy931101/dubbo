package com.xyy.dubboboot;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@ImportResource("classpath:dubbo-boot-provider.xml")
@SpringBootApplication
@EnableDubbo
public class DubboBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboBootApplication.class, args);
    }

}
