<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<section>
    <div class="container">
        <p>
            <a href="<spring:url value="/products" />" class="btn btn-primary">
                <span class="glyphicon-hand-left glyphicon"></span>
                produkty
            </a>
        </p>
    </div>
</section>
