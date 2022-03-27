package com.week5;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
        @Override
        public void init() throws ServletException{
            super.init();
            ServletConfig config=getServletConfig();
            String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url="jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false";
            String username="sa";
            String password="123456";
        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config=getServletConfig();
        String username=config.getInitParameter("username");
        String password=config.getInitParameter("password");
        string sql="SELECT * FROM USERTABLE WHERE USERNAME ="zhaowenchen"";


        protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            String username = request.getParameter("Username");
            String Username = request.getParameter("password");
            if (username is valid){
                Out.println("Login Success!!!");
                Out.println("Welcome" + username);
            }else{
                Out.println("Username or Password Error!!!");
            }

        }

    }