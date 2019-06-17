package cn.caber.dubboapi.consumer;

import cn.caber.dubboapi.service.HelloService;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;

import java.io.IOException;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/11 9:53
 */
public class Consumer {
    public static void main(String[] args) {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("bbb");

// 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://192.168.1.141:2181");
//        registry.setUsername("aaa");
//        registry.setPassword("bbb");

// 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接

// 引用远程服务
        ReferenceConfig<HelloService> reference = new ReferenceConfig<HelloService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setInterface(HelloService.class);
        reference.setProtocol("dubbo");
//        reference.setGroup();
        reference.setTimeout(50000);
        reference.setVersion("1.0.0");

// 和本地bean一样使用xxxService
        HelloService helloService = reference.get();
        System.out.println("看看拿到了没："+helloService);
        String s = helloService.sayHello("大河向东流啊");
        System.out.println("返回："+s);
      /*  try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
