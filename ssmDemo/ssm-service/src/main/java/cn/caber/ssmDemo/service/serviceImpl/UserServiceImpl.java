package cn.caber.ssmDemo.service.serviceImpl;

import cn.caber.ssmDemo.pojo.User;
import cn.caber.ssmDemo.service.UserService;
import cn.caber.ssmDemo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void delByIdAndAge(String user_id,Integer user_age) {
        userDao.delByIdAndAge(user_id,user_age);
    }

    @Override
    public void insertOne(String user_id, String user_name, Integer user_age) {
        User user = new User(user_id, user_name, user_age);
        userDao.insertOne(user);
    }

    @Override
    public User findByName(String name) {
        User user = userDao.findByName(name);
        return user;
    }

    @Override
    public Long setValue() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        Long hset = jedis.hset("libai", "nane", "23");
        return hset;
    }
}
