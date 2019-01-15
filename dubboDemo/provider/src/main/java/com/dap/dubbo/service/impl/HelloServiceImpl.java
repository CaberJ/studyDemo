package com.dap.dubbo.service.impl;


import com.dap.dubbo.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String  sayHello(String msg) {
        System.out.println("调用方法[sayHello]:"+msg);
        return msg;
    }
}
