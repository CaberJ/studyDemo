package cn.caber.dubborestprovider.po;

import java.io.Serializable;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/14 16:03
 */
public class User implements Serializable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
