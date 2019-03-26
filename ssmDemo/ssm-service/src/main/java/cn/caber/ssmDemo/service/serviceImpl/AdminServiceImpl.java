package cn.caber.ssmDemo.service.serviceImpl;

import cn.caber.ssmDemo.dao.UserDao;
import cn.caber.ssmDemo.pojo.Result;
import cn.caber.ssmDemo.pojo.User;
import cn.caber.ssmDemo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserDao userDao;
    @Override
    public Result add(User user) {
        Result result = new Result();
        result.setFlag(true);
        result.setMassage("成功");
        try {
            userDao.insertOne(user);
        } catch (Exception e) {
            result.setFlag(false);
            result.setMassage("失败");
        }
        return result;
    }

    @Override
    public Result del(User user) {
        return null;
    }

    @Override
    public Result change(User user) {
        return null;
    }

    @Override
    public Result find(User user) {
        return null;
    }
}
