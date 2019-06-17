package cn.caber.dubborestapiprovider;

import com.pactera.po.User;
import com.pactera.service.HelloService;
import com.pactera.service.impl.HelloServiceImpl;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
@Import(User.class)
public class DubboRestApiProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboRestApiProviderApplication.class, args);

        publish();
    }

    private static void publish(){
        HelloService helloService = new HelloServiceImpl();

        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("rest-provider");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setProtocol("zookeeper");
        registry.setAddress("192.168.1.119:2181");
        registry.setTimeout(5000);
        registry.setCheck(false);


        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("rest");
        protocol.setPort(8081);
        protocol.setIothreads(5);
        protocol.setThreads(100);
        protocol.setServer("tomcat");


// 注意：ServiceConfig为重对象，内部封装了与注册中心的连接，以及开启服务端口

        // 服务提供者暴露服务配置
        ServiceConfig<HelloService> service = new ServiceConfig<HelloService>();
        service.setApplication(application);
        service.setRegistry(registry); // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
        service.setInterface(HelloService.class);
        service.setRef(helloService);
        service.setTimeout(2000);
        service.setVersion("2.6.2");
        service.setRetries(0);


// 暴露及注册服务
        service.export();

    }

}
