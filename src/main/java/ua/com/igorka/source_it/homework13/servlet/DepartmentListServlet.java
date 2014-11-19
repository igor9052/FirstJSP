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
import java.util.List;

/**
 * Created by igor on 19.11.14
 * Project name: FirstJSP
 */
@WebServlet(name = "DepartmentListServlet", urlPatterns = {"/pages/ListDepartment"})
public class DepartmentListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DepartmentDAO departmentDAO = new DepartmentDAOImpl();

        try {
            List<Department> departmentList = departmentDAO.selectAll();
            request.setAttribute("departmentList", departmentList);
            request.getRequestDispatcher("listDepartment.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "ERROR");
            request.setAttribute("e", e.getMessage());
            request.setAttribute("action", "Getting department list...");
            request.setAttribute("page", "../index.jsp");
            request.getRequestDispatcher("message.jsp").forward(request, response);
        }
    }
}
