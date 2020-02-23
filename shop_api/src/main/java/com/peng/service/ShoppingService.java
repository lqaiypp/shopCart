package com.peng.service;

import com.peng.entity.Product;
import com.peng.entity.User;

import java.util.List;

public interface ShoppingService {

    //登陆
    User login(String username, String password);

    //修改密码
    void modifyPassword(String oldpwd, String newpwd);

    //更新个人信息
    void modify(User user);

    //注册
    void registUser(User user);

    //添加商品
    void registProduct(Product p);

    //删除商品
    void dropProductById(Integer id);

    //更新商品
    void updateProductMessage(Product p);

    //通过id查找商品
    Product queryById(Integer id);

    //查询所有 分页
    public List<Product> queryPage(Integer currentPage);

    //根据名称模糊查询
    List<Product> queryByName(String name);

    //根据价格区间查询
    List<Product> queryByBig(Double max);

    List<Product> queryBySmall(Double min);

    //模糊分页查询
    List<Product> findProduct(Integer currentPage
            , String productName, String smallOrGreat, Double price);
}
