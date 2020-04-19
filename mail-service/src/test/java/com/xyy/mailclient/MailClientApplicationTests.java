package com.xyy.mailclient;

import com.xyy.dubbo.client.dto.MailDto;
import com.xyy.dubbo.client.service.IMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MailClientApplicationTests {

    @Autowired
    private IMailService mailService;

    @Test
    void contextLoads() {
        MailDto mail = new MailDto();
        mail.getTo().add("xiong965053171.com@qq.com");
        mail.setContent("今晚小龙虾,收到请回复");
        mail.setTitle("今晚安排!!!!");
        mailService.sendMailAsync(mail);
        System.out.println("发送邮件成功!!!!");
    }

}
