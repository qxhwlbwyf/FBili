package com.taru.Bili.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class isloginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //判断是否是登录请求，如果是就放行       【也可以不在此处拦截，在XML文件中配置放行】
//        HttpSession session=httpServletRequest.getSession(false);
//        if(session!=null){
//            Object object=session.getAttribute("UserLoginKey");
//            if(object!=null){
//                return true;
//            }
//        }
//        httpServletResponse.sendRedirect("/login.jsp");//未登录，跳转到登录界面
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
