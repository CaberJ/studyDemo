package cn.caber.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/5/7 17:32
 */
public class PostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("beforeInitialization "+o+" beanName="+s);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("afterInitialization "+o+" beanName="+s);
        return o;
    }
}
