package cn.caber.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ProviderTest {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo-p.xml"});
        context.start();
        System.out.println("=============启动成功==============");
        System.in.read();
    }
}
