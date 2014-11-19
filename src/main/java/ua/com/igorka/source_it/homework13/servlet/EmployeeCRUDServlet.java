package ua.com.igorka.source_it.homework13.servlet;

import ua.com.igorka.source_it.homework13.dao.EmployeeDAO;
import ua.com.igorka.source_it.homework13.dao.impl.EmployeeDAOImpl;
import ua.com.igorka.source_it.homework13.entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by igor on 18.11.14
 * Project name: FirstJSP
 */
@WebServlet(name = "EmployeeCRUDServlet", urlPatterns = {"/pages/EmployeeAction"})
public class EmployeeCRUDServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    /*
    * Attribute "action" is an enum of type CRUDAction.
    *
    * */
    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();


        switch (request.getParameter("action").toLowerCase()) {
            case "create":
                try {
                    employeeDAO.insert(requestParamsToEmployee(request, response));
                    request.setAttribute("message", "Employee " + request.getParameter("name") + " was successfully created.");

                } catch (SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("message", "ERROR. Employee " + request.getParameter("name") + " was NOT created.");
                    request.setAttribute("e", e.getMessage());

                }
                finally {
                    request.setAttribute("action", "Creating...");
                    forward(request, response);
                }

                break;
            case "update":
                try {
                    employeeDAO.update(requestParamsToEmployee(request, response));
                    request.setAttribute("message", "Employee " + request.getParameter("name") + " was successfully updated.");
                } catch (SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("message", "ERROR. Employee " + request.getParameter("name") + " was NOT created.");
                    request.setAttribute("e", e.getMessage());
                }
                finally {
                    request.setAttribute("action", "Updating...");
                    forward(request, response);
                }
                break;
            case "delete":
                try {
                    employeeDAO.deleteById(Long.parseLong(request.getParameter("id")));
                    request.setAttribute("message", "Employee " + request.getParameter("name") + " was successfully deleted.");
                } catch (SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("message", "Employee " + request.getParameter("name") + " was NOT deleted.");
                    request.setAttribute("e", e.getMessage());
                }
                finally {
                    request.setAttribute("action", "Deleting...");
                    forward(request, response);
                }

                break;
            default: {
                request.setAttribute("message", "Sorry, this action is not supported.");
                request.setAttribute("action", "Unsupported action...");
                request.getRequestDispatcher("message.jsp").forward(request, response);
            }
        }
    }

    private Employee requestParamsToEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Employee newEmployee = new Employee();
        try {
            if ("update".equals(request.getParameter("action").toLowerCase())) {
                if (StringUtils.isNumeric(request.getParameter("id"))) {
                    newEmployee.setDepartmentId(Long.parseLong(request.getParameter("id")));
                }
                else {
                    request.setAttribute("message", "ID must be a number.");
                    forward(request, response);
                }
            }
            newEmployee.setName(request.getParameter("name"));
            if (StringUtils.isNumeric(request.getParameter("age"))) {
                newEmployee.setAge(Integer.parseInt(request.getParameter("age")));
            }
            else {
                request.setAttribute("message", "Age must be a number.");
                forward(request, response);
            }
            newEmployee.setEmail(request.getParameter("email"));
            if (StringUtils.isNumeric(request.getParameter("departmentId"))) {
                newEmployee.setDepartmentId(Long.parseLong(request.getParameter("departmentId")));
            }
            else {
                request.setAttribute("message", "Department ID must be a number.");
                forward(request, response);
            }
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
            request.setAttribute("message", "ERROR. Employee " + request.getParameter("name") + " was NOT created.");
            request.setAttribute("e", e.getMessage());
            forward(request, response);
        }
        return newEmployee;
    }

    private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("page", "listEmployee.jsp");
        request.getRequestDispatcher("message.jsp").forward(request, response);
    }
}
