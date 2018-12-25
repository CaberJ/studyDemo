package cn.caber.demo.dubbo.rpc.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;


@Activate(group = {Constants.CONSUMER},order = 2)
public class TestFilter2 implements Filter {
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("测试order2");
        Result invoke = invoker.invoke(invocation);
        return invoke;
    }
}
