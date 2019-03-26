package cn.caber.ssmDemo.controller;

import cn.caber.ssmDemo.pojo.Result;
import cn.caber.ssmDemo.pojo.User;
import cn.caber.ssmDemo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/userAdd", method = RequestMethod.GET, params = {"name","age","sex"})
    public ModelAndView add(String name, String age, String sex){
        ModelAndView mv = new ModelAndView();

        User user = new User();
        user.setId("user_2");
        user.setName(name);
        user.setAge(Integer.parseInt(age));
        Result add = adminService.add(user);
        mv.setViewName("ok");
        mv.addObject(add);
        return mv;
    }

}
