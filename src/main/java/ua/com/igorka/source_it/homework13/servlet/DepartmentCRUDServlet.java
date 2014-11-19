package ua.com.igorka.source_it.homework13.servlet;

import ua.com.igorka.source_it.homework13.dao.DepartmentDAO;
import ua.com.igorka.source_it.homework13.dao.impl.DepartmentDAOImpl;
import ua.com.igorka.source_it.homework13.entity.Department;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by igor on 18.11.14
 * Project name: FirstJSP
 */
@WebServlet(name = "DepartmentCRUDServlet", urlPatterns = {"/pages/DepartmentAction"})
public class DepartmentCRUDServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDAO departmentDAO = new DepartmentDAOImpl();

        switch (request.getParameter("action").toLowerCase()) {
            case "create":
                try {
                    departmentDAO.insert(requestParamsToDepartment(request, response));
                    request.setAttribute("message", "Department " + request.getParameter("name") + " was successfully created.");
                } catch (SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("message", "ERROR. Department " + request.getParameter("name") + " was NOT created.");
                    request.setAttribute("e", e.getMessage());
                } finally {
                    request.setAttribute("action", "Creating...");
                    forward(request, response);
                }
                break;
            case "update":
                try {
                    departmentDAO.update(requestParamsToDepartment(request, response));
                    request.setAttribute("message", "Department " + request.getParameter("name") + " was successfully updated.");
                } catch (SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("message", "ERROR. Department " + request.getParameter("name") + " was NOT created.");
                    request.setAttribute("e", e.getMessage());
                } finally {
                    request.setAttribute("action", "Updating...");
                    forward(request, response);
                }
                break;
            case "delete":
                try {
                    departmentDAO.deleteById(Long.parseLong(request.getParameter("id")));
                    request.setAttribute("message", "Department " + request.getParameter("name") + " was successfully deleted.");
                } catch (SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("message", "Department " + request.getParameter("name") + " was NOT deleted.");
                    request.setAttribute("e", e.getMessage());
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    request.setAttribute("message", "ERROR");
                    request.setAttribute("e", e.getMessage());
                    forward(request, response);
                }
                finally {
                    request.setAttribute("action", "Deleting...");
                    forward(request, response);
                }
                break;
            default: {
                request.setAttribute("page", "/index.jsp");
                request.setAttribute("message", "Sorry, this action is not supported.");
                request.setAttribute("action", "Unsupported action...");
                request.getRequestDispatcher("message.jsp").forward(request, response);
            }
        }
    }

    private Department requestParamsToDepartment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Department newDepartment = new Department();
        try {
            if ("update".equals(request.getParameter("action").toLowerCase())) {
                newDepartment.setId(Long.parseLong(request.getParameter("id")));
            }
            newDepartment.setName(request.getParameter("name"));
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
            request.setAttribute("message", "ERROR");
            request.setAttribute("e", e.getMessage());
            forward(request, response);
        }
        return newDepartment;
    }

    private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "listDepartment.jsp");
        request.getRequestDispatcher("message.jsp").forward(request, response);
    }
}
