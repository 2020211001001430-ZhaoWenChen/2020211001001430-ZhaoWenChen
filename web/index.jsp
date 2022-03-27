<%--
  Created by IntelliJ IDEA.
  User: 赵小黑
  Date: 2022/3/6
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>
  <%="Hello World!!!"%>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<form>
  <input name="username " type="text" maxlength="20" size="10" value="Username"/><br />

  <input name="phone" type="text" maxlength="10" size="10"  value="password"><br />

  <input name="phone" type="text" maxlength="10" size="10"  value="Email"><br />

  Gender:
  <input name="sex" type="radio" value="Male"/>  Male
  <input name="sex" type="radio" value="Female"/>  Female<br />

  <input name="birth " type="text" maxlength="20" size="10" value="Date of birth"/><br />

  <input name="submit" type="submit" id="" value="Register" />
</form>
<%@ include file="footer.jsp"%>
