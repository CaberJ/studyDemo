package cn.caber.demo.dubbo.service.impl;

import cn.caber.demo.dubbo.service.HelloService;
import com.alibaba.dubbo.config.annotation.Service;


@Service
public class HelloServiceImpl implements HelloService {

    public String sayHello(String mes) {
        System.out.println("*****result="+mes);
        return mes;
    }
}
