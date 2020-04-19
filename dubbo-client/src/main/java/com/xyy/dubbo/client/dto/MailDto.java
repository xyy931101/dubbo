package com.xyy.dubbo.client.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xiongyy
 * @Date: 2020/4/18 16:47
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
@Data
public class MailDto {

    private List<String> to = new ArrayList<>();

    private List<String> cc = new ArrayList<>();

    private String title;

    private String content;

}
