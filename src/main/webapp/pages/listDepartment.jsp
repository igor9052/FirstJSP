<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/jspf/header.jsp" %>

<%--<c:if test="${empty requestScope.departmentList}">--%>
    <%--<c:redirect url="/pages/ListDepartment" />--%>
<%--</c:if>--%>

<section id="content">
    <table border="2" width="600">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>ACTIONS</th>
        </tr>
        <c:forEach items="${requestScope.departmentList}" var="department">
            <tr>
                <td><c:out value="${department.id}"/></td>
                <td><c:out value="${department.name}"/></td>
                <td>
                    <form action="editDepartment.jsp" method="post">
                        <input name="id" value="${department.id}" type="hidden"/>
                        <input name="name" value="${department.name}" type="hidden"/>
                        <input type="submit" value="Edit">
                    </form>
                    <form action="deleteDepartmentConfirmation.jsp" method="post">
                        <input name="id" value="${department.id}" type="hidden"/>
                        <input name="name" value="${department.name}" type="hidden"/>
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
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