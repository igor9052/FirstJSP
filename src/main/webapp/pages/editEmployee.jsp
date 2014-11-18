<%@ page import="ua.com.igorka.source_it.homework13.dao.EmployeeDAO" %>
<%@ page import="ua.com.igorka.source_it.homework13.dao.impl.EmployeeDAOImpl" %>
<%@ page import="ua.com.igorka.source_it.homework13.entity.Employee" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/jspf/header.jsp" %>

<section id="content">
    <form action="EmployeeAction" method="post">
        <p>
            <label for="name">Name: </label><input type="text" id="name" name="name" value="${param.name}"/>
        </p>

        <p>
            <label for="age">Age: </label><input type="text" id="age" name="age" value="${param.age}"/>
        </p>

        <p>
            <label for="email">Email: </label><input type="text" id="email" name="email" value="${param.email}"/>
        </p>

        <p>
            <label for="departmentId">Department: </label><input type="text" id="departmentId" name="departmentId" value="${param.departmentId}" />
        </p>
        <input type="hidden" name="id" value="${param.id}" readonly/>
        <input type="hidden" name="action" value="update"/>
        <input type="submit" value="Save"/>
        <a href="listEmployee.jsp"><input type="button" value="Cancel"/></a>
    </form>
</section>
<!-- content section end -->

<%@include file="../WEB-INF/jspf/footer.jsp" %>
