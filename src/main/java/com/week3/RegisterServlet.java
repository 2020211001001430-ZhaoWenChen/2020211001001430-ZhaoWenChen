package com.week3;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
       /* ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection -->"+con);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        con = (Connection) getServletContext().getAttribute("con");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birth = request.getParameter("birth");
        /*PrintWriter writer = response.getWriter();
        writer.println("<br>username : "+username);
        writer.println("<br>password : "+password);
        writer.println("<br>email : "+email);
        writer.println("<br>gender : "+gender);
        writer.println("<br>birth : "+birth);*/
        PrintWriter writer = response.getWriter();
        StringBuilder sql = new StringBuilder();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            sql.append("select * from user where username = ?");
            ps = con.prepareStatement(sql.toString());
            ps.setString(1,username);
            rs = ps.executeQuery();
            while (rs.next()) {
                //writer.println("注册失败！");
               /* writer.println("<h1>register fail!</h1>");
                writer.println("<h1>username already exists!</h1>");
                return;*/
                request.setAttribute("fail","username already exists!");
                request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
                return;
            }
            sql.setLength(0);
            sql.append("insert into user values(null,?,?,?,?,?)");
            ps = con.prepareStatement(sql.toString());
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,email);
            ps.setString(4,gender);
            ps.setString(5,birth);
            ps.executeUpdate();
            response.sendRedirect("login");
            //sql.setLength(0);
            //sql.append("select * from user");
            //ps = con.prepareStatement(sql.toString());
            //rs = ps.executeQuery();
            //writer.println("<table border=1><tr><th>id</th><th>username</th><th>password</th><th>email</th><th>gender</th><th>birth</th></tr>");
            // while (rs.next()) {
               /* writer.println("<tr><td>"+rs.getString("id")+"</td>"
                        +"<td>"+rs.getString("username")+"</td>"
                        +"<td>"+rs.getString("password")+"</td>"
                        +"<td>"+rs.getString("email")+"</td>"
                        +"<td>"+rs.getString("gender")+"</td>"
                        +"<td>"+rs.getString("birth")+"</td></tr>"
                        );*/
            //return;
            //}
            //writer.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
            //writer.println("注册失败！");
            //writer.println("<h1>register fail!</h1>");
            request.setAttribute("fail","register fail!");
            request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
        }
        finally {
            try {
                if(rs!=null){

                    rs.close();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(ps!=null){

                    ps.close();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }
    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
