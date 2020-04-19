package com.xyy.mailclient.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.xyy.dubbo.client.dto.MailDto;
import com.xyy.dubbo.client.service.IMailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailMessage;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @Author: Xiongyy
 * @Date: 2020/4/18 16:59
 * .............................................
 * 佛祖保佑             永无BUG
 * 佛曰:
 * 写字楼里写字间，写字间里程序员；
 * 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠；
 * 酒醉酒醒日复日，网上网下年复年。
 * 但愿老死电脑间，不愿鞠躬老板前；
 * 奔驰宝马贵者趣，公交自行程序员。
 * 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？
 */
@Service
@Component
@Slf4j
public class MailServiceImpl implements IMailService {

    @Autowired
    JavaMailSender mailSender;

    @Value("${mail.address}")
    private String mailFrom;

    @Autowired
    TemplateEngine templateEngine;

    @Override
    @Async
    public void sendMailAsync(MailDto mail) {
        MimeMessage mailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(mailMessage, true);
            helper.setCc(mail.getCc().toArray(new String []{}));
            helper.setTo(mail.getTo().toArray(new String []{}));
            helper.setFrom(mailFrom);
            helper.setSubject(mail.getTitle());
            helper.setText(mail.getContent(), true);
            mailSender.send(mailMessage);
        } catch (MessagingException e) {
           log.error("send mail error:{}", e);
        }

    }
}
