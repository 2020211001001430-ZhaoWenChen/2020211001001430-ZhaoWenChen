package com.controller;

import com.dao.UserDao;
import com.sun.jndi.ldap.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet",value = "/updateUser")
    public class UpdateUserServlet extends HttpServlet {
        Connection con = null;
        @Override
        public void init() throws ServletException {
            con = (Connection) getServletContext().getAttribute("con");
        }
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            UserDao userDao = new UserDao();
            try {
                Users users = userDao.findById(con,Integer.valueOf(request.getParameter("id")));
                request.setAttribute("user",users);
                request.getRequestDispatcher("WEB-INF/views/updateUserView.jsp").forward(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id = request.getParameter("id");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String gender = request.getParameter("gender");
            String birth = request.getParameter("birth");
            HttpSession session = request.getSession();
            Users users = (Users)session.getAttribute("user");
            users.setId(Integer.parseInt(id));
            users.setUsername(username);
            users.setPassword(password);
            users.setEmail(email);
            users.setGender(gender);
            users.setBirth(Date.valueOf(birth));
            UserDao userDao = new UserDao();
            try {
                int update = userDao.updateUser(con,users);
                if (update == 0) {
                    HttpSession s = request.getSession();//create session if session not exist -- otherwise return existing session
                    //session.setMaxInactiveInterval(10);
                    session.removeAttribute("user");
                    //change request(one page) to session -- can get session attribute in many jsp
                    session.setAttribute("user",users);
                    request.getRequestDispatcher("accountDetails").forward(request,response);
                }
                else {
                    request.setAttribute("updateFail","updateUser fail!");
                    request.getRequestDispatcher("WEB-INF/views/updateUserView.jsp").forward(request,response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }