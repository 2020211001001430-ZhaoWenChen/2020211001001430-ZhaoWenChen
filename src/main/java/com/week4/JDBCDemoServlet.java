package com.week4;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

//@WebServlet(name = "JDBCDemoServlet",urlPatterns = {"/jdbc"},
//        initParams = {
//        @WebInitParam(name = "driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
//                @WebInitParam(name = "url",value="jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false"),
//                @WebInitParam(name = "username",value="sa"),
//                @WebInitParam(name = "password",value="123456")
//        },
//        loadOnStartup = 1
//
//)//done---use @webServlet -no web.xml code

//@WebServlet(urlPatterns = {"/jdbc"},loadOnStartup = 1)//only url
public class JDBCDemoServlet extends HttpServlet {

    Connection con=null;
    public void init() throws ServletException{
        super.init();
        //way 2 -create connection with  init()

        //to get connection we need 4 variables
        //connect to sql server
        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false";
        String username="sa";
        String password="123456";
//        ServletConfig config=getServletConfig();
//        String driver= config.getInitParameter("driver");
//        String url= config.getInitParameter("url");
//        String username= config.getInitParameter("username");
//        String password= config.getInitParameter("password");



        try{
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,password);
            System.out.println("Connection--> in JDBCDemoServlet"+con);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    //close connection here -when stop tomcat
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //way 1 create connection within doGet
        System.out.println("Connection-->"+con);


    }
}
