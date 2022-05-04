package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//2 way of mapping filter to servlet
//way 1 - use web.xml
//way 2 - user WebFilter
@WebFilter(filterName = "HelloFilter",urlPatterns = {"/home","/login","/register.jsp"})

//url /hello - filter is only for one Servlet - HelloServlet
public class HelloFilter implements Filter {//
    public void init(FilterConfig config) throws ServletException {
    System.out.println("i am in HelloFilter-->init()");

    }


    public void destroy() {
        System.out.println("i am in HelloFilter-->destroy()");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //request come here - before go to servlet -doGet() or Post()
        System.out.println("i am in HelloFilter-->doFilter()-before servlet -(request come here)");

        chain.doFilter(req, resp);//call next filter - if no next filter- then go to servlet
        //response after servlet come back here
        System.out.println("i am in HelloFilter-->doFilter()-before servlet -(request come here)");
    }

    }
