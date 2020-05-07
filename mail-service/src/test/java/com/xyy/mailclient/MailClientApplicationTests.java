package com.xyy.mailclient;

import com.xyy.dubbo.client.dto.MailDto;
import com.xyy.dubbo.client.service.IMailService;
import com.xyy.dubbo.client.util.RandomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class MailClientApplicationTests {

    @Autowired
    private IMailService mailService;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {
        MailDto mail = new MailDto();
        mail.getTo().add("xiong965053171.com@qq.com");
        mail.setContent("今晚小龙虾,收到请回复");
        mail.setTitle("今晚安排!!!!");
        mailService.sendMailAsync(mail);
        System.out.println("发送邮件成功!!!!");
    }

    @Test
    public void save2Redis(){
        redisTemplate.opsForValue().set("boot:xyy:1", "boot:handsome");
        Object o = redisTemplate.opsForValue().get("boot:xyy:1");
        System.out.println(o);
    }

    @Test
    void saveCode2Redis(){
        // 验证码的手机号到redis
        String phoneNumber = "18850198317";
        // 生产redis的Key
        StringBuffer redisKey = new StringBuffer("register:code:").append(phoneNumber);
        // 生产随机的6位验证码
        String verifyCode = RandomUtil.getRandom(6);
        System.out.println(verifyCode);

        //4 将验证码保存到redis中
        redisTemplate.opsForValue().set(redisKey.toString(), verifyCode);
        //5 设置验证码的有效期
        redisTemplate.expire(redisKey.toString(), 5, TimeUnit.MINUTES);
        //6 发送短信验证码
        System.out.println("短信验证码发送成功!!!!");
    }

    @Test
    public void getCode4Phone(){
        // 验证码的手机号到redis
        String phoneNumber = "18850198317";
        // 生产redis的Key
        StringBuffer redisKey = new StringBuffer("register:code:").append(phoneNumber);

        Object o = redisTemplate.opsForValue().get(redisKey.toString());
        System.out.println(o);
    }
}
