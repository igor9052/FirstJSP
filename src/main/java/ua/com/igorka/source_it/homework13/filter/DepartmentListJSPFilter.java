package ua.com.igorka.source_it.homework13.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by igor on 19.11.14
 * Project name: FirstJSP
 */
@WebFilter(filterName = "DepartmentListJSPFilter", urlPatterns = "/pages/listDepartment.jsp")
public class DepartmentListJSPFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (req.getAttribute("departmentList") == null) {
            ((HttpServletResponse)resp).sendRedirect("ListDepartment");
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
