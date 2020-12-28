package com.xyy.dubbo.consumer;

import com.alibaba.dubbo.config.ReferenceConfig;
import com.xyy.dubbo.client.service.IUserService;

/**
 * @Author: Xiongyy
 * @Date: 2020/12/23 20:09
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ApiConsumer {

    public static void main(String[] args) {
        //1)创建引用对象实例
        ReferenceConfig<IUserService> referenceConfig = new ReferenceConfig<>();

        //2)设置应用程序信息
    }
}
