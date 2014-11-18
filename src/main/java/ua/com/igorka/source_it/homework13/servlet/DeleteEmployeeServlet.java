package ua.com.igorka.source_it.homework13.servlet;

import ua.com.igorka.source_it.homework13.dao.EmployeeDAO;
import ua.com.igorka.source_it.homework13.dao.impl.EmployeeDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by igor on 15.11.14
 * Project name: FirstJSP
 */
@WebServlet(name = "DeleteEmployeeServlet", urlPatterns = {"/pages/DeleteEmployee"})
public class DeleteEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();

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


    }
}
