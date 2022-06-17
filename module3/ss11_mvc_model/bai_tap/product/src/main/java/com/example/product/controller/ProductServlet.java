package com.example.product.controller;

import com.example.product.model.Product;
import com.example.product.service.ProductService;
import com.example.product.service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = {"/product",""})
public class ProductServlet extends HttpServlet {
    private ProductService productService=new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "display":
                break;
            case "create":
                break;
            case "update":
                break;
            case "delete":
                break;
            case "view":
                break;
            case "find":
                break;
            default:
                listProducts(request,response);
                break;

        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products=this.productService.findAll();
        request.setAttribute("products",products);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/product/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "display":
                break;
            case "create":
                break;
            case "update":
                break;
            case "delete":
                break;
            case "view":
                break;
            case "find":
                break;
            default:
                break;

        }
    }
}
