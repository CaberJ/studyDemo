package cn.caber.ssmDemo.service;

import cn.caber.ssmDemo.pojo.Result;
import cn.caber.ssmDemo.pojo.User;

public interface AdminService {
    Result add(User user);
    Result del(User user);
    Result change(User user);
    Result find(User user);
}
