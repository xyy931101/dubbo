package com.xyy.dubbo.client.filter;

import com.alibaba.dubbo.rpc.*;

/**
 * @Author: Xiongyy
 * @Date: 2020/12/28 19:43
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class MyFilter implements Filter {


    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("这是一个filter");
        return invoker.invoke(invocation);
    }

}
