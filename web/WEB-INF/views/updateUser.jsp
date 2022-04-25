<%@ page import="com.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 赵小黑
  Date: 2022/4/25
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>

<%
    User u=(User) session.getAttribute("user");
%>
<form method="post" action="/updateUser">
    <input type="hidden" name="id" value="<%=u.getId()%>">
    username<input name="username " type="text" maxlength="20" size="10" value="<%=u.getUsername()%>"/><br />

    password<input name="password" type="text" maxlength="10" size="10"  value="<%=u.getPassword()%>"><br />

    Email<input name="email" type="text" maxlength="10" size="10"  value="<%=u.getEmail()%>"><br />
    Gender:
    <input name="gender" type="radio" value="Male" <%= "male".equals(u.getGender())?"checked":""%>>  Male
    <input name="gender" type="radio" value="Female" <%= "female".equals(u.getGender())?"checked":""%>/>  Female<br />

    Date of Birth <input name="birth " type="text" maxlength="20" size="10" value="<%=u.getBirthDate()%>"/><br />

    <input name="submit" type="submit" id="" value="Save Change" />
</form>
<%@include file="footer.jsp"%>