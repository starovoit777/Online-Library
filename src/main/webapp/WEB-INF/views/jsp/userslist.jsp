    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>

        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Users List</title>
        <link href="<c:url value='/resources/static/css/bootstrap.css'/>" rel="stylesheet"></link>
        <link href="<c:url value='/resources/static/css/app.css'/>" rel="stylesheet"></link>
        </head>

        <body>
        <div class="generic-container">
        <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Users </span></div>
        <table class="table table-hover">
        <thead>
        <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>EMail</th>
        <th>Login</th>
        <th>Password</th>
        <th>UrlPicture</th>
        <th>UserRole</th>
        <th width="100"></th>
        <th width="100"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.eMail}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.urlPicture}</td>
            <td>${user.userRole}</td>

            <td><a href="<c:url value='/edit-user-${user.id}'/>" class="btn btn-success custom-width">edit</a></td>
            <td><a href="<c:url value='/delete-user-${user.id}'/>" class="btn btn-danger custom-width">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
        </table>
        </div>
        <div class="well">
        <a href="<c:url value='/newuser'/>">Add New User</a>
        </div>
        </div>
        </body>
        </html>