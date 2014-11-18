<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/jspf/header.jsp" %>

<section id="content">

    <form action="EmployeeAction" method="post">
        <p>
            <label for="name">Name: </label><input type="text" id="name" name="name" value=""/>
        </p>

        <p>
            <label for="age">Age: </label><input type="text" id="age" name="age" value=""/>
        </p>

        <p>
            <label for="email"> Email: </label><input type="text" id="email" name="email" value=""/>
        </p>

        <p>
            <label for="departmentId">Department: </label><input type="text" id="departmentId" name="departmentId" value=""/>
        </p>
        <input type="submit" value="Save"/>
        <input type="hidden" name="action" value="create"/>
        <a href="listEmployee.jsp"><input type="button" value="Cancel"/></a>
    </form>

</section>
<!-- content section end -->

<%@include file="../WEB-INF/jspf/footer.jsp" %>