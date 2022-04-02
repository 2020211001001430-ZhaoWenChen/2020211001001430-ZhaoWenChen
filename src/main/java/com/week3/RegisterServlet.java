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

@WebServlet(name = "RegisterServlet")


public class RegisterServlet extends HttpServlet {
    Connection con = null;

    public void init() throws ServletException {
        super.init();
        //way 2 -create connection with  init()

        //to get connection we need 4 variables
        //connect to sql server
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false";
        //String username="sa";
        //String password="123456";
//        ServletConfig config=getServletConfig();
//        String driver= config.getInitParameter("driver");
//        String url= config.getInitParameter("url");
//        String username= config.getInitParameter("username");
//        String password= config.getInitParameter("password");

        ServletConfig config = getServletConfig();
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection--> in JDBCDemoServlet" + con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        con=(Connection)getServletContext().getAttribute("con");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String Email = request.getParameter("Email");
        String gender = request.getParameter("gender");
        String birth = request.getParameter("birth");

        try {
            Statement st = con.createStatement();
            String sql = "insert into usertable(username,password,email.gender,birthdate)" +
                    "values('" + username + "','" + password + "','" + Email + "','" + gender + "','" + birth + "')";
            System.out.println("sql" + sql);

            int n = st.executeUpdate(sql);
            System.out.println("n-->" + n);

            response.sendRedirect("login.jsp");
//            sql = "select username,password,email,gender,birthdate from usertable";
//            ResultSet rs = st.executeQuery(sql);
//            PrintWriter out = response.getWriter();
//
//            request.setAttribute("rsname",rs);//name - string,value - any type (object)
//            request.getRequestDispatcher("userList.jsp").forward(request, response);
//
//
//        System.out.println("i am in RegisterServlet-->doPsst()-->after forward()");
    } catch(SQLException e){
            e.printStackTrace();
        }

//    PrintWriter writer = response.getWriter();
//        writer.println("<br>username"+username);
//        writer.println("<br>password"+password);
//        writer.println("<br>Email"+Email);
//        writer.println("<br>gender"+gender);
//        writer.println("<br>birth Date"+birth);
//        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
