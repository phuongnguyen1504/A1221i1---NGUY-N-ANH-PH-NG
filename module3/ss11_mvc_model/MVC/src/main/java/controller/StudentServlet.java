package controller;

import model.Student;
import service.IStudentService;
import service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"/student", ""})
public class StudentServlet extends HttpServlet {
    private IStudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreatePage(request, response);
                break;
            case "edit":
                break;
            case "delete":
                deleteStudent(request, response);
                break;
            default:
                showStudentList(request, response);
        }
    }

    private void showCreatePage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/student/create.jsp");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        studentService.remove(id);
        response.sendRedirect("/student");
//        showStudentList(request, response);
    }

    private void showStudentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentList", studentService.findAll()); //đẩy data vào jsp
        request.getRequestDispatcher("/student/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createStudent(request, response);
                break;
            case "edit":
                break;
            default:
                showStudentList(request, response);
        }
    }

    private void createStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String studentName = request.getParameter("studentName");
        int studentGender = Integer.parseInt(request.getParameter("studentGender"));
        int studentPoint = Integer.parseInt(request.getParameter("studentPoint"));
        String studentImage = request.getParameter("studentImage");

        Student student = new Student(studentId, studentName, studentGender, studentPoint, studentImage);

        studentService.save(student);

        response.sendRedirect("/student");

    }
}
