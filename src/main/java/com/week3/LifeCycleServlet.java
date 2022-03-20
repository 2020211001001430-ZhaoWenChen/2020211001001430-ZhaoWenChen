package com.week3;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "/life")
public class LifeCycleServlet extends HttpServlet {
    Connection con=null;
    public LifeCycleServlet(){
        System.out.println(" I am in --> LifeCycleServlet");
    }

    public void init(){
        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");

        try{
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection--> in JDBCDemoServlet"+con);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        System.out.println("i am in init()->LifeCycleServlet-->"+con);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in service () --> doGet()");
    }

    @Override
    public void destroy() {
        System.out.println("i am in destroy()");
        try {
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
