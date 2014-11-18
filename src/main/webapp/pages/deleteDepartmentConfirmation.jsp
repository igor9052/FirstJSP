<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../WEB-INF/jspf/header.jsp" %>

<section id="content">
  <h3><span class="red_warning">Are you sure you want to delete the
        <%=request.getParameter("name") %>?</span></h3>

  <form class="form_inline" action="DepartmentAction" method="post">
    <input type="hidden" name="id" value="${param.id}">
    <input type="hidden" name="name" value="${param.name}">
    <input type="hidden" name="action" value="delete"/>
    <input type="submit" value="Delete"/>
  </form>
  <a href="listDepartment.jsp"><input type="button" value="Cancel"/></a>
</section>
<!-- content section end -->

<%@include file="../WEB-INF/jspf/footer.jsp" %>