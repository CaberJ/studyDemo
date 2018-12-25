package cn.caber.demo.dubbo.rpc.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import org.springframework.core.annotation.Order;


@Activate(group = {Constants.CONSUMER},order = 1)
public class TestFilter1 implements Filter {
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("测试order1");
        Result invoke = invoker.invoke(invocation);
        return invoke;
    }
}
