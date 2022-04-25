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

<%
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMeVale="";
    if(allCookies!=null){
        for (Cookie c:allCookies){
            if (c.getName().equals("cUsername")){
                //get values of this cookies
                username=c.getValue();
            }
                    if (c.getName().equals("cPassword")){
                //get values of this cookies
                password=c.getValue();
            }
            if (c.getName().equals("cRememberMe")){
                //get values of this cookies
                rememberMeVale=c.getValue();
            }
        }
    }
%>
<form method="post" action="/login">

    Username : <input name="username " type="text" maxlength="20" size="10" value="<%=username%>"/><br />
    Password : <input name="password" type="text" maxlength="20" size="10" value="<%=password%>"/><br />
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVale.equals("1 ") ?"checked":""%>checked/>RememberMe<br/>
    <input type="submit" value="Submit"/>
</form>
<%@ include file="footer.jsp"%>