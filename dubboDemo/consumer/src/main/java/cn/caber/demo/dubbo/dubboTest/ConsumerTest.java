package cn.caber.demo.dubbo.dubboTest;

import cn.caber.demo.dubbo.service.HelloService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ConsumerTest {


    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-c.xml");
        context.start();
        HelloService helloService = (HelloService) context.getBean("helloService");

        String a = helloService.sayHello("nihao");
        System.out.println(a);
        System.in.read();


    }
}
