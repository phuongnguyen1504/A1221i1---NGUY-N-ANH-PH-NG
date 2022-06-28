package com.casestudy.controller;

import com.casestudy.model.Product;
import com.casestudy.service.IProductService;
import com.casestudy.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = {"/product",""})
public class ProductServlet extends HttpServlet {
    private IProductService productService;
    public void init(){
        productService=new ProductService();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                break;
            case "edit":
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            case "find":
                break;
            case "sort":
            default:
                listUser(request, response);
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        productService.deleteProduct(id);
        response.sendRedirect("/product");
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products=productService.selectAllProduct();
        request.setAttribute("products",products);
        RequestDispatcher dispatcher=request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
            case "edit":
                try {
                    updateProduct(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                break;
            case "find":
                break;
            case "sort":
            default:
                listUser(request, response);
                break;
        }
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name=request.getParameter("name");
        double price= Double.parseDouble(request.getParameter("price"));
        int quantity= Integer.parseInt(request.getParameter("quantity"));
        String color=request.getParameter("color");
        String category=request.getParameter("category");
        Product product=new Product(name,price,quantity,color,category);
        productService.insertProduct(product);
        response.sendRedirect("/product");
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id= Integer.parseInt(request.getParameter("id"));
        System.out.println(id);
        String name=request.getParameter("name");
        double price= Double.parseDouble(request.getParameter("price"));
        int quantity= Integer.parseInt(request.getParameter("quantity"));
        String color=request.getParameter("color");
        String category=request.getParameter("category");
        Product product=new Product(id,name,price,quantity,color,category);
        productService.updateProduct(product);
        response.sendRedirect("/product");
    }
}
