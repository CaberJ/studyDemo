package cn.caber.ssmDemo.controller;

import cn.caber.ssmDemo.pojo.User;
import cn.caber.ssmDemo.service.UserService;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findById")
    public User findById(String id) {
        return userService.findById(id);
    }

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/delByIdAndAge", method = RequestMethod.GET, params = {"user_id", "user_age"})
    public void delByIdAndAge(String user_id, Integer user_age) {
        userService.delByIdAndAge(user_id, user_age);
    }


    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        String requestURI = request.getRequestURI();
        return requestURI;
    }

    @RequestMapping("/insertOne")
    public void insertOne(@RequestParam("name") String user_name, @RequestParam(value = "id", required = true) String user_id) {
        Integer age = 18;
        userService.insertOne(user_id, user_name, age);
    }

    @RequestMapping("/useRequestBody")
    public String userRequestBody(@RequestBody(required = false) String body) {
        System.out.println(body);
        return "success";
        //id=user5&name=libai&age=23
    }

    @RequestMapping(value = "/requestBodys",method = RequestMethod.POST)
    public String requestBody(@RequestBody(required = false) List<User> users) {
        for (User user : users) {
            System.out.println(user.toString());
        }
        return "success";
        //id=user5&name=libai&age=23
    }

    @RequestMapping("/useRequestHeader")
    public String useRequestHeader(@RequestHeader(value = "Accept-Language", required = false) String requestHeader) {
        System.out.println(requestHeader);
        return "success";
        //zh-CN,zh;q=0.9
    }

    @RequestMapping("/useCookieValue")
    public String useCookieValue(@CookieValue(value = "JSESSIONID", required = false) String jsessionId) {
        System.out.println(jsessionId);
        return "success";
        //A64FDE43FF053FCC38C44649FC22023E
    }

    //在其他方法之前先执行
   @ModelAttribute
    public User showModel(String name) {
        User user = userService.findByName(name);
        return user;
    }

    @RequestMapping("/showUser")
    public String showUser(User user){
        String s = user.toString();
        return s;
    }

    @RequestMapping("/forward")
    public void forward(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/mid.jsp").forward(request,response);
    }

    @RequestMapping("/redirect")
    public void sendRedirect(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("forward");
    }

    @RequestMapping("/modelAndView")
    public ModelAndView testModelAndView(String name){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name",name);
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/WEB-INF/pages/success.jsp";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:testForward";
        //它相当于“response.sendRedirect(url)”。
        // 需要注意的是，如果是重定向到 jsp 页面，则 jsp 页面不能写在 WEB-INF 目录中，否则无法找到
    }


    @RequestMapping("/testJson")
    public @ResponseBody User testJson(@RequestBody User user){
        System.out.println(user);
        return user;
    }

    @RequestMapping("/redisTest")
    public String test() {
        Long aLong = userService.setValue();
        System.out.println(aLong);
        return "success";
    }
}
