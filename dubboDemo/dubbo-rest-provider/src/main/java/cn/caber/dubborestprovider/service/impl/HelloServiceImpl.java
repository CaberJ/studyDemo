package cn.caber.dubborestprovider.service.impl;


import cn.caber.dubborestprovider.po.User;
import cn.caber.dubborestprovider.service.HelloService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/6/10 15:05
 */
@Path("/hello")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})//@Consumes用于指定可以接受的客户端请求的MIME媒体类型：REST框架会自动将JSON数据反序列化为User对象
@Produces({MediaType.APPLICATION_JSON})//@Produce注解指定返回给客户端的MIME媒体类型
public class HelloServiceImpl implements HelloService {

    @Override
    @POST
    @Path("sayHello")
    public String sayHello(User user) {
        String str = user.getAge()+"岁的"+user.getName()+"向你问好！";
        System.out.println(str);
        return str;
    }
}
