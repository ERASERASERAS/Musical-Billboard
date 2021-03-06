package com.ssau.filter;

import com.ssau.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StatusFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if(user != null && user.getRole().equals("ADMIN"))
            filterChain.doFilter(servletRequest,servletResponse);
        else
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/");
    }

    @Override
    public void destroy() {

    }
}
