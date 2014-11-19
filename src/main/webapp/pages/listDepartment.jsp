<%@ page import="ua.com.igorka.source_it.homework13.entity.Department" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/jspf/header.jsp" %>

<jsp:useBean id="departmentDAO" class="ua.com.igorka.source_it.homework13.dao.impl.DepartmentDAOImpl" scope="request"/>
<jsp:useBean id="departmentList" class="java.util.List<Depa>" scope="request"/>
<section id="content">

    <table border="2" width="600">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>ACTIONS</th>
        </tr>
        <%
            List<Department> listDepartment = departmentDAO.selectAll();
            for (int i = 0; i < listDepartment.size(); i++) { %>
        <tr>
            <td><%=listDepartment.get(i).getId()%>
            </td>
            <td><%=listDepartment.get(i).getName()%>
            </td>
            <td>
                <form action="editDepartment.jsp" method="post">
                    <input name="id" value="<%= listDepartment.get(i).getId()%>" type="hidden"/>
                    <input name="name" value="<%= listDepartment.get(i).getName()%>" type="hidden"/>
                    <input type="submit" value="Edit">
                </form>
                <form action="deleteDepartmentConfirmation.jsp" method="post">
                    <input name="id" value="<%= listDepartment.get(i).getId()%>" type="hidden"/>
                    <input name="name" value="<%= listDepartment.get(i).getName()%>" type="hidden"/>
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
        <% } %>
    </table>
    <div>
        <br/>

        <form class="form_inline" action="createDepartment.jsp" method="post">
            <input type="submit" value="Create new department"/>
        </form>
        <a href="../index.jsp"><input type="button" value="Back to start page"/></a>
    </div>

</section>
<!-- content section end -->

<%@include file="../WEB-INF/jspf/footer.jsp" %>