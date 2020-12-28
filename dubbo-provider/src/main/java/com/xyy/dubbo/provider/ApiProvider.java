package com.xyy.dubbo.provider;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.xyy.dubbo.client.service.IUserService;

import java.io.IOException;

/**
 * @Author: Xiongyy
 * @Date: 2020/12/23 19:57
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ApiProvider {
    public static void main(String[] args) throws IOException {
        //1）创建serviceConfig实例
        ServiceConfig<IUserService> serviceServiceConfig = new ServiceConfig<>();

        //2)设置应用程序配置
        serviceServiceConfig.setApplication(new ApplicationConfig("first-dubbo-provider"));

        //3)设置注册中心信息
        RegistryConfig registryConfig = new RegistryConfig("zookeeper://8.129.216.97:2181");
        serviceServiceConfig.setRegistry(registryConfig);

        //4)设置接口与实现类
        serviceServiceConfig.setInterface(IUserService.class);
        serviceServiceConfig.setRef(new IUserServiceImpl());

        //5)设置分组服务与版本
        serviceServiceConfig.setVersion("1.0.0");
        serviceServiceConfig.setGroup("META-INF/dubbo");

        //6)设置

        //7)导出服务(启用Netty监听服务请求)
        serviceServiceConfig.export();

        //8)花旗服务
        System.out.println("Dubbo start....");
        System.in.read();
   }
}
