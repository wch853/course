package com.wch.course.config;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import javax.servlet.*;
import java.io.IOException;

public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getParameter("token");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
