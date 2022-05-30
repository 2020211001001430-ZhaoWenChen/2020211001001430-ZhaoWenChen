
package com.lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalcServlet" , value = "/CalServlet")
class CalcServlet extends HttpServlet {

    public String add(double firstNum,double secondNum) { return ""+(firstNum+secondNum); }
    public String subtract(double firstNum,double secondNum) { return ""+(firstNum-secondNum); }
    public String multiply(double firstNum,double secondNum) { return ""+(firstNum*secondNum); }
    public String divide(double firstNum,double secondNum) { if(secondNum==0) { return "Can't divide by 0"; }return ""+firstNum/secondNum; }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstVal = request.getParameter("firstVal") != null ? request.getParameter("firstVal") : "";
        String secondVal = request.getParameter("secondVal") != null ? request.getParameter("secondVal") : "";
        String name = request.getParameter("name") != null ? request.getParameter("name") : "";
        String length = request.getParameter("length") != null ? request.getParameter("length") : "";
        String result = request.getParameter("result") != null ? request.getParameter("result") : "";

        Cookie cFirstValue = new Cookie("cFirstValue",firstVal);
        Cookie cSecondValue = new Cookie("cSecondValue",secondVal);
        //Cookie cResult = new Cookie("cResult",result);

        if(request.getParameter("1")!=null) {
            Double a = Double.parseDouble(firstVal),b = Double.parseDouble(secondVal);
            Cookie cResult = new Cookie("cResult",add(a,b));
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        } else if(request.getParameter("2")!=null) {
            Double a = Double.parseDouble(firstVal),b = Double.parseDouble(secondVal);
            Cookie cResult = new Cookie("cResult",subtract(a,b));
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        } else if(request.getParameter("3")!=null) {
            Double a = Double.parseDouble(firstVal),b = Double.parseDouble(secondVal);
            Cookie cResult = new Cookie("cResult",multiply(a,b));
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        } else if(request.getParameter("4")!=null) {
            Double a = Double.parseDouble(firstVal),b = Double.parseDouble(secondVal);
            Cookie cResult = new Cookie("cResult",divide(a,b));
            response.addCookie(cFirstValue);
            response.addCookie(cSecondValue);
            response.addCookie(cResult);
        } else if(request.getParameter("5")!=null) {
            Cookie cName=new Cookie("cName",name);
            Cookie cLength=new Cookie("cLength",""+name.length());
            response.addCookie(cName);
            response.addCookie(cLength);
        } else {

        }

        request.getRequestDispatcher("lab3/cal.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}