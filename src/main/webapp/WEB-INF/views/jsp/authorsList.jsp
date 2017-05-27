<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Authors List</title>
        <link href="<c:url value='/resources/static/css/bootstrap.css'/>" rel="stylesheet" />
        <link href="<c:url value='/resources/static/css/app.css'/>" rel="stylesheet" />
    </head>
    <body>
        <div class="generic-container">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading"><span class="lead">List of Author </span></div>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>PenName</th>
                        <th>Rating</th>
                        <th>UserName</th>
                        <th>Description</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${authors}" var="author">
                        <tr>
                            <td>${author.id}</td>
                            <td>${author.name}</td>
                            <td>${author.surname}</td>
                            <td>${author.penName}</td>
                            <td>${author.rating}</td>
                            <td>${author.user.name}</td>
                            <td>${author.description}</td>
                            <td>
                                <a href="<c:url value='/edit-author-${author.id}'/>" class="btn btn-success custom-width">edit</a>
                            </td>
                            <td>
                                <a href="<c:url value='/delete-author-${author.id}'/>" class="btn btn-danger custom-width">delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="well">
                <a href="<c:url value='/addAuthor/'/>">Add New Author</a>
            </div>
        </div>
     </body>
 </html>