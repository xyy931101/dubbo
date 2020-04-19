package com.xyy.rabbitmq.publish;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: Xiongyy
 * @Date: 2020/4/18 12:54
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
public class Sender {

    private static final String Exchange_NAME = "publish_exchange";

    public static void main(String[] args) throws IOException, TimeoutException {

        //1.连接MQ服务器
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setHost("8.129.216.97");
        factory.setPort(5672);

        //2.发送消息给MQ服务器
        Connection connection = factory.newConnection();
        //3.基于channel连接会话
        Channel channel = connection.createChannel();
        //4.声明交换机
        channel.exchangeDeclare(Exchange_NAME, "fanout");

        //5.发布消息
        for (int i = 1; i <= 10 ; i++) {
            String msg = String.format("这是publish第%s次发送的消息!!!", i);
            channel.basicPublish(Exchange_NAME, "", null, msg.getBytes());

        }
        System.out.println("发送消息完毕!!!");
    }
}
