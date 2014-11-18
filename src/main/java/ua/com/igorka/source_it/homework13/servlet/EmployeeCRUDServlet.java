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
                    Employee newEmployee = new Employee();
                    newEmployee.setName(request.getParameter("name"));
                    newEmployee.setAge(Integer.parseInt(request.getParameter("age")));
                    newEmployee.setEmail(request.getParameter("email"));
                    newEmployee.setDepartmentId(Long.parseLong(request.getParameter("departmentId")));

                    employeeDAO.insert(newEmployee);

                    request.setAttribute("message", "Employee " + request.getParameter("name") + " was successfully created.");
                    request.setAttribute("action", "Creating...");

                    request.getRequestDispatcher("message.jsp").forward(request, response);

                } catch (SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("message", "ERROR. Employee " + request.getParameter("name") + " was NOT created.");
                    request.setAttribute("action", "Creating...");
                    request.setAttribute("e", e.getMessage());
                    request.getRequestDispatcher("message.jsp").forward(request, response);
                }
                break;
            case "update":
                try {
                    Employee newEmployee = new Employee();
                    newEmployee.setId(Long.parseLong(request.getParameter("id")));
                    newEmployee.setName(request.getParameter("name"));
                    newEmployee.setAge(Integer.parseInt(request.getParameter("age")));
                    newEmployee.setEmail(request.getParameter("email"));
                    newEmployee.setDepartmentId(Long.parseLong(request.getParameter("departmentId")));

                    employeeDAO.update(newEmployee);

                    request.setAttribute("message", "Employee " + request.getParameter("name") + " was successfully updated.");

                } catch (SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("message", "ERROR. Employee " + request.getParameter("name") + " was NOT created.");
                    request.setAttribute("e", e.getMessage());
                }
                finally {
                    request.setAttribute("action", "Updating...");
                    request.getRequestDispatcher("message.jsp").forward(request, response);
                }
                break;
            case "delete":
                try {
                    employeeDAO.deleteById(Long.parseLong(request.getParameter("id")));
                    request.setAttribute("message", "Employee " + request.getParameter("name") + " was successfully deleted.");
                    request.setAttribute("action", "Deleting...");
                    request.getRequestDispatcher("message.jsp").forward(request, response);

                } catch (SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("message", "Employee " + request.getParameter("name") + " was NOT deleted.");
                    request.setAttribute("action", "Deleting...");
                    request.setAttribute("e", e.getMessage());
                    request.getRequestDispatcher("message.jsp").forward(request, response);

                }
                break;
            default: {
                request.setAttribute("message", "Sorry, this action is not supported.");
                request.setAttribute("action", "Unsupported action...");
                request.getRequestDispatcher("message.jsp").forward(request, response);
            }
        }


    }
}
