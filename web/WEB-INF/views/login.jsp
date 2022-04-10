<%--
  Created by IntelliJ IDEA.
  User: 赵小黑
  Date: 2022/3/27
  Time: 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="header.jsp"%>
<h1>Login</h1>
<%
    if (!(request.getAttribute("message")==null)){
        out.println("<h3>"+request.getAttribute("message")+"</h3>");
    }
%>

<form method="post" action="/login">

    <input name="username " type="text" maxlength="20" size="10" value="Username"/><br />
    <input name="password" type="text" maxlength="20" size="10" value="Password"/><br />
    <input name="Login" type="submit" id="" value="Login" />
</form>
<%@ include file="footer.jsp"%>