package cn.caber.bean;

import org.springframework.beans.factory.InitializingBean;

import javax.naming.spi.InitialContextFactory;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/5/7 17:15
 */
public class People implements InitializingBean {
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet执行了");
    }

    public void init(){
        System.out.println("init 执行了");
    }

    public void destroy(){
        System.out.println("destroy 执行了");
    }
}
