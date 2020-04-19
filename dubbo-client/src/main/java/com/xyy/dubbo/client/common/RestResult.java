package com.xyy.dubbo.client.common;

import lombok.Data;

/**
 * @Author: Xiongyy
 * @Date: 2020/4/12 15:58
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
public class RestResult <T>{

    public static final String STATUS_OK = "ok";

    public static final String STATUS_ERROR = "error";

    //状态码
    private String status = STATUS_OK;

    //返回的数据
    private T data;

    //异常信息
    private String errorMsg;

    public static <T> RestResult ok(T data){
        RestResult reslut = new RestResult();
        reslut.setData(data);
        return reslut;
    }
}
