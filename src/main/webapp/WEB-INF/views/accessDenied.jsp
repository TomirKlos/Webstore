<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="generic-container">
    <div class="authbar">
        <span>Witaj <strong>${loggedinuser}</strong>, Nie masz uprawnień do przeglądania tej strony.</span> <span class="floatRight"><a href="<c:url value="/logout" />">Wyloguj</a></span>
    </div>
</div>
