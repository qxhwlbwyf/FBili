package com.taru.Bili.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/api/*")
public class CorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        response.addHeader("Access-Control-Allow-Origin","*");                              //IP地址
        response.addHeader("Access-Control-Allow-Methods","GET,POST,OPTIONS,PUT,DELETE");   //协议方法
        response.addHeader("Access-Control-Allow-Headers","Content-type");                              //头部
        response.addHeader("Access-Control-Allow-Age","86400");                                  //允许时长
        response.addHeader("Access-Control-Allow-Credentials","false");                          //携带凭证     Origin的IP地址如果设为*则不允许携带凭证

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
