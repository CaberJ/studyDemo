package com.dap.dubbo.service;

public class TestHello implements Runnable{
    private int i;
    private HelloService helloService;
    public TestHello(int i,HelloService helloService) {
        this.i=i;
        this.helloService=helloService;
    }

    @Override
    public void run() {
        System.out.println(i + "resultVV==" + helloService.sayHello("hello world"+i));

    }
}
