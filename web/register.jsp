<%--
  Created by IntelliJ IDEA.
  User: 赵小黑
  Date: 2022/3/11
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="header.jsp"%>
<form method="post" action="/register">
    <input name="username " type="text" maxlength="20" size="10" value="Username"/><br />

    <input name="phone" type="text" maxlength="10" size="10"  value="password"><br />

    <input name="phone" type="text" maxlength="10" size="10"  value="Email"><br />
    Gender:
    <input name="gender" type="radio" value="Male"/>  Male
    <input name="gender" type="radio" value="Female"/>  Female<br />

    <input name="birth " type="text" maxlength="20" size="10" value="Date of birth"/><br />

    <input name="submit" type="submit" id="" value="Register" />
</form>
<%@ include file="footer.jsp"%>

