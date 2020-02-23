package com.peng.dao;

import com.peng.entity.Product;
import com.peng.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public void add(Product p) {//添加商品
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //调用工具类获取连接
            conn = JDBCUtil.getConnection();
            //书写sql命令
            String sql = "insert into shop_product values(?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, p.getId());
            pstm.setString(2, p.getProductName());
            pstm.setString(3, p.getPicpath());
            pstm.setDouble(4, p.getPrice());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("插入失败！~");
        } finally {
            JDBCUtil.close(pstm, null);
        }
    }

    @Override
    public void update(Product p) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //调用工具类获取连接
            conn = JDBCUtil.getConnection();
            //书写sql命令
            String sql = "update shop_product set id=?,productname=?,price=?,picpath=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, p.getId());
            pstm.setString(2, p.getProductName());
            pstm.setDouble(3, p.getPrice());
            pstm.setString(4, p.getPicpath());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("更新失败！~");
        } finally {
            JDBCUtil.close(pstm, null);
        }
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //调用工具类获取连接
            conn = JDBCUtil.getConnection();
            //书写sql命令
            String sql = "delete from shop_product where id=? ";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("删除失败！~");
        } finally {
            JDBCUtil.close(pstm, null);
        }
    }

    @Override
    public List<Product> queryAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Product> l = new ArrayList<Product>();
        try {
            //调用工具类获取连接
            conn = JDBCUtil.getConnection();
            //书写sql命令
            String sql = "select id,productname,price,picpath from shop_product";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            Product p = null;
            //处理结果集
            while (rs.next()) {
                p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)
                );
                l.add(p);
            }
            return l;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询失败！~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }

    @Override
    public Product queryById(Integer id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            //调用工具类获取连接
            conn = JDBCUtil.getConnection();
            //书写sql命令
            String sql = "select id,productname,price,picpath from shop_product where id=?";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            Product p = null;
            //处理结果集
            while (rs.next()) {
                p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)
                );
            }
            return p;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询失败！~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }

    @Override
    public List<Product> queryByName(String name) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Product> l = new ArrayList<Product>();
        try {
            //调用工具类获取连接
            conn = JDBCUtil.getConnection();
            //书写sql命令
            String sql = "select id,productname,price,picpath from shop_product where productname like '%'||?||'%'";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, name);
            rs = pstm.executeQuery();
            Product p = null;
            //处理结果集
            while (rs.next()) {
                p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)
                );
                l.add(p);
            }
            return l;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询失败！~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }

    @Override
    public List<Product> queryByBigPrice(Double price) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Product> l = new ArrayList<Product>();
        try {
            //调用工具类获取连接
            conn = JDBCUtil.getConnection();
            //书写sql命令
            String sql = "select id,productname,price,picpath from shop_product where price>?";
            pstm = conn.prepareStatement(sql);
            pstm.setDouble(1, price);
            rs = pstm.executeQuery();
            Product p = null;
            //处理结果集
            while (rs.next()) {
                p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)
                );
                l.add(p);
            }
            return l;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询失败！~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }

    @Override
    public List<Product> queryBySmallPrice(Double price) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Product> l = new ArrayList<Product>();
        try {
            //调用工具类获取连接
            conn = JDBCUtil.getConnection();
            //书写sql命令
            String sql = "select id,productname,price,picpath from shop_product where price<?";
            pstm = conn.prepareStatement(sql);
            pstm.setDouble(1, price);
            rs = pstm.executeQuery();
            Product p = null;
            //处理结果集
            while (rs.next()) {
                p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)
                );
                l.add(p);
            }
            return l;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询失败！~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }

    @Override
    public List<Product> queryByPage(Integer begin, Integer end) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Product> l = new ArrayList<Product>();
        try {
            //调用工具类获取连接
            conn = JDBCUtil.getConnection();
            //书写sql命令
            String sql = "select id,productname,price,picpath from (select p.id,p.productname,p.price,p.picpath,rownum rn from shop_product p) where rn>=? and rn<=?";
            pstm = conn.prepareStatement(sql);
            pstm.setDouble(1, begin);
            pstm.setInt(2, end);
            rs = pstm.executeQuery();
            Product p = null;
            //处理结果集
            while (rs.next()) {
                p = new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getString(4)
                );
                l.add(p);
            }
            return l;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询失败！~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }

    @Override
    public List<Product> queryByPage(Integer begin, Integer end,
                                     String productName, String smallOrGreat, Double price) {
        // TODO Auto-generated method stub
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Product> l = new ArrayList<Product>();
        if (productName == null && price == null) {//1
            try {
                //调用工具类获取连接
                conn = JDBCUtil.getConnection();
                //书写sql命令
                String sql = "select id,productname,price,picpath from (select p.id,p.productname,p.price,p.picpath,rownum rn from shop_product p) where rn>=? and rn<=?";
                pstm = conn.prepareStatement(sql);
                pstm.setDouble(1, begin);
                pstm.setInt(2, end);
                rs = pstm.executeQuery();
                Product p = null;
                //处理结果集
                while (rs.next()) {
                    p = new Product(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDouble(3),
                            rs.getString(4)
                    );
                    l.add(p);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("查询失败！~");
            } finally {
                JDBCUtil.close(rs, pstm, null);
            }
        } else if (productName == null && price != null && "1".equals(smallOrGreat)) {//2
            try {
                //调用工具类获取连接
                conn = JDBCUtil.getConnection();
                //书写sql命令
                String sql = "select id,productname,price,picpath from (select p.id,p.productname,p.price,p.picpath,rownum rn from shop_product p where price<?) where rn>=? and rn<=?";
                pstm = conn.prepareStatement(sql);
                pstm.setDouble(1, price);
                pstm.setDouble(2, begin);
                pstm.setInt(3, end);
                rs = pstm.executeQuery();
                Product p = null;
                //处理结果集
                while (rs.next()) {
                    p = new Product(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDouble(3),
                            rs.getString(4)
                    );
                    l.add(p);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("查询失败！~");
            } finally {
                JDBCUtil.close(rs, pstm, null);
            }
        } else if (productName == null && price != null && "2".equals(smallOrGreat)) {//3
            try {
                //调用工具类获取连接
                conn = JDBCUtil.getConnection();
                //书写sql命令
                String sql = "select id,productname,price,picpath from (select p.id,p.productname,p.price,p.picpath,rownum rn from shop_product p where price>?) where rn>=? and rn<=?";
                pstm = conn.prepareStatement(sql);
                pstm.setDouble(1, price);
                pstm.setDouble(2, begin);
                pstm.setInt(3, end);
                rs = pstm.executeQuery();
                Product p = null;
                //处理结果集
                while (rs.next()) {
                    p = new Product(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDouble(3),
                            rs.getString(4)
                    );
                    l.add(p);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("查询失败！~");
            } finally {
                JDBCUtil.close(rs, pstm, null);
            }
        } else if (productName != null && price != null && "1".equals(smallOrGreat)) {//4
            try {
                //调用工具类获取连接
                conn = JDBCUtil.getConnection();
                //书写sql命令
                String sql = "select id,productname,price,picpath from (select p.id,p.productname,p.price,p.picpath,rownum rn from shop_product p where productname like '%'||?||'%' and price<?) where rn>=? and rn<=?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, productName);
                pstm.setDouble(2, price);
                pstm.setDouble(3, begin);
                pstm.setInt(4, end);
                rs = pstm.executeQuery();
                Product p = null;
                //处理结果集
                while (rs.next()) {
                    p = new Product(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDouble(3),
                            rs.getString(4)
                    );
                    l.add(p);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("查询失败！~");
            } finally {
                JDBCUtil.close(rs, pstm, null);
            }
        } else if (productName != null && price != null && "2".equals(smallOrGreat)) {//4
            try {
                //调用工具类获取连接
                conn = JDBCUtil.getConnection();
                //书写sql命令
                String sql = "select id,productname,price,picpath from (select p.id,p.productname,p.price,p.picpath,rownum rn from shop_product p where productname like '%'||?||'%' and price>?) where rn>=? and rn<=?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, productName);
                pstm.setDouble(2, price);
                pstm.setDouble(3, begin);
                pstm.setInt(4, end);
                rs = pstm.executeQuery();
                Product p = null;
                //处理结果集
                while (rs.next()) {
                    p = new Product(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDouble(3),
                            rs.getString(4)
                    );
                    l.add(p);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("查询失败！~");
            } finally {
                JDBCUtil.close(rs, pstm, null);
            }
        } else {//6
            try {
                //调用工具类获取连接
                conn = JDBCUtil.getConnection();
                //书写sql命令
                String sql = "select id,productname,price,picpath from (select p.id,p.productname,p.price,p.picpath,rownum rn from shop_product p where productname like '%'||?||'%') where rn>=? and rn<=?";
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, productName);
                pstm.setDouble(2, begin);
                pstm.setInt(3, end);
                rs = pstm.executeQuery();
                Product p = null;
                //处理结果集
                while (rs.next()) {
                    p = new Product(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDouble(3),
                            rs.getString(4)
                    );
                    l.add(p);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("查询失败！~");
            } finally {
                JDBCUtil.close(rs, pstm, null);
            }
        }
        return l;
    }

}
