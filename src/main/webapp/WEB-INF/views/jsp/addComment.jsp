    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <html>

        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Add comment Form</title>
        <link href="<c:url value='/resources/static/css/bootstrap.css'/>" rel="stylesheet"></link>
        <link href="<c:url value='/resources/static/css/app.css'/>" rel="stylesheet"></link>
        </head>

        <body>

        <div class="generic-container">
        <div class="well lead">comment form</div>
        <form:form method="POST" modelAttribute="comment" class="form-horizontal">
            <form:input type="hidden" path="id" id="id"/>

            <div class="row">
            <div class="form-group col-md-12">
            <label class="col-md-3 control-lable" for="Comment">Comment</label>
            <div class="col-md-7">
            <form:input type="text" path="Comment" id="Comment" class="form-control input-sm"/>
            <div class="has-error">
            <form:errors path="Comment" class="help-inline"/>
            </div>
            </div>
            </div>
            </div>


            <div class="row">
            <div class="form-actions floatRight">
            <c:choose>
                <c:when test="${edit}">
                    <input type="submit" value="Update" class="btn btn-primary btn-sm"/> or <a href="<c:url
                        value='/comments'/>">Cancel</a>
                </c:when>
                <c:otherwise>
                    <input type="submit" value="Register" class="btn btn-primary btn-sm"/> or <a href="<c:url
                        value='/comments'/>">Cancel</a>
                </c:otherwise>
            </c:choose>
            </div>
            </div>
        </form:form>
        </div>
        </body>
        </html>