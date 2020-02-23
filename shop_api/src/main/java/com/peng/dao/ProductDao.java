package com.peng.dao;

import com.peng.entity.Product;

import java.util.List;

public interface ProductDao {
    //添加商品
    void add(Product p);

    //更新商品
    void update(Product p);

    //删除商品
    void delete(Integer id);

    //查询所有商品
    List<Product> queryAll();

    //通过id查询
    Product queryById(Integer id);

    //根据商品名称模糊查询
    List<Product> queryByName(String name);

    //根据大于价格查询
    List<Product> queryByBigPrice(Double price);

    //根据小于价格查询
    List<Product> queryBySmallPrice(Double price);

    //分页查询
    List<Product> queryByPage(Integer begin, Integer end);

    //模糊分页查询
    List<Product> queryByPage(Integer begin, Integer end
            , String productName, String smallOrGreat, Double price);
}
