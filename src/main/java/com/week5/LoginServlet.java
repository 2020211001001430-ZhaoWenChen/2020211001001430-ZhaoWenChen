package com.week5;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    Connection conn = null;
        @Override
        public void init() throws ServletException{
            super.init();
            ServletConfig config=getServletConfig();
            String driver=config.getInitParameter("driver");
            String url=config.getInitParameter("url");
            String username=config.getInitParameter("username");
            String password=config.getInitParameter("password");
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, username, password);
                System.out.println("Connection -->" + conn);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();

            }
        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from usertable where username='zhaowenchen' and password =123456 ");
            if("zhaowenchen".equals(username)&&"123456".equals(password))
            {   PrintWriter writer =response.getWriter();
                writer.println("Login successful");
                writer.println("Welcome   "+username);
            }
            else
            {   PrintWriter writer =response.getWriter();

                writer.println("Username or password Error");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {

        }

    }