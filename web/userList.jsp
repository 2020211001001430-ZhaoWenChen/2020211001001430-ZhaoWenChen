<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 赵小黑
  Date: 2022/4/1
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User List</h1>
<table border="1">
    <tr>
        <td>ID</td><td>Username</td>password<td></td><td>Email</td><td>Gender</td><td>Birthday</td>
    </tr>
    <%
        //get rs from request attribute-
        ResultSet rs =(ResultSet) request.setAttribute("rsname");
        if(rs==null){

        }
    %>
    <tr>
        <td>No Data!!! </td>
    </tr>
    <%
        while(rs.next()){
    //get one by one
            out.println("<tr>");
            out.println("<td>"+rs.getString("username")+"</td>");
            out.println("<td>"+rs.getString("password")+"</td>");
            out.println("<td>"+rs.getString("email")+"</td>");
            out.println("<td>"+rs.getString("gender")+"</td>");
            out.println("<td>"+rs.getString("birthdate")+"</td>");

            out.println("</tr>");

         }
    %>
</table>
<%@include file="footer.jsp"%>