package com.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeServlet" ,value = "/home")
public class HomeServlet extends HttpServlet {
    private String message;
    public void init(){
        message = "Hello World";
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        System.out.println("i am in HelloServlet__>doGet()");

        //Hello
        PrintWriter out=response.getWriter();
        out.println("<html><body>");
        out.println("<h1>"+message+"</h1>");
        out.println("</body></html>");


        //when u run or user click Home form menu - method is get
        request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request,response);
        //copy index.jsp inside WEB-INF/views/
    }
}
