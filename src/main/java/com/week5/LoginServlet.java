package com.week5;

import com.dao.UserDao;
import com.model.User;

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
    Connection con = null;
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
                con = DriverManager.getConnection(url, username, password);
                System.out.println("Connection -->" + con);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();

            }
            con=(Connection)getServletContext().getAttribute("con");
        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDao userDao=new UserDao();
        try {
            User user= userDao.findByUsernamePassword(con,username,password);
                if(user!=null){
                    request.setAttribute("user",user);//get user info in jsp
                    request.getRequestDispatcher("WEB-INF/views/userInfo.jsp ").forward(request,response);
                }else {
                    request.setAttribute("message","Username or Password Error!!!");
                    request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
                }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from usertable where username='zhaowenchen' and password =123456 ");
            if("zhaowenchen".equals(username)&&"123456".equals(password))
            {
                request.setAttribute("id",rs.getInt(""));
                request.setAttribute("username",rs.getString(""));
                request.setAttribute("password",rs.getString(""));
                request.setAttribute("email",rs.getString(""));
                request.setAttribute("gender",rs.getString(""));
                request.setAttribute("birthDate",rs.getString(""));
                request.getRequestDispatcher("userlist.jsp").forward(request,response);

//                PrintWriter writer =response.getWriter();
//                writer.println("Login successful");
//                writer.println("Welcome   "+username);
            }
            else
            {
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
//                PrintWriter writer =response.getWriter();
 //                writer.println("Username or password Error");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);

        }

    }