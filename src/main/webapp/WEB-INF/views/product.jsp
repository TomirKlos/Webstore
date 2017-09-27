<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/resource/js/controllers.js"></script>
    <title>Produkt</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Produkt</h1>
        </div>
    </div>
</section>
<section class="container" ng-app="cartApp">
    <div class="row">
        <div class="col-md-5">

            <c:choose>
                <c:when test="${empty product.base64Image}">
                </c:when>
                <c:otherwise>
                    <img id="profileImage" src="data:image/jpg;base64,${product.base64Image}" alt="image" style = "width:100%"/>
                </c:otherwise>
            </c:choose>

        </div>
        <div class="col-md-5">
            <h3>${product.name}</h3>
            <p>${product.description}</p>
            <p>
                <strong>Kod produktu: </strong><span class="label-warning">${product.productId}</span>
            </p>
            <p>
                <strong>Producent</strong>: ${product.manufacturer}
            </p>
            <p>
                <strong>Kategoria</strong>: ${product.category}
            </p>
            <p>
                <strong>Dostępna liczba sztuk</strong>:${product.unitsInStock}
            </p>
            <h4>${product.unitPrice}PLN</h4>
            <p>


            <p ng-controller="cartCtrl">
                <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')">
                    <span class="glyphicon-shopping-cart glyphicon"></span> Zamów teraz </a>


                <a href="<spring:url value="/products" />" class="btn btn-default">
                    <span class="glyphicon-hand-left glyphicon"></span> Wstecz
                </a>
                <a href="<spring:url value="/cart" />" class="btn btn-default">
                    <span class="glyphicon-hand-right glyphicon"></span> Koszyk
                </a>
            </p>
        </div>
    </div>
</section>
</body>
</html>
