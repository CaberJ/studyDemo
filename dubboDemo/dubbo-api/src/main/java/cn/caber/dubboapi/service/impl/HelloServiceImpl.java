package cn.caber.dubboapi.service.impl;

import cn.caber.dubboapi.service.HelloService;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/10 15:05
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String mesg) {
        System.out.println("消息是:"+mesg);
        return "消息是:"+mesg;
    }
}
