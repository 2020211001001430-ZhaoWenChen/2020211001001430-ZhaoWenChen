<%--
  Created by IntelliJ IDEA.
  User: 赵小黑
  Date: 2022/3/6
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<h1><%="Hello World!!!"%></h1><br/>

<a href="hello-servlet">Hello Servlet</a>

  <h2>Wel come to my Online Shop Home Page.</h2><br>
  <form method="get" target="_blank" action="search">
    <!--<url-pattern>/search</url-pattern>-->
    <input type="text" name="txt" size="30"/>
    <select name="search">
    <option value="baidu">Baidu</option>
    <option value="bing">Bing</option>
    <option value="google">Google</option>
    </select>
    <input type="submit" value="Search"/>
  </form>

<%@ include file="footer.jsp"%>
