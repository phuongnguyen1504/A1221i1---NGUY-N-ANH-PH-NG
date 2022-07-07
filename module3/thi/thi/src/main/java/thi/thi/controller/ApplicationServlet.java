package thi.thi.controller;

import thi.thi.model.Object;
import thi.thi.model.People;
import thi.thi.service.ApplicationService;
import thi.thi.service.IApplicationService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ApplicationServlet", urlPatterns = {"applications",""})
public class ApplicationServlet extends HttpServlet {
    private IApplicationService applicationService;

    public void init() {
        applicationService = new ApplicationService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "edit":
                break;
            case "delete":
                deleteObject(request,response);
                break;
            case "search":
                break;
            case "sort":
            default:
                listObject(request, response);
                break;
        }
    }

    private void deleteObject(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id_object");
        applicationService.deleteObject(id);
        response.sendRedirect("/applications?m=1");
    }

    private void listObject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Object> objectList;
        List<People> peopleList;
        String m = request.getParameter("m");
        if(m != null){
            request.setAttribute("m", Integer.parseInt(m));
        }
        objectList = applicationService.selectAllObject();
        peopleList = applicationService.findListCategory();
        request.setAttribute("objectList", objectList);
        request.setAttribute("peopleList", peopleList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/applications/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "edit":
                try {
                    updateObject(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "search":
                break;
            default:
                listObject(request, response);
                break;
        }
    }

    private void updateObject(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String id_object=request.getParameter("id_object");
        String id_patience=request.getParameter("id_patience");
        String name_patience=request.getParameter("name_patience");
        String date_in=request.getParameter("date_in");
        String date_out=request.getParameter("date_out");
        String reason=request.getParameter("reason");
        Object object=new Object(id_object,id_patience,name_patience,date_in,date_out,reason);
        applicationService.updateObject(object);
        response.sendRedirect("/applications?m=2");

    }
}
