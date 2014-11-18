<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/jspf/header.jsp" %>

<section id="content">
  <form action="DepartmentAction" method="post">
    <p>
      <label for="name">Name: </label><input type="text" id="name" name="name" value="${param.name}"/>
    </p>
    <input type="hidden" name="id" value="${param.id}" readonly/>
    <input type="hidden" name="action" value="update"/>
    <input type="submit" value="Save"/>
    <a href="listDepartment.jsp"><input type="button" value="Cancel"/></a>
  </form>

</section>
<!-- content section end -->

<%@include file="../WEB-INF/jspf/footer.jsp" %>