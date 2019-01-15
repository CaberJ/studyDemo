package com.dap.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppProvider {
    public static void main(String[] args) throws Exception {
        System.setProperty("java.net.preferIPv4Stack", "true");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-p.xml"});
        context.start();
        System.out.println("Provider started.");
        System.out.println("========================app1启动成功=======================");
        System.in.read(); // press any key to exit

    }
}
