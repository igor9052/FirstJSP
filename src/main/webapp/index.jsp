<html>
<head>
    <title>it-source</title>
    <link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
<div id="container">
    <header>
        <h1><span class="blue-text">IT Source</span> Homework 13</h1>
        <h2><span class="white-text">Servlet+JSP</span> and <span class="white-text">JSTL+EL</span></h2>
    </header>

    <section id="content">
        <form name="user" action="pages/listEmployee.jsp" method="post">
            <p>Please, enter your name and password:</p>
            <input type="text" name="username" id="username"/>
            <br/>
            <br/>
            <input type="password" name="password" id="password"/>
            <br/>
            <br/>
            <input type="submit" value="Sign in"/>
        </form>
    </section>
    <!-- content section end -->
<%@include file="WEB-INF/jspf/footer.jsp" %>

