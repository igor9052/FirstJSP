<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/jspf/header.jsp" %>

<section id="content">

    <form action="EmployeeAction" method="post">
        <p>
            Name: <input type="text" name="name" value=""/>
        </p>

        <p>
            Age: <input type="text" name="age" value=""/>
        </p>

        <p>
            Email: <input type="text" name="email" value=""/>
        </p>

        <p>
            Department: <input type="text" name="departmentId" value=""/>
        </p>
        <input type="submit" value="Save"/>
        <input type="hidden" name="action" value="create"/>
        <a href="listEmployee.jsp"><input type="button" value="Cancel"/></a>
    </form>

</section>
<!-- content section end -->

<%@include file="../WEB-INF/jspf/footer.jsp" %>