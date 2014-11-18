<%@ page import="ua.com.igorka.source_it.homework13.dao.EmployeeDAO" %>
<%@ page import="ua.com.igorka.source_it.homework13.dao.impl.EmployeeDAOImpl" %>
<%@ page import="ua.com.igorka.source_it.homework13.entity.Employee" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/jspf/header.jsp" %>

<section id="content">
    <form action="EmployeeAction" method="post">
        <p>
            Name: <input type="text" name="name" value="${param.name}"/>
        </p>

        <p>
            Age: <input type="text" name="age" value="${param.age}"/>
        </p>

        <p>
            Email: <input type="text" name="email" value="${param.email}"/>
        </p>

        <p>
            Department: <input type="text" name="departmentId" value="${param.departmentId}" readonly/>
        </p>
        <input type="hidden" name="id" value="${param.id}" readonly/>
        <input type="hidden" name="action" value="update"/>
        <input type="submit" value="Save"/>
        <a href="listEmployee.jsp"><input type="button" value="Cancel"/></a>
    </form>
</section>
<!-- content section end -->

<%@include file="../WEB-INF/jspf/footer.jsp" %>
