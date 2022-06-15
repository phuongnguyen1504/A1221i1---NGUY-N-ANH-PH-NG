package com.example.calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculateServlet", urlPatterns ="/calculate")
public class CalculateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double first=Double.parseDouble(request.getParameter("num1"));
        String operator=request.getParameter("operator");
        Double second=Double.parseDouble(request.getParameter("num2"));
        try {
            double res=calculate(first,operator,second);
            request.setAttribute("res",res);
            request.getRequestDispatcher("result.jsp").forward(request,response);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }


    }
    private Double calculate(Double first,String operator,Double second) throws Exception{
        double res=0;
        switch (operator){
            case "Addition":
                res=first+second;
                break;
            case "Subtraction":
                res=first-second;
                break;
            case "Multiplication":
                res=first*second;
                break;
            case "Division":
                if (second==0){
                    throw new Exception("Cannot division by zero");
                }
                else {
                    res=first/second;
                }
                break;
        }
        return res;
    }
}
