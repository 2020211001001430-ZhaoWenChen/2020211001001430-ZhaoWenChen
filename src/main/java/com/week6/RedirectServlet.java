package com.week6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //redirect - same server -Relative URL
        //1.start without/
        System.out.println("before redirect");
        response.sendRedirect("index.jsp");//URL
        System.out.println("after redirect");
        //2.start with /
//        response.sendRedirect("/index.jsp");
        //http://localhost:8080/index.jsp
        //redirect - another server - Absolute URL
        response.sendRedirect("baidu.com");
    }
}
