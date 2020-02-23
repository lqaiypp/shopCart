package com.peng.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static Properties prop = new Properties();
    //创建一个ThreadLocal对象，绑定connection到当前线程
    private static ThreadLocal<Connection> tol = new ThreadLocal<Connection>();

    //静态初始化代码块，负责执行只需要一次的操作
    static {
        InputStream in = null;
        try {
            //使用IO流读取配置文件信息：参数为配置文件的位置，/ 斜杠代表从项目根目录开始
            in = JDBCUtil.class.getResourceAsStream("/jdbc.properties");
            //使用Properties对象解析流中的信息
            prop.load(in);
            //加载驱动
            Class.forName(prop.getProperty("driverClassName"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("读取配置文件失败！~");
        } finally {
            //关闭流
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        //从当前线程先获取一下conn
        Connection conn = tol.get();
        try {
            if (conn == null) {//说明第一次调用工具类创建连接，还没有向当前线程绑定
                //即创建连接
                conn = DriverManager.getConnection(prop.getProperty("url")
                        , prop.getProperty("username"), prop.getProperty("password"));
                //并绑定到当前线程
                tol.set(conn);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return conn;

    }

    //释放资源
    public static void close(ResultSet rs, PreparedStatement pstm, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
                //从当前线程中移除已关闭无用的连接
                tol.remove();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 释放资源
    public static void close(PreparedStatement pstm, Connection conn) {
        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
                tol.remove();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 释放资源
    public static void close(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
                tol.remove();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}










