package com.xyy.dubbo.client.filter;

import com.alibaba.dubbo.rpc.*;

/**
 * @Author: Xiongyy
 * @Date: 2020/12/28 19:43
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class AddParamFilter implements Filter {


    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext.getContext().setAttachment("xyyToken", "xyy在测试Dubbo");
        System.out.println("这是一个filter");
        Result result = invoker.invoke(invocation);
        System.out.println(result);
        return result;
    }

}
