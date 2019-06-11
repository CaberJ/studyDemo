package cn.caber.dubborest.config;

import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/11 11:06
 */

@Configuration
public class HttpProviderConf {

    private List<String> usePackage ;

    public List<String> getUsePackage() {
        return usePackage;
    }

    public void setUsePackage(List<String> usePackage) {
        this.usePackage = usePackage;
    }

}
