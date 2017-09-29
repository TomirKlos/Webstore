<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="//ressio.github.io/lazy-load-xt/dist/jquery.lazyloadxt.js"></script>
<script src="//raw.githubusercontent.com/ressio/lazy-load-xt/master/dist/jquery.lazyloadxt.js"></script>
<link rel="stylesheet" href="//ressio.github.io/lazy-load-xt/dist/jquery.lazyloadxt.fadein.css">
<div class="row">
    <c:forEach items="${products}" var="product">
        <div class="col-sm-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">${product.name}</h3>
                </div>
                <div class="panel-body">
                    <c:choose>
                        <c:when test="${empty product.base64Image}">
                        </c:when>
                        <c:otherwise>
                            <img class="img-responsive" id="profileImage" data-src="data:image/jpg;base64,${product.base64Image}" style = "width:100%"/>
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="panel-footer">
                    <p>${product.description}</p>
                    <p>${product.unitPrice} PLN</p>
                    <p>Liczba sztuk w magazynie:${product.unitsInStock}</p>

                        <a href=" <spring:url value="/products/product?id=${product.productId}" />" class="btn btn-primary">
                            <span class="glyphicon-info-sign glyphicon"/></span> Szczegóły
                        </a>

                </div>
            </div>
        </div>
    </c:forEach>
</div><br><br>



