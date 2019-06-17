package cn.caber.dubborestprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath:/dubbo-p.xml")
public class DubboRestProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboRestProviderApplication.class, args);
    }

}
