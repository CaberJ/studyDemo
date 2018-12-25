package cn.caber.demo.dubbo.consumer;

import cn.caber.demo.dubbo.service.HelloService;
import com.alibaba.dubbo.config.annotation.Reference;


public class DubboConsumer {

    @Reference
    private HelloService helloService;

    public String sayHello(String a){
        return helloService.sayHello(a);
    }
}
