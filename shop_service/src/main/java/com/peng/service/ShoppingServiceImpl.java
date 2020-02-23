package com.peng.service;

import com.peng.dao.ProductDao;
import com.peng.dao.ProductDaoImpl;
import com.peng.dao.UserDao;
import com.peng.dao.UserDaoImpl;
import com.peng.entity.Product;
import com.peng.entity.User;
import com.peng.util.JDBCUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ShoppingServiceImpl implements ShoppingService {

    @Override
    public User login(String username, String password) {
        Connection conn = null;
        try {
            //手动设置控制事务
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            //调用Dao
            UserDao dao = new UserDaoImpl();
            User m = dao.queryByNameAndPassword(username, password);
            //手动提交事务
            conn.commit();
            return m;
        } catch (Exception e) {
            //手动回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("查询失败！~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public void modifyPassword(String oldpwd, String newpwd) {
        Connection conn = null;
        try {
            //手动设置控制事务
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            //调用Dao
            UserDao dao = new UserDaoImpl();
            dao.updatePassword(oldpwd, newpwd);
            //手动提交事务
            conn.commit();
        } catch (Exception e) {
            //手动回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("修改失败！~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public void modify(User user) {
        // TODO Auto-generated method stub
        Connection conn = null;
        try {
            //手动设置控制事务
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            //调用Dao
            UserDao dao = new UserDaoImpl();
            dao.update(user);
            //手动提交事务
            conn.commit();
        } catch (Exception e) {
            //手动回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("更新失败！~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public void registUser(User user) {
        // TODO Auto-generated method stub
        Connection conn = null;
        try {
            //手动设置控制事务
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            //调用Dao
            UserDao dao = new UserDaoImpl();
            dao.add(user);
            //手动提交事务
            conn.commit();
        } catch (Exception e) {
            //手动回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("添加失败！~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public void registProduct(Product p) {
        // TODO Auto-generated method stub
        Connection conn = null;
        try {
            //手动设置控制事务
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            //调用Dao
            ProductDao dao = new ProductDaoImpl();
            dao.add(p);
            //手动提交事务
            conn.commit();
        } catch (Exception e) {
            //手动回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("添加失败！~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public void dropProductById(Integer id) {
        Connection conn = null;
        try {
            //手动设置控制事务
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            //调用Dao
            ProductDao dao = new ProductDaoImpl();
            dao.delete(id);
            //手动提交事务
            conn.commit();
        } catch (Exception e) {
            //手动回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("删除失败！~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public void updateProductMessage(Product p) {
        Connection conn = null;
        try {
            //手动设置控制事务
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            //调用Dao
            ProductDao dao = new ProductDaoImpl();
            dao.update(p);
            //手动提交事务
            conn.commit();
        } catch (Exception e) {
            //手动回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("更新失败！~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public Product queryById(Integer id) {
        Connection conn = null;
        try {
            //手动设置控制事务
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            //调用Dao
            ProductDao dao = new ProductDaoImpl();
            Product p = dao.queryById(id);
            //手动提交事务
            conn.commit();
            return p;
        } catch (Exception e) {
            //手动回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("查询失败！~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public List<Product> queryPage(Integer currentPage) {
        Connection conn = null;
        try {
            //手动设置控制事务
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            //调用Dao
            ProductDao dao = new ProductDaoImpl();
            List<Product> ps = dao.queryByPage((currentPage - 1) * 3 + 1, currentPage * 3);
            //手动提交事务
            conn.commit();
            return ps;
        } catch (Exception e) {
            //手动回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("查询失败！~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public List<Product> queryByName(String name) {
        Connection conn = null;
        try {
            //手动设置控制事务
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            //调用Dao
            ProductDao dao = new ProductDaoImpl();
            List<Product> ps = dao.queryByName(name);
            //手动提交事务
            conn.commit();
            return ps;
        } catch (Exception e) {
            //手动回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("查询失败！~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public List<Product> queryByBig(Double max) {
        Connection conn = null;
        try {
            //手动设置控制事务
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            //调用Dao
            ProductDao dao = new ProductDaoImpl();
            List<Product> ps = dao.queryByBigPrice(max);
            //手动提交事务
            conn.commit();
            return ps;
        } catch (Exception e) {
            //手动回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("查询失败！~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public List<Product> queryBySmall(Double min) {
        Connection conn = null;
        try {
            //手动设置控制事务
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            //调用Dao
            ProductDao dao = new ProductDaoImpl();
            List<Product> ps = dao.queryBySmallPrice(min);
            //手动提交事务
            conn.commit();
            return ps;
        } catch (Exception e) {
            //手动回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("查询失败！~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

    @Override
    public List<Product> findProduct(Integer currentPage, String productName,
                                     String smallOrGreat, Double price) {
        Connection conn = null;
        try {
            //手动设置控制事务
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            //调用Dao
            ProductDao dao = new ProductDaoImpl();
            Integer begin = (currentPage - 1) * 3 + 1;
            Integer end = currentPage * 3;
            List<Product> ps = dao.queryByPage(begin, end, productName, smallOrGreat, price);
            //手动提交事务
            conn.commit();
            return ps;
        } catch (Exception e) {
            //手动回滚事务
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
            throw new RuntimeException("查询失败！~");
        } finally {
            JDBCUtil.close(conn);
        }
    }

}
