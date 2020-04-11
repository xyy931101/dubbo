package com.xyy.dubbo.bootconsumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xyy.dubbo.client.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootConsumerApplicationTests {

    @Reference
    private IUserService userService;

    @Test
    public void contextLoads() {
        for (int i = 0; i < 4; i++) {
            System.out.println(userService.say());
        }
    }

    @Test
    public void consumerTest(){

    }


}
