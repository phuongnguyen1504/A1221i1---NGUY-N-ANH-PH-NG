package com.example.dictionary;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslateServlet", value = "/translate")
public class TranslateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> dictionary=new HashMap<>();
        dictionary.put("hello","Xin chao");
        dictionary.put("how","The nao");
        dictionary.put("book","Quyen vo");
        dictionary.put("computer","May tinh");
        String search= request.getParameter("search");
        PrintWriter writer=response.getWriter();
        writer.println("<html>");
        String res=dictionary.get(search);
        if (res!=null){
            writer.println("Word: "+search);
            writer.println("Result: "+res);
        }
        else {
            writer.println("Not found");
        }
        writer.println("</html>");
    }
}
