package com.peng.dao;

import com.peng.entity.User;
import com.peng.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {

    @Override
    public User queryByNameAndPassword(String username, String password) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            //创建连接
            conn = JDBCUtil.getConnection();
            //书写sql
            String sql = "select username,password,name,zip,address from shop_user where username=? and password=?";
            //创建PreparedStatement
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            User u = null;
            while (rs.next()) {
                u = new User(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5)
                );
            }
            return u;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException("查询失败！~");
        } finally {
            JDBCUtil.close(rs, pstm, null);
        }
    }

    @Override
    public void add(User user) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //调用工具类获取连接
            conn = JDBCUtil.getConnection();
            //书写sql命令
            String sql = "insert into shop_user values(?,?,?,?,?)";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getName());
            pstm.setInt(4, user.getZip());
            pstm.setString(5, user.getAddress());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("插入失败！~");
        } finally {
            JDBCUtil.close(pstm, null);
        }

    }

    @Override
    public void update(User user) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //调用工具类获取连接
            conn = JDBCUtil.getConnection();
            //书写sql命令
            String sql = "update shop_user set username=?,password=?,name=?,zip=?,address=? ";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getName());
            pstm.setInt(4, user.getZip());
            pstm.setString(5, user.getAddress());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("更新失败！~");
        } finally {
            JDBCUtil.close(pstm, null);
        }

    }

    @Override
    public void updatePassword(String oldpwd, String newpwd) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            //调用工具类获取连接
            conn = JDBCUtil.getConnection();
            //书写sql命令
            String sql = "update shop_user set password=? where password=? ";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, newpwd);
            pstm.setString(2, oldpwd);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("更新失败！~");
        } finally {
            JDBCUtil.close(pstm, null);
        }
    }

}
