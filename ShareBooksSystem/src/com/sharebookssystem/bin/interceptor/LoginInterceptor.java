package com.sharebookssystem.bin.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sharebookssystem.model.User;

import java.util.Map;


public class LoginInterceptor extends AbstractInterceptor {
    public String intercept(ActionInvocation ai)throws Exception{
        Map session=ai.getInvocationContext().getSession();
        User user=(User)session.get("user");
        if(user!=null){
            return ai.invoke();
        }else{
            ActionContext ac=ai.getInvocationContext();
            ac.put("popedom","请登录！");
            return "reglogin";
        }
    }
}
