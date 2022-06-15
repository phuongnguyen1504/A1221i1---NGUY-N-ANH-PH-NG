package com.codegym.product_discount_calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Display_discountServlet", urlPatterns="/display-discount")
public class Display_discountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double price=Double.parseDouble(request.getParameter("price"));
        Integer discount=Integer.parseInt(request.getParameter("discount"));
        String des=request.getParameter("description");
        PrintWriter writer=response.getWriter();
        writer.println("<html>");
        if(price!=null&&discount!=null){
            Double discountAmount=(discount*price)/100;
            Double priceAfterDiscount=price-discountAmount;
            writer.println("<div>Description: " + des + "</div>");
            writer.println("<div>Discount Amount: " + discountAmount + "</div>");
            writer.println("Discount Price:" + priceAfterDiscount + "</div>");
        }
        else {
            writer.println("Please input new field");
        }
        writer.println("</html>");
    }
}
