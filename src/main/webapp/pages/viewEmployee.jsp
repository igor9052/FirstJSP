<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="../WEB-INF/jspf/header.jsp" %>

<section id="content">
    <p>
        <input type="text" name="id" value="${param.id}" readonly/>
    </p>

    <p>
        <input type="text" name="name" value="${param.name}" readonly/>
    </p>

    <p>
        <input type="text" name="age" value="${param.age}" readonly/>
    </p>

    <p>
        <input type="text" name="email" value="${param.email}" readonly/>
    </p>

    <p>
        <input type="text" name="departmentId" value="${param.departmentId}" readonly/>
    </p>
    </div>

</section>
<!-- content section end -->

<%@include file="../WEB-INF/jspf/footer.jsp" %>
