package com.peng.dao;

import com.peng.entity.User;

public interface UserDao {
    //登陆查询
    User queryByNameAndPassword(String username, String password);

    //添加
    void add(User user);

    //更新个人信息
    void update(User user);

    //修改密码
    void updatePassword(String oldpwd, String newpwd);

}
