package cn.caber.dubboapi.provider;

import cn.caber.dubboapi.service.HelloService;
import cn.caber.dubboapi.service.impl.HelloServiceImpl;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;

import java.io.IOException;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/10 14:19
 */

public class provider {

    public static void main(String[] args) throws InterruptedException {
        HelloService helloService = new HelloServiceImpl();

        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("aaa");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://192.168.1.141:2181");
//        registry.setGroup("a");
//        registry.setPort(2181);
//        registry.setProtocol("dubbo");
//        registry.setUsername("aaa");
//        registry.setPassword("bbb");

        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(20883);
//        protocol.setThreads(200);

// 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口

        // 服务提供者暴露服务配置
        ServiceConfig<HelloService> service = new ServiceConfig<HelloService>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        service.setApplication(application);
        service.setRegistry(registry); // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
        service.setInterface(HelloService.class);
        service.setRef(helloService);
        service.setTimeout(50000);
        service.setVersion("1.0.0");

// 暴露及注册服务
        service.export();

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
