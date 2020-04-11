package com.xyy.dubboboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xyy.dubbo.client.service.IUserService;
import org.springframework.stereotype.Component;

/**
 * @Author: Xiongyy
 * @Date: 2020/4/11 13:36
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
@Component   //spring组件
@Service    //dubbo服务的Service
public class UserServiceImpl implements IUserService {

    public String say() {
        System.out.println("这是在调用dubbo的提供者");
        return "this is the consumer!!!";
    }
}
