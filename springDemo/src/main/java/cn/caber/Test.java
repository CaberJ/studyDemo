package cn.caber;

import cn.caber.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/5/7 17:08
 */
public class Test {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Object user = classPathXmlApplicationContext.getBean("People");
        System.out.println("==="+user);
        classPathXmlApplicationContext.registerShutdownHook();
    }

}
