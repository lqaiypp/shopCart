package com.peng.action;

import com.peng.entity.User;
import com.peng.service.ShoppingService;
import com.peng.service.ShoppingServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserAction {
    private String username;
    private String password;
    private User user;

    public UserAction(String username, String password, User user) {
        super();
        this.username = username;
        this.password = password;
        this.user = user;
    }

    public UserAction() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserAction [username=" + username + ", password=" + password
                + ", user=" + user + "]";
    }

    public String Login() {
        //调用service
        ShoppingService sp = new ShoppingServiceImpl();
        User u = sp.login(username, password);
        if (u != null) {
            //获取Session
            HttpServletRequest req = ServletActionContext.getRequest();
            HttpSession session = req.getSession();
            session.setAttribute("user", u);
            return "showProduct";
        } else {
            return "login";
        }
    }

    public String CreateUser() {
        //调用Service
        ShoppingService sp = new ShoppingServiceImpl();
        sp.registUser(user);
        return "regist";

    }

    public String safeOut() {
        //获取session
        HttpServletRequest req = ServletActionContext.getRequest();
        HttpSession session = req.getSession();
        session.invalidate();
        //返回
        return "safeOut";
    }

}








