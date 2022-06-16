package com.example.customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends HttpServlet {
    private static List<Customer> customerList;
    static {
        customerList=new ArrayList<>();
        customerList.add(new Customer("Mai Van Hoan","1983-08-20","Ha Noi","img1.jpeg"));
        customerList.add(new Customer("Nguyen Van Nam","1983-08-21","Bac Giang","img2.jpeg"));
        customerList.add(new Customer("Nguyen Thai Hoa","1983-08-22","Nam Dinh","img3.jpeg"));
        customerList.add(new Customer("Tran Dang Khoa","1983-08-17","Ha Tay","img4.jpeg"));
        customerList.add(new Customer("Nguyen Dinh Thi","1983-08-19","Ha Noi","img5.jpeg"));

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList",customerList);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
