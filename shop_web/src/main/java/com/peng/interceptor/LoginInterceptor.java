package com.peng.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements Interceptor {

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        //获取request
        HttpServletRequest req = ServletActionContext.getRequest();
        //获取session
        HttpSession session = req.getSession();
        Object o = session.getAttribute("user");
        if (o == null) {
            return "login";
        } else {
            //继续向下执行
            return ai.invoke();
        }
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void init() {
        // TODO Auto-generated method stub

    }


}
