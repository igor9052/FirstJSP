<%@ page import="ua.com.igorka.source_it.homework13.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="../WEB-INF/jspf/header.jsp" %>

<jsp:useBean id="employeeDAO" class="ua.com.igorka.source_it.homework13.dao.impl.EmployeeDAOImpl"
             scope="application"/>

<section id="content">
    <table border="2" width="900">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>AGE</th>
            <th>EMAIL</th>
            <th>DEPARTMENT ID</th>
            <th>ACTIONS</th>
        </tr>
        <%
            List<Employee> listEmployees = employeeDAO.selectAll();
            for (int i = 0; i < listEmployees.size(); i++) { %>
        <tr>
            <td><%=listEmployees.get(i).getId()%>
            </td>
            <td><%=listEmployees.get(i).getName()%>
            </td>
            <td><%=listEmployees.get(i).getAge()%>
            </td>
            <td><%=listEmployees.get(i).getEmail()%>
            </td>
            <td><%=listEmployees.get(i).getDepartmentId()%>
            </td>
            <td>
                <form action="editEmployee.jsp" method="post">
                    <input name="id" value="<%= listEmployees.get(i).getId()%>" type="hidden"/>
                    <input name="name" value="<%= listEmployees.get(i).getName()%>" type="hidden"/>
                    <input name="age" value="<%= listEmployees.get(i).getAge()%>" type="hidden"/>
                    <input name="email" value="<%= listEmployees.get(i).getEmail()%>" type="hidden"/>
                    <input name="departmentId" value="<%= listEmployees.get(i).getDepartmentId()%>" type="hidden"/>
                    <input type="submit" value="Edit">
                </form>
                <form action="deleteEmployeeConfirmation.jsp" method="post">
                    <input name="id" value="<%= listEmployees.get(i).getId()%>" type="hidden"/>
                    <input name="name" value="<%= listEmployees.get(i).getName()%>" type="hidden"/>
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
        <% } %>
    </table>
    <div>
        <br/>
        <form class="form_inline" action="createEmployee.jsp" method="post">
            <input type="submit" value="Create new employee"/>
        </form>
        <a href="listEmployee.jsp"><input type="button" value="Back to list of Employees"/></a>
    </div>
</section>
<!-- content section end -->

<%@include file="../WEB-INF/jspf/footer.jsp" %>
