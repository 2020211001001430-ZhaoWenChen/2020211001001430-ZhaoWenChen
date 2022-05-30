<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Cookie[] cookies = request.getCookies();
    String firstVal = "";
    String secondVal = "";
    String result = "";
    String name = "";
    String length = "";
    for(Cookie cookie:cookies) {
        if(cookie.getName().equals("cFirstValue")) { firstVal=cookie.getValue(); }
        if(cookie.getName().equals("cSecondValue")) { secondVal=cookie.getValue(); }
        if(cookie.getName().equals("cResult")) { result=cookie.getValue(); }
        if(cookie.getName().equals("cName")) { name=cookie.getValue(); }
        if(cookie.getName().equals("cLength")) { length=cookie.getValue(); }
    }
%>

<html>
<head>
    <title>Calculate</title>
</head>
<body>
<form id = "myForm" method="post" action="<%=request.getContextPath()+"/CalServlet"%>">
    <table>
        <tr>
            <td>First Val:</td>
            <td><input type="text" name="firstVal" id="firstVal" width="100px" value="<%=firstVal%>"></td>
            <td>Enter a Name:</td>
            <td><input type="text" name="name" id="name" width="100px" value="<%=name%>"></td>
        </tr>
        <tr>
            <td>Second Val:</td>
            <td><input type="text" name="secondVal" id="secondVal" style="margin-top: 2px;";width="100px" value="<%=secondVal%>"></td>
            <td>Length:</td>
            <td><input type="text" name="length" style="margin-top: 2px";width="100px" value="<%=length%>"></td>
        </tr>
        <tr>
            <td>Result:</td>
            <td><input type="text" name="result" style="margin-top: 2px;margin-bottom: 2px;";width="100px" value="<%=result%>"></td>
        </tr>
    </table>

    <br>
    <input type="submit" value="Add" name="1">
    <input type="submit" value="Subtract" name="2">
    <input type="submit" value="Multiply" name="3">
    <input type="submit" value="Divide" name="4">
    <input type="submit" value="Compute Length" name="5">
    <input type="submit" value="Reset" onclick="allreset()">
</form>

<script>
    function firstfun() {
        var value = document.getElementById("firstVal").value;
        for(var i=0 ; i<value.size() ; i++) {
            if((value[i]<'0' || value[i]>'9') && value[i]!='.') {
                alert("First Value is not a Number !");
                return false;
            }
        }
        return true;
    }
    function secondfun() {
        var value = document.getElementById("firstVal").value;
        for(var i=0 ; i<value.size() ; i++) {
            if((value[i]<'0' || value[i]>'9') && value[i]!='.') {
                alert("Second Value is not a Number !");
                return false;
            }
        }
        return true;
    }
    function namefun() {
        var value = document.getElementById("firstVal").value;
        for(var i=0 ; i<value.size() ; i++) {
            if((value[i]<'0' || value[i]>'9') && (value[i]<'A' || value[i]>'Z')) {
                alert("Name is not valid !");
                return false;
            }
        }
        return true;
    }
    function allreset() {
        document.getElementById("myForm").reset();
    }
</script>
</body>
</html>
