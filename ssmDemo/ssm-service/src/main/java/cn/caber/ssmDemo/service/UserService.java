package cn.caber.ssmDemo.service;

import cn.caber.ssmDemo.pojo.User;

import java.util.List;

public interface UserService {
     User findById(String id);
     List<User> findAll();
     void delByIdAndAge(String user_id,Integer user_age);
     void insertOne(String user_id,String user_name,Integer age);
     User findByName(String name);

     Long setValue();
}

