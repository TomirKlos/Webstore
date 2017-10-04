<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="generic-container">
    <%@include file="authheader.jsp" %>

    <div class="alert alert-success lead">
        ${success}
    </div>

    <span class="well floatRight">
            Powrót do <a href="<c:url value='/list' />">Lista użytkowników</a>
        </span>
</div>
