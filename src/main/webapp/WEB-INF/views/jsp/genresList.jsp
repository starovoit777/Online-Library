    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>

        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Genre List</title>
        <link href="<c:url value='/resources/static/css/bootstrap.css'/>" rel="stylesheet"></link>
        <link href="<c:url value='/resources/static/css/app.css'/>" rel="stylesheet"></link>
        </head>

        <body>
        <div class="generic-container">
        <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Genre </span></div>
        <table class="table table-hover">
        <thead>
        <tr>
        <th>Id</th>
        <th>Name</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${genres}" var="genre">
            <tr>
            <td>${genre.id}</td>
            <td>${genre.name}</td>

            <td><a href="<c:url value='/edit-genre-${genre.id}'/>" class="btn btn-success custom-width">edit</a></td>
            <td><a href="<c:url value='/delete-genre-${genre.id}'/>" class="btn btn-danger custom-width">delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
        </table>
        </div>
        <div class="well">
        <a href="<c:url value='/newgenre'/>">Add New genre</a>
        </div>
        </div>
        </body>
        </html>