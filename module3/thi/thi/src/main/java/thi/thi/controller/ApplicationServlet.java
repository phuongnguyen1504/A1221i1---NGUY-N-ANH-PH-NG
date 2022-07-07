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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ApplicationServlet", value = {"/application",""})
public class ApplicationServlet extends HttpServlet {
    private IApplicationService applicationService;
    private final String[] listcolumn= {"STT","Ma benh an", "Ma benh nhan","Ten benh nhan","Ngay nhap vien","Ngay ra vien","Ly do nhap vien","Action"};

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
        String id=request.getParameter("id");
        applicationService.deleteObject(id);
        response.sendRedirect("/application?m=1");
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
        request.setAttribute("listColumn",listcolumn);
        request.setAttribute("objectList", objectList);
        request.setAttribute("peopleList", peopleList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/application/list.jsp");
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
                try {
                    createObject(request,response);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateObject(request,response);
                } catch (SQLException | ParseException e) {
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

    private void createObject(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
        String id_object=request.getParameter("id_object");
        String id_patience=request.getParameter("id_patience");
        String name_patience=request.getParameter("name_patience");
        String datein=request.getParameter("date_in");
        Date date_in=new SimpleDateFormat("yyyy-mm-dd").parse(datein);
        String dateout=request.getParameter("date_out");
        Date date_out=new SimpleDateFormat("yyyy-mm-dd").parse(dateout);
        String reason=request.getParameter("reason");
        Object object=new Object(id_object,id_patience,name_patience,date_in,date_out,reason);
        applicationService.insertObject(object);
        response.sendRedirect("/application?m=3");
    }

    private void updateObject(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ParseException {
        String id_object=request.getParameter("id_object");
        String id_patience=request.getParameter("id_patience");
        String name_patience=request.getParameter("name_patience");
        String datein=request.getParameter("date_in");
        Date date_in=new SimpleDateFormat("yyyy-mm-dd").parse(datein);
        String dateout=request.getParameter("date_out");
        Date date_out=new SimpleDateFormat("yyyy-mm-dd").parse(dateout);
        String reason=request.getParameter("reason");
        Object object=new Object(id_object,id_patience,name_patience,date_in,date_out,reason);
        applicationService.updateObject(object);
        response.sendRedirect("/application?m=2");

    }
}
