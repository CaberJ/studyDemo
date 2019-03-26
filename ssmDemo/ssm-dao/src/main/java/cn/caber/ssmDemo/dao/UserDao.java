package cn.caber.ssmDemo.dao;

import cn.caber.ssmDemo.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    User findById(String id);
    List<User> findAll();
    void delByIdAndAge(@Param("user_id") String user_id, @Param("user_age") Integer user_age);
    void insertOne(User user);
    User findByName(String name);
}
