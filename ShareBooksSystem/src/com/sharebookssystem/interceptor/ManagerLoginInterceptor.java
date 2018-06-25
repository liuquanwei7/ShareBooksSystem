package com.sharebookssystem.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

/**
 * 管理员登录拦截
 * 2018/6/25
 */


public class ManagerLoginInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation arg0) throws Exception {
        Map s = ActionContext.getContext().getSession();
        if(s.get("managerLoginAccount")==null || s.get("managerLoginAccount").toString().trim().equals("")){
            ActionContext ac = arg0.getInvocationContext();
            s.put("managerLoginNoAccountError", "您还没登陆,请登陆!");
            return "managerLogin";
        }else{
            return arg0.invoke();
        }


    }
}
