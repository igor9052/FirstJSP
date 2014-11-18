<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../WEB-INF/jspf/header.jsp" %>

<section id="content">

    <h3><c:out value="${requestScope.action}"/></h3>

    <c:out value="${requestScope.message}"/>

    <c:out value="${requestScope.e}"/>

    <p>
        <a href="${requestScope.page}"><input type="button" value="Back"/></a>
    </p>

</section>

<%@ include file="../WEB-INF/jspf/footer.jsp" %>