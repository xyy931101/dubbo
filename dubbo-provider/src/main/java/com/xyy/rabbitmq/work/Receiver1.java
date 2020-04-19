package com.xyy.rabbitmq.work;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: Xiongyy
 * @Date: 2020/4/18 13:11
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
public class Receiver1 {

    private static final String QUEUE_NAME = "work_queue";

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

        //4.声明消费者
        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //来处理接受的参数信息
                String message = new String(body, "utf-8");
                System.out.println("消费者1接受到的消息为:" + message);
            }
        };

        //5.让消费者取监听队列
        //autoAck 为true时 自动回复模式
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}
