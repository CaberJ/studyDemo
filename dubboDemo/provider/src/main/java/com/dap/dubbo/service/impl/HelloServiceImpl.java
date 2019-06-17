package com.dap.dubbo.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.dap.dubbo.service.HelloService;

@Service(protocol = "rest")
public class HelloServiceImpl implements HelloService {
    @Override
    public String  sayHello(String msg) {
        System.out.println("调用方法[sayHello]:"+msg);
        return msg;
    }
}
