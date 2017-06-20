    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>

        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login</title>
        <link href="<c:url value='/resources/static/css/bootstrap.css'/>" rel="stylesheet"></link>
        <link href="<c:url value='/resources/static/css/app.css'/>" rel="stylesheet"></link>
        </head>

        <body>
        <div class="generic-container">
        <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Users </span></div>
        <table class="table table-hover">

        <tbody>
        <form:form action="userCheck" method="post">
            <td>
            <br>
            Enter User Name:<input type="text" name="name"> <br/>
             <br>
            Enter Password :<input type="password" name="pwd"/><br/>
            <br>
            <input type="submit">

        </form:form>
        </tbody>
        </table>
        </div>
        <div class="well">
        <a href="<c:url value='/newuser'/>">Register</a>
        <td>
        <br>
        <a href="<c:url value='/'/>">Cancel</a>
        </div>

        </div>
        </body>
        </html>