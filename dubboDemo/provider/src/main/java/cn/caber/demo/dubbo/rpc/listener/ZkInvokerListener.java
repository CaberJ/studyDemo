package cn.caber.demo.dubbo.rpc.listener;

import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Exporter;
import com.alibaba.dubbo.rpc.ExporterListener;
import com.alibaba.dubbo.rpc.RpcException;

@Activate
public class ZkInvokerListener implements ExporterListener {

    public void exported(Exporter<?> exporter) throws RpcException {
        System.out.println("************=进来了");
    }

    public void unexported(Exporter<?> exporter) {
        System.out.println("************=进来了");

    }
}
